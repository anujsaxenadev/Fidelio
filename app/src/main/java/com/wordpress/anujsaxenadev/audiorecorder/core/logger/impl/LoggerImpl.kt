package com.wordpress.anujsaxenadev.audiorecorder.core.logger.impl

import android.util.Log
import javax.inject.Inject

class LoggerImpl @Inject constructor() : Logger{
    override fun log(logType: LogType, tag:String, e: Exception) {
        Log.e(tag, e.toString())
    }
}