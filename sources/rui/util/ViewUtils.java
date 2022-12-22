package rui.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

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
        view.setBackgroundDrawable(view.getResources().getDrawable(i));
    }

    public static void setTextSize(TextView textView, int i) {
        textView.setTextSize(0, textView.getResources().getDimension(i));
    }

    public static void setTextSizeSP(TextView textView, int i) {
        textView.setTextSize(2, (float) i);
    }

    public static void setTextColor(TextView textView, int i) {
        textView.setTextColor(getColor(textView.getContext(), i));
    }

    public static int getColor(Context context, int i) {
        return context.getResources().getColor(i);
    }

    public static float getDimen(Context context, int i) {
        return context.getResources().getDimension(i);
    }

    public static Drawable getDrawable(Context context, int i) {
        return context.getResources().getDrawable(i);
    }

    /* renamed from: dp */
    public static float m3859dp(Context context, float f) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }
}
