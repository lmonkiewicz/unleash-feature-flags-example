# Feature Flags: Spring Boot + Unleash

## How to Run

### Prerequisites
- Java 11 or higher
- Docker and Docker Compose
- Maven (or use the included Maven wrapper)

### Starting the Unleash Server
1. Start the Unleash server and its dependencies using Docker Compose:
   ```
   docker-compose up -d
   ```
2. The Unleash server will be available at http://localhost:4242
   - Default admin credentials: admin/unleash4all
3. Create the following feature flags in the Unleash UI:
   - `SIMPLE_FLAG` - for simple ON/OFF flag example
   - `CONTEXT_USER_FLAG` - for context-based flag example
   - `CONTEXT_ATTRIBUTE_FLAG` - for context-based flag example (requires creating a "role" context field in Unleash UI)
   - `ONCE_EVALUATED_FLAG` - for once-evaluated bean example
   - `DYNAMIC_FLAG` - for dynamic bean switching example
   - `VARIANT_FLAG` - for variant flag example (requires creating variant configuration in Unleash UI)

### Running the Application
Run the application with a selected profile to see different use cases:

```
# Using Maven
mvn spring-boot:run -Dspring-boot.run.profiles=<profile>

# Using Maven wrapper
./mvnw spring-boot:run -Dspring-boot.run.profiles=<profile>
```

### Available Profiles:
- `simpleFlag` - simple ON/OFF flag
- `contextFlag` - ON/OFF flag dependent on context values (ex. userId, or custom value)
- `onceEvaluatedBean` - bean creation dependent on flag state - evaluated once at startup
- `dynamicBean` - multiple beans, with dynamic switching between them, depending on the flag state
- `variant` - example of flag with Variant value
