# Feature Flags: Spring Boot \+ Unleash

## Jak uruchomić

### Wymagania wstępne

* Java 11 lub wyższa
* Docker i Docker Compose
* Maven (lub użyj dołączonego wrapperu Maven)

### Uruchamianie serwera Unleash

1. Uruchom serwer Unleash i jego zależności używając Docker Compose:
   
2. ```bash
   docker-compose up -d
   ```

2. Serwer Unleash będzie dostępny pod adresem: http://localhost:4242
   - Domyślne dane logowania administratora: `admin/unleash4all`
3. Utwórz następujące flagi funkcyjne (feature flags) w interfejsie użytkownika Unleash:
   - `SIMPLE_FLAG` - przykład prostej flagi ON/OFF
   - `CONTEXT_USER_FLAG` - przykład flagi opartej na kontekście
   - `CONTEXT_ATTRIBUTE_FLAG` - przykład flagi opartej na kontekście (wymaga utworzenia pola kontekstu "role" w interfejsie użytkownika Unleash)
   - `ONCE_EVALUATED_FLAG` - przykład beana sprawdzającego flagę raz
   - `DYNAMIC_FLAG` - przykład dynamicznego przełączania beanów
   - `VARIANT_FLAG` - przykład flagi z wariantami (wymaga utworzenia konfiguracji wariantu w interfejsie użytkownika Unleash)

### Uruchamianie aplikacji

Uruchom aplikację z wybranym profilem, aby zobaczyć różne przypadki użycia:

#### Użycie Mavena  
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=<profil>
```

#### Użycie wrappera Mavena
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=<profil>
```

### Dostępne profile:

- `simpleFlag` - prosta flaga ON/OFF
- `contextFlag` - flaga ON/OFF zależna od wartości kontekstu (np. userId lub niestandardowa wartość)
- `onceEvaluatedBean` - tworzenie beana zależne od stanu flagi \- ewaluowane raz przy starcie aplikacji
- `dynamicBean` - wiele beanów, z dynamicznym przełączaniem między nimi w zależności od stanu flagi
- `variant` - przykład flagi z wartością wariantu