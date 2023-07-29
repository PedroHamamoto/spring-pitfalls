package br.com.hamamoto.spring_pitfalls.pokemon.domain

import com.github.tomakehurst.wiremock.client.WireMock.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock
import org.springframework.http.HttpHeaders.CONTENT_TYPE
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import wiremock.org.apache.hc.core5.http.HttpStatus.SC_OK

@SpringBootTest
@AutoConfigureWireMock(port = 0)
class PokemonServiceV1Test {

    @Autowired
    private lateinit var pokemonServiceV1: PokemonServiceV1

    @Test
    fun `getByName - should hit cache only once while getting same pokemon name`() {
        // Given
        val pokemonName = "klinklang"
        val testUrl = "/api/v2/pokemon/$pokemonName"

        stubFor(get(urlEqualTo(testUrl))
            .willReturn(aResponse()
                .withHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .withStatus(SC_OK)
                .withBodyFile("poke-api/klinklang-response.json")
            )
        )

        // When
        for (i in 0 until 10) {
            pokemonServiceV1.getByName(pokemonName)
        }

        // Then
        verify(1, getRequestedFor(urlEqualTo(testUrl)))
    }

    @Test
    fun `findByName - should hit cache ten times while getting same pokemon name`() {
        // Given
        val pokemonName = "klinklang"
        val testUrl = "/api/v2/pokemon/$pokemonName"

        stubFor(get(urlEqualTo(testUrl))
            .willReturn(aResponse()
                .withHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .withStatus(SC_OK)
                .withBodyFile("poke-api/klinklang-response.json")
            )
        )

        // When
        for (i in 0 until 10) {
            pokemonServiceV1.findByName(pokemonName)
        }

        // Then
        verify(10, getRequestedFor(urlEqualTo(testUrl)))
    }

}