package br.com.hamamoto.spring_pitfalls.trainer.data

import br.com.hamamoto.spring_pitfalls.trainer.domain.Trainer
import org.springframework.stereotype.Repository

@Repository
class TrainerRepository(
    private val trainerJpaRepository: TrainerJpaRepository
) {

    fun save(trainer: Trainer): Trainer =
        toDomain(trainerJpaRepository.save(toEntity(trainer)))

    companion object TrainerConverter{
        fun toEntity(trainer: Trainer) =
            TrainerEntity(
                id = trainer.id,
                name = trainer.name
            )

        fun toDomain(trainerEntity: TrainerEntity) =
            Trainer(
                id = trainerEntity.id,
                name = trainerEntity.name
            )
    }
}

