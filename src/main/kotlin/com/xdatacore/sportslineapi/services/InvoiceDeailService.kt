package com.xdatacore.sportslineapi.services

import com.xdatacore.sportslineapi.models.InvoiceDetail
import com.xdatacore.sportslineapi.repositories.InvoiceDetailRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InvoiceDetailService(@Autowired private val invoiceDetailRepository: InvoiceDetailRepository) {

    fun getAllInvoiceDetails(): List<InvoiceDetail> {
        return invoiceDetailRepository.findAll()
    }

    fun getInvoiceDetailById(id: String): InvoiceDetail? {
        return invoiceDetailRepository.findById(id).orElse(null)
    }

    fun getInvoiceDetailsByNumFactura(numFactura: Int): List<InvoiceDetail> {
        return invoiceDetailRepository.findByNumFactura(numFactura)
    }

    fun createInvoiceDetail(invoiceDetail: InvoiceDetail): InvoiceDetail {
        return invoiceDetailRepository.save(invoiceDetail)
    }

    fun updateInvoiceDetail(id: String, updatedInvoiceDetail: InvoiceDetail): InvoiceDetail? {
        return if (invoiceDetailRepository.existsById(id)) {
            val invoiceDetailToSave = updatedInvoiceDetail.copy(detalleFacturaId = id)
            invoiceDetailRepository.save(invoiceDetailToSave)
        } else {
            null
        }
    }

    fun deleteInvoiceDetail(id: String): Boolean {
        return if (invoiceDetailRepository.existsById(id)) {
            invoiceDetailRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
