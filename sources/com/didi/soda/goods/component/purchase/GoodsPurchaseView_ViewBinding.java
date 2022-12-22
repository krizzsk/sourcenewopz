package com.didi.soda.goods.component.purchase;

import android.view.View;
import butterknife.internal.Utils;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalView;
import com.didi.soda.goods.component.AbsCommonGoodsView_ViewBinding;
import com.taxis99.R;

public class GoodsPurchaseView_ViewBinding extends AbsCommonGoodsView_ViewBinding {

    /* renamed from: a */
    private GoodsPurchaseView f42409a;

    public GoodsPurchaseView_ViewBinding(GoodsPurchaseView goodsPurchaseView, View view) {
        super(goodsPurchaseView, view);
        this.f42409a = goodsPurchaseView;
        goodsPurchaseView.mAbnormalView = (TopGunAbnormalView) Utils.findRequiredViewAsType(view, R.id.customer_custom_abnormal_view, "field 'mAbnormalView'", TopGunAbnormalView.class);
    }

    public void unbind() {
        GoodsPurchaseView goodsPurchaseView = this.f42409a;
        if (goodsPurchaseView != null) {
            this.f42409a = null;
            goodsPurchaseView.mAbnormalView = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
