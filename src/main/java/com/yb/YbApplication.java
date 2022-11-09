package com.yb;

import com.yb.init.SetUp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YbApplication {

    public static void main(String[] args) {
        SetUp tool = new SetUp();
        tool.setUp();
        SpringApplication.run(YbApplication.class, args);
    }

}
