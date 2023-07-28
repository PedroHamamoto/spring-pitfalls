# spring-pitfalls
This is a simple projects that presents common spring/spring-boot pitfalls

## 1. Proxying - Cache
To demonstrate this problem I've created two versions of PokemonController:
* The [V1](src/main/kotlin/br/com/hamamoto/spring_pitfalls/pokemon/view/PokemonControllerV2.kt) uses the [PokemonServiceV1](src/main/kotlin/br/com/hamamoto/spring_pitfalls/pokemon/domain/PokemonServiceV1.kt), which has the `@Cacheable` on an internal method. This implementation is problematic because this method was called directly instead of the spring proxy.
* The [V2](src/main/kotlin/br/com/hamamoto/spring_pitfalls/pokemon/view/PokemonControllerV2.kt) uses the [PokemonServiceV2](src/main/kotlin/br/com/hamamoto/spring_pitfalls/pokemon/domain/PokemonServiceV2.kt), which has the `@Cacheable` on the public method. This implementation worked because the spring proxy exposed the annotated method and was called by the controller.