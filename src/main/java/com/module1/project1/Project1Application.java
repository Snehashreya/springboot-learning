package com.module1.project1;

import com.module1.project1.impl.EmailNotificationService;
import com.module1.project1.impl.smsNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Project1Application  implements CommandLineRunner {

    @Autowired
    paymentService obj ;

    @Autowired
    paymentService obj1 ;

//    @Autowired
    final NotificationService notificationService;

    public Project1Application(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public static void main(String[] args)  {

        SpringApplication.run(Project1Application.class, args);

	}

    @Override
    public void run(String... args) throws Exception {

//        NotificationService notificationService = new smsNotification();
        notificationService.sendMsg();

//        System.out.println(obj.hashCode());
//        System.out.println(obj1.hashCode());
//        obj.pay();
//        obj1.pay();
    }
}
