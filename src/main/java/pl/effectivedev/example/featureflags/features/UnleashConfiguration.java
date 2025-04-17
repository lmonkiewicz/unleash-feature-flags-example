package pl.effectivedev.example.featureflags.features;

import io.getunleash.DefaultUnleash;
import io.getunleash.Unleash;
import io.getunleash.util.UnleashConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UnleashConfiguration {

    @Bean
    Unleash unleash() {
        UnleashConfig config = UnleashConfig.builder()
                .appName("feature-flags-example")
                .instanceId("example-instance-1")
                .unleashAPI("http://localhost:4242/api")
                .apiKey("default:development.unleash-insecure-api-token")
                .synchronousFetchOnInitialisation(true)
                .build();

        return new DefaultUnleash(config);
    }
}
