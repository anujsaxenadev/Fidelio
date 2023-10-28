package com.wordpress.anujsaxenadev.date.impl

import com.wordpress.anujsaxenadev.logger.Logger
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class DateManagerImpl @Inject constructor(
    private val logger: Logger
) : DateManager,
    Logger by logger{
    override suspend fun getTodayInFormat(format: String): String? {
        return try {
            val sdf = SimpleDateFormat(format, Locale.getDefault())
            sdf.format(Date())
        } catch (e: Exception){
            e logThisExceptionWithTag javaClass.simpleName
            null
        }
    }
}