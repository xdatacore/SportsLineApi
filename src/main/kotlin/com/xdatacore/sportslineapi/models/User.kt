package com.xdatacore.sportslineapi.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Document(collection = "usuario")
data class User(
    @Id val id: String? = null,
    val nombreUsuario: String,
    val clave: String,
    val tipo: Int // 1--ADM, 2--VENDEDOR
) : UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority> {
        val role = if (tipo == 1) "ROLE_ADMIN" else "ROLE_VENDEDOR"
        return listOf(SimpleGrantedAuthority(role))
    }

    override fun getPassword(): String {
        return clave
    }

    override fun getUsername(): String {
        return nombreUsuario
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}
