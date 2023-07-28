package br.com.hamamoto.spring_pitfalls.pokemon.domain

import br.com.hamamoto.spring_pitfalls.pokemon.client.PokeApiClient
import mu.KotlinLogging
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class PokemonServiceV2(
    val pokeApiClient: PokeApiClient
) {
    private val logger = KotlinLogging.logger {}

    @Cacheable("pokemons-v2")
    fun findByName(name: String) =
        pokeApiClient.getByName(name).let {
            Pokemon(
                id = it.id,
                name = it.name,
                abilities = it.moves.map { moveWrapper -> moveWrapper.move.name }
            ).also { logger.info { "[V2] Found pokemon $it" } }
        }
}