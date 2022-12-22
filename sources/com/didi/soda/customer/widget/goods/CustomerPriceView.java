package com.didi.soda.customer.widget.goods;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.passenger.C10448R;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;

public class CustomerPriceView extends LinearLayout {

    /* renamed from: a */
    private static final String f41829a = "CustomerPriceView";

    /* renamed from: b */
    private static final int f41830b = -16777216;

    /* renamed from: c */
    private static final float f41831c = 6.0f;

    /* renamed from: d */
    private int f41832d = -16777216;

    /* renamed from: e */
    private int f41833e = -16777216;

    /* renamed from: f */
    private int f41834f = -16777216;

    /* renamed from: g */
    private int f41835g = -16777216;

    /* renamed from: h */
    private float f41836h;

    /* renamed from: i */
    private float f41837i;

    /* renamed from: j */
    private CharSequence f41838j = "";

    /* renamed from: k */
    private CharSequence f41839k = "";

    /* renamed from: l */
    private TextView f41840l;

    /* renamed from: m */
    private TextView f41841m;

    /* renamed from: n */
    private float f41842n = 0.0f;

    /* renamed from: o */
    private boolean f41843o = true;

    /* renamed from: p */
    private boolean f41844p = false;

    /* renamed from: q */
    private boolean f41845q = true;

    /* renamed from: r */
    private boolean f41846r = false;

    /* renamed from: s */
    private IToolsService.FontType f41847s = IToolsService.FontType.MEDIUM;

    /* renamed from: t */
    private IToolsService.FontType f41848t = IToolsService.FontType.NORMAL;

    public CustomerPriceView(Context context) {
        super(context);
        m29507a(context, (AttributeSet) null);
    }

    public CustomerPriceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29507a(context, attributeSet);
    }

    public CustomerPriceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29507a(context, attributeSet);
    }

    public void setFontType(IToolsService.FontType fontType, IToolsService.FontType fontType2) {
        this.f41847s = fontType;
        this.f41848t = fontType2;
        m29505a();
    }

    public float getCurPriceSize() {
        return this.f41836h;
    }

    public float getOriPriceSize() {
        return this.f41837i;
    }

    public void setEnabled(boolean z) {
        this.f41843o = z;
        m29512d();
        super.setEnabled(z);
    }

    public void setMaxWidth(int i) {
        this.f41842n = (float) i;
        m29512d();
    }

    public void setCurPriceColor(int i) {
        this.f41832d = i;
    }

    public void setOriginPriceColor(int i) {
        this.f41833e = i;
    }

    public void setDisableCurPriceColor(int i) {
        this.f41834f = i;
    }

    public void setDisableOriginPriceColor(int i) {
        this.f41835g = i;
    }

    public void setPriceStr(CharSequence charSequence, CharSequence charSequence2) {
        if (TextUtils.isEmpty(charSequence2)) {
            charSequence2 = "";
        }
        this.f41838j = charSequence;
        this.f41839k = charSequence2;
        m29512d();
    }

    public void setPriceTextSize(float f, float f2) {
        this.f41836h = f;
        this.f41837i = f2;
        m29512d();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            i3 += getChildAt(i4).getMeasuredWidth();
        }
        int paddingLeft = i3 + getPaddingLeft() + getPaddingRight();
        if (getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            paddingLeft = paddingLeft + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        }
        if (!this.f41845q) {
            paddingLeft += DisplayUtils.dip2px(getContext(), f41831c);
        }
        m29508a("rough total: " + paddingLeft + " max width: " + this.f41842n);
        if (this.f41846r) {
            return;
        }
        if (this.f41845q) {
            if (((float) paddingLeft) >= this.f41842n) {
                this.f41846r = true;
                m29506a(i, i2);
            }
        } else if (((float) paddingLeft) < this.f41842n) {
            this.f41846r = true;
            m29510b(i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f41846r = false;
    }

    /* renamed from: a */
    private void m29507a(Context context, AttributeSet attributeSet) {
        float screenWidth = (float) CustomerSystemUtil.getScreenWidth(context);
        this.f41842n = screenWidth;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.CustomerPriceView);
            this.f41832d = obtainStyledAttributes.getColor(0, -16777216);
            this.f41833e = obtainStyledAttributes.getColor(6, -16777216);
            this.f41834f = obtainStyledAttributes.getColor(2, -16777216);
            this.f41835g = obtainStyledAttributes.getColor(3, -16777216);
            this.f41836h = obtainStyledAttributes.getDimension(1, 0.0f);
            this.f41837i = obtainStyledAttributes.getDimension(7, 0.0f);
            this.f41842n = obtainStyledAttributes.getDimension(5, screenWidth);
            this.f41844p = obtainStyledAttributes.getBoolean(4, false);
            obtainStyledAttributes.recycle();
        }
        this.f41840l = new TextView(context);
        this.f41841m = new TextView(context);
        this.f41840l.setMaxLines(1);
        this.f41841m.setMaxLines(1);
        m29509b();
        m29505a();
    }

    /* renamed from: a */
    private void m29505a() {
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41840l, this.f41847s);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41841m, this.f41848t);
    }

    /* renamed from: a */
    private void m29506a(int i, int i2) {
        if (this.f41845q) {
            removeAllViews();
            m29511c();
            measure(i, i2);
        }
    }

    /* renamed from: b */
    private void m29510b(int i, int i2) {
        if (!this.f41845q) {
            removeAllViews();
            m29509b();
            measure(i, i2);
        }
    }

    /* renamed from: b */
    private void m29509b() {
        setOrientation(0);
        if (this.f41844p) {
            this.f41840l.setPadding(0, 0, 0, 0);
            this.f41841m.setPadding(0, 0, DisplayUtils.dip2px(getContext(), f41831c), 0);
            addView(this.f41841m, new LinearLayoutCompat.LayoutParams(-2, -2));
            addView(this.f41840l, new LinearLayoutCompat.LayoutParams(-2, -2));
        } else {
            this.f41840l.setPadding(0, 0, DisplayUtils.dip2px(getContext(), f41831c), 0);
            this.f41841m.setPadding(0, 0, 0, 0);
            addView(this.f41840l, new LinearLayoutCompat.LayoutParams(-2, -2));
            addView(this.f41841m, new LinearLayoutCompat.LayoutParams(-2, -2));
        }
        this.f41845q = true;
    }

    /* renamed from: c */
    private void m29511c() {
        setOrientation(1);
        this.f41840l.setPadding(0, 0, 0, 0);
        this.f41841m.setPadding(0, DisplayUtils.dip2px(getContext(), f41831c), 0, 0);
        addView(this.f41840l, new LinearLayoutCompat.LayoutParams(-2, -2));
        addView(this.f41841m, new LinearLayoutCompat.LayoutParams(-2, -2));
        this.f41845q = false;
    }

    /* renamed from: d */
    private void m29512d() {
        CharSequence charSequence = this.f41838j;
        CharSequence charSequence2 = this.f41839k;
        SpannableString spannableString = new SpannableString(charSequence);
        if (this.f41836h > 0.0f) {
            spannableString.setSpan(new AbsoluteSizeSpan((int) this.f41836h), 0, charSequence.length(), 33);
        }
        SpannableString spannableString2 = new SpannableString(charSequence2);
        if (this.f41837i > 0.0f) {
            spannableString2.setSpan(new AbsoluteSizeSpan((int) this.f41837i), 0, charSequence2.length(), 33);
        }
        spannableString2.setSpan(new StrikethroughSpan(), 0, charSequence2.length(), 33);
        if (this.f41843o) {
            spannableString.setSpan(new ForegroundColorSpan(this.f41832d), 0, charSequence.length(), 33);
            spannableString2.setSpan(new ForegroundColorSpan(this.f41833e), 0, charSequence2.length(), 33);
        } else {
            spannableString.setSpan(new ForegroundColorSpan(this.f41834f), 0, charSequence.length(), 33);
            spannableString2.setSpan(new ForegroundColorSpan(this.f41835g), 0, charSequence2.length(), 33);
        }
        this.f41840l.setText(spannableString);
        this.f41841m.setText(spannableString2);
        if (TextUtils.isEmpty(charSequence2)) {
            this.f41841m.setVisibility(this.f41845q ? 4 : 8);
        } else {
            this.f41841m.setVisibility(0);
        }
    }

    /* renamed from: a */
    private void m29508a(String str) {
        LogUtil.m29100d(f41829a, str);
    }
}
