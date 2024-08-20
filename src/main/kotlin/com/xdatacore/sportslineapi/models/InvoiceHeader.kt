package com.xdatacore.sportslineapi.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

@Document(collection = "encabezadoFactura")
data class InvoiceHeader (
    @Id val encabezadoFacturaId: String? = null,
    val numFactura: Int,
    val idCliente: String? = null,
    val fechaFac: LocalDateTime? = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC),
    val total: Double
)