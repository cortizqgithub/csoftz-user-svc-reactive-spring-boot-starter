/*----------------------------------------------------------------------------*/
/* Source File:   MEMORYUSERSERVICE.JAVA                                      */
/* Copyright (c), 2025 The Musketeers                                         */
/*----------------------------------------------------------------------------*/

/*-----------------------------------------------------------------------------
 History
 Jan.07/2025  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.user.service

import com.csoftz.user.domain.User
import java.util.UUID
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

/**
 * Handles the list of user in the system. The internal representation is to
 * use a in-memory storage.
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@Service
class MemoryUserService : UserService {
    private val userList: MutableList<User> = ArrayList()

    override fun exists(userId: String) = findUserInfo(userId).isPresent

    override fun insert(user: User): User {
        var userToInsert = user

        if (user.id == null) {
            userToInsert = User(UUID.randomUUID().toString(), user.name, user.address)
        }

        userList.add(userToInsert)
        return userToInsert
    }

    override fun retrieve(userId: String): User? = findUserInfo(userId).orElseGet { null };

    override fun delete(userId: String) = userList.removeIf { user -> user.id == userId }

    override fun update(user: User): Boolean {
        if (user.id?.let { exists(it) } == true) {
            delete(user.id)
            insert(user)
            return true
        }

        return false
    }

    override fun retrieveAll(): Flux<User> = Flux.fromIterable(userList)

    override fun count(): Long {
        return userList.size.toLong()
    }

    private fun findUserInfo(userId: String) = userList
        .stream()
        .filter { user -> user.id == userId }
        .findFirst()
}
