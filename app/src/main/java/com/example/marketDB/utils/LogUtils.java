package com.example.marketDB.utils;

import android.util.Log;

public class LogUtils {
    static final String LOG_TAG = "TEST_ISSUE_SQL_LITE";
    final String FILENAME = "file";

    public static void log(String log) {
        Log.d(LOG_TAG, log);
    }

    public static void logError(String text, Throwable t) {
        Log.e(LOG_TAG, text, t);
    }
}
