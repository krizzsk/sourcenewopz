package rui.base;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import rui.util.ViewUtils;
import rui.widget.button.ButtonStyles;

public class BaseViews {
    public static final int NO_COLOR = Integer.MIN_VALUE;

    public static Button createButton(Context context, CharSequence charSequence, String str, int i, View.OnClickListener onClickListener) {
        Button button = new Button(context);
        ButtonStyles.style(str, button);
        if (i != Integer.MIN_VALUE) {
            button.setTextColor(i);
        }
        button.setText(charSequence);
        button.setOnClickListener(onClickListener);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        button.setLayoutParams(layoutParams);
        return button;
    }

    public static View createSplit(Context context) {
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#E5E5E5"));
        view.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, (int) ViewUtils.m3859dp(context, 0.5f)));
        return view;
    }

    public static View createSplitVertical(Context context) {
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#E5E5E5"));
        view.setLayoutParams(new ViewGroup.MarginLayoutParams((int) ViewUtils.m3859dp(context, 0.5f), -1));
        return view;
    }
}
