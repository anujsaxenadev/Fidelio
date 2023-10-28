package com.wordpress.anujsaxenadev.logger

/**
 * Interface for logging Exceptions or Messages.
 * See `LogcatLogger` for implementations.
 */
interface Logger {

    /**
     * Log the Exception with the given tag.
     *
     * Example Usage:
     * ```
     * try {
     *      // Some Code
     * } catch (e: Exception){
     *      e logThisExceptionWithTag "Tag Name"
     * }
     * ```
     *
     * @param tag Identifier for the given Exception.
     */
    infix fun Throwable.logThisExceptionWithTag(tag:String)

    /**
     * Log the Message with the given tag.
     *
     * Example Usage:
     * ```
     * "Some Message" logThisMessageWithTag "Tag Name"
     * ```
     *
     * @param tag Identifier for the given Message.
     */
    infix fun String.logThisMessageWithTag(tag:String)
}