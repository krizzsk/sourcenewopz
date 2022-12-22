package com.didi.soda.customer.widget.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.taxis99.R;

public final class CommonBlockDialog extends Dialog {

    /* renamed from: a */
    private static final int f41686a = 5000;

    /* renamed from: b */
    private Runnable f41687b = new Runnable() {
        public void run() {
            if (!CommonBlockDialog.this.isDestroyed()) {
                CommonBlockDialog.this.dismiss();
            }
        }
    };

    public TransformAnimation getEnterAnimation() {
        return null;
    }

    public TransformAnimation getExitAnimation() {
        return null;
    }

    public void onDestroy() {
    }

    private CommonBlockDialog(boolean z) {
        setCancelable(z);
    }

    public static CommonBlockDialog getBlockDialog() {
        return new CommonBlockDialog(false);
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_common_dialog_block, (ViewGroup) null, false);
    }

    public void onDismiss() {
        UiHandlerUtil.removeCallbacks(this.f41687b);
    }

    public boolean onHandleBack() {
        return super.onHandleBack();
    }

    public void onShow() {
        UiHandlerUtil.postDelayed(this.f41687b, 5000);
    }
}
