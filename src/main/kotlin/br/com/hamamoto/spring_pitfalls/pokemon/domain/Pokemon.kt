package br.com.hamamoto.spring_pitfalls.pokemon.domain

data class Pokemon(
    val id: Int,
    val name: String,
    val abilities: List<String>
)