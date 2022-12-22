package com.firebase.jobdispatcher;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public final class GooglePlayDriver implements Driver {

    /* renamed from: a */
    static final String f52082a = "com.google.android.gms";

    /* renamed from: b */
    private static final String f52083b = "com.google.android.gms.gcm.ACTION_SCHEDULE";

    /* renamed from: c */
    private static final String f52084c = "scheduler_action";

    /* renamed from: d */
    private static final String f52085d = "tag";

    /* renamed from: e */
    private static final String f52086e = "app";

    /* renamed from: f */
    private static final String f52087f = "component";

    /* renamed from: g */
    private static final String f52088g = "SCHEDULE_TASK";

    /* renamed from: h */
    private static final String f52089h = "CANCEL_TASK";

    /* renamed from: i */
    private static final String f52090i = "CANCEL_ALL";

    /* renamed from: j */
    private static final String f52091j = "source";

    /* renamed from: k */
    private static final String f52092k = "source_version";

    /* renamed from: l */
    private static final int f52093l = 8;

    /* renamed from: m */
    private static final int f52094m = 1;

    /* renamed from: n */
    private final JobValidator f52095n;

    /* renamed from: o */
    private final Context f52096o;

    /* renamed from: p */
    private final PendingIntent f52097p;

    /* renamed from: q */
    private final C17816d f52098q;

    /* renamed from: r */
    private final boolean f52099r = true;

    public boolean isAvailable() {
        return true;
    }

    public GooglePlayDriver(Context context) {
        this.f52096o = context;
        this.f52097p = PendingIntent.getBroadcast(context, 0, new Intent(), 0);
        this.f52098q = new C17816d();
        this.f52095n = new DefaultJobValidator(context);
    }

    public int schedule(Job job) {
        GooglePlayReceiver.m37195a(job);
        this.f52096o.sendBroadcast(m37192a((JobParameters) job));
        return 0;
    }

    public int cancel(String str) {
        this.f52096o.sendBroadcast(createCancelRequest(str));
        return 0;
    }

    public int cancelAll() {
        this.f52096o.sendBroadcast(createBatchCancelRequest());
        return 0;
    }

    /* access modifiers changed from: protected */
    public Intent createCancelRequest(String str) {
        Intent a = m37193a(f52089h);
        a.putExtra("tag", str);
        a.putExtra(f52087f, new ComponentName(this.f52096o, getReceiverClass()));
        return a;
    }

    /* access modifiers changed from: protected */
    public Intent createBatchCancelRequest() {
        Intent a = m37193a(f52090i);
        a.putExtra(f52087f, new ComponentName(this.f52096o, getReceiverClass()));
        return a;
    }

    /* access modifiers changed from: protected */
    public Class<GooglePlayReceiver> getReceiverClass() {
        return GooglePlayReceiver.class;
    }

    public JobValidator getValidator() {
        return this.f52095n;
    }

    /* renamed from: a */
    private Intent m37192a(JobParameters jobParameters) {
        Intent a = m37193a(f52088g);
        a.putExtras(this.f52098q.mo131188a(jobParameters, a.getExtras()));
        return a;
    }

    /* renamed from: a */
    private Intent m37193a(String str) {
        Intent intent = new Intent(f52083b);
        intent.setPackage("com.google.android.gms");
        intent.putExtra(f52084c, str);
        intent.putExtra("app", this.f52097p);
        intent.putExtra("source", 8);
        intent.putExtra(f52092k, 1);
        return intent;
    }
}
