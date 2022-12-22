package com.koushikdutta.async;

import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.koushikdutta.async.c */
/* compiled from: SelectorWrapper */
class C20148c implements Closeable {

    /* renamed from: a */
    public AtomicBoolean f55243a = new AtomicBoolean(false);

    /* renamed from: b */
    Semaphore f55244b = new Semaphore(0);

    /* renamed from: c */
    private Selector f55245c;

    /* renamed from: a */
    public Selector mo163908a() {
        return this.f55245c;
    }

    public C20148c(Selector selector) {
        this.f55245c = selector;
    }

    /* renamed from: b */
    public int mo163910b() throws IOException {
        return this.f55245c.selectNow();
    }

    /* renamed from: c */
    public void mo163911c() throws IOException {
        mo163909a(0);
    }

    /* renamed from: a */
    public void mo163909a(long j) throws IOException {
        try {
            this.f55244b.drainPermits();
            this.f55245c.select(j);
        } finally {
            this.f55244b.release(Integer.MAX_VALUE);
        }
    }

    /* renamed from: d */
    public Set<SelectionKey> mo163913d() {
        return this.f55245c.keys();
    }

    /* renamed from: e */
    public Set<SelectionKey> mo163914e() {
        return this.f55245c.selectedKeys();
    }

    public void close() throws IOException {
        this.f55245c.close();
    }

    /* renamed from: f */
    public boolean mo163915f() {
        return this.f55245c.isOpen();
    }

    /* renamed from: g */
    public void mo163916g() {
        boolean z = !this.f55244b.tryAcquire();
        this.f55245c.wakeup();
        if (!z) {
            if (this.f55243a.getAndSet(true)) {
                this.f55245c.wakeup();
                return;
            }
            try {
                mo163917h();
                this.f55245c.wakeup();
            } finally {
                this.f55243a.set(false);
            }
        }
    }

    /* renamed from: h */
    public boolean mo163917h() {
        int i = 0;
        while (i < 100) {
            try {
                this.f55244b.tryAcquire(10, TimeUnit.MILLISECONDS);
                i++;
            } catch (InterruptedException unused) {
                return true;
            }
        }
        return false;
    }
}
