package pl.effectivedev.example.featureflags.examples.dynamic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.effectivedev.example.featureflags.examples.context.ContextFlagExample;
import pl.effectivedev.example.featureflags.examples.once.OnceEvaluatedFeature;
import pl.effectivedev.example.featureflags.examples.simple.SimpleFlagExample;
import pl.effectivedev.example.featureflags.examples.variant.ContextVariantFlagExample;

@Profile("dynamicBean")
@Component
@RequiredArgsConstructor
@Slf4j
public class DynamicExampleRunner {

    private final DynamicExample dynamicExample;

    @Scheduled(fixedRate = 2000)
    public void execute() {
        log.info("---");
        dynamicExample.execute();
    }
}
