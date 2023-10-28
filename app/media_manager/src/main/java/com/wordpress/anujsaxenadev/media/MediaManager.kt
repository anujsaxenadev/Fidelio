package com.wordpress.anujsaxenadev.media

import java.io.File

/**
 * Interface for Managing the Media, like playing, pausing, etc.
 * See `MediaManagerImpl` for implementations.
 */
interface MediaManager {

    /**
     * Need to Initialise the MediaManager Before Use. It will set the meta data for the media.
     *
     * @param file reference of the file that we need to manage.
     */
    suspend fun initManager(file: File)

    /**
     * To play the media that has been initialised in `initManager`.
     * Ensure that `initManager` is called before use.
     */
    suspend fun play()

    /**
     * To pause the media that has been initialised in `initManager`.
     * Ensure that `initManager` is called before use.
     */
    suspend fun pause()

    /**
     * To stop the media and release media resources that has been initialised in `initManager`.
     * Ensure that `initManager` is called before use.
     */
    suspend fun stop()

    /**
     * To get the duration of the media that has been initialised in `initManager`.
     * Ensure that `initManager` is called before use.
     *
     * @return duration in milliseconds or 0 if not able to get duration like in case of file not found.
     */
    suspend fun getDuration(): Int
}