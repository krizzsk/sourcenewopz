package com.didi.payment.creditcard.global.widget;

import android.content.Context;
import android.os.Build;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.GravityCompat;
import com.taxis99.R;

public class DecimalEditText extends AppCompatEditText {

    /* renamed from: a */
    private static final int f30618a = 2;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f30619b;

    public DecimalEditText(Context context) {
        this(context, (AttributeSet) null, R.attr.editTextStyle);
    }

    public DecimalEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public DecimalEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f30619b = 2;
        m21521a();
    }

    /* renamed from: a */
    private void m21521a() {
        if (Build.VERSION.SDK_INT >= 17) {
            setTextAlignment(5);
            setGravity(GravityCompat.START);
            setTextDirection(5);
        }
        setFilters(new InputFilter[]{new InputFilter() {
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                String obj = spanned.toString();
                if (DecimalEditText.this.f30619b == 0 && charSequence.equals(".")) {
                    return "";
                }
                if (charSequence.equals(".") && obj.length() == 0) {
                    return "0.";
                }
                if (!obj.contains(".") || i4 - obj.indexOf(".") < DecimalEditText.this.f30619b + 1) {
                    return null;
                }
                return "";
            }
        }});
    }

    public int getDecimalNumber() {
        return this.f30619b;
    }

    public void setDecimalNumber(int i) {
        this.f30619b = i;
    }
}
