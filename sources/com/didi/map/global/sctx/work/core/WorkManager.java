package com.didi.map.global.sctx.work.core;

import android.os.Handler;
import android.os.Looper;
import com.didi.map.utils.logger.Logger;

public class WorkManager {

    /* renamed from: a */
    private Handler f27709a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    private boolean f27710b;

    public void enqueue(WorkRequest workRequest) {
        if (Logger.isLoggable()) {
            Logger.m20436d("enqueue");
        }
        this.f27710b = false;
        if (workRequest.getWorkSpec().initialDelay > 0) {
            this.f27709a.postDelayed(new Runnable(workRequest) {
                public final /* synthetic */ WorkRequest f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    WorkManager.this.m19859c(this.f$1);
                }
            }, workRequest.getWorkSpec().initialDelay);
        } else {
            workRequest.getWorkSpec().worker.onRun();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m19859c(WorkRequest workRequest) {
        workRequest.getWorkSpec().worker.onRun();
        if (workRequest.getWorkSpec().intervalDuration > 0) {
            m19857a(workRequest);
        }
    }

    /* renamed from: a */
    private void m19857a(WorkRequest workRequest) {
        if (Logger.isLoggable()) {
            Logger.m20436d("runWorkInterval");
        }
        this.f27709a.postDelayed(new Runnable(workRequest) {
            public final /* synthetic */ WorkRequest f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                WorkManager.this.m19858b(this.f$1);
            }
        }, workRequest.getWorkSpec().intervalDuration);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m19858b(WorkRequest workRequest) {
        workRequest.getWorkSpec().worker.onRun();
        if (!this.f27710b) {
            m19857a(workRequest);
        }
    }

    public void cancelAllWork() {
        if (Logger.isLoggable()) {
            Logger.m20436d("cancelAllWOrk");
        }
        this.f27709a.removeCallbacksAndMessages((Object) null);
        this.f27710b = true;
    }
}
