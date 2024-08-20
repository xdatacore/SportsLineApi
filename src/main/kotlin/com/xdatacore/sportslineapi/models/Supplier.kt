package com.xdatacore.sportslineapi.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "proveedor")
data class Supplier (
    val nombre: String? = null,
    @Id val codProv: String? = null
)