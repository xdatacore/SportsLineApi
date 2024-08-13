package com.xdatacore.sportslineapi.controllers

import com.xdatacore.sportslineapi.models.Product
import com.xdatacore.sportslineapi.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController(@Autowired private val productService: ProductService) {

    @GetMapping
    fun getAllProducts(): List<Product> {
        return productService.getAllProducts()
    }

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: String): Product? {
        return productService.getProductById(id)
    }

    @PostMapping
    fun createProduct(@RequestBody product: Product): Product {
        return productService.createProduct(product)
    }

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: String, @RequestBody updatedProduct: Product): Product? {
        return productService.updateProduct(id, updatedProduct)
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: String): Boolean {
        return productService.deleteProduct(id)
    }
}