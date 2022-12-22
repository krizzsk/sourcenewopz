package com.didi.soda.customer.biz.popdialog.natived.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.rfusion.widget.button.RFMainButton;
import com.taxis99.R;

public class CouponPopDialogView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private CouponPopDialogView f40508a;

    public CouponPopDialogView_ViewBinding(CouponPopDialogView couponPopDialogView, View view) {
        this.f40508a = couponPopDialogView;
        couponPopDialogView.mRootView = Utils.findRequiredView(view, R.id.customer_ll_pop_root, "field 'mRootView'");
        couponPopDialogView.mPopImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_pop_image, "field 'mPopImage'", ImageView.class);
        couponPopDialogView.mPopListView = (NovaRecyclerView) Utils.findRequiredViewAsType(view, R.id.customer_lv_coupon, "field 'mPopListView'", NovaRecyclerView.class);
        couponPopDialogView.mPopBtn = (RFMainButton) Utils.findRequiredViewAsType(view, R.id.customer_tv_pop_btn, "field 'mPopBtn'", RFMainButton.class);
        couponPopDialogView.mPopClose = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_pop_close, "field 'mPopClose'", ImageView.class);
        couponPopDialogView.mCouponParent = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.customer_ll_coupon_parent, "field 'mCouponParent'", LinearLayout.class);
        couponPopDialogView.mCouponContent = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.customer_cl_coupon_pop_content, "field 'mCouponContent'", ConstraintLayout.class);
    }

    public void unbind() {
        CouponPopDialogView couponPopDialogView = this.f40508a;
        if (couponPopDialogView != null) {
            this.f40508a = null;
            couponPopDialogView.mRootView = null;
            couponPopDialogView.mPopImage = null;
            couponPopDialogView.mPopListView = null;
            couponPopDialogView.mPopBtn = null;
            couponPopDialogView.mPopClose = null;
            couponPopDialogView.mCouponParent = null;
            couponPopDialogView.mCouponContent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
