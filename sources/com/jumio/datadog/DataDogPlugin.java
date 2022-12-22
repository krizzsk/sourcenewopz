package com.jumio.datadog;

import android.content.Context;
import com.datadog.android.Datadog;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.rum.GlobalRum;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.RumResourceKind;
import com.jumio.commons.log.Log;
import com.jumio.core.Controller;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.plugins.AnalyticsPlugin;
import java.util.Map;
import jumio.datadog.C21394a;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016JA\u0010\u0013\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u000e\u0010\u0012\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J&\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u001aH\u0016J&\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u001aH\u0016¨\u0006 "}, mo175978d2 = {"Lcom/jumio/datadog/DataDogPlugin;", "Lcom/jumio/core/plugins/AnalyticsPlugin;", "Landroid/content/Context;", "context", "", "clientId", "appId", "", "run", "id", "url", "", "size", "method", "reportRequest", "statusCode", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "reportResponse", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILjava/lang/Exception;)V", "", "boolean", "enableDataCollection", "", "key", "", "attributes", "reportViewStart", "reportViewStop", "<init>", "()V", "jumio-datadog_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: DataDogPlugin.kt */
public final class DataDogPlugin implements AnalyticsPlugin {
    public void enableDataCollection(boolean z) {
        Log.m39456d("JDataDog", Intrinsics.stringPlus("Consent granted is set to ", Boolean.valueOf(z)));
        Datadog.setTrackingConsent(z ? TrackingConsent.GRANTED : TrackingConsent.NOT_GRANTED);
    }

    public boolean isUsable(Controller controller, ScanPartModel scanPartModel) {
        return AnalyticsPlugin.DefaultImpls.isUsable(this, controller, scanPartModel);
    }

    public void reportRequest(String str, String str2, int i, String str3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(str3, "method");
        if (GlobalRum.isRegistered()) {
            Log.m39456d("JDataDog", Intrinsics.stringPlus("Reporting network request ", str));
            GlobalRum.get().startResource(str, str3, str2, MapsKt.mapOf(TuplesKt.m42317to("Request Size", Integer.valueOf(i))));
            return;
        }
        Log.m39476w("JDataDog", "Skipping reporting network request " + str + " as RUM is not started");
    }

    public void reportResponse(String str, String str2, Integer num, int i, Exception exc) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "url");
        if (!GlobalRum.isRegistered()) {
            Log.m39476w("JDataDog", "Skipping reporting network response " + str + " as RUM is not started");
        } else if (exc == null) {
            Log.m39456d("JDataDog", Intrinsics.stringPlus("Reporting network response ", str));
            GlobalRum.get().stopResource(str, Integer.valueOf(i), num == null ? null : Long.valueOf((long) num.intValue()), RumResourceKind.OTHER, MapsKt.emptyMap());
        } else {
            Log.m39456d("JDataDog", "Reporting network response " + str + " with error");
            RumMonitor.DefaultImpls.stopResourceWithError$default(GlobalRum.get(), str, Integer.valueOf(i), "", RumErrorSource.NETWORK, exc, (Map) null, 32, (Object) null);
        }
    }

    public void reportViewStart(Object obj, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(obj, "key");
        Intrinsics.checkNotNullParameter(map, "attributes");
        if (GlobalRum.isRegistered()) {
            Log.m39456d("JDataDog", Intrinsics.stringPlus("Reporting view start for ", obj.getClass().getName()));
            RumMonitor rumMonitor = GlobalRum.get();
            String name = obj.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "key::class.java.name");
            rumMonitor.startView(obj, name, map);
            return;
        }
        Log.m39476w("JDataDog", "Skipping reporting view start for " + obj.getClass().getName() + " as RUM is not started");
    }

    public void reportViewStop(Object obj, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(obj, "key");
        Intrinsics.checkNotNullParameter(map, "attributes");
        if (GlobalRum.isRegistered()) {
            Log.m39456d("JDataDog", Intrinsics.stringPlus("Reporting view stop for ", obj.getClass().getName()));
            GlobalRum.get().stopView(obj, map);
            return;
        }
        Log.m39476w("JDataDog", "Skipping reporting view stop for " + obj.getClass().getName() + " as RUM is not started");
    }

    public void run(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "clientId");
        Intrinsics.checkNotNullParameter(str2, "appId");
        C21394a.f59689a.mo175898a(context, str, str2);
    }
}
