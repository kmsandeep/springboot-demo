package com.sandeep.springbootdemo.runner;

import com.sandeep.springbootdemo.enums.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//@Component
public class MyCLRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("App running: "+User.USER);
    }


}
