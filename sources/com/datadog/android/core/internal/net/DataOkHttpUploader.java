package com.datadog.android.core.internal.net;

import com.datadog.android.core.internal.CoreFeature;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b \u0018\u0000 \"2\u00020\u0001:\u0001\"B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00150\u0014H&J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0014\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010!\u001a\u00020\u0003H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000b\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00038BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0010\u0010\u000b¨\u0006#"}, mo175978d2 = {"Lcom/datadog/android/core/internal/net/DataOkHttpUploader;", "Lcom/datadog/android/core/internal/net/DataUploader;", "url", "", "callFactory", "Lokhttp3/Call$Factory;", "contentType", "(Ljava/lang/String;Lokhttp3/Call$Factory;Ljava/lang/String;)V", "getCallFactory$dd_sdk_android_release", "()Lokhttp3/Call$Factory;", "getContentType$dd_sdk_android_release", "()Ljava/lang/String;", "getUrl$dd_sdk_android_release", "setUrl$dd_sdk_android_release", "(Ljava/lang/String;)V", "userAgent", "getUserAgent", "userAgent$delegate", "Lkotlin/Lazy;", "buildQueryParams", "", "", "buildRequest", "Lokhttp3/Request;", "data", "", "headers", "", "responseCodeToUploadStatus", "Lcom/datadog/android/core/internal/net/UploadStatus;", "code", "", "upload", "urlWithQueryParams", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DataOkHttpUploader.kt */
public abstract class DataOkHttpUploader implements DataUploader {
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String CONTENT_TYPE_TEXT_UTF8 = "text/plain;charset=UTF-8";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String QP_BATCH_TIME = "batch_time";
    public static final String QP_SOURCE = "ddsource";
    public static final String SYSTEM_UA = "http.agent";

    /* renamed from: e */
    private static final String f3474e = "active_threads";

    /* renamed from: f */
    private static final String f3475f = "Content-Type";

    /* renamed from: g */
    private static final String f3476g = "User-Agent";

    /* renamed from: a */
    private String f3477a;

    /* renamed from: b */
    private final Call.Factory f3478b;

    /* renamed from: c */
    private final String f3479c;

    /* renamed from: d */
    private final Lazy f3480d;

    public abstract Map<String, Object> buildQueryParams();

    public DataOkHttpUploader(String str, Call.Factory factory, String str2) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(factory, "callFactory");
        Intrinsics.checkNotNullParameter(str2, "contentType");
        this.f3477a = str;
        this.f3478b = factory;
        this.f3479c = str2;
        this.f3480d = LazyKt.lazy(DataOkHttpUploader$userAgent$2.INSTANCE);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DataOkHttpUploader(String str, Call.Factory factory, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, factory, (i & 4) != 0 ? "application/json" : str2);
    }

    public final String getUrl$dd_sdk_android_release() {
        return this.f3477a;
    }

    public final void setUrl$dd_sdk_android_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f3477a = str;
    }

    public final Call.Factory getCallFactory$dd_sdk_android_release() {
        return this.f3478b;
    }

    public final String getContentType$dd_sdk_android_release() {
        return this.f3479c;
    }

    public UploadStatus upload(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        try {
            Response execute = this.f3478b.newCall(m2320a(bArr)).execute();
            execute.close();
            return m2318a(execute.code());
        } catch (Throwable th) {
            RuntimeUtilsKt.getSdkLogger().mo20185e("Unable to upload batch data.", th, MapsKt.mapOf(TuplesKt.m42317to(f3474e, Integer.valueOf(CoreFeature.INSTANCE.getUploadExecutorService$dd_sdk_android_release().getActiveCount()))));
            return UploadStatus.NETWORK_ERROR;
        }
    }

    /* renamed from: a */
    private final Map<String, String> m2319a() {
        return MapsKt.mutableMapOf(TuplesKt.m42317to("User-Agent", m2321b()), TuplesKt.m42317to("Content-Type", this.f3479c));
    }

    /* renamed from: b */
    private final String m2321b() {
        return (String) this.f3480d.getValue();
    }

    /* renamed from: a */
    private final Request m2320a(byte[] bArr) {
        Request.Builder post = new Request.Builder().url(m2322c()).post(RequestBody.create((MediaType) null, bArr));
        for (Map.Entry next : m2319a().entrySet()) {
            post.addHeader((String) next.getKey(), (String) next.getValue());
        }
        Request build = post.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    /* renamed from: c */
    private final String m2322c() {
        Map<String, Object> buildQueryParams = buildQueryParams();
        if (buildQueryParams.isEmpty()) {
            return this.f3477a;
        }
        String str = this.f3477a;
        Collection arrayList = new ArrayList(buildQueryParams.size());
        for (Map.Entry next : buildQueryParams.entrySet()) {
            arrayList.add(((String) next.getKey()) + '=' + next.getValue());
        }
        return Intrinsics.stringPlus(str, CollectionsKt.joinToString$default((List) arrayList, ParamKeys.SIGN_AND, "?", (CharSequence) null, 0, (CharSequence) null, (Function1) null, 60, (Object) null));
    }

    /* renamed from: a */
    private final UploadStatus m2318a(int i) {
        if (i == 403) {
            return UploadStatus.INVALID_TOKEN_ERROR;
        }
        boolean z = true;
        if (200 <= i && i <= 299) {
            return UploadStatus.SUCCESS;
        }
        if (300 <= i && i <= 399) {
            return UploadStatus.HTTP_REDIRECTION;
        }
        if (400 <= i && i <= 499) {
            return UploadStatus.HTTP_CLIENT_ERROR;
        }
        if (500 > i || i > 599) {
            z = false;
        }
        if (z) {
            return UploadStatus.HTTP_SERVER_ERROR;
        }
        return UploadStatus.UNKNOWN_ERROR;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/datadog/android/core/internal/net/DataOkHttpUploader$Companion;", "", "()V", "ACTIVE_THREADS_LOG_ATTRIBUTE_KEY", "", "CONTENT_TYPE_JSON", "CONTENT_TYPE_TEXT_UTF8", "HEADER_CT", "HEADER_UA", "QP_BATCH_TIME", "QP_SOURCE", "SYSTEM_UA", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: DataOkHttpUploader.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
