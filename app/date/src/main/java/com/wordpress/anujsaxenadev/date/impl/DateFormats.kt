package com.wordpress.anujsaxenadev.date.impl

sealed class DateFormats(val format: String){
    data object DDMMMYYHHMMSS: DateFormats("dd-MMM-yy|HH-mm-ss")
}