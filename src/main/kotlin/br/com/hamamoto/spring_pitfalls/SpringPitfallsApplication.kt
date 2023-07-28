package br.com.hamamoto.spring_pitfalls

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringPitfallsApplication

fun main(args: Array<String>) {
	runApplication<SpringPitfallsApplication>(*args)
}
