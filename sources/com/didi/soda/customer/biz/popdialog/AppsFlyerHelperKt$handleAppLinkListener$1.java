package com.didi.soda.customer.biz.popdialog;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(mo175977d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/soda/customer/biz/popdialog/AppsFlyerHelperKt$handleAppLinkListener$1", "Lcom/didi/soda/customer/biz/popdialog/SimpleAFConversionListener;", "onAppOpenAttribution", "", "map", "", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AppsFlyerHelper.kt */
public final class AppsFlyerHelperKt$handleAppLinkListener$1 extends SimpleAFConversionListener {
    final /* synthetic */ Function1<Map<String, String>, Unit> $handAppLink;

    AppsFlyerHelperKt$handleAppLinkListener$1(Function1<? super Map<String, String>, Unit> function1) {
        this.$handAppLink = function1;
    }

    public void onAppOpenAttribution(Map<String, String> map) {
        super.onAppOpenAttribution(map);
        this.$handAppLink.invoke(map);
    }
}
