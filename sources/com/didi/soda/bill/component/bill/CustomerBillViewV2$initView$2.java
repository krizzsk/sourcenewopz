package com.didi.soda.bill.component.bill;

import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.bill.view.BillItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/soda/bill/component/bill/CustomerBillViewV2$initView$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerBillViewV2.kt */
public final class CustomerBillViewV2$initView$2 extends RecyclerView.OnScrollListener {
    final /* synthetic */ float $maxMoveH;
    final /* synthetic */ CustomerBillViewV2 this$0;

    CustomerBillViewV2$initView$2(CustomerBillViewV2 customerBillViewV2, float f) {
        this.this$0 = customerBillViewV2;
        this.$maxMoveH = f;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        CustomerBillViewV2 customerBillViewV2 = this.this$0;
        BillItemView access$findAddressView = customerBillViewV2.m27622b(customerBillViewV2.f38911j);
        if (access$findAddressView != null) {
            CustomerBillViewV2 customerBillViewV22 = this.this$0;
            float f = this.$maxMoveH;
            Rect rect = new Rect();
            TextView textView = null;
            if (access$findAddressView.getLocalVisibleRect(rect)) {
                float height = ((float) rect.height()) / ((float) access$findAddressView.getHeight());
                View access$getAddressIcon$p = customerBillViewV22.f38907f;
                if (access$getAddressIcon$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addressIcon");
                    access$getAddressIcon$p = null;
                }
                float f2 = ((float) 1) - height;
                access$getAddressIcon$p.setAlpha(f2);
                TextView access$getAddressName$p = customerBillViewV22.f38906e;
                if (access$getAddressName$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addressName");
                    access$getAddressName$p = null;
                }
                access$getAddressName$p.setAlpha(f2);
                TextView access$getTitleView$p = customerBillViewV22.f38905d;
                if (access$getTitleView$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleView");
                } else {
                    textView = access$getTitleView$p;
                }
                textView.setTranslationY((-f2) * f);
                access$findAddressView.getGlobalVisibleRect(rect);
            } else {
                View access$getAddressIcon$p2 = customerBillViewV22.f38907f;
                if (access$getAddressIcon$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addressIcon");
                    access$getAddressIcon$p2 = null;
                }
                access$getAddressIcon$p2.setAlpha(1.0f);
                TextView access$getAddressName$p2 = customerBillViewV22.f38906e;
                if (access$getAddressName$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addressName");
                    access$getAddressName$p2 = null;
                }
                access$getAddressName$p2.setAlpha(1.0f);
                TextView access$getTitleView$p2 = customerBillViewV22.f38905d;
                if (access$getTitleView$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleView");
                } else {
                    textView = access$getTitleView$p2;
                }
                textView.setTranslationY(-f);
            }
        }
        this.this$0.m27626c();
    }
}
