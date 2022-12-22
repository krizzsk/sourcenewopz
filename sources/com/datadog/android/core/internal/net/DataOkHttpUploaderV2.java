package com.datadog.android.core.internal.net;

import com.datadog.android.DatadogInterceptor;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.log.Logger;
import com.datadog.android.tracing.internal.domain.event.SpanEventSerializer;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Metadata(mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b \u0018\u0000 22\u00020\u0001:\u000223B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0003H\u0002J\u0014\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020&0%H\u0014J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010#\u001a\u00020\u0003H\u0002J\b\u0010+\u001a\u00020\u0003H\u0002J\u0018\u0010,\u001a\u00020-2\u0006\u0010)\u001a\u00020*2\u0006\u0010#\u001a\u00020\u0003H\u0002J\u0010\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020-2\u0006\u0010)\u001a\u00020*H\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0010\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0016\u0010\u0019\u001a\n \u001a*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u00038BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001c\u0010\u0010¨\u00064"}, mo175978d2 = {"Lcom/datadog/android/core/internal/net/DataOkHttpUploaderV2;", "Lcom/datadog/android/core/internal/net/DataUploader;", "intakeUrl", "", "clientToken", "source", "sdkVersion", "callFactory", "Lokhttp3/Call$Factory;", "contentType", "internalLogger", "Lcom/datadog/android/log/Logger;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokhttp3/Call$Factory;Ljava/lang/String;Lcom/datadog/android/log/Logger;)V", "getCallFactory$dd_sdk_android_release", "()Lokhttp3/Call$Factory;", "getClientToken$dd_sdk_android_release", "()Ljava/lang/String;", "getContentType$dd_sdk_android_release", "getIntakeUrl$dd_sdk_android_release", "setIntakeUrl$dd_sdk_android_release", "(Ljava/lang/String;)V", "getInternalLogger$dd_sdk_android_release", "()Lcom/datadog/android/log/Logger;", "getSdkVersion$dd_sdk_android_release", "getSource$dd_sdk_android_release", "uploaderName", "kotlin.jvm.PlatformType", "userAgent", "getUserAgent", "userAgent$delegate", "Lkotlin/Lazy;", "buildHeaders", "", "builder", "Lokhttp3/Request$Builder;", "requestId", "buildQueryParameters", "", "", "buildRequest", "Lokhttp3/Request;", "data", "", "buildUrl", "executeUploadRequest", "Lcom/datadog/android/core/internal/net/UploadStatus;", "responseCodeToUploadStatus", "code", "", "upload", "Companion", "TrackType", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DataOkHttpUploaderV2.kt */
public abstract class DataOkHttpUploaderV2 implements DataUploader {
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String CONTENT_TYPE_TEXT_UTF8 = "text/plain;charset=UTF-8";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String HEADER_API_KEY = "DD-API-KEY";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_EVP_ORIGIN = "DD-EVP-ORIGIN";
    public static final String HEADER_EVP_ORIGIN_VERSION = "DD-EVP-ORIGIN-VERSION";
    public static final String HEADER_REQUEST_ID = "DD-REQUEST-ID";
    public static final String HEADER_USER_AGENT = "User-Agent";
    public static final int HTTP_ACCEPTED = 202;
    public static final int HTTP_BAD_REQUEST = 400;
    public static final int HTTP_CLIENT_TIMEOUT = 408;
    public static final int HTTP_ENTITY_TOO_LARGE = 413;
    public static final int HTTP_FORBIDDEN = 403;
    public static final int HTTP_INTERNAL_ERROR = 500;
    public static final int HTTP_TOO_MANY_REQUESTS = 429;
    public static final int HTTP_UNAUTHORIZED = 401;
    public static final int HTTP_UNAVAILABLE = 503;
    public static final String QUERY_PARAM_SOURCE = "ddsource";
    public static final String QUERY_PARAM_TAGS = "ddtags";

    /* renamed from: j */
    private static final String f3481j = "%s/api/v2/%s";

    /* renamed from: a */
    private String f3482a;

    /* renamed from: b */
    private final String f3483b;

    /* renamed from: c */
    private final String f3484c;

    /* renamed from: d */
    private final String f3485d;

    /* renamed from: e */
    private final Call.Factory f3486e;

    /* renamed from: f */
    private final String f3487f;

    /* renamed from: g */
    private final Logger f3488g;

    /* renamed from: h */
    private final String f3489h = getClass().getSimpleName();

    /* renamed from: i */
    private final Lazy f3490i = LazyKt.lazy(new DataOkHttpUploaderV2$userAgent$2(this));

    public DataOkHttpUploaderV2(String str, String str2, String str3, String str4, Call.Factory factory, String str5, Logger logger) {
        Intrinsics.checkNotNullParameter(str, "intakeUrl");
        Intrinsics.checkNotNullParameter(str2, "clientToken");
        Intrinsics.checkNotNullParameter(str3, "source");
        Intrinsics.checkNotNullParameter(str4, "sdkVersion");
        Intrinsics.checkNotNullParameter(factory, "callFactory");
        Intrinsics.checkNotNullParameter(str5, "contentType");
        Intrinsics.checkNotNullParameter(logger, "internalLogger");
        this.f3482a = str;
        this.f3483b = str2;
        this.f3484c = str3;
        this.f3485d = str4;
        this.f3486e = factory;
        this.f3487f = str5;
        this.f3488g = logger;
    }

    public final String getIntakeUrl$dd_sdk_android_release() {
        return this.f3482a;
    }

    public final void setIntakeUrl$dd_sdk_android_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f3482a = str;
    }

    public final String getClientToken$dd_sdk_android_release() {
        return this.f3483b;
    }

    public final String getSource$dd_sdk_android_release() {
        return this.f3484c;
    }

    public final String getSdkVersion$dd_sdk_android_release() {
        return this.f3485d;
    }

    public final Call.Factory getCallFactory$dd_sdk_android_release() {
        return this.f3486e;
    }

    public final String getContentType$dd_sdk_android_release() {
        return this.f3487f;
    }

    public final Logger getInternalLogger$dd_sdk_android_release() {
        return this.f3488g;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, mo175978d2 = {"Lcom/datadog/android/core/internal/net/DataOkHttpUploaderV2$TrackType;", "", "trackName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTrackName", "()Ljava/lang/String;", "LOGS", "RUM", "SPANS", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: DataOkHttpUploaderV2.kt */
    public enum TrackType {
        LOGS("logs"),
        RUM(DatadogInterceptor.ORIGIN_RUM),
        SPANS(SpanEventSerializer.TAG_SPANS);
        
        private final String trackName;

        private TrackType(String str) {
            this.trackName = str;
        }

        public final String getTrackName() {
            return this.trackName;
        }
    }

    /* renamed from: a */
    private final String m2325a() {
        return (String) this.f3490i.getValue();
    }

    public UploadStatus upload(byte[] bArr) {
        UploadStatus uploadStatus;
        Intrinsics.checkNotNullParameter(bArr, "data");
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        try {
            uploadStatus = m2324a(bArr, uuid);
        } catch (Throwable th) {
            Logger.e$default(this.f3488g, "Unable to upload batch data.", th, (Map) null, 4, (Object) null);
            uploadStatus = UploadStatus.NETWORK_ERROR;
        }
        UploadStatus uploadStatus2 = uploadStatus;
        String str = this.f3489h;
        Intrinsics.checkNotNullExpressionValue(str, "uploaderName");
        UploadStatus uploadStatus3 = uploadStatus2;
        String str2 = uuid;
        uploadStatus3.logStatus(str, bArr.length, RuntimeUtilsKt.getDevLogger(), false, str2);
        String str3 = this.f3489h;
        Intrinsics.checkNotNullExpressionValue(str3, "uploaderName");
        uploadStatus3.logStatus(str3, bArr.length, this.f3488g, true, str2);
        return uploadStatus2;
    }

    /* renamed from: a */
    private final UploadStatus m2324a(byte[] bArr, String str) {
        Response execute = this.f3486e.newCall(m2328b(bArr, str)).execute();
        execute.close();
        return m2323a(execute.code());
    }

    /* renamed from: b */
    private final Request m2328b(byte[] bArr, String str) {
        Request.Builder post = new Request.Builder().url(m2327b()).post(RequestBody.create((MediaType) null, bArr));
        Intrinsics.checkNotNullExpressionValue(post, "builder");
        m2326a(post, str);
        Request build = post.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    /* renamed from: b */
    private final String m2327b() {
        Map<String, Object> buildQueryParameters = buildQueryParameters();
        if (buildQueryParameters.isEmpty()) {
            return this.f3482a;
        }
        String str = this.f3482a;
        Collection arrayList = new ArrayList(buildQueryParameters.size());
        for (Map.Entry next : buildQueryParameters.entrySet()) {
            arrayList.add(((String) next.getKey()) + '=' + next.getValue());
        }
        return Intrinsics.stringPlus(str, CollectionsKt.joinToString$default((List) arrayList, ParamKeys.SIGN_AND, "?", (CharSequence) null, 0, (CharSequence) null, (Function1) null, 60, (Object) null));
    }

    /* renamed from: a */
    private final void m2326a(Request.Builder builder, String str) {
        builder.addHeader(HEADER_API_KEY, this.f3483b);
        builder.addHeader(HEADER_EVP_ORIGIN, this.f3484c);
        builder.addHeader(HEADER_EVP_ORIGIN_VERSION, this.f3485d);
        builder.addHeader("User-Agent", m2325a());
        builder.addHeader("Content-Type", this.f3487f);
        builder.addHeader(HEADER_REQUEST_ID, str);
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> buildQueryParameters() {
        return MapsKt.emptyMap();
    }

    /* renamed from: a */
    private final UploadStatus m2323a(int i) {
        if (i == 202) {
            return UploadStatus.SUCCESS;
        }
        if (i == 403) {
            return UploadStatus.HTTP_CLIENT_ERROR;
        }
        if (i == 408) {
            return UploadStatus.HTTP_CLIENT_RATE_LIMITING;
        }
        if (i == 413) {
            return UploadStatus.HTTP_CLIENT_ERROR;
        }
        if (i == 429) {
            return UploadStatus.HTTP_CLIENT_RATE_LIMITING;
        }
        if (i == 500) {
            return UploadStatus.HTTP_SERVER_ERROR;
        }
        if (i == 503) {
            return UploadStatus.HTTP_SERVER_ERROR;
        }
        if (i == 400) {
            return UploadStatus.HTTP_CLIENT_ERROR;
        }
        if (i != 401) {
            return UploadStatus.UNKNOWN_ERROR;
        }
        return UploadStatus.INVALID_TOKEN_ERROR;
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo175978d2 = {"Lcom/datadog/android/core/internal/net/DataOkHttpUploaderV2$Companion;", "", "()V", "CONTENT_TYPE_JSON", "", "CONTENT_TYPE_TEXT_UTF8", "HEADER_API_KEY", "HEADER_CONTENT_TYPE", "HEADER_EVP_ORIGIN", "HEADER_EVP_ORIGIN_VERSION", "HEADER_REQUEST_ID", "HEADER_USER_AGENT", "HTTP_ACCEPTED", "", "HTTP_BAD_REQUEST", "HTTP_CLIENT_TIMEOUT", "HTTP_ENTITY_TOO_LARGE", "HTTP_FORBIDDEN", "HTTP_INTERNAL_ERROR", "HTTP_TOO_MANY_REQUESTS", "HTTP_UNAUTHORIZED", "HTTP_UNAVAILABLE", "QUERY_PARAM_SOURCE", "QUERY_PARAM_TAGS", "UPLOAD_URL", "buildUrl", "endpoint", "trackType", "Lcom/datadog/android/core/internal/net/DataOkHttpUploaderV2$TrackType;", "buildUrl$dd_sdk_android_release", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: DataOkHttpUploaderV2.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String buildUrl$dd_sdk_android_release(String str, TrackType trackType) {
            Intrinsics.checkNotNullParameter(str, "endpoint");
            Intrinsics.checkNotNullParameter(trackType, "trackType");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.US, DataOkHttpUploaderV2.f3481j, Arrays.copyOf(new Object[]{str, trackType.getTrackName()}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            return format;
        }
    }
}
