package pl.effectivedev.example.featureflags.examples.once.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import pl.effectivedev.example.featureflags.examples.once.LegacyOnceEvaluatedFeature;
import pl.effectivedev.example.featureflags.examples.once.NewOnceEvaluatedFeature;
import pl.effectivedev.example.featureflags.examples.once.OnceEvaluatedFeature;
import pl.effectivedev.example.featureflags.features.Features;

@Configuration
public class ExamplesConfiguration {

    @Bean
    public OnceEvaluatedFeature newFeature(Features features) {
        if (features.isEnabled(Features.Feature.ONCE_EVALUATED_FLAG)) {
            return new NewOnceEvaluatedFeature();
        } else {
            return new LegacyOnceEvaluatedFeature();
        }
    }
}
