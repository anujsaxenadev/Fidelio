package com.wordpress.anujsaxenadev.logger.impl

sealed interface LogType{
    object LOGCAT: LogType
}