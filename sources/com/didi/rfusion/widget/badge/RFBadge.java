package com.didi.rfusion.widget.badge;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFTextView;
import com.taxis99.R;

public class RFBadge extends RFTextView implements C11527a {

    /* renamed from: a */
    private static final int f33319a = 99;

    /* renamed from: b */
    private static final int f33320b = 8;

    /* renamed from: c */
    private static final String f33321c = "+";

    /* renamed from: d */
    private int f33322d;

    /* renamed from: e */
    private int f33323e;

    /* renamed from: f */
    private String f33324f;

    /* renamed from: g */
    private int f33325g;

    /* renamed from: h */
    private int f33326h;

    /* renamed from: i */
    private int f33327i;

    /* renamed from: j */
    private int f33328j;

    /* renamed from: k */
    private int f33329k;

    /* renamed from: l */
    private Drawable f33330l;

    /* renamed from: m */
    private boolean f33331m;

    /* renamed from: n */
    private int f33332n;

    public RFBadge(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFBadge(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFBadge(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33322d = 99;
        this.f33324f = "";
        this.f33332n = 17170445;
        m23442a(context);
    }

    /* renamed from: a */
    private void m23442a(Context context) {
        this.f33326h = getResources().getDimensionPixelOffset(R.dimen.rf_dimen_12);
        this.f33327i = getResources().getDimensionPixelOffset(R.dimen.rf_dimen_3);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f_11_app_24_pad_14);
        this.f33325g = dimensionPixelSize;
        this.f33328j = dimensionPixelSize;
        int color = getResources().getColor(R.color.rf_color_white_100_FFFFFF);
        this.f33329k = color;
        setTextColor(color);
        setGravity(17);
        m23441a();
    }

    /* renamed from: a */
    private void m23441a() {
        setText(this.f33324f);
        if (TextUtils.isEmpty(this.f33324f)) {
            this.f33328j = 0;
            setPadding(0, 0, 0, 0);
            this.f33330l = getResources().getDrawable(R.drawable.rf_shape_bg_badge_circle_default);
        } else if (this.f33324f.length() == 1) {
            this.f33328j = this.f33325g;
            setPadding(0, 0, 0, 0);
            this.f33330l = getResources().getDrawable(R.drawable.rf_shape_bg_badge_circle_with_text);
        } else {
            this.f33328j = this.f33325g;
            int i = this.f33326h;
            int i2 = this.f33327i;
            setPadding(i, i2, i, i2);
            this.f33330l = getResources().getDrawable(R.drawable.rf_shape_bg_badge_round_rect_with_text);
        }
        setTextSize((float) this.f33328j);
        m23443b();
    }

    /* renamed from: b */
    private void m23443b() {
        Drawable drawable = this.f33330l;
        if (drawable != null && (drawable instanceof GradientDrawable)) {
            ((GradientDrawable) drawable).setStroke(RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_3), RFResUtils.getColor(this.f33332n));
            setBackground(this.f33330l);
        }
    }

    public void setMaxBadgeNumber(int i) {
        this.f33322d = i;
    }

    public int getMaxBadgeNumber() {
        return this.f33322d;
    }

    public void setBadgeNumber(int i) {
        this.f33323e = i;
        if (i <= this.f33322d) {
            this.f33324f = String.valueOf(i);
        } else {
            this.f33324f = this.f33322d + "+";
        }
        m23441a();
    }

    public int getBadgeNumber() {
        return this.f33323e;
    }

    public void setBadgeText(String str) {
        if (str.length() > 8) {
            this.f33324f = str.substring(0, 8);
        } else {
            this.f33324f = str;
        }
        m23441a();
    }

    public String getBadgeText() {
        return this.f33324f;
    }

    public void clearContent() {
        this.f33324f = "";
        m23441a();
    }

    public void show() {
        setVisibility(0);
    }

    public void hide() {
        setVisibility(8);
    }

    public void showStock(int i) {
        if (!this.f33331m) {
            this.f33331m = true;
            this.f33332n = i;
            m23443b();
        }
    }

    public void showStock() {
        showStock(R.color.rf_color_white_100_FFFFFF);
    }

    public void hideStock() {
        if (this.f33331m) {
            this.f33331m = false;
            this.f33332n = 17170445;
            m23443b();
        }
    }

    public void setTextColor(int i) {
        super.setTextColor(this.f33329k);
    }

    public void setTextSize(float f) {
        super.setTextSize(0, (float) this.f33328j);
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(0, (float) this.f33328j);
    }

    public void setBackground(Drawable drawable) {
        super.setBackground(this.f33330l);
    }
}
