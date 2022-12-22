package com.didi.soda.customer.widget.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.widget.dialog.DialogBuilder;
import com.taxis99.R;
import rui.base.ImageLoader;
import rui.util.ViewUtils;

public class CustomerCommonDialog extends Dialog {

    /* renamed from: a */
    private View f41702a;

    /* renamed from: b */
    private ImageView f41703b;

    /* renamed from: c */
    private ImageView f41704c;

    /* renamed from: d */
    private TextView f41705d;

    /* renamed from: e */
    private TextView f41706e;

    /* renamed from: f */
    private FrameLayout f41707f;

    /* renamed from: g */
    private TextView f41708g;

    /* renamed from: h */
    private TextView f41709h;

    /* renamed from: i */
    private TextView f41710i;

    /* renamed from: j */
    private View f41711j;

    /* renamed from: k */
    private LinearLayout f41712k;

    /* renamed from: l */
    private Context f41713l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public DialogBuilder.CustomerDialogModel f41714m;

    /* renamed from: n */
    private View.OnClickListener f41715n = new View.OnClickListener() {
        public void onClick(View view) {
            CustomerCommonDialog.this.dismiss();
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

    public CustomerCommonDialog(Context context, DialogBuilder.CustomerDialogModel customerDialogModel) {
        this.f41714m = customerDialogModel;
        this.f41713l = context;
    }

    public View initRootView(LayoutInflater layoutInflater) {
        this.f41702a = layoutInflater.inflate(R.layout.customer_dialog_common, (ViewGroup) null);
        m29462e();
        return this.f41702a;
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f41702a = layoutInflater.inflate(R.layout.customer_dialog_common, viewGroup, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.leftMargin = (int) ViewUtils.m3859dp(this.f41713l, 50.0f);
        layoutParams.rightMargin = (int) ViewUtils.m3859dp(this.f41713l, 50.0f);
        this.f41702a.setLayoutParams(layoutParams);
        m29462e();
        return this.f41702a;
    }

    public CustomerCommonDialog setContent(CharSequence charSequence) {
        this.f41706e.setText(charSequence);
        this.f41706e.setVisibility(0);
        return this;
    }

    public CustomerCommonDialog setContent(View view) {
        this.f41707f.addView(view);
        return this;
    }

    public CustomerCommonDialog setTitle(CharSequence charSequence) {
        this.f41705d.setText(charSequence);
        return this;
    }

    /* renamed from: e */
    private void m29462e() {
        this.f41703b = (ImageView) this.f41702a.findViewById(R.id.customer_iv_common_dialog_banner);
        this.f41704c = (ImageView) this.f41702a.findViewById(R.id.customer_iv_common_dialog_close);
        this.f41705d = (TextView) this.f41702a.findViewById(R.id.customer_tv_common_dialog_title);
        this.f41706e = (TextView) this.f41702a.findViewById(R.id.customer_tv_common_dialog_content);
        this.f41707f = (FrameLayout) this.f41702a.findViewById(R.id.customer_fl_common_dialog_content);
        this.f41708g = (TextView) this.f41702a.findViewById(R.id.customer_tv_common_dialog_sub_action1);
        this.f41709h = (TextView) this.f41702a.findViewById(R.id.customer_tv_common_dialog_sub_action2);
        this.f41710i = (TextView) this.f41702a.findViewById(R.id.customer_tv_common_dialog_main_action);
        this.f41712k = (LinearLayout) this.f41702a.findViewById(R.id.customer_ll_common_dialog_action2);
        this.f41711j = this.f41702a.findViewById(R.id.customer_view_commmon_dialog_divider3);
        this.f41710i.setTextColor(SkinUtil.getDialogMainActionTextColor());
        this.f41704c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CustomerCommonDialog.this.dismiss();
                if (CustomerCommonDialog.this.f41714m != null && CustomerCommonDialog.this.f41714m.onCloseListener != null) {
                    CustomerCommonDialog.this.f41714m.onCloseListener.onClick(view);
                }
            }
        });
        DialogBuilder.CustomerDialogModel customerDialogModel = this.f41714m;
        if (customerDialogModel != null) {
            setCancelable(customerDialogModel.mCancelable);
            if (this.f41714m.iconImage != null) {
                m29459a(this.f41714m.iconImage);
            }
            if (this.f41714m.hasClose) {
                m29457a(0);
            }
            if (!TextUtils.isEmpty(this.f41714m.title)) {
                setTitle(this.f41714m.title);
            }
            if (!TextUtils.isEmpty(this.f41714m.content)) {
                setContent(this.f41714m.content);
            }
            if (this.f41714m.mContentView != null) {
                setContent(this.f41714m.mContentView);
            }
            if (this.f41714m.mMainAction != null) {
                m29461c(this.f41714m.mMainAction);
            }
            if (this.f41714m.mSubAction1 != null) {
                m29458a(this.f41714m.mSubAction1);
            }
            if (this.f41714m.mSubAction2 != null) {
                m29460b(this.f41714m.mSubAction2);
            }
            if (this.f41714m.iconImage != null) {
                this.f41706e.setGravity(17);
            } else {
                this.f41706e.setGravity(3);
            }
        }
    }

    /* renamed from: a */
    private void m29459a(ImageLoader imageLoader) {
        this.f41703b.setVisibility(0);
        imageLoader.load(this.f41703b);
    }

    /* renamed from: a */
    private void m29457a(int i) {
        this.f41704c.setVisibility(i);
    }

    /* renamed from: a */
    private void m29458a(final DialogAction dialogAction) {
        this.f41708g.setText(dialogAction.mActionName);
        this.f41708g.setVisibility(0);
        this.f41711j.setVisibility(0);
        if (dialogAction.mListener == null) {
            this.f41708g.setOnClickListener(this.f41715n);
        } else {
            this.f41708g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (dialogAction.mIsAutoDismiss) {
                        CustomerCommonDialog.this.dismiss();
                    }
                    dialogAction.mListener.onClick(view);
                }
            });
        }
    }

    /* renamed from: b */
    private void m29460b(final DialogAction dialogAction) {
        this.f41709h.setText(dialogAction.mActionName);
        this.f41712k.setVisibility(0);
        if (dialogAction.mListener == null) {
            this.f41709h.setOnClickListener(this.f41715n);
        } else {
            this.f41709h.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (dialogAction.mIsAutoDismiss) {
                        CustomerCommonDialog.this.dismiss();
                    }
                    dialogAction.mListener.onClick(view);
                }
            });
        }
    }

    /* renamed from: c */
    private void m29461c(final DialogAction dialogAction) {
        this.f41710i.setText(dialogAction.mActionName);
        if (dialogAction.mListener == null) {
            this.f41710i.setOnClickListener(this.f41715n);
        } else {
            this.f41710i.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (dialogAction.mIsAutoDismiss) {
                        CustomerCommonDialog.this.dismiss();
                    }
                    dialogAction.mListener.onClick(view);
                }
            });
        }
    }

    public static class DialogAction {
        public String mActionName;
        public boolean mIsAutoDismiss = true;
        public View.OnClickListener mListener;

        public DialogAction(String str) {
            this.mActionName = str;
            this.mListener = null;
        }

        public DialogAction(String str, View.OnClickListener onClickListener) {
            this.mActionName = str;
            this.mListener = onClickListener;
        }

        public DialogAction setAutoDismiss(boolean z) {
            this.mIsAutoDismiss = z;
            return this;
        }
    }
}
