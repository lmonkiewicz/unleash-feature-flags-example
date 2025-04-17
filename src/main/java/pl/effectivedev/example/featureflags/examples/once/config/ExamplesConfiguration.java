package pl.effectivedev.example.featureflags.examples.once;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExamplesConfiguration {

    @Conditional(NewImplementationCondition.class)
    StartTimeEvaluationExample.OnceEvaluatedFeature newFeature() {
        return new StartTimeEvaluationExample.NewOnceEvaluatedFeature();
    }

    @ConditionalOnMissingBean
    StartTimeEvaluationExample.OnceEvaluatedFeature legacyFeature() {
        return new StartTimeEvaluationExample.LegacyOnceEvaluatedFeature();
    }
}
