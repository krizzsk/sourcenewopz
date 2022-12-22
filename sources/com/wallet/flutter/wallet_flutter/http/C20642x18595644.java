package com.wallet.flutter.wallet_flutter.http;

import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¨\u0006\u0002"}, mo175978d2 = {"<anonymous>", "", "com/wallet/flutter/wallet_flutter/base/FlutterHelper$Companion$runOnMain$1"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.wallet.flutter.wallet_flutter.http.WalletFlutterHttpChannel$getCallback$1$onSuccess$lambda-1$$inlined$runOnMain$1 */
/* compiled from: FlutterHelper.kt */
public final class C20642x18595644 implements Runnable {
    final /* synthetic */ String $errMsg$inlined;
    final /* synthetic */ int $errno$inlined;
    final /* synthetic */ Map $it$inlined;
    final /* synthetic */ MethodChannel.Result $result$inlined;

    public C20642x18595644(MethodChannel.Result result, int i, String str, Map map) {
        this.$result$inlined = result;
        this.$errno$inlined = i;
        this.$errMsg$inlined = str;
        this.$it$inlined = map;
    }

    public final void run() {
        MethodChannel.Result result = this.$result$inlined;
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.m42317to("platformError", false);
        pairArr[1] = TuplesKt.m42317to(Constants.ERROR_CODE, Integer.valueOf(this.$errno$inlined));
        pairArr[2] = TuplesKt.m42317to("errorMsg", this.$errMsg$inlined);
        Object obj = this.$it$inlined.get("data");
        pairArr[3] = TuplesKt.m42317to("data", obj instanceof Map ? (Map) obj : null);
        result.success(MapsKt.mutableMapOf(pairArr));
        Unit unit = Unit.INSTANCE;
    }
}
