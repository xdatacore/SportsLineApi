package com.xdatacore.sportslineapi.controllers

import com.xdatacore.sportslineapi.models.InvoiceHeader
import com.xdatacore.sportslineapi.models.InvoiceDetail
import com.xdatacore.sportslineapi.services.InvoiceHeaderService
import com.xdatacore.sportslineapi.services.InvoiceDetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/invoice-headers")
class InvoiceHeaderController(
    @Autowired private val invoiceHeaderService: InvoiceHeaderService,
    @Autowired private val invoiceDetailService: InvoiceDetailService
) {

    @GetMapping
    fun getAllInvoiceHeaders(): List<InvoiceHeader> {
        return invoiceHeaderService.getAllInvoiceHeaders()
    }

    @GetMapping("/{id}")
    fun getInvoiceHeaderById(@PathVariable id: String): InvoiceHeader? {
        return invoiceHeaderService.getInvoiceHeaderById(id)
    }

    @GetMapping("/with-details/{numFactura}")
    fun getInvoiceWithDetails(@PathVariable numFactura: Int): Map<String, Any?> {
        val header = invoiceHeaderService.getInvoiceHeaderByNumFactura(numFactura)
        val details = invoiceDetailService.getInvoiceDetailsByNumFactura(numFactura)
        return mapOf("header" to header, "details" to details)
    }

    @PostMapping
    fun createInvoiceHeader(@RequestBody invoiceHeader: InvoiceHeader): InvoiceHeader {
        return invoiceHeaderService.createInvoiceHeader(invoiceHeader)
    }

    @PutMapping("/{id}")
    fun updateInvoiceHeader(@PathVariable id: String, @RequestBody updatedInvoiceHeader: InvoiceHeader): InvoiceHeader? {
        return invoiceHeaderService.updateInvoiceHeader(id, updatedInvoiceHeader)
    }

    @DeleteMapping("/{id}")
    fun deleteInvoiceHeader(@PathVariable id: String): Boolean {
        return invoiceHeaderService.deleteInvoiceHeader(id)
    }
}
