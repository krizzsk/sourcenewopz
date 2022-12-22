package com.didi.dimina.container.secondparty.trace.inner;

import android.util.Log;
import com.didi.dimina.container.secondparty.trace.inner.net.LogNetManager;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TextUtil;
import com.tencent.mmkv.MMKV;
import java.util.LinkedList;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010H\u0002J\b\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/trace/inner/LogFileSendThread;", "Ljava/lang/Thread;", "()V", "FIRST_TIME_GAP", "", "TAG", "", "isUploading", "", "()Z", "setUploading", "(Z)V", "printException", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "run", "sendEvent", "fileName", "startSend", "wakeUp", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: LogFileSendThread.kt */
public final class LogFileSendThread extends Thread {
    public static final LogFileSendThread INSTANCE = new LogFileSendThread();
    public static final String TAG = "LogFileSendThread";

    /* renamed from: a */
    private static volatile boolean f17465a = false;

    /* renamed from: b */
    private static final long f17466b = 7000;

    private LogFileSendThread() {
        super("DMTraceInnerLogFileSendThread");
    }

    public final boolean isUploading() {
        return f17465a;
    }

    public final void setUploading(boolean z) {
        f17465a = z;
    }

    public final void wakeUp() {
        if (f17465a) {
            LogUtil.iRelease(TAG, "is uploading");
        } else {
            interrupt();
        }
    }

    public final void startSend() {
        try {
            if (!isAlive()) {
                start();
            }
        } catch (Exception e) {
            LogUtil.eRelease(TAG, "got an exception " + Log.getStackTraceString(e));
        }
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(f17466b);
            } catch (Exception e) {
                m12984a(e);
            }
            f17465a = true;
            m12983a();
            f17465a = false;
        }
    }

    /* renamed from: a */
    private final void m12984a(Exception exc) {
        if (exc instanceof InterruptedException) {
            LogUtil.iRelease(TAG, "this thread is wake up");
            return;
        }
        LogUtil.eRelease(TAG, "got an exception " + Log.getStackTraceString(exc));
    }

    /* renamed from: a */
    private final void m12983a() {
        LogUtil.iRelease(TAG, "check logs to send");
        String[] allMkKey = LogCollectThread.INSTANCE.getAllMkKey();
        if (allMkKey != null) {
            if (!(allMkKey.length == 0)) {
                if (TextUtil.isEmpty(LogManager.INSTANCE.getUniqueId())) {
                    LogNetManager.INSTANCE.getConfig();
                    return;
                }
                for (String str : allMkKey) {
                    if (str != null) {
                        INSTANCE.m12985a(str);
                    }
                }
                return;
            }
        }
        LogUtil.iRelease(TAG, "empty logs ");
    }

    /* renamed from: a */
    private final void m12985a(String str) {
        MMKV mmkv = null;
        try {
            mmkv = MMKV.mmkvWithID(str, LogManager.INSTANCE.getMRecordDataPath());
            String[] allKeys = mmkv != null ? mmkv.allKeys() : null;
            LinkedList linkedList = new LinkedList();
            if (allKeys != null) {
                for (String decodeString : allKeys) {
                    String decodeString2 = mmkv != null ? mmkv.decodeString(decodeString) : null;
                    if (decodeString2 != null) {
                        JSONObject jSONObject = new JSONObject(decodeString2);
                        if (TextUtil.isEmpty(jSONObject.optString(LogBase.KEY_UNION_ID))) {
                            jSONObject.put(LogBase.KEY_UNION_ID, LogManager.INSTANCE.getUniqueId());
                        }
                        linkedList.add(jSONObject);
                    }
                }
            }
            if (linkedList.size() > 0) {
                LogNetManager.send(LogManager.INSTANCE.getBundleLogs(str, linkedList));
                if (mmkv == null) {
                    return;
                }
                mmkv.close();
            } else if (mmkv != null) {
                mmkv.close();
            }
        } catch (Exception e) {
            LogUtil.eRelease(TAG, "got an exception:" + Log.getStackTraceString(e));
            if (mmkv == null) {
            }
        } catch (Throwable th) {
            if (mmkv != null) {
                mmkv.close();
            }
            throw th;
        }
    }
}
