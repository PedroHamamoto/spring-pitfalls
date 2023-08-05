package br.com.hamamoto.spring_pitfalls.bank.domain

import br.com.hamamoto.spring_pitfalls.bank.client.BankClient
import mu.KotlinLogging
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class BankService(
    private val bankClient: BankClient
) {

    private val logger = KotlinLogging.logger {}

    fun getBankByCode(code: Int) =
        getBanksMap()[code]

    @Cacheable("banks")
    private fun getBanksMap() =
        bankClient.getBanks()
            .filter { it.code != null }
            .associate { it.code to Bank(it.code!!, it.name!!) }
            .also { logger.info { "Getting Banks" } }

}