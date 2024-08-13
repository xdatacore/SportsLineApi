package com.xdatacore.sportslineapi.repositories

import com.xdatacore.sportslineapi.models.InvoiceHeader
import org.springframework.data.mongodb.repository.MongoRepository

interface InvoiceHeaderRepository : MongoRepository<InvoiceHeader, String> {
    fun findByNumFactura(numFactura: Int): InvoiceHeader?
}
