package com.didi.soda.customer.biz.popdialog;

import com.didi.soda.customer.foundation.tracker.performance.ConversionOmegaHelper;
import com.didi.soda.customer.foundation.util.GsonUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "url", "", "campaign"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AppsFlyersLauncher.kt */
final class AppsFlyersLauncherKt$appFlyersLaunch$trackClosure$1 extends Lambda implements Function2<String, String, Unit> {
    final /* synthetic */ Map<String, Object> $map;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppsFlyersLauncherKt$appFlyersLaunch$trackClosure$1(Map<String, ? extends Object> map) {
        super(2);
        this.$map = map;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "campaign");
        ConversionOmegaHelper.trackAppEnter(str, false, "4", str2, GsonUtil.toJson(this.$map));
    }
}
