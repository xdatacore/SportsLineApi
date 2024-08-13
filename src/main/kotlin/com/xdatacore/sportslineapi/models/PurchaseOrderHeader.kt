package com.xdatacore.sportslineapi.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

@Document(collection = "encabezadoFactura")
data class PurchaseOrderHeader (
    @Id val idEncabezadoFactura: String? = null,
    val numOC: Int,
    val idProveedor: String? = null,
    val fechaOC: LocalDateTime? = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC),
    val aplicada: Boolean
)