package com.didichuxing.dfbasesdk.logupload2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.dfbasesdk.AppContextHolder;
import com.didichuxing.dfbasesdk.logupload.LogRecord;
import com.didichuxing.dfbasesdk.logupload.UploadObj;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.SPHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class LogInnerTask extends BaseLogTask {

    /* renamed from: f */
    static final String f46637f = "LogInnerTask";

    /* renamed from: n */
    private static LogInnerTask f46638n = new LogInnerTask();

    /* renamed from: g */
    protected final List<LogData> f46639g = new LinkedList();

    /* renamed from: h */
    private final HandlerThread f46640h;

    /* renamed from: i */
    private final Handler f46641i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final C15304a f46642j;

    /* renamed from: k */
    private volatile boolean f46643k;

    /* renamed from: l */
    private boolean f46644l;

    /* renamed from: m */
    private SPHelper f46645m;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f46646o = 0;

    /* renamed from: p */
    private final Runnable f46647p = new Runnable() {
        public void run() {
            if (LogInnerTask.this.f46639g.size() > 0) {
                boolean z = false;
                String str = LogInnerTask.this.f46639g.get(0).url;
                String postKey = LogInnerTask.this.getPostKey(str);
                LogUtils.m33564d(LogInnerTask.f46637f, "repeated upload check, uploadUrl===" + str);
                List a = LogInnerTask.this.m33496b(str);
                if (a != null && !a.isEmpty()) {
                    LogUtils.m33564d(LogInnerTask.f46637f, "schedule upload...");
                    UploadObj buildUploadObj = LogInnerTask.this.buildUploadObj(a, str, postKey);
                    Boolean bool = (Boolean) LogInnerTask.this.encryptMap.get(str);
                    if (bool != null && bool.booleanValue()) {
                        z = true;
                    }
                    String str2 = (String) LogInnerTask.this.versionMap.get(str);
                    if (!TextUtils.isEmpty(str2)) {
                        LogInnerTask.this.f46642j.mo115709a(str, buildUploadObj, postKey, str2);
                    } else {
                        LogInnerTask.this.f46642j.mo115710a(str, buildUploadObj, postKey, z);
                    }
                }
            } else {
                LogInnerTask.this.m33498c();
            }
        }
    };

    public static class LogData {
        public String content;
        public String extra;
        public boolean isUploading;
        public String url;
    }

    /* renamed from: b */
    static /* synthetic */ int m33495b(LogInnerTask logInnerTask) {
        int i = logInnerTask.f46646o;
        logInnerTask.f46646o = i + 1;
        return i;
    }

    private LogInnerTask() {
        HandlerThread handlerThread = new HandlerThread("inner_thread2", 10);
        this.f46640h = handlerThread;
        handlerThread.start();
        InnerHandler innerHandler = new InnerHandler(this.f46640h.getLooper());
        this.f46641i = innerHandler;
        this.f46642j = new C15304a(innerHandler);
        this.f46641i.postDelayed(this.f46647p, 5000);
    }

    /* renamed from: a */
    public static LogInnerTask m33492a() {
        return f46638n;
    }

    /* renamed from: a */
    public void mo115692a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            LogData logData = new LogData();
            logData.url = str;
            logData.content = str2;
            logData.extra = str3;
            Message obtain = Message.obtain(this.f46641i);
            obtain.what = 1;
            obtain.obj = logData;
            obtain.sendToTarget();
        }
    }

    private class InnerHandler extends Handler {
        InnerHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                LogInnerTask.this.f46639g.add((LogData) message.obj);
                LogInnerTask.this.m33498c();
            } else if (message.what == 2) {
                int unused = LogInnerTask.this.f46646o = 0;
                LogUtils.m33564d(LogInnerTask.f46637f, "upload ok, logDataList.size() = " + LogInnerTask.this.f46639g.size());
                List list = (List) message.obj;
                if (list != null) {
                    LogInnerTask.this.f46639g.removeAll(list);
                }
                LogInnerTask.this.m33498c();
            } else if (message.what == 3) {
                LogInnerTask.m33495b(LogInnerTask.this);
                List<LogData> list2 = (List) message.obj;
                if (list2 != null) {
                    for (LogData logData : list2) {
                        logData.isUploading = false;
                    }
                }
                LogInnerTask.this.m33498c();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m33498c() {
        if (!this.f46642j.mo115711a()) {
            if (this.f46646o >= 3) {
                if (this.f46639g.size() > 0) {
                    mo115693b();
                }
            } else if (this.f46639g.size() >= 15 && this.f46646o <= 0) {
                this.f46641i.removeCallbacks(this.f46647p);
                this.f46647p.run();
            } else if (!this.f46641i.hasCallbacks(this.f46647p)) {
                this.f46641i.postDelayed(this.f46647p, 10000);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public List<LogRecord> m33496b(String str) {
        String str2;
        if (this.f46639g.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (LogData next : this.f46639g) {
            if (!next.isUploading && (str2 = next.url) != null && str2.equals(str)) {
                arrayList.add(new LogRecord(next, next.content, 0, 0));
                next.isUploading = true;
                if (arrayList.size() >= 15) {
                    break;
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public void mo115693b() {
        if (this.f46639g.size() > 0) {
            for (int size = this.f46639g.size() - 1; size >= 0; size--) {
                LogData logData = this.f46639g.get(size);
                if (!logData.isUploading) {
                    SystemUtils.log(3, "martin", "dumLogToDB ...............", (Throwable) null, "com.didichuxing.dfbasesdk.logupload2.LogInnerTask", 204);
                    LogDBTask.m33469b().mo115672a(logData.url, logData.content, logData.extra);
                    this.f46639g.remove(logData);
                }
            }
            LogReporter2.saveDBStatus(true);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo115691a(String str) {
        if (this.f46645m == null) {
            synchronized (LogInnerTask.class) {
                if (this.f46645m == null) {
                    this.f46645m = new SPHelper(AppContextHolder.getAppContext(), "access_security_sp");
                }
            }
        }
        String str2 = "log_number_" + str;
        int intValue = ((Integer) this.f46645m.get(str2, 0)).intValue();
        this.f46645m.put(str2, Integer.valueOf(intValue + 1)).apply();
        return intValue;
    }
}
