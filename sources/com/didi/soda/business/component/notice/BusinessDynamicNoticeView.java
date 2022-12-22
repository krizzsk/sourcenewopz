package com.didi.soda.business.component.notice;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.didi.soda.business.component.notice.Contract;
import com.taxis99.R;

public class BusinessDynamicNoticeView extends Contract.IDynamicNoticeView {
    @BindView(18145)
    FrameLayout mContainer;
    @BindView(18912)
    TextView mNoticeContentTv;

    public void updateView(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mContainer.setVisibility(8);
            return;
        }
        this.mNoticeContentTv.setText(str);
        this.mContainer.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_component_business_dynamic_notice, viewGroup, true);
    }
}
