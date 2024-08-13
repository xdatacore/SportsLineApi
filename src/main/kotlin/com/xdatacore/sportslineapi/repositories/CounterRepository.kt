package com.xdatacore.sportslineapi.repositories

import com.xdatacore.sportslineapi.models.Counter
import org.springframework.data.mongodb.repository.MongoRepository

interface CounterRepository : MongoRepository<Counter, String>
