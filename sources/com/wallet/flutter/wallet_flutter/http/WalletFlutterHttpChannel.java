package com.wallet.flutter.wallet_flutter.http;

import android.net.Uri;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import com.didi.payment.base.exts.ApplicationContextProvider;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.http.SimpleHttpHeader;
import com.didichuxing.foundation.net.rpc.http.HttpRpc;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.wallet.flutter.wallet_flutter.base.FlutterHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.embedding.engine.plugins.activity.ActivityAware;
import p242io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\"\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010 \u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0018H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\""}, mo175978d2 = {"Lcom/wallet/flutter/wallet_flutter/http/WalletFlutterHttpChannel;", "Lio/flutter/plugin/common/MethodChannel;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "(Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;)V", "isApplicationDebug", "", "rpcClient", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpcClient;", "getRpcClient", "()Lcom/didichuxing/foundation/net/rpc/http/HttpRpcClient;", "rpcClient$delegate", "Lkotlin/Lazy;", "getCallback", "Lcom/didichuxing/foundation/net/rpc/http/HttpRpc$Callback;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "handleHttp", "", "call", "Lio/flutter/plugin/common/MethodCall;", "onAttachedToActivity", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "onDetachedFromActivity", "onDetachedFromActivityForConfigChanges", "onFail", "errorMsg", "", "errorCode", "", "onMethodCall", "onReattachedToActivityForConfigChanges", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletFlutterHttpChannel.kt */
public final class WalletFlutterHttpChannel extends MethodChannel implements ActivityAware, MethodChannel.MethodCallHandler {

    /* renamed from: a */
    private final boolean f56064a;

    /* renamed from: b */
    private final Lazy f56065b;

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
    }

    public void onDetachedFromActivity() {
    }

    public void onDetachedFromActivityForConfigChanges() {
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletFlutterHttpChannel(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        super(flutterPluginBinding.getBinaryMessenger(), "ibg_rpc_service");
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        this.f56064a = (ApplicationContextProvider.Companion.getContext().getApplicationInfo().flags & 2) != 0;
        this.f56065b = LazyKt.lazy(WalletFlutterHttpChannel$rpcClient$2.INSTANCE);
        setMethodCallHandler(this);
    }

    /* renamed from: a */
    private final HttpRpcClient m40383a() {
        Object value = this.f56065b.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-rpcClient>(...)");
        return (HttpRpcClient) value;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (Intrinsics.areEqual((Object) str, (Object) "request")) {
            try {
                m40384a(methodCall, result);
            } catch (Exception e) {
                onFail$default(this, result, e.getMessage(), 0, 4, (Object) null);
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) "isReleaseMode")) {
            result.success(MapsKt.hashMapOf(TuplesKt.m42317to("isReleaseMode", Boolean.valueOf(true ^ this.f56064a))));
        } else {
            result.success((Object) null);
        }
    }

    /* renamed from: a */
    private final void m40384a(MethodCall methodCall, MethodChannel.Result result) {
        HttpRpcRequest.Builder builder;
        Integer num = (Integer) methodCall.argument("method");
        boolean z = true;
        if (!(num != null && new IntRange(1, 2).contains(num.intValue()))) {
            onFail$default(this, result, "the method id:" + num + " is NOT support now!", 0, 4, (Object) null);
            return;
        }
        String str = (String) methodCall.argument("host");
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            onFail$default(this, result, "host must not be null or empty", 0, 4, (Object) null);
            return;
        }
        String str2 = (String) methodCall.argument("url");
        if (charSequence == null || charSequence.length() == 0) {
            onFail$default(this, result, "url must not be null or empty", 0, 4, (Object) null);
            return;
        }
        Map map = (Map) methodCall.argument("header");
        Uri.Builder buildUpon = Uri.parse(Intrinsics.stringPlus(str, str2)).buildUpon();
        HashMap<String, Object> httpBaseParams = PayBaseParamUtil.getHttpBaseParams(ApplicationContextProvider.Companion.getContext());
        if (httpBaseParams != null) {
            for (Map.Entry entry : httpBaseParams.entrySet()) {
                if (!(entry.getKey() == null || entry.getValue() == null)) {
                    buildUpon.appendQueryParameter((String) entry.getKey(), entry.getValue().toString());
                }
            }
        }
        Integer num2 = (Integer) methodCall.argument("method");
        if (num2 != null && num2.intValue() == 1) {
            Map map2 = (Map) methodCall.argument("params");
            if (map2 != null) {
                for (Map.Entry entry2 : map2.entrySet()) {
                    buildUpon.appendQueryParameter((String) entry2.getKey(), entry2.getValue().toString());
                }
            }
            builder = new HttpRpcRequest.Builder().get(buildUpon.toString());
        } else if (num2 != null && num2.intValue() == 2) {
            Map linkedHashMap = new LinkedHashMap();
            Map map3 = (Map) methodCall.argument("params");
            if (map3 != null) {
                linkedHashMap.putAll(map3);
            }
            builder = new HttpRpcRequest.Builder().post(buildUpon.toString(), HttpBody.newInstance("application/json", FlutterHelper.Companion.getGson().toJson((Object) linkedHashMap)));
        } else {
            builder = null;
        }
        if (builder != null) {
            if (map != null && !map.isEmpty()) {
                z = false;
            }
            if (!z) {
                Collection arrayList = new ArrayList(map.size());
                for (Map.Entry entry3 : map.entrySet()) {
                    arrayList.add(new SimpleHttpHeader((String) entry3.getKey(), entry3.getValue().toString()));
                }
                builder.addHeaders((Iterable) (List) arrayList);
            }
            HttpRpc newRpc = m40383a().newRpc(builder.build());
            if (newRpc != null) {
                newRpc.enqueue(m40382a(result));
            }
        }
    }

    /* renamed from: a */
    private final HttpRpc.Callback m40382a(MethodChannel.Result result) {
        return new WalletFlutterHttpChannel$getCallback$1(this, result);
    }

    public static /* synthetic */ void onFail$default(WalletFlutterHttpChannel walletFlutterHttpChannel, MethodChannel.Result result, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = -1;
        }
        walletFlutterHttpChannel.onFail(result, str, i);
    }

    public final void onFail(MethodChannel.Result result, String str, int i) {
        Intrinsics.checkNotNullParameter(result, "result");
        FlutterHelper.Companion companion = FlutterHelper.Companion;
        if (Intrinsics.areEqual((Object) Thread.currentThread(), (Object) Looper.getMainLooper().getThread())) {
            Pair[] pairArr = new Pair[3];
            pairArr[0] = TuplesKt.m42317to("platformError", true);
            pairArr[1] = TuplesKt.m42317to(Constants.ERROR_CODE, Integer.valueOf(i));
            if (str == null) {
                str = "";
            }
            pairArr[2] = TuplesKt.m42317to("errorMsg", str);
            result.success(MapsKt.mutableMapOf(pairArr));
            return;
        }
        companion.getHandler().post(new WalletFlutterHttpChannel$onFail$$inlined$runOnMain$1(result, i, str));
    }
}
