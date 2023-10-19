package com.wordpress.anujsaxenadev.file_manager.impl

import android.content.Context
import com.wordpress.anujsaxenadev.logger.impl.LogType
import com.wordpress.anujsaxenadev.logger.impl.Logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileDescriptor
import java.io.FileOutputStream

class AndroidFileManager(
    private val context: Context,
    private val logger: Logger
) : FileManager {

    override suspend fun getInternalFilesList() : Array<String>{
        return try {
            context.fileList()
        } catch (e: Exception){
            logger.log(LogType.LOGCAT, this.javaClass.name, e)
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
            logger.log(LogType.LOGCAT, this.javaClass.name, e)
            null
        }
    }

    override suspend fun getFile(filename: String): File? {
        return try {
            File(context.filesDir, filename)
        } catch (e: Exception){
            logger.log(LogType.LOGCAT, this.javaClass.name, e)
            null
        }
    }

}