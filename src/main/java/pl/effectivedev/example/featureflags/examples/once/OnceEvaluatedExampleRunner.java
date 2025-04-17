package pl.effectivedev.example.featureflags.examples.once;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Profile("onceEvaluatedBean")
@Component
@RequiredArgsConstructor
@Slf4j
public class OnceEvaluatedExampleRunner {

    private final OnceEvaluatedFeature onceEvaluatedFeature;

    @Scheduled(fixedRate = 2000)
    public void execute() {
        log.info("---");
        onceEvaluatedFeature.execute();
    }
}
