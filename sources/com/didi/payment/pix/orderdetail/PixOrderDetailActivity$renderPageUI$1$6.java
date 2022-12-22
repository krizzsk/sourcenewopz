package com.didi.payment.pix.orderdetail;

import android.view.View;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.pix.net.response.PixOrderDetailResp;
import com.didi.payment.wallet.global.utils.WalletSecuritySPUtils;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/pix/orderdetail/PixOrderDetailActivity$renderPageUI$1$6", "Lcom/didi/payment/base/widget/DoubleCheckOnClickListener;", "doClick", "", "v", "Landroid/view/View;", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixOrderDetailActivity.kt */
public final class PixOrderDetailActivity$renderPageUI$1$6 extends DoubleCheckOnClickListener {
    final /* synthetic */ PixOrderDetailResp.RuleLimitDetailVo $ruleLimitDetail;
    final /* synthetic */ PixOrderDetailActivity this$0;

    PixOrderDetailActivity$renderPageUI$1$6(PixOrderDetailResp.RuleLimitDetailVo ruleLimitDetailVo, PixOrderDetailActivity pixOrderDetailActivity) {
        this.$ruleLimitDetail = ruleLimitDetailVo;
        this.this$0 = pixOrderDetailActivity;
    }

    public void doClick(View view) {
        CharSequence link = this.$ruleLimitDetail.getLink();
        if (!(link == null || link.length() == 0)) {
            DRouter.build(this.$ruleLimitDetail.getLink()).start(this.this$0);
        }
        Map hashMap = new HashMap();
        hashMap.put("pub_page", "order_finish");
        hashMap.put("pub_target", "text");
        hashMap.put("pub_biz", "fintech");
        hashMap.put("product_line", 99996);
        hashMap.put("text_theme", LoginOmegaUtil.NEED_VERIFY_EMAIL);
        hashMap.put("button_name", "text");
        hashMap.put("kyc_tag", Integer.valueOf(WalletSecuritySPUtils.getKycTag()));
        PayTracker.trackEvent("ibt_fintech_passenger_text_ck", hashMap);
    }
}
