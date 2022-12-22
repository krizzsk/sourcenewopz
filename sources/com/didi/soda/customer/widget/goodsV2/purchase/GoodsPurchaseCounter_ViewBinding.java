package com.didi.soda.customer.widget.goodsV2.purchase;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class GoodsPurchaseCounter_ViewBinding implements Unbinder {

    /* renamed from: a */
    private GoodsPurchaseCounter f41956a;

    public GoodsPurchaseCounter_ViewBinding(GoodsPurchaseCounter goodsPurchaseCounter) {
        this(goodsPurchaseCounter, goodsPurchaseCounter);
    }

    public GoodsPurchaseCounter_ViewBinding(GoodsPurchaseCounter goodsPurchaseCounter, View view) {
        this.f41956a = goodsPurchaseCounter;
        goodsPurchaseCounter.mSubtractIv = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_subtract, "field 'mSubtractIv'", ImageView.class);
        goodsPurchaseCounter.mAddIv = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_add, "field 'mAddIv'", ImageView.class);
        goodsPurchaseCounter.mAmountTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_amount, "field 'mAmountTv'", TextView.class);
    }

    public void unbind() {
        GoodsPurchaseCounter goodsPurchaseCounter = this.f41956a;
        if (goodsPurchaseCounter != null) {
            this.f41956a = null;
            goodsPurchaseCounter.mSubtractIv = null;
            goodsPurchaseCounter.mAddIv = null;
            goodsPurchaseCounter.mAmountTv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
