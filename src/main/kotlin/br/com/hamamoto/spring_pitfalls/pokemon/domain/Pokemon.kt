package br.com.hamamoto.spring_pitfalls.pokemon.domain

data class Pokemon(
    val name: String,
    val abilities: List<String>,
    val id: Int
)