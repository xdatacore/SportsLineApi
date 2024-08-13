package com.xdatacore.sportslineapi.services

import com.xdatacore.sportslineapi.models.Customer
import com.xdatacore.sportslineapi.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService(@Autowired private val customerRepository: CustomerRepository) {

    fun getAllCustomers(): List<Customer> {
        return customerRepository.findAll()
    }

    fun getCustomerById(id: String): Customer? {
        return customerRepository.findById(id).orElse(null)
    }

    fun createCustomer(customer: Customer): Customer {
        return customerRepository.save(customer)
    }

    fun updateCustomer(id: String, updatedCustomer: Customer): Customer? {
        return if (customerRepository.existsById(id)) {
            val customerToSave = updatedCustomer.copy(idCliente = id)
            customerRepository.save(customerToSave)
        } else {
            null
        }
    }

    fun deleteCustomer(id: String): Boolean {
        return if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
