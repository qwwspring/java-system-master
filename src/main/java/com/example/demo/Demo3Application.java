package com.example.demo;

import com.mantoo.mtic.netty.client.ConnectInfo;
import com.mantoo.mtic.netty.client.DataTransferClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// Generated by https://start.springboot.io
// 优质的 spring/boot/data/security/cloud 框架中文文档尽在 => https://springdoc.cn
@SpringBootApplication
public class Demo3Application {

    public static void main(String[] args) {

        SpringApplication.run(Demo3Application.class, args);
       ConnectInfo connectInfo = new ConnectInfo("124.221.193.23", 8010, new dd(),
                1, "DD122201");
   // DataTransferClient.run(connectInfo);
    }

}
