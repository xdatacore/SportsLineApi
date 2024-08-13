package com.xdatacore.sportslineapi.repositories

import com.xdatacore.sportslineapi.models.InvoiceDetail
import org.springframework.data.mongodb.repository.MongoRepository

interface InvoiceDetailRepository : MongoRepository<InvoiceDetail, String> {
    fun findByNumFactura(numFactura: Int): List<InvoiceDetail>
}
