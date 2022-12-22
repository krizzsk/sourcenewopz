package com.didi.soda.customer.widget.goodsV2;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.passenger.C10448R;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;

public class CustomerPriceView extends LinearLayout {

    /* renamed from: a */
    private static final String f41911a = "CustomerPriceView";

    /* renamed from: b */
    private static final int f41912b = -16777216;

    /* renamed from: c */
    private static final float f41913c = 6.0f;

    /* renamed from: d */
    private int f41914d = -16777216;

    /* renamed from: e */
    private int f41915e = -16777216;

    /* renamed from: f */
    private float f41916f;

    /* renamed from: g */
    private float f41917g;

    /* renamed from: h */
    private CharSequence f41918h = "";

    /* renamed from: i */
    private CharSequence f41919i = "";

    /* renamed from: j */
    private TextView f41920j;

    /* renamed from: k */
    private TextView f41921k;

    /* renamed from: l */
    private IToolsService.FontType f41922l = IToolsService.FontType.BOLD;

    /* renamed from: m */
    private IToolsService.FontType f41923m = IToolsService.FontType.NORMAL;

    public CustomerPriceView(Context context) {
        super(context);
        m29551a(context, (AttributeSet) null);
    }

    public CustomerPriceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29551a(context, attributeSet);
    }

    public CustomerPriceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29551a(context, attributeSet);
    }

    public void setFontType(IToolsService.FontType fontType, IToolsService.FontType fontType2) {
        this.f41922l = fontType;
        this.f41923m = fontType2;
        m29550a();
    }

    public void setPriceStr(CharSequence charSequence, CharSequence charSequence2) {
        if (TextUtils.isEmpty(charSequence2)) {
            charSequence2 = "";
        }
        this.f41918h = charSequence;
        this.f41919i = charSequence2;
        m29553c();
    }

    public void setPriceLight(boolean z) {
        if (z) {
            this.f41920j.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_brand1_1_a100));
        } else {
            this.f41920j.setTextColor(-16777216);
        }
    }

    /* renamed from: a */
    private void m29551a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.CustomerPriceView);
            this.f41914d = obtainStyledAttributes.getColor(0, -16777216);
            this.f41915e = obtainStyledAttributes.getColor(6, -16777216);
            this.f41916f = (float) obtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.f41917g = (float) obtainStyledAttributes.getDimensionPixelSize(7, 0);
            obtainStyledAttributes.recycle();
        }
        this.f41920j = new TextView(context);
        this.f41921k = new TextView(context);
        this.f41920j.setTextColor(this.f41914d);
        this.f41921k.setTextColor(this.f41915e);
        this.f41921k.getPaint().setFlags(16);
        this.f41921k.getPaint().setAntiAlias(true);
        this.f41920j.setTextSize(0, this.f41916f);
        this.f41921k.setTextSize(0, this.f41917g);
        this.f41920j.setMaxLines(1);
        this.f41921k.setMaxLines(1);
        m29552b();
        m29550a();
    }

    /* renamed from: a */
    private void m29550a() {
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41920j, this.f41922l);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41921k, this.f41923m);
    }

    /* renamed from: b */
    private void m29552b() {
        setOrientation(0);
        setGravity(16);
        this.f41920j.setPadding(0, 0, DisplayUtils.dip2px(getContext(), f41913c), 0);
        this.f41921k.setPadding(0, 0, 0, 0);
        addView(this.f41920j, new LinearLayoutCompat.LayoutParams(-2, -2));
        addView(this.f41921k, new LinearLayoutCompat.LayoutParams(-2, -2));
    }

    /* renamed from: c */
    private void m29553c() {
        this.f41920j.setText(this.f41918h);
        this.f41921k.setText(this.f41919i);
        if (TextUtils.isEmpty(this.f41918h)) {
            this.f41920j.setVisibility(8);
        } else {
            this.f41920j.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.f41919i)) {
            this.f41921k.setVisibility(8);
        } else {
            this.f41921k.setVisibility(0);
        }
    }
}
