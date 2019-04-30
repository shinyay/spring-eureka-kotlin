package io.pivotal.shinyay.eureka

import org.springframework.web.bind.annotation.RequestMapping

interface GreetingInterface {

    @RequestMapping("/greeting")
    fun greeting(): String
}