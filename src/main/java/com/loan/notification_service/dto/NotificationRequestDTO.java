package com.loan.notification_service.dto;

import lombok.Data;

import java.util.Map;

@Data
public class NotificationRequestDTO {

    private String eventCode;
    private String channel;
    private String recipient;
    private Map<String, String> placeholders;

}
