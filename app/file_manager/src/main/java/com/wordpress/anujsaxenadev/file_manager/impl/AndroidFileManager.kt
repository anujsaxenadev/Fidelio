package com.wordpress.anujsaxenadev.file_manager.impl

import android.content.Context
import com.wordpress.anujsaxenadev.file_manager.FileManager
import com.wordpress.anujsaxenadev.logger.Logger
import com.wordpress.anujsaxenadev.logger.helpers.tag
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileDescriptor
import java.io.FileOutputStream
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AndroidFileManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val logger: Logger
) : FileManager,
    Logger by logger {
    override suspend fun getInternalFilesList() : Array<String>{
        return try {
            context.fileList()
        } catch (e: Exception){
            e logThisExceptionWithTag tag
            arrayOf()
        }
    }

    override suspend fun createInternalFileStream(filename: String): FileDescriptor? {
        return try {
            withContext(Dispatchers.IO) {
                FileOutputStream(
                    File(context.filesDir, filename)
                ).fd
            }
        } catch (e: Exception){
            e logThisExceptionWithTag tag
            null
        }
    }

    override suspend fun getInternalFile(filename: String): File? {
        return try {
            File(context.filesDir, filename)
        } catch (e: Exception){
            e logThisExceptionWithTag tag
            null
        }
    }

}