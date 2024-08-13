package com.xdatacore.sportslineapi.controllers

import com.xdatacore.sportslineapi.models.AuthenticationRequest
import com.xdatacore.sportslineapi.models.AuthenticationResponse
import com.xdatacore.sportslineapi.models.User
import com.xdatacore.sportslineapi.services.CustomUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.AuthenticationException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    @Autowired val userDetailsService: CustomUserDetailsService,
    @Autowired val authenticationManager: AuthenticationManager,
    @Autowired val passwordEncoder: BCryptPasswordEncoder
) {

    @PostMapping("/register")
    fun register(@RequestBody user: User): User {
        val encodedPassword = passwordEncoder.encode(user.clave)
        val newUser = user.copy(clave = encodedPassword)
        return userDetailsService.saveUser(newUser)
    }

    @PostMapping("/authenticate")
    fun authenticate(@RequestBody authenticationRequest: AuthenticationRequest): AuthenticationResponse {
        return try {
            val authentication = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(
                    authenticationRequest.username,
                    authenticationRequest.password
                )
            )
            val userDetails = userDetailsService.loadUserByUsername(authenticationRequest.username) as User
            AuthenticationResponse("Authenticated", userDetails.username, userDetails.id)
        } catch (e: AuthenticationException) {
            AuthenticationResponse("Authentication failed", null)
        }
    }
}
