package com.wordpress.anujsaxenadev.audiorecorder.date.impl

sealed class DateFormats(val format: String){
    object DD_MM_YYYY_HH_MM_SS: DateFormats("dd-MMM-yy|HH-mm-ss")
}