package br.com.hamamoto.spring_pitfalls.pokemon.view

import br.com.hamamoto.spring_pitfalls.pokemon.domain.PokemonServiceV2
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v2/pokemons")
class PokemonControllerV2(
    val pokemonServiceV2: PokemonServiceV2
) {

    @GetMapping("/{name}")
    fun getAbilitiesByNameV(@PathVariable("name") name: String) =
        pokemonServiceV2.findByName(name)

}