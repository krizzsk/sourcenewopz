package rui.widget.popup.base;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rui.base.BaseViews;
import rui.base.ButtonModel;
import rui.internal.loopview.LoopView;
import rui.style.StyleText;
import rui.util.ViewUtils;

public class PopupViews {
    public static final int DRAWABLE_NONE = Integer.MIN_VALUE;
    public static final String TAG_PROGRESS = "progress";
    public static final String TAG_TITLE = "title";

    /* renamed from: a */
    private static final int f6826a = 20;

    public static TextView createTitle(Context context, CharSequence charSequence) {
        TextView textView = new TextView(context);
        StyleText.titleLarge(textView);
        textView.setText(charSequence);
        textView.setPadding((int) ViewUtils.m3859dp(context, 20.0f), 0, (int) ViewUtils.m3859dp(context, 20.0f), 0);
        textView.setTextColor(ResourcesCompat.getColor(context.getResources(), R.color.rui_color_brands_dark, (Resources.Theme) null));
        return textView;
    }

    public static TextView createSubtitle(Context context, CharSequence charSequence) {
        TextView textView = new TextView(context);
        StyleText.titleNormal(textView);
        textView.setText(charSequence);
        textView.setPadding((int) ViewUtils.m3859dp(context, 20.0f), 0, (int) ViewUtils.m3859dp(context, 20.0f), 0);
        textView.setTextColor(ResourcesCompat.getColor(context.getResources(), R.color.rui_color_grey_2, (Resources.Theme) null));
        return textView;
    }

    public static TextView createUpgradeContent(Context context, CharSequence charSequence) {
        TextView textView = new TextView(context);
        StyleText.titleNormal(textView);
        textView.setText(charSequence);
        textView.setPadding((int) ViewUtils.m3859dp(context, 20.0f), (int) ViewUtils.m3859dp(context, 10.0f), (int) ViewUtils.m3859dp(context, 20.0f), 0);
        textView.setTextColor(ResourcesCompat.getColor(context.getResources(), R.color.rui_color_grey_2, (Resources.Theme) null));
        textView.setLineSpacing((float) ((int) ViewUtils.m3859dp(context, 6.0f)), 1.0f);
        textView.setGravity(3);
        return textView;
    }

    public static FrameLayout createContentContainer(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = (int) ViewUtils.m3859dp(context, 20.0f);
        frameLayout.setLayoutParams(layoutParams);
        return frameLayout;
    }

    public static LinearLayout createButtonContainer(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(80);
        linearLayout.setPadding((int) ViewUtils.m3859dp(context, 20.0f), (int) ViewUtils.m3859dp(context, 20.0f), (int) ViewUtils.m3859dp(context, 20.0f), 0);
        return linearLayout;
    }

    public static void fillButtonContainer(Context context, LinearLayout linearLayout, List<ButtonModel> list) {
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (i != 0) {
                    linearLayout.addView(createButtonSpace(context));
                }
                ButtonModel buttonModel = list.get(i);
                linearLayout.addView(BaseViews.createButton(context, buttonModel.title, buttonModel.style, buttonModel.customColor, buttonModel.onClick));
            }
        }
    }

    public static void fixButtonSameHeight(LinearLayout linearLayout) {
        if (linearLayout != null && linearLayout.getChildCount() >= 1) {
            ArrayList arrayList = new ArrayList();
            linearLayout.requestLayout();
            for (int i = 0; i < linearLayout.getChildCount(); i++) {
                linearLayout.getChildAt(i).requestLayout();
                arrayList.add(Integer.valueOf(linearLayout.getChildAt(i).getHeight()));
            }
            int a = m3864a(arrayList);
            for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
                ViewGroup.LayoutParams layoutParams = linearLayout.getChildAt(i2).getLayoutParams();
                layoutParams.height = -1;
                linearLayout.getChildAt(i2).setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = linearLayout.getLayoutParams();
            layoutParams2.height = a + ((int) ViewUtils.m3859dp(linearLayout.getContext(), 20.0f));
            linearLayout.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: a */
    private static int m3864a(ArrayList<Integer> arrayList) {
        Iterator<Integer> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = Math.max(i, it.next().intValue());
        }
        return i;
    }

    public static View createButtonSpace(Context context) {
        View view = new View(context);
        view.setLayoutParams(new LinearLayout.LayoutParams((int) ViewUtils.m3859dp(context, 16.0f), 1));
        return view;
    }

    public static ScrollView createListContainer(Context context) {
        ScrollView scrollView = new ScrollView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        scrollView.setLayoutParams(layoutParams);
        return scrollView;
    }

    public static LinearLayout createListLayout(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setPadding((int) ViewUtils.m3859dp(context, 20.0f), 0, (int) ViewUtils.m3859dp(context, 20.0f), 0);
        return linearLayout;
    }

    public static View createListItem(Context context, CharSequence charSequence, boolean z) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.rui_popup_list_item, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(R.id.title)).setText(charSequence);
        ((CheckBox) inflate.findViewById(R.id.checkbox)).setChecked(z);
        return inflate;
    }

    public static View createListItemYellow(Context context, CharSequence charSequence, boolean z) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.rui_popup_list_item_yellow, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(R.id.title)).setText(charSequence);
        ((CheckBox) inflate.findViewById(R.id.checkbox)).setChecked(z);
        return inflate;
    }

    public static View createTabTwo(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z) {
        int i = 0;
        View inflate = LayoutInflater.from(context).inflate(R.layout.rui_popup_tab_two, (ViewGroup) null, false);
        ((Button) inflate.findViewById(R.id.tv_left_tab)).setText(charSequence);
        ((Button) inflate.findViewById(R.id.tv_right_tab)).setText(charSequence2);
        View findViewById = inflate.findViewById(R.id.rui_ct_roller_picker_close);
        if (!z) {
            i = 4;
        }
        findViewById.setVisibility(i);
        return inflate;
    }

    public static View createLoopContainer(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setTag("content");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = (int) ViewUtils.m3859dp(context, 35.0f);
        layoutParams.rightMargin = (int) ViewUtils.m3859dp(context, 35.0f);
        frameLayout.addView(linearLayout, layoutParams);
        View createSplit = BaseViews.createSplit(context);
        createSplit.setTag("split1");
        frameLayout.addView(createSplit);
        View createSplit2 = BaseViews.createSplit(context);
        createSplit2.setTag("split2");
        frameLayout.addView(createSplit2);
        return frameLayout;
    }

    public static LoopView createLoopView(Context context) {
        LoopView loopView = new LoopView(context);
        loopView.setTextSize(ViewUtils.m3859dp(context, 20.0f));
        loopView.setCenterTextColor(context.getResources().getColor(R.color.rui_color_grey_1));
        loopView.setOuterTextColor(new int[]{context.getResources().getColor(R.color.rui_color_grey_3), context.getResources().getColor(R.color.rui_color_grey_4)});
        loopView.setNotLoop();
        loopView.setDividerColor(0);
        loopView.setItemsVisibleCount(7);
        return loopView;
    }

    public static FrameLayout createProgressBar(Context context, int i) {
        FrameLayout frameLayout = new FrameLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = (int) ViewUtils.m3859dp(context, 20.0f);
        layoutParams.rightMargin = (int) ViewUtils.m3859dp(context, 20.0f);
        layoutParams.topMargin = (int) ViewUtils.m3859dp(context, 20.0f);
        frameLayout.setLayoutParams(layoutParams);
        ProgressBar progressBar = new ProgressBar(context, (AttributeSet) null, 16973855);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) ViewUtils.m3859dp(context, 50.0f));
        if (i != Integer.MIN_VALUE) {
            progressBar.setProgressDrawable(ViewUtils.getDrawable(context, i));
        }
        progressBar.setTag("progress");
        TextView textView = new TextView(context);
        ViewUtils.setTextSizeSP(textView, 14);
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        textView.setTag("title");
        frameLayout.addView(progressBar, layoutParams2);
        frameLayout.addView(textView, layoutParams3);
        return frameLayout;
    }

    public static LinearLayout createMenuListSection(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundResource(R.drawable.rui_popup_menu_list_section);
        return linearLayout;
    }

    public static TextView createMenuListButton(Context context) {
        TextView textView = new TextView(context);
        textView.setBackgroundResource(R.drawable.rui_popup_menu_list_button);
        ViewUtils.setTextColor(textView, R.color.rui_color_grey_1);
        textView.setGravity(17);
        ViewUtils.setTextSizeSP(textView, 18);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) ViewUtils.m3859dp(context, 56.0f)));
        return textView;
    }

    public static TextView createMenuCancelButton(Context context) {
        TextView textView = new TextView(context);
        textView.setBackgroundResource(R.drawable.rui_popup_menu_list_cancel);
        ViewUtils.setTextColor(textView, R.color.rui_color_grey_1);
        textView.setGravity(17);
        ViewUtils.setTextSizeSP(textView, 18);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) ViewUtils.m3859dp(context, 50.0f));
        layoutParams.topMargin = (int) ViewUtils.m3859dp(context, 10.0f);
        layoutParams.bottomMargin = (int) ViewUtils.m3859dp(context, 10.0f);
        textView.setLayoutParams(layoutParams);
        return textView;
    }
}
