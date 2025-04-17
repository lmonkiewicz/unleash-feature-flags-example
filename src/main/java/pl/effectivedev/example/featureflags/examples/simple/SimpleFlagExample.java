package pl.effectivedev.example.featureflags.examples.simple;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.effectivedev.example.featureflags.features.Features;

@Profile("simpleFlag")
@Component
@Slf4j
@RequiredArgsConstructor
public class SimpleFlagExample {

    private final Features features;

    @Scheduled(fixedRate = 2000)
    public void execute() {
        if (features.isEnabled(Features.Feature.SIMPLE_FLAG)) {
            log.info("Simple flag ENABLED");
        } else {
            log.info("Simple flag DISABLED");
        }
    }
}
