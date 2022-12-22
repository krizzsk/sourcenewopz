package com.microblink.blinkbarcode.util;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: line */
public class lIlIIIIlIl extends Thread implements IllIIIllII {
    /* access modifiers changed from: private */
    public Looper IlIllIlIIl;
    private AtomicBoolean IllIIIIllI = new AtomicBoolean(false);
    private AtomicBoolean IllIIIllII = new AtomicBoolean(false);
    private CountDownLatch lIlIIIIlIl;
    /* access modifiers changed from: private */
    public String llIIIlllll = "";
    private CountDownLatch llIIlIIlll;
    private Handler llIIlIlIIl;

    /* compiled from: line */
    public class IlIllIlIIl implements Runnable {
        public IlIllIlIIl() {
        }

        public void run() {
            if (Build.VERSION.SDK_INT >= 18) {
                lIlIIIIlIl.this.IlIllIlIIl.quitSafely();
            } else {
                lIlIIIIlIl.this.IlIllIlIIl.quit();
            }
        }
    }

    /* compiled from: line */
    public static class IllIIIllII extends Handler {
        public IllIIIllII(Looper looper) {
            super(looper);
        }

        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Throwable th) {
                Throwable th2 = th;
                while (th2.getCause() != null) {
                    th2 = th2.getCause();
                }
                StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) message.obj;
                StackTraceElement[] stackTrace = th2.getStackTrace();
                ArrayList arrayList = new ArrayList(stackTrace.length + stackTraceElementArr.length);
                Collections.addAll(arrayList, stackTrace);
                arrayList.add(new StackTraceElement("********************* Posted to handler", "at: ", (String) null, -2));
                for (int i = 5; i < stackTraceElementArr.length; i++) {
                    arrayList.add(stackTraceElementArr[i]);
                }
                StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[arrayList.size()];
                arrayList.toArray(stackTraceElementArr2);
                th2.setStackTrace(stackTraceElementArr2);
                throw th;
            }
        }

        public boolean sendMessageAtTime(Message message, long j) {
            message.obj = Thread.currentThread().getStackTrace();
            return super.sendMessageAtTime(message, j);
        }
    }

    /* compiled from: line */
    public class llIIlIlIIl implements Runnable {
        public final /* synthetic */ Throwable llIIlIlIIl;

        public llIIlIlIIl(Throwable th) {
            this.llIIlIlIIl = th;
        }

        public void run() {
            throw new RuntimeException("Processing queue " + lIlIIIIlIl.this.llIIIlllll + " halted due to an error. " + this.llIIlIlIIl.getMessage(), this.llIIlIlIIl);
        }
    }

    public lIlIIIIlIl(String str) {
        this.llIIIlllll = str;
        this.lIlIIIIlIl = new CountDownLatch(1);
        this.llIIlIIlll = new CountDownLatch(1);
        setName(this.llIIIlllll);
    }

    private void IllIIIllII() {
        try {
            this.lIlIIIIlIl.await();
        } catch (InterruptedException e) {
            Log.m40230e(this, e, "Interrupted while waiting for processing queue {} to start", this.llIIIlllll);
        }
    }

    public void run() {
        try {
            Looper.prepare();
            Log.m40233v(this, "Booting processing queue {}", this.llIIIlllll);
            this.IlIllIlIIl = Looper.myLooper();
            this.llIIlIlIIl = new IllIIIllII(this.IlIllIlIIl);
            this.lIlIIIIlIl.countDown();
            Looper.loop();
            this.IllIIIllII.set(true);
            this.llIIlIIlll.countDown();
            Log.m40227d(this, "Processing queue {} terminated gracefully", this.llIIIlllll);
        } catch (Throwable th) {
            new Handler(Looper.getMainLooper()).post(new llIIlIlIIl(th));
        }
    }

    public void IlIllIlIIl() {
        if (!this.IllIIIIllI.getAndSet(true)) {
            this.llIIlIlIIl.post(new IlIllIlIIl());
            this.llIIlIlIIl = null;
        }
    }

    public void llIIlIlIIl(Runnable runnable) {
        IllIIIllII();
        if (!this.IllIIIIllI.get()) {
            this.llIIlIlIIl.post(runnable);
            return;
        }
        Log.m40235w(this, "Processing queue {} is exiting, unable to post job to it", this.llIIIlllll);
    }

    public void llIIlIlIIl(Runnable runnable, long j) {
        IllIIIllII();
        if (!this.IllIIIIllI.get()) {
            this.llIIlIlIIl.postDelayed(runnable, j);
            return;
        }
        Log.m40235w(this, "Processing queue {} is exiting, unable to post job to it", this.llIIIlllll);
    }

    public Handler llIIlIlIIl() {
        IllIIIllII();
        return this.llIIlIlIIl;
    }
}
