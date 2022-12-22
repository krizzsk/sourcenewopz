package com.didi.payment.base.view.webview.titlebar;

import android.app.Activity;
import com.didi.payment.base.view.webview.WalletWebActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/base/view/webview/titlebar/TitleBarFactory;", "", "()V", "Companion", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TitleBarFactory.kt */
public final class TitleBarFactory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final ITitleBar getTitleBar(Activity activity) {
        return Companion.getTitleBar(activity);
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/payment/base/view/webview/titlebar/TitleBarFactory$Companion;", "", "()V", "getTitleBar", "Lcom/didi/payment/base/view/webview/titlebar/ITitleBar;", "context", "Landroid/app/Activity;", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TitleBarFactory.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ITitleBar getTitleBar(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "context");
            String simpleName = activity.getClass().getSimpleName();
            if (Intrinsics.areEqual((Object) simpleName, (Object) C21490Reflection.getOrCreateKotlinClass(WalletWebActivity.class).getSimpleName())) {
                return new WalletTitleBar();
            }
            if (Intrinsics.areEqual((Object) simpleName, (Object) "WebActivity")) {
                return new WebTitleBar();
            }
            return new TitleBarFactory$Companion$getTitleBar$1();
        }
    }
}
