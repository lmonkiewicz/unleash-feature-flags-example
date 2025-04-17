package pl.effectivedev.example.featureflags.examples.once;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.effectivedev.example.featureflags.examples.context.ContextFlagExample;
import pl.effectivedev.example.featureflags.examples.dynamic.DynamicExample;
import pl.effectivedev.example.featureflags.examples.simple.SimpleFlagExample;
import pl.effectivedev.example.featureflags.examples.variant.ContextVariantFlagExample;

@Component
@RequiredArgsConstructor
@Slf4j
public class OnceEvaluetedExampleRunner {

    private final OnceEvaluatedFeature onceEvaluatedFeature;

    @Scheduled(fixedRate = 2000)
    public void execute() {
        log.info("---");
        onceEvaluatedFeature.execute();
    }
}
