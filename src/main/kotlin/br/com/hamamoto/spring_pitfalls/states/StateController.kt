package br.com.hamamoto.spring_pitfalls.states

import br.com.hamamoto.spring_pitfalls.states.domain.StateService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/states")
class StateController(
    private val stateService: StateService
) {

    @GetMapping("{uf}")
    fun getStateByUf(@PathVariable("uf") uf: String) =
        stateService.getStateNameByUf(uf.uppercase())

}