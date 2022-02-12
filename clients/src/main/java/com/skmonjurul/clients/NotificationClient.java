package com.skmonjurul.clients;

import com.skmonjurul.clients.dto.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("notification")
public interface NotificationClient {

    @PostMapping("/v1/notification")
    void sendNotification(@RequestBody NotificationRequest notificationRequest);
}
