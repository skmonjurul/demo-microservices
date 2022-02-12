package com.skmonjurul.customer.service;

import com.skmonjurul.clients.NotificationClient;
import com.skmonjurul.clients.dto.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements INotificationService{

    @Autowired
    private NotificationClient notificationClient;

    @Override
    public void send(NotificationRequest notificationRequest) {
        notificationClient.sendNotification(notificationRequest);
    }
}
