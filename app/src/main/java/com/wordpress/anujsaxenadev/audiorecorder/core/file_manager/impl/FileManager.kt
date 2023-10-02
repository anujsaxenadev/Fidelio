package com.wordpress.anujsaxenadev.audiorecorder.core.file_manager.impl

import java.io.FileDescriptor

interface FileManager {
    companion object{
        const val AUDIO_FILE_PREFIX: String = "AUDIO-REC-"
    }
    suspend fun getInternalFilesList() : Array<String>
    suspend fun createFileStream(filename: String) : FileDescriptor?
}