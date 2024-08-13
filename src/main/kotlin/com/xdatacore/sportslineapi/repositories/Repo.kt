package com.xdatacore.sportslineapi.repositories

import com.xdatacore.sportslineapi.models.Restaurant
import org.springframework.data.mongodb.repository.MongoRepository

interface Repo : MongoRepository<Restaurant, String> {
    fun findByRestaurantId(restaurantId: String): Restaurant?
}