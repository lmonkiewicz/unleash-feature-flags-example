package pl.effectivedev.example.featureflags;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FeatureFlagsExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeatureFlagsExampleApplication.class, args);
    }

}
