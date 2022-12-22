package com.didi.component.mapflow.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import java.util.ArrayList;
import java.util.List;

public class TextBuilder {

    /* renamed from: a */
    private List<SubString> f14501a = new ArrayList();

    /* renamed from: b */
    private Context f14502b;

    /* renamed from: c */
    private Resources f14503c;

    public TextBuilder(Context context) {
        this.f14502b = context;
        this.f14503c = context.getResources();
    }

    public TextBuilder addText(String str, int i, int i2) {
        return addText(str, i, i2, false);
    }

    public TextBuilder addText(String str, int i, int i2, boolean z) {
        return m10306a(str, this.f14503c.getDimensionPixelSize(i), this.f14503c.getColor(i2), z);
    }

    public TextBuilder addTextWithColor(String str, int i, int i2) {
        return m10306a(str, this.f14503c.getDimensionPixelSize(i), i2, false);
    }

    public TextBuilder addTextWithColor(String str, int i, int i2, boolean z) {
        return m10306a(str, this.f14503c.getDimensionPixelSize(i), i2, z);
    }

    public TextBuilder addText(int i, int i2, int i3) {
        return addText(this.f14502b.getString(i), i2, i3);
    }

    public TextBuilder addText(SubString subString) {
        if (subString != null) {
            this.f14501a.add(subString);
            return this;
        }
        throw new RuntimeException("subString cannot be null.");
    }

    /* renamed from: a */
    private TextBuilder m10305a(CharSequence charSequence, int i, int i2) {
        this.f14501a.add(new SubString(charSequence, i, i2));
        return this;
    }

    /* renamed from: a */
    private TextBuilder m10306a(CharSequence charSequence, int i, int i2, boolean z) {
        this.f14501a.add(new SubString(charSequence, i, i2, z));
        return this;
    }

    public SpannableString build() {
        StringBuilder sb = new StringBuilder();
        for (SubString next : this.f14501a) {
            if (!TextUtils.isEmpty(next.subText)) {
                sb.append(next.subText);
            }
        }
        int i = 0;
        SpannableString spannableString = new SpannableString(sb.toString());
        for (SubString next2 : this.f14501a) {
            if (!TextUtils.isEmpty(next2.subText)) {
                int length = next2.subText.length() + i;
                spannableString.setSpan(new ForegroundColorSpan(next2.subTextColor), i, length, 34);
                spannableString.setSpan(new AbsoluteSizeSpan(next2.subTextSize), i, length, 34);
                if (next2.isBold) {
                    spannableString.setSpan(new StyleSpan(1), i, length, 34);
                }
                i = length;
            }
        }
        return spannableString;
    }

    public void clear() {
        this.f14501a.clear();
    }

    public static final class SubString {
        public boolean isBold;
        public CharSequence subText;
        public int subTextColor;
        public int subTextSize;

        public SubString(CharSequence charSequence, int i, int i2) {
            this.subText = charSequence;
            this.subTextSize = i;
            this.subTextColor = i2;
            this.isBold = true;
        }

        public SubString(CharSequence charSequence, int i, int i2, boolean z) {
            this.subText = charSequence;
            this.subTextSize = i;
            this.subTextColor = i2;
            this.isBold = z;
        }
    }
}
