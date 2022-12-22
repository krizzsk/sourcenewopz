package com.didi.soda.customer.biz.popdialog;

import android.net.Uri;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "map", "", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AppsFlyerHelper.kt */
final class AppsFlyerHelperKt$handleAppLinkListener$handAppLink$1 extends Lambda implements Function1<Map<String, String>, Unit> {
    final /* synthetic */ boolean $isCold;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppsFlyerHelperKt$handleAppLinkListener$handAppLink$1(boolean z) {
        super(1);
        this.$isCold = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Map<String, String>) (Map) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Map<String, String> map) {
        if (map != null) {
            String str = map.get("link");
            CharSequence charSequence = map.get("scheme");
            if (!(charSequence == null || charSequence.length() == 0)) {
                LogUtil.m29104i("AppsFlyerListener", "scheme 启动app，此处不需要分发。");
            } else if (str == null || Uri.parse(str).getQueryParameter(AppsFlyerHelperKt.appLinkAppName) == null) {
                AppsFlyerHelperKt.m28676a(map, this.$isCold);
            } else {
                LogUtil.m29104i("AppsFlyerListener", "兼容链接后缀形式实现的applink，此处不需要分发。");
            }
        } else {
            LogUtil.m29104i("AppsFlyerListener", " handle app link map = null");
        }
    }
}
