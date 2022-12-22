package com.didi.global.globaluikit.drawer;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import com.taxis99.R;

public class LEGOPopupWindow extends PopupWindow {

    /* renamed from: a */
    private View f22573a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f22574b;

    /* renamed from: c */
    private boolean f22575c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public LEGODrawerDismissListener f22576d;

    public LEGOPopupWindow(View view, int i, int i2, View view2, Context context, boolean z, LEGODrawerDismissListener lEGODrawerDismissListener) {
        super(view, i, i2);
        this.f22573a = view2;
        this.f22574b = context;
        this.f22575c = z;
        this.f22576d = lEGODrawerDismissListener;
    }

    public void dismiss() {
        if (this.f22575c) {
            dismissBySelf();
        }
    }

    public void dismissBySelf() {
        View view = this.f22573a;
        if (view != null) {
            view.startAnimation(AnimationUtils.loadAnimation(this.f22574b, R.anim.lego_drawer_bottom_out));
            this.f22573a.requestLayout();
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                Activity activity = null;
                try {
                    if (LEGOPopupWindow.this.f22574b instanceof Activity) {
                        activity = (Activity) LEGOPopupWindow.this.f22574b;
                    }
                    if (activity == null) {
                        return;
                    }
                    if (!activity.isFinishing()) {
                        LEGOPopupWindow.super.dismiss();
                        if (LEGOPopupWindow.this.f22576d != null) {
                            LEGOPopupWindow.this.f22576d.onDismiss();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 250);
    }

    public void setDismissListener(LEGODrawerDismissListener lEGODrawerDismissListener) {
        this.f22576d = lEGODrawerDismissListener;
    }
}
