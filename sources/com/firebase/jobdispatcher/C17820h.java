package com.firebase.jobdispatcher;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.didi.sdk.apm.SystemUtils;
import com.firebase.jobdispatcher.IRemoteJobService;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* renamed from: com.firebase.jobdispatcher.h */
/* compiled from: JobServiceConnection */
class C17820h implements ServiceConnection {

    /* renamed from: a */
    private final Map<JobInvocation, Boolean> f52211a = new HashMap();

    /* renamed from: b */
    private final IJobCallback f52212b;

    /* renamed from: c */
    private final Context f52213c;

    /* renamed from: d */
    private boolean f52214d = false;

    /* renamed from: e */
    private IRemoteJobService f52215e;

    C17820h(IJobCallback iJobCallback, Context context) {
        this.f52212b = iJobCallback;
        this.f52213c = context;
    }

    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (mo131195a()) {
            SystemUtils.log(5, "FJD.ExternalReceiver", "Connection have been used already.", (Throwable) null, "com.firebase.jobdispatcher.JobServiceConnection", 62);
            return;
        }
        this.f52215e = IRemoteJobService.Stub.asInterface(iBinder);
        HashSet<JobInvocation> hashSet = new HashSet<>();
        for (Map.Entry next : this.f52211a.entrySet()) {
            if (Boolean.FALSE.equals(next.getValue())) {
                try {
                    this.f52215e.start(m37241a((JobParameters) next.getKey()), this.f52212b);
                    hashSet.add(next.getKey());
                } catch (RemoteException e) {
                    RemoteException remoteException = e;
                    SystemUtils.log(6, "FJD.ExternalReceiver", "Failed to start job " + next.getKey(), remoteException, "com.firebase.jobdispatcher.JobServiceConnection", 74);
                    mo131198c();
                    return;
                }
            }
        }
        for (JobInvocation put : hashSet) {
            this.f52211a.put(put, true);
        }
    }

    public synchronized void onServiceDisconnected(ComponentName componentName) {
        mo131198c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo131195a() {
        return this.f52214d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized boolean mo131196b() {
        return this.f52215e != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo131194a(JobInvocation jobInvocation, boolean z) {
        if (!mo131195a()) {
            if (Boolean.TRUE.equals(this.f52211a.remove(jobInvocation)) && mo131196b()) {
                m37242a(z, jobInvocation);
            }
            if (!z && this.f52211a.isEmpty()) {
                mo131198c();
            }
        } else {
            SystemUtils.log(5, "FJD.ExternalReceiver", "Can't send stop request because service was unbound.", (Throwable) null, "com.firebase.jobdispatcher.JobServiceConnection", 117);
        }
    }

    /* renamed from: a */
    private synchronized void m37242a(boolean z, JobInvocation jobInvocation) {
        try {
            this.f52215e.stop(m37241a((JobParameters) jobInvocation), z);
        } catch (RemoteException e) {
            SystemUtils.log(6, "FJD.ExternalReceiver", "Failed to stop a job", e, "com.firebase.jobdispatcher.JobServiceConnection", 125);
            mo131198c();
        }
        return;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized void mo131198c() {
        if (!mo131195a()) {
            this.f52215e = null;
            this.f52214d = true;
            try {
                this.f52213c.unbindService(this);
            } catch (IllegalArgumentException e) {
                SystemUtils.log(5, "FJD.ExternalReceiver", "Error unbinding service: " + e.getMessage(), (Throwable) null, "com.firebase.jobdispatcher.JobServiceConnection", 137);
            }
        }
        return;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo131193a(JobInvocation jobInvocation) {
        this.f52211a.remove(jobInvocation);
        if (this.f52211a.isEmpty()) {
            mo131198c();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized boolean mo131197b(JobInvocation jobInvocation) {
        boolean b;
        b = mo131196b();
        if (b) {
            if (Boolean.TRUE.equals(this.f52211a.get(jobInvocation))) {
                SystemUtils.log(5, "FJD.ExternalReceiver", "Received an execution request for already running job " + jobInvocation, (Throwable) null, "com.firebase.jobdispatcher.JobServiceConnection", 157);
                m37242a(false, jobInvocation);
            }
            try {
                this.f52215e.start(m37241a((JobParameters) jobInvocation), this.f52212b);
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                SystemUtils.log(6, "FJD.ExternalReceiver", "Failed to start the job " + jobInvocation, remoteException, "com.firebase.jobdispatcher.JobServiceConnection", 163);
                mo131198c();
                return false;
            }
        }
        this.f52211a.put(jobInvocation, Boolean.valueOf(b));
        return b;
    }

    /* renamed from: a */
    private static Bundle m37241a(JobParameters jobParameters) {
        return GooglePlayReceiver.m37199c().mo131190a(jobParameters, new Bundle());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized boolean mo131199c(JobInvocation jobInvocation) {
        return this.f52211a.containsKey(jobInvocation);
    }
}
