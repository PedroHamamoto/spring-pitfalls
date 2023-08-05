package br.com.hamamoto.spring_pitfalls.trainer.data

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

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