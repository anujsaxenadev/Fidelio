package com.wordpress.anujsaxenadev.audiorecorder.date.impl

interface DateManager{
    suspend fun getTodayInFormat(format: String): String?
}