package com.didi.sdk.logging;

import com.didi.sdk.logging.model.AbstractLog;
import com.didi.sdk.logging.util.Debug;
import com.didi.sdk.logging.util.LoggerUtils;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

class BinaryExecutor {

    /* renamed from: a */
    private static final int f36469a = 1024;

    /* renamed from: b */
    private static final Map<String, BinaryExecutor> f36470b = Collections.synchronizedMap(new HashMap());

    /* renamed from: c */
    private final C12387a f36471c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final BlockingQueue<AbstractLog> f36472d;

    /* renamed from: e */
    private final Worker f36473e;

    /* renamed from: f */
    private final Object f36474f = new Object();

    /* renamed from: g */
    private File f36475g;

    /* renamed from: h */
    private OutputStream f36476h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final AtomicBoolean f36477i = new AtomicBoolean(false);

    /* renamed from: a */
    public static BinaryExecutor m25849a(String str) {
        BinaryExecutor binaryExecutor = f36470b.get(str);
        if (binaryExecutor == null) {
            synchronized (f36470b) {
                if (binaryExecutor == null) {
                    binaryExecutor = new BinaryExecutor(str);
                    f36470b.put(str, binaryExecutor);
                }
            }
        }
        return binaryExecutor;
    }

    private BinaryExecutor(String str) {
        this.f36473e = new Worker("logger-binary-" + str);
        this.f36472d = new ArrayBlockingQueue(1024);
        this.f36471c = new C12399g(Type.BINARY, str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo92512a(AbstractLog abstractLog) {
        if (abstractLog != null) {
            if (this.f36477i.compareAndSet(false, true)) {
                m25851a();
            }
            if (LoggerUtils.isMainThread()) {
                this.f36472d.offer(abstractLog);
                return;
            }
            try {
                this.f36472d.put(abstractLog);
            } catch (InterruptedException unused) {
            }
        }
    }

    /* renamed from: a */
    private void m25851a() {
        this.f36471c.mo92596a(System.currentTimeMillis());
        File file = new File(this.f36471c.mo92598b());
        this.f36475g = file;
        try {
            m25853a(file);
        } catch (IOException e) {
            Debug.logOrThrow("start work thread openFile IOException ", e);
        }
        m25856b();
    }

    /* renamed from: b */
    private void m25856b() {
        this.f36473e.setDaemon(true);
        this.f36473e.start();
    }

    class Worker extends Thread {
        Worker(String str) {
            super(str);
        }

        public void run() {
            while (BinaryExecutor.this.f36477i.get()) {
                try {
                    AbstractLog abstractLog = (AbstractLog) BinaryExecutor.this.f36472d.take();
                    if (abstractLog != null) {
                        try {
                            BinaryExecutor.this.m25854a(abstractLog.getData());
                        } catch (IOException e) {
                            Debug.m25981e("writeToFile failed e = " + e);
                        }
                    }
                } catch (InterruptedException e2) {
                    Debug.m25981e("writeToFile failed e = " + e2);
                }
            }
        }
    }

    /* renamed from: c */
    private void m25857c() {
        synchronized (this.f36474f) {
            m25858d();
            this.f36471c.mo92595a();
            File file = new File(this.f36471c.mo92598b());
            this.f36475g = file;
            try {
                m25853a(file);
            } catch (IOException e) {
                Debug.m25981e("rollover openFile IOException e = " + e);
            }
        }
    }

    /* renamed from: a */
    private void m25853a(File file) throws IOException {
        synchronized (this.f36474f) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            this.f36476h = new C12398f(file, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25854a(byte[] bArr) throws IOException {
        if (this.f36471c.mo92597a(this.f36475g)) {
            m25857c();
        }
        OutputStream outputStream = this.f36476h;
        if (outputStream != null && bArr != null && bArr.length != 0) {
            outputStream.write(bArr);
            this.f36476h.flush();
        }
    }

    /* renamed from: d */
    private void m25858d() {
        OutputStream outputStream = this.f36476h;
        if (outputStream != null) {
            try {
                outputStream.close();
                this.f36476h = null;
            } catch (IOException unused) {
            }
        }
    }
}
