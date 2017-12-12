package java.pro.nechyporenko.javabegin.chat.dao;

import java.pro.nechyporenko.javabegin.chat.entity.Message;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DaoMessage implements ChatDao {

        private static final String PASSWORD = "root";
        private static final String URL = "jdbc:postgresql://localhost:5432/javaBegin";
        private static final String USER = "postgres";
        private static final Logger logger = Logger.getLogger(ChatDao.class.getName());

        private String sqlInsert = "INSERT INTO messages (text) VALUES(?)";
        //private String sqlUpdate = "UPDATE messages SET text =? WHERE id_message=?";
        private String sqlRemove = "DELETE  FROM messages WHERE id_message=?";
        private String sqlGetByid = "SELECT r.id_message, r.id_refrence, c.text FROM \"references\" r INNER JOIN messages c ON r.id_refrence = c.id_message where c.id_message = ?";
        private String sqlGetAll = "SELECT r.id_message, r.id_refrence, c.text FROM \"references\" r INNER JOIN messages c ON r.id_refrence = c.id_message";


    @Override
    public void addMessage(Message message) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert)) {
            preparedStatement.setString(1, message.getText());
            preparedStatement.executeUpdate();
            logger.info("Message sent successfully. Message details: " + message);
        } catch (SQLException e) {
            logger.info("Connection have some errors");
        }
    }

    @Override
    public void removeMessage(int id) {
        Message message = new Message();
        message.setId(id);
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlRemove)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            logger.info("Message successfully removed. Message details: " + message);
        } catch (SQLException e) {
            logger.info("Connection have some errors");
        }
    }

    @Override
    public Message getMessage(int id) {
        Message message = new Message();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlGetByid)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                message.setId(resultSet.getInt(1));
                message.setText(resultSet.getString(2));
            }
            logger.info("Message successfully received. Message details: " + message);
        } catch (SQLException e) {
            logger.info("Connection have some errors");
        }
        return message;
    }

    @Override
    public List<Message> messagesList() {
        List<Message> messagesList = new ArrayList();
        Message message = new Message();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlGetAll);) {
            while (resultSet.next()) {
                message.setId(resultSet.getInt("id_message"));
                message.setText(resultSet.getString("text"));
                messagesList.add(message);
                System.out.println(message);
            }
            logger.info("All Messages successfully get. Messages details: " + messagesList);
        } catch (SQLException e) {
            logger.info("Connection have some errors");
        }
        return messagesList;
    }
}
