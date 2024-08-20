package com.xdatacore.sportslineapi.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "clienteProveedor")
data class SupplierCustomer (
    @Id var idClienteProveedor: String? = null,
    val nombre: String,
    val apellido: String?,
    val correo: String?
)