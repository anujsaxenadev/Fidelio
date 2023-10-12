package com.wordpress.anujsaxenadev.audiorecorder.ui.theme

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource


sealed class UIText {
    data class DynamicString(
        val value: String,
    ): UIText()
    data class StringResource(
        @StringRes val id: Int,
        val args: List<Any>?= null
    ): UIText()

    fun asString(context: Context): String{
        return when(this){
            is DynamicString -> value
            is StringResource -> {
                if(args != null){
                    context.getString(id, *args.toTypedArray())
                }
                else{
                    context.getString(id)
                }
            }
        }
    }

    @Composable
    fun asString(): String{
        return when(this){
            is DynamicString -> value
            is StringResource -> {
                if(args != null){
                    stringResource(id, args)
                }
                else{
                    stringResource(id)
                }
            }
        }
    }
}