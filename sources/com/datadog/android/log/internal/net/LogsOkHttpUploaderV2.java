package com.datadog.android.log.internal.net;

import com.datadog.android.core.internal.net.DataOkHttpUploaderV2;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\b\u0010\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\rH\u0014¨\u0006\u000f"}, mo175978d2 = {"Lcom/datadog/android/log/internal/net/LogsOkHttpUploaderV2;", "Lcom/datadog/android/core/internal/net/DataOkHttpUploaderV2;", "endpoint", "", "clientToken", "source", "sdkVersion", "callFactory", "Lokhttp3/Call$Factory;", "internalLogger", "Lcom/datadog/android/log/Logger;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokhttp3/Call$Factory;Lcom/datadog/android/log/Logger;)V", "buildQueryParameters", "", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LogsOkHttpUploaderV2.kt */
public class LogsOkHttpUploaderV2 extends DataOkHttpUploaderV2 {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LogsOkHttpUploaderV2(java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, okhttp3.Call.Factory r15, com.datadog.android.log.Logger r16) {
        /*
            r10 = this;
            r0 = r11
            java.lang.String r1 = "endpoint"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r1)
            java.lang.String r1 = "clientToken"
            r4 = r12
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            java.lang.String r1 = "source"
            r5 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r1)
            java.lang.String r1 = "sdkVersion"
            r6 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r1)
            java.lang.String r1 = "callFactory"
            r7 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            java.lang.String r1 = "internalLogger"
            r9 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            com.datadog.android.core.internal.net.DataOkHttpUploaderV2$Companion r1 = com.datadog.android.core.internal.net.DataOkHttpUploaderV2.Companion
            com.datadog.android.core.internal.net.DataOkHttpUploaderV2$TrackType r2 = com.datadog.android.core.internal.net.DataOkHttpUploaderV2.TrackType.LOGS
            java.lang.String r3 = r1.buildUrl$dd_sdk_android_release(r11, r2)
            java.lang.String r8 = "application/json"
            r2 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.log.internal.net.LogsOkHttpUploaderV2.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, okhttp3.Call$Factory, com.datadog.android.log.Logger):void");
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> buildQueryParameters() {
        return MapsKt.mapOf(TuplesKt.m42317to("ddsource", getSource$dd_sdk_android_release()));
    }
}
