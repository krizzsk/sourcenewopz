package com.didi.sdk.audiorecorder.utils.log;

import android.content.Context;

public final class LogService {
    public static LogService getInstance() {
        return Singleton.INSTANCE;
    }

    private LogService() {
    }

    /* renamed from: d */
    public void mo91274d(String str, String str2) {
        XJLog.m25199a(str, str2);
    }

    /* renamed from: d */
    public void mo91273d(Context context, String str, String str2, Throwable th) {
        XJLog.m25195a(context, str, str2, th);
    }

    public static void log2sd4Record(String str) {
        XJLog.m25198a(str);
    }

    public static void log2sd4Record(Context context, String str, Throwable th) {
        XJLog.m25196a(context, str, th);
    }

    public static void log2sd4RecordService(String str) {
        XJLog.m25201b(str);
    }

    public static void log2sd4RecordService(Context context, String str, Throwable th) {
        XJLog.m25200b(context, str, th);
    }

    public void changeFileName(String str, String str2) {
        XJLog.m25204c(str, str2);
    }

    public void delete() {
        XJLog.m25193a();
    }

    private static final class Singleton {
        static final LogService INSTANCE = new LogService();

        private Singleton() {
        }
    }
}
