/*----------------------------------------------------------------------------*/
/* Source File:   USERSERVICEAUTOCONFIGURATION.KT                             */
/* Copyright (c), 2025 The Musketeers                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jan.07/2025  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.user.common.config

import com.csoftz.user.service.MemoryUserService
import com.csoftz.user.service.UserService
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.annotation.Bean

/**
 * Holds the bean creation to configure.
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@AutoConfiguration
class UserServiceAutoConfiguration {

    /**
     * Create the 'userService'.
     */
    @Bean
    fun userService(): UserService {
        return MemoryUserService()
    }
}