package com.didi.soda.customer.p165h5.hybird.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u001cR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/soda/customer/h5/hybird/request/WebRequestModel;", "", "()V", "data", "Lorg/json/JSONObject;", "getData", "()Lorg/json/JSONObject;", "setData", "(Lorg/json/JSONObject;)V", "header", "getHeader", "setHeader", "method", "", "getMethod", "()Ljava/lang/String;", "setMethod", "(Ljava/lang/String;)V", "timeout", "", "getTimeout", "()J", "setTimeout", "(J)V", "url", "getUrl", "setUrl", "checkSelf", "", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.h5.hybird.request.WebRequestModel */
/* compiled from: WebRequest.kt */
final class WebRequestModel {

    /* renamed from: a */
    public static final Companion f41324a = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b */
    private String f41325b;

    /* renamed from: c */
    private String f41326c;

    /* renamed from: d */
    private JSONObject f41327d;

    /* renamed from: e */
    private JSONObject f41328e;

    /* renamed from: f */
    private long f41329f = 30000;

    /* renamed from: a */
    public final String mo105181a() {
        return this.f41325b;
    }

    /* renamed from: a */
    public final void mo105183a(String str) {
        this.f41325b = str;
    }

    /* renamed from: b */
    public final String mo105185b() {
        return this.f41326c;
    }

    /* renamed from: b */
    public final void mo105186b(String str) {
        this.f41326c = str;
    }

    /* renamed from: a */
    public final void mo105184a(JSONObject jSONObject) {
        this.f41327d = jSONObject;
    }

    /* renamed from: c */
    public final JSONObject mo105188c() {
        return this.f41327d;
    }

    /* renamed from: b */
    public final void mo105187b(JSONObject jSONObject) {
        this.f41328e = jSONObject;
    }

    /* renamed from: d */
    public final JSONObject mo105189d() {
        return this.f41328e;
    }

    /* renamed from: a */
    public final void mo105182a(long j) {
        this.f41329f = j;
    }

    /* renamed from: e */
    public final long mo105190e() {
        return this.f41329f;
    }

    /* renamed from: f */
    public final boolean mo105191f() {
        CharSequence charSequence = this.f41325b;
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.f41326c, (Object) "post");
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/customer/h5/hybird/request/WebRequestModel$Companion;", "", "()V", "create", "Lcom/didi/soda/customer/h5/hybird/request/WebRequestModel;", "params", "Lorg/json/JSONObject;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.soda.customer.h5.hybird.request.WebRequestModel$Companion */
    /* compiled from: WebRequest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WebRequestModel create(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "params");
            WebRequestModel webRequestModel = new WebRequestModel();
            webRequestModel.mo105183a(jSONObject.optString("url"));
            webRequestModel.mo105186b(jSONObject.optString("method"));
            webRequestModel.mo105184a(jSONObject.optJSONObject("data"));
            webRequestModel.mo105187b(jSONObject.optJSONObject("header"));
            webRequestModel.mo105182a(jSONObject.optLong("timeout"));
            if (webRequestModel.mo105190e() == 0) {
                webRequestModel.mo105182a(10000);
            }
            return webRequestModel;
        }
    }
}
