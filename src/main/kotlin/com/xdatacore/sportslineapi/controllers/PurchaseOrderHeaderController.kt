package com.xdatacore.sportslineapi.controllers

import com.xdatacore.sportslineapi.models.PurchaseOrderHeader
import com.xdatacore.sportslineapi.services.PurchaseOrderHeaderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/purchase-order-headers")
class PurchaseOrderHeaderController(@Autowired private val purchaseOrderHeaderService: PurchaseOrderHeaderService) {

    @GetMapping
    fun getAllPurchaseOrderHeaders(): List<PurchaseOrderHeader> {
        return purchaseOrderHeaderService.getAllPurchaseOrderHeaders()
    }

    @GetMapping("/{id}")
    fun getPurchaseOrderHeaderById(@PathVariable id: String): PurchaseOrderHeader? {
        return purchaseOrderHeaderService.getPurchaseOrderHeaderById(id)
    }

    @GetMapping("/by-num-oc/{numOC}")
    fun getPurchaseOrderHeaderByNumOC(@PathVariable numOC: Int): PurchaseOrderHeader? {
        return purchaseOrderHeaderService.getPurchaseOrderHeaderByNumOC(numOC)
    }

    @PostMapping
    fun createPurchaseOrderHeader(@RequestBody purchaseOrderHeader: PurchaseOrderHeader): PurchaseOrderHeader {
        return purchaseOrderHeaderService.createPurchaseOrderHeader(purchaseOrderHeader)
    }

    @PutMapping("/{id}")
    fun updatePurchaseOrderHeader(@PathVariable id: String, @RequestBody updatedPurchaseOrderHeader: PurchaseOrderHeader): PurchaseOrderHeader? {
        return purchaseOrderHeaderService.updatePurchaseOrderHeader(id, updatedPurchaseOrderHeader)
    }

    @DeleteMapping("/{id}")
    fun deletePurchaseOrderHeader(@PathVariable id: String): Boolean {
        return purchaseOrderHeaderService.deletePurchaseOrderHeader(id)
    }
}
