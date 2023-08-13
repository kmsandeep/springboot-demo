package com.sandeep.springbootdemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Data
@ConfigurationProperties(prefix = "mail")
@Component
@PropertySource("classpath:myprops.properties")
public class MailProps {
    private String from;
    private String to;
    private String subject;
}
