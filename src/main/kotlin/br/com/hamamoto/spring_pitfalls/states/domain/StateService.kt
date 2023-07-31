package br.com.hamamoto.spring_pitfalls.states.domain

import br.com.hamamoto.spring_pitfalls.states.client.StateClient
import mu.KotlinLogging
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class StateService(
    private val stateClient: StateClient
) {
    private val logger = KotlinLogging.logger {}

    fun getStateNameByUf(uf: String) =
        getStatesMap()[uf]

    @Cacheable("states")
    private fun getStatesMap() =
        stateClient.getStates().associate { it.uf to it.name }
            .also { logger.info { "Getting states" } }

}