package com.xdatacore.sportslineapi.services

import com.xdatacore.sportslineapi.models.InvoiceHeader
import com.xdatacore.sportslineapi.repositories.InvoiceHeaderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InvoiceHeaderService(
    @Autowired private val invoiceHeaderRepository: InvoiceHeaderRepository,
    @Autowired private val counterService: CounterService
) {

    fun getAllInvoiceHeaders(): List<InvoiceHeader> {
        return invoiceHeaderRepository.findAll()
    }

    fun getInvoiceHeaderById(id: String): InvoiceHeader? {
        return invoiceHeaderRepository.findById(id).orElse(null)
    }

    fun getInvoiceHeaderByNumFactura(numFactura: Int): InvoiceHeader? {
        return invoiceHeaderRepository.findByNumFactura(numFactura)
    }

    fun createInvoiceHeader(invoiceHeader: InvoiceHeader): InvoiceHeader {
        val numFactura = counterService.getNextSequence("invoiceNumber")
        val newInvoiceHeader = invoiceHeader.copy(numFactura = numFactura)
        return invoiceHeaderRepository.save(newInvoiceHeader)
    }

    fun updateInvoiceHeader(id: String, updatedInvoiceHeader: InvoiceHeader): InvoiceHeader? {
        return if (invoiceHeaderRepository.existsById(id)) {
            val invoiceHeaderToSave = updatedInvoiceHeader.copy(encabezadoFacturaId = id)
            invoiceHeaderRepository.save(invoiceHeaderToSave)
        } else {
            null
        }
    }

    fun deleteInvoiceHeader(id: String): Boolean {
        return if (invoiceHeaderRepository.existsById(id)) {
            invoiceHeaderRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
