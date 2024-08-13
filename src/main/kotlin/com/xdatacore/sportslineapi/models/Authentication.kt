package com.xdatacore.sportslineapi.models

import org.springframework.data.annotation.Id

data class AuthenticationRequest(
    val username: String,
    val password: String
)

data class AuthenticationResponse(
    val message: String,
    val username: String?,
    @Id val id: String? = null,
)