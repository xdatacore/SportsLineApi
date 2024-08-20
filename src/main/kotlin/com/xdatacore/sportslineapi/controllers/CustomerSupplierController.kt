package com.xdatacore.sportslineapi.controllers

import com.xdatacore.sportslineapi.models.SupplierCustomer
import com.xdatacore.sportslineapi.services.SupplierCustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers-supplier")
class CustomerSupplierController(@Autowired private val service: SupplierCustomerService) {

    @GetMapping
    fun getAll(): List<SupplierCustomer> {
        return service.getAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): SupplierCustomer? {
        return service.getById(id)
    }

    @PostMapping
    fun create(@RequestBody entity: SupplierCustomer): SupplierCustomer {
        return service.create(entity)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody updatedCustomer: SupplierCustomer): SupplierCustomer? {
        return service.update(id, updatedCustomer)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): Boolean {
        return service.delete(id)
    }
}