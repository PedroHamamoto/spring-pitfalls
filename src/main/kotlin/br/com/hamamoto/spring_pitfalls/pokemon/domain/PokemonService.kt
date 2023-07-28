package br.com.hamamoto.spring_pitfalls.pokemon.domain

import br.com.hamamoto.spring_pitfalls.pokemon.client.PokeApiClient
import org.springframework.stereotype.Service

@Service
class PokemonService(
    val pokeApiClient: PokeApiClient
) {
    fun findByName(name: String) =
        getByName(name)

    private fun getByName(name: String) = pokeApiClient.getByName(name).let {
        Pokemon(
            name = it.name,
            abilities = it.moves.map { moveWrapper -> moveWrapper.move.name }
        )
    }
}