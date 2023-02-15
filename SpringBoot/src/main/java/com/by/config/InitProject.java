package com.by.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.InetAddress;

/**
 * @author 白也
 * @title 面板提示
 * @date 2023/2/15 12:40 下午
 */
@Data
@ConfigurationProperties(prefix = "server")
@Slf4j
public class InitProject implements ApplicationRunner{

    private int port;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        InetAddress localHost = InetAddress.getLocalHost();
        String url = "http://"+localHost.getCanonicalHostName()+":"+port;
        log.warn("接口地址："+url);
        log.warn("swagger文档地址:  " +url+"/doc.html");
    }
}
