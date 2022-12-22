package com.didichuxing.security.cardverify.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import com.taxis99.R;

public class DecimalEditText extends AppCompatEditText {

    /* renamed from: a */
    private static final int f48947a = 2;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f48948b;

    public DecimalEditText(Context context) {
        this(context, (AttributeSet) null, R.attr.editTextStyle);
    }

    public DecimalEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public DecimalEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f48948b = 2;
        m35162a();
    }

    /* renamed from: a */
    private void m35162a() {
        setFilters(new InputFilter[]{new InputFilter() {
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (DecimalEditText.this.f48948b == 0 && charSequence.equals(".")) {
                    return "";
                }
                String obj = spanned.toString();
                if (TextUtils.isEmpty(obj)) {
                    if (charSequence.equals(".") || charSequence.equals("0")) {
                        return "0.";
                    }
                    return null;
                } else if (!obj.contains(".") || !charSequence.equals(".")) {
                    return null;
                } else {
                    return "";
                }
            }
        }});
    }

    public int getDecimalNumber() {
        return this.f48948b;
    }

    public void setDecimalNumber(int i) {
        this.f48948b = i;
    }
}
