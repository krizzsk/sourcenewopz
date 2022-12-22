package com.koushikdutta.async.util;

import android.os.Handler;
import com.koushikdutta.async.AsyncServer;

public class IdleTimeout extends TimeoutBase {

    /* renamed from: a */
    Runnable f55469a;

    /* renamed from: b */
    Object f55470b;

    public IdleTimeout(AsyncServer asyncServer, long j) {
        super(asyncServer, j);
    }

    public IdleTimeout(Handler handler, long j) {
        super(handler, j);
    }

    public void setTimeout(Runnable runnable) {
        this.f55469a = runnable;
    }

    public void reset() {
        this.handlerish.removeAllCallbacks(this.f55470b);
        this.f55470b = this.handlerish.postDelayed(this.f55469a, this.delay);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m40011a() {
        this.handlerish.removeAllCallbacks(this.f55470b);
    }

    public void cancel() {
        this.handlerish.post(new Runnable() {
            public final void run() {
                IdleTimeout.this.m40011a();
            }
        });
    }
}
