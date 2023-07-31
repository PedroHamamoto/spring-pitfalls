package br.com.hamamoto.spring_pitfalls.trainer.view

import br.com.hamamoto.spring_pitfalls.trainer.domain.Trainer
import br.com.hamamoto.spring_pitfalls.trainer.domain.TrainerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/v1/trainers")
class TrainerController(
    private val trainerService: TrainerService
) {

    @PostMapping
    fun create(@RequestBody trainerCreationRequest: TrainerCreationRequest) =
        trainerService.create(toDomain(trainerCreationRequest)).let {
            ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(it.id)).body(it)
        }
    
    companion object Converter{
        fun toDomain(trainerCreationRequest: TrainerCreationRequest) =
            Trainer(name = trainerCreationRequest.name)
    }
}