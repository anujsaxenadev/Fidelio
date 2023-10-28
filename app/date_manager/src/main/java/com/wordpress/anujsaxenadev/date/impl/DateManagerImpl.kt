package com.wordpress.anujsaxenadev.date.impl

import com.wordpress.anujsaxenadev.date.DateManager
import com.wordpress.anujsaxenadev.logger.Logger
import com.wordpress.anujsaxenadev.logger.helpers.tag
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DateManagerImpl @Inject constructor(
    private val logger: Logger
) : DateManager,
    Logger by logger{
    override suspend fun getTodayInFormat(format: String): String? {
        return try {
            val sdf = SimpleDateFormat(format, Locale.getDefault())
            sdf.format(Date())
        } catch (e: Exception){
            e logThisExceptionWithTag tag
            null
        }
    }
}