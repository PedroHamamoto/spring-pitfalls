package br.com.hamamoto.spring_pitfalls.pokemon.client

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("pokemons")
class PokemonController(val pokeApiClient: PokeApiClient) {

    @GetMapping("/{name}/abilities")
    fun getAbilitiesByName(@PathVariable("name") name: String) =
        pokeApiClient.getByName(name)

}