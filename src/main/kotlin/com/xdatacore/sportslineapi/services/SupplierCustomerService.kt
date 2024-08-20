package com.xdatacore.sportslineapi.services

import com.xdatacore.sportslineapi.models.Customer
import com.xdatacore.sportslineapi.models.Supplier
import com.xdatacore.sportslineapi.models.SupplierCustomer
import com.xdatacore.sportslineapi.models.Usuario
import com.xdatacore.sportslineapi.repositories.CustomerRepository
import com.xdatacore.sportslineapi.repositories.SupplierCustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SupplierCustomerService(@Autowired private val repository: SupplierCustomerRepository) {

    fun getAll(): List<SupplierCustomer> {
        return repository.findAll()
    }

    fun getById(id: String): SupplierCustomer? {
        return repository.findById(id).orElse(null)
    }

    fun create(entity: SupplierCustomer): SupplierCustomer {
        return repository.save(entity)
    }

    fun update(id: String, updatedEntity: SupplierCustomer): SupplierCustomer? {
        return if (repository.existsById(id)) {
            val entityToSave = updatedEntity.copy(idClienteProveedor = id)
            repository.save(entityToSave)
        } else {
            null
        }
    }

    fun delete(id: String): Boolean {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else {
            false
        }
    }
}
