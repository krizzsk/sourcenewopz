package com.didichuxing.drtl;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.didichuxing.drtl.tookit.DRtlToolkit;

public class RtlAdapter {
    public static int fixGravity(int i) {
        if ((i & 7) == 3) {
            i = (i & -4) | GravityCompat.START;
        }
        return (i & 7) == 5 ? (i & -6) | GravityCompat.END : i;
    }

    private static int fixRule(int i) {
        if (i == 0) {
            return 16;
        }
        if (i == 1) {
            return 17;
        }
        if (i == 5) {
            return 18;
        }
        if (i == 7) {
            return 19;
        }
        if (i == 9) {
            return 20;
        }
        if (i != 11) {
            return i;
        }
        return 21;
    }

    public static void fixPadding(Object obj, int i, int i2, int i3, int i4) {
        if (obj != null && (obj instanceof View)) {
            ((View) obj).setPaddingRelative(i, i2, i3, i4);
        }
    }

    public static void fixPadding(Object obj) {
        if (obj != null && (obj instanceof View)) {
            View view = (View) obj;
            view.setPaddingRelative(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    public static void fixMargins(Object obj, int i, int i2, int i3, int i4) {
        if (obj != null && (obj instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) obj;
            marginLayoutParams.setMarginStart(i);
            marginLayoutParams.setMarginEnd(i3);
        }
    }

    public static void fixMargins(Object obj) {
        if (obj != null && (obj instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) obj;
            marginLayoutParams.setMarginStart(marginLayoutParams.leftMargin);
            marginLayoutParams.setMarginEnd(marginLayoutParams.rightMargin);
        }
    }

    public static void setCompoundDrawables(Object obj, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (obj != null && (obj instanceof TextView)) {
            ((TextView) obj).setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }
    }

    public static void setCompoundDrawables(Object obj) {
        if (obj != null && (obj instanceof TextView)) {
            TextView textView = (TextView) obj;
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            textView.setCompoundDrawablesRelative(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }
    }

    public static void setCompoundDrawablesWithIntrinsicBounds(Object obj, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (obj != null && (obj instanceof TextView)) {
            ((TextView) obj).setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    public static void setCompoundDrawablesWithIntrinsicBounds(Object obj) {
        if (obj != null && (obj instanceof TextView)) {
            TextView textView = (TextView) obj;
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }
    }

    public static void setCompoundDrawablesWithIntrinsicBounds(Object obj, int i, int i2, int i3, int i4) {
        if (obj != null && (obj instanceof TextView)) {
            ((TextView) obj).setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        }
    }

    public static void fixRule(Object obj, int i) {
        if (obj != null && (obj instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) obj).addRule(fixRule(i));
        }
    }

    public static void fixRule(Object obj, int i, int i2) {
        if (obj != null && (obj instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) obj).addRule(fixRule(i), i2);
        }
    }

    public static void fixLeftMargin(Object obj) {
        if (obj != null && (obj instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) obj;
            marginLayoutParams.setMarginStart(marginLayoutParams.leftMargin);
        }
    }

    public static void fixRightMargin(Object obj) {
        if (obj != null && (obj instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) obj;
            marginLayoutParams.setMarginEnd(marginLayoutParams.rightMargin);
        }
    }

    public static TranslateAnimation fixNewTranslateAnimation(float f, float f2, float f3, float f4) {
        if (DRtlToolkit.rtl()) {
            f = -f;
            f2 = -f2;
        }
        return new TranslateAnimation(f, f2, f3, f4);
    }

    public static TranslateAnimation fixNewTranslateAnimation(int i, float f, int i2, float f2, int i3, float f3, int i4, float f4) {
        float f5;
        float f6;
        if (DRtlToolkit.rtl()) {
            f6 = -f;
            f5 = -f2;
        } else {
            f6 = f;
            f5 = f2;
        }
        return new TranslateAnimation(i, f6, i2, f5, i3, f3, i4, f4);
    }
}
