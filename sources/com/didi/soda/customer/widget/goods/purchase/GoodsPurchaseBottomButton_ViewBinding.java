package com.didi.soda.customer.widget.goods.purchase;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.rfusion.widget.button.RFMainButton;
import com.taxis99.R;

public class GoodsPurchaseBottomButton_ViewBinding implements Unbinder {

    /* renamed from: a */
    private GoodsPurchaseBottomButton f41881a;

    public GoodsPurchaseBottomButton_ViewBinding(GoodsPurchaseBottomButton goodsPurchaseBottomButton) {
        this(goodsPurchaseBottomButton, goodsPurchaseBottomButton);
    }

    public GoodsPurchaseBottomButton_ViewBinding(GoodsPurchaseBottomButton goodsPurchaseBottomButton, View view) {
        this.f41881a = goodsPurchaseBottomButton;
        goodsPurchaseBottomButton.mContainer = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_add_cart_container, "field 'mContainer'", ConstraintLayout.class);
        goodsPurchaseBottomButton.mBottomTempTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_goods_purchase_add_cart, "field 'mBottomTempTv'", TextView.class);
        goodsPurchaseBottomButton.mPriceContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.customer_fl_goods_purchase_price, "field 'mPriceContainer'", ViewGroup.class);
        goodsPurchaseBottomButton.mCurPriceTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_cur_price, "field 'mCurPriceTv'", TextView.class);
        goodsPurchaseBottomButton.mOriPriceTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_ori_price, "field 'mOriPriceTv'", TextView.class);
        goodsPurchaseBottomButton.mMaskView = Utils.findRequiredView(view, R.id.customer_cl_add_cart_mask, "field 'mMaskView'");
        goodsPurchaseBottomButton.mBtnView = (RFMainButton) Utils.findRequiredViewAsType(view, R.id.customer_cl_add_cart, "field 'mBtnView'", RFMainButton.class);
    }

    public void unbind() {
        GoodsPurchaseBottomButton goodsPurchaseBottomButton = this.f41881a;
        if (goodsPurchaseBottomButton != null) {
            this.f41881a = null;
            goodsPurchaseBottomButton.mContainer = null;
            goodsPurchaseBottomButton.mBottomTempTv = null;
            goodsPurchaseBottomButton.mPriceContainer = null;
            goodsPurchaseBottomButton.mCurPriceTv = null;
            goodsPurchaseBottomButton.mOriPriceTv = null;
            goodsPurchaseBottomButton.mMaskView = null;
            goodsPurchaseBottomButton.mBtnView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
