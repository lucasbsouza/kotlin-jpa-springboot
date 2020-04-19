package com.example.kex1

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan
class Aplication

fun main(args: Array<String>) {
	runApplication<Aplication>(*args) {
		setBannerMode(Banner.Mode.OFF)
	}
}
