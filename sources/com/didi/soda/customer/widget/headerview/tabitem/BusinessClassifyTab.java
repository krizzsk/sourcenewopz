package com.didi.soda.customer.widget.headerview.tabitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import com.taxis99.R;

public class BusinessClassifyTab extends ConstraintLayout implements ITab<BusinessCategoryRvModel> {

    /* renamed from: a */
    private TextView f42020a;

    /* renamed from: b */
    private CharSequence f42021b;

    /* renamed from: c */
    private CharSequence f42022c;

    public BusinessClassifyTab(Context context) {
        super(context);
        m29641a();
    }

    public BusinessClassifyTab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29641a();
    }

    public BusinessClassifyTab(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29641a();
    }

    public void setSelectedState(boolean z, boolean z2) {
        if (z) {
            this.f42020a.setSelected(true);
            this.f42020a.setText(this.f42021b);
            return;
        }
        this.f42020a.setSelected(false);
        this.f42020a.setText(this.f42022c);
    }

    public void updateTabView(BusinessCategoryRvModel businessCategoryRvModel, int i, int i2) {
        this.f42021b = businessCategoryRvModel.mSelectedCateName;
        this.f42022c = businessCategoryRvModel.mUnSelectedCateName;
        if (i == 0) {
            setPadding(DisplayUtils.dip2px(getContext(), 16.0f), 0, DisplayUtils.dip2px(getContext(), 12.0f), 0);
        } else if (i == i2) {
            setPadding(DisplayUtils.dip2px(getContext(), 12.0f), 0, DisplayUtils.dip2px(getContext(), 20.0f), 0);
        } else {
            setPadding(DisplayUtils.dip2px(getContext(), 12.0f), 0, DisplayUtils.dip2px(getContext(), 12.0f), 0);
        }
    }

    /* renamed from: a */
    private void m29641a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_item_business_classify_tab, this);
        this.f42020a = (TextView) findViewById(R.id.customer_tv_business_classify_name);
    }
}
