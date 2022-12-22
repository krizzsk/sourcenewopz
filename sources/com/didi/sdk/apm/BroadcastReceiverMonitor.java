package com.didi.sdk.apm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.FileObserver;
import android.os.Handler;
import android.os.Looper;
import android.util.ArrayMap;
import android.util.Log;
import com.didi.sdk.apm.utils.ReflectUtils;

class BroadcastReceiverMonitor {

    /* renamed from: a */
    public static final String f34935a = "ReceiverMonitor";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f34936b;

    /* renamed from: c */
    private FileObserver f34937c = new FileObserver("/data/anr", 8) {
        public void onEvent(int i, String str) {
            Log.d(BroadcastReceiverMonitor.f34935a, "onEvent: event=" + i + " path=" + str);
            BroadcastReceiverDumper.dump(BroadcastReceiverMonitor.this.f34936b);
        }
    };

    BroadcastReceiverMonitor(Context context) {
        this.f34936b = context;
    }

    /* renamed from: a */
    public void mo90273a() {
        try {
            this.f34937c.startWatching();
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0048, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0049, code lost:
        r5.printStackTrace();
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005e A[SYNTHETIC, Splitter:B:24:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0068 A[SYNTHETIC, Splitter:B:30:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006e A[SYNTHETIC, Splitter:B:34:0x006e] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:27:0x0063=Splitter:B:27:0x0063, B:21:0x0059=Splitter:B:21:0x0059} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m24699a(java.lang.String r5, android.app.Application r6) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cmd line: "
            r0.append(r1)
            java.lang.String r6 = r6.getPackageName()
            java.lang.String r1 = "."
            java.lang.String r2 = "\\."
            java.lang.String r6 = r6.replace(r1, r2)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.util.regex.Pattern r6 = java.util.regex.Pattern.compile(r6)
            r0 = 0
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0058 }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0058 }
            java.io.File r4 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0058 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0058 }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0058 }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0058 }
        L_0x0032:
            java.lang.String r5 = r2.readLine()     // Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0050, all -> 0x004d }
            if (r5 == 0) goto L_0x0044
            java.util.regex.Matcher r5 = r6.matcher(r5)     // Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0050, all -> 0x004d }
            boolean r5 = r5.find()     // Catch:{ FileNotFoundException -> 0x0053, IOException -> 0x0050, all -> 0x004d }
            if (r5 == 0) goto L_0x0032
            r5 = 1
            r1 = 1
        L_0x0044:
            r2.close()     // Catch:{ IOException -> 0x0048 }
            goto L_0x006b
        L_0x0048:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x006b
        L_0x004d:
            r5 = move-exception
            r0 = r2
            goto L_0x006c
        L_0x0050:
            r5 = move-exception
            r0 = r2
            goto L_0x0059
        L_0x0053:
            r5 = move-exception
            r0 = r2
            goto L_0x0063
        L_0x0056:
            r5 = move-exception
            goto L_0x006c
        L_0x0058:
            r5 = move-exception
        L_0x0059:
            r5.printStackTrace()     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x006b
            r0.close()     // Catch:{ IOException -> 0x0048 }
            goto L_0x006b
        L_0x0062:
            r5 = move-exception
        L_0x0063:
            r5.printStackTrace()     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x006b
            r0.close()     // Catch:{ IOException -> 0x0048 }
        L_0x006b:
            return r1
        L_0x006c:
            if (r0 == 0) goto L_0x0076
            r0.close()     // Catch:{ IOException -> 0x0072 }
            goto L_0x0076
        L_0x0072:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0076:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.apm.BroadcastReceiverMonitor.m24699a(java.lang.String, android.app.Application):boolean");
    }

    static class BroadcastReceiverDumper {
        static BroadcastReceiverDumperImpl IMPL;

        BroadcastReceiverDumper() {
        }

        static {
            if (Build.VERSION.SDK_INT >= 19) {
                IMPL = new BroadcastReceiverDumperImplV19();
            } else {
                IMPL = new BroadcastReceiverDumperImpl();
            }
        }

        static void dump(final Context context) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                public void run() {
                    BroadcastReceiverDumper.IMPL.dumpBackgroundReceivers(context);
                }
            });
        }
    }

    static class BroadcastReceiverDumperImpl {
        /* access modifiers changed from: package-private */
        public void dumpBackgroundReceivers(Context context) {
        }

        BroadcastReceiverDumperImpl() {
        }
    }

    static class BroadcastReceiverDumperImplV19 extends BroadcastReceiverDumperImpl {
        BroadcastReceiverDumperImplV19() {
        }

        /* access modifiers changed from: package-private */
        public void dumpBackgroundReceivers(Context context) {
            Object tryGetFiled = ReflectUtils.tryGetFiled(context.getApplicationContext(), "mLoadedApk");
            Log.d(BroadcastReceiverMonitor.f34935a, "dumpBackgroundReceivers start: ");
            if (tryGetFiled == null) {
                Log.w(BroadcastReceiverMonitor.f34935a, "dumpBackgroundReceivers loadedApk == null");
                return;
            }
            ArrayMap arrayMap = (ArrayMap) ReflectUtils.tryGetFiled(tryGetFiled, "mReceivers");
            if (arrayMap == null) {
                Log.w(BroadcastReceiverMonitor.f34935a, "dumpBackgroundReceivers mReceivers == null");
                return;
            }
            ArrayMap arrayMap2 = new ArrayMap(arrayMap);
            for (int i = 0; i < arrayMap2.size(); i++) {
                ArrayMap arrayMap3 = (ArrayMap) arrayMap2.valueAt(i);
                for (int i2 = 0; i2 < arrayMap3.size(); i2++) {
                    BroadcastReceiver broadcastReceiver = (BroadcastReceiver) arrayMap3.keyAt(i2);
                    Handler handler = (Handler) ReflectUtils.tryGetFiled(arrayMap3.valueAt(i2), "mActivityThread");
                    if (handler != null) {
                        if (!(handler.getLooper() == Looper.getMainLooper())) {
                            Log.e(BroadcastReceiverMonitor.f34935a, "Found receiver loop in background thread " + broadcastReceiver);
                        }
                    }
                }
            }
        }
    }
}
