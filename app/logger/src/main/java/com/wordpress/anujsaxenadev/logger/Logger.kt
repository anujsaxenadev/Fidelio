package com.wordpress.anujsaxenadev.logger

interface Logger {
    infix fun Throwable.logThisExceptionWithTag(tag:String)
    infix fun String.logThisMessageWithTag(tag:String)
}