package com.xdatacore.sportslineapi.services

import com.xdatacore.sportslineapi.models.Supplier
import com.xdatacore.sportslineapi.repositories.SupplierRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SupplierService(@Autowired private val supplierRepository: SupplierRepository) {

    fun getAllSuppliers(): List<Supplier> {
        return supplierRepository.findAll()
    }

    fun getSupplierById(id: String): Supplier? {
        return supplierRepository.findById(id).orElse(null)
    }

    fun createSupplier(supplier: Supplier): Supplier {
        return supplierRepository.save(supplier)
    }

    fun updateSupplier(id: String, updatedSupplier: Supplier): Supplier? {
        return if (supplierRepository.existsById(id)) {
            val supplierToSave = updatedSupplier.copy(codProv = id)
            supplierRepository.save(supplierToSave)
        } else {
            null
        }
    }

    fun deleteSupplier(id: String): Boolean {
        return if (supplierRepository.existsById(id)) {
            supplierRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
