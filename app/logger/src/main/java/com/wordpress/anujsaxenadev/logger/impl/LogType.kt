package com.wordpress.anujsaxenadev.logger.impl

sealed interface LogType{
    val tag: String
    data class Message(
        override val tag:String,
        val message: String
    ): LogType

    data class Exception(
        override val tag:String,
        val e: Throwable
    ): LogType
}