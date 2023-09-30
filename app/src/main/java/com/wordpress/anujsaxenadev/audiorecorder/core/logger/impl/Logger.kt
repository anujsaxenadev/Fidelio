package com.wordpress.anujsaxenadev.audiorecorder.core.logger.impl

import java.lang.Exception

interface Logger {
    fun log(logType: LogType, tag:String, e: Exception)
}