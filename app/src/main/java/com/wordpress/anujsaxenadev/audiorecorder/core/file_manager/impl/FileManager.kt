package com.wordpress.anujsaxenadev.audiorecorder.core.file_manager.impl

interface FileManager {
    suspend fun getInternalFilesList() : Array<String>
}