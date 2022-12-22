package com.didi.soda.customer.widget;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.passenger.C10448R;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class CustomerIndicator extends LinearLayout {

    /* renamed from: a */
    private Context f41459a;

    /* renamed from: b */
    private int f41460b;

    /* renamed from: c */
    private int f41461c;

    /* renamed from: d */
    private int f41462d;

    /* renamed from: e */
    private int f41463e;

    /* renamed from: f */
    private int f41464f;

    /* renamed from: g */
    private List<View> f41465g;

    /* renamed from: h */
    private int f41466h;

    public CustomerIndicator(Context context) {
        this(context, (AttributeSet) null);
        m29345a(context, (AttributeSet) null);
    }

    public CustomerIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        m29345a(context, attributeSet);
    }

    public CustomerIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f41459a = null;
        this.f41465g = null;
        this.f41466h = 0;
        m29345a(context, attributeSet);
    }

    public void initIndicator(int i) {
        List<View> list = this.f41465g;
        if (list == null) {
            this.f41465g = new ArrayList();
        } else {
            list.clear();
            removeAllViews();
        }
        if (i > 1) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f41461c, this.f41460b);
            int i2 = this.f41462d;
            layoutParams.setMargins(i2, i2, i2, i2);
            for (int i3 = 0; i3 < i; i3++) {
                View view = new View(this.f41459a);
                view.setBackgroundResource(R.drawable.customer_banner_indicator_bg);
                ((GradientDrawable) view.getBackground()).setColor(this.f41464f);
                addView(view, layoutParams);
                this.f41465g.add(view);
            }
            if (this.f41465g.size() > 0) {
                ((GradientDrawable) this.f41465g.get(0).getBackground()).setColor(this.f41463e);
            }
            this.f41466h = 0;
        }
    }

    public void setSelectedPage(int i) {
        List<View> list = this.f41465g;
        if (list != null && list.size() > 0) {
            if (i >= this.f41465g.size()) {
                i = this.f41465g.size() - 1;
            }
            int i2 = this.f41466h;
            if (i != i2) {
                m29344a(i2, this.f41463e, this.f41464f);
                m29344a(i, this.f41464f, this.f41463e);
                this.f41466h = i;
            }
        }
    }

    /* renamed from: a */
    private void m29344a(int i, int i2, int i3) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt((GradientDrawable) this.f41465g.get(i).getBackground(), "color", new int[]{i2, i3});
        ofInt.setDuration(260);
        ofInt.setEvaluator(new ArgbEvaluator());
        ofInt.start();
    }

    /* renamed from: a */
    private void m29345a(Context context, AttributeSet attributeSet) {
        this.f41459a = context;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.CustomerIndicator);
            this.f41463e = obtainStyledAttributes.getColor(3, context.getResources().getColor(R.color.rf_color_white_100_FFFFFF));
            this.f41464f = obtainStyledAttributes.getColor(4, context.getResources().getColor(R.color.rf_color_gery_16_93_5C000000));
            this.f41461c = (int) obtainStyledAttributes.getDimension(2, (float) ResourceHelper.getDimensionPixelSize(R.dimen.customer_22px));
            this.f41460b = (int) obtainStyledAttributes.getDimension(0, (float) ResourceHelper.getDimensionPixelSize(R.dimen.customer_6px));
            this.f41462d = (int) obtainStyledAttributes.getDimension(1, (float) ResourceHelper.getDimensionPixelSize(R.dimen.customer_8px));
            obtainStyledAttributes.recycle();
        }
        setGravity(17);
        setOrientation(0);
    }
}
