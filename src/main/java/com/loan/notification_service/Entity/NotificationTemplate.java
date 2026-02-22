package com.loan.notification_service.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="notification_template")
@Data
public class NotificationTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="event_code",nullable = false)
    private  String eventCode;

    @Column(nullable = false)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String body;


}
