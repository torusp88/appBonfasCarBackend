package danilopereira.bonfascarapi

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication





@SpringBootApplication()
@EnableAutoConfiguration
class BonfascarapiApplication

fun main(args: Array<String>) {
	runApplication<BonfascarapiApplication>(*args)
}
