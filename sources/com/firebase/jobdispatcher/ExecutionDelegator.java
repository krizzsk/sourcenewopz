package com.firebase.jobdispatcher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.firebase.jobdispatcher.IJobCallback;
import com.firebase.jobdispatcher.JobInvocation;

class ExecutionDelegator {

    /* renamed from: a */
    static final String f52074a = "FJD.ExternalReceiver";

    /* renamed from: b */
    private static final SimpleArrayMap<String, C17820h> f52075b = new SimpleArrayMap<>();

    /* renamed from: c */
    private final IJobCallback f52076c = new IJobCallback.Stub() {
        public void jobFinished(Bundle bundle, int i) {
            JobInvocation.Builder b = GooglePlayReceiver.m37199c().mo131192b(bundle);
            if (b == null) {
                Log.wtf(ExecutionDelegator.f52074a, "jobFinished: unknown invocation provided");
            } else {
                ExecutionDelegator.this.m37189a(b.build(), i);
            }
        }
    };

    /* renamed from: d */
    private final Context f52077d;

    /* renamed from: e */
    private final JobFinishedCallback f52078e;

    interface JobFinishedCallback {
        void onJobFinished(JobInvocation jobInvocation, int i);
    }

    /* renamed from: a */
    static C17820h m37186a(String str) {
        C17820h hVar;
        synchronized (f52075b) {
            hVar = f52075b.get(str);
        }
        return hVar;
    }

    /* renamed from: a */
    static void m37187a() {
        synchronized (f52075b) {
            f52075b.clear();
        }
    }

    ExecutionDelegator(Context context, JobFinishedCallback jobFinishedCallback) {
        this.f52077d = context;
        this.f52078e = jobFinishedCallback;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0071, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo131082a(com.firebase.jobdispatcher.JobInvocation r10) {
        /*
            r9 = this;
            if (r10 != 0) goto L_0x0003
            return
        L_0x0003:
            androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.h> r0 = f52075b
            monitor-enter(r0)
            androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.h> r1 = f52075b     // Catch:{ all -> 0x0072 }
            java.lang.String r2 = r10.getService()     // Catch:{ all -> 0x0072 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0072 }
            com.firebase.jobdispatcher.h r1 = (com.firebase.jobdispatcher.C17820h) r1     // Catch:{ all -> 0x0072 }
            if (r1 == 0) goto L_0x0028
            boolean r2 = r1.mo131195a()     // Catch:{ all -> 0x0072 }
            if (r2 != 0) goto L_0x0028
            boolean r2 = r1.mo131199c(r10)     // Catch:{ all -> 0x0072 }
            if (r2 == 0) goto L_0x003a
            boolean r2 = r1.mo131196b()     // Catch:{ all -> 0x0072 }
            if (r2 != 0) goto L_0x003a
            monitor-exit(r0)     // Catch:{ all -> 0x0072 }
            return
        L_0x0028:
            com.firebase.jobdispatcher.h r1 = new com.firebase.jobdispatcher.h     // Catch:{ all -> 0x0072 }
            com.firebase.jobdispatcher.IJobCallback r2 = r9.f52076c     // Catch:{ all -> 0x0072 }
            android.content.Context r3 = r9.f52077d     // Catch:{ all -> 0x0072 }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x0072 }
            androidx.collection.SimpleArrayMap<java.lang.String, com.firebase.jobdispatcher.h> r2 = f52075b     // Catch:{ all -> 0x0072 }
            java.lang.String r3 = r10.getService()     // Catch:{ all -> 0x0072 }
            r2.put(r3, r1)     // Catch:{ all -> 0x0072 }
        L_0x003a:
            boolean r2 = r1.mo131197b(r10)     // Catch:{ all -> 0x0072 }
            if (r2 != 0) goto L_0x0070
            android.content.Context r2 = r9.f52077d     // Catch:{ all -> 0x0072 }
            android.content.Intent r3 = r9.m37185a((com.firebase.jobdispatcher.JobParameters) r10)     // Catch:{ all -> 0x0072 }
            r4 = 1
            boolean r2 = r2.bindService(r3, r1, r4)     // Catch:{ all -> 0x0072 }
            if (r2 != 0) goto L_0x0070
            java.lang.String r4 = "FJD.ExternalReceiver"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0072 }
            r2.<init>()     // Catch:{ all -> 0x0072 }
            java.lang.String r3 = "Unable to bind to "
            r2.append(r3)     // Catch:{ all -> 0x0072 }
            java.lang.String r10 = r10.getService()     // Catch:{ all -> 0x0072 }
            r2.append(r10)     // Catch:{ all -> 0x0072 }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0072 }
            r3 = 6
            r6 = 0
            java.lang.String r7 = "com.firebase.jobdispatcher.ExecutionDelegator"
            r8 = 112(0x70, float:1.57E-43)
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0072 }
            r1.mo131198c()     // Catch:{ all -> 0x0072 }
        L_0x0070:
            monitor-exit(r0)     // Catch:{ all -> 0x0072 }
            return
        L_0x0072:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0072 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.ExecutionDelegator.mo131082a(com.firebase.jobdispatcher.JobInvocation):void");
    }

    /* renamed from: a */
    private Intent m37185a(JobParameters jobParameters) {
        Intent intent = new Intent("com.firebase.jobdispatcher.ACTION_EXECUTE");
        intent.setClassName(this.f52077d, jobParameters.getService());
        return intent;
    }

    /* renamed from: a */
    static void m37190a(JobInvocation jobInvocation, boolean z) {
        synchronized (f52075b) {
            C17820h hVar = f52075b.get(jobInvocation.getService());
            if (hVar != null) {
                hVar.mo131194a(jobInvocation, z);
                if (hVar.mo131195a()) {
                    f52075b.remove(jobInvocation.getService());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37189a(JobInvocation jobInvocation, int i) {
        synchronized (f52075b) {
            C17820h hVar = f52075b.get(jobInvocation.getService());
            if (hVar != null) {
                hVar.mo131193a(jobInvocation);
                if (hVar.mo131195a()) {
                    f52075b.remove(jobInvocation.getService());
                }
            }
        }
        this.f52078e.onJobFinished(jobInvocation, i);
    }
}
