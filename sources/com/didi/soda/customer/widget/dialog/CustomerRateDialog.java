package com.didi.soda.customer.widget.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.soda.customer.widget.dialog.DialogBuilder;
import com.taxis99.R;
import rui.util.ViewUtils;

public class CustomerRateDialog extends Dialog {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final DialogBuilder.CustomerDialogModel f41753a;

    /* renamed from: b */
    private View f41754b;

    /* renamed from: c */
    private ImageView f41755c;

    /* renamed from: d */
    private Context f41756d;

    /* renamed from: e */
    private TextView f41757e;

    /* renamed from: f */
    private TextView f41758f;

    /* renamed from: g */
    private TextView f41759g;

    /* renamed from: h */
    private TextView f41760h;

    public TransformAnimation getEnterAnimation() {
        return null;
    }

    public TransformAnimation getExitAnimation() {
        return null;
    }

    public void onDestroy() {
    }

    public void onDismiss() {
    }

    public void onShow() {
    }

    public CustomerRateDialog(Context context, DialogBuilder.CustomerDialogModel customerDialogModel) {
        this.f41753a = customerDialogModel;
        this.f41756d = context;
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f41754b = layoutInflater.inflate(R.layout.customer_dialog_rate, viewGroup, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.leftMargin = (int) ViewUtils.m3859dp(this.f41756d, 50.0f);
        layoutParams.rightMargin = (int) ViewUtils.m3859dp(this.f41756d, 50.0f);
        this.f41754b.setLayoutParams(layoutParams);
        m29493e();
        return this.f41754b;
    }

    public void setTitle(CharSequence charSequence) {
        this.f41757e.setText(charSequence);
    }

    public void setContent(CharSequence charSequence) {
        this.f41758f.setText(charSequence);
    }

    /* renamed from: e */
    private void m29493e() {
        this.f41755c = (ImageView) this.f41754b.findViewById(R.id.customer_iv_dialog_icon);
        this.f41757e = (TextView) this.f41754b.findViewById(R.id.customer_tv_dialog_title);
        this.f41758f = (TextView) this.f41754b.findViewById(R.id.customer_tv_dialog_content);
        this.f41759g = (TextView) this.f41754b.findViewById(R.id.customer_tv_common_dialog_sub_action1);
        this.f41760h = (TextView) this.f41754b.findViewById(R.id.customer_tv_common_dialog_sub_action2);
        if (!TextUtils.isEmpty(this.f41753a.title)) {
            setTitle(this.f41753a.title);
        }
        if (!TextUtils.isEmpty(this.f41753a.content)) {
            setContent(this.f41753a.content);
        }
        if (this.f41753a.mSubAction1 != null) {
            this.f41759g.setText(this.f41753a.mSubAction1.mActionName);
        }
        if (this.f41753a.mSubAction2 != null) {
            this.f41760h.setText(this.f41753a.mSubAction2.mActionName);
        }
        this.f41759g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!(CustomerRateDialog.this.f41753a.mSubAction1 == null || CustomerRateDialog.this.f41753a.mSubAction1.mListener == null)) {
                    CustomerRateDialog.this.f41753a.mSubAction1.mListener.onClick(view);
                }
                CustomerRateDialog.this.dismiss();
            }
        });
        this.f41760h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CustomerRateDialog.this.dismiss();
            }
        });
    }
}
