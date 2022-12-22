package com.didi.soda.customer.biz.popdialog;

import com.didi.soda.router.DiRouter;
import com.didi.soda.router.Request;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AppsFlyersLauncher.kt */
final class AppsFlyersLauncherKt$doDispatch$dispatch$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function2<String, String, Unit> $track;
    final /* synthetic */ CampaignValue $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppsFlyersLauncherKt$doDispatch$dispatch$1(CampaignValue campaignValue, Function2<? super String, ? super String, Unit> function2) {
        super(0);
        this.$value = campaignValue;
        this.$track = function2;
    }

    public final void invoke() {
        if (this.$value.mo102097f()) {
            String h = this.$value.mo102099h();
            if (h != null) {
                Function2<String, String, Unit> function2 = this.$track;
                CampaignValue campaignValue = this.$value;
                function2.invoke(h, campaignValue.mo102095d());
                Request.Builder putString = DiRouter.request().path("webPage").putString("url", h);
                HashMap<String, String> c = campaignValue.mo102093c();
                if (c != null) {
                    putString.putSerializable("params", c);
                }
                putString.open();
            }
        } else if (this.$value.mo102096e()) {
            this.$track.invoke(this.$value.mo102098g(), this.$value.mo102095d());
            Request.Builder path = DiRouter.request().path(this.$value.mo102091b());
            HashMap<String, String> c2 = this.$value.mo102093c();
            if (c2 != null) {
                for (Map.Entry entry : c2.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        String lowerCase = str.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                        path.putString(lowerCase, (String) entry.getValue());
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                }
            }
            path.open();
        }
    }
}
