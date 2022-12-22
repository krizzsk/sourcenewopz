package com.didi.payment.commonsdk.p129ui.helper;

import android.text.InputFilter;
import android.text.Spanned;
import com.didi.sdk.util.TextUtil;
import java.text.DecimalFormat;
import java.util.Locale;

/* renamed from: com.didi.payment.commonsdk.ui.helper.NFloatInputHelper */
public class NFloatInputHelper {
    public static String DECIMAL_SEPARATOR_enUS = ".";
    public static String DECIMAL_SEPARATOR_ptBR = ",";
    public String decimalSeperatorBySys = ",";

    public NFloatInputHelper() {
        m21133a();
    }

    /* renamed from: a */
    private void m21133a() {
        this.decimalSeperatorBySys = Character.toString(((DecimalFormat) DecimalFormat.getInstance(Locale.getDefault())).getDecimalFormatSymbols().getDecimalSeparator());
        DECIMAL_SEPARATOR_enUS = Character.toString(((DecimalFormat) DecimalFormat.getInstance(Locale.US)).getDecimalFormatSymbols().getDecimalSeparator());
        DECIMAL_SEPARATOR_ptBR = Character.toString(((DecimalFormat) DecimalFormat.getInstance(new Locale("pt", "BR"))).getDecimalFormatSymbols().getDecimalSeparator());
    }

    public float parseFloatValue(String str) {
        if (TextUtil.isEmpty(str)) {
            return 0.0f;
        }
        if (str.lastIndexOf(this.decimalSeperatorBySys) == str.length() - 1) {
            str = str.substring(0, str.length() - 1);
        }
        return m21132a(str, this.decimalSeperatorBySys);
    }

    public boolean validFloatValue(String str) {
        if (!TextUtil.isEmpty(str) && !TextUtil.isEmpty(this.decimalSeperatorBySys)) {
            try {
                if (str.lastIndexOf(this.decimalSeperatorBySys) == str.length() - 1) {
                    str = str.substring(0, str.length() - 1);
                }
                if (str.indexOf(this.decimalSeperatorBySys) > 0) {
                    str = str.replace(this.decimalSeperatorBySys, ".");
                }
                Float.parseFloat(str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* renamed from: a */
    private float m21132a(String str, String str2) {
        if (str != null && !TextUtil.isEmpty(str2)) {
            if (str.indexOf(str2) > 0) {
                str = str.replace(str2, ".");
            }
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
            }
        }
        return 0.0f;
    }

    /* renamed from: com.didi.payment.commonsdk.ui.helper.NFloatInputHelper$NumberDecimalInputFilter */
    public static class NumberDecimalInputFilter implements InputFilter {
        int DECIMAL_NUMBER_LENGTH_2 = 2;
        String decimalSeperator = NFloatInputHelper.DECIMAL_SEPARATOR_enUS;

        public NumberDecimalInputFilter(int i, String str) {
            this.DECIMAL_NUMBER_LENGTH_2 = i;
            this.decimalSeperator = str;
        }

        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            String str;
            if (charSequence == null) {
                return null;
            }
            boolean z = false;
            for (int i5 = 0; i5 < charSequence.length(); i5++) {
                if (!"01233456789,.".contains(String.valueOf(charSequence.charAt(i5)))) {
                    return "";
                }
            }
            if (NFloatInputHelper.DECIMAL_SEPARATOR_ptBR.contentEquals(charSequence) || NFloatInputHelper.DECIMAL_SEPARATOR_enUS.contentEquals(charSequence)) {
                z = true;
            }
            if (spanned != null) {
                str = spanned.toString();
            } else {
                str = "";
            }
            if (this.DECIMAL_NUMBER_LENGTH_2 == 0 && z) {
                return "";
            }
            if (!z || str.length() != 0) {
                int indexOf = str.indexOf(this.decimalSeperator);
                if (z) {
                    if (indexOf >= 0) {
                        return "";
                    }
                    return this.decimalSeperator;
                } else if ("0".contentEquals(charSequence) && "0".equals(str)) {
                    return "";
                } else {
                    if (!str.contains(this.decimalSeperator) || i4 - str.indexOf(this.decimalSeperator) < this.DECIMAL_NUMBER_LENGTH_2 + 1) {
                        return null;
                    }
                    return "";
                }
            } else {
                return "0" + this.decimalSeperator;
            }
        }
    }
}
