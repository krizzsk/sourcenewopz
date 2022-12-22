package com.didi.component.business.job;

import com.didi.sdk.apm.SystemUtils;
import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class GlobalJobDispatcher extends JobService {

    /* renamed from: c */
    private static ExecutorService f11311c = Executors.newCachedThreadPool();

    /* renamed from: d */
    private Future f11312d;

    public final boolean onStartJob(final JobParameters jobParameters) {
        String tag = jobParameters.getTag();
        SystemUtils.log(4, "JobManager", "dispatcher " + hashCode() + " is running, we'll take: " + tag + " job and run it.", (Throwable) null, "com.didi.component.business.job.GlobalJobDispatcher", 38);
        final AbsJob a = JobMapping.m7629a().mo46225a(tag);
        if (a == null) {
            SystemUtils.log(6, "JobManager", "the job is null tag is:" + jobParameters.getTag(), (Throwable) null, "com.didi.component.business.job.GlobalJobDispatcher", 41);
            return false;
        }
        this.f11312d = f11311c.submit(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
                com.didi.component.business.job.JobMapping.m7629a().mo46226a(r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
                r4.this$0.jobFinished(r10, r0.mo46213b());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0034, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:3:0x000d, code lost:
                if (r0.mo46213b() != false) goto L_0x001e;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
                if (r0.mo46213b() == false) goto L_0x0027;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r4 = this;
                    com.didi.component.business.job.AbsJob r0 = r0     // Catch:{ Exception -> 0x0012 }
                    com.firebase.jobdispatcher.JobParameters r1 = r10     // Catch:{ Exception -> 0x0012 }
                    r0.onJobExecution(r1)     // Catch:{ Exception -> 0x0012 }
                    com.didi.component.business.job.AbsJob r0 = r0
                    boolean r0 = r0.mo46213b()
                    if (r0 == 0) goto L_0x0027
                    goto L_0x001e
                L_0x0010:
                    r0 = move-exception
                    goto L_0x0035
                L_0x0012:
                    r0 = move-exception
                    r0.printStackTrace()     // Catch:{ all -> 0x0010 }
                    com.didi.component.business.job.AbsJob r0 = r0
                    boolean r0 = r0.mo46213b()
                    if (r0 == 0) goto L_0x0027
                L_0x001e:
                    com.didi.component.business.job.JobMapping r0 = com.didi.component.business.job.JobMapping.m7629a()
                    com.didi.component.business.job.AbsJob r1 = r0
                    r0.mo46226a((com.didi.component.business.job.AbsJob) r1)
                L_0x0027:
                    com.didi.component.business.job.GlobalJobDispatcher r0 = com.didi.component.business.job.GlobalJobDispatcher.this
                    com.firebase.jobdispatcher.JobParameters r1 = r10
                    com.didi.component.business.job.AbsJob r2 = r0
                    boolean r2 = r2.mo46213b()
                    r0.jobFinished(r1, r2)
                    return
                L_0x0035:
                    com.didi.component.business.job.AbsJob r1 = r0
                    boolean r1 = r1.mo46213b()
                    if (r1 == 0) goto L_0x0046
                    com.didi.component.business.job.JobMapping r1 = com.didi.component.business.job.JobMapping.m7629a()
                    com.didi.component.business.job.AbsJob r2 = r0
                    r1.mo46226a((com.didi.component.business.job.AbsJob) r2)
                L_0x0046:
                    com.didi.component.business.job.GlobalJobDispatcher r1 = com.didi.component.business.job.GlobalJobDispatcher.this
                    com.firebase.jobdispatcher.JobParameters r2 = r10
                    com.didi.component.business.job.AbsJob r3 = r0
                    boolean r3 = r3.mo46213b()
                    r1.jobFinished(r2, r3)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.component.business.job.GlobalJobDispatcher.C46311.run():void");
            }
        });
        return true;
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        Future future = this.f11312d;
        if (future == null) {
            return false;
        }
        future.cancel(true);
        return false;
    }
}
