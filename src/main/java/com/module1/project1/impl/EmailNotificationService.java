package com.module1.project1.impl;

import com.module1.project1.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
@Qualifier("EmailNotification")
@ConditionalOnProperty(name ="notification.type", havingValue = "email")
public class EmailNotificationService implements NotificationService {
    @Override
    public void sendMsg() {
        System.out.println("Email sending");
    }
}
