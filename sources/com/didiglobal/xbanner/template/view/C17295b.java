package com.didiglobal.xbanner.template.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import com.didi.global.xbanner.utils.DisplayUtils;
import com.didiglobal.xbanner.util.CenterAlignImageSpan;
import com.taxis99.R;

/* renamed from: com.didiglobal.xbanner.template.view.b */
/* compiled from: XBTemplateUtil */
class C17295b {

    /* renamed from: a */
    private static final String f51498a = "[a]";

    /* renamed from: b */
    private static final String f51499b = "[D]";

    /* renamed from: a */
    public static boolean m36860a(int i) {
        return (i & 1) == 1;
    }

    /* renamed from: b */
    public static boolean m36862b(int i) {
        return (i & 2) == 2;
    }

    /* renamed from: c */
    public static boolean m36863c(int i) {
        return (i & 4) == 4;
    }

    C17295b() {
    }

    /* renamed from: a */
    public static SpannableString m36858a(Context context, String str, int i, int i2) {
        return m36859a(context, str, i, i2, 1);
    }

    /* renamed from: a */
    public static SpannableString m36859a(Context context, String str, int i, int i2, int i3) {
        if (str == null) {
            return new SpannableString("");
        }
        int i4 = i3 == 1 ? 22 : 44;
        if (str.length() > i4) {
            str = str.substring(0, i4 - 3) + "…" + f51499b;
        }
        if (!m36860a(i2)) {
            i = -1;
        }
        return m36857a(context, str, i);
    }

    /* renamed from: b */
    public static SpannableString m36861b(Context context, String str, int i, int i2) {
        if (!m36862b(i2)) {
            i = -1;
        }
        if (str.length() > 56) {
            str = str.substring(0, 53) + "…" + f51499b;
        }
        return m36857a(context, str, i);
    }

    /* renamed from: a */
    public static SpannableString m36857a(Context context, String str, int i) {
        if (i != -1) {
            Drawable a = m36856a(context, i);
            a.setBounds(0, 0, DisplayUtils.dip2px(context, 10.0f), DisplayUtils.dip2px(context, 10.0f));
            SpannableString spannableString = new SpannableString(str + f51498a);
            spannableString.setSpan(new CenterAlignImageSpan(a, DisplayUtils.dip2px(context, 4.0f)), str.contains(f51499b) ? str.length() - 3 : str.length(), str.length() + 3, 18);
            return spannableString;
        }
        if (str.contains(f51499b)) {
            str = str.replace(f51499b, "");
        }
        return new SpannableString(str);
    }

    /* renamed from: a */
    public static Drawable m36856a(Context context, int i) {
        return context.getResources().getDrawable(i == 1 ? R.mipmap.com_icon_arrow_light : R.mipmap.com_icon_arrow_lightgray);
    }
}
