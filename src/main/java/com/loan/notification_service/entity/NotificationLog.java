package com.loan.notification_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="notification_log")
public class NotificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="event_code")
    private String eventCode;

    private  String recipient;

    private String channel;

    private String status;

    @Column(name="error_message", columnDefinition = "TEXT")
    private String errorMessage;

    @Column(name="created_at")
    private LocalDateTime createdAt= LocalDateTime.now();
}
