package com.jumio.core.api.calls;

import com.jumio.analytics.AnalyticsEvent;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.network.C20000d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import jumio.core.C21351f;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AnalyticsCall.kt */
public class AnalyticsCall extends C20000d<Void> {

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, mo175978d2 = {"Lcom/jumio/core/api/calls/AnalyticsCall$Companion;", "", "", "DATA_EVENTS", "Ljava/lang/String;", "DATA_OFFSET", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: AnalyticsCall.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        new Companion((DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnalyticsCall(C21351f fVar, ApiCallDataModel<?> apiCallDataModel) {
        super(fVar, apiCallDataModel);
        Intrinsics.checkNotNullParameter(fVar, "apiCallSettings");
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
        if (!apiCallDataModel.getData().containsKey("DATA_EVENTS")) {
            throw new IllegalArgumentException("Events are missing".toString());
        } else if (!apiCallDataModel.getData().containsKey("DATA_OFFSET")) {
            throw new IllegalArgumentException("Offset is missing".toString());
        }
    }

    /* renamed from: a */
    public Void parseResponse(String str) {
        Intrinsics.checkNotNullParameter(str, "plainTextAnswer");
        return null;
    }

    /* renamed from: b */
    public final ArrayList<AnalyticsEvent> mo162582b() {
        Serializable serializable = getApiCallDataModel().getData().get("DATA_EVENTS");
        if (serializable != null) {
            return (ArrayList) serializable;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.jumio.analytics.AnalyticsEvent>{ kotlin.collections.TypeAliasesKt.ArrayList<com.jumio.analytics.AnalyticsEvent> }");
    }

    /* renamed from: c */
    public final long mo162583c() {
        Serializable serializable = getApiCallDataModel().getData().get("DATA_OFFSET");
        if (serializable != null) {
            return ((Long) serializable).longValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    }

    public String getRequest() throws Exception {
        if (!mo162582b().isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator<AnalyticsEvent> it = mo162582b().iterator();
            while (it.hasNext()) {
                AnalyticsEvent next = it.next();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("eventType", next.getEventType());
                jSONObject2.put("timestamp", next.getTimestamp() - mo162583c());
                jSONObject2.put("payload", next.getPayload().mo162354c());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("events", jSONArray);
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "request.toString()");
            return jSONObject3;
        }
        throw new IllegalArgumentException("event list cannot be empty!".toString());
    }

    public String getUri() {
        return StringDeobfuscator.deobfuscate(new byte[]{105, -38, -1, -84, -47, 102, -78, 95, 38, -120, -105, 42, -87, 9}, 7332388328695791698L);
    }

    public void responseReceived(int i, long j) {
    }
}
