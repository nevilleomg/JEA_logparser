package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class LogEntity {
    private LocalDate date;
    private LocalTime time;
    private int thread;
    private String messageText;
    private MessageType messageType;
    private MessageStatus messageStatus;


    public LogEntity(
            LocalDate date,
            LocalTime time,
            int thread,
            String messageText
    ) {
        this.date = date;
        this.time = time;
        this.thread = thread;
        this.messageText = messageText;
        setMessageType(messageText);
        setMessageStatus(messageText);
    }

    private void setMessageType(String messageText) {
        String[] arr = messageText.split(" ");
        switch (arr[0]) {
            case "Operation" -> {
                this.messageType = MessageType.OPERATION_PROCESSING;
            }
            case "Authentication" -> {
                this.messageType = MessageType.AUTHENTICATION;
            }
            case "Authorization" -> {
                this.messageType = MessageType.AUTHORIZATION;
            }
            case "Balances" -> {
                this.messageType = MessageType.BALANCES_MODIFICATION;
            }
        }
    }

    private void setMessageStatus(String messageText) {
        if (messageText.contains("started")) {
            this.messageStatus = MessageStatus.STARTED;
        } else if (messageText.contains("finished")) {
            this.messageStatus = MessageStatus.FINISHED;
        } else if (messageText.contains("failed")) {
            this.messageStatus = MessageStatus.FAILED;
        }
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public MessageStatus getMessageStatus() {
        return messageStatus;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getThread() {
        return thread;
    }

    public void setThread(int thread) {
        this.thread = thread;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
