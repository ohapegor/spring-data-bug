package ru.ohapegor.springdatabug

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Example project to demonstrate and reproduce spring-data-mongo bug (see ru.ohapegor.springdatabug.repository.RepositoryTests)
 */
@SpringBootApplication
class SpringDataBugApplication

fun main(args: Array<String>) {
	runApplication<SpringDataBugApplication>(*args)
}
