package com.didi.soda.home.component.titlebar;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.soda.customer.widget.text.IconTextView;
import com.taxis99.R;

public class HomeTitleBarView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private HomeTitleBarView f42622a;

    public HomeTitleBarView_ViewBinding(HomeTitleBarView homeTitleBarView, View view) {
        this.f42622a = homeTitleBarView;
        homeTitleBarView.mAddressTv = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_address_name, "field 'mAddressTv'", TextView.class);
        homeTitleBarView.mAddressArrow = (IconTextView) Utils.findRequiredViewAsType(view, R.id.customer_custom_address_arrow, "field 'mAddressArrow'", IconTextView.class);
    }

    public void unbind() {
        HomeTitleBarView homeTitleBarView = this.f42622a;
        if (homeTitleBarView != null) {
            this.f42622a = null;
            homeTitleBarView.mAddressTv = null;
            homeTitleBarView.mAddressArrow = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
