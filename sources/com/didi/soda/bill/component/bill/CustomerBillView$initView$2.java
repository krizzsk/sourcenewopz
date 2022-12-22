package com.didi.soda.bill.component.bill;

import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.bill.view.BillItemView;
import com.didi.soda.bill.widgets.CustomerBillRecommendTipsView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/soda/bill/component/bill/CustomerBillView$initView$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerBillView.kt */
public final class CustomerBillView$initView$2 extends RecyclerView.OnScrollListener {
    final /* synthetic */ float $maxMoveH;
    final /* synthetic */ CustomerBillView this$0;

    CustomerBillView$initView$2(CustomerBillView customerBillView, float f) {
        this.this$0 = customerBillView;
        this.$maxMoveH = f;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        CustomerBillView customerBillView = this.this$0;
        BillItemView access$findAddressView = customerBillView.m27608b(customerBillView.f38899n);
        if (access$findAddressView != null) {
            CustomerBillView customerBillView2 = this.this$0;
            float f = this.$maxMoveH;
            Rect rect = new Rect();
            CustomerBillRecommendTipsView customerBillRecommendTipsView = null;
            if (access$findAddressView.getLocalVisibleRect(rect)) {
                float height = (float) rect.height();
                int height2 = access$findAddressView.getHeight();
                float f2 = height / ((float) height2);
                View access$getAddressIcon$p = customerBillView2.f38891f;
                if (access$getAddressIcon$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addressIcon");
                    access$getAddressIcon$p = null;
                }
                float f3 = ((float) 1) - f2;
                access$getAddressIcon$p.setAlpha(f3);
                TextView access$getAddressName$p = customerBillView2.f38890e;
                if (access$getAddressName$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addressName");
                    access$getAddressName$p = null;
                }
                access$getAddressName$p.setAlpha(f3);
                TextView access$getTitleView$p = customerBillView2.f38889d;
                if (access$getTitleView$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleView");
                    access$getTitleView$p = null;
                }
                access$getTitleView$p.setTranslationY((-f3) * f);
                access$findAddressView.getGlobalVisibleRect(rect);
                CustomerBillRecommendTipsView access$getTipsView$p = customerBillView2.f38898m;
                if (access$getTipsView$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tipsView");
                } else {
                    customerBillRecommendTipsView = access$getTipsView$p;
                }
                customerBillRecommendTipsView.setScrollProgress(f3, (int) (((float) (rect.top - height2)) + height));
            } else {
                View access$getAddressIcon$p2 = customerBillView2.f38891f;
                if (access$getAddressIcon$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addressIcon");
                    access$getAddressIcon$p2 = null;
                }
                access$getAddressIcon$p2.setAlpha(1.0f);
                TextView access$getAddressName$p2 = customerBillView2.f38890e;
                if (access$getAddressName$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addressName");
                    access$getAddressName$p2 = null;
                }
                access$getAddressName$p2.setAlpha(1.0f);
                TextView access$getTitleView$p2 = customerBillView2.f38889d;
                if (access$getTitleView$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleView");
                    access$getTitleView$p2 = null;
                }
                access$getTitleView$p2.setTranslationY(-f);
                CustomerBillRecommendTipsView access$getTipsView$p2 = customerBillView2.f38898m;
                if (access$getTipsView$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tipsView");
                } else {
                    customerBillRecommendTipsView = access$getTipsView$p2;
                }
                customerBillRecommendTipsView.setAlpha(0.0f);
            }
        }
        this.this$0.m27612c();
    }
}
