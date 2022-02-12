package com.skmonjurul.notification.controller;

import com.skmonjurul.clients.dto.NotificationRequest;
import com.skmonjurul.notification.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class NotificationController {

    @Autowired
    private INotificationService notificationService;

    @PostMapping("/notification")
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        notificationService.send(notificationRequest);
    }
}
