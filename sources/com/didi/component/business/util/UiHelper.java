package com.didi.component.business.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.view.dialog.AlertController;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.taxis99.R;

public class UiHelper {

    /* renamed from: a */
    private static final View.OnTouchListener f11397a = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };

    public static void show(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public static void hide(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public static void invisible(View view) {
        if (view != null) {
            view.setVisibility(4);
        }
    }

    public static void show(final View view, int i) {
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                UiHelper.show(View.this);
            }
        }, (long) i);
    }

    public static void shieldTouchEvent(View view) {
        if (view != null) {
            view.setOnTouchListener(f11397a);
        }
    }

    public static void showTip(Context context, String str) {
        ToastHelper.showShortInfo(context, str);
    }

    public static void showInvalidDataDialog(FragmentActivity fragmentActivity, String str) {
        if (TextUtil.isEmpty(str)) {
            str = fragmentActivity.getString(R.string.car_request_failed);
        }
        AlertDialogFragment.Builder alertDialogBuilder = getAlertDialogBuilder(fragmentActivity);
        alertDialogBuilder.setIcon(AlertController.IconType.INFO);
        alertDialogBuilder.setCloseVisible(true);
        alertDialogBuilder.setCancelable(true);
        alertDialogBuilder.setPositiveButtonDefault();
        alertDialogBuilder.setMessage(str);
        alertDialogBuilder.setNegativeButton((CharSequence) ResourcesHelper.getString(fragmentActivity, R.string.car_me_known), (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
            }
        });
        if (fragmentActivity != null && fragmentActivity.getSupportFragmentManager() != null) {
            alertDialogBuilder.create().show(fragmentActivity.getSupportFragmentManager(), UiHelper.class.getSimpleName());
        }
    }

    public static AlertDialogFragment.Builder getAlertDialogBuilder(Context context) {
        return new AlertDialogFragment.Builder(context);
    }

    public static Drawable createGradientDrawable(Context context, int i, int i2, int i3, int i4) {
        int dip2px = UiUtils.dip2px(context, 4.0f);
        PaintDrawable paintDrawable = new PaintDrawable(-1118482);
        float f = (float) dip2px;
        paintDrawable.setCornerRadius(f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.BL_TR);
        gradientDrawable.setColors(new int[]{i3, i4});
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius(f);
        gradientDrawable2.setGradientType(0);
        gradientDrawable2.setOrientation(GradientDrawable.Orientation.BL_TR);
        gradientDrawable2.setColors(new int[]{i, i2});
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842910}, paintDrawable);
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable);
        stateListDrawable.addState(new int[0], gradientDrawable2);
        return stateListDrawable;
    }
}
