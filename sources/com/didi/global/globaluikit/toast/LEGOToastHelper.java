package com.didi.global.globaluikit.toast;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.global.globaluikit.button.UnitUtils;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class LEGOToastHelper {

    /* renamed from: a */
    private static Toast f22635a;

    /* renamed from: a */
    private static Toast m16306a(Context context, String str, int i, int i2) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        View inflate = LayoutInflater.from(applicationContext).inflate(R.layout.lego_common_toast, (ViewGroup) null);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.toast_layout);
        Toast makeText = Toast.makeText(applicationContext, (CharSequence) null, i2);
        f22635a = makeText;
        makeText.setDuration(i2);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.lego_iv_icon);
        if (i > 0) {
            imageView.setImageResource(i);
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        int dp2px = UnitUtils.dp2px(applicationContext, 214.0f);
        TextView textView = (TextView) inflate.findViewById(R.id.lego_tv_msg);
        textView.setText(str);
        textView.setMaxLines(2);
        textView.setContentDescription(str);
        f22635a.setView(inflate);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(relativeLayout, "translationY", new float[]{50.0f, 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(relativeLayout, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setDuration(500);
        animatorSet.start();
        f22635a.setGravity(17, 0, dp2px);
        return f22635a;
    }

    public static void showToast(Context context, String str, int i, int i2) {
        SystemUtils.showToast(m16306a(context, str, i, i2));
    }

    public static void showShortToast(Context context, String str, int i) {
        showToast(context, str, i, 0);
    }

    public static void showLongToast(Context context, String str, int i) {
        showToast(context, str, i, 1);
    }

    public static void showShortPosToast(Context context, String str) {
        showShortToast(context, str, R.drawable.lego_toast_icon_success);
    }

    public static void showShortNagToast(Context context, String str) {
        showShortToast(context, str, R.drawable.lego_toast_icon_failure);
    }

    public static void showLongPosToast(Context context, String str) {
        showLongToast(context, str, R.drawable.lego_toast_icon_success);
    }

    public static void showLongNagToast(Context context, String str) {
        showLongToast(context, str, R.drawable.lego_toast_icon_failure);
    }

    public static void showToast(Context context, String str) {
        showShortToast(context, str, -1);
    }

    public static void showLongToast(Context context, String str) {
        showLongToast(context, str, 0);
    }
}
