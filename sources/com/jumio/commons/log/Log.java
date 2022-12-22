package com.jumio.commons.log;

import android.graphics.Bitmap;
import java.io.File;

public class Log {
    public static final String TAG = "JumioMobileSDK";

    public enum LogLevel {
        OFF,
        VERBOSE,
        DEBUG,
        INFO,
        WARN,
        ERROR
    }

    public static void allowFileLogging(boolean z) {
    }

    /* renamed from: d */
    public static void m39454d(String str) {
    }

    /* renamed from: d */
    public static void m39455d(String str, File file, String str2) {
    }

    /* renamed from: d */
    public static void m39456d(String str, String str2) {
    }

    /* renamed from: d */
    public static void m39457d(String str, String str2, Throwable th) {
    }

    /* renamed from: d */
    public static void m39458d(String str, Throwable th) {
    }

    public static void data(byte[] bArr, File file, String str) {
    }

    /* renamed from: e */
    public static void m39459e(String str) {
    }

    /* renamed from: e */
    public static void m39460e(String str, File file, String str2) {
    }

    /* renamed from: e */
    public static void m39461e(String str, String str2) {
    }

    /* renamed from: e */
    public static void m39462e(String str, String str2, Throwable th) {
    }

    /* renamed from: e */
    public static void m39463e(String str, Throwable th) {
    }

    public static LogLevel getLogLevel() {
        return LogLevel.OFF;
    }

    /* renamed from: i */
    public static void m39464i(String str) {
    }

    /* renamed from: i */
    public static void m39465i(String str, File file, String str2) {
    }

    /* renamed from: i */
    public static void m39466i(String str, String str2) {
    }

    /* renamed from: i */
    public static void m39467i(String str, String str2, Throwable th) {
    }

    /* renamed from: i */
    public static void m39468i(String str, Throwable th) {
    }

    public static void image(Bitmap bitmap, File file, String str) {
    }

    public static void image(Bitmap bitmap, File file, String str, Bitmap.CompressFormat compressFormat, int i) {
    }

    public static boolean isFileLoggingActivated() {
        return false;
    }

    public static boolean isLogEnabledForLevel(LogLevel logLevel) {
        return false;
    }

    public static void printStackTrace(Throwable th) {
    }

    public static void setLogLevel(LogLevel logLevel) {
    }

    /* renamed from: v */
    public static void m39469v(String str) {
    }

    /* renamed from: v */
    public static void m39470v(String str, File file, String str2) {
    }

    /* renamed from: v */
    public static void m39471v(String str, String str2) {
    }

    /* renamed from: v */
    public static void m39472v(String str, String str2, Throwable th) {
    }

    /* renamed from: v */
    public static void m39473v(String str, Throwable th) {
    }

    /* renamed from: w */
    public static void m39474w(String str) {
    }

    /* renamed from: w */
    public static void m39475w(String str, File file, String str2) {
    }

    /* renamed from: w */
    public static void m39476w(String str, String str2) {
    }

    /* renamed from: w */
    public static void m39477w(String str, String str2, Throwable th) {
    }

    /* renamed from: w */
    public static void m39478w(String str, Throwable th) {
    }
}
