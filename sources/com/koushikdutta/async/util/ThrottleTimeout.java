package com.koushikdutta.async.util;

import android.os.Handler;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.callback.ValueCallback;
import java.util.ArrayList;
import java.util.List;

public class ThrottleTimeout<T> extends TimeoutBase {

    /* renamed from: a */
    ValueCallback<List<T>> f55471a;

    /* renamed from: b */
    ArrayList<T> f55472b = new ArrayList<>();

    /* renamed from: c */
    ThrottleMode f55473c = ThrottleMode.Collect;

    /* renamed from: d */
    Object f55474d;

    public enum ThrottleMode {
        Collect,
        Meter
    }

    public ThrottleTimeout(AsyncServer asyncServer, long j, ValueCallback<List<T>> valueCallback) {
        super(asyncServer, j);
        this.f55471a = valueCallback;
    }

    public ThrottleTimeout(Handler handler, long j, ValueCallback<List<T>> valueCallback) {
        super(handler, j);
        this.f55471a = valueCallback;
    }

    public void setCallback(ValueCallback<List<T>> valueCallback) {
        this.f55471a = valueCallback;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40012a() {
        this.f55474d = null;
        ArrayList arrayList = new ArrayList(this.f55472b);
        this.f55472b.clear();
        this.f55471a.onResult(arrayList);
    }

    public synchronized void postThrottled(T t) {
        this.handlerish.post(new Runnable(t) {
            public final /* synthetic */ Object f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                ThrottleTimeout.this.m40013a(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m40013a(Object obj) {
        this.f55472b.add(obj);
        if (this.f55473c == ThrottleMode.Collect) {
            this.handlerish.removeAllCallbacks(this.f55474d);
            this.f55474d = this.handlerish.postDelayed(new Runnable() {
                public final void run() {
                    ThrottleTimeout.this.m40012a();
                }
            }, this.delay);
        } else if (this.f55474d == null) {
            m40012a();
            this.f55474d = this.handlerish.postDelayed(new Runnable() {
                public final void run() {
                    ThrottleTimeout.this.m40012a();
                }
            }, this.delay);
        }
    }

    public void setThrottleMode(ThrottleMode throttleMode) {
        this.f55473c = throttleMode;
    }
}
