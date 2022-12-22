package com.cardinalcommerce.p060a;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewDebug;
import android.widget.TextView;
import com.cardinalcommerce.p060a.setFontFeatureSettings;

/* renamed from: com.cardinalcommerce.a.setLetterSpacing */
public class setLetterSpacing extends TextView {

    /* renamed from: a */
    private static int f2859a = 0;

    /* renamed from: b */
    private static int f2860b = 1;

    public void addTextChangedListener(TextWatcher textWatcher) {
        int i = f2859a;
        int i2 = i & 125;
        int i3 = ((i | 125) & (~i2)) + (i2 << 1);
        f2860b = i3 % 128;
        if (!(i3 % 2 != 0)) {
            int i4 = 52 / 0;
        }
    }

    public void setFocusableInTouchMode(boolean z) {
        int i = f2859a;
        int i2 = ((i & -52) | ((~i) & 51)) + ((i & 51) << 1);
        f2860b = i2 % 128;
        int i3 = i2 % 2;
    }

    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        int i = f2859a;
        int i2 = (i ^ 109) + ((i & 109) << 1);
        f2860b = i2 % 128;
        int i3 = i2 % 2;
    }

    public /* synthetic */ CharSequence getText() {
        int i = f2860b;
        int i2 = i ^ 55;
        boolean z = true;
        int i3 = (((i & 55) | i2) << 1) - i2;
        f2859a = i3 % 128;
        int i4 = i3 % 2;
        Editable a = m2032a();
        int i5 = f2860b + 1;
        f2859a = i5 % 128;
        if (i5 % 2 != 0) {
            z = false;
        }
        if (z) {
            return a;
        }
        Object obj = null;
        super.hashCode();
        return a;
    }

    public setLetterSpacing(Context context) {
        super(context);
    }

    public setLetterSpacing(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setImeOptions(268435456);
        setCursorVisible(true);
        setSingleLine();
        setGravity(17);
    }

    public setLetterSpacing(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    private Editable m2032a() {
        int i = f2860b;
        int i2 = i & 69;
        int i3 = -(-((i ^ 69) | i2));
        int i4 = (i2 & i3) + (i3 | i2);
        f2859a = i4 % 128;
        int i5 = i4 % 2;
        CharSequence text = super.getText();
        if ((text == null ? 25 : '5') != 25) {
            setCursorVisible(true);
            setTextIsSelectable(true);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int i6 = f2860b;
            int i7 = i6 & 109;
            int i8 = (i6 ^ 109) | i7;
            int i9 = ((i7 | i8) << 1) - (i8 ^ i7);
            f2859a = i9 % 128;
            int i10 = i9 % 2;
            int i11 = 0;
            while (true) {
                if (i11 >= text.length()) {
                    int i12 = f2860b + 20;
                    int i13 = ((i12 | -1) << 1) - (i12 ^ -1);
                    f2859a = i13 % 128;
                    int i14 = i13 % 2;
                    return spannableStringBuilder;
                }
                int i15 = f2859a;
                int i16 = ((i15 | 29) << 1) - (i15 ^ 29);
                f2860b = i16 % 128;
                if (!(i16 % 2 != 0)) {
                    spannableStringBuilder.append('y');
                    i11 += 70;
                } else {
                    spannableStringBuilder.append('*');
                    int i17 = (i11 & -2) | ((~i11) & 1);
                    int i18 = -(-((i11 & 1) << 1));
                    i11 = (i17 ^ i18) + ((i18 & i17) << 1);
                }
                int i19 = f2860b;
                int i20 = i19 & 17;
                int i21 = -(-((i19 ^ 17) | i20));
                int i22 = (i20 ^ i21) + ((i21 & i20) << 1);
                f2859a = i22 % 128;
                int i23 = i22 % 2;
            }
        } else {
            int i24 = f2859a;
            int i25 = i24 & 101;
            int i26 = i25 + ((i24 ^ 101) | i25);
            f2860b = i26 % 128;
            Editable editable = null;
            if ((i26 % 2 == 0 ? '=' : 28) != 28) {
                super.hashCode();
            }
            return editable;
        }
    }

    @ViewDebug.ExportedProperty(category = "text")
    public int getSelectionStart() {
        int i = f2859a;
        int i2 = i & 103;
        int i3 = (i ^ 103) | i2;
        int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
        f2860b = i4 % 128;
        int i5 = i4 % 2;
        int length = m2032a().toString().length();
        int i6 = f2859a;
        int i7 = i6 & 67;
        int i8 = i7 + ((i6 ^ 67) | i7);
        f2860b = i8 % 128;
        int i9 = i8 % 2;
        return length;
    }

    @ViewDebug.ExportedProperty(category = "text")
    public int getSelectionEnd() {
        int i = f2860b;
        boolean z = true;
        int i2 = ((i & -16) | ((~i) & 15)) + ((i & 15) << 1);
        f2859a = i2 % 128;
        int i3 = i2 % 2;
        int length = m2032a().toString().length();
        int i4 = f2859a;
        int i5 = i4 & 99;
        int i6 = ((i4 ^ 99) | i5) << 1;
        int i7 = -((i4 | 99) & (~i5));
        int i8 = (i6 & i7) + (i7 | i6);
        f2860b = i8 % 128;
        if (i8 % 2 != 0) {
            z = false;
        }
        if (!z) {
            return length;
        }
        Object[] objArr = null;
        int length2 = objArr.length;
        return length;
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        int i = f2860b;
        int i2 = i & 7;
        int i3 = (i ^ 7) | i2;
        int i4 = (i2 & i3) + (i3 | i2);
        f2859a = i4 % 128;
        boolean z = i4 % 2 == 0;
        super.setText("", bufferType);
        if (!z) {
            int i5 = 17 / 0;
        }
        int i6 = f2860b;
        int i7 = i6 & 71;
        int i8 = ((i6 ^ 71) | i7) << 1;
        int i9 = -((i6 | 71) & (~i7));
        int i10 = (i8 ^ i9) + ((i9 & i8) << 1);
        f2859a = i10 % 128;
        int i11 = i10 % 2;
    }

    public final CharSequence getInstance() {
        int i = f2859a;
        int i2 = i & 37;
        int i3 = -(-((i ^ 37) | i2));
        int i4 = ((i2 | i3) << 1) - (i3 ^ i2);
        f2860b = i4 % 128;
        if (i4 % 2 != 0) {
            return super.getText();
        }
        CharSequence text = super.getText();
        Object obj = null;
        super.hashCode();
        return text;
    }

    public void setCCAText(CharSequence charSequence) {
        int i = f2859a;
        int i2 = (i & -4) | ((~i) & 3);
        int i3 = -(-((i & 3) << 1));
        int i4 = (i2 & i3) + (i3 | i2);
        f2860b = i4 % 128;
        int i5 = i4 % 2;
        super.setText(charSequence, TextView.BufferType.EDITABLE);
        int i6 = (((f2859a + 51) - 1) + 0) - 1;
        f2860b = i6 % 128;
        if ((i6 % 2 == 0 ? 'N' : 30) != 30) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public void setCCAFocusableInTouchMode(boolean z) {
        int i = f2860b;
        int i2 = i & 87;
        int i3 = (i | 87) & (~i2);
        boolean z2 = true;
        int i4 = i2 << 1;
        int i5 = (i3 ^ i4) + ((i3 & i4) << 1);
        f2859a = i5 % 128;
        int i6 = i5 % 2;
        super.setFocusableInTouchMode(z);
        int i7 = f2859a;
        int i8 = i7 ^ 25;
        int i9 = ((((i7 & 25) | i8) << 1) - (~(-i8))) - 1;
        f2860b = i9 % 128;
        if (i9 % 2 == 0) {
            z2 = false;
        }
        if (!z2) {
            Object obj = null;
            super.hashCode();
        }
    }

    public void setCCAOnFocusChangeListener(setFontFeatureSettings.getInstance getinstance) {
        int i = f2859a + 87;
        f2860b = i % 128;
        int i2 = i % 2;
        super.setOnFocusChangeListener(getinstance);
        int i3 = f2859a;
        int i4 = i3 | 123;
        int i5 = i4 << 1;
        int i6 = -((~(i3 & 123)) & i4);
        int i7 = ((i5 | i6) << 1) - (i6 ^ i5);
        f2860b = i7 % 128;
        if ((i7 % 2 == 0 ? 'X' : 28) == 'X') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }
}
