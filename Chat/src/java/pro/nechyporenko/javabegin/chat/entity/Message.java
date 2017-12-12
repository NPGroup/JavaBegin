package pro.nechyporenko.javabegin.chat.entity;

public class Message {

    private int id;
    private String text;

    //public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) { this.text = text; }

    public Message() {
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
