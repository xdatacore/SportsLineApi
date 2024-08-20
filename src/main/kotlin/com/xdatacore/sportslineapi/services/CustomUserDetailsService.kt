package com.xdatacore.sportslineapi.services

import com.xdatacore.sportslineapi.models.Usuario
import com.xdatacore.sportslineapi.repositories.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(private val userRepository: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findByNombreUsuario(username)
            ?: throw UsernameNotFoundException("Usuario not found with username: $username")
    }

    fun saveUser(usuario: Usuario): Usuario {
        return userRepository.save(usuario)
    }

    fun getUserById(id: String): Usuario? {
        return userRepository.findById(id).orElse(null)
    }

    fun deleteUser(id: String): Boolean {
        return if (userRepository.existsById(id)) {
            userRepository.deleteById(id)
            true
        } else {
            false
        }
    }

    fun getAllUsers(): List<Usuario> {
        return userRepository.findAll()
    }
}
