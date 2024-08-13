package com.xdatacore.sportslineapi.services

import com.xdatacore.sportslineapi.models.User
import com.xdatacore.sportslineapi.repositories.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(private val userRepository: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findByNombreUsuario(username)
            ?: throw UsernameNotFoundException("User not found with username: $username")
    }

    fun saveUser(user: User): User {
        return userRepository.save(user)
    }
}
