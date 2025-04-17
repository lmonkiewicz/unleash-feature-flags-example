package pl.effectivedev.example.featureflags.examples.dynamic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NewDynamicExampleFeature implements DynamicExample {
    @Override
    public void execute() {
        log.info("Executed from NEW DYNAMIC");
    }
}
