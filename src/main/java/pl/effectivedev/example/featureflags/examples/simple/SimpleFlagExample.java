package pl.effectivedev.example.featureflags.examples;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.effectivedev.example.featureflags.features.Features;

@Component
@Slf4j
@RequiredArgsConstructor
public class SimpleFlagExample {

    private final Features features;

    public void execute() {
        if (features.isEnabled(Features.Feature.SIMPLE_FLAG)) {
            log.info("Simple flag ENABLED");
        } else {
            log.info("Simple flag DISABLED");
        }
    }
}
