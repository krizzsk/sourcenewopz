package com.cardinalcommerce.p060a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

/* renamed from: com.cardinalcommerce.a.setHighlightColor */
public class setHighlightColor extends LinearLayout {

    /* renamed from: a */
    private static int f2798a = 0;

    /* renamed from: b */
    private static int f2799b = 1;
    public int cca_continue = -1;

    public void addView(View view) {
        int i = f2799b;
        int i2 = i | 111;
        int i3 = i2 << 1;
        int i4 = -((~(i & 111)) & i2);
        int i5 = ((i3 | i4) << 1) - (i4 ^ i3);
        f2798a = i5 % 128;
        int i6 = i5 % 2;
    }

    public setHighlightColor(Context context) {
        super(context);
    }

    public setHighlightColor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public setHighlightColor(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void cca_continue(final View view) {
        int i = f2798a;
        int i2 = (i ^ 59) + ((i & 59) << 1);
        f2799b = i2 % 128;
        int i3 = i2 % 2;
        if (view instanceof setBreakStrategy) {
            view.setOnClickListener(new View.OnClickListener() {
                private static int Cardinal = 1;
                private static int configure;

                public final void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    int i = configure;
                    int i2 = (i & 81) + (i | 81);
                    Cardinal = i2 % 128;
                    if (!(i2 % 2 != 0)) {
                        setHighlightColor.m1995a(setHighlightColor.this);
                        setHighlightColor.m1996a(setHighlightColor.this, (setBreakStrategy) view);
                        Object[] objArr = null;
                        int length = objArr.length;
                    } else {
                        setHighlightColor.m1995a(setHighlightColor.this);
                        setHighlightColor.m1996a(setHighlightColor.this, (setBreakStrategy) view);
                    }
                    int i3 = configure;
                    int i4 = i3 & 81;
                    int i5 = (i3 | 81) & (~i4);
                    int i6 = -(-(i4 << 1));
                    int i7 = (i5 & i6) + (i6 | i5);
                    Cardinal = i7 % 128;
                    int i8 = i7 % 2;
                }
            });
            int i4 = f2798a;
            int i5 = i4 & 1;
            int i6 = (i4 ^ 1) | i5;
            int i7 = (i5 ^ i6) + ((i6 & i5) << 1);
            f2799b = i7 % 128;
            int i8 = i7 % 2;
        }
        super.addView(view);
        int i9 = f2799b;
        int i10 = i9 & 73;
        int i11 = (i10 - (~(-(-((i9 ^ 73) | i10))))) - 1;
        f2798a = i11 % 128;
        if ((i11 % 2 != 0 ? ':' : 'X') == ':') {
            Object obj = null;
            super.hashCode();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m1995a(setHighlightColor sethighlightcolor) {
        View view;
        int i = f2799b;
        boolean z = true;
        int i2 = ((i | 124) << 1) - (i ^ 124);
        int i3 = (i2 ^ -1) + ((i2 & -1) << 1);
        f2798a = i3 % 128;
        int i4 = i3 % 2;
        int i5 = f2799b;
        int i6 = (i5 & -116) | ((~i5) & 115);
        int i7 = -(-((i5 & 115) << 1));
        int i8 = (i6 ^ i7) + ((i7 & i6) << 1);
        f2798a = i8 % 128;
        int i9 = i8 % 2;
        int i10 = 0;
        while (true) {
            if (!(i10 >= sethighlightcolor.getChildCount())) {
                int i11 = f2799b;
                int i12 = i11 & 3;
                int i13 = -(-((i11 ^ 3) | i12));
                int i14 = (i12 ^ i13) + ((i13 & i12) << 1);
                f2798a = i14 % 128;
                if (i14 % 2 == 0) {
                    view = sethighlightcolor.getChildAt(i10);
                    if ((view instanceof setBreakStrategy ? ',' : '9') != ',') {
                        i10 = (i10 + 2) - 1;
                        int i15 = f2798a;
                        int i16 = i15 | 109;
                        int i17 = (i16 << 1) - ((~(i15 & 109)) & i16);
                        f2799b = i17 % 128;
                        int i18 = i17 % 2;
                    }
                } else {
                    view = sethighlightcolor.getChildAt(i10);
                    boolean z2 = view instanceof setBreakStrategy;
                    Object obj = null;
                    super.hashCode();
                    if ((z2 ? 'a' : '1') != 'a') {
                        i10 = (i10 + 2) - 1;
                        int i152 = f2798a;
                        int i162 = i152 | 109;
                        int i172 = (i162 << 1) - ((~(i152 & 109)) & i162);
                        f2799b = i172 % 128;
                        int i182 = i172 % 2;
                    }
                }
                int i19 = f2799b;
                int i20 = i19 & 77;
                int i21 = i19 | 77;
                int i22 = ((i20 | i21) << 1) - (i21 ^ i20);
                f2798a = i22 % 128;
                int i23 = i22 % 2;
                ((setBreakStrategy) view).setCCAButtonDrawable(R.drawable.ic_radio_button_unchecked);
                int i24 = f2798a;
                int i25 = ((i24 & 113) - (~(-(-(i24 | 113))))) - 1;
                f2799b = i25 % 128;
                int i26 = i25 % 2;
                i10 = (i10 + 2) - 1;
                int i1522 = f2798a;
                int i1622 = i1522 | 109;
                int i1722 = (i1622 << 1) - ((~(i1522 & 109)) & i1622);
                f2799b = i1722 % 128;
                int i1822 = i1722 % 2;
            } else {
                int i27 = f2798a;
                int i28 = (i27 ^ 119) + ((i27 & 119) << 1);
                f2799b = i28 % 128;
                if (i28 % 2 == 0) {
                    z = false;
                }
                if (!z) {
                    int i29 = 76 / 0;
                    return;
                }
                return;
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m1996a(setHighlightColor sethighlightcolor, setBreakStrategy setbreakstrategy) {
        int i = f2799b + 71;
        f2798a = i % 128;
        int i2 = i % 2;
        setbreakstrategy.setCCAButtonDrawable(R.drawable.ic_check_circle);
        sethighlightcolor.cca_continue = setbreakstrategy.getId();
        int i3 = f2799b;
        int i4 = i3 ^ 41;
        int i5 = (((i3 & 41) | i4) << 1) - i4;
        f2798a = i5 % 128;
        int i6 = i5 % 2;
    }
}
