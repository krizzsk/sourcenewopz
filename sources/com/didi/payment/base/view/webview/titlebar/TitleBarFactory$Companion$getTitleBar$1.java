package com.didi.payment.base.view.webview.titlebar;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, mo175978d2 = {"com/didi/payment/base/view/webview/titlebar/TitleBarFactory$Companion$getTitleBar$1", "Lcom/didi/payment/base/view/webview/titlebar/ITitleBar;", "addViewToTitleBar", "", "context", "Landroid/app/Activity;", "view", "Landroid/view/View;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "removeViewFromTitleBar", "tag", "", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TitleBarFactory.kt */
public final class TitleBarFactory$Companion$getTitleBar$1 implements ITitleBar {
    public void addViewToTitleBar(Activity activity, View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(activity, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
    }

    public void removeViewFromTitleBar(Activity activity, Object obj) {
        Intrinsics.checkNotNullParameter(activity, "context");
        Intrinsics.checkNotNullParameter(obj, "tag");
    }

    TitleBarFactory$Companion$getTitleBar$1() {
    }
}
