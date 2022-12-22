package com.didi.beatles.p099im.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.utils.IMViewUtil */
public class IMViewUtil {
    private IMViewUtil() {
    }

    public static void setBackgroundCompat(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static int getWindowWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getWindowHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int dp2px(Context context, float f) {
        return (int) Math.round((((double) (f * context.getResources().getDisplayMetrics().density)) * (((double) context.getResources().getInteger(R.integer.im_dpi_multiple)) / 10.0d)) + 0.5d);
    }

    public static int getDefaultKeyBoardHeight() {
        return IMContextInfoHelper.isPad() ? 166 : 260;
    }

    public static void hide(View view) {
        if (view != null && view.getVisibility() != 8) {
            view.setVisibility(8);
        }
    }

    public static void hide(View... viewArr) {
        for (int i = 0; i < viewArr.length; i++) {
            if (viewArr[i] != null) {
                viewArr[i].setVisibility(8);
            }
        }
    }

    public static void show(View view) {
        if (view != null && view.getVisibility() != 0) {
            view.setVisibility(0);
        }
    }

    public static void show(View... viewArr) {
        for (int i = 0; i < viewArr.length; i++) {
            if (viewArr[i] != null) {
                viewArr[i].setVisibility(0);
            }
        }
    }

    public static void changeMarginParam(View view, int i, int i2, int i3, int i4) {
        if (view != null && view.getLayoutParams() != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (i != -1) {
                marginLayoutParams.leftMargin = i;
            }
            if (i3 != -1) {
                marginLayoutParams.rightMargin = i3;
            }
            if (i2 != -1) {
                marginLayoutParams.topMargin = i2;
            }
            if (i4 != -1) {
                marginLayoutParams.bottomMargin = i4;
            }
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public static int getSmartBarHeight(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("mz_action_button_min_height").get(cls.newInstance()).toString()));
        } catch (Exception unused) {
            return 0;
        }
    }

    public static void showWindowAboveAnchor(PopupWindow popupWindow, View view, int i, int i2) {
        showWindowAboveAnchor(popupWindow, view, 0, i, i2, 0);
    }

    public static void showWindowAboveAnchor(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        showWindowAboveAnchor(popupWindow, view, i, i2, i3, 0);
    }

    public static void showWindowAboveAnchor(PopupWindow popupWindow, View view, int i, int i2, int i3, int i4) {
        View contentView = popupWindow.getContentView();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        contentView.measure(i > 0 ? View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE) : makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = contentView.getMeasuredHeight();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        popupWindow.showAtLocation(view, i4, i2, (iArr[1] - measuredHeight) - i3);
    }

    public static void measureView(View view) {
        int i;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i2 = layoutParams.height;
        if (i2 > 0) {
            i = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        } else {
            i = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, i);
    }

    public static void changeColor(TextView textView, int i, int i2, int i3, int i4) {
        SpannableString spannableString = new SpannableString(textView.getText());
        if (spannableString.length() >= i3) {
            spannableString.setSpan(new ForegroundColorSpan(i), i2, i3, 33);
            textView.setText(spannableString);
        }
    }

    public static void changeColor(TextView textView, int i, int[] iArr, int[] iArr2, int i2) {
        SpannableString spannableString = new SpannableString(textView.getText());
        int i3 = 0;
        while (i3 < iArr.length) {
            if (spannableString.length() >= iArr2[i3]) {
                spannableString.setSpan(new ForegroundColorSpan(i), iArr[i3], iArr2[i3], 33);
                i3++;
            } else {
                return;
            }
        }
        textView.setText(spannableString);
    }
}
