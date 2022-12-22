package com.datadog.android.core.internal.net;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/datadog/android/core/internal/net/GzipRequestInterceptor;", "Lokhttp3/Interceptor;", "()V", "gzip", "Lokhttp3/RequestBody;", "body", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GzipRequestInterceptor.kt */
public final class GzipRequestInterceptor implements Interceptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final String f3492a = "Content-Encoding";

    /* renamed from: b */
    private static final String f3493b = "gzip";

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        Intrinsics.checkNotNullExpressionValue(request, "chain.request()");
        RequestBody body = request.body();
        if (body == null || request.header("Content-Encoding") != null) {
            Response proceed = chain.proceed(request);
            Intrinsics.checkNotNullExpressionValue(proceed, "{\n            chain.proceed(originalRequest)\n        }");
            return proceed;
        }
        Response proceed2 = chain.proceed(request.newBuilder().header("Content-Encoding", f3493b).method(request.method(), m2329a(body)).build());
        Intrinsics.checkNotNullExpressionValue(proceed2, "{\n            val compressedRequest = originalRequest.newBuilder()\n                .header(HEADER_ENCODING, ENCODING_GZIP)\n                .method(originalRequest.method(), gzip(body))\n                .build()\n            chain.proceed(compressedRequest)\n        }");
        return proceed2;
    }

    /* renamed from: a */
    private final RequestBody m2329a(RequestBody requestBody) {
        return new GzipRequestInterceptor$gzip$1(requestBody);
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/datadog/android/core/internal/net/GzipRequestInterceptor$Companion;", "", "()V", "ENCODING_GZIP", "", "HEADER_ENCODING", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GzipRequestInterceptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
