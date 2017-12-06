package java.com.alex.zhurylo.dao;

import java.com.alex.zhurylo.entity.Chapters;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.sql.*;

public class ChapterDao implements Dao {
    public static final String PASSWORD = "root";
    public static final String URL = "jdbc:postgresql://localhost:5432/javaBegin";
    public static final String USER = "postgres";
    Connection connection;

    {
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static final Logger logger = Logger.getLogger(Dao.class.getName());
    String sqlInsert = "INSERT INTO chapters (name) VALUES(?)";
    String sqlUpdate = "UPDATE chapters SET name =? WHERE id_chapter=?";
    String sqlRemove = "DELETE  FROM chapters WHERE id_chapter=?";
    String sqlGetByid = "SELECT r.id_chapter, r.id_refrence, c.name FROM \"references\" r INNER JOIN chapters c ON r.id_refrence = c.id_chapter where r.id_chapter = ?";
    String sqlGetAll = "SELECT r.id_chapter, r.id_refrence, c.name FROM \"references\" r INNER JOIN chapters c ON r.id_refrence = c.id_chapter";

    public void addChapter(Chapters chapters) {

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert)) {
            preparedStatement.setString(1, chapters.getName());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("User successfully saved. User details: " + chapters);
    }

    public void updateChapter(Chapters chapters) {

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate)) {
            preparedStatement.setString(1, chapters.getName());
            preparedStatement.setInt(2, chapters.getId());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("User successfully update. User details: " + chapters);
    }

    public void removeChapter(int id) {

        Chapters chapters = new Chapters();
        chapters.setId(id);
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlRemove)) {
            preparedStatement.setInt(1, chapters.getId());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("User successfully remove. User details: " + chapters);
    }

    public Chapters getChapters(int id) {

        Chapters chapters = new Chapters();
        chapters.setId(id);

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlGetByid)) {
            preparedStatement.setInt(1, chapters.getId());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("User successfully get. User details: " + chapters);
        return chapters;
    }

    public List<Chapters> listChapters() {

        List<Chapters> chaptersList = new ArrayList();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlGetAll);) {

            Chapters chapters = new Chapters();
            while (resultSet.next()) {
                chapters.setId(resultSet.getInt("id_chapter"));
                chapters.setName(resultSet.getString("name"));
                chaptersList.add(chapters);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("All Users successfully get. User details: " + chaptersList);
        return chaptersList;
    }

}
