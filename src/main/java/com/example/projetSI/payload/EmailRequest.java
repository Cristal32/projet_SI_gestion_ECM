package com.example.projetSI.payload;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class EmailRequest {
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime scheduledDateTime;

    private String to;
    private String subject;
    private String body;

    public LocalDateTime getScheduledDateTime() {
        return scheduledDateTime;
    }
    public String getTo() {
        return to;
    }
    public String getSubject() {
        return subject;
    }
    public String getBody() {
        return body;
    }


    public void setScheduledDateTime(LocalDateTime scheduledDateTime) {
        this.scheduledDateTime = scheduledDateTime;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void setBody(String body) {
        this.body = body;
    }
}
