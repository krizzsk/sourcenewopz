package com.didi.soda.cart.component.globalmini;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.customer.widget.text.RichTextView;
import com.taxis99.R;

public class CustomerGlobalMiniCartView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private CustomerGlobalMiniCartView f39982a;

    public CustomerGlobalMiniCartView_ViewBinding(CustomerGlobalMiniCartView customerGlobalMiniCartView, View view) {
        this.f39982a = customerGlobalMiniCartView;
        customerGlobalMiniCartView.mButton = (RFMainButton) Utils.findRequiredViewAsType(view, R.id.customer_custom_mini_cart_content, "field 'mButton'", RFMainButton.class);
        customerGlobalMiniCartView.mOfferPassParent = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.customer_cl_offer_pass_parent, "field 'mOfferPassParent'", ConstraintLayout.class);
        customerGlobalMiniCartView.mOfferPassText = (RichTextView) Utils.findRequiredViewAsType(view, R.id.customer_custom_offer_pass, "field 'mOfferPassText'", RichTextView.class);
        customerGlobalMiniCartView.mContainer = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.customer_custom_mini_cart_container, "field 'mContainer'", FrameLayout.class);
    }

    public void unbind() {
        CustomerGlobalMiniCartView customerGlobalMiniCartView = this.f39982a;
        if (customerGlobalMiniCartView != null) {
            this.f39982a = null;
            customerGlobalMiniCartView.mButton = null;
            customerGlobalMiniCartView.mOfferPassParent = null;
            customerGlobalMiniCartView.mOfferPassText = null;
            customerGlobalMiniCartView.mContainer = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
