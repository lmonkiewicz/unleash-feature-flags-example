package pl.effectivedev.example.featureflags.examples.context;

import io.getunleash.UnleashContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.effectivedev.example.featureflags.features.Features;

import java.util.List;

@Profile("contextFlag")
@Component
@Slf4j
@RequiredArgsConstructor
public class ContextFlagExample {

    private final Features features;

    private final List<User> users = List.of(
            new User("luke", "jedi"),
            new User("leia", "princess"),
            new User("yoda", "jedi")
    );

    @Scheduled(fixedRate = 2000)
    public void execute() {
        userDependentFeature();
        customAttributeDependentFeature();
    }

    private void userDependentFeature() {
        users.forEach(user -> {
                    var context = UnleashContext.builder()
                            .userId(user.userId)
                            .build();

                    if (features.isEnabled(Features.Feature.CONTEXT_USER_FLAG, context)) {
                        log.info("Context flag ENABLED for user: {}", user);
                    } else {
                        log.info("Context flag DISABLED for user: {}", user);
                    }
                });

    }

    private void customAttributeDependentFeature() {
        users.forEach(user -> {
                    var context = UnleashContext.builder()
                            .userId(user.userId())
                            .addProperty("role", String.valueOf(user.role()))
                            .build();

                    if (features.isEnabled(Features.Feature.CONTEXT_ATTRIBUTE_FLAG, context)) {
                        log.info("Context Attribute flag ENABLED for user: {}", user);
                    } else {
                        log.info("Context Attribute flag DISABLED for user: {}", user);
                    }
                });
    }

    record User(String userId, String role){}
}
