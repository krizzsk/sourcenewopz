package com.datadog.android.rum.internal.net;

import com.datadog.android.core.internal.net.DataOkHttpUploaderV2;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\b\u0010\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\u0010H\u0014R\u001b\u0010\n\u001a\u00020\u00038BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/net/RumOkHttpUploaderV2;", "Lcom/datadog/android/core/internal/net/DataOkHttpUploaderV2;", "endpoint", "", "clientToken", "source", "sdkVersion", "callFactory", "Lokhttp3/Call$Factory;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokhttp3/Call$Factory;)V", "tags", "getTags", "()Ljava/lang/String;", "tags$delegate", "Lkotlin/Lazy;", "buildQueryParameters", "", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RumOkHttpUploaderV2.kt */
public class RumOkHttpUploaderV2 extends DataOkHttpUploaderV2 {

    /* renamed from: a */
    private final Lazy f3888a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RumOkHttpUploaderV2(String str, String str2, String str3, String str4, Call.Factory factory) {
        super(DataOkHttpUploaderV2.Companion.buildUrl$dd_sdk_android_release(str, DataOkHttpUploaderV2.TrackType.RUM), str2, str3, str4, factory, "text/plain;charset=UTF-8", RuntimeUtilsKt.getSdkLogger());
        Intrinsics.checkNotNullParameter(str, "endpoint");
        Intrinsics.checkNotNullParameter(str2, "clientToken");
        Intrinsics.checkNotNullParameter(str3, "source");
        Intrinsics.checkNotNullParameter(str4, "sdkVersion");
        Intrinsics.checkNotNullParameter(factory, "callFactory");
        this.f3888a = LazyKt.lazy(new RumOkHttpUploaderV2$tags$2(str4));
    }

    /* renamed from: a */
    private final String m2513a() {
        return (String) this.f3888a.getValue();
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> buildQueryParameters() {
        return MapsKt.mapOf(TuplesKt.m42317to("ddsource", getSource$dd_sdk_android_release()), TuplesKt.m42317to("ddtags", m2513a()));
    }
}
