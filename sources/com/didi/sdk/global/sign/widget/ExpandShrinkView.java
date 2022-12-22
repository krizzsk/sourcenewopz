package com.didi.sdk.global.sign.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.taxis99.R;

public class ExpandShrinkView extends LinearLayout {

    /* renamed from: a */
    private View f36355a;

    /* renamed from: b */
    private View f36356b;

    public ExpandShrinkView(Context context) {
        super(context);
        m25729a(context);
    }

    public ExpandShrinkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25729a(context);
    }

    public ExpandShrinkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m25729a(context);
    }

    /* renamed from: a */
    private void m25729a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.one_payment_v_global_pay_list_expand_shrink, this, true);
        this.f36355a = inflate.findViewById(R.id.tv_more);
        this.f36356b = inflate.findViewById(R.id.tv_less);
    }

    public void setIsExpand(boolean z) {
        if (z) {
            this.f36355a.setVisibility(8);
            this.f36356b.setVisibility(0);
            return;
        }
        this.f36355a.setVisibility(0);
        this.f36356b.setVisibility(8);
    }
}
