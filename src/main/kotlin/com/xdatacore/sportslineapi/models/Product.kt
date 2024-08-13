package com.xdatacore.sportslineapi.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "producto")
data class Product (
    @Id val idProducto: String? = null,
    val nombre: String? = null,
    val precioVenta: Double,
    val inventario: Int
)