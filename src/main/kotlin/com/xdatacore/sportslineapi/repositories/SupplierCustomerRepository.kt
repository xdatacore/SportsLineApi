package com.xdatacore.sportslineapi.repositories

import com.xdatacore.sportslineapi.models.Supplier
import com.xdatacore.sportslineapi.models.SupplierCustomer
import org.springframework.data.mongodb.repository.MongoRepository

interface SupplierCustomerRepository : MongoRepository<SupplierCustomer, String>
