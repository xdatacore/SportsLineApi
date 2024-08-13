package com.xdatacore.sportslineapi.services

import com.xdatacore.sportslineapi.models.PurchaseOrderHeader
import com.xdatacore.sportslineapi.repositories.PurchaseOrderHeaderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PurchaseOrderHeaderService(
    @Autowired private val purchaseOrderHeaderRepository: PurchaseOrderHeaderRepository,
    @Autowired private val counterService: CounterService
) {

    fun getAllPurchaseOrderHeaders(): List<PurchaseOrderHeader> {
        return purchaseOrderHeaderRepository.findAll()
    }

    fun getPurchaseOrderHeaderById(id: String): PurchaseOrderHeader? {
        return purchaseOrderHeaderRepository.findById(id).orElse(null)
    }

    fun getPurchaseOrderHeaderByNumOC(numOC: Int): PurchaseOrderHeader? {
        return purchaseOrderHeaderRepository.findByNumOC(numOC)
    }

    fun createPurchaseOrderHeader(purchaseOrderHeader: PurchaseOrderHeader): PurchaseOrderHeader {
        val numOC = counterService.getNextSequence("purchaseOrderNumber")
        val newPurchaseOrderHeader = purchaseOrderHeader.copy(numOC = numOC)
        return purchaseOrderHeaderRepository.save(newPurchaseOrderHeader)
    }

    fun updatePurchaseOrderHeader(id: String, updatedPurchaseOrderHeader: PurchaseOrderHeader): PurchaseOrderHeader? {
        return if (purchaseOrderHeaderRepository.existsById(id)) {
            val purchaseOrderHeaderToSave = updatedPurchaseOrderHeader.copy(idEncabezadoFactura = id)
            purchaseOrderHeaderRepository.save(purchaseOrderHeaderToSave)
        } else {
            null
        }
    }

    fun deletePurchaseOrderHeader(id: String): Boolean {
        return if (purchaseOrderHeaderRepository.existsById(id)) {
            purchaseOrderHeaderRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
