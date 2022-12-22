package com.didi.soda.order.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.taxis99.R;

public class OrderFeeItemView extends OrderDetailFeeItemView {
    public OrderFeeItemView(Context context) {
        super(context);
    }

    public OrderFeeItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OrderFeeItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void inflate() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_item_order_preview_fee, this);
    }
}
