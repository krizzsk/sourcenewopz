package com.cardinalcommerce.p060a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.cardinalcommerce.p060a.setFontFeatureSettings;
import org.osgi.framework.VersionRange;

/* renamed from: com.cardinalcommerce.a.setFallbackLineSpacing */
public class setFallbackLineSpacing extends ImageView {

    /* renamed from: a */
    private static int f2767a = 0;

    /* renamed from: b */
    private static int f2768b = 1;

    public void setImageBitmap(Bitmap bitmap) {
        int i = f2768b;
        int i2 = i & 57;
        boolean z = true;
        int i3 = (((i ^ 57) | i2) << 1) - ((i | 57) & (~i2));
        f2767a = i3 % 128;
        if (i3 % 2 != 0) {
            z = false;
        }
        if (!z) {
            Object obj = null;
            super.hashCode();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        int i = f2768b;
        boolean z = true;
        int i2 = ((i & -8) | ((~i) & 7)) + ((i & 7) << 1);
        f2767a = i2 % 128;
        if (i2 % 2 != 0) {
            z = false;
        }
        if (!z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public void setImageIcon(Icon icon) {
        int i = f2768b;
        int i2 = i & 69;
        int i3 = (i ^ 69) | i2;
        int i4 = (i2 & i3) + (i3 | i2);
        f2767a = i4 % 128;
        int i5 = i4 % 2;
    }

    public void setImageResource(int i) {
        int i2 = f2768b;
        int i3 = i2 & 97;
        int i4 = ((i2 ^ 97) | i3) << 1;
        int i5 = -((i2 | 97) & (~i3));
        int i6 = (i4 ^ i5) + ((i5 & i4) << 1);
        f2767a = i6 % 128;
        int i7 = i6 % 2;
    }

    public void setImageURI(Uri uri) {
        int i = f2767a;
        int i2 = (i ^ 55) + ((i & 55) << 1);
        f2768b = i2 % 128;
        int i3 = i2 % 2;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        int i = (f2767a + 64) - 1;
        f2768b = i % 128;
        int i2 = i % 2;
    }

    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        int i = f2768b;
        int i2 = (i & 109) + (i | 109);
        f2767a = i2 % 128;
        int i3 = i2 % 2;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        int i = f2768b + 88;
        int i2 = ((i | -1) << 1) - (i ^ -1);
        f2767a = i2 % 128;
        int i3 = i2 % 2;
    }

    public setFallbackLineSpacing(Context context) {
        super(context);
    }

    public setFallbackLineSpacing(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public setFallbackLineSpacing(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public Drawable getDrawable() {
        int i = f2768b;
        int i2 = (i & 50) + (i | 50);
        int i3 = (i2 ^ -1) + ((i2 & -1) << 1);
        f2767a = i3 % 128;
        int i4 = i3 % 2;
        int i5 = f2768b;
        int i6 = i5 & 81;
        int i7 = (i6 - (~((i5 ^ 81) | i6))) - 1;
        f2767a = i7 % 128;
        int i8 = i7 % 2;
        return null;
    }

    public void setCCAImageDrawable(Drawable drawable) {
        int i = f2768b;
        int i2 = ((((i | 24) << 1) - (i ^ 24)) + 0) - 1;
        f2767a = i2 % 128;
        char c = i2 % 2 != 0 ? VersionRange.LEFT_OPEN : 'S';
        super.setImageDrawable(drawable);
        if (c == '(') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public void setCCAImageIcon(Icon icon) {
        int i = f2768b;
        int i2 = i & 63;
        int i3 = (i ^ 63) | i2;
        int i4 = (i2 & i3) + (i3 | i2);
        f2767a = i4 % 128;
        int i5 = i4 % 2;
        super.setImageIcon(icon);
        int i6 = f2767a;
        int i7 = (i6 ^ 109) + ((i6 & 109) << 1);
        f2768b = i7 % 128;
        int i8 = i7 % 2;
    }

    public void setCCAImageUri(Uri uri) {
        int i = f2768b;
        int i2 = i & 21;
        int i3 = i2 + ((i ^ 21) | i2);
        f2767a = i3 % 128;
        int i4 = i3 % 2;
        super.setImageURI(uri);
        int i5 = f2768b;
        int i6 = i5 & 3;
        int i7 = (i5 ^ 3) | i6;
        int i8 = (i6 ^ i7) + ((i7 & i6) << 1);
        f2767a = i8 % 128;
        if ((i8 % 2 != 0 ? 'F' : 27) != 27) {
            Object obj = null;
            super.hashCode();
        }
    }

    public void setCCAImageBitmap(Bitmap bitmap) {
        setCCAImageDrawable(new BitmapDrawable(getResources(), bitmap));
        int i = f2767a;
        int i2 = i & 103;
        int i3 = (((i | 103) & (~i2)) - (~(i2 << 1))) - 1;
        f2768b = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public void setCCAImageResource(int i) {
        int i2 = f2767a;
        int i3 = (i2 & 117) + (i2 | 117);
        f2768b = i3 % 128;
        int i4 = i3 % 2;
        super.setImageResource(i);
        int i5 = f2767a;
        int i6 = ((i5 & -50) | ((~i5) & 49)) + ((i5 & 49) << 1);
        f2768b = i6 % 128;
        int i7 = i6 % 2;
    }

    public void setCCAOnClickListener(setFontFeatureSettings.C2048init init) {
        int i = f2768b;
        int i2 = (i & 69) + (i | 69);
        f2767a = i2 % 128;
        int i3 = i2 % 2;
        super.setOnClickListener(init);
        int i4 = f2767a;
        int i5 = i4 ^ 43;
        boolean z = true;
        int i6 = -(-((i4 & 43) << 1));
        int i7 = (i5 ^ i6) + ((i6 & i5) << 1);
        f2768b = i7 % 128;
        if (i7 % 2 == 0) {
            z = false;
        }
        if (!z) {
            int i8 = 90 / 0;
        }
    }

    public void setCCAOnFocusChangeListener(setFontFeatureSettings.getInstance getinstance) {
        int i = f2768b + 25;
        f2767a = i % 128;
        int i2 = i % 2;
        super.setOnFocusChangeListener(getinstance);
        int i3 = f2768b;
        int i4 = i3 & 9;
        int i5 = (i4 - (~(-(-((i3 ^ 9) | i4))))) - 1;
        f2767a = i5 % 128;
        if (!(i5 % 2 == 0)) {
            int i6 = 31 / 0;
        }
    }

    public void setCCAOnTouchListener(setFontFeatureSettings.C2047configure configure) {
        int i = (f2767a + 40) - 1;
        f2768b = i % 128;
        char c = i % 2 == 0 ? 21 : 'K';
        super.setOnTouchListener(configure);
        if (c != 'K') {
            int i2 = 0 / 0;
        }
    }
}
