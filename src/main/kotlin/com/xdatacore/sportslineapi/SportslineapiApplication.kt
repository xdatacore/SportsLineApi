package com.xdatacore.sportslineapi

import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper
import org.springframework.data.mongodb.core.convert.MappingMongoConverter

@SpringBootApplication
class SportslineapiApplication

fun main(args: Array<String>) {
	runApplication<SportslineapiApplication>(*args)
}

@Configuration
class AppConfiguration{
	@Autowired
	private val mongoConverter: MappingMongoConverter? = null

	// remove _class
	@PostConstruct
	fun setupMongoEscapeCharacterConversion() {
		mongoConverter!!.setTypeMapper(DefaultMongoTypeMapper(null))
	}
}