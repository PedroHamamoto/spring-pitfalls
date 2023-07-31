package br.com.hamamoto.spring_pitfalls.states.client

import com.fasterxml.jackson.annotation.JsonProperty

data class StateResponse (
    @JsonProperty("sigla")
    val uf: String,
    @JsonProperty("nome")
    val name: String
)