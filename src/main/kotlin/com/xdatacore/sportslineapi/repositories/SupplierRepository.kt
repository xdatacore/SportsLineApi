package com.xdatacore.sportslineapi.repositories

import com.xdatacore.sportslineapi.models.Supplier
import org.springframework.data.mongodb.repository.MongoRepository

interface SupplierRepository : MongoRepository<Supplier, String>
