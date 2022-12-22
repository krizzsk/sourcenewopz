package com.didi.payment.base.widget;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.widget.EditText;
import com.didi.payment.base.widget.CommonEditText;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ThausandStyleEditAdapter extends CommonEditText.EditStyleAdapter {

    /* renamed from: c */
    private static String f30139c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static String f30140d;

    /* renamed from: a */
    private int f30141a = 13;

    /* renamed from: b */
    private int f30142b = 2;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f30143e = 2;

    public ThausandStyleEditAdapter() {
    }

    public ThausandStyleEditAdapter(int i, int i2) {
        if (i > 0) {
            this.f30141a = i;
        }
        if (i2 >= 0) {
            this.f30142b = i2;
        }
    }

    public void init() {
        DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) DecimalFormat.getInstance(new Locale("pt", "BR"))).getDecimalFormatSymbols();
        f30139c = Character.toString(decimalFormatSymbols.getGroupingSeparator());
        f30140d = Character.toString(decimalFormatSymbols.getDecimalSeparator());
    }

    public int getDecimalNumber() {
        return this.f30143e;
    }

    public void setDecimalNumber(int i) {
        this.f30143e = i;
    }

    public String trimStringToNormalDecimalFormat(String str) {
        String replaceAll = str.replaceAll("\\" + f30139c, "");
        return replaceAll.replaceAll("\\" + f30140d, "\\.");
    }

    public TextWatcher getWatcher() {
        return new CommonEditText.NumberTextWatcherForThousand(this.mEdittext, f30140d, f30139c);
    }

    /* access modifiers changed from: protected */
    public void bindEditText(EditText editText) {
        super.bindEditText(editText);
        this.mEdittext.setFilters(new InputFilter[]{new InputFilter() {
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                String obj = spanned.toString();
                if (ThausandStyleEditAdapter.this.f30143e == 0 && charSequence.equals(ThausandStyleEditAdapter.f30140d)) {
                    return "";
                }
                if (charSequence.equals(ThausandStyleEditAdapter.f30140d) && obj.length() == 0) {
                    return "0" + ThausandStyleEditAdapter.f30140d;
                } else if (!obj.contains(ThausandStyleEditAdapter.f30140d) || i4 - obj.indexOf(ThausandStyleEditAdapter.f30140d) < ThausandStyleEditAdapter.this.f30143e + 1) {
                    return null;
                } else {
                    return "";
                }
            }
        }, new InputFilter.LengthFilter(this.f30141a)});
    }
}
