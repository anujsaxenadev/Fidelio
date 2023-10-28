package com.wordpress.anujsaxenadev.file_manager

import java.io.File
import java.io.FileDescriptor

/**
 * Interface for Handing Files in System.
 * @see `AndroidFileManager` for implementations.
 */
interface FileManager {
    /**
     * Get the Internal Files List From the System. No Permissions are required for Internal Storage of the App.
     *
     * @return List of File names from Internal Storage.
     */
    suspend fun getInternalFilesList() : Array<String>

    /**
     * Create a file in Internal Storage with given name.
     *
     * @param filename Name of the file.
     *
     * @return [FileDescriptor] for the given file that was created or `null` if not able to create the file.
     */
    suspend fun createInternalFileStream(filename: String) : FileDescriptor?

    /**
     * Get the file reference with the Given Name form the Internal Storage.
     *
     * @param filename Name of the file.
     *
     * @return [File] reference of the file or `null` if not able to get the file.
     */
    suspend fun getInternalFile(filename: String): File?

    /**
     * Releasing the Resources that has been captured by Manager. like - File Streams, etc.
     * Must call this after the file execution is done.
     */
    suspend fun releaseResources()
}