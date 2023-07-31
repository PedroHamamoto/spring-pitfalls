package br.com.hamamoto.spring_pitfalls.trainer.domain

import br.com.hamamoto.spring_pitfalls.trainer.data.TrainerRepository
import org.springframework.stereotype.Service

@Service
class TrainerService(
    private val trainerRepository: TrainerRepository
) {
    fun create(trainer: Trainer) =
        trainerRepository.save(trainer)
}