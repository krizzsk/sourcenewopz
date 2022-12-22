package com.didi.soda.goodsV2.component.purchase;

import android.view.View;
import android.widget.ImageView;
import butterknife.internal.Utils;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalView;
import com.didi.soda.customer.widget.goodsV2.purchase.GoodsPurchaseCounter;
import com.didi.soda.goodsV2.component.AbsCommonGoodsView_ViewBinding;
import com.taxis99.R;

public class GoodsPurchaseView_ViewBinding extends AbsCommonGoodsView_ViewBinding {

    /* renamed from: a */
    private GoodsPurchaseView f42499a;

    public GoodsPurchaseView_ViewBinding(GoodsPurchaseView goodsPurchaseView, View view) {
        super(goodsPurchaseView, view);
        this.f42499a = goodsPurchaseView;
        goodsPurchaseView.mAbnormalView = (TopGunAbnormalView) Utils.findRequiredViewAsType(view, R.id.customer_custom_abnormal_view, "field 'mAbnormalView'", TopGunAbnormalView.class);
        goodsPurchaseView.mGoodsPurchaseCounter = (GoodsPurchaseCounter) Utils.findRequiredViewAsType(view, R.id.customer_custom_bottom_counter, "field 'mGoodsPurchaseCounter'", GoodsPurchaseCounter.class);
        goodsPurchaseView.mBackBg = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_page_back_bg, "field 'mBackBg'", ImageView.class);
    }

    public void unbind() {
        GoodsPurchaseView goodsPurchaseView = this.f42499a;
        if (goodsPurchaseView != null) {
            this.f42499a = null;
            goodsPurchaseView.mAbnormalView = null;
            goodsPurchaseView.mGoodsPurchaseCounter = null;
            goodsPurchaseView.mBackBg = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
