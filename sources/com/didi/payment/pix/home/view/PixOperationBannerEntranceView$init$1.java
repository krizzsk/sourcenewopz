package com.didi.payment.pix.home.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.utils.UIUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007¨\u0006\u0015"}, mo175978d2 = {"com/didi/payment/pix/home/view/PixOperationBannerEntranceView$init$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "internalSpace", "", "getInternalSpace", "()I", "setInternalSpace", "(I)V", "outSpace", "getOutSpace", "setOutSpace", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixOperationBannerEntranceView.kt */
public final class PixOperationBannerEntranceView$init$1 extends RecyclerView.ItemDecoration {
    private int internalSpace = UIUtil.dip2px(this.this$0.mContext, 10.0f);
    private int outSpace = UIUtil.dip2px(this.this$0.mContext, 15.0f);
    final /* synthetic */ PixOperationBannerEntranceView this$0;

    PixOperationBannerEntranceView$init$1(PixOperationBannerEntranceView pixOperationBannerEntranceView) {
        this.this$0 = pixOperationBannerEntranceView;
    }

    public final int getOutSpace() {
        return this.outSpace;
    }

    public final void setOutSpace(int i) {
        this.outSpace = i;
    }

    public final int getInternalSpace() {
        return this.internalSpace;
    }

    public final void setInternalSpace(int i) {
        this.internalSpace = i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        rect.left = childAdapterPosition != 0 ? this.internalSpace : this.outSpace;
        if (childAdapterPosition == this.this$0.getMAdapter().getItemCount() - 1) {
            rect.right = this.outSpace;
        }
    }
}
