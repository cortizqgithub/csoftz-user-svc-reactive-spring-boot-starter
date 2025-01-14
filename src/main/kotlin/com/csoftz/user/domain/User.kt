/*----------------------------------------------------------------------------*/
/* Source File:   USER.KT                                                     */
/* Copyright (c), 2025 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jan.07/2025  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.user.domain

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import jakarta.validation.constraints.NotEmpty

/**
 * Represents User information.
 *
 * @param id      Identifies the User.
 * @param name    Indicates the User's name (mandatory).
 * @param address Indicates the location of the User (mandatory).
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("id", "name", "address")
public data class User(
    val id: String?,
    @field:NotEmpty(message = "User Name is mandatory") val name: String?,
    @field:NotEmpty(message = "User Address is mandatory") val address: String?
)
