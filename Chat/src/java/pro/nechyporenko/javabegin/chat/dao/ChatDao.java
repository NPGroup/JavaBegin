package java.pro.nechyporenko.javabegin.chat.dao;

import java.pro.nechyporenko.javabegin.chat.entity.Message;

import java.util.List;

public interface ChatDao {

    void addMessage(Message message);

    void removeMessage(int id);

    Message getMessage(int id);

    List<Message> messagesList();
}
