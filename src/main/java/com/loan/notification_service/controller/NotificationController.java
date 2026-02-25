package com.loan.notification_service.controller;

import com.loan.notification_service.dto.NotificationRequestDTO;
import com.loan.notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notification/")
@RequiredArgsConstructor
public class NotificationController {
    private  final NotificationService notificationService;

    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequestDTO request){
        notificationService.sendNotification(request);

        return ResponseEntity.ok("Notification sent successfully");
    }
}
