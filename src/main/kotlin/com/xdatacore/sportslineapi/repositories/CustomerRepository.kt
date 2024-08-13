package com.xdatacore.sportslineapi.repositories

import com.xdatacore.sportslineapi.models.Customer
import org.springframework.data.mongodb.repository.MongoRepository

interface CustomerRepository : MongoRepository<Customer, String>