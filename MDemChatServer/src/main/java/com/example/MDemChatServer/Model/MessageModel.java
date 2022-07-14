package com.example.MDemChatServer.Model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MessageModel {

//    private String message;
//    private String date;
//    private String resiver;
//    private String sender;
//    private StatusMessage statusMessage;
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public String getResiver() {
//        return resiver;
//    }
//
//    public void setResiver(String resiver) {
//        this.resiver = resiver;
//    }
//
//    public String getSender() {
//        return sender;
//    }
//
//    public void setSender(String sender) {
//        this.sender = sender;
//    }
//
//    public StatusMessage getStatusMessage() {
//        return statusMessage;
//    }
//
//    public void setStatusMessage(StatusMessage statusMessage) {
//        this.statusMessage = statusMessage;
//    }

private String content;
private String sender;
private MessageType type;

    public enum MessageType
{
    CHAT,LEAVE,JOIN;
}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}
