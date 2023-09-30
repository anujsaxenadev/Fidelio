package com.wordpress.anujsaxenadev.audiorecorder.date.impl

import com.wordpress.anujsaxenadev.audiorecorder.core.logger.impl.LogType
import com.wordpress.anujsaxenadev.audiorecorder.core.logger.impl.Logger
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateManagerImpl(private val logger: Logger) : DateManager{
    override suspend fun getTodayInFormat(format: String): String? {
        return try {
            val sdf = SimpleDateFormat(format, Locale.getDefault())
            sdf.format(Date())
        } catch (e: Exception){
            logger.log(LogType.LOGCAT, javaClass.name, e)
            null
        }
    }
}