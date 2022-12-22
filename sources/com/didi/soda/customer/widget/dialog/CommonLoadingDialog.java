package com.didi.soda.customer.widget.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.didi.soda.customer.widget.dialog.SodaWindowFactory;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public final class CommonLoadingDialog extends Dialog {
    public static final String DEFAULT_TAG = "CommonLoadingDialog";

    /* renamed from: a */
    private static final int f41688a = 5000;

    /* renamed from: b */
    private LottieLoadingView f41689b;

    /* renamed from: c */
    private View f41690c;

    /* renamed from: d */
    private boolean f41691d;

    /* renamed from: e */
    private SodaWindowFactory.DialogKeyBackListener f41692e;

    /* renamed from: f */
    private boolean f41693f;

    /* renamed from: g */
    private Runnable f41694g = new Runnable() {
        public void run() {
            if (!CommonLoadingDialog.this.isDestroyed()) {
                CommonLoadingDialog.this.m29449e();
            }
        }
    };

    public TransformAnimation getEnterAnimation() {
        return null;
    }

    public TransformAnimation getExitAnimation() {
        return null;
    }

    private CommonLoadingDialog(boolean z, boolean z2, boolean z3, SodaWindowFactory.DialogKeyBackListener dialogKeyBackListener) {
        setCancelable(z);
        this.f41691d = z2;
        this.f41692e = dialogKeyBackListener;
        this.f41693f = z3;
    }

    public static CommonLoadingDialog getLoadingDialog(boolean z, boolean z2) {
        return getLoadingDialog(z, z2, true, (SodaWindowFactory.DialogKeyBackListener) null);
    }

    public static CommonLoadingDialog getLoadingDialog(boolean z, boolean z2, boolean z3, SodaWindowFactory.DialogKeyBackListener dialogKeyBackListener) {
        return new CommonLoadingDialog(z, z2, z3, dialogKeyBackListener);
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.customer_common_dialog_loading, (ViewGroup) null, false);
        this.f41690c = inflate.findViewById(R.id.loading_box_view);
        this.f41689b = (LottieLoadingView) inflate.findViewById(R.id.loading_dot_view);
        return inflate;
    }

    public boolean onHandleBack() {
        SodaWindowFactory.DialogKeyBackListener dialogKeyBackListener = this.f41692e;
        if (dialogKeyBackListener != null) {
            return dialogKeyBackListener.handleBack();
        }
        return super.onHandleBack();
    }

    public void onDestroy() {
        UiHandlerUtil.removeCallbacks(this.f41694g);
    }

    public void onDismiss() {
        this.f41689b.stop();
        UiHandlerUtil.removeCallbacks(this.f41694g);
    }

    public void onShow() {
        this.f41689b.start();
        if (this.f41691d) {
            this.f41690c.setVisibility(0);
        } else {
            this.f41690c.setVisibility(8);
        }
        if (this.f41693f) {
            UiHandlerUtil.postDelayed(this.f41694g, 5000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m29449e() {
        View view = getView();
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    CommonLoadingDialog.this.dismiss();
                }
            });
        }
    }
}
