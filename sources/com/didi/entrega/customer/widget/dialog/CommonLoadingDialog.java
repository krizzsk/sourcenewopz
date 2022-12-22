package com.didi.entrega.customer.widget.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.entrega.customer.foundation.util.UiHandlerUtil;
import com.didi.entrega.customer.widget.dialog.SodaWindowFactory;
import com.didi.entrega.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public final class CommonLoadingDialog extends Dialog {
    public static final String DEFAULT_TAG = "CommonLoadingDialog";

    /* renamed from: a */
    private static final int f20397a = 5000;

    /* renamed from: b */
    private LottieLoadingView f20398b;

    /* renamed from: c */
    private View f20399c;

    /* renamed from: d */
    private boolean f20400d;

    /* renamed from: e */
    private SodaWindowFactory.DialogKeyBackListener f20401e;

    /* renamed from: f */
    private boolean f20402f;

    /* renamed from: g */
    private Runnable f20403g = new Runnable() {
        public void run() {
            if (!CommonLoadingDialog.this.isDestroyed()) {
                CommonLoadingDialog.this.m14940e();
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
        this.f20400d = z2;
        this.f20401e = dialogKeyBackListener;
        this.f20402f = z3;
    }

    public static CommonLoadingDialog getLoadingDialog(boolean z, boolean z2) {
        return getLoadingDialog(z, z2, true, (SodaWindowFactory.DialogKeyBackListener) null);
    }

    public static CommonLoadingDialog getLoadingDialog(boolean z, boolean z2, boolean z3, SodaWindowFactory.DialogKeyBackListener dialogKeyBackListener) {
        return new CommonLoadingDialog(z, z2, z3, dialogKeyBackListener);
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.entrega_customer_common_dialog_loading, (ViewGroup) null, false);
        this.f20399c = inflate.findViewById(R.id.loading_box_view);
        this.f20398b = (LottieLoadingView) inflate.findViewById(R.id.loading_dot_view);
        return inflate;
    }

    public boolean onHandleBack() {
        SodaWindowFactory.DialogKeyBackListener dialogKeyBackListener = this.f20401e;
        if (dialogKeyBackListener != null) {
            return dialogKeyBackListener.handleBack();
        }
        return super.onHandleBack();
    }

    public void onDestroy() {
        UiHandlerUtil.removeCallbacks(this.f20403g);
    }

    public void onDismiss() {
        this.f20398b.stop();
        UiHandlerUtil.removeCallbacks(this.f20403g);
    }

    public void onShow() {
        this.f20398b.start();
        if (this.f20400d) {
            this.f20399c.setVisibility(0);
        } else {
            this.f20399c.setVisibility(8);
        }
        if (this.f20402f) {
            UiHandlerUtil.postDelayed(this.f20403g, 5000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m14940e() {
        View view = getView();
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    CommonLoadingDialog.this.dismiss();
                }
            });
        }
    }
}
