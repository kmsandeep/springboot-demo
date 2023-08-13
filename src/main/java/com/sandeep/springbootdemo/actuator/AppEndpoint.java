package com.sandeep.springbootdemo.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;
@Endpoint(id="custom-health")
@Component
public class AppEndpoint {
    @ReadOperation()
    public String health(@Selector String name){
        System.out.println("custom-health: "+ name);
        return name;
    }
    @ReadOperation()
    public String health2( String name){
        System.out.println("custom-health: "+ name);
        return name;
    }
    @WriteOperation()
    public String health3(){
        System.out.println("custom-health");
        return "hello";
    }
}
