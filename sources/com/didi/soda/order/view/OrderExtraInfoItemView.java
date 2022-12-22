package com.didi.soda.order.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.taxis99.R;

public class OrderExtraInfoItemView extends ConstraintLayout {

    /* renamed from: a */
    private TextView f43612a;

    /* renamed from: b */
    private TextView f43613b;

    public OrderExtraInfoItemView(Context context) {
        super(context);
        m30908a();
    }

    public OrderExtraInfoItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30908a();
    }

    public OrderExtraInfoItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30908a();
    }

    public void setText(String str, String str2) {
        this.f43612a.setText(str);
        this.f43613b.setText(str2);
    }

    /* renamed from: a */
    private void m30908a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_item_order_extra_info, this);
        this.f43612a = (TextView) findViewById(R.id.customer_tv_title);
        this.f43613b = (TextView) findViewById(R.id.customer_tv_desc);
    }
}
