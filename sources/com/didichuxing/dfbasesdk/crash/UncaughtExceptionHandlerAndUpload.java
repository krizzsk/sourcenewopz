package com.didichuxing.dfbasesdk.crash;

import java.lang.Thread;

public interface UncaughtExceptionHandlerAndUpload extends Thread.UncaughtExceptionHandler {
    String getUploadJson(Throwable th);
}
