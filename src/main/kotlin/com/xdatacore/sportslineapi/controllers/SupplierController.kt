package com.xdatacore.sportslineapi.controllers

import com.xdatacore.sportslineapi.models.Supplier
import com.xdatacore.sportslineapi.services.SupplierService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/suppliers")
class SupplierController(@Autowired private val supplierService: SupplierService) {

    @GetMapping
    fun getAllSuppliers(): List<Supplier> {
        return supplierService.getAllSuppliers()
    }

    @GetMapping("/{id}")
    fun getSupplierById(@PathVariable id: String): Supplier? {
        return supplierService.getSupplierById(id)
    }

    @PostMapping
    fun createSupplier(@RequestBody supplier: Supplier): Supplier {
        return supplierService.createSupplier(supplier)
    }

    @PutMapping("/{id}")
    fun updateSupplier(@PathVariable id: String, @RequestBody updatedSupplier: Supplier): Supplier? {
        return supplierService.updateSupplier(id, updatedSupplier)
    }

    @DeleteMapping("/{id}")
    fun deleteSupplier(@PathVariable id: String): Boolean {
        return supplierService.deleteSupplier(id)
    }
}
