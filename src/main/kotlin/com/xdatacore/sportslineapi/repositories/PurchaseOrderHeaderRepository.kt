package com.xdatacore.sportslineapi.repositories

import com.xdatacore.sportslineapi.models.PurchaseOrderHeader
import org.springframework.data.mongodb.repository.MongoRepository

interface PurchaseOrderHeaderRepository : MongoRepository<PurchaseOrderHeader, String> {
    fun findByNumOC(numOC: Int): PurchaseOrderHeader?
}
