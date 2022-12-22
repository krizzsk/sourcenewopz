package com.didi.soda.home.page.deleagteimp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.home.page.CustomerMainPageDelegate;
import com.taxis99.R;

public class CustomerMainPageB extends BaseCustomerMainPage {
    public CustomerMainPageB(CustomerMainPageDelegate.CustomerPageCallback customerPageCallback) {
        super(customerPageCallback);
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View onInflateView = super.onInflateView(layoutInflater, viewGroup);
        m30160a((ViewGroup) (FrameLayout) onInflateView.findViewById(R.id.customer_custom_main_drawer));
        return onInflateView;
    }

    /* renamed from: a */
    private void m30160a(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_home_back_view, viewGroup, false);
        viewGroup.addView(inflate);
        inflate.setOnClickListener($$Lambda$CustomerMainPageB$2c9SAzT1GeJxM9GGY7tXwcZAZwQ.INSTANCE);
        getScopeContext().attach(Const.HomeTags.BACK_VIEW_TAG, inflate);
    }
}
