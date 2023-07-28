package br.com.hamamoto.spring_pitfalls.pokemon.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(url = "\${poke-api.url}", name = "poke-api")
interface PokeApiClient {

    @GetMapping("/api/v2/pokemon/{name}")
    fun getByName(@PathVariable("name") name: String): PokemonApiResponse

}