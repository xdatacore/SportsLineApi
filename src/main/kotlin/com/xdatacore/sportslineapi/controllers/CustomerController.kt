package com.xdatacore.sportslineapi.controllers

import com.xdatacore.sportslineapi.models.Customer
import com.xdatacore.sportslineapi.services.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customer")
class CustomerController(@Autowired private val customerService: CustomerService) {

    @GetMapping
    fun getAllCustomers(): List<Customer> {
        return customerService.getAllCustomers()
    }

    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable id: String): Customer? {
        return customerService.getCustomerById(id)
    }

    @PostMapping
    fun createCustomer(@RequestBody customer: Customer): Customer {
        return customerService.createCustomer(customer)
    }

    @PutMapping("/{id}")
    fun updateCustomer(@PathVariable id: String, @RequestBody updatedCustomer: Customer): Customer? {
        return customerService.updateCustomer(id, updatedCustomer)
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: String): Boolean {
        return customerService.deleteCustomer(id)
    }
}