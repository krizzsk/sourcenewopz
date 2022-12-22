package com.firebase.jobdispatcher;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.firebase.jobdispatcher.JobInvocation;
import com.firebase.jobdispatcher.JobTrigger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.firebase.jobdispatcher.g */
/* compiled from: JobCoder */
final class C17819g {

    /* renamed from: b */
    private static final String f52208b = "uri_flags";

    /* renamed from: c */
    private static final String f52209c = "uris";

    /* renamed from: a */
    private final String f52210a;

    C17819g(String str) {
        this.f52210a = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Bundle mo131190a(JobParameters jobParameters, Bundle bundle) {
        if (bundle != null) {
            Bundle extras = jobParameters.getExtras();
            if (extras != null) {
                bundle.putAll(extras);
            }
            bundle.putInt(this.f52210a + "persistent", jobParameters.getLifetime());
            bundle.putBoolean(this.f52210a + "recurring", jobParameters.isRecurring());
            bundle.putBoolean(this.f52210a + "replace_current", jobParameters.shouldReplaceCurrent());
            bundle.putString(this.f52210a + "tag", jobParameters.getTag());
            bundle.putString(this.f52210a + "service", jobParameters.getService());
            bundle.putInt(this.f52210a + "constraints", Constraint.m37173a(jobParameters.getConstraints()));
            m37234a(jobParameters.getTrigger(), bundle);
            m37235a(jobParameters.getRetryStrategy(), bundle);
            return bundle;
        }
        throw new IllegalArgumentException("Unexpected null Bundle provided");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JobInvocation mo131191a(Bundle bundle) {
        if (bundle == null) {
            SystemUtils.log(6, "FJD.ExternalReceiver", "Unexpected null Bundle provided", (Throwable) null, "com.firebase.jobdispatcher.JobCoder", 77);
            return null;
        }
        Bundle bundle2 = bundle.getBundle("extras");
        if (bundle2 == null) {
            return null;
        }
        JobInvocation.Builder b = mo131192b(bundle2);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("triggered_uris");
        if (parcelableArrayList != null) {
            b.setTriggerReason(new TriggerReason(parcelableArrayList));
        }
        return b.build();
    }

    /* renamed from: b */
    public JobInvocation.Builder mo131192b(Bundle bundle) {
        if (bundle != null) {
            Bundle bundle2 = new Bundle(bundle);
            boolean z = bundle2.getBoolean(this.f52210a + "recurring");
            boolean z2 = bundle2.getBoolean(this.f52210a + "replace_current");
            int i = bundle2.getInt(this.f52210a + "persistent");
            int[] a = Constraint.m37174a(bundle2.getInt(this.f52210a + "constraints"));
            JobTrigger c = m37236c(bundle2);
            RetryStrategy d = m37237d(bundle2);
            String string = bundle2.getString(this.f52210a + "tag");
            String string2 = bundle2.getString(this.f52210a + "service");
            if (string == null || string2 == null || c == null || d == null) {
                return null;
            }
            JobInvocation.Builder builder = new JobInvocation.Builder();
            builder.setTag(string);
            builder.setService(string2);
            builder.setTrigger(c);
            builder.setRetryStrategy(d);
            builder.setRecurring(z);
            builder.setLifetime(i);
            builder.setConstraints(a);
            builder.setReplaceCurrent(z2);
            if (!TextUtils.isEmpty(this.f52210a)) {
                Iterator it = bundle2.keySet().iterator();
                while (it.hasNext()) {
                    if (((String) it.next()).startsWith(this.f52210a)) {
                        it.remove();
                    }
                }
            }
            builder.addExtras(bundle2);
            return builder;
        }
        throw new IllegalArgumentException("Unexpected null Bundle provided");
    }

    /* renamed from: c */
    private JobTrigger m37236c(Bundle bundle) {
        int i = bundle.getInt(this.f52210a + "trigger_type");
        if (i == 1) {
            int i2 = bundle.getInt(this.f52210a + "window_start");
            return Trigger.executionWindow(i2, bundle.getInt(this.f52210a + "window_end"));
        } else if (i == 2) {
            return Trigger.NOW;
        } else {
            if (i == 3) {
                return Trigger.contentUriTrigger(Collections.unmodifiableList(m37233a(bundle.getString(this.f52210a + "observed_uris"))));
            } else if (!Log.isLoggable("FJD.ExternalReceiver", 3)) {
                return null;
            } else {
                SystemUtils.log(3, "FJD.ExternalReceiver", "Unsupported trigger.", (Throwable) null, "com.firebase.jobdispatcher.JobCoder", 165);
                return null;
            }
        }
    }

    /* renamed from: a */
    private void m37234a(JobTrigger jobTrigger, Bundle bundle) {
        if (jobTrigger == Trigger.NOW) {
            bundle.putInt(this.f52210a + "trigger_type", 2);
        } else if (jobTrigger instanceof JobTrigger.ExecutionWindowTrigger) {
            JobTrigger.ExecutionWindowTrigger executionWindowTrigger = (JobTrigger.ExecutionWindowTrigger) jobTrigger;
            bundle.putInt(this.f52210a + "trigger_type", 1);
            bundle.putInt(this.f52210a + "window_start", executionWindowTrigger.getWindowStart());
            bundle.putInt(this.f52210a + "window_end", executionWindowTrigger.getWindowEnd());
        } else if (jobTrigger instanceof JobTrigger.ContentUriTrigger) {
            bundle.putInt(this.f52210a + "trigger_type", 3);
            String a = m37232a(((JobTrigger.ContentUriTrigger) jobTrigger).getUris());
            bundle.putString(this.f52210a + "observed_uris", a);
        } else {
            throw new IllegalArgumentException("Unsupported trigger.");
        }
    }

    /* renamed from: d */
    private RetryStrategy m37237d(Bundle bundle) {
        int i = bundle.getInt(this.f52210a + "retry_policy");
        if (i != 1 && i != 2) {
            return RetryStrategy.DEFAULT_EXPONENTIAL;
        }
        int i2 = bundle.getInt(this.f52210a + "initial_backoff_seconds");
        return new RetryStrategy(i, i2, bundle.getInt(this.f52210a + "maximum_backoff_seconds"));
    }

    /* renamed from: a */
    private void m37235a(RetryStrategy retryStrategy, Bundle bundle) {
        if (retryStrategy == null) {
            retryStrategy = RetryStrategy.DEFAULT_EXPONENTIAL;
        }
        bundle.putInt(this.f52210a + "retry_policy", retryStrategy.getPolicy());
        bundle.putInt(this.f52210a + "initial_backoff_seconds", retryStrategy.getInitialBackoff());
        bundle.putInt(this.f52210a + "maximum_backoff_seconds", retryStrategy.getMaximumBackoff());
    }

    /* renamed from: a */
    private static String m37232a(List<ObservedUri> list) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (ObservedUri next : list) {
            jSONArray.put(next.getFlags());
            jSONArray2.put(next.getUri());
        }
        try {
            jSONObject.put(f52208b, jSONArray);
            jSONObject.put("uris", jSONArray2);
            return jSONObject.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private static List<ObservedUri> m37233a(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray(f52208b);
            JSONArray jSONArray2 = jSONObject.getJSONArray("uris");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(new ObservedUri(Uri.parse(jSONArray2.getString(i)), jSONArray.getInt(i)));
            }
            return arrayList;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
