package net.cserny.poc.guicespark;

import java.time.LocalDateTime;

public class HelloMessage {

    private final String message;
    private final LocalDateTime dateTime;

    public HelloMessage(String message, LocalDateTime dateTime) {
        this.message = message;
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "HelloMessage{" +
                "message='" + message + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
