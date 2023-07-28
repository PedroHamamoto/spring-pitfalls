package br.com.hamamoto.spring_pitfalls.pokemon.client

data class PokemonApiResponse(
    val name: String,
    val moves: List<MoveWrapper>,
    val id: Int
)

data class MoveWrapper(
    val move: Move
)
data class Move(
    val name: String
)