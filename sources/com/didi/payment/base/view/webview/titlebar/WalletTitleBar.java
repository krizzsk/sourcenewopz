package com.didi.payment.base.view.webview.titlebar;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.didi.payment.base.view.webview.WalletWebActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/payment/base/view/webview/titlebar/WalletTitleBar;", "Lcom/didi/payment/base/view/webview/titlebar/ITitleBar;", "()V", "addViewToTitleBar", "", "context", "Landroid/app/Activity;", "view", "Landroid/view/View;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "removeViewFromTitleBar", "tag", "", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletTitleBar.kt */
public final class WalletTitleBar implements ITitleBar {
    public void addViewToTitleBar(Activity activity, View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(activity, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        if (activity instanceof WalletWebActivity) {
            ((WalletWebActivity) activity).addViewToTitleBar(view, (RelativeLayout.LayoutParams) layoutParams);
        }
    }

    public void removeViewFromTitleBar(Activity activity, Object obj) {
        Intrinsics.checkNotNullParameter(activity, "context");
        Intrinsics.checkNotNullParameter(obj, "tag");
        if (activity instanceof WalletWebActivity) {
            ((WalletWebActivity) activity).removeViewFromTitleBar(obj);
        }
    }
}
