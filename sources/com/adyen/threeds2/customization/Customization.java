package com.adyen.threeds2.customization;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import com.adyen.threeds2.exception.InvalidInputException;
import com.adyen.threeds2.util.Preconditions;
import com.didi.soda.blocks.constant.Const;

public class Customization {

    /* renamed from: a */
    private String f963a;

    /* renamed from: b */
    private String f964b;

    /* renamed from: c */
    private int f965c = -1;

    Customization() {
    }

    public static Integer parseHexColorCode(String str) {
        if (str == null || str.isEmpty() || str.charAt(0) != '#') {
            return null;
        }
        try {
            return Integer.valueOf(Color.parseColor(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static Typeface parseTypeface(Context context, String str) {
        Typeface typeface;
        if (str == null) {
            return null;
        }
        try {
            typeface = Typeface.createFromAsset(context.getAssets(), str);
        } catch (Exception unused) {
            typeface = null;
        }
        if (typeface != null) {
            return typeface;
        }
        try {
            typeface = Typeface.createFromFile(str);
        } catch (Exception unused2) {
        }
        if (typeface != null) {
            return typeface;
        }
        try {
            typeface = Typeface.create(str, 0);
        } catch (Exception unused3) {
        }
        if (typeface != null) {
            return typeface;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Integer mo14763a(String str, int i) throws InvalidInputException {
        Preconditions.requireNonNegative(str, i);
        return Integer.valueOf(i);
    }

    public String getTextColor() {
        return this.f963a;
    }

    public String getTextFontName() {
        return this.f964b;
    }

    public int getTextFontSize() {
        return this.f965c;
    }

    public void setTextColor(String str) throws InvalidInputException {
        this.f963a = mo14764a(str);
    }

    public void setTextFontName(String str) throws InvalidInputException {
        this.f964b = mo14765a("fontName", str);
    }

    public void setTextFontSize(int i) throws InvalidInputException {
        this.f965c = mo14763a(Const.BlockParamConst.FONT_SIZE, i).intValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo14765a(String str, String str2) throws InvalidInputException {
        Preconditions.requireNonEmpty(str, str2);
        return str2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo14764a(String str) throws InvalidInputException {
        Preconditions.requireNonNull("hexColorCode", parseHexColorCode(str));
        return str;
    }
}
