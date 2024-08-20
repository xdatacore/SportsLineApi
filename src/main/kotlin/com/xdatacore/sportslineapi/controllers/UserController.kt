package com.xdatacore.sportslineapi.controllers

import com.xdatacore.sportslineapi.models.AuthenticationRequest
import com.xdatacore.sportslineapi.models.AuthenticationResponse
import com.xdatacore.sportslineapi.models.Usuario
import com.xdatacore.sportslineapi.services.CustomUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.AuthenticationException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/users")
class UserController(
    @Autowired val userDetailsService: CustomUserDetailsService,
    @Autowired val authenticationManager: AuthenticationManager,
    @Autowired val passwordEncoder: BCryptPasswordEncoder
) {

    @PostMapping("/register")
    fun register(@RequestBody usuario: Usuario): Usuario {
        val encodedPassword = passwordEncoder.encode(usuario.clave)
        val newUser = usuario.copy(clave = encodedPassword)
        return userDetailsService.saveUser(newUser)
    }

    @PostMapping("/authenticate")
    fun authenticate(@RequestBody authenticationRequest: AuthenticationRequest): AuthenticationResponse {
        return try {
            val authentication = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(
                    authenticationRequest.nombreUsuario,
                    authenticationRequest.clave
                )
            )
            val usuarioDetails = userDetailsService.loadUserByUsername(authenticationRequest.nombreUsuario) as Usuario
            AuthenticationResponse("Authenticated", usuarioDetails.username, usuarioDetails.clave, usuarioDetails.tipo, usuarioDetails.nombreUsuario)
        } catch (e: AuthenticationException) {
            AuthenticationResponse("Authentication failed", null, null, 0, null)
        }
    }

    @GetMapping
    fun getUsers(): List<Usuario> {
        return userDetailsService.getAllUsers()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: String): Usuario {
        return userDetailsService.getUserById(id)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: $id")
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: String): ResponseEntity<Void> {
        return if (userDetailsService.deleteUser(id)) {
            ResponseEntity.noContent().build()  // 204 No Content
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()  // 404 Not Found
        }
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: String, @RequestBody updatedUser: Usuario): Usuario {
        val userToUpdate = userDetailsService.getUserById(id)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: $id")

        val encodedPassword = if (updatedUser.clave == userToUpdate.clave) {
            // Si las contraseñas son iguales, significa que no han cambiado (ya están encriptadas)
            userToUpdate.clave
        } else {
            // Si son diferentes, significa que la contraseña fue cambiada y debe encriptarse
            passwordEncoder.encode(updatedUser.clave)
        }

        val newUser = updatedUser.copy(clave = encodedPassword)

        return userDetailsService.saveUser(newUser)
    }



}
