package com.skmonjurul.customer.service;

import com.skmonjurul.clients.dto.NotificationRequest;

public interface INotificationService {
    void send(NotificationRequest notificationRequest);
}
