package com.didi.security.wireless;

import android.content.Context;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SecurityController {

    /* renamed from: h */
    private static boolean f38570h = false;

    /* renamed from: a */
    private Context f38571a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ReentrantLock f38572b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Condition f38573c;

    /* renamed from: d */
    private Thread f38574d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public volatile boolean f38575e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Queue<SecurityMessage> f38576f = new LinkedList();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Queue<Runnable> f38577g = new LinkedList();

    /* renamed from: i */
    private Runnable f38578i = new Runnable() {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Runnable} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.didi.security.wireless.SecurityMessage} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Runnable} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.didi.security.wireless.SecurityMessage} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.Runnable} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: com.didi.security.wireless.SecurityMessage} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.Runnable} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Runnable} */
        /* JADX WARNING: type inference failed for: r1v24, types: [com.didi.security.wireless.SecurityMessage] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
            L_0x0000:
                com.didi.security.wireless.SecurityController r0 = com.didi.security.wireless.SecurityController.this
                boolean r0 = r0.f38575e
                if (r0 != 0) goto L_0x00a7
                com.didi.security.wireless.SecurityController r0 = com.didi.security.wireless.SecurityController.this
                java.util.concurrent.locks.ReentrantLock r0 = r0.f38572b
                r0.lock()
            L_0x0011:
                r0 = 0
                com.didi.security.wireless.SecurityController r1 = com.didi.security.wireless.SecurityController.this     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                boolean r1 = r1.f38575e     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                if (r1 != 0) goto L_0x003c
                com.didi.security.wireless.SecurityController r1 = com.didi.security.wireless.SecurityController.this     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                java.util.Queue r1 = r1.f38576f     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                boolean r1 = r1.isEmpty()     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                if (r1 == 0) goto L_0x003c
                com.didi.security.wireless.SecurityController r1 = com.didi.security.wireless.SecurityController.this     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                java.util.Queue r1 = r1.f38577g     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                boolean r1 = r1.isEmpty()     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                if (r1 == 0) goto L_0x003c
                com.didi.security.wireless.SecurityController r1 = com.didi.security.wireless.SecurityController.this     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                java.util.concurrent.locks.Condition r1 = r1.f38573c     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                r1.await()     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                goto L_0x0011
            L_0x003c:
                com.didi.security.wireless.SecurityController r1 = com.didi.security.wireless.SecurityController.this     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                java.util.Queue r1 = r1.f38576f     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                boolean r1 = r1.isEmpty()     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                if (r1 != 0) goto L_0x0058
                com.didi.security.wireless.SecurityController r1 = com.didi.security.wireless.SecurityController.this     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                java.util.Queue r1 = r1.f38576f     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                java.lang.Object r1 = r1.poll()     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                com.didi.security.wireless.SecurityMessage r1 = (com.didi.security.wireless.SecurityMessage) r1     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                r3 = r1
                r1 = r0
                r0 = r3
                goto L_0x0072
            L_0x0058:
                com.didi.security.wireless.SecurityController r1 = com.didi.security.wireless.SecurityController.this     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                java.util.Queue r1 = r1.f38577g     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                boolean r1 = r1.isEmpty()     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                if (r1 != 0) goto L_0x0071
                com.didi.security.wireless.SecurityController r1 = com.didi.security.wireless.SecurityController.this     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                java.util.Queue r1 = r1.f38577g     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                java.lang.Object r1 = r1.poll()     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                java.lang.Runnable r1 = (java.lang.Runnable) r1     // Catch:{ InterruptedException -> 0x008a, all -> 0x007f }
                goto L_0x0072
            L_0x0071:
                r1 = r0
            L_0x0072:
                com.didi.security.wireless.SecurityController r2 = com.didi.security.wireless.SecurityController.this
                java.util.concurrent.locks.ReentrantLock r2 = r2.f38572b
                r2.unlock()
                r3 = r1
                r1 = r0
                r0 = r3
                goto L_0x0094
            L_0x007f:
                r0 = move-exception
                com.didi.security.wireless.SecurityController r1 = com.didi.security.wireless.SecurityController.this
                java.util.concurrent.locks.ReentrantLock r1 = r1.f38572b
                r1.unlock()
                throw r0
            L_0x008a:
                com.didi.security.wireless.SecurityController r1 = com.didi.security.wireless.SecurityController.this
                java.util.concurrent.locks.ReentrantLock r1 = r1.f38572b
                r1.unlock()
                r1 = r0
            L_0x0094:
                if (r0 == 0) goto L_0x009e
                r0.run()     // Catch:{ Exception -> 0x009b }
                goto L_0x0000
            L_0x009b:
                goto L_0x0000
            L_0x009e:
                if (r1 == 0) goto L_0x0000
                com.didi.security.wireless.SecurityController r0 = com.didi.security.wireless.SecurityController.this     // Catch:{ Exception -> 0x009b }
                r0.m27327a((com.didi.security.wireless.SecurityMessage) r1)     // Catch:{ Exception -> 0x009b }
                goto L_0x0000
            L_0x00a7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.security.wireless.SecurityController.C133451.run():void");
        }
    };

    public SecurityController() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f38572b = reentrantLock;
        this.f38573c = reentrantLock.newCondition();
    }

    private static class SingletonClassInstance {
        /* access modifiers changed from: private */
        public static final SecurityController INSTANCE = new SecurityController();

        private SingletonClassInstance() {
        }
    }

    public void init(Context context) {
        if (this.f38571a == null) {
            this.f38571a = context;
            m27325a();
        }
    }

    public static SecurityController getInstance() {
        return SingletonClassInstance.INSTANCE;
    }

    public static void setPriorityOn(boolean z) {
        f38570h = z;
    }

    /* renamed from: a */
    private void m27325a() {
        if (this.f38574d == null) {
            this.f38575e = false;
            Thread thread = new Thread(this.f38578i);
            this.f38574d = thread;
            thread.setName("WSGController");
            if (f38570h) {
                this.f38574d.setPriority(10);
            }
            this.f38574d.start();
            Logger.m27324i("Controller", "start only Once");
        }
    }

    /* renamed from: b */
    private void m27330b() {
        if (this.f38574d != null) {
            this.f38575e = true;
            this.f38572b.lock();
            this.f38573c.signal();
            this.f38572b.unlock();
            this.f38576f.clear();
            this.f38577g.clear();
            this.f38574d = null;
        }
    }

    public void post(SecurityMessage securityMessage) {
        if (this.f38574d != null) {
            this.f38572b.lock();
            this.f38576f.add(securityMessage);
            this.f38573c.signal();
            this.f38572b.unlock();
        }
    }

    public void post(Runnable runnable) {
        if (this.f38574d != null) {
            this.f38572b.lock();
            this.f38577g.add(runnable);
            this.f38573c.signal();
            this.f38572b.unlock();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27327a(SecurityMessage securityMessage) {
        SecurityLib.report(securityMessage.msgType, securityMessage.eventType, securityMessage.eventData);
    }
}
