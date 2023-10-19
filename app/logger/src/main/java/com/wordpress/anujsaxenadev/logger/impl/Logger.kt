package com.wordpress.anujsaxenadev.logger.impl

import java.lang.Exception

interface Logger {
    fun log(logType: LogType, tag:String, e: Exception)
}