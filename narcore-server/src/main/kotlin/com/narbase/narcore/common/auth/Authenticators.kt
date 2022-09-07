package com.narbase.narcore.common.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.narbase.narcore.common.auth.basic.BasicAuthenticator
import com.narbase.narcore.common.auth.loggedin.AuthorizedClientData
import com.narbase.narcore.data.access.roles.ClientRolesDao
import com.narbase.narcore.deployment.JwtConf
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

/**
 * NARBASE TECHNOLOGIES CONFIDENTIAL
 * ______________________________
 * [2017] -[2018] Narbase Technologies
 * All Rights Reserved.
 * Created by ${user}
 * On: ${date}.
 */

fun Application.setupAuthenticators(jwtRealm: String, jwtIssuer: String, jwtAudience: String) {
    install(Authentication) {
        basic(name = AuthenticationConstants.BASIC_AUTH) {
            realm = "basic auth"
            validate { credentials -> BasicAuthenticator().validate(credentials) }
        }

        jwt(name = AuthenticationConstants.JWT_AUTH) {
            realm = jwtRealm
            verifier(makeJwtVerifier(jwtIssuer, jwtAudience))
            myJwtVerifier = makeJwtVerifier(jwtIssuer, jwtAudience)
            validate { credential ->

                val clientId = credential.payload.claims["clientId"]?.asString() ?: return@validate null
                val uuidClientId = UUID.fromString(clientId)
                val timestamp = credential.payload.claims["timestamp"]?.asLong() ?: return@validate null
                val dynamicRoles = transaction { ClientRolesDao.getClientRoles(uuidClientId) }
                val privileges = dynamicRoles.map { it.privileges }.flatten()

                AuthorizedClientData(
                    clientId,
                    timestamp,
                    privileges,
                )
            }
        }
    }
}

val algorithm: Algorithm by lazy { Algorithm.HMAC256(JwtConf.jwtSecret) }
var myJwtVerifier: JWTVerifier? = null
private fun makeJwtVerifier(issuer: String, audience: String): JWTVerifier = JWT
    .require(algorithm)
    .withAudience(audience)
    .withIssuer(issuer)
    .build()