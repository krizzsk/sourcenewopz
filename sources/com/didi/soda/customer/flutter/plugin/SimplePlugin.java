package com.didi.soda.customer.flutter.plugin;

import androidx.core.app.NotificationCompat;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001e\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/customer/flutter/plugin/SimplePlugin;", "Lcom/didi/soda/customer/flutter/plugin/CustomerBasePlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "toMap", "", "", "", "obj", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SimplePlugin.kt */
public abstract class SimplePlugin extends CustomerBasePlugin implements MethodChannel.MethodCallHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String METHOD = "method";
    public static final String TAG = "SimplePlugin";

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = (String) methodCall.argument("pageId");
        if (str != null) {
            Map<String, Object> map = toMap(methodCall.arguments);
            map.put("method", methodCall.method);
            Unit unit = Unit.INSTANCE;
            notifyAllObserver(str, map, new SimplePlugin$onMethodCall$1$2(result));
        }
    }

    public final Map<String, Object> toMap(Object obj) {
        if (obj instanceof Map) {
            if (obj != null) {
                return new HashMap<>((Map) obj);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
        } else if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String next = keys.next();
                Intrinsics.checkNotNullExpressionValue(next, "key");
                hashMap.put(next, jSONObject.opt(next));
            }
            return hashMap;
        } else {
            LogUtil.m29104i("SimplePlugin", Intrinsics.stringPlus("toMap error obj=", obj));
            return new HashMap<>();
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/customer/flutter/plugin/SimplePlugin$Companion;", "", "()V", "METHOD", "", "TAG", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SimplePlugin.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
