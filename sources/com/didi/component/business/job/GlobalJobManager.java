package com.didi.component.business.job;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Trigger;

public class GlobalJobManager {

    /* renamed from: a */
    private static volatile GlobalJobManager f11313a;

    /* renamed from: b */
    private Context f11314b;

    /* renamed from: c */
    private FirebaseJobDispatcher f11315c;

    private GlobalJobManager(Context context) {
        this.f11315c = new FirebaseJobDispatcher(new GooglePlayDriver(context.getApplicationContext()));
        this.f11314b = context.getApplicationContext();
    }

    public static GlobalJobManager getInstance(Context context) {
        if (f11313a == null) {
            synchronized (GlobalJobManager.class) {
                if (f11313a == null) {
                    f11313a = new GlobalJobManager(context);
                }
            }
        }
        return f11313a;
    }

    public String schedule(AbsJob absJob, int i) throws FirebaseJobDispatcher.ScheduleFailedException {
        return schedule(absJob, i, 30);
    }

    public String schedule(AbsJob absJob, int i, int i2) throws FirebaseJobDispatcher.ScheduleFailedException {
        if (this.f11315c == null) {
            return "";
        }
        String str = absJob.getClass().getSimpleName() + "-" + System.currentTimeMillis();
        Job build = this.f11315c.newJobBuilder().setService(GlobalJobDispatcher.class).setLifetime(1).setTag(str).setRecurring(false).setTrigger(Trigger.executionWindow(i, i2 + i)).setReplaceCurrent(true).build();
        absJob.mo46212a(str);
        absJob.mo46211a(this.f11314b);
        this.f11315c.mustSchedule(build);
        SystemUtils.log(4, "JobManager", "job is scheduled tag is " + str, (Throwable) null, "com.didi.component.business.job.GlobalJobManager", 89);
        JobMapping.m7629a().mo46226a(absJob);
        return str;
    }

    public void cancel(String str) {
        if (this.f11315c != null) {
            JobMapping.m7629a().mo46225a(str);
            this.f11315c.cancel(str);
        }
    }

    public void cancelAll() {
        if (this.f11315c != null) {
            JobMapping.m7629a().mo46227b();
            this.f11315c.cancelAll();
        }
    }

    public void destory() {
        FirebaseJobDispatcher firebaseJobDispatcher = this.f11315c;
        if (firebaseJobDispatcher != null) {
            firebaseJobDispatcher.cancelAll();
        }
        JobMapping.m7629a().mo46227b();
        this.f11315c = null;
        f11313a = null;
    }
}
