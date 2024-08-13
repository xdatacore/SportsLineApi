package com.xdatacore.sportslineapi.controllers

import com.xdatacore.sportslineapi.models.Restaurant
import com.xdatacore.sportslineapi.repositories.Repo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/restaurants")
class Controller(@Autowired val repo: Repo) {

    @GetMapping
    fun getCount(): Int {
        return repo.findAll().count()
    }

    @GetMapping("/{id}")
    fun getRestaurantById(@PathVariable("id") id: String): ResponseEntity<Restaurant> {
        val restaurant = repo.findByRestaurantId(id)
        return if (restaurant != null) ResponseEntity.ok(restaurant) else ResponseEntity
            .notFound().build()
    }

    @PostMapping
    fun postRestaurant(): Restaurant {
        val restaurant = Restaurant().copy(name = "sample", restaurantId = "33332")
        return repo.insert(restaurant)
    }

    @PostMapping("/addByParams")
    fun postRestaurantAsParams(@RequestBody restaurant: Restaurant): ResponseEntity<Any> {
        return try {
            val insertedRestaurant = repo.insert(restaurant)
            ResponseEntity.ok(insertedRestaurant)
        } catch (e: Exception) {
            e.printStackTrace()
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: ${e.message}")
        }
    }

    @DeleteMapping("/{id}")
    fun deleteRestaurant(@PathVariable("id") id: String) {
        repo.findByRestaurantId(id)?.let {
            repo.delete(it)
        }
    }

    @PatchMapping("/{id}")
    fun updateRestaurant(@PathVariable("id") id: String): Restaurant? {
        return repo.findByRestaurantId(restaurantId = id)?.let {
            repo.save(it.copy(name = "Update"))
        }
    }
}