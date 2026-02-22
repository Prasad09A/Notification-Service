package com.loan.notification_service.repository;

import com.loan.notification_service.Entity.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotificationLogRepository extends JpaRepository<NotificationLogRepository,Long> {

}
