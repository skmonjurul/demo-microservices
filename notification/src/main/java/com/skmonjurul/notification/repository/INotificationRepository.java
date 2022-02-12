package com.skmonjurul.notification.repository;

import com.skmonjurul.notification.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotificationRepository extends JpaRepository<Notification, Integer> {
}
