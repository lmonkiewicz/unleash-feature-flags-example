package pl.effectivedev.example.featureflags.examples.once;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LegacyOnceEvaluatedFeature implements OnceEvaluatedFeature {

    @Override
    public void execute() {
        log.info("Executed from LEGACY");
    }
}
