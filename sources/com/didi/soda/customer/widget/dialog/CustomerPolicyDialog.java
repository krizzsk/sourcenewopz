package com.didi.soda.customer.widget.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.dialog.CustomerCommonDialog;
import com.didi.soda.customer.widget.dialog.DialogBuilder;
import com.taxis99.R;

public class CustomerPolicyDialog extends Dialog {

    /* renamed from: a */
    private View f41744a;

    /* renamed from: b */
    private TextView f41745b;

    /* renamed from: c */
    private FrameLayout f41746c;

    /* renamed from: d */
    private TextView f41747d;

    /* renamed from: e */
    private TextView f41748e;

    /* renamed from: f */
    private View f41749f;

    /* renamed from: g */
    private Context f41750g;

    /* renamed from: h */
    private DialogBuilder.CustomerDialogModel f41751h;

    /* renamed from: i */
    private View.OnClickListener f41752i = new View.OnClickListener() {
        public void onClick(View view) {
            CustomerPolicyDialog.this.dismiss();
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

    public void onDismiss() {
    }

    public void onShow() {
    }

    public CustomerPolicyDialog(Context context, DialogBuilder.CustomerDialogModel customerDialogModel) {
        this.f41751h = customerDialogModel;
        this.f41750g = context;
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f41744a = layoutInflater.inflate(R.layout.customer_dialog_policy, viewGroup, false);
        m29490e();
        return this.f41744a;
    }

    public CustomerPolicyDialog setContent(View view) {
        this.f41746c.addView(view);
        return this;
    }

    public CustomerPolicyDialog setTitle(CharSequence charSequence) {
        this.f41745b.setText(charSequence);
        return this;
    }

    /* renamed from: e */
    private void m29490e() {
        this.f41745b = (TextView) this.f41744a.findViewById(R.id.customer_tv_common_dialog_title);
        this.f41746c = (FrameLayout) this.f41744a.findViewById(R.id.customer_fl_common_dialog_content);
        this.f41747d = (TextView) this.f41744a.findViewById(R.id.customer_tv_common_dialog_sub_action1);
        this.f41748e = (TextView) this.f41744a.findViewById(R.id.customer_tv_common_dialog_main_action);
        this.f41749f = this.f41744a.findViewById(R.id.customer_view_commmon_dialog_divider3);
        this.f41748e.setTextColor(SkinUtil.getDialogMainActionTextColor());
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41745b, IToolsService.FontType.BOLD);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41747d, IToolsService.FontType.BOLD);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f41748e, IToolsService.FontType.BOLD);
        DialogBuilder.CustomerDialogModel customerDialogModel = this.f41751h;
        if (customerDialogModel != null) {
            setCancelable(customerDialogModel.mCancelable);
            if (!TextUtils.isEmpty(this.f41751h.title)) {
                setTitle(this.f41751h.title);
            }
            if (this.f41751h.mContentView != null) {
                setContent(this.f41751h.mContentView);
            }
            if (this.f41751h.mMainAction != null) {
                m29489b(this.f41751h.mMainAction);
            }
            if (this.f41751h.mSubAction1 != null) {
                m29488a(this.f41751h.mSubAction1);
            }
        }
    }

    /* renamed from: a */
    private void m29488a(final CustomerCommonDialog.DialogAction dialogAction) {
        this.f41747d.setText(dialogAction.mActionName);
        this.f41747d.setVisibility(0);
        this.f41749f.setVisibility(0);
        if (dialogAction.mListener == null) {
            this.f41747d.setOnClickListener(this.f41752i);
        } else {
            this.f41747d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (dialogAction.mIsAutoDismiss) {
                        CustomerPolicyDialog.this.dismiss();
                    }
                    dialogAction.mListener.onClick(view);
                }
            });
        }
    }

    /* renamed from: b */
    private void m29489b(final CustomerCommonDialog.DialogAction dialogAction) {
        this.f41748e.setText(dialogAction.mActionName);
        if (dialogAction.mListener == null) {
            this.f41748e.setOnClickListener(this.f41752i);
        } else {
            this.f41748e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (dialogAction.mIsAutoDismiss) {
                        CustomerPolicyDialog.this.dismiss();
                    }
                    dialogAction.mListener.onClick(view);
                }
            });
        }
    }
}
