package br.com.hamamoto.spring_pitfalls.trainer.domain

import br.com.hamamoto.spring_pitfalls.trainer.data.TrainerRepository
import java.lang.RuntimeException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TrainerService(
    private val trainerRepository: TrainerRepository
) {

    fun create(trainer: Trainer): Trainer =
        save(trainer)

    @Transactional
    private fun save(trainer: Trainer): Trainer {
        val persistedTrainer = trainerRepository.save(trainer)
        doSomething()
        return persistedTrainer
    }

    private fun doSomething() {
        throw RuntimeException("Unknown error")
    }
}