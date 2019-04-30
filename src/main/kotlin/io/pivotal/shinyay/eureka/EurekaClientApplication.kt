package io.pivotal.shinyay.eureka

import com.netflix.discovery.EurekaClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class EurekaClientApplication : GreetingInterface {

	private lateinit var eurekaClient: EurekaClient

	@Value("\${spring.application.name}")
	private lateinit var appName: String

	override fun greeting(): String = String.format("Hello from '%s'!", eurekaClient.getApplication(appName).name)
}

fun main(args: Array<String>) {
	runApplication<EurekaClientApplication>(*args)
}