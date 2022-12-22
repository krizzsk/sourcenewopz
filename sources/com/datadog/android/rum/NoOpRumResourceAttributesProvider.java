package com.datadog.android.rum;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/datadog/android/rum/NoOpRumResourceAttributesProvider;", "Lcom/datadog/android/rum/RumResourceAttributesProvider;", "()V", "onProvideAttributes", "", "", "", "request", "Lokhttp3/Request;", "response", "Lokhttp3/Response;", "throwable", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NoOpRumResourceAttributesProvider.kt */
public final class NoOpRumResourceAttributesProvider implements RumResourceAttributesProvider {
    public Map<String, Object> onProvideAttributes(Request request, Response response, Throwable th) {
        Intrinsics.checkNotNullParameter(request, "request");
        return MapsKt.emptyMap();
    }
}
