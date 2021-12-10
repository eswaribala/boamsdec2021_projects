package com.test.springbootwithelk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//logstash.bat -f D:\logstash-6.5.3\logstash-6.5.3\config\logstash-my-microservice-architecture.conf
@SpringBootApplication
public class SpringbootWithElkApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWithElkApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Logger logger = LoggerFactory.getLogger(SpringbootWithElkApplication.class);
        logger.info("Started Integration with ELK.....");

        for (int i = 0; i < 10; i++) {
            logger.error("something wrong. id={}; name=Danske-{};", i, i);
        }
    }
}
