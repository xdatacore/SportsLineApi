package com.xdatacore.sportslineapi.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "detalleOC")
data class PurchaseOrderDetail (
    @Id val idDetalleOC: String? = null,
    val numOC: Int,
    val codProducto: String,
    val cantidad: Int?,
    val costo: Double
)
