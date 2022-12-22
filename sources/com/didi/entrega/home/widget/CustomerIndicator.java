package com.didi.entrega.home.widget;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.passenger.C10448R;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class CustomerIndicator extends LinearLayout {

    /* renamed from: a */
    private Context f20740a;

    /* renamed from: b */
    private int f20741b;

    /* renamed from: c */
    private int f20742c;

    /* renamed from: d */
    private int f20743d;

    /* renamed from: e */
    private int f20744e;

    /* renamed from: f */
    private int f20745f;

    /* renamed from: g */
    private List<View> f20746g;

    /* renamed from: h */
    private int f20747h;

    public CustomerIndicator(Context context) {
        this(context, (AttributeSet) null);
        m15174a(context, (AttributeSet) null);
    }

    public CustomerIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        m15174a(context, attributeSet);
    }

    public CustomerIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20740a = null;
        this.f20746g = null;
        this.f20747h = 0;
        m15174a(context, attributeSet);
    }

    public void initIndicator(int i) {
        List<View> list = this.f20746g;
        if (list == null) {
            this.f20746g = new ArrayList();
        } else {
            list.clear();
            removeAllViews();
        }
        if (i > 1) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f20742c, this.f20741b);
            int i2 = this.f20743d;
            layoutParams.setMargins(i2, i2, i2, i2);
            for (int i3 = 0; i3 < i; i3++) {
                View view = new View(this.f20740a);
                view.setBackgroundResource(R.drawable.entrega_banner_indicator_bg);
                ((GradientDrawable) view.getBackground()).setColor(this.f20745f);
                addView(view, layoutParams);
                this.f20746g.add(view);
            }
            if (this.f20746g.size() > 0) {
                ((GradientDrawable) this.f20746g.get(0).getBackground()).setColor(this.f20744e);
            }
            this.f20747h = 0;
        }
    }

    public void setSelectedPage(int i) {
        List<View> list = this.f20746g;
        if (list != null && list.size() > 0) {
            if (i >= this.f20746g.size()) {
                i = this.f20746g.size() - 1;
            }
            int i2 = this.f20747h;
            if (i != i2) {
                m15173a(i2, this.f20744e, this.f20745f);
                m15173a(i, this.f20745f, this.f20744e);
                this.f20747h = i;
            }
        }
    }

    /* renamed from: a */
    private void m15173a(int i, int i2, int i3) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt((GradientDrawable) this.f20746g.get(i).getBackground(), "color", new int[]{i2, i3});
        ofInt.setDuration(260);
        ofInt.setEvaluator(new ArgbEvaluator());
        ofInt.start();
    }

    /* renamed from: a */
    private void m15174a(Context context, AttributeSet attributeSet) {
        this.f20740a = context;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.EntregaIndicator);
            this.f20744e = obtainStyledAttributes.getColor(3, context.getResources().getColor(R.color.rf_color_white_100_FFFFFF));
            this.f20745f = obtainStyledAttributes.getColor(4, context.getResources().getColor(R.color.rf_color_gery_16_93_5C000000));
            this.f20742c = (int) obtainStyledAttributes.getDimension(2, (float) ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_22));
            this.f20741b = (int) obtainStyledAttributes.getDimension(0, (float) ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_6));
            this.f20743d = (int) obtainStyledAttributes.getDimension(1, (float) ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_8));
            obtainStyledAttributes.recycle();
        }
        setGravity(17);
        setOrientation(0);
    }
}
