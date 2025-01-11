package com.csoftz.user.common.config

import com.csoftz.user.service.MemoryUserService
import com.csoftz.user.service.UserService
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.annotation.Bean

@AutoConfiguration
class UserServiceConfiguration {

    @Bean
    fun userService(): UserService {
        return MemoryUserService()
    }
}