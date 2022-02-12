package com.skmonjurul.notification.service;

import com.skmonjurul.clients.dto.NotificationRequest;
import com.skmonjurul.notification.model.Notification;
import com.skmonjurul.notification.repository.INotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService implements INotificationService{

    @Autowired
    private INotificationRepository notificationRepository;

    @Override
    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(Notification.builder()
                .toCustomerId(notificationRequest.getToCustomerId())
                .toCustomerEmail(notificationRequest.getToCustomerName())
                .sender("Sk Monjurul Haque")
                .message(notificationRequest.getMessage())
                .sentAt(LocalDateTime.now())
                .build()
        );
    }
}
