package com.didi.soda.customer.widget.headerview.tabitem.p166dy;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import com.didi.soda.customer.widget.headerview.tabitem.ITab;
import com.taxis99.R;

/* renamed from: com.didi.soda.customer.widget.headerview.tabitem.dy.BusinessDyClassifyTab */
public class BusinessDyClassifyTab extends ConstraintLayout implements ITab<BusinessCategoryRvModel> {

    /* renamed from: a */
    private TextView f42023a;

    /* renamed from: b */
    private CharSequence f42024b;

    /* renamed from: c */
    private CharSequence f42025c;

    public BusinessDyClassifyTab(Context context) {
        super(context);
        m29643a();
    }

    public BusinessDyClassifyTab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29643a();
    }

    public BusinessDyClassifyTab(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29643a();
    }

    public void setSelectedState(boolean z, boolean z2) {
        if (!z || !z2) {
            this.f42023a.setSelected(false);
            this.f42023a.setText(this.f42025c);
            return;
        }
        this.f42023a.setSelected(true);
        this.f42023a.setText(this.f42024b);
    }

    public void updateTabView(BusinessCategoryRvModel businessCategoryRvModel, int i, int i2) {
        this.f42024b = businessCategoryRvModel.mSelectedCateName;
        this.f42025c = businessCategoryRvModel.mUnSelectedCateName;
        if (i == 0) {
            setPadding(DisplayUtils.dip2px(getContext(), 0.0f), 0, DisplayUtils.dip2px(getContext(), 0.0f), 0);
        } else if (i == i2 - 1) {
            setPadding(DisplayUtils.dip2px(getContext(), 0.0f), 0, DisplayUtils.dip2px(getContext(), 10.0f), 0);
        } else {
            setPadding(DisplayUtils.dip2px(getContext(), 0.0f), 0, DisplayUtils.dip2px(getContext(), 0.0f), 0);
        }
    }

    /* renamed from: a */
    private void m29643a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_item_business_dy_classify_tab, this);
        this.f42023a = (TextView) findViewById(R.id.customer_tv_business_classify_name);
    }
}
