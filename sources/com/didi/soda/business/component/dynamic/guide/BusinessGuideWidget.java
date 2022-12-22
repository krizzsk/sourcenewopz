package com.didi.soda.business.component.dynamic.guide;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;

public class BusinessGuideWidget extends ConstraintLayout {

    /* renamed from: a */
    private static final String f39465a = "BusinessGuideWidget";

    /* renamed from: b */
    private CustomerAppCompatTextView f39466b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnDismissListener f39467c;

    public interface OnDismissListener {
        void onDismiss();
    }

    public BusinessGuideWidget(Context context) {
        this(context, (AttributeSet) null);
    }

    public BusinessGuideWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BusinessGuideWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m27996a();
    }

    /* renamed from: a */
    private void m27996a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_business_guide_view, this, true);
        this.f39466b = (CustomerAppCompatTextView) findViewById(R.id.customer_tv_content_guide);
        findViewById(R.id.customer_tv_guide_confirm).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BusinessGuideWidget.this.setVisibility(8);
                if (BusinessGuideWidget.this.f39467c != null) {
                    BusinessGuideWidget.this.f39467c.onDismiss();
                }
            }
        });
        findViewById(R.id.customer_business_guide_root_container).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BusinessGuideWidget.this.setVisibility(8);
                if (BusinessGuideWidget.this.f39467c != null) {
                    BusinessGuideWidget.this.f39467c.onDismiss();
                }
            }
        });
    }

    public void setVisibility(int i) {
        if (getVisibility() != i) {
            super.setVisibility(i);
        }
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f39467c = onDismissListener;
    }
}
