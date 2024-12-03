package com.baczek.movienight.utils

import android.util.Log

private const val TAG = "UI_DEBUG"

fun debug(message: () -> String) = Log.d(TAG, message())