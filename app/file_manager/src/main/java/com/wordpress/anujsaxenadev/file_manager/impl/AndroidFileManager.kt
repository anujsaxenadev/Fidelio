package com.wordpress.anujsaxenadev.file_manager.impl

import android.content.Context
import com.wordpress.anujsaxenadev.logger.Logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileDescriptor
import java.io.FileOutputStream

class AndroidFileManager(
    private val context: Context,
    private val logger: Logger
) : FileManager,
    Logger by logger {
    override suspend fun getInternalFilesList() : Array<String>{
        return try {
            context.fileList()
        } catch (e: Exception){
            e logThisExceptionWithTag javaClass.simpleName
            arrayOf()
        }
    }

    override suspend fun createFileStream(filename: String): FileDescriptor? {
        return try {
            withContext(Dispatchers.IO) {
                FileOutputStream(
                    File(context.filesDir, filename)
                ).fd
            }
        } catch (e: Exception){
            e logThisExceptionWithTag javaClass.simpleName
            null
        }
    }

    override suspend fun getFile(filename: String): File? {
        return try {
            File(context.filesDir, filename)
        } catch (e: Exception){
            e logThisExceptionWithTag javaClass.simpleName
            null
        }
    }

}