package br.com.hamamoto.spring_pitfalls.trainer.data

import org.springframework.data.jpa.repository.JpaRepository

interface TrainerJpaRepository: JpaRepository<TrainerEntity, Long>