package br.com.hamamoto.spring_pitfalls.pokemon.view

import br.com.hamamoto.spring_pitfalls.pokemon.domain.PokemonServiceV1
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/pokemons")
class PokemonControllerV1(
    val pokemonServiceV1: PokemonServiceV1
) {

    @GetMapping("/{name}")
    fun getByName(@PathVariable("name") name: String) =
        pokemonServiceV1.findByName(name)

}