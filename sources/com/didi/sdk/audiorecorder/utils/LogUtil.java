package com.didi.sdk.audiorecorder.utils;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.audiorecorder.AudioRecordManager;
import com.didi.sdk.audiorecorder.utils.log.LogService;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class LogUtil {

    /* renamed from: a */
    private static final String f35578a = "LogUtil -> ";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static boolean f35579b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static boolean f35580c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static Context f35581d;

    /* renamed from: e */
    private static String f35582e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static File f35583f;

    /* renamed from: g */
    private static final Executor f35584g = Executors.newSingleThreadExecutor(new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("didi-recorder-logger");
            thread.setPriority(1);
            return thread;
        }
    });

    public static void init(Context context, boolean z) {
        f35581d = context.getApplicationContext();
        f35580c = z;
        f35584g.execute(new Runnable() {
            public void run() {
                boolean unused = LogUtil.f35579b = AudioRecordManager.isRecordProcess(LogUtil.f35581d);
                File unused2 = LogUtil.f35583f = C12122a.m25180a(LogUtil.f35581d);
                LogUtil.log("LogUtil -> init : sRecordProcessFlag = " + LogUtil.f35579b, ", isDebuggable = " + LogUtil.f35580c + ", sLogDir = " + LogUtil.f35583f);
            }
        });
    }

    public static File getLogDir() {
        try {
            if (!f35583f.exists()) {
                f35583f.mkdirs();
            }
            return f35583f;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void updateUserPhone(String str) {
        f35582e = str;
    }

    public static String getUserPhone() {
        return f35582e;
    }

    public static boolean isDebuggable() {
        return f35580c;
    }

    public static void log(final String... strArr) {
        f35584g.execute(new Runnable() {
            public void run() {
                StringBuilder sb = new StringBuilder();
                for (String append : strArr) {
                    sb.append(append);
                }
                String sb2 = sb.toString();
                if (LogUtil.f35579b) {
                    LogService.log2sd4RecordService(sb2);
                } else {
                    LogService.log2sd4Record(sb2);
                }
                if (LogUtil.f35580c) {
                    LogService.getInstance().mo91274d(LogUtil.f35578a, sb2);
                }
            }
        });
    }

    public static void log(final String str) {
        f35584g.execute(new Runnable() {
            public void run() {
                if (LogUtil.f35579b) {
                    LogService.log2sd4RecordService(str);
                } else {
                    LogService.log2sd4Record(str);
                }
                if (LogUtil.f35580c) {
                    LogService.getInstance().mo91274d(LogUtil.f35578a, str);
                }
            }
        });
    }

    public static void log(final String str, final Throwable th) {
        m25179e();
        f35584g.execute(new Runnable() {
            public void run() {
                if (LogUtil.f35579b) {
                    LogService.log2sd4RecordService(LogUtil.f35581d, str, th);
                } else {
                    LogService.log2sd4Record(LogUtil.f35581d, str, th);
                }
                if (LogUtil.f35580c) {
                    LogService.getInstance().mo91273d(LogUtil.f35581d, LogUtil.f35578a, str, th);
                }
            }
        });
    }

    public static void logD(String str, String str2) {
        if (str != null && str2 != null && f35580c) {
            SystemUtils.log(3, str, str2, (Throwable) null, "com.didi.sdk.audiorecorder.utils.LogUtil", 132);
        }
    }

    /* renamed from: e */
    private static void m25179e() {
        if (f35581d == null) {
            throw new IllegalStateException("Please invoke init method first.");
        }
    }
}
