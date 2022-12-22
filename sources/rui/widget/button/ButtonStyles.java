package rui.widget.button;

import android.animation.StateListAnimator;
import android.content.Context;
import android.os.Build;
import android.widget.Button;
import com.taxis99.R;
import rui.util.ViewUtils;

public class ButtonStyles {
    public static final String BUTTON_GHOST_DARK = "BUTTON_GHOST_DARK";
    public static final String BUTTON_GHOST_ORANGE = "BUTTON_GHOST_ORANGE";
    public static final String BUTTON_GHOST_YELLOW = "BUTTON_GHOST_YELLOW";
    public static final String BUTTON_GRADIENT_YELLOW = "BUTTON_GRADIENT_DARK";
    public static final String BUTTON_INTERNAL_DIALOG_BASE = "BUTTON_INTERNAL_DIALOG_BASE";
    public static final String BUTTON_MAIN_DARK = "BUTTON_MAIN_DARK";
    public static final String BUTTON_MAIN_ORANGE = "BUTTON_MAIN_ORANGE";
    public static final String BUTTON_TEXT_GREY = "BUTTON_TEXT_GREY";
    public static final String BUTTON_TEXT_ORANGE = "BUTTON_TEXT_ORANGE";
    public static final String BUTTON_TEXT_YELLOW = "BUTTON_TEXT_YELLOW";

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.widget.Button style(java.lang.String r1, android.widget.Button r2) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -1894487573: goto L_0x0065;
                case -1619875791: goto L_0x005b;
                case -1159855501: goto L_0x0051;
                case 267396312: goto L_0x0047;
                case 446178791: goto L_0x003d;
                case 491281395: goto L_0x0033;
                case 539002835: goto L_0x0028;
                case 737702372: goto L_0x001e;
                case 765893177: goto L_0x0013;
                case 1524141423: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x006f
        L_0x0009:
            java.lang.String r0 = "BUTTON_MAIN_DARK"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x006f
            r1 = 1
            goto L_0x0070
        L_0x0013:
            java.lang.String r0 = "BUTTON_TEXT_YELLOW"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x006f
            r1 = 8
            goto L_0x0070
        L_0x001e:
            java.lang.String r0 = "BUTTON_TEXT_GREY"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x006f
            r1 = 7
            goto L_0x0070
        L_0x0028:
            java.lang.String r0 = "BUTTON_INTERNAL_DIALOG_BASE"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x006f
            r1 = 9
            goto L_0x0070
        L_0x0033:
            java.lang.String r0 = "BUTTON_TEXT_ORANGE"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x006f
            r1 = 6
            goto L_0x0070
        L_0x003d:
            java.lang.String r0 = "BUTTON_MAIN_ORANGE"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x006f
            r1 = 2
            goto L_0x0070
        L_0x0047:
            java.lang.String r0 = "BUTTON_GRADIENT_DARK"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x006f
            r1 = 0
            goto L_0x0070
        L_0x0051:
            java.lang.String r0 = "BUTTON_GHOST_DARK"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x006f
            r1 = 3
            goto L_0x0070
        L_0x005b:
            java.lang.String r0 = "BUTTON_GHOST_YELLOW"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x006f
            r1 = 5
            goto L_0x0070
        L_0x0065:
            java.lang.String r0 = "BUTTON_GHOST_ORANGE"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x006f
            r1 = 4
            goto L_0x0070
        L_0x006f:
            r1 = -1
        L_0x0070:
            switch(r1) {
                case 0: goto L_0x00a1;
                case 1: goto L_0x009c;
                case 2: goto L_0x0097;
                case 3: goto L_0x0092;
                case 4: goto L_0x008d;
                case 5: goto L_0x0088;
                case 6: goto L_0x0083;
                case 7: goto L_0x007e;
                case 8: goto L_0x0079;
                case 9: goto L_0x0074;
                default: goto L_0x0073;
            }
        L_0x0073:
            return r2
        L_0x0074:
            android.widget.Button r1 = buttonDialogBase(r2)
            return r1
        L_0x0079:
            android.widget.Button r1 = buttonTextYellow(r2)
            return r1
        L_0x007e:
            android.widget.Button r1 = buttonTextGrey(r2)
            return r1
        L_0x0083:
            android.widget.Button r1 = buttonTextOrange(r2)
            return r1
        L_0x0088:
            android.widget.Button r1 = buttonGhostYellow(r2)
            return r1
        L_0x008d:
            android.widget.Button r1 = buttonGhostOrange(r2)
            return r1
        L_0x0092:
            android.widget.Button r1 = buttonGhostDark(r2)
            return r1
        L_0x0097:
            android.widget.Button r1 = buttonMainOrange(r2)
            return r1
        L_0x009c:
            android.widget.Button r1 = buttonMainDark(r2)
            return r1
        L_0x00a1:
            android.widget.Button r1 = buttonGradientYellow(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: rui.widget.button.ButtonStyles.style(java.lang.String, android.widget.Button):android.widget.Button");
    }

    public static Button buttonMainDark(Button button) {
        Context context = button.getContext();
        button.setAllCaps(false);
        ViewUtils.setTextSizeSP(button, 16);
        button.setMinHeight((int) ViewUtils.m3859dp(context, 50.0f));
        button.setTextColor(ViewUtils.getColor(context, R.color.rui_color_white));
        button.setBackgroundResource(R.drawable.rui_selector_button_main_dark);
        return button;
    }

    public static Button buttonMainOrange(Button button) {
        Context context = button.getContext();
        button.setAllCaps(false);
        ViewUtils.setTextSizeSP(button, 16);
        button.setMinHeight((int) ViewUtils.m3859dp(context, 50.0f));
        button.setTextColor(ViewUtils.getColor(context, R.color.rui_color_white));
        button.setBackgroundResource(R.drawable.rui_selector_button_main_orange);
        return button;
    }

    public static Button buttonGradientYellow(Button button) {
        Context context = button.getContext();
        button.setAllCaps(false);
        if (Build.VERSION.SDK_INT >= 21) {
            button.setStateListAnimator((StateListAnimator) null);
        }
        ViewUtils.setTextSizeSP(button, 16);
        button.setMinHeight((int) ViewUtils.m3859dp(context, 50.0f));
        ViewUtils.setTextColor(button, R.color.rui_color_000000);
        button.setBackgroundResource(R.drawable.rui_selector_button_gradient_yellow);
        return button;
    }

    public static Button buttonGhostDark(Button button) {
        Context context = button.getContext();
        button.setAllCaps(false);
        if (Build.VERSION.SDK_INT >= 21) {
            button.setStateListAnimator((StateListAnimator) null);
        }
        ViewUtils.setTextSizeSP(button, 16);
        button.setMinHeight((int) ViewUtils.m3859dp(context, 50.0f));
        button.setTextColor(ViewUtils.getColor(context, R.color.rui_color_grey_1));
        button.setBackgroundResource(R.drawable.rui_selector_button_ghost_dark);
        return button;
    }

    public static Button buttonGhostOrange(Button button) {
        Context context = button.getContext();
        button.setAllCaps(false);
        if (Build.VERSION.SDK_INT >= 21) {
            button.setStateListAnimator((StateListAnimator) null);
        }
        ViewUtils.setTextSizeSP(button, 16);
        button.setMinHeight((int) ViewUtils.m3859dp(context, 50.0f));
        button.setTextColor(ViewUtils.getColor(context, R.color.rui_color_brands_orange));
        button.setBackgroundResource(R.drawable.rui_selector_button_ghost_orange);
        return button;
    }

    public static Button buttonGhostYellow(Button button) {
        Context context = button.getContext();
        button.setAllCaps(false);
        if (Build.VERSION.SDK_INT >= 21) {
            button.setStateListAnimator((StateListAnimator) null);
        }
        ViewUtils.setTextSizeSP(button, 16);
        button.setMinHeight((int) ViewUtils.m3859dp(context, 50.0f));
        button.setTextColor(ViewUtils.getColor(context, R.color.rui_color_FFA32F));
        button.setBackgroundResource(R.drawable.rui_selector_button_ghost_yellow);
        return button;
    }

    public static Button buttonDialogBase(Button button) {
        Context context = button.getContext();
        button.setAllCaps(false);
        if (Build.VERSION.SDK_INT >= 21) {
            button.setStateListAnimator((StateListAnimator) null);
        }
        ViewUtils.setTextSizeSP(button, 14);
        button.setMinHeight((int) ViewUtils.m3859dp(context, 50.0f));
        button.setBackgroundResource(R.drawable.rui_selector_button_text);
        return button;
    }

    public static Button buttonTextOrange(Button button) {
        Context context = button.getContext();
        buttonDialogBase(button);
        if (Build.VERSION.SDK_INT >= 21) {
            button.setStateListAnimator((StateListAnimator) null);
        }
        button.setTextColor(ViewUtils.getColor(context, R.color.rui_color_brands_orange));
        return button;
    }

    public static Button buttonTextGrey(Button button) {
        Context context = button.getContext();
        buttonDialogBase(button);
        if (Build.VERSION.SDK_INT >= 21) {
            button.setStateListAnimator((StateListAnimator) null);
        }
        button.setTextColor(ViewUtils.getColor(context, R.color.rui_color_brands_dark));
        return button;
    }

    public static Button buttonTextYellow(Button button) {
        Context context = button.getContext();
        buttonDialogBase(button);
        if (Build.VERSION.SDK_INT >= 21) {
            button.setStateListAnimator((StateListAnimator) null);
        }
        button.setTextColor(ViewUtils.getColor(context, R.color.rui_color_FFA32F));
        return button;
    }
}
