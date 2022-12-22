package com.didichuxing.dfbasesdk.logupload2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.didichuxing.dfbasesdk.AppContextHolder;
import com.didichuxing.dfbasesdk.logupload.LogRecord;
import com.didichuxing.dfbasesdk.logupload.UploadObj;
import com.didichuxing.dfbasesdk.logupload2.LogDbHelper2;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import java.util.List;

class LogDBTask extends BaseLogTask {

    /* renamed from: f */
    static final String f46618f = "LogUpload2";

    /* renamed from: m */
    private static LogDBTask f46619m = new LogDBTask();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final LogDbHelper2 f46620g = new LogDbHelper2(AppContextHolder.getAppContext());

    /* renamed from: h */
    private final HandlerThread f46621h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final Handler f46622i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final C15304a f46623j;

    /* renamed from: k */
    private volatile boolean f46624k;

    /* renamed from: l */
    private boolean f46625l;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f46626n = 0;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final Runnable f46627o = new Runnable() {
        public void run() {
            LogUtils.m33564d(LogDBTask.f46618f, "uploadRunnable execute, failTimes=" + LogDBTask.this.f46626n);
            if (LogDBTask.this.f46626n < 3) {
                String b = LogDBTask.this.f46620g.mo115680b();
                if (TextUtils.isEmpty(b)) {
                    b = LogDBTask.this.activeUrl;
                }
                String postKey = LogDBTask.this.getPostKey(b);
                LogUtils.m33564d(LogDBTask.f46618f, "repeated upload check, uploadUrl===" + b);
                List<LogRecord> b2 = LogDBTask.this.f46620g.mo115681b(b);
                if (b2 != null && !b2.isEmpty()) {
                    LogUtils.m33564d(LogDBTask.f46618f, "schedule upload...");
                    UploadObj buildUploadObj = LogDBTask.this.buildUploadObj(b2, b, postKey);
                    Boolean bool = (Boolean) LogDBTask.this.encryptMap.get(b);
                    boolean z = bool != null && bool.booleanValue();
                    String str = (String) LogDBTask.this.versionMap.get(b);
                    if (!TextUtils.isEmpty(str)) {
                        LogDBTask.this.f46623j.mo115709a(b, buildUploadObj, postKey, str);
                    } else {
                        LogDBTask.this.f46623j.mo115710a(b, buildUploadObj, postKey, z);
                    }
                    LogDBTask.this.f46620g.mo115682b(buildUploadObj.ids);
                }
            }
        }
    };

    /* renamed from: d */
    static /* synthetic */ int m33472d(LogDBTask logDBTask) {
        int i = logDBTask.f46626n;
        logDBTask.f46626n = i + 1;
        return i;
    }

    private LogDBTask() {
        HandlerThread handlerThread = new HandlerThread("db_thread2", 10);
        this.f46621h = handlerThread;
        handlerThread.start();
        DbHandler dbHandler = new DbHandler(this.f46621h.getLooper());
        this.f46622i = dbHandler;
        this.f46623j = new C15304a(dbHandler);
    }

    /* renamed from: a */
    public void mo115671a() {
        Handler handler = this.f46622i;
        if (handler != null) {
            handler.postDelayed(this.f46627o, 5000);
        }
    }

    /* renamed from: b */
    public static LogDBTask m33469b() {
        return f46619m;
    }

    /* renamed from: a */
    public void mo115672a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            this.activeUrl = str;
            Message obtain = Message.obtain(this.f46622i);
            obtain.what = 1;
            obtain.obj = new LogDbHelper2.DbRecord(str, str2, str3);
            obtain.sendToTarget();
        }
    }

    private class DbHandler extends Handler {
        DbHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                long a = LogDBTask.this.f46620g.mo115677a((LogDbHelper2.DbRecord) message.obj);
                LogUtils.m33564d(LogDBTask.f46618f, "insert ok, id=" + a);
            } else if (message.what == 2) {
                LogUtils.m33564d(LogDBTask.f46618f, "upload ok, del ids=" + message.obj);
                int unused = LogDBTask.this.f46626n = 0;
                if (LogDBTask.this.f46620g.mo115676a((List<String>) (List) message.obj) > 0) {
                    LogDBTask.this.f46622i.postDelayed(LogDBTask.this.f46627o, 3000);
                }
            } else if (message.what == 3) {
                LogUtils.m33564d(LogDBTask.f46618f, "upload failed, ids=" + message.obj);
                LogDBTask.m33472d(LogDBTask.this);
                LogDBTask.this.f46620g.mo115684c((List) message.obj);
                LogDBTask.this.f46622i.postDelayed(LogDBTask.this.f46627o, 10000);
            }
        }
    }

    /* renamed from: b */
    public void mo115673b(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            this.activeUrl = str;
            Message obtain = Message.obtain(this.f46622i);
            obtain.what = 1;
            obtain.obj = new LogDbHelper2.DbRecord(str, str2, str3);
            obtain.sendToTarget();
        }
    }
}
