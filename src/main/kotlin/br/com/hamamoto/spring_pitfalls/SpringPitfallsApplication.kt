package br.com.hamamoto.spring_pitfalls

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class SpringPitfallsApplication

fun main(args: Array<String>) {
	runApplication<SpringPitfallsApplication>(*args)
}
