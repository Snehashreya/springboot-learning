package com.module1.project1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

//@Component
@Service
@Controller
@Repository
@RestController
public class paymentService {

    void pay(){
        System.out.println("paying...");
    }

}
