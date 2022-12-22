package com.didi.component.framework.pages.promo.helper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.didi.app.router.sidebar.BaseSideBarDRouterHandler;
import com.didi.component.framework.pages.promo.PromoCodeActivity;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, mo175978d2 = {"Lcom/didi/component/framework/pages/promo/helper/PromoCodeInterceptor;", "Lcom/didi/app/router/sidebar/BaseSideBarDRouterHandler;", "()V", "callRealHandle", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "Companion", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PromoCodeInterceptor.kt */
public final class PromoCodeInterceptor extends BaseSideBarDRouterHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PROMO_CODE = "promoCode";
    public static final String PROMO_TITLE = "title";

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/component/framework/pages/promo/helper/PromoCodeInterceptor$Companion;", "", "()V", "PROMO_CODE", "", "PROMO_TITLE", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PromoCodeInterceptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void callRealHandle(Request request, Result result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        Uri uri = request.getUri();
        String str = null;
        String queryParameter = uri == null ? null : uri.getQueryParameter(PROMO_CODE);
        Uri uri2 = request.getUri();
        if (uri2 != null) {
            str = uri2.getQueryParameter("title");
        }
        Context context = request.getContext();
        Intent intent = new Intent(context, PromoCodeActivity.class);
        intent.putExtra(PROMO_CODE, queryParameter);
        intent.putExtra("title", str);
        intent.setFlags(335544320);
        context.startActivity(intent);
    }
}
