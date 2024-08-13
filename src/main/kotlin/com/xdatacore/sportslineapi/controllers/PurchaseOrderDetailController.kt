package com.xdatacore.sportslineapi.controllers

import com.xdatacore.sportslineapi.models.PurchaseOrderDetail
import com.xdatacore.sportslineapi.services.PurchaseOrderDetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/purchase-order-details")
class PurchaseOrderDetailController(@Autowired private val purchaseOrderDetailService: PurchaseOrderDetailService) {

    @GetMapping
    fun getAllPurchaseOrderDetails(): List<PurchaseOrderDetail> {
        return purchaseOrderDetailService.getAllPurchaseOrderDetails()
    }

    @GetMapping("/{id}")
    fun getPurchaseOrderDetailById(@PathVariable id: String): PurchaseOrderDetail? {
        return purchaseOrderDetailService.getPurchaseOrderDetailById(id)
    }

    @GetMapping("/by-num-oc/{numOC}")
    fun getPurchaseOrderDetailsByNumOC(@PathVariable numOC: Int): List<PurchaseOrderDetail> {
        return purchaseOrderDetailService.getPurchaseOrderDetailsByNumOC(numOC)
    }

    @PostMapping
    fun createPurchaseOrderDetail(@RequestBody purchaseOrderDetail: PurchaseOrderDetail): PurchaseOrderDetail {
        return purchaseOrderDetailService.createPurchaseOrderDetail(purchaseOrderDetail)
    }

    @PutMapping("/{id}")
    fun updatePurchaseOrderDetail(@PathVariable id: String, @RequestBody updatedPurchaseOrderDetail: PurchaseOrderDetail): PurchaseOrderDetail? {
        return purchaseOrderDetailService.updatePurchaseOrderDetail(id, updatedPurchaseOrderDetail)
    }

    @DeleteMapping("/{id}")
    fun deletePurchaseOrderDetail(@PathVariable id: String): Boolean {
        return purchaseOrderDetailService.deletePurchaseOrderDetail(id)
    }
}
