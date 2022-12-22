package com.didi.map.core.p121ui.callback;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import java.util.Timer;
import java.util.TimerTask;

@Deprecated
/* renamed from: com.didi.map.core.ui.callback.ProtectedUnPeekLiveDataV3 */
public class ProtectedUnPeekLiveDataV3<T> extends LiveData<T> {
    protected int DELAY_TO_CLEAR_EVENT = 1000;

    /* renamed from: a */
    private boolean f24758a;

    /* renamed from: b */
    private boolean f24759b = true;

    /* renamed from: c */
    private boolean f24760c;

    /* renamed from: d */
    private Timer f24761d = new Timer();

    /* renamed from: e */
    private TimerTask f24762e;
    protected boolean isAllowNullValue;
    protected boolean isAllowToClear = true;

    public void observe(LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
        super.observe(lifecycleOwner, new Observer(observer) {
            public final /* synthetic */ Observer f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                ProtectedUnPeekLiveDataV3.this.m17589a(this.f$1, obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m17589a(Observer observer, Object obj) {
        if (this.f24758a) {
            this.f24759b = true;
            this.f24760c = false;
            this.f24758a = false;
        } else if (!this.f24759b) {
            this.f24759b = true;
            this.f24760c = true;
            observer.onChanged(obj);
        } else if (this.f24760c) {
            observer.onChanged(obj);
        }
    }

    public void observeForever(Observer<? super T> observer) {
        throw new IllegalArgumentException("Do not use observeForever for communication between pages to avoid lifecycle security issues");
    }

    /* access modifiers changed from: protected */
    public void setValue(T t) {
        if (this.f24758a || this.isAllowNullValue || t != null) {
            this.f24759b = false;
            this.f24760c = false;
            super.setValue(t);
            TimerTask timerTask = this.f24762e;
            if (timerTask != null) {
                timerTask.cancel();
                this.f24761d.purge();
            }
            if (t != null) {
                C93351 r4 = new TimerTask() {
                    public void run() {
                        ProtectedUnPeekLiveDataV3.this.m17588a();
                    }
                };
                this.f24762e = r4;
                this.f24761d.schedule(r4, (long) this.DELAY_TO_CLEAR_EVENT);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17588a() {
        if (this.isAllowToClear) {
            this.f24758a = true;
            super.postValue(null);
            return;
        }
        this.f24759b = true;
        this.f24760c = false;
    }
}
