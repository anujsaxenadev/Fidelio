package com.wordpress.anujsaxenadev.logger.helpers

/**
 * Get the Tag Name of the Class from where log is been generated
 */
inline val <T : Any> T.tag: String
    get() = ((this as Any).javaClass as Class<*>).simpleName