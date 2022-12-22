package com.didichuxing.dfbasesdk.crash;

import android.content.Context;
import java.lang.Thread;

public class ThreadUncaughtExceptionHandler {
    public static void setDefaultUncaughtExceptionHandler(final Context context, final String str, final UncaughtExceptionHandlerAndUpload uncaughtExceptionHandlerAndUpload) {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread thread, Throwable th) {
                UploadService.startService(context, str, uncaughtExceptionHandlerAndUpload.getUploadJson(th));
                uncaughtExceptionHandlerAndUpload.uncaughtException(thread, th);
            }
        });
    }
}
