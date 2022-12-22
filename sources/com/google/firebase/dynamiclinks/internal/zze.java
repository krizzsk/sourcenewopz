package com.google.firebase.dynamiclinks.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.dynamiclinks.ShortDynamicLink;

/* compiled from: com.google.firebase:firebase-dynamic-links@@19.0.0 */
public final class zze extends FirebaseDynamicLinks {
    private final GoogleApi<Api.ApiOptions.NoOptions> zzq;
    private final AnalyticsConnector zzr;

    public zze(FirebaseApp firebaseApp, AnalyticsConnector analyticsConnector) {
        this((GoogleApi<Api.ApiOptions.NoOptions>) new zzc(firebaseApp.getApplicationContext()), analyticsConnector);
    }

    private zze(GoogleApi<Api.ApiOptions.NoOptions> googleApi, AnalyticsConnector analyticsConnector) {
        this.zzq = googleApi;
        this.zzr = analyticsConnector;
        if (analyticsConnector == null) {
            SystemUtils.log(5, "FDL", "FDL logging failed. Add a dependency for Firebase Analytics to your app to enable logging of Dynamic Link events.", (Throwable) null, "com.google.firebase.dynamiclinks.internal.zze", 7);
        }
    }

    public final Task<PendingDynamicLinkData> getDynamicLink(Intent intent) {
        Task<TResult> doWrite = this.zzq.doWrite(new zzl(this.zzr, intent.getDataString()));
        DynamicLinkData dynamicLinkData = (DynamicLinkData) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "com.google.firebase.dynamiclinks.DYNAMIC_LINK_DATA", DynamicLinkData.CREATOR);
        PendingDynamicLinkData pendingDynamicLinkData = dynamicLinkData != null ? new PendingDynamicLinkData(dynamicLinkData) : null;
        return pendingDynamicLinkData != null ? Tasks.forResult(pendingDynamicLinkData) : doWrite;
    }

    public final Task<PendingDynamicLinkData> getDynamicLink(Uri uri) {
        return this.zzq.doWrite(new zzl(this.zzr, uri.toString()));
    }

    public final DynamicLink.Builder createDynamicLink() {
        return new DynamicLink.Builder(this);
    }

    public final Task<ShortDynamicLink> zza(Bundle bundle) {
        zzb(bundle);
        return this.zzq.doWrite(new zzj(bundle));
    }

    public static void zzb(Bundle bundle) {
        Uri uri = (Uri) bundle.getParcelable("dynamicLink");
        if (TextUtils.isEmpty(bundle.getString("domainUriPrefix")) && uri == null) {
            throw new IllegalArgumentException("FDL domain is missing. Set with setDomainUriPrefix() or setDynamicLinkDomain().");
        }
    }
}
