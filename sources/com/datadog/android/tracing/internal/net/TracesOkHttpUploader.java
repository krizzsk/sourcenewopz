package com.datadog.android.tracing.internal.net;

import com.datadog.android.core.internal.net.DataOkHttpUploader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.Call;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0010\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\f"}, mo175978d2 = {"Lcom/datadog/android/tracing/internal/net/TracesOkHttpUploader;", "Lcom/datadog/android/core/internal/net/DataOkHttpUploader;", "endpoint", "", "token", "callFactory", "Lokhttp3/Call$Factory;", "(Ljava/lang/String;Ljava/lang/String;Lokhttp3/Call$Factory;)V", "buildQueryParams", "", "", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TracesOkHttpUploader.kt */
public class TracesOkHttpUploader extends DataOkHttpUploader {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String UPLOAD_URL = "%s/v1/input/%s";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TracesOkHttpUploader(String str, String str2, Call.Factory factory) {
        super(Companion.buildUrl(str, str2), factory, "text/plain;charset=UTF-8");
        Intrinsics.checkNotNullParameter(str, "endpoint");
        Intrinsics.checkNotNullParameter(str2, "token");
        Intrinsics.checkNotNullParameter(factory, "callFactory");
    }

    public Map<String, Object> buildQueryParams() {
        return MapsKt.emptyMap();
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/datadog/android/tracing/internal/net/TracesOkHttpUploader$Companion;", "", "()V", "UPLOAD_URL", "", "buildUrl", "endpoint", "token", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TracesOkHttpUploader.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final String buildUrl(String str, String str2) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.US, "%s/v1/input/%s", Arrays.copyOf(new Object[]{str, str2}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            return format;
        }
    }
}
