package com.xdatacore.sportslineapi.repositories

import com.xdatacore.sportslineapi.models.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User, String> {
    fun findByNombreUsuario(nombreUsuario: String): User?
}
