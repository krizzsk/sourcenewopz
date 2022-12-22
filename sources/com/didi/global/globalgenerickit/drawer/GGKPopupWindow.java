package com.didi.global.globalgenerickit.drawer;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import com.taxis99.R;

public class GGKPopupWindow extends PopupWindow {

    /* renamed from: a */
    private View f22170a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f22171b;

    public GGKPopupWindow(View view, int i, int i2, View view2, Context context) {
        super(view, i, i2);
        this.f22170a = view2;
        this.f22171b = context;
    }

    public void dismiss() {
        View view = this.f22170a;
        if (view != null) {
            view.startAnimation(AnimationUtils.loadAnimation(this.f22171b, R.anim.ggk_drawer_bottom_out));
            this.f22170a.requestLayout();
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                Activity activity = null;
                try {
                    if (GGKPopupWindow.this.f22171b instanceof Activity) {
                        activity = (Activity) GGKPopupWindow.this.f22171b;
                    }
                    if (activity == null) {
                        return;
                    }
                    if (!activity.isFinishing()) {
                        GGKPopupWindow.super.dismiss();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 250);
    }
}
