package com.narbase.narcore.domain.user.crud

import com.narbase.narcore.common.exceptions.InvalidRequestException
import com.narbase.narcore.data.tables.DeletableTable
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import java.util.*

/**
 * NARBASE TECHNOLOGIES CONFIDENTIAL
 * ______________________________
 * [2017] -[2019] Narbase Technologies
 * All Rights Reserved.
 * Created by islam
 * On: 2020/02/06.
 */

fun <E> E.softDelete(id: UUID?) where E : UUIDTable, E : DeletableTable {
    val dbTable = this
    val updatedRows = transaction {
        dbTable.update({ dbTable.id eq id }) {
            it[dbTable.isDeleted] = true
        }
    }
    if (updatedRows == 0) throw InvalidRequestException("No rows match the id sent by the request, nothing was deleted")
}