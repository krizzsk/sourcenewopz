package com.didi.soda.goodsV2.component;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.soda.customer.widget.goodsV2.purchase.GoodsPurchaseBottomButton;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.customer.widget.text.IconTextView;
import com.taxis99.R;

public class AbsCommonGoodsView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private AbsCommonGoodsView f42441a;

    public AbsCommonGoodsView_ViewBinding(AbsCommonGoodsView absCommonGoodsView, View view) {
        this.f42441a = absCommonGoodsView;
        absCommonGoodsView.mBottomButton = (GoodsPurchaseBottomButton) Utils.findRequiredViewAsType(view, R.id.customer_custom_bottom_button, "field 'mBottomButton'", GoodsPurchaseBottomButton.class);
        absCommonGoodsView.mTitleView = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_tbv_title_view, "field 'mTitleView'", FrameLayout.class);
        absCommonGoodsView.mTitleTvView = (CustomerAppCompatTextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_title_label, "field 'mTitleTvView'", CustomerAppCompatTextView.class);
        absCommonGoodsView.mBackView = (IconTextView) Utils.findRequiredViewAsType(view, R.id.customer_iv_page_back, "field 'mBackView'", IconTextView.class);
        absCommonGoodsView.mStickyHeaderContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_purchase_rv_container, "field 'mStickyHeaderContainer'", FrameLayout.class);
        absCommonGoodsView.mRecyclerView = (NovaRecyclerView) Utils.findRequiredViewAsType(view, R.id.customer_custom_goods_purchase, "field 'mRecyclerView'", NovaRecyclerView.class);
        absCommonGoodsView.mShadowConstrain = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.customer_custom_bottom_button_add, "field 'mShadowConstrain'", ConstraintLayout.class);
    }

    public void unbind() {
        AbsCommonGoodsView absCommonGoodsView = this.f42441a;
        if (absCommonGoodsView != null) {
            this.f42441a = null;
            absCommonGoodsView.mBottomButton = null;
            absCommonGoodsView.mTitleView = null;
            absCommonGoodsView.mTitleTvView = null;
            absCommonGoodsView.mBackView = null;
            absCommonGoodsView.mStickyHeaderContainer = null;
            absCommonGoodsView.mRecyclerView = null;
            absCommonGoodsView.mShadowConstrain = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
