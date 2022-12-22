package com.didi.soda.globalcart.view;

import android.view.View;
import android.widget.LinearLayout;
import com.didi.soda.bill.model.datamodel.BillItemsInfoModel;
import com.didi.soda.globalcart.view.VerticalCollapseView;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/soda/globalcart/view/BillItemsInfoItemView$showExpandView$2", "Lcom/didi/soda/globalcart/view/VerticalCollapseView$StatusChangeListener;", "onAnimFinish", "", "onUpdate", "value", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillItemsInfoItemView.kt */
public final class BillItemsInfoItemView$showExpandView$2 implements VerticalCollapseView.StatusChangeListener {
    final /* synthetic */ LinearLayout $dishContainer;
    final /* synthetic */ int $firstHideIndex;
    final /* synthetic */ BillItemsInfoModel $model;

    BillItemsInfoItemView$showExpandView$2(int i, LinearLayout linearLayout, BillItemsInfoModel billItemsInfoModel) {
        this.$firstHideIndex = i;
        this.$dishContainer = linearLayout;
        this.$model = billItemsInfoModel;
    }

    public void onUpdate(float f) {
        int i = this.$firstHideIndex;
        int childCount = this.$dishContainer.getChildCount();
        if (i < childCount) {
            while (true) {
                int i2 = i + 1;
                View childAt = this.$dishContainer.getChildAt(i);
                if (childAt != null) {
                    childAt.setAlpha(f);
                }
                if (i2 < childCount) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    public void onAnimFinish() {
        View childAt;
        int i = this.$firstHideIndex;
        int childCount = this.$dishContainer.getChildCount();
        if (i < childCount) {
            while (true) {
                int i2 = i + 1;
                View childAt2 = this.$dishContainer.getChildAt(i);
                if (childAt2 != null) {
                    childAt2.setAlpha(1.0f);
                }
                if (!this.$model.isExpand() && (childAt = this.$dishContainer.getChildAt(i)) != null) {
                    childAt.setVisibility(8);
                }
                if (i2 < childCount) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }
}
