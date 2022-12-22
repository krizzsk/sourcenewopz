package rui.widget.dialog.base;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taxis99.R;
import java.util.List;
import rui.base.BaseViews;
import rui.base.ButtonModel;
import rui.style.StyleText;
import rui.util.ViewUtils;

public class DialogViews {
    public static TextView createTitle(Context context, CharSequence charSequence) {
        TextView textView = new TextView(context);
        StyleText.titleStyle(textView, R.dimen.rui_text_normal, false);
        ViewUtils.setTextColor(textView, R.color.rui_color_grey_1);
        textView.setText(charSequence);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.leftMargin = (int) ViewUtils.m3859dp(context, 16.0f);
        layoutParams.rightMargin = (int) ViewUtils.m3859dp(context, 16.0f);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    public static TextView createContent(Context context, CharSequence charSequence) {
        TextView textView = new TextView(context);
        StyleText.titleStyle(textView, R.dimen.rui_text_secondary, false);
        ViewUtils.setTextColor(textView, R.color.rui_color_grey_2);
        textView.setText(charSequence);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.leftMargin = (int) ViewUtils.m3859dp(context, 16.0f);
        layoutParams.rightMargin = (int) ViewUtils.m3859dp(context, 16.0f);
        layoutParams.topMargin = (int) ViewUtils.m3859dp(context, 16.0f);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    public static FrameLayout createButtonContainer(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) ViewUtils.m3859dp(context, 50.0f)));
        View createSplit = BaseViews.createSplit(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(createSplit.getLayoutParams());
        layoutParams.gravity = 48;
        createSplit.setLayoutParams(layoutParams);
        frameLayout.addView(createSplit);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setTag("container");
        frameLayout.addView(linearLayout);
        return frameLayout;
    }

    public static void fillButtonContainer(Context context, LinearLayout linearLayout, List<ButtonModel> list) {
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (i != 0) {
                    linearLayout.addView(BaseViews.createSplitVertical(context));
                }
                ButtonModel buttonModel = list.get(i);
                linearLayout.addView(BaseViews.createButton(context, buttonModel.title, buttonModel.style, buttonModel.customColor, buttonModel.onClick));
            }
        }
    }
}
