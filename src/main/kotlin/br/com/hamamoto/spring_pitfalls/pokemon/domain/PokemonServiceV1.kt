package br.com.hamamoto.spring_pitfalls.pokemon.domain

import br.com.hamamoto.spring_pitfalls.pokemon.client.PokeApiClient
import mu.KotlinLogging
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class PokemonServiceV1(
    val pokeApiClient: PokeApiClient
) {
    private val logger = KotlinLogging.logger {}


    fun findByName(name: String) =
        getByName(name)

    @Cacheable("pokemons")
    private fun getByName(name: String) = pokeApiClient.getByName(name).let {
        Pokemon(
            id = it.id,
            name = it.name,
            abilities = it.moves.map { moveWrapper -> moveWrapper.move.name }
        ).also { logger.info { "Found pokemon $it" } }
    }
}