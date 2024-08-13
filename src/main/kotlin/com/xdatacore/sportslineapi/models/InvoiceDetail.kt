package com.xdatacore.sportslineapi.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "detalleFactura")
data class InvoiceDetail (
    @Id val detalleFacturaId: String? = null,
    val numFactura: Int,
    val idProducto: String,
    val cantidad: Int?
)