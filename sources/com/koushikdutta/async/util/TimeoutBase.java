package com.koushikdutta.async.util;

import android.os.Handler;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.future.Cancellable;

public class TimeoutBase {
    protected long delay;
    protected Handlerish handlerish;

    interface Handlerish {
        void post(Runnable runnable);

        Object postDelayed(Runnable runnable, long j);

        void removeAllCallbacks(Object obj);
    }

    /* access modifiers changed from: protected */
    public void onCallback() {
    }

    public TimeoutBase(final AsyncServer asyncServer, long j) {
        this.delay = j;
        this.handlerish = new Handlerish() {
            public void post(Runnable runnable) {
                asyncServer.post(runnable);
            }

            public Object postDelayed(Runnable runnable, long j) {
                return asyncServer.postDelayed(runnable, j);
            }

            public void removeAllCallbacks(Object obj) {
                if (obj != null) {
                    ((Cancellable) obj).cancel();
                }
            }
        };
    }

    public TimeoutBase(final Handler handler, long j) {
        this.delay = j;
        this.handlerish = new Handlerish() {
            public void post(Runnable runnable) {
                handler.post(runnable);
            }

            public Object postDelayed(Runnable runnable, long j) {
                handler.postDelayed(runnable, j);
                return runnable;
            }

            public void removeAllCallbacks(Object obj) {
                if (obj != null) {
                    handler.removeCallbacks((Runnable) obj);
                }
            }
        };
    }

    public void setDelay(long j) {
        this.delay = j;
    }
}
