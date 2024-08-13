package com.xdatacore.sportslineapi.repositories

import com.xdatacore.sportslineapi.models.Product
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository : MongoRepository<Product, String>
