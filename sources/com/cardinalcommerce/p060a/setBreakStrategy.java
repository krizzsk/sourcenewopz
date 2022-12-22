package com.cardinalcommerce.p060a;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taxis99.R;
import org.apache.commons.p071io.IOUtils;

/* renamed from: com.cardinalcommerce.a.setBreakStrategy */
public final class setBreakStrategy extends CompoundButton {

    /* renamed from: a */
    private static int f2706a = 0;

    /* renamed from: b */
    private static int f2707b = 1;

    public final void setButtonDrawable(int i) {
        int i2 = f2706a;
        int i3 = (i2 & -70) | ((~i2) & 69);
        int i4 = -(-((i2 & 69) << 1));
        int i5 = (i3 ^ i4) + ((i4 & i3) << 1);
        f2707b = i5 % 128;
        int i6 = i5 % 2;
    }

    public final void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        int i = f2706a;
        int i2 = i & 7;
        int i3 = i2 + ((i ^ 7) | i2);
        f2707b = i3 % 128;
        if (i3 % 2 == 0) {
            Object obj = null;
            super.hashCode();
        }
    }

    public final void setPadding(int i, int i2, int i3, int i4) {
        int i5 = f2706a;
        int i6 = i5 & 71;
        boolean z = true;
        int i7 = ((i5 ^ 71) | i6) << 1;
        int i8 = -((i5 | 71) & (~i6));
        int i9 = (i7 ^ i8) + ((i8 & i7) << 1);
        f2707b = i9 % 128;
        if (i9 % 2 != 0) {
            z = false;
        }
        if (z) {
            int i10 = 95 / 0;
        }
    }

    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        int i = f2706a;
        int i2 = (i & 123) + (i | 123);
        f2707b = i2 % 128;
        if ((i2 % 2 == 0 ? 'G' : 31) == 'G') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public setBreakStrategy(Context context) {
        super(context);
        setCCAPadding();
        setCCAButtonDrawable(R.drawable.ic_radio_button_unchecked);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(8, 8, 8, 16);
        setLayoutParams(layoutParams);
    }

    public setBreakStrategy(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setCCAPadding();
        setCCAButtonDrawable(R.drawable.ic_radio_button_unchecked);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(8, 8, 8, 16);
        setLayoutParams(layoutParams);
    }

    public setBreakStrategy(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setCCAPadding();
        setCCAButtonDrawable(R.drawable.ic_radio_button_unchecked);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(8, 8, 8, 16);
        setLayoutParams(layoutParams);
    }

    public final CharSequence getText() {
        int i = f2706a;
        int i2 = (i ^ 101) + ((i & 101) << 1);
        f2707b = i2 % 128;
        int i3 = i2 % 2;
        int i4 = f2706a;
        int i5 = i4 & 121;
        int i6 = ((i4 | 121) & (~i5)) + (i5 << 1);
        f2707b = i6 % 128;
        if (!(i6 % 2 == 0)) {
            return "*";
        }
        int i7 = 36 / 0;
        return "*";
    }

    public final void setCCAButtonDrawable(int i) {
        int i2 = f2706a;
        int i3 = i2 & 109;
        int i4 = ((((i2 ^ 109) | i3) << 1) - (~(-((i2 | 109) & (~i3))))) - 1;
        f2707b = i4 % 128;
        char c = i4 % 2 == 0 ? '!' : '7';
        Object[] objArr = null;
        super.setButtonDrawable(i);
        if (c != '7') {
            int length = objArr.length;
        }
        int i5 = f2707b;
        int i6 = ((i5 | 95) << 1) - (i5 ^ 95);
        f2706a = i6 % 128;
        if ((i6 % 2 != 0 ? 11 : IOUtils.DIR_SEPARATOR_WINDOWS) != '\\') {
            int length2 = objArr.length;
        }
    }

    public final void setCCAText(CharSequence charSequence) {
        int i = f2706a + 111;
        f2707b = i % 128;
        int i2 = i % 2;
        super.setText(charSequence, TextView.BufferType.EDITABLE);
        int i3 = f2707b + 40;
        int i4 = (i3 ^ -1) + ((i3 & -1) << 1);
        f2706a = i4 % 128;
        int i5 = i4 % 2;
    }

    public final void setCCAPadding() {
        int i = f2707b;
        int i2 = (i & -126) | ((~i) & 125);
        int i3 = (i & 125) << 1;
        int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
        f2706a = i4 % 128;
        int i5 = i4 % 2;
        super.setPadding(20, 4, 28, 4);
        int i6 = f2706a;
        int i7 = i6 ^ 115;
        int i8 = ((i6 & 115) | i7) << 1;
        int i9 = -i7;
        int i10 = ((i8 | i9) << 1) - (i8 ^ i9);
        f2707b = i10 % 128;
        int i11 = i10 % 2;
    }

    public final void setCCAOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        int i = f2706a;
        int i2 = (((i & -28) | ((~i) & 27)) - (~(-(-((i & 27) << 1))))) - 1;
        f2707b = i2 % 128;
        boolean z = i2 % 2 != 0;
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        if (!z) {
            int i3 = 28 / 0;
        }
    }
}
