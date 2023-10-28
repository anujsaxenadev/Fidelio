package com.wordpress.anujsaxenadev.date

/**
 * Interface for Handling Date And Time Processing
 * See `DateManagerImpl` for implementations.
 */
interface DateManager{

    /**
     * Get today Date Time String in given Format.
     *
     * @param format Given Format of the Date Time Output.
     *
     * @return Output in Given format or `null` if invalid format is provided.
     */
    suspend fun getTodayInFormat(format: String): String?
}