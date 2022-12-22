package com.datadog.android.rum.internal.net;

import com.datadog.android.core.internal.CoreFeature;
import com.datadog.android.core.internal.net.DataOkHttpUploader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.Call;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0010\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016R\u001b\u0010\b\u001a\u00020\u00038BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/net/RumOkHttpUploader;", "Lcom/datadog/android/core/internal/net/DataOkHttpUploader;", "endpoint", "", "token", "callFactory", "Lokhttp3/Call$Factory;", "(Ljava/lang/String;Ljava/lang/String;Lokhttp3/Call$Factory;)V", "tags", "getTags", "()Ljava/lang/String;", "tags$delegate", "Lkotlin/Lazy;", "buildQueryParams", "", "", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RumOkHttpUploader.kt */
public class RumOkHttpUploader extends DataOkHttpUploader {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String QP_TAGS = "ddtags";
    public static final String UPLOAD_URL = "%s/v1/input/%s";

    /* renamed from: a */
    private final Lazy f3887a = LazyKt.lazy(RumOkHttpUploader$tags$2.INSTANCE);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RumOkHttpUploader(String str, String str2, Call.Factory factory) {
        super(Companion.buildUrl(str, str2), factory, "text/plain;charset=UTF-8");
        Intrinsics.checkNotNullParameter(str, "endpoint");
        Intrinsics.checkNotNullParameter(str2, "token");
        Intrinsics.checkNotNullParameter(factory, "callFactory");
    }

    /* renamed from: a */
    private final String m2512a() {
        return (String) this.f3887a.getValue();
    }

    public Map<String, Object> buildQueryParams() {
        return MapsKt.mutableMapOf(TuplesKt.m42317to("ddsource", CoreFeature.INSTANCE.getSourceName$dd_sdk_android_release()), TuplesKt.m42317to("ddtags", m2512a()));
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/net/RumOkHttpUploader$Companion;", "", "()V", "QP_TAGS", "", "UPLOAD_URL", "buildUrl", "endpoint", "token", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: RumOkHttpUploader.kt */
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
