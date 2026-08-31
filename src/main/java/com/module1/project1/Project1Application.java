package com.module1.project1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Project1Application  implements CommandLineRunner {

    @Autowired
    paymentService obj ;

    @Autowired
    paymentService obj1 ;

	public static void main(String[] args)  {

        SpringApplication.run(Project1Application.class, args);

	}

    @Override
    public void run(String... args) throws Exception {

        System.out.println(obj.hashCode());
        System.out.println(obj1.hashCode());


        obj.pay();
        obj1.pay();
    }
}
