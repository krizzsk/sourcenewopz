package com.cardinalcommerce.p060a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.cardinalcommerce.p060a.setFontFeatureSettings;

/* renamed from: com.cardinalcommerce.a.setElegantTextHeight */
public final class setElegantTextHeight extends CompoundButton {

    /* renamed from: a */
    private static int f2762a = 0;

    /* renamed from: b */
    private static int f2763b = 1;
    public int init = 0;

    /* renamed from: com.cardinalcommerce.a.setElegantTextHeight$configure */
    interface C2045configure extends CompoundButton.OnCheckedChangeListener {
    }

    public final void setButtonDrawable(int i) {
        int i2 = f2763b;
        int i3 = (i2 & 38) + (i2 | 38);
        int i4 = (i3 & -1) + (i3 | -1);
        f2762a = i4 % 128;
        if (i4 % 2 != 0) {
            int i5 = 5 / 0;
        }
    }

    public final void setElevation(float f) {
        int i = f2762a;
        int i2 = i & 31;
        int i3 = i2 + ((i ^ 31) | i2);
        f2763b = i3 % 128;
        if ((i3 % 2 == 0 ? '!' : 14) != 14) {
            Object obj = null;
            super.hashCode();
        }
    }

    public final void setId(int i) {
        int i2 = f2763b + 2;
        int i3 = (i2 ^ -1) + ((i2 & -1) << 1);
        f2762a = i3 % 128;
        int i4 = i3 % 2;
    }

    public final void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        int i = (f2763b + 59) - 1;
        int i2 = (i & -1) + (i | -1);
        f2762a = i2 % 128;
        if (i2 % 2 != 0) {
            int i3 = 12 / 0;
        }
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        int i = f2763b;
        int i2 = (i ^ 88) + ((i & 88) << 1);
        int i3 = ((i2 | -1) << 1) - (i2 ^ -1);
        f2762a = i3 % 128;
        int i4 = i3 % 2;
    }

    public final void setPadding(int i, int i2, int i3, int i4) {
        int i5 = f2763b + 103;
        f2762a = i5 % 128;
        if (i5 % 2 != 0) {
            Object obj = null;
            super.hashCode();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m1983a(setElegantTextHeight seteleganttextheight) {
        int i = f2763b;
        int i2 = ((i & 2) + (i | 2)) - 1;
        f2762a = i2 % 128;
        char c = i2 % 2 != 0 ? 9 : 'D';
        seteleganttextheight.getInstance();
        if (c == 9) {
            int i3 = 68 / 0;
        }
    }

    public setElegantTextHeight(Context context) {
        super(context);
        getInstance();
        setCCAOnCheckedChangeListener(new C2045configure() {
            private static int Cardinal = 0;
            private static int getInstance = 1;

            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
                if (r3.cca_continue.init != 1) goto L_0x0034;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
                r3.cca_continue.init = 0;
                r4 = getInstance;
                r5 = (r4 & 23) + (r4 | 23);
                Cardinal = r5 % 128;
                r5 = r5 % 2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
                if (r4 != 1) goto L_0x0034;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onCheckedChanged(android.widget.CompoundButton r4, boolean r5) {
                /*
                    r3 = this;
                    com.didi.autotracker.AutoTrackHelper.trackViewOnClick((android.widget.CompoundButton) r4, (boolean) r5)
                    int r4 = Cardinal
                    r5 = r4 & 59
                    int r0 = ~r5
                    r4 = r4 | 59
                    r4 = r4 & r0
                    r0 = 1
                    int r5 = r5 << r0
                    int r5 = -r5
                    int r5 = -r5
                    int r5 = ~r5
                    int r4 = r4 - r5
                    int r4 = r4 - r0
                    int r5 = r4 % 128
                    getInstance = r5
                    int r4 = r4 % 2
                    r5 = 33
                    if (r4 != 0) goto L_0x001f
                    r4 = 65
                    goto L_0x0021
                L_0x001f:
                    r4 = 33
                L_0x0021:
                    r1 = 0
                    if (r4 == r5) goto L_0x002e
                    com.cardinalcommerce.a.setElegantTextHeight r4 = com.cardinalcommerce.p060a.setElegantTextHeight.this
                    int r4 = r4.init
                    int r5 = r1.length     // Catch:{ all -> 0x002c }
                    if (r4 == r0) goto L_0x004d
                    goto L_0x0034
                L_0x002c:
                    r4 = move-exception
                    throw r4
                L_0x002e:
                    com.cardinalcommerce.a.setElegantTextHeight r4 = com.cardinalcommerce.p060a.setElegantTextHeight.this
                    int r4 = r4.init
                    if (r4 == r0) goto L_0x004d
                L_0x0034:
                    com.cardinalcommerce.a.setElegantTextHeight r4 = com.cardinalcommerce.p060a.setElegantTextHeight.this
                    r4.init = r0
                    int r4 = getInstance
                    r5 = r4 & 19
                    r4 = r4 ^ 19
                    r4 = r4 | r5
                    int r4 = -r4
                    int r4 = -r4
                    r2 = r5 ^ r4
                    r4 = r4 & r5
                    int r4 = r4 << r0
                    int r2 = r2 + r4
                    int r4 = r2 % 128
                    Cardinal = r4
                    int r2 = r2 % 2
                    goto L_0x005f
                L_0x004d:
                    com.cardinalcommerce.a.setElegantTextHeight r4 = com.cardinalcommerce.p060a.setElegantTextHeight.this
                    r5 = 0
                    r4.init = r5
                    int r4 = getInstance
                    r5 = r4 & 23
                    r4 = r4 | 23
                    int r5 = r5 + r4
                    int r4 = r5 % 128
                    Cardinal = r4
                    int r5 = r5 % 2
                L_0x005f:
                    com.cardinalcommerce.a.setElegantTextHeight r4 = com.cardinalcommerce.p060a.setElegantTextHeight.this
                    com.cardinalcommerce.p060a.setElegantTextHeight.m1983a(r4)
                    int r4 = getInstance
                    r5 = r4 & 31
                    r4 = r4 ^ 31
                    r4 = r4 | r5
                    int r4 = -r4
                    int r4 = -r4
                    r2 = r5 ^ r4
                    r4 = r4 & r5
                    int r4 = r4 << r0
                    int r2 = r2 + r4
                    int r4 = r2 % 128
                    Cardinal = r4
                    int r2 = r2 % 2
                    r4 = 8
                    if (r2 == 0) goto L_0x007f
                    r5 = 8
                    goto L_0x0081
                L_0x007f:
                    r5 = 16
                L_0x0081:
                    if (r5 == r4) goto L_0x0084
                    return
                L_0x0084:
                    int r4 = r1.length     // Catch:{ all -> 0x0086 }
                    return
                L_0x0086:
                    r4 = move-exception
                    throw r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setElegantTextHeight.C20441.onCheckedChanged(android.widget.CompoundButton, boolean):void");
            }
        });
    }

    public setElegantTextHeight(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        getInstance();
        setCCAOnCheckedChangeListener(new C2045configure() {
            private static int Cardinal = 0;
            private static int getInstance = 1;

            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onCheckedChanged(android.widget.CompoundButton r4, boolean r5) {
                /*
                    r3 = this;
                    com.didi.autotracker.AutoTrackHelper.trackViewOnClick((android.widget.CompoundButton) r4, (boolean) r5)
                    int r4 = Cardinal
                    r5 = r4 & 59
                    int r0 = ~r5
                    r4 = r4 | 59
                    r4 = r4 & r0
                    r0 = 1
                    int r5 = r5 << r0
                    int r5 = -r5
                    int r5 = -r5
                    int r5 = ~r5
                    int r4 = r4 - r5
                    int r4 = r4 - r0
                    int r5 = r4 % 128
                    getInstance = r5
                    int r4 = r4 % 2
                    r5 = 33
                    if (r4 != 0) goto L_0x001f
                    r4 = 65
                    goto L_0x0021
                L_0x001f:
                    r4 = 33
                L_0x0021:
                    r1 = 0
                    if (r4 == r5) goto L_0x002e
                    com.cardinalcommerce.a.setElegantTextHeight r4 = com.cardinalcommerce.p060a.setElegantTextHeight.this
                    int r4 = r4.init
                    int r5 = r1.length     // Catch:{ all -> 0x002c }
                    if (r4 == r0) goto L_0x004d
                    goto L_0x0034
                L_0x002c:
                    r4 = move-exception
                    throw r4
                L_0x002e:
                    com.cardinalcommerce.a.setElegantTextHeight r4 = com.cardinalcommerce.p060a.setElegantTextHeight.this
                    int r4 = r4.init
                    if (r4 == r0) goto L_0x004d
                L_0x0034:
                    com.cardinalcommerce.a.setElegantTextHeight r4 = com.cardinalcommerce.p060a.setElegantTextHeight.this
                    r4.init = r0
                    int r4 = getInstance
                    r5 = r4 & 19
                    r4 = r4 ^ 19
                    r4 = r4 | r5
                    int r4 = -r4
                    int r4 = -r4
                    r2 = r5 ^ r4
                    r4 = r4 & r5
                    int r4 = r4 << r0
                    int r2 = r2 + r4
                    int r4 = r2 % 128
                    Cardinal = r4
                    int r2 = r2 % 2
                    goto L_0x005f
                L_0x004d:
                    com.cardinalcommerce.a.setElegantTextHeight r4 = com.cardinalcommerce.p060a.setElegantTextHeight.this
                    r5 = 0
                    r4.init = r5
                    int r4 = getInstance
                    r5 = r4 & 23
                    r4 = r4 | 23
                    int r5 = r5 + r4
                    int r4 = r5 % 128
                    Cardinal = r4
                    int r5 = r5 % 2
                L_0x005f:
                    com.cardinalcommerce.a.setElegantTextHeight r4 = com.cardinalcommerce.p060a.setElegantTextHeight.this
                    com.cardinalcommerce.p060a.setElegantTextHeight.m1983a(r4)
                    int r4 = getInstance
                    r5 = r4 & 31
                    r4 = r4 ^ 31
                    r4 = r4 | r5
                    int r4 = -r4
                    int r4 = -r4
                    r2 = r5 ^ r4
                    r4 = r4 & r5
                    int r4 = r4 << r0
                    int r2 = r2 + r4
                    int r4 = r2 % 128
                    Cardinal = r4
                    int r2 = r2 % 2
                    r4 = 8
                    if (r2 == 0) goto L_0x007f
                    r5 = 8
                    goto L_0x0081
                L_0x007f:
                    r5 = 16
                L_0x0081:
                    if (r5 == r4) goto L_0x0084
                    return
                L_0x0084:
                    int r4 = r1.length     // Catch:{ all -> 0x0086 }
                    return
                L_0x0086:
                    r4 = move-exception
                    throw r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setElegantTextHeight.C20441.onCheckedChanged(android.widget.CompoundButton, boolean):void");
            }
        });
    }

    public setElegantTextHeight(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        getInstance();
        setCCAOnCheckedChangeListener(new C2045configure() {
            private static int Cardinal = 0;
            private static int getInstance = 1;

            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onCheckedChanged(android.widget.CompoundButton r4, boolean r5) {
                /*
                    r3 = this;
                    com.didi.autotracker.AutoTrackHelper.trackViewOnClick((android.widget.CompoundButton) r4, (boolean) r5)
                    int r4 = Cardinal
                    r5 = r4 & 59
                    int r0 = ~r5
                    r4 = r4 | 59
                    r4 = r4 & r0
                    r0 = 1
                    int r5 = r5 << r0
                    int r5 = -r5
                    int r5 = -r5
                    int r5 = ~r5
                    int r4 = r4 - r5
                    int r4 = r4 - r0
                    int r5 = r4 % 128
                    getInstance = r5
                    int r4 = r4 % 2
                    r5 = 33
                    if (r4 != 0) goto L_0x001f
                    r4 = 65
                    goto L_0x0021
                L_0x001f:
                    r4 = 33
                L_0x0021:
                    r1 = 0
                    if (r4 == r5) goto L_0x002e
                    com.cardinalcommerce.a.setElegantTextHeight r4 = com.cardinalcommerce.p060a.setElegantTextHeight.this
                    int r4 = r4.init
                    int r5 = r1.length     // Catch:{ all -> 0x002c }
                    if (r4 == r0) goto L_0x004d
                    goto L_0x0034
                L_0x002c:
                    r4 = move-exception
                    throw r4
                L_0x002e:
                    com.cardinalcommerce.a.setElegantTextHeight r4 = com.cardinalcommerce.p060a.setElegantTextHeight.this
                    int r4 = r4.init
                    if (r4 == r0) goto L_0x004d
                L_0x0034:
                    com.cardinalcommerce.a.setElegantTextHeight r4 = com.cardinalcommerce.p060a.setElegantTextHeight.this
                    r4.init = r0
                    int r4 = getInstance
                    r5 = r4 & 19
                    r4 = r4 ^ 19
                    r4 = r4 | r5
                    int r4 = -r4
                    int r4 = -r4
                    r2 = r5 ^ r4
                    r4 = r4 & r5
                    int r4 = r4 << r0
                    int r2 = r2 + r4
                    int r4 = r2 % 128
                    Cardinal = r4
                    int r2 = r2 % 2
                    goto L_0x005f
                L_0x004d:
                    com.cardinalcommerce.a.setElegantTextHeight r4 = com.cardinalcommerce.p060a.setElegantTextHeight.this
                    r5 = 0
                    r4.init = r5
                    int r4 = getInstance
                    r5 = r4 & 23
                    r4 = r4 | 23
                    int r5 = r5 + r4
                    int r4 = r5 % 128
                    Cardinal = r4
                    int r5 = r5 % 2
                L_0x005f:
                    com.cardinalcommerce.a.setElegantTextHeight r4 = com.cardinalcommerce.p060a.setElegantTextHeight.this
                    com.cardinalcommerce.p060a.setElegantTextHeight.m1983a(r4)
                    int r4 = getInstance
                    r5 = r4 & 31
                    r4 = r4 ^ 31
                    r4 = r4 | r5
                    int r4 = -r4
                    int r4 = -r4
                    r2 = r5 ^ r4
                    r4 = r4 & r5
                    int r4 = r4 << r0
                    int r2 = r2 + r4
                    int r4 = r2 % 128
                    Cardinal = r4
                    int r2 = r2 % 2
                    r4 = 8
                    if (r2 == 0) goto L_0x007f
                    r5 = 8
                    goto L_0x0081
                L_0x007f:
                    r5 = 16
                L_0x0081:
                    if (r5 == r4) goto L_0x0084
                    return
                L_0x0084:
                    int r4 = r1.length     // Catch:{ all -> 0x0086 }
                    return
                L_0x0086:
                    r4 = move-exception
                    throw r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setElegantTextHeight.C20441.onCheckedChanged(android.widget.CompoundButton, boolean):void");
            }
        });
    }

    public final void setCheckState(int i) {
        int i2 = f2763b;
        boolean z = true;
        int i3 = ((i2 | 14) << 1) - (i2 ^ 14);
        int i4 = (i3 & -1) + (i3 | -1);
        f2762a = i4 % 128;
        if (i4 % 2 != 0) {
            this.init = i;
            getInstance();
            Object obj = null;
            super.hashCode();
        } else {
            this.init = i;
            getInstance();
        }
        int i5 = f2762a;
        int i6 = i5 & 55;
        int i7 = -(-((i5 ^ 55) | i6));
        int i8 = ((i6 | i7) << 1) - (i7 ^ i6);
        f2763b = i8 % 128;
        if (i8 % 2 != 0) {
            z = false;
        }
        if (z) {
            int i9 = 3 / 0;
        }
    }

    public final int getId() {
        int i = f2763b;
        int i2 = ((i | 97) << 1) - (i ^ 97);
        f2762a = i2 % 128;
        int i3 = i2 % 2;
        int i4 = f2763b;
        int i5 = i4 & 91;
        int i6 = (i4 | 91) & (~i5);
        int i7 = i5 << 1;
        int i8 = ((i6 | i7) << 1) - (i6 ^ i7);
        f2762a = i8 % 128;
        int i9 = i8 % 2;
        return 0;
    }

    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        int i = f2762a;
        int i2 = i & 109;
        int i3 = (i ^ 109) | i2;
        int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
        f2763b = i4 % 128;
        char c = i4 % 2 == 0 ? 25 : '+';
        super.setText("", bufferType);
        if (c == 25) {
            Object obj = null;
            super.hashCode();
        }
        int i5 = f2763b;
        int i6 = (((i5 | 62) << 1) - (i5 ^ 62)) - 1;
        f2762a = i6 % 128;
        int i7 = i6 % 2;
    }

    public final CharSequence getText() {
        int i = f2763b;
        int i2 = ((i ^ 62) + ((i & 62) << 1)) - 1;
        f2762a = i2 % 128;
        int i3 = i2 % 2;
        int i4 = f2763b;
        int i5 = i4 & 83;
        int i6 = ((((i4 ^ 83) | i5) << 1) - (~(-((i4 | 83) & (~i5))))) - 1;
        f2762a = i6 % 128;
        int i7 = i6 % 2;
        return "*";
    }

    public final boolean isChecked() {
        int i = f2762a;
        int i2 = ((i & -24) | ((~i) & 23)) + ((i & 23) << 1);
        f2763b = i2 % 128;
        int i3 = i2 % 2;
        int i4 = f2763b;
        int i5 = i4 & 119;
        int i6 = -(-((i4 ^ 119) | i5));
        int i7 = (i5 ^ i6) + ((i6 & i5) << 1);
        f2762a = i7 % 128;
        int i8 = i7 % 2;
        return false;
    }

    public final void setCCAElevation(float f) {
        int i = f2762a;
        int i2 = i & 113;
        int i3 = (((i | 113) & (~i2)) - (~(i2 << 1))) - 1;
        f2763b = i3 % 128;
        boolean z = i3 % 2 != 0;
        super.setElevation(f);
        if (!z) {
            int i4 = 77 / 0;
        }
    }

    public final int init() {
        int i;
        int i2 = f2763b + 85;
        f2762a = i2 % 128;
        boolean z = false;
        Object[] objArr = null;
        if (i2 % 2 == 0) {
            i = super.getId();
        } else {
            i = super.getId();
            int length = objArr.length;
        }
        int i3 = f2762a;
        int i4 = ((((i3 | 22) << 1) - (i3 ^ 22)) - 0) - 1;
        f2763b = i4 % 128;
        if (i4 % 2 != 0) {
            z = true;
        }
        if (z) {
            return i;
        }
        int length2 = objArr.length;
        return i;
    }

    public final void setCCAText(CharSequence charSequence) {
        int i = f2763b;
        int i2 = ((i | 51) << 1) - (i ^ 51);
        f2762a = i2 % 128;
        if ((i2 % 2 != 0 ? 25 : 'D') != 'D') {
            super.setText(charSequence, TextView.BufferType.EDITABLE);
            Object obj = null;
            super.hashCode();
            return;
        }
        super.setText(charSequence, TextView.BufferType.EDITABLE);
    }

    public final void setCCAId(int i) {
        int i2 = f2762a;
        int i3 = i2 & 5;
        int i4 = (i2 ^ 5) | i3;
        int i5 = (i3 ^ i4) + ((i4 & i3) << 1);
        f2763b = i5 % 128;
        int i6 = i5 % 2;
        super.setId(i);
        int i7 = f2762a;
        int i8 = (i7 & -38) | ((~i7) & 37);
        int i9 = (i7 & 37) << 1;
        int i10 = (i8 & i9) + (i9 | i8);
        f2763b = i10 % 128;
        if ((i10 % 2 == 0 ? ';' : 15) != 15) {
            int i11 = 22 / 0;
        }
    }

    public final void setCCAOnCheckedChangeListener(C2045configure configure) {
        int i = f2763b;
        int i2 = i & 95;
        int i3 = (i ^ 95) | i2;
        int i4 = i2 ^ i3;
        int i5 = i3 & i2;
        boolean z = true;
        int i6 = i4 + (i5 << 1);
        f2762a = i6 % 128;
        if (i6 % 2 != 0) {
            z = false;
        }
        super.setOnCheckedChangeListener(configure);
        if (!z) {
            Object obj = null;
            super.hashCode();
        }
    }

    public final void setCCAButtonDrawable(int i) {
        int i2 = f2763b;
        int i3 = i2 & 15;
        int i4 = ((i2 ^ 15) | i3) << 1;
        int i5 = -((i2 | 15) & (~i3));
        int i6 = (i4 & i5) + (i5 | i4);
        f2762a = i6 % 128;
        boolean z = i6 % 2 != 0;
        super.setButtonDrawable(i);
        if (z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public final void setCCAOnClickListener(setFontFeatureSettings.C2048init init2) {
        int i = f2762a;
        int i2 = i & 43;
        int i3 = (i | 43) & (~i2);
        int i4 = i2 << 1;
        int i5 = (i3 ^ i4) + ((i3 & i4) << 1);
        f2763b = i5 % 128;
        int i6 = i5 % 2;
        super.setOnClickListener(init2);
        int i7 = f2763b;
        int i8 = ((i7 & 80) + (i7 | 80)) - 1;
        f2762a = i8 % 128;
        if (!(i8 % 2 == 0)) {
            int i9 = 49 / 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        if (r1 != 1) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        r1 = com.taxis99.R.drawable.ic_checked_box;
        r4 = f2762a;
        r5 = (r4 ^ 40) + ((r4 & 40) << 1);
        r4 = (r5 ^ -1) + ((r5 & -1) << 1);
        f2763b = r4 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0019, code lost:
        if (r7.init != 1) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void getInstance() {
        /*
            r7 = this;
            int r0 = f2763b
            r1 = r0 & 75
            r0 = r0 | 75
            int r1 = r1 + r0
            int r0 = r1 % 128
            f2762a = r0
            int r1 = r1 % 2
            r0 = 0
            r2 = 1
            if (r1 == 0) goto L_0x0013
            r1 = 0
            goto L_0x0014
        L_0x0013:
            r1 = 1
        L_0x0014:
            r3 = 3
            if (r1 == 0) goto L_0x001c
            int r1 = r7.init
            if (r1 == r2) goto L_0x0039
            goto L_0x0022
        L_0x001c:
            int r1 = r7.init
            r4 = 0
            int r4 = r4.length     // Catch:{ all -> 0x008c }
            if (r1 == r2) goto L_0x0039
        L_0x0022:
            r1 = 2131233735(0x7f080bc7, float:1.8083616E38)
            int r4 = f2763b
            r5 = r4 & 3
            int r6 = ~r5
            r4 = r4 | r3
            r4 = r4 & r6
            int r5 = r5 << r2
            int r5 = -r5
            int r5 = -r5
            int r5 = ~r5
            int r4 = r4 - r5
            int r4 = r4 - r2
            int r5 = r4 % 128
            f2762a = r5
        L_0x0036:
            int r4 = r4 % 2
            goto L_0x004f
        L_0x0039:
            r1 = 2131233658(0x7f080b7a, float:1.808346E38)
            int r4 = f2762a
            r5 = r4 ^ 40
            r4 = r4 & 40
            int r4 = r4 << r2
            int r5 = r5 + r4
            r4 = r5 ^ -1
            r5 = r5 & -1
            int r5 = r5 << r2
            int r4 = r4 + r5
            int r5 = r4 % 128
            f2763b = r5
            goto L_0x0036
        L_0x004f:
            r4 = 20
            r5 = 28
            r6 = 4
            super.setPadding(r4, r6, r5, r6)
            r7.setCCAButtonDrawable(r1)
            android.widget.LinearLayout$LayoutParams r1 = new android.widget.LinearLayout$LayoutParams
            r4 = -2
            r1.<init>(r4, r4)
            r4 = 16
            r5 = 8
            r1.setMargins(r5, r5, r5, r4)
            r7.setLayoutParams(r1)
            int r1 = f2762a
            r4 = r1 | 4
            int r2 = r4 << 1
            r1 = r1 ^ r6
            int r2 = r2 - r1
            r1 = r2 & -1
            r2 = r2 | -1
            int r1 = r1 + r2
            int r2 = r1 % 128
            f2763b = r2
            int r1 = r1 % 2
            if (r1 != 0) goto L_0x0082
            r1 = 18
            goto L_0x0083
        L_0x0082:
            r1 = 3
        L_0x0083:
            if (r1 == r3) goto L_0x008b
            r1 = 45
            int r1 = r1 / r0
            return
        L_0x0089:
            r0 = move-exception
            throw r0
        L_0x008b:
            return
        L_0x008c:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setElegantTextHeight.getInstance():void");
    }
}
