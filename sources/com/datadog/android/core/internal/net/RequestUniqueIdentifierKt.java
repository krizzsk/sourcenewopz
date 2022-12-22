package com.datadog.android.core.internal.net;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.C2434Util;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, mo175978d2 = {"identifyRequest", "", "request", "Lokhttp3/Request;", "dd-sdk-android_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RequestUniqueIdentifier.kt */
public final class RequestUniqueIdentifierKt {
    public static final String identifyRequest(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        String method = request.method();
        HttpUrl url = request.url();
        RequestBody body = request.body();
        if (body == null || Intrinsics.areEqual((Object) body, (Object) C2434Util.EMPTY_REQUEST)) {
            return method + Typography.bullet + url;
        }
        long contentLength = body.contentLength();
        MediaType contentType = body.contentType();
        return method + Typography.bullet + url + Typography.bullet + contentLength + Typography.bullet + contentType;
    }
}
