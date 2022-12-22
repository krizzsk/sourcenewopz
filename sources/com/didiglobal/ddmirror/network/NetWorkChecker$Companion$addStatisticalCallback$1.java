package com.didiglobal.ddmirror.network;

import didihttp.StatisticalCallback;
import didihttp.StatisticalContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Ldidihttp/StatisticalContext;", "kotlin.jvm.PlatformType", "onStatisticalDataCallback"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: NetWorkChecker.kt */
final class NetWorkChecker$Companion$addStatisticalCallback$1 implements StatisticalCallback {
    public static final NetWorkChecker$Companion$addStatisticalCallback$1 INSTANCE = new NetWorkChecker$Companion$addStatisticalCallback$1();

    NetWorkChecker$Companion$addStatisticalCallback$1() {
    }

    public final void onStatisticalDataCallback(StatisticalContext statisticalContext) {
        if (NetWorkChecker.isEnable) {
            Intrinsics.checkExpressionValueIsNotNull(statisticalContext, "it");
            String httpUrl = statisticalContext.getRequest().url().toString();
            Intrinsics.checkExpressionValueIsNotNull(httpUrl, "it.request.url().toString()");
            String apiPathFromUrlAndConfig = NetWorkChecker.Companion.getApiPathFromUrlAndConfig(httpUrl);
            if (NetWorkChecker.Companion.isBFFUrl(httpUrl)) {
                NetWorkChecker.Companion.checkBff(apiPathFromUrlAndConfig, statisticalContext);
            } else {
                NetWorkChecker.Companion.checkApi(apiPathFromUrlAndConfig, statisticalContext);
            }
        }
    }
}
