package com.narbase.narcore.web.network

import com.narbase.narcore.dto.common.EnumDtoName

/**
 * NARBASE TECHNOLOGIES CONFIDENTIAL
 * ______________________________
 * [2017] -[2019] Narbase Technologies
 * All Rights Reserved.
 * Created by islam
 * On: 2020/02/02.
 */


fun <E> E.dto(): DtoName<E> where E : EnumDtoName, E : Enum<E> {
    return DtoName(this)
}

class DtoName<E> private constructor(private val name: String) where E : EnumDtoName, E : Enum<E> {
    @Suppress("CAST_NEVER_SUCCEEDS")
    @Deprecated("Use .enum() instead")
    fun getName() = this as? String ?: this.name

    constructor(enumDto: EnumDtoName) : this(enumDto.dtoName)

    @Suppress("unused")
    fun toJSON() = name
}

@Suppress("CAST_NEVER_SUCCEEDS")
inline fun <reified E> DtoName<E>.enum(): E where E : EnumDtoName, E : Enum<E> {
    val dtoName = this as? String ?: getName()
    return enumValues<E>().first { it.dtoName == dtoName }
}


inline fun <reified E> valueOfDto(str: String): E? where E : Enum<E>, E : EnumDtoName {
    return enumValues<E>().firstOrNull { it.dtoName == str }
}
