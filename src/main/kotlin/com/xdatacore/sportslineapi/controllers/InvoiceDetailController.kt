package com.xdatacore.sportslineapi.controllers

import com.xdatacore.sportslineapi.models.InvoiceDetail
import com.xdatacore.sportslineapi.services.InvoiceDetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/invoice-details")
class InvoiceDetailController(@Autowired private val invoiceDetailService: InvoiceDetailService) {

    @GetMapping
    fun getAllInvoiceDetails(): List<InvoiceDetail> {
        return invoiceDetailService.getAllInvoiceDetails()
    }

    @GetMapping("/{id}")
    fun getInvoiceDetailById(@PathVariable id: String): InvoiceDetail? {
        return invoiceDetailService.getInvoiceDetailById(id)
    }

    @GetMapping("/by-num-factura/{numFactura}")
    fun getInvoiceDetailsByNumFactura(@PathVariable numFactura: Int): List<InvoiceDetail> {
        return invoiceDetailService.getInvoiceDetailsByNumFactura(numFactura)
    }

    @PostMapping
    fun createInvoiceDetail(@RequestBody invoiceDetail: InvoiceDetail): InvoiceDetail {
        return invoiceDetailService.createInvoiceDetail(invoiceDetail)
    }

    @PutMapping("/{id}")
    fun updateInvoiceDetail(@PathVariable id: String, @RequestBody updatedInvoiceDetail: InvoiceDetail): InvoiceDetail? {
        return invoiceDetailService.updateInvoiceDetail(id, updatedInvoiceDetail)
    }

    @DeleteMapping("/{id}")
    fun deleteInvoiceDetail(@PathVariable id: String): Boolean {
        return invoiceDetailService.deleteInvoiceDetail(id)
    }
}
