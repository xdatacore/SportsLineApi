package com.xdatacore.sportslineapi.services

import com.xdatacore.sportslineapi.models.Product
import com.xdatacore.sportslineapi.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService(@Autowired private val productRepository: ProductRepository) {

    fun getAllProducts(): List<Product> {
        return productRepository.findAll()
    }

    fun getProductById(id: String): Product? {
        return productRepository.findById(id).orElse(null)
    }

    fun createProduct(product: Product): Product {
        return productRepository.save(product)
    }

    fun updateProduct(id: String, updatedProduct: Product): Product? {
        return if (productRepository.existsById(id)) {
            val productToSave = updatedProduct.copy(idProducto = id)
            productRepository.save(productToSave)
        } else {
            null
        }
    }

    fun deleteProduct(id: String): Boolean {
        return if (productRepository.existsById(id)) {
            productRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
