package pl.effectivedev.example.featureflags.examples.variant;

import io.getunleash.UnleashContext;
import io.getunleash.variant.Payload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.effectivedev.example.featureflags.features.Features;

import java.util.List;

@Profile("variant")
@Component
@Slf4j
@RequiredArgsConstructor
public class ContextVariantFlagExample {

    private final Features features;

    private final List<User> users = List.of(
            new User("luke", "jedi"),
            new User("leia", "princess"),
            new User("yoda", "jedi")
    );

    @Scheduled(fixedRate = 2000)
    public void execute() {
        users.forEach(user -> {
            var context = UnleashContext.builder()
                    .userId(user.userId)
                    .build();

            if (features.isEnabled(Features.Feature.VARIANT_FLAG, context)) {
                var variant = features.getVariant(Features.Feature.VARIANT_FLAG, context);
                var value = variant.getPayload().map(Payload::getValue).orElse(null);

                log.info("Context variant flag ENABLED for user: {} with VARIANT: {}", user, value);
            } else {
                log.info("Context variant flag DISABLED for user: {}", user);
            }
        });
    }

    record User(String userId, String role){}
}
