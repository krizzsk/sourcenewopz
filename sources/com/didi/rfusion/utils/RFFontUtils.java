package com.didi.rfusion.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import com.didi.rfusion.RFusion;
import com.didi.rfusion.config.RFFontDelegate;
import com.didi.rfusion.config.RFLocale;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class RFFontUtils {
    public static final int BOLD = 2;
    public static final int LIGHT = 3;
    public static final int MEDIUM = 1;
    public static final int REGULAR = 0;

    /* renamed from: a */
    private static final String f33304a = "fonts/rf_icon.ttf";

    @Retention(RetentionPolicy.SOURCE)
    public @interface RFFontType {
    }

    private RFFontUtils() {
        throw new UnsupportedOperationException("can't instantiate this class");
    }

    public static void setTypeFace(TextView textView, int i) {
        if (textView != null) {
            RFFontDelegate fontDelegate = RFusion.getFontDelegate();
            if (fontDelegate != null) {
                fontDelegate.setTypeface(textView, i);
                return;
            }
            Typeface fontTypeFace = getFontTypeFace(textView.getContext(), i);
            if (fontTypeFace != null) {
                textView.setTypeface(fontTypeFace);
            }
        }
    }

    public static Typeface getIconTypeface(Context context) {
        return m23424a(context, f33304a);
    }

    public static Typeface getFontTypeFace(Context context, int i) {
        return m23423a(context, i, RFLocale.getLanguage());
    }

    /* renamed from: a */
    private static Typeface m23423a(Context context, int i, String str) {
        boolean z = "es".equals(str) || "pt".equals(str) || "en".equals(str);
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (z) {
                        return RFResUtils.getFont(context, R.font.didi_sans_pro_regular);
                    }
                    return Typeface.create(Typeface.DEFAULT, 0);
                } else if (z) {
                    return RFResUtils.getFont(context, R.font.didi_sans_pro_light);
                } else {
                    return Typeface.create(Typeface.DEFAULT, 0);
                }
            } else if (z) {
                return RFResUtils.getFont(context, R.font.didi_sans_pro_bold);
            } else {
                return Typeface.create(Typeface.DEFAULT, 1);
            }
        } else if (z) {
            return RFResUtils.getFont(context, R.font.didi_sans_pro_medium);
        } else {
            return Typeface.create(Typeface.DEFAULT, 0);
        }
    }

    /* renamed from: a */
    private static Typeface m23424a(Context context, String str) {
        try {
            return Typeface.createFromAsset(context.getAssets(), str);
        } catch (Exception unused) {
            return null;
        }
    }
}
