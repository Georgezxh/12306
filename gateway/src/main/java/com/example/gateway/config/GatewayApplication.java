package com.example.gateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;


@SpringBootApplication
@ComponentScan("com.example")
public class GatewayApplication {

    private static final Logger LOG = LoggerFactory.getLogger(GatewayApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(GatewayApplication.class);
        try {
            Environment env = app.run(args).getEnvironment();
            System.out.println(111);
            LOG.info("网关启动成功！！");
            LOG.info("网关地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
            System.out.println(222);
        } catch (Exception e) {
            LOG.error("启动过程中发生错误", e);
            e.printStackTrace();
        }
    }


}
