package com.wordpress.anujsaxenadev.logger.impl

import android.util.Log
import com.wordpress.anujsaxenadev.logger.Logger
import javax.inject.Inject

class LoggerImpl @Inject constructor() : Logger {
    override infix fun Throwable.logThisExceptionWithTag(tag:String){
        log(LogType.Exception(tag, this))
    }

    override infix fun String.logThisMessageWithTag(tag:String){
        log(LogType.Message(tag, this))
    }

    private fun log(logType: LogType) {
        when(logType){
            is LogType.Exception -> {
                Log.e(logType.tag, logType.e.toString())
            }
            is LogType.Message -> {
                Log.e(logType.tag, logType.message)
            }
        }
    }
}