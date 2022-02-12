package com.skmonjurul.clients.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest {
    private Integer toCustomerId;
    private String toCustomerName;
    private String message;
}
