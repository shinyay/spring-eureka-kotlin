package io.pivotal.shinyay.eureka

import com.netflix.discovery.EurekaClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@EnableEurekaClient
@RestController
class EurekaClientApplication(var eurekaClient: EurekaClient): GreetingInterface {

	@Value("\${spring.application.name}")
	private lateinit var appName: String

	override fun greeting(): String = String.format("Hello from '%s'!", eurekaClient.getApplication(appName).name)
}

fun main(args: Array<String>) {
	runApplication<EurekaClientApplication>(*args)
}