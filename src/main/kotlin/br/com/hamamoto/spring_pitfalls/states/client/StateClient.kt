package br.com.hamamoto.spring_pitfalls.states.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(url = "\${servico-dados-ibge.url}", name = "sevico-dados-ibge")
interface StateClient {

    @GetMapping("api/v1/localidades/estados")
    fun getStates(): List<StateResponse>
}