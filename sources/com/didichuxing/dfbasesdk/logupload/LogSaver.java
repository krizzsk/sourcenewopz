package com.didichuxing.dfbasesdk.logupload;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.didichuxing.dfbasesdk.utils.CheckUtils;
import com.didichuxing.dfbasesdk.utils.DFApi;
import com.didichuxing.dfbasesdk.utils.GsonUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LogSaver {
    public static final int MSG_SAVE_LOG = 1;
    public static final int MSG_UPLOAD_FAIL = 3;
    public static final int MSG_UPLOAD_OK = 2;

    /* renamed from: a */
    private static final long f46591a = 5000;

    /* renamed from: b */
    private static final long f46592b = 20000;

    /* renamed from: l */
    private static LogSaver f46593l = new LogSaver();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public volatile LogDbHelper f46594c;

    /* renamed from: d */
    private HandlerThread f46595d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Handler f46596e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public LogUploader f46597f;

    /* renamed from: g */
    private volatile boolean f46598g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public volatile boolean f46599h;

    /* renamed from: i */
    private boolean f46600i;

    /* renamed from: j */
    private volatile String f46601j;

    /* renamed from: k */
    private volatile String f46602k;

    /* renamed from: m */
    private final Runnable f46603m = new Runnable() {
        public void run() {
            LogUtils.m33564d(LogRecord.LOG_TAG, "repeated upload check...");
            List<LogRecord> c = LogSaver.this.f46594c.mo115640c();
            if (!c.isEmpty()) {
                List a = LogSaver.this.m33449a(c);
                if (!a.isEmpty()) {
                    LogUtils.m33564d(LogRecord.LOG_TAG, "send upload msg...");
                    Message obtain = Message.obtain(LogSaver.this.f46597f.mo115662a());
                    obtain.what = 1;
                    obtain.obj = LogSaver.this.m33454b((List<LogRecord>) a);
                    obtain.sendToTarget();
                    LogSaver.this.f46594c.mo115635a();
                    return;
                }
                LogUtils.m33564d(LogRecord.LOG_TAG, "remainings are all uploading logs...");
            }
        }
    };

    /* renamed from: n */
    private final Runnable f46604n = new Runnable() {
        public void run() {
            LogUtils.m33564d(LogRecord.LOG_TAG, "repeated upload check...");
            List<LogRecord> b = LogSaver.this.f46594c.mo115637b();
            if (!b.isEmpty()) {
                LogUtils.m33564d(LogRecord.LOG_TAG, "schedule upload...");
                Message obtain = Message.obtain(LogSaver.this.f46597f.mo115662a());
                obtain.what = 1;
                UploadObj b2 = LogSaver.this.m33454b(b);
                obtain.obj = b2;
                obtain.sendToTarget();
                LogSaver.this.f46594c.mo115639b(b2.ids);
            }
            if (LogSaver.this.f46599h) {
                LogUtils.m33564d(LogRecord.LOG_TAG, "schedule exit in 20s...");
                if (LogSaver.this.f46596e != null) {
                    LogSaver.this.f46596e.postDelayed(LogSaver.this.f46605o, 20000);
                    return;
                }
                return;
            }
            LogUtils.m33564d(LogRecord.LOG_TAG, "schedule next check...");
            if (LogSaver.this.f46596e != null) {
                LogSaver.this.f46596e.postDelayed(this, 5000);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final Runnable f46605o = new Runnable() {
        public void run() {
            LogSaver.this.m33455b();
        }
    };

    public static LogSaver getInstance() {
        return f46593l;
    }

    public void onEnter(Context context, String str, String str2) {
        LogUtils.m33564d(LogRecord.LOG_TAG, "onEnter, mInited=" + this.f46600i);
        this.f46599h = false;
        this.f46598g = false;
        if (!this.f46600i) {
            m33451a(context, str2);
            this.f46600i = true;
        } else {
            Handler handler = this.f46596e;
            if (handler != null) {
                handler.removeCallbacks(this.f46605o);
                this.f46596e.removeCallbacks(this.f46604n);
            }
        }
        this.f46601j = str;
    }

    public void setSdkVer(String str) {
        this.f46602k = str;
    }

    public void onEnter(Context context, String str, String str2, String str3) {
        LogUtils.m33564d(LogRecord.LOG_TAG, "onEnter, mInited=" + this.f46600i);
        this.f46599h = false;
        this.f46598g = false;
        if (!this.f46600i) {
            m33452a(context, str, str3);
            this.f46600i = true;
        } else {
            Handler handler = this.f46596e;
            if (handler != null) {
                handler.removeCallbacks(this.f46605o);
                this.f46596e.removeCallbacks(this.f46604n);
            }
        }
        this.f46601j = str2;
    }

    /* renamed from: a */
    private void m33452a(Context context, String str, String str2) {
        this.f46594c = new LogDbHelper(context, str);
        HandlerThread handlerThread = new HandlerThread("db_thread", 10);
        this.f46595d = handlerThread;
        handlerThread.start();
        DbHandler dbHandler = new DbHandler(this.f46595d.getLooper());
        this.f46596e = dbHandler;
        this.f46597f = new LogUploader(dbHandler, str2);
    }

    /* renamed from: a */
    private void m33451a(Context context, String str) {
        this.f46594c = new LogDbHelper(context);
        HandlerThread handlerThread = new HandlerThread("db_thread", 10);
        this.f46595d = handlerThread;
        handlerThread.start();
        DbHandler dbHandler = new DbHandler(this.f46595d.getLooper());
        this.f46596e = dbHandler;
        this.f46597f = new LogUploader(dbHandler, str);
    }

    public void setSessionId(String str) {
        this.f46601j = str;
    }

    public void save(LoggerParam loggerParam) {
        save(GsonUtils.toJsonStr(loggerParam));
    }

    public <T> void save(T t) {
        save(GsonUtils.toJsonStr(t));
    }

    public void syncSave(LoggerParam loggerParam) {
        this.f46594c.mo115634a(GsonUtils.toJsonStr(loggerParam));
    }

    public <T> void syncSave(T t) {
        this.f46594c.mo115634a(GsonUtils.toJsonStr(t));
    }

    public void syncSave(String str) {
        this.f46594c.mo115634a(str);
    }

    public void uploadOnce() {
        this.f46596e.postDelayed(this.f46603m, 5000);
    }

    public void save(String str) {
        Handler handler = this.f46596e;
        if (handler != null) {
            Message obtain = Message.obtain(handler);
            obtain.what = 1;
            obtain.obj = str;
            obtain.sendToTarget();
        }
    }

    private class DbHandler extends Handler {
        DbHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (LogSaver.this.f46594c != null) {
                if (message.what == 1) {
                    long a = LogSaver.this.f46594c.mo115634a((String) message.obj);
                    LogUtils.m33564d(LogRecord.LOG_TAG, "insert ok, id=" + a);
                    LogSaver.this.m33450a();
                } else if (message.what == 2) {
                    LogUtils.m33564d(LogRecord.LOG_TAG, "upload ok, del ids=" + message.obj);
                    LogSaver.this.f46594c.mo115636a((List<String>) (List) message.obj);
                } else if (message.what == 3) {
                    LogUtils.m33564d(LogRecord.LOG_TAG, "upload failed, ids=" + message.obj);
                    LogSaver.this.f46594c.mo115641c((List) message.obj);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33450a() {
        if (!this.f46598g) {
            Handler handler = this.f46596e;
            if (handler != null) {
                handler.postDelayed(this.f46604n, 5000);
            }
            this.f46598g = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public List<LogRecord> m33449a(List<LogRecord> list) {
        ArrayList arrayList = new ArrayList();
        for (LogRecord next : list) {
            if (next.isNeedUpload()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public UploadObj m33454b(List<LogRecord> list) {
        UploadObj uploadObj = new UploadObj();
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (LogRecord next : list) {
                uploadObj.ids.add(next.f46590id);
                jSONArray.put(new JSONObject(next.content));
            }
            jSONObject.put("jsonArray", jSONArray);
            jSONObject.put("sessionId", this.f46601j);
            jSONObject.put("extra", DFApi.getCommonExtra(this.f46602k));
            uploadObj.jsonBody = jSONObject.toString();
        } catch (JSONException e) {
            LogUtils.logStackTrace(e);
        }
        return uploadObj;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m33455b() {
        LogUtils.m33564d(LogRecord.LOG_TAG, "exit sdk uninit");
        CheckUtils.checkAssert(this.f46600i, "mInited is false, should be true!!!");
        if (this.f46600i) {
            this.f46597f = null;
            HandlerThread handlerThread = this.f46595d;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            this.f46595d = null;
            this.f46596e = null;
            this.f46594c.mo115642d();
            this.f46594c = null;
            this.f46600i = false;
        }
    }

    public void onExit() {
        this.f46599h = true;
    }
}
