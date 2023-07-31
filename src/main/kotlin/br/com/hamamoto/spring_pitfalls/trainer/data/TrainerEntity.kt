package br.com.hamamoto.spring_pitfalls.trainer.data

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp

@Entity
@Table(name = "trainers")
data class TrainerEntity (

    @get:[Id GeneratedValue(strategy = GenerationType.IDENTITY) Column(updatable = false, nullable = false)]
    var id: Long?,

    @get:[Column(updatable = false, nullable = false)]
    var name: String,

    @get:[CreationTimestamp Column(updatable = false, nullable = false)]
    var createdAt : LocalDateTime = LocalDateTime.now(),

    @get:[UpdateTimestamp Column(nullable = false)]
    var updatedAt : LocalDateTime = LocalDateTime.now()

)