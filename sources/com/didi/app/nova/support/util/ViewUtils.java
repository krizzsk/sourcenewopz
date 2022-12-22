package com.didi.app.nova.support.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;

public class ViewUtils {
    public static void gone(View view) {
        view.setVisibility(8);
    }

    public static void invisible(View view) {
        view.setVisibility(4);
    }

    public static void visible(View view) {
        view.setVisibility(0);
    }

    public static boolean isVisible(View view) {
        return view.getVisibility() == 0;
    }

    public static boolean isInVisible(View view) {
        return view.getVisibility() == 4;
    }

    public static boolean isGone(View view) {
        return view.getVisibility() == 8;
    }

    public static void setBackgroundColor(View view, int i) {
        view.setBackgroundColor(getColor(view.getContext(), i));
    }

    public static void setBackground(View view, int i) {
        view.setBackground(ResourcesCompat.getDrawable(view.getResources(), i, (Resources.Theme) null));
    }

    public static void setTextSize(TextView textView, int i) {
        textView.setTextSize(0, textView.getResources().getDimension(i));
    }

    public static void setTextColor(TextView textView, int i) {
        textView.setTextColor(getColor(textView.getContext(), i));
    }

    public static int getColor(Context context, int i) {
        return ResourcesCompat.getColor(context.getResources(), i, (Resources.Theme) null);
    }

    public static float getDimen(Context context, int i) {
        return context.getResources().getDimension(i);
    }

    public static Drawable getDrawable(Context context, int i) {
        return ResourcesCompat.getDrawable(context.getResources(), i, (Resources.Theme) null);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams() {
            super(0, 0);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams setHeightMatchParent() {
            this.height = -1;
            return this;
        }

        public LayoutParams setHeightWrapContent() {
            this.height = -2;
            return this;
        }

        public LayoutParams setHeight(int i) {
            this.height = i;
            return this;
        }

        public LayoutParams setWidthMatchParent() {
            this.width = -1;
            return this;
        }

        public LayoutParams setWidthWrapContent() {
            this.width = -2;
            return this;
        }

        public LayoutParams setWidth(int i) {
            this.width = i;
            return this;
        }

        public LayoutParams setMarginLeft(int i) {
            this.leftMargin = i;
            return this;
        }

        public LayoutParams setMarginLeftDimen(Context context, int i) {
            this.leftMargin = (int) ViewUtils.getDimen(context, i);
            return this;
        }

        public LayoutParams setMarginTop(int i) {
            this.topMargin = i;
            return this;
        }

        public LayoutParams setMarginTopDimen(Context context, int i) {
            this.topMargin = (int) ViewUtils.getDimen(context, i);
            return this;
        }

        public LayoutParams setMarginRight(int i) {
            this.rightMargin = i;
            return this;
        }

        public LayoutParams setMarginRightDimen(Context context, int i) {
            this.rightMargin = (int) ViewUtils.getDimen(context, i);
            return this;
        }

        public LayoutParams setMarginBottom(int i) {
            this.bottomMargin = this.bottomMargin;
            return this;
        }

        public LayoutParams setMarginBottomDimen(Context context, int i) {
            this.bottomMargin = (int) ViewUtils.getDimen(context, i);
            return this;
        }
    }
}
