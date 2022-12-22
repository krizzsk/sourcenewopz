package com.didi.soda.business.component.image;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.soda.customer.widget.goods.CustomerPriceView;
import com.taxis99.R;

public class BusinessPreviewImageView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private BusinessPreviewImageView f39610a;

    public BusinessPreviewImageView_ViewBinding(BusinessPreviewImageView businessPreviewImageView, View view) {
        this.f39610a = businessPreviewImageView;
        businessPreviewImageView.mImageView = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_business_preview_image, "field 'mImageView'", ImageView.class);
        businessPreviewImageView.mNameView = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_image_name, "field 'mNameView'", TextView.class);
        businessPreviewImageView.mPriceView = (CustomerPriceView) Utils.findRequiredViewAsType(view, R.id.customer_tv_image_price, "field 'mPriceView'", CustomerPriceView.class);
        businessPreviewImageView.mAddBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_image_add_btn, "field 'mAddBtn'", TextView.class);
        businessPreviewImageView.mAddContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_fl_add_container, "field 'mAddContainer'", FrameLayout.class);
        businessPreviewImageView.mBackView = Utils.findRequiredView(view, R.id.customer_cl_preview_image_back, "field 'mBackView'");
    }

    public void unbind() {
        BusinessPreviewImageView businessPreviewImageView = this.f39610a;
        if (businessPreviewImageView != null) {
            this.f39610a = null;
            businessPreviewImageView.mImageView = null;
            businessPreviewImageView.mNameView = null;
            businessPreviewImageView.mPriceView = null;
            businessPreviewImageView.mAddBtn = null;
            businessPreviewImageView.mAddContainer = null;
            businessPreviewImageView.mBackView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
