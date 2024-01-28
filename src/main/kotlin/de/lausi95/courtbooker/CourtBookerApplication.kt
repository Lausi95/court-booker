package de.lausi95.courtbooker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CourtBookerApplication

fun main(args: Array<String>) {
  runApplication<CourtBookerApplication>(*args)
}
