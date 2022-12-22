package com.didichuxing.omega.p195nc;

import android.os.Looper;
import android.text.TextUtils;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didichuxing.omega.nc.NativeCapture */
public class NativeCapture {
    private static final String TAG = "omegasdk";
    private static OnNativeCrashCallBack onNativeExceptionCallBack;

    /* renamed from: com.didichuxing.omega.nc.NativeCapture$OnNativeCrashCallBack */
    public interface OnNativeCrashCallBack {
        void exception(boolean z, String str, String str2, String str3);
    }

    private static native void init(String str);

    public static native void makeCrash();

    static {
        System.loadLibrary(Constants.FILE_NATIVE_CRASH_KEY);
    }

    public static void initNativeCapture(String str) {
        init(str);
    }

    public static void setOnNativeExceptionCallBack(OnNativeCrashCallBack onNativeCrashCallBack) {
        onNativeExceptionCallBack = onNativeCrashCallBack;
    }

    private static void nativeException(String str, String str2, byte[] bArr, boolean z) {
        String str3 = new String(bArr);
        if (z) {
            str3 = Looper.getMainLooper().getThread().getName();
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
        }
        List<Thread> threadListByName = getThreadListByName(str3);
        if (threadListByName.isEmpty()) {
            threadListByName.addAll(getAllThreadList());
        }
        StringBuilder sb = new StringBuilder(str2);
        for (Thread threadInfo : threadListByName) {
            sb.append("Caused by: java.lang.Error: java stack\n");
            sb.append(" at ");
            sb.append(getThreadInfo(threadInfo));
            sb.append("\n");
        }
        OnNativeCrashCallBack onNativeCrashCallBack = onNativeExceptionCallBack;
        if (onNativeCrashCallBack != null) {
            onNativeCrashCallBack.exception(z, str3, str, sb.toString());
        }
    }

    public static String getThreadInfo(Thread thread) {
        StringBuilder sb = new StringBuilder(2048);
        if (thread != null) {
            try {
                sb.append("threadId: ");
                sb.append(thread.getId());
                sb.append("\n");
                sb.append("name: ");
                sb.append(thread.getName());
                sb.append("\n");
                sb.append("priority: ");
                sb.append(thread.getPriority());
                sb.append("\n");
                if (thread.getThreadGroup() != null) {
                    sb.append("groupName: ");
                    sb.append(thread.getThreadGroup().getName());
                    sb.append("\n");
                }
                sb.append("state: ");
                sb.append(thread.getState());
                sb.append("\n");
                sb.append("stacktrace: \n");
                for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
                    sb.append("\tat ");
                    sb.append(stackTraceElement.getMethodName());
                    sb.append("(");
                    sb.append(stackTraceElement.getFileName());
                    sb.append(":");
                    sb.append(stackTraceElement.getLineNumber());
                    sb.append(")\n");
                }
            } catch (Exception unused) {
                return sb.toString();
            } catch (Throwable unused2) {
                return sb.toString();
            }
        }
        return sb.toString();
    }

    private static List<Thread> getAllThreadList() {
        return new ArrayList(Thread.getAllStackTraces().keySet());
    }

    private static List<Thread> getThreadListByName(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (Thread next : Thread.getAllStackTraces().keySet()) {
                if (next.getName().contains(str)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }
}
