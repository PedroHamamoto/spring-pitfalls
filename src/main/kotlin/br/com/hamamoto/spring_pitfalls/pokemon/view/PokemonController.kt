package br.com.hamamoto.spring_pitfalls.pokemon.view

import br.com.hamamoto.spring_pitfalls.pokemon.domain.PokemonServiceV1
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PokemonController(
    val pokemonServiceV1: PokemonServiceV1
) {

    @GetMapping("/v1/pokemons/{name}/abilities")
    fun getAbilitiesByName(@PathVariable("name") name: String) =
        pokemonServiceV1.findByName(name)

}