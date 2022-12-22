package com.didi.map.global.component.departure.wheel.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SimpleWheelItem extends FrameLayout {

    /* renamed from: a */
    private TextView f25424a;

    public SimpleWheelItem(Context context) {
        super(context);
        m18191a();
    }

    public SimpleWheelItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18191a();
    }

    public SimpleWheelItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18191a();
    }

    /* renamed from: a */
    private void m18191a() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, WheelUtils.dip2px(getContext(), 45.0f));
        linearLayout.setOrientation(0);
        linearLayout.setPadding(20, 20, 20, 20);
        linearLayout.setGravity(17);
        addView(linearLayout, layoutParams);
        TextView textView = new TextView(getContext());
        this.f25424a = textView;
        textView.setTag(101);
        this.f25424a.setEllipsize(TextUtils.TruncateAt.END);
        this.f25424a.setSingleLine();
        this.f25424a.setIncludeFontPadding(false);
        this.f25424a.setGravity(17);
        this.f25424a.setTextColor(-16777216);
        linearLayout.addView(this.f25424a, new FrameLayout.LayoutParams(-1, -1));
    }

    public void setText(CharSequence charSequence) {
        this.f25424a.setText(charSequence);
    }
}
