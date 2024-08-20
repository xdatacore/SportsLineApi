package com.xdatacore.sportslineapi.repositories

import com.xdatacore.sportslineapi.models.Usuario
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<Usuario, String> {
    fun findByNombreUsuario(nombreUsuario: String): Usuario?
}
