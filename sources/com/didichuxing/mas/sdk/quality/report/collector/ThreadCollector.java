package com.didichuxing.mas.sdk.quality.report.collector;

import android.os.Process;
import android.text.TextUtils;
import com.datadog.android.rum.internal.ndk.NdkCrashLog;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;

public class ThreadCollector {
    public static String[] sIgnoredThreadWhiteList = {"FinalizerWatchdogDaemon", "HeapTaskDaemon", "FinalizerDaemon", "ReferenceQueueDaemon", "Signal Catcher", "AudioThread", "SoundPool", "SoundPoolThread", "^Chrome_.*", "^Binder:.*", "^Jit thread pool worker thread .*"};

    public static String getThreadInfo(Thread thread, StackTraceElement[] stackTraceElementArr) {
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
                if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
                    for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                        sb.append("\tat ");
                        sb.append(stackTraceElement.getMethodName());
                        sb.append("(");
                        sb.append(stackTraceElement.getFileName());
                        sb.append(":");
                        sb.append(stackTraceElement.getLineNumber());
                        sb.append(")\n");
                    }
                }
            } catch (Exception e) {
                OLog.m34418e("getThreadInfo Error:" + e.getMessage());
                return sb.toString();
            } catch (Throwable unused) {
                return sb.toString();
            }
        }
        return sb.toString();
    }

    public static String getAllThreadStacks() {
        return getAllThreadStacks(false, new String[0]);
    }

    public static String getAllThreadStacks(boolean z, String... strArr) {
        StringBuilder sb = new StringBuilder(2048);
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            ArrayList arrayList = null;
            if (z) {
                arrayList = new ArrayList();
                if (strArr != null && strArr.length > 0) {
                    arrayList.addAll(Arrays.asList(strArr));
                }
                arrayList.addAll(Arrays.asList(sIgnoredThreadWhiteList));
            }
            for (Map.Entry next : allStackTraces.entrySet()) {
                Thread thread = (Thread) next.getKey();
                String name = thread.getName();
                if (z && name != null) {
                    boolean z2 = false;
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (name.matches((String) it.next())) {
                                z2 = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (z2) {
                    }
                }
                sb.append(getThreadInfo(thread, (StackTraceElement[]) next.getValue()));
                sb.append("\n");
            }
        } catch (Exception e) {
            OLog.m34418e(e.getMessage());
        }
        return sb.toString();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:2|3|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001f, code lost:
        com.didichuxing.mas.sdk.quality.report.utils.OLog.m34418e(r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return java.lang.Thread.getAllStackTraces().size();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getCurrentThreadCount() {
        /*
            android.os.Looper r0 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x0015 }
            java.lang.Thread r0 = r0.getThread()     // Catch:{ Exception -> 0x0015 }
            java.lang.ThreadGroup r0 = r0.getThreadGroup()     // Catch:{ Exception -> 0x0015 }
            java.lang.ThreadGroup r0 = r0.getParent()     // Catch:{ Exception -> 0x0015 }
            int r0 = r0.activeCount()     // Catch:{ Exception -> 0x0015 }
            goto L_0x0027
        L_0x0015:
            java.util.Map r0 = java.lang.Thread.getAllStackTraces()     // Catch:{ Exception -> 0x001e }
            int r0 = r0.size()     // Catch:{ Exception -> 0x001e }
            goto L_0x0027
        L_0x001e:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.didichuxing.mas.sdk.quality.report.utils.OLog.m34418e(r0)
            r0 = 0
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.report.collector.ThreadCollector.getCurrentThreadCount():int");
    }

    public static int getSysThreadCountLimit() {
        File file = new File("/proc/sys/kernel/threads-max");
        if (!file.exists() || !file.canRead()) {
            return -1;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            String readLine = new BufferedReader(new InputStreamReader(fileInputStream)).readLine();
            fileInputStream.close();
            return Integer.valueOf(readLine).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static Map<String, Object> getCurrentFDList() {
        HashMap hashMap = new HashMap();
        try {
            File file = new File("/proc/" + Process.myPid() + "/fd");
            if (file.exists() && file.isDirectory() && file.canRead()) {
                for (File file2 : file.listFiles()) {
                    hashMap.put(file2.getName(), file2.getCanonicalPath());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    public static int getSysFdCountLimit() {
        FileInputStream fileInputStream;
        Exception e;
        File file = new File("/proc/" + Process.myPid() + "/limits");
        if (!file.exists() || !file.canRead()) {
            return -1;
        }
        StringBuilder sb = new StringBuilder();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!TextUtils.isEmpty(readLine)) {
                        if (readLine.contains("Max open files")) {
                            sb.append(readLine);
                        }
                    }
                }
                String sb2 = sb.toString();
                if (!TextUtils.isEmpty(sb2)) {
                    Matcher matcher = Pattern.compile("\\d+").matcher(sb2);
                    if (matcher.find()) {
                        int intValue = Integer.valueOf(matcher.group(0)).intValue();
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        return intValue;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    fileInputStream.close();
                    return -1;
                } catch (Throwable th) {
                    th = th;
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
            }
            try {
                fileInputStream.close();
                return -1;
            } catch (IOException e5) {
                e5.printStackTrace();
                return -1;
            }
        } catch (Exception e6) {
            fileInputStream = null;
            e = e6;
            e.printStackTrace();
            fileInputStream.close();
            return -1;
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
            fileInputStream.close();
            throw th;
        }
    }

    public static String getThreadInfoInJson(Thread thread, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("threadId", thread.getId());
            jSONObject.put("name", thread.getName());
            jSONObject.put(LogFactory.PRIORITY_KEY, thread.getPriority());
            jSONObject.put("groupName", thread.getThreadGroup() != null ? thread.getThreadGroup().getName() : "");
            jSONObject.put(LogFactory.PRIORITY_KEY, thread.getPriority());
            jSONObject.put("state", thread.getState());
            if (z) {
                StringBuilder sb = new StringBuilder();
                for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
                    sb.append("\tat ");
                    sb.append(stackTraceElement.getMethodName());
                    sb.append("(");
                    sb.append(stackTraceElement.getFileName());
                    sb.append(":");
                    sb.append(stackTraceElement.getLineNumber());
                    sb.append(")\n");
                }
                jSONObject.put(NdkCrashLog.STACKTRACE_KEY_NAME, sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String getAllThreadInfo(boolean z) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (Map.Entry<Thread, StackTraceElement[]> key : Thread.getAllStackTraces().entrySet()) {
                jSONArray.put(getThreadInfoInJson((Thread) key.getKey(), z));
            }
        } catch (Exception e) {
            OLog.m34418e(e.getMessage());
        }
        return jSONArray.toString();
    }

    public static String getCensusAllThreadInfo() {
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            StringBuilder sb = new StringBuilder();
            sb.append("Threads: ");
            sb.append(allStackTraces.size());
            sb.append("\n\n");
            sb.append(String.format("%8s", new Object[]{"PID"}));
            sb.append(String.format("%8s", new Object[]{"TID"}));
            sb.append(String.format("%8s", new Object[]{"PRI"}));
            sb.append(String.format("%10s", new Object[]{"TGROUP"}));
            sb.append(String.format("%17s", new Object[]{"STATE"}));
            sb.append(String.format("       %-8s", new Object[]{"NAME"}));
            sb.append("\n");
            int myPid = Process.myPid();
            for (Map.Entry<Thread, StackTraceElement[]> key : allStackTraces.entrySet()) {
                Thread thread = (Thread) key.getKey();
                sb.append(String.format("%8s", new Object[]{Integer.valueOf(myPid)}));
                sb.append(String.format("%8s", new Object[]{Long.valueOf(thread.getId())}));
                sb.append(String.format("%8s", new Object[]{Integer.valueOf(thread.getPriority())}));
                sb.append(String.format("%10s", new Object[]{thread.getThreadGroup().getName()}));
                sb.append(String.format("%17s", new Object[]{thread.getState()}));
                sb.append(String.format("       %-8s", new Object[]{thread.getName()}));
                sb.append("\n");
            }
            return sb.toString();
        } catch (Exception e) {
            OLog.m34418e(e.getMessage());
            return "";
        }
    }

    public static String getAllThreadInfo(boolean z, boolean z2) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (Map.Entry next : Thread.getAllStackTraces().entrySet()) {
                String name = ((Thread) next.getKey()).getName();
                if (z2 && name != null) {
                    String[] strArr = sIgnoredThreadWhiteList;
                    int length = strArr.length;
                    boolean z3 = false;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        } else if (name.matches(strArr[i])) {
                            z3 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (z3) {
                    }
                }
                jSONArray.put(getThreadInfoInJson((Thread) next.getKey(), z));
            }
        } catch (Exception e) {
            OLog.m34418e(e.getMessage());
        }
        return jSONArray.toString();
    }
}
