package pl.effectivedev.example.featureflags.features;

import io.getunleash.Unleash;
import io.getunleash.UnleashContext;
import io.getunleash.variant.Variant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Features {

    private final Unleash unleash;

    public boolean isEnabled(Feature feature) {
        return unleash.isEnabled(feature.name(), false);
    }

    public boolean isEnabled(Feature feature, UnleashContext context) {
        return unleash.isEnabled(feature.name(), context, false);
    }

    public Variant getVariant(Feature feature, UnleashContext context) {
        return unleash.getVariant(feature.name(), context);
    }

    public enum Feature {
        SIMPLE_FLAG,
        CONTEXT_USER_FLAG,
        CONTEXT_ATTRIBUTE_FLAG,
        ONCE_EVALUATED_FLAG,
        DYNAMIC_FLAG,
        VARIANT_FLAG,
    }
}
