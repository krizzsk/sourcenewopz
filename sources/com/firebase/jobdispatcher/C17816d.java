package com.firebase.jobdispatcher;

import android.net.Uri;
import android.os.Bundle;
import com.firebase.jobdispatcher.JobTrigger;

/* renamed from: com.firebase.jobdispatcher.d */
/* compiled from: GooglePlayJobWriter */
final class C17816d {

    /* renamed from: a */
    static final String f52178a = "update_current";

    /* renamed from: b */
    static final String f52179b = "extras";

    /* renamed from: c */
    static final String f52180c = "persisted";

    /* renamed from: d */
    static final String f52181d = "requiredNetwork";

    /* renamed from: e */
    static final String f52182e = "requiresCharging";

    /* renamed from: f */
    static final String f52183f = "requiresIdle";

    /* renamed from: g */
    static final String f52184g = "retryStrategy";

    /* renamed from: h */
    static final String f52185h = "service";

    /* renamed from: i */
    static final String f52186i = "tag";

    /* renamed from: j */
    static final String f52187j = "initial_backoff_seconds";

    /* renamed from: k */
    static final String f52188k = "maximum_backoff_seconds";

    /* renamed from: l */
    static final String f52189l = "retry_policy";

    /* renamed from: m */
    static final String f52190m = "trigger_type";

    /* renamed from: n */
    static final String f52191n = "window_end";

    /* renamed from: o */
    static final String f52192o = "period_flex";

    /* renamed from: p */
    static final String f52193p = "period";

    /* renamed from: q */
    static final String f52194q = "window_start";

    /* renamed from: r */
    static final int f52195r = 0;

    /* renamed from: s */
    static final int f52196s = 1;

    /* renamed from: t */
    static final int f52197t = 1;

    /* renamed from: u */
    static final int f52198u = 0;

    /* renamed from: v */
    static final int f52199v = 2;

    /* renamed from: w */
    private final C17819g f52200w = new C17819g("com.firebase.jobdispatcher.");

    /* renamed from: a */
    private static int m37220a(int i) {
        return i != 2 ? 0 : 1;
    }

    /* renamed from: b */
    private static int m37224b(int i) {
        int i2 = 2;
        if ((i & 2) == 2) {
            i2 = 0;
        }
        if ((i & 1) == 1) {
            return 1;
        }
        return i2;
    }

    C17816d() {
    }

    /* renamed from: a */
    private static void m37223a(JobParameters jobParameters, Bundle bundle, JobTrigger.ExecutionWindowTrigger executionWindowTrigger) {
        bundle.putInt(f52190m, 1);
        if (jobParameters.isRecurring()) {
            bundle.putLong("period", (long) executionWindowTrigger.getWindowEnd());
            bundle.putLong(f52192o, (long) (executionWindowTrigger.getWindowEnd() - executionWindowTrigger.getWindowStart()));
            return;
        }
        bundle.putLong(f52194q, (long) executionWindowTrigger.getWindowStart());
        bundle.putLong(f52191n, (long) executionWindowTrigger.getWindowEnd());
    }

    /* renamed from: a */
    private static void m37221a(Bundle bundle) {
        bundle.putInt(f52190m, 2);
        bundle.putLong(f52194q, 0);
        bundle.putLong(f52191n, 1);
    }

    /* renamed from: a */
    private static void m37222a(Bundle bundle, JobTrigger.ContentUriTrigger contentUriTrigger) {
        bundle.putInt(f52190m, 3);
        int size = contentUriTrigger.getUris().size();
        int[] iArr = new int[size];
        Uri[] uriArr = new Uri[size];
        for (int i = 0; i < size; i++) {
            ObservedUri observedUri = contentUriTrigger.getUris().get(i);
            iArr[i] = observedUri.getFlags();
            uriArr[i] = observedUri.getUri();
        }
        bundle.putIntArray("content_uri_flags_array", iArr);
        bundle.putParcelableArray("content_uri_array", uriArr);
    }

    /* renamed from: a */
    public Bundle mo131188a(JobParameters jobParameters, Bundle bundle) {
        bundle.putString("tag", jobParameters.getTag());
        bundle.putBoolean(f52178a, jobParameters.shouldReplaceCurrent());
        bundle.putBoolean(f52180c, jobParameters.getLifetime() == 2);
        bundle.putString("service", GooglePlayReceiver.class.getName());
        m37226c(jobParameters, bundle);
        m37227d(jobParameters, bundle);
        m37225b(jobParameters, bundle);
        Bundle extras = jobParameters.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        bundle.putBundle("extras", this.f52200w.mo131190a(jobParameters, extras));
        return bundle;
    }

    /* renamed from: b */
    private static void m37225b(JobParameters jobParameters, Bundle bundle) {
        RetryStrategy retryStrategy = jobParameters.getRetryStrategy();
        Bundle bundle2 = new Bundle();
        bundle2.putInt(f52189l, m37220a(retryStrategy.getPolicy()));
        bundle2.putInt(f52187j, retryStrategy.getInitialBackoff());
        bundle2.putInt(f52188k, retryStrategy.getMaximumBackoff());
        bundle.putBundle(f52184g, bundle2);
    }

    /* renamed from: c */
    private static void m37226c(JobParameters jobParameters, Bundle bundle) {
        JobTrigger trigger = jobParameters.getTrigger();
        if (trigger == Trigger.NOW) {
            m37221a(bundle);
        } else if (trigger instanceof JobTrigger.ExecutionWindowTrigger) {
            m37223a(jobParameters, bundle, (JobTrigger.ExecutionWindowTrigger) trigger);
        } else if (trigger instanceof JobTrigger.ContentUriTrigger) {
            m37222a(bundle, (JobTrigger.ContentUriTrigger) trigger);
        } else {
            throw new IllegalArgumentException("Unknown trigger: " + trigger.getClass());
        }
    }

    /* renamed from: d */
    private static void m37227d(JobParameters jobParameters, Bundle bundle) {
        int a = Constraint.m37173a(jobParameters.getConstraints());
        boolean z = true;
        bundle.putBoolean(f52182e, (a & 4) == 4);
        if ((a & 8) != 8) {
            z = false;
        }
        bundle.putBoolean(f52183f, z);
        bundle.putInt(f52181d, m37224b(a));
    }
}
