package com.didi.payment.pix.home;

import android.text.TextUtils;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.pix.home.PixChannelResp;
import com.didi.payment.pix.home.view.PixOperationBannerEntranceView;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/payment/pix/home/PixChannelHomeActivity$initView$2", "Lcom/didi/payment/pix/home/view/PixOperationBannerEntranceView$OperationItemListener;", "onOperationItemClicked", "", "item", "Lcom/didi/payment/pix/home/PixChannelResp$PanelEntry;", "onOperationItemShown", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixChannelHomeActivity.kt */
public final class PixChannelHomeActivity$initView$2 implements PixOperationBannerEntranceView.OperationItemListener {
    final /* synthetic */ PixChannelHomeActivity this$0;

    public void onOperationItemShown(PixChannelResp.PanelEntry panelEntry) {
    }

    PixChannelHomeActivity$initView$2(PixChannelHomeActivity pixChannelHomeActivity) {
        this.this$0 = pixChannelHomeActivity;
    }

    public void onOperationItemClicked(PixChannelResp.PanelEntry panelEntry) {
        if (panelEntry != null && !TextUtils.isEmpty(panelEntry.getLinkUrl())) {
            WebBrowserUtil.startInternalWebActivity(this.this$0, panelEntry.getLinkUrl(), panelEntry.getTitle());
        }
    }
}
