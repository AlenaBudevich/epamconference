package by.budevich.conference.entity;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * Created by Asus on 15.01.2018.
 */
public class Message implements Serializable, Cloneable{
    private long messageId;
    private Timestamp messageTime;
    private String messageText;
    private String messageContent;
    private long sendId;
    private long receiveId;

    public Message (){}

    public Message(long messageId, Timestamp messageTime, String messageText, String messageContent,
                   long sendId, long receiveId) {
        this.messageId = messageId;
        this.messageTime = messageTime;
        this.messageText = messageText;
        this.messageContent = messageContent;
        this.sendId = sendId;
        this.receiveId = receiveId;
    }

    public Message (String messageText, long sendId, long receiveId){
        this.messageText = messageText;
        this.sendId = sendId;
        this.receiveId = receiveId;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public Timestamp getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Timestamp messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public long getSendId() {
        return sendId;
    }

    public void setSendId(long sendId) {
        this.sendId = sendId;
    }

    public long getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(long receiveId) {
        this.receiveId = receiveId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (messageId != message.messageId) return false;
        if (sendId != message.sendId) return false;
        if (receiveId != message.receiveId) return false;
        if (messageTime != null ? !messageTime.equals(message.messageTime) : message.messageTime != null) return false;
        if (messageText != null ? !messageText.equals(message.messageText) : message.messageText != null) return false;
        return messageContent != null ? messageContent.equals(message.messageContent) : message.messageContent == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (messageId ^ (messageId >>> 32));
        result = 31 * result + (messageTime != null ? messageTime.hashCode() : 0);
        result = 31 * result + (messageText != null ? messageText.hashCode() : 0);
        result = 31 * result + (messageContent != null ? messageContent.hashCode() : 0);
        result = 31 * result + (int) (sendId ^ (sendId >>> 32));
        result = 31 * result + (int) (receiveId ^ (receiveId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", messageTime=" + messageTime +
                ", messageText='" + messageText + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", sendId=" + sendId +
                ", receiveId=" + receiveId +
                '}';
    }
}
