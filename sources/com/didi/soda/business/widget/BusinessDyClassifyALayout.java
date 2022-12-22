package com.didi.soda.business.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.didi.rfusion.widget.RFIconView;
import com.taxis99.R;

public class BusinessDyClassifyALayout extends ConstraintLayout {

    /* renamed from: a */
    private static final String f39770a = "BusinessDyClassifyALayout";
    @BindView(18381)
    RFIconView mClassifyIcon;
    @BindView(18346)
    RFIconView mClassifySearchIcon;
    @BindView(18857)
    TextView mClassifyTv;

    public BusinessDyClassifyALayout(Context context) {
        super(context);
        m28350a();
    }

    public BusinessDyClassifyALayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m28350a();
    }

    public BusinessDyClassifyALayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m28350a();
    }

    public void setMenuClickListener(View.OnClickListener onClickListener) {
        this.mClassifyIcon.setOnClickListener(onClickListener);
        this.mClassifyTv.setOnClickListener(onClickListener);
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.mClassifySearchIcon.setOnClickListener(onClickListener);
    }

    /* renamed from: a */
    private void m28350a() {
        ButterKnife.bind((Object) this, LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_dy_business_classify_a, this, true));
        setClickable(false);
    }
}
