package pl.effectivedev.example.featureflags.examples.dynamic;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.effectivedev.example.featureflags.features.Features;

@Component
@Primary
@RequiredArgsConstructor
public class DynamicExampleFacade implements DynamicExample {

    private final LegacyDynamicExampleFeature legacyFeaure;
    private final NewDynamicExampleFeature newFeature;

    private final Features features;

    @Override
    public void execute() {
        if (features.isEnabled(Features.Feature.DYNAMIC_FLAG)) {
            newFeature.execute();
        } else {
            legacyFeaure.execute();
        }
    }
}
