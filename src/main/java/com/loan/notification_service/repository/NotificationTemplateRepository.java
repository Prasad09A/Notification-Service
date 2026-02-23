package com.loan.notification_service.repository;

import com.loan.notification_service.entity.NotificationTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotificationTemplateRepository extends JpaRepository<NotificationTemplate,Long> {

    Optional<NotificationTemplate>  findByEventCodeAndChannel(String eventCode, String channel);
}
