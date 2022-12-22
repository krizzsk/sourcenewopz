package com.didi.soda.customer.widget.goodsV2.purchase;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.rfusion.widget.button.RFMainButton;
import com.taxis99.R;

public class GoodsPurchaseBottomButton_ViewBinding implements Unbinder {

    /* renamed from: a */
    private GoodsPurchaseBottomButton f41955a;

    public GoodsPurchaseBottomButton_ViewBinding(GoodsPurchaseBottomButton goodsPurchaseBottomButton) {
        this(goodsPurchaseBottomButton, goodsPurchaseBottomButton);
    }

    public GoodsPurchaseBottomButton_ViewBinding(GoodsPurchaseBottomButton goodsPurchaseBottomButton, View view) {
        this.f41955a = goodsPurchaseBottomButton;
        goodsPurchaseBottomButton.mPriceContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.customer_fl_goods_purchase_price, "field 'mPriceContainer'", ViewGroup.class);
        goodsPurchaseBottomButton.mBottomTempTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_goods_purchase_add_cart, "field 'mBottomTempTv'", TextView.class);
        goodsPurchaseBottomButton.mCurPriceTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_cur_price, "field 'mCurPriceTv'", TextView.class);
        goodsPurchaseBottomButton.mOriPriceTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_ori_price, "field 'mOriPriceTv'", TextView.class);
        goodsPurchaseBottomButton.mMaskView = Utils.findRequiredView(view, R.id.customer_cl_add_cart_mask, "field 'mMaskView'");
        goodsPurchaseBottomButton.mBtnView = (RFMainButton) Utils.findRequiredViewAsType(view, R.id.customer_cl_add_cart, "field 'mBtnView'", RFMainButton.class);
        goodsPurchaseBottomButton.mTexView = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_cl_add_cart_text, "field 'mTexView'", TextView.class);
    }

    public void unbind() {
        GoodsPurchaseBottomButton goodsPurchaseBottomButton = this.f41955a;
        if (goodsPurchaseBottomButton != null) {
            this.f41955a = null;
            goodsPurchaseBottomButton.mPriceContainer = null;
            goodsPurchaseBottomButton.mBottomTempTv = null;
            goodsPurchaseBottomButton.mCurPriceTv = null;
            goodsPurchaseBottomButton.mOriPriceTv = null;
            goodsPurchaseBottomButton.mMaskView = null;
            goodsPurchaseBottomButton.mBtnView = null;
            goodsPurchaseBottomButton.mTexView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
