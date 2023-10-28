package com.wordpress.anujsaxenadev.logger.helpers

inline val <T : Any> T.tag: String
    get() = ((this as Any).javaClass as Class<*>).simpleName