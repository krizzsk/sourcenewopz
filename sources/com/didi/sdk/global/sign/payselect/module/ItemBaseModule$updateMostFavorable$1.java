package com.didi.sdk.global.sign.payselect.module;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didi/sdk/global/sign/payselect/module/ItemBaseModule$updateMostFavorable$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ItemBaseModule.kt */
public final class ItemBaseModule$updateMostFavorable$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ PaySelItemData $data;
    final /* synthetic */ TextView $tvMostFavorable;
    final /* synthetic */ ItemBaseModule this$0;

    ItemBaseModule$updateMostFavorable$1(TextView textView, ItemBaseModule itemBaseModule, PaySelItemData paySelItemData) {
        this.$tvMostFavorable = textView;
        this.this$0 = itemBaseModule;
        this.$data = paySelItemData;
    }

    public void onGlobalLayout() {
        int width = this.$tvMostFavorable.getWidth() - (UiUtils.dip2px(this.this$0.getContext(), 10.0f) * 2);
        long measureText = (long) this.$tvMostFavorable.getPaint().measureText(this.$data.mostFavorableTxt);
        LinearLayout llMainTitleContainer = this.this$0.getLlMainTitleContainer();
        if (llMainTitleContainer != null) {
            llMainTitleContainer.removeView(this.$tvMostFavorable);
        }
        LinearLayout llAllTitleContainer = this.this$0.getLlAllTitleContainer();
        if (llAllTitleContainer != null) {
            llAllTitleContainer.removeView(this.$tvMostFavorable);
        }
        ViewGroup.LayoutParams layoutParams = this.$tvMostFavorable.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (measureText > ((long) width)) {
                marginLayoutParams.setMarginStart(0);
                marginLayoutParams.topMargin = UiUtils.dip2px(this.this$0.getContext(), 4.0f);
                LinearLayout llAllTitleContainer2 = this.this$0.getLlAllTitleContainer();
                if (llAllTitleContainer2 != null) {
                    llAllTitleContainer2.addView(this.$tvMostFavorable, marginLayoutParams);
                }
            } else {
                marginLayoutParams.setMarginStart(UiUtils.dip2px(this.this$0.getContext(), 4.0f));
                marginLayoutParams.topMargin = 0;
                LinearLayout llMainTitleContainer2 = this.this$0.getLlMainTitleContainer();
                if (llMainTitleContainer2 != null) {
                    llMainTitleContainer2.addView(this.$tvMostFavorable, marginLayoutParams);
                }
            }
            this.$tvMostFavorable.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}
