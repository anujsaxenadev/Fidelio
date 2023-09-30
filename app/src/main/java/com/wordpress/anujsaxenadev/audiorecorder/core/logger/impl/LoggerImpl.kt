package com.wordpress.anujsaxenadev.audiorecorder.core.logger.impl

import android.util.Log
import java.lang.Exception

class LoggerImpl : Logger{
    override fun log(logType: LogType, tag:String, e: Exception) {
        Log.e(tag, e.toString())
    }
}