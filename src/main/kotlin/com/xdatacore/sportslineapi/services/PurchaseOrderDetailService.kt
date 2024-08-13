package com.xdatacore.sportslineapi.services

import com.xdatacore.sportslineapi.models.PurchaseOrderDetail
import com.xdatacore.sportslineapi.repositories.PurchaseOrderDetailRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PurchaseOrderDetailService(@Autowired private val purchaseOrderDetailRepository: PurchaseOrderDetailRepository) {

    fun getAllPurchaseOrderDetails(): List<PurchaseOrderDetail> {
        return purchaseOrderDetailRepository.findAll()
    }

    fun getPurchaseOrderDetailById(id: String): PurchaseOrderDetail? {
        return purchaseOrderDetailRepository.findById(id).orElse(null)
    }

    fun getPurchaseOrderDetailsByNumOC(numOC: Int): List<PurchaseOrderDetail> {
        return purchaseOrderDetailRepository.findByNumOC(numOC)
    }

    fun createPurchaseOrderDetail(purchaseOrderDetail: PurchaseOrderDetail): PurchaseOrderDetail {
        return purchaseOrderDetailRepository.save(purchaseOrderDetail)
    }

    fun updatePurchaseOrderDetail(id: String, updatedPurchaseOrderDetail: PurchaseOrderDetail): PurchaseOrderDetail? {
        return if (purchaseOrderDetailRepository.existsById(id)) {
            val purchaseOrderDetailToSave = updatedPurchaseOrderDetail.copy(idDetalleOC = id)
            purchaseOrderDetailRepository.save(purchaseOrderDetailToSave)
        } else {
            null
        }
    }

    fun deletePurchaseOrderDetail(id: String): Boolean {
        return if (purchaseOrderDetailRepository.existsById(id)) {
            purchaseOrderDetailRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
