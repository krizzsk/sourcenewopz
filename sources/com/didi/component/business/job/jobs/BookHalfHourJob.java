package com.didi.component.business.job.jobs;

import com.didi.component.business.job.AbsJob;
import com.didi.component.business.util.NotificationUtils;
import com.firebase.jobdispatcher.JobParameters;

public class BookHalfHourJob extends AbsJob {

    /* renamed from: a */
    private String f11317a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f11318b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f11319c;

    public BookHalfHourJob(String str, String str2, String str3) {
        this.f11317a = str;
        this.f11318b = str2;
        this.f11319c = str3;
    }

    /* access modifiers changed from: protected */
    public void onJobExecution(JobParameters jobParameters) {
        this.mHandler.post(new Runnable() {
            public void run() {
                NotificationUtils.getInstance(BookHalfHourJob.this.mContext).showNotification(BookHalfHourJob.this.f11318b, BookHalfHourJob.this.f11319c);
            }
        });
    }
}
