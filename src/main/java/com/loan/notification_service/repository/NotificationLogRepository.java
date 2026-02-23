package com.loan.notification_service.repository;

import com.loan.notification_service.entity.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationLogRepository extends JpaRepository<NotificationLog,Long> {

}
