package com.xdatacore.sportslineapi.models

import org.springframework.data.annotation.Id

data class AuthenticationRequest(
    val nombreUsuario: String,
    val clave: String
)

data class AuthenticationResponse(
    val message: String,
    val nombreUsuario: String?,
    val clave: String?,
    val tipo: Int,
    @Id val id: String? = null,
)