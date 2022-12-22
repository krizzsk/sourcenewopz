package com.didi.payment.pix.home.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.pix.home.PixChannelResp;
import com.didi.payment.pix.home.view.PixOperationBannerEntranceView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\r"}, mo175978d2 = {"com/didi/payment/pix/home/view/PixOperationBannerEntranceView$init$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "lastShownPos", "", "getLastShownPos", "()I", "setLastShownPos", "(I)V", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixOperationBannerEntranceView.kt */
public final class PixOperationBannerEntranceView$init$2 extends RecyclerView.OnScrollListener {
    private int lastShownPos = -1;
    final /* synthetic */ PixOperationBannerEntranceView this$0;

    PixOperationBannerEntranceView$init$2(PixOperationBannerEntranceView pixOperationBannerEntranceView) {
        this.this$0 = pixOperationBannerEntranceView;
    }

    public final int getLastShownPos() {
        return this.lastShownPos;
    }

    public final void setLastShownPos(int i) {
        this.lastShownPos = i;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (i == 0 && this.this$0.mListener != null && recyclerView.getLayoutManager() != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(linearLayoutManager);
            int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            if (findLastCompletelyVisibleItemPosition >= 0 && findLastCompletelyVisibleItemPosition != this.lastShownPos) {
                ((PixOperationBannerEntranceView.OperationItemListener) this.this$0.mListener).onOperationItemShown((PixChannelResp.PanelEntry) this.this$0.getMAdapter().getItem(findLastCompletelyVisibleItemPosition));
                this.lastShownPos = findLastCompletelyVisibleItemPosition;
            }
        }
    }
}
