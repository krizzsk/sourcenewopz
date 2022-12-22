package com.didi.global.globaluikit.datepicker;

import android.graphics.Color;

public class LEGOLinearGradient {

    /* renamed from: a */
    private int f22379a;

    /* renamed from: b */
    private int f22380b;

    /* renamed from: c */
    private int f22381c;

    /* renamed from: d */
    private int f22382d;

    /* renamed from: e */
    private int f22383e;

    /* renamed from: f */
    private int f22384f;

    /* renamed from: g */
    private int f22385g;

    /* renamed from: h */
    private int f22386h;

    public LEGOLinearGradient(int i, int i2) {
        this.f22379a = i;
        this.f22380b = i2;
        m16131a();
    }

    public void setStartColor(int i) {
        this.f22379a = i;
        m16131a();
    }

    public void setEndColor(int i) {
        this.f22380b = i;
        m16131a();
    }

    /* renamed from: a */
    private void m16131a() {
        this.f22381c = Color.red(this.f22379a);
        this.f22382d = Color.blue(this.f22379a);
        this.f22383e = Color.green(this.f22379a);
        this.f22384f = Color.red(this.f22380b);
        this.f22385g = Color.blue(this.f22380b);
        this.f22386h = Color.green(this.f22380b);
    }

    public int getColor(float f) {
        int i = this.f22381c;
        int i2 = (int) (((double) i) + ((double) (((float) (this.f22384f - i)) * f)) + 0.5d);
        int i3 = this.f22383e;
        int i4 = (int) (((double) i3) + ((double) (((float) (this.f22386h - i3)) * f)) + 0.5d);
        int i5 = this.f22382d;
        return Color.rgb(i2, i4, (int) (((double) i5) + ((double) (((float) (this.f22385g - i5)) * f)) + 0.5d));
    }
}
