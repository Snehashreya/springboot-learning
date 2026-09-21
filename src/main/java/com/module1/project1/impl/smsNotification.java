package com.module1.project1.impl;

import com.module1.project1.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
//@Primary
@Component
@Qualifier("SmsNotification")
@ConditionalOnProperty(name ="notification.type", havingValue = "sms")
public class smsNotification implements NotificationService {
    @Override
    public void sendMsg() {
        System.out.println("SMS sending");
    }
}
