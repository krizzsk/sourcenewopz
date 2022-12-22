package com.datadog.android.tracing.internal.net;

import com.datadog.android.core.internal.net.DataOkHttpUploaderV2;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t¨\u0006\n"}, mo175978d2 = {"Lcom/datadog/android/tracing/internal/net/TracesOkHttpUploaderV2;", "Lcom/datadog/android/core/internal/net/DataOkHttpUploaderV2;", "endpoint", "", "clientToken", "source", "sdkVersion", "callFactory", "Lokhttp3/Call$Factory;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokhttp3/Call$Factory;)V", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TracesOkHttpUploaderV2.kt */
public class TracesOkHttpUploaderV2 extends DataOkHttpUploaderV2 {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TracesOkHttpUploaderV2(String str, String str2, String str3, String str4, Call.Factory factory) {
        super(DataOkHttpUploaderV2.Companion.buildUrl$dd_sdk_android_release(str, DataOkHttpUploaderV2.TrackType.SPANS), str2, str3, str4, factory, "text/plain;charset=UTF-8", RuntimeUtilsKt.getSdkLogger());
        Intrinsics.checkNotNullParameter(str, "endpoint");
        Intrinsics.checkNotNullParameter(str2, "clientToken");
        Intrinsics.checkNotNullParameter(str3, "source");
        Intrinsics.checkNotNullParameter(str4, "sdkVersion");
        Intrinsics.checkNotNullParameter(factory, "callFactory");
    }
}
