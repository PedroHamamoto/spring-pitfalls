package br.com.hamamoto.spring_pitfalls.bank.view

import br.com.hamamoto.spring_pitfalls.bank.domain.BankService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/banks")
class BankController(
    private val bankService: BankService
) {

    @GetMapping("/{code}")
    fun getBankByCode(@PathVariable("code") code: Int) =
        bankService.getBankByCode(code)

}