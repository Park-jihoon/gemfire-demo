package kr.co.pohinian.gemfiredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.cache.config.EnableGemfireCaching;

@SpringBootApplication
public class GemfireDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(GemfireDemoApplication.class, args);
    }
}
