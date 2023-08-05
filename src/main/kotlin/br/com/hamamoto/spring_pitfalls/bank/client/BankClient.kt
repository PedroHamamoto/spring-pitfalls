package br.com.hamamoto.spring_pitfalls.bank.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(url = "\${brasil-api.url}", name = "brasil-api")
interface BankClient {

    @GetMapping("/api/banks/v1")
    fun getBanks(): List<BankResponse>

}