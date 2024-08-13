package com.xdatacore.sportslineapi.repositories

import com.xdatacore.sportslineapi.models.PurchaseOrderDetail
import org.springframework.data.mongodb.repository.MongoRepository

interface PurchaseOrderDetailRepository : MongoRepository<PurchaseOrderDetail, String> {
    fun findByNumOC(numOC: Int): List<PurchaseOrderDetail>
}
