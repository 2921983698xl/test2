package com.xl.fan.fastdfs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FastDFSConfig {
    @Value("8888")
    private String trackerServers;
}
