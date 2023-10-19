package com.wordpress.anujsaxenadev.date.impl

interface DateManager{
    suspend fun getTodayInFormat(format: String): String?
}