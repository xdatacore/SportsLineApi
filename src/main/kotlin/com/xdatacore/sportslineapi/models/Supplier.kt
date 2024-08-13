package com.xdatacore.sportslineapi.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "proveedor")
data class Supplier (
    @Id val idProveedor: String? = null,
    val nombre: String
)