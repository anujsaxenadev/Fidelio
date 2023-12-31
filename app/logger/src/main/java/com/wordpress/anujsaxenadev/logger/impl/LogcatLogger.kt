package com.wordpress.anujsaxenadev.logger.impl

import android.util.Log
import com.wordpress.anujsaxenadev.logger.Logger
import javax.inject.Inject
import javax.inject.Singleton

/**
 * An implementation of [Logger] just writes different types of Logging Input events to logcat.
 * Used in builds where no logs events should be sent to a backend.
 */
@Singleton
class LogcatLogger @Inject constructor() : Logger {

    override infix fun Throwable.logThisExceptionWithTag(tag:String){
        log(LogType.Exception(tag, this))
    }

    override infix fun String.logThisMessageWithTag(tag:String){
        log(LogType.Message(tag, this))
    }

    /**
     * Logging different types of Log Inputs.
     *
     * @param logType type of log that we want to emit.
     */
    private fun log(logType: LogType) {
        when(logType){
            is LogType.Exception -> {
                Log.d(logType.tag, logType.e.message, logType.e)
            }
            is LogType.Message -> {
                Log.d(logType.tag, logType.message)
            }
        }
    }

    /**
     * Type of Logs that can be logged.
     *
     * @property tag all the log types should always contain this log identifier.
     */
    private sealed interface LogType{
        val tag: String
        data class Message(
            override val tag:String,
            val message: String
        ): LogType

        data class Exception(
            override val tag:String,
            val e: Throwable
        ): LogType
    }
}
