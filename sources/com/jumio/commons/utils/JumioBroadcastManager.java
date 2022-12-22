package com.jumio.commons.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class JumioBroadcastManager {

    /* renamed from: g */
    public static final Object f54576g = new Object();

    /* renamed from: h */
    public static JumioBroadcastManager f54577h;

    /* renamed from: a */
    public final Context f54578a;

    /* renamed from: b */
    public final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> f54579b = new HashMap<>();

    /* renamed from: c */
    public final HashMap<String, ArrayList<C19947c>> f54580c = new HashMap<>();

    /* renamed from: d */
    public final HashMap<String, Intent> f54581d = new HashMap<>();

    /* renamed from: e */
    public final ArrayList<C19946b> f54582e = new ArrayList<>();

    /* renamed from: f */
    public final Handler f54583f;

    /* renamed from: com.jumio.commons.utils.JumioBroadcastManager$a */
    public class C19945a extends Handler {
        public C19945a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                JumioBroadcastManager.this.mo162464a();
            }
        }
    }

    /* renamed from: com.jumio.commons.utils.JumioBroadcastManager$b */
    public static class C19946b {

        /* renamed from: a */
        public final Intent f54585a;

        /* renamed from: b */
        public final ArrayList<C19947c> f54586b;

        public C19946b(Intent intent, ArrayList<C19947c> arrayList) {
            this.f54585a = intent;
            this.f54586b = arrayList;
        }
    }

    /* renamed from: com.jumio.commons.utils.JumioBroadcastManager$c */
    public static class C19947c {

        /* renamed from: a */
        public final IntentFilter f54587a;

        /* renamed from: b */
        public final BroadcastReceiver f54588b;

        /* renamed from: c */
        public boolean f54589c;

        public C19947c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f54587a = intentFilter;
            this.f54588b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f54588b);
            sb.append(" filter=");
            sb.append(this.f54587a);
            sb.append("}");
            return sb.toString();
        }
    }

    public JumioBroadcastManager(Context context) {
        this.f54578a = context;
        this.f54583f = new C19945a(context.getMainLooper());
    }

    public static synchronized void destroy() {
        synchronized (JumioBroadcastManager.class) {
            JumioBroadcastManager jumioBroadcastManager = f54577h;
            if (jumioBroadcastManager != null) {
                HashMap<String, ArrayList<C19947c>> hashMap = jumioBroadcastManager.f54580c;
                if (hashMap != null) {
                    hashMap.clear();
                }
                HashMap<String, Intent> hashMap2 = f54577h.f54581d;
                if (hashMap2 != null) {
                    hashMap2.clear();
                }
                f54577h = null;
            }
        }
    }

    public static JumioBroadcastManager getInstance(Context context) {
        JumioBroadcastManager jumioBroadcastManager;
        synchronized (f54576g) {
            if (f54577h == null) {
                f54577h = new JumioBroadcastManager(context.getApplicationContext());
            }
            jumioBroadcastManager = f54577h;
        }
        return jumioBroadcastManager;
    }

    public void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f54579b) {
            C19947c cVar = new C19947c(intentFilter, broadcastReceiver);
            ArrayList arrayList = this.f54579b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.f54579b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                if (this.f54581d.containsKey(action)) {
                    arrayList2.add(action);
                }
                ArrayList arrayList3 = this.f54580c.get(action);
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList(1);
                    this.f54580c.put(action, arrayList3);
                }
                arrayList3.add(cVar);
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                sendBroadcast(this.f54581d.get(str));
                this.f54581d.remove(str);
            }
        }
    }

    public boolean sendBroadcast(Intent intent) {
        return sendBroadcast(intent, false);
    }

    public void sendBroadcastSync(Intent intent) {
        if (sendBroadcast(intent)) {
            mo162464a();
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f54579b) {
            ArrayList remove = this.f54579b.remove(broadcastReceiver);
            if (remove != null) {
                for (int i = 0; i < remove.size(); i++) {
                    IntentFilter intentFilter = (IntentFilter) remove.get(i);
                    for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                        String action = intentFilter.getAction(i2);
                        ArrayList arrayList = this.f54580c.get(action);
                        if (arrayList != null) {
                            int i3 = 0;
                            while (i3 < arrayList.size()) {
                                if (((C19947c) arrayList.get(i3)).f54588b == broadcastReceiver) {
                                    arrayList.remove(i3);
                                    i3--;
                                }
                                i3++;
                            }
                            if (arrayList.size() <= 0) {
                                this.f54580c.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (r3 >= r1) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        r4 = r2[r3];
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (r5 >= r4.f54586b.size()) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r4.f54586b.get(r5).f54588b.onReceive(r9.f54578a, r4.f54585a);
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        r3 = 0;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo162464a() {
        /*
            r9 = this;
        L_0x0000:
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<android.content.IntentFilter>> r0 = r9.f54579b
            monitor-enter(r0)
            java.util.ArrayList<com.jumio.commons.utils.JumioBroadcastManager$b> r1 = r9.f54582e     // Catch:{ all -> 0x0040 }
            int r1 = r1.size()     // Catch:{ all -> 0x0040 }
            if (r1 > 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            return
        L_0x000d:
            com.jumio.commons.utils.JumioBroadcastManager$b[] r2 = new com.jumio.commons.utils.JumioBroadcastManager.C19946b[r1]     // Catch:{ all -> 0x0040 }
            java.util.ArrayList<com.jumio.commons.utils.JumioBroadcastManager$b> r3 = r9.f54582e     // Catch:{ all -> 0x0040 }
            r3.toArray(r2)     // Catch:{ all -> 0x0040 }
            java.util.ArrayList<com.jumio.commons.utils.JumioBroadcastManager$b> r3 = r9.f54582e     // Catch:{ all -> 0x0040 }
            r3.clear()     // Catch:{ all -> 0x0040 }
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            r0 = 0
            r3 = 0
        L_0x001c:
            if (r3 >= r1) goto L_0x0000
            r4 = r2[r3]
            r5 = 0
        L_0x0021:
            java.util.ArrayList<com.jumio.commons.utils.JumioBroadcastManager$c> r6 = r4.f54586b
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x003d
            java.util.ArrayList<com.jumio.commons.utils.JumioBroadcastManager$c> r6 = r4.f54586b
            java.lang.Object r6 = r6.get(r5)
            com.jumio.commons.utils.JumioBroadcastManager$c r6 = (com.jumio.commons.utils.JumioBroadcastManager.C19947c) r6
            android.content.BroadcastReceiver r6 = r6.f54588b
            android.content.Context r7 = r9.f54578a
            android.content.Intent r8 = r4.f54585a
            r6.onReceive(r7, r8)
            int r5 = r5 + 1
            goto L_0x0021
        L_0x003d:
            int r3 = r3 + 1
            goto L_0x001c
        L_0x0040:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.utils.JumioBroadcastManager.mo162464a():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0171, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x017a, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean sendBroadcast(android.content.Intent r22, boolean r23) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<android.content.IntentFilter>> r2 = r1.f54579b
            monitor-enter(r2)
            java.lang.String r10 = r22.getAction()     // Catch:{ all -> 0x017c }
            android.content.Context r3 = r1.f54578a     // Catch:{ all -> 0x017c }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ all -> 0x017c }
            java.lang.String r11 = r0.resolveTypeIfNeeded(r3)     // Catch:{ all -> 0x017c }
            android.net.Uri r12 = r22.getData()     // Catch:{ all -> 0x017c }
            java.lang.String r13 = r22.getScheme()     // Catch:{ all -> 0x017c }
            java.util.Set r14 = r22.getCategories()     // Catch:{ all -> 0x017c }
            int r3 = r22.getFlags()     // Catch:{ all -> 0x017c }
            r3 = r3 & 8
            if (r3 == 0) goto L_0x002c
            r16 = 1
            goto L_0x002e
        L_0x002c:
            r16 = 0
        L_0x002e:
            if (r16 == 0) goto L_0x0056
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r4.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r5 = "Resolving type "
            r4.append(r5)     // Catch:{ all -> 0x017c }
            r4.append(r11)     // Catch:{ all -> 0x017c }
            java.lang.String r5 = " scheme "
            r4.append(r5)     // Catch:{ all -> 0x017c }
            r4.append(r13)     // Catch:{ all -> 0x017c }
            java.lang.String r5 = " of intent "
            r4.append(r5)     // Catch:{ all -> 0x017c }
            r4.append(r0)     // Catch:{ all -> 0x017c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x017c }
            com.jumio.commons.log.Log.m39471v((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x017c }
        L_0x0056:
            java.util.HashMap<java.lang.String, java.util.ArrayList<com.jumio.commons.utils.JumioBroadcastManager$c>> r3 = r1.f54580c     // Catch:{ all -> 0x017c }
            java.lang.String r4 = r22.getAction()     // Catch:{ all -> 0x017c }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x017c }
            r8 = r3
            java.util.ArrayList r8 = (java.util.ArrayList) r8     // Catch:{ all -> 0x017c }
            if (r8 == 0) goto L_0x0172
            if (r16 == 0) goto L_0x007d
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r4.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r5 = "Action list: "
            r4.append(r5)     // Catch:{ all -> 0x017c }
            r4.append(r8)     // Catch:{ all -> 0x017c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x017c }
            com.jumio.commons.log.Log.m39471v((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x017c }
        L_0x007d:
            r3 = 0
            r7 = r3
            r6 = 0
        L_0x0080:
            int r3 = r8.size()     // Catch:{ all -> 0x017c }
            if (r6 >= r3) goto L_0x0142
            java.lang.Object r3 = r8.get(r6)     // Catch:{ all -> 0x017c }
            r5 = r3
            com.jumio.commons.utils.JumioBroadcastManager$c r5 = (com.jumio.commons.utils.JumioBroadcastManager.C19947c) r5     // Catch:{ all -> 0x017c }
            if (r16 == 0) goto L_0x00a7
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r4.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r9 = "Matching against filter "
            r4.append(r9)     // Catch:{ all -> 0x017c }
            android.content.IntentFilter r9 = r5.f54587a     // Catch:{ all -> 0x017c }
            r4.append(r9)     // Catch:{ all -> 0x017c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x017c }
            com.jumio.commons.log.Log.m39471v((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x017c }
        L_0x00a7:
            boolean r3 = r5.f54589c     // Catch:{ all -> 0x017c }
            if (r3 == 0) goto L_0x00c0
            if (r16 == 0) goto L_0x00b4
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.String r4 = "  Filter's target already added"
            com.jumio.commons.log.Log.m39471v((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x017c }
        L_0x00b4:
            r17 = r6
            r19 = r8
            r18 = r11
            r20 = r12
            r12 = 1
            r11 = r7
            goto L_0x0137
        L_0x00c0:
            android.content.IntentFilter r3 = r5.f54587a     // Catch:{ all -> 0x017c }
            java.lang.String r9 = "LocalBroadcastManager"
            r4 = r10
            r15 = r5
            r5 = r11
            r17 = r6
            r6 = r13
            r18 = r11
            r11 = r7
            r7 = r12
            r19 = r8
            r8 = r14
            r20 = r12
            r12 = 1
            int r3 = r3.match(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x017c }
            if (r3 < 0) goto L_0x0105
            if (r16 == 0) goto L_0x00f6
            java.lang.String r4 = "LocalBroadcastManager"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r5.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r6 = "  Filter matched!  match=0x"
            r5.append(r6)     // Catch:{ all -> 0x017c }
            java.lang.String r3 = java.lang.Integer.toHexString(r3)     // Catch:{ all -> 0x017c }
            r5.append(r3)     // Catch:{ all -> 0x017c }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x017c }
            com.jumio.commons.log.Log.m39471v((java.lang.String) r4, (java.lang.String) r3)     // Catch:{ all -> 0x017c }
        L_0x00f6:
            if (r11 != 0) goto L_0x00fe
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x017c }
            r7.<init>()     // Catch:{ all -> 0x017c }
            goto L_0x00ff
        L_0x00fe:
            r7 = r11
        L_0x00ff:
            r7.add(r15)     // Catch:{ all -> 0x017c }
            r15.f54589c = r12     // Catch:{ all -> 0x017c }
            goto L_0x0138
        L_0x0105:
            if (r16 == 0) goto L_0x0137
            r4 = -4
            if (r3 == r4) goto L_0x011f
            r4 = -3
            if (r3 == r4) goto L_0x011c
            r4 = -2
            if (r3 == r4) goto L_0x0119
            r4 = -1
            if (r3 == r4) goto L_0x0116
            java.lang.String r3 = "unknown reason"
            goto L_0x0121
        L_0x0116:
            java.lang.String r3 = "type"
            goto L_0x0121
        L_0x0119:
            java.lang.String r3 = "data"
            goto L_0x0121
        L_0x011c:
            java.lang.String r3 = "action"
            goto L_0x0121
        L_0x011f:
            java.lang.String r3 = "category"
        L_0x0121:
            java.lang.String r4 = "LocalBroadcastManager"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r5.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r6 = "  Filter did not match: "
            r5.append(r6)     // Catch:{ all -> 0x017c }
            r5.append(r3)     // Catch:{ all -> 0x017c }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x017c }
            com.jumio.commons.log.Log.m39471v((java.lang.String) r4, (java.lang.String) r3)     // Catch:{ all -> 0x017c }
        L_0x0137:
            r7 = r11
        L_0x0138:
            int r6 = r17 + 1
            r11 = r18
            r8 = r19
            r12 = r20
            goto L_0x0080
        L_0x0142:
            r11 = r7
            r12 = 1
            if (r11 == 0) goto L_0x0179
            r3 = 0
        L_0x0147:
            int r4 = r11.size()     // Catch:{ all -> 0x017c }
            if (r3 >= r4) goto L_0x0159
            java.lang.Object r4 = r11.get(r3)     // Catch:{ all -> 0x017c }
            com.jumio.commons.utils.JumioBroadcastManager$c r4 = (com.jumio.commons.utils.JumioBroadcastManager.C19947c) r4     // Catch:{ all -> 0x017c }
            r5 = 0
            r4.f54589c = r5     // Catch:{ all -> 0x017c }
            int r3 = r3 + 1
            goto L_0x0147
        L_0x0159:
            java.util.ArrayList<com.jumio.commons.utils.JumioBroadcastManager$b> r3 = r1.f54582e     // Catch:{ all -> 0x017c }
            com.jumio.commons.utils.JumioBroadcastManager$b r4 = new com.jumio.commons.utils.JumioBroadcastManager$b     // Catch:{ all -> 0x017c }
            r4.<init>(r0, r11)     // Catch:{ all -> 0x017c }
            r3.add(r4)     // Catch:{ all -> 0x017c }
            android.os.Handler r0 = r1.f54583f     // Catch:{ all -> 0x017c }
            boolean r0 = r0.hasMessages(r12)     // Catch:{ all -> 0x017c }
            if (r0 != 0) goto L_0x0170
            android.os.Handler r0 = r1.f54583f     // Catch:{ all -> 0x017c }
            r0.sendEmptyMessage(r12)     // Catch:{ all -> 0x017c }
        L_0x0170:
            monitor-exit(r2)     // Catch:{ all -> 0x017c }
            return r12
        L_0x0172:
            if (r23 == 0) goto L_0x0179
            java.util.HashMap<java.lang.String, android.content.Intent> r3 = r1.f54581d     // Catch:{ all -> 0x017c }
            r3.put(r10, r0)     // Catch:{ all -> 0x017c }
        L_0x0179:
            monitor-exit(r2)     // Catch:{ all -> 0x017c }
            r0 = 0
            return r0
        L_0x017c:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x017c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.utils.JumioBroadcastManager.sendBroadcast(android.content.Intent, boolean):boolean");
    }
}
