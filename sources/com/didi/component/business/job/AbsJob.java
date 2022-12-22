package com.didi.component.business.job;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.firebase.jobdispatcher.JobParameters;

public abstract class AbsJob {

    /* renamed from: a */
    private String f11309a = "";

    /* renamed from: b */
    private boolean f11310b;
    protected Context mContext;
    protected final Handler mHandler = new Handler(Looper.getMainLooper());

    /* access modifiers changed from: protected */
    public abstract void onJobExecution(JobParameters jobParameters);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final String mo46210a() {
        return this.f11309a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo46212a(String str) {
        this.f11309a = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo46213b() {
        return this.f11310b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo46211a(Context context) {
        this.mContext = context;
    }

    /* access modifiers changed from: protected */
    public final void setNeedToReschedule(boolean z) {
        this.f11310b = z;
    }

    public Handler getHandler() {
        return this.mHandler;
    }
}
