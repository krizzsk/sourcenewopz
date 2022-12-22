package com.didi.soda.customer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.passenger.C10448R;
import com.taxis99.R;

public class CustomerCommonBubbleView extends BubbleLayout {

    /* renamed from: a */
    private TextView f41455a;

    /* renamed from: b */
    private TextView f41456b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CommonBubbleListener f41457c;

    public /* bridge */ /* synthetic */ void setBubbleParams(int i, float f) {
        super.setBubbleParams(i, f);
    }

    public /* bridge */ /* synthetic */ void setFillColor(int i) {
        super.setFillColor(i);
    }

    public CustomerCommonBubbleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CustomerCommonBubbleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomerCommonBubbleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.CustomerCommonBubbleView);
        int resourceId = obtainStyledAttributes.getResourceId(3, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(4, R.layout.customer_common_bubble);
        int i2 = obtainStyledAttributes.getInt(0, 0);
        int color = obtainStyledAttributes.getColor(2, context.getResources().getColor(R.color.customer_color_E625262D));
        float f = obtainStyledAttributes.getFloat(1, -1.0f);
        obtainStyledAttributes.recycle();
        setFillColor(color);
        setBubbleParams(i2, f);
        m29343a(context, resourceId2, resourceId);
    }

    public void setBubbleView(View view) {
        setBackgroundColor(0);
        addView(view);
        setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
    }

    public void setBuddleOrientation(int i) {
        setBubbleParams(i, -1.0f);
    }

    public void setCommonBubbleListener(CommonBubbleListener commonBubbleListener) {
        this.f41457c = commonBubbleListener;
    }

    public void setContent(String str) {
        this.f41455a.setText(str);
        if (TextUtils.isEmpty(str)) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void setContentNotShow(String str) {
        this.f41455a.setText(str);
    }

    /* renamed from: a */
    private void m29343a(Context context, int i, int i2) {
        setOrientation(1);
        View inflate = inflate(context, i, (ViewGroup) null);
        this.f41455a = (TextView) inflate.findViewWithTag("bubble_content");
        this.f41456b = (TextView) inflate.findViewWithTag("bubble_close");
        setBubbleView(inflate);
        if (i2 != -1) {
            this.f41455a.setText(context.getResources().getString(i2));
        }
        this.f41456b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CustomerCommonBubbleView.this.setVisibility(8);
                if (CustomerCommonBubbleView.this.f41457c != null) {
                    CustomerCommonBubbleView.this.f41457c.onBubbleCloseClick();
                }
            }
        });
        inflate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (CustomerCommonBubbleView.this.f41457c != null) {
                    CustomerCommonBubbleView.this.f41457c.onBubbleCloseClick();
                }
            }
        });
    }
}
