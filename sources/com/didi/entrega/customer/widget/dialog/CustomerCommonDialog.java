package com.didi.entrega.customer.widget.dialog;

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
import com.didi.autotracker.AutoTrackHelper;
import com.didi.entrega.customer.foundation.skin.SkinUtil;
import com.didi.entrega.customer.widget.dialog.DialogBuilder;
import com.taxis99.R;
import rui.base.ImageLoader;
import rui.util.ViewUtils;

public class CustomerCommonDialog extends Dialog {

    /* renamed from: a */
    private View f20404a;

    /* renamed from: b */
    private ImageView f20405b;

    /* renamed from: c */
    private ImageView f20406c;

    /* renamed from: d */
    private TextView f20407d;

    /* renamed from: e */
    private TextView f20408e;

    /* renamed from: f */
    private FrameLayout f20409f;

    /* renamed from: g */
    private TextView f20410g;

    /* renamed from: h */
    private TextView f20411h;

    /* renamed from: i */
    private TextView f20412i;

    /* renamed from: j */
    private View f20413j;

    /* renamed from: k */
    private LinearLayout f20414k;

    /* renamed from: l */
    private Context f20415l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public DialogBuilder.CustomerDialogModel f20416m;

    /* renamed from: n */
    private View.OnClickListener f20417n = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
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
        this.f20416m = customerDialogModel;
        this.f20415l = context;
    }

    public View initRootView(LayoutInflater layoutInflater) {
        this.f20404a = layoutInflater.inflate(R.layout.entrega_customer_dialog_common, (ViewGroup) null);
        m14947e();
        return this.f20404a;
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f20404a = layoutInflater.inflate(R.layout.entrega_customer_dialog_common, viewGroup, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.leftMargin = (int) ViewUtils.m3859dp(this.f20415l, 50.0f);
        layoutParams.rightMargin = (int) ViewUtils.m3859dp(this.f20415l, 50.0f);
        this.f20404a.setLayoutParams(layoutParams);
        m14947e();
        return this.f20404a;
    }

    public CustomerCommonDialog setContent(CharSequence charSequence) {
        this.f20408e.setText(charSequence);
        this.f20408e.setVisibility(0);
        return this;
    }

    public CustomerCommonDialog setContent(View view) {
        this.f20409f.addView(view);
        return this;
    }

    public CustomerCommonDialog setTitle(CharSequence charSequence) {
        this.f20407d.setText(charSequence);
        return this;
    }

    /* renamed from: e */
    private void m14947e() {
        this.f20405b = (ImageView) this.f20404a.findViewById(R.id.customer_iv_common_dialog_banner);
        this.f20406c = (ImageView) this.f20404a.findViewById(R.id.customer_iv_common_dialog_close);
        this.f20407d = (TextView) this.f20404a.findViewById(R.id.customer_tv_common_dialog_title);
        this.f20408e = (TextView) this.f20404a.findViewById(R.id.customer_tv_common_dialog_content);
        this.f20409f = (FrameLayout) this.f20404a.findViewById(R.id.customer_fl_common_dialog_content);
        this.f20410g = (TextView) this.f20404a.findViewById(R.id.customer_tv_common_dialog_sub_action1);
        this.f20411h = (TextView) this.f20404a.findViewById(R.id.customer_tv_common_dialog_sub_action2);
        this.f20412i = (TextView) this.f20404a.findViewById(R.id.customer_tv_common_dialog_main_action);
        this.f20414k = (LinearLayout) this.f20404a.findViewById(R.id.customer_ll_common_dialog_action2);
        this.f20413j = this.f20404a.findViewById(R.id.customer_view_commmon_dialog_divider3);
        this.f20412i.setTextColor(SkinUtil.getDialogMainActionTextColor());
        this.f20406c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CustomerCommonDialog.this.dismiss();
                if (CustomerCommonDialog.this.f20416m != null && CustomerCommonDialog.this.f20416m.onCloseListener != null) {
                    CustomerCommonDialog.this.f20416m.onCloseListener.onClick(view);
                }
            }
        });
        DialogBuilder.CustomerDialogModel customerDialogModel = this.f20416m;
        if (customerDialogModel != null) {
            setCancelable(customerDialogModel.mCancelable);
            if (this.f20416m.iconImage != null) {
                m14944a(this.f20416m.iconImage);
            }
            if (this.f20416m.hasClose) {
                m14942a(0);
            }
            if (!TextUtils.isEmpty(this.f20416m.title)) {
                setTitle(this.f20416m.title);
            }
            if (!TextUtils.isEmpty(this.f20416m.content)) {
                setContent(this.f20416m.content);
            }
            if (this.f20416m.mContentView != null) {
                setContent(this.f20416m.mContentView);
            }
            if (this.f20416m.mMainAction != null) {
                m14946c(this.f20416m.mMainAction);
            }
            if (this.f20416m.mSubAction1 != null) {
                m14943a(this.f20416m.mSubAction1);
            }
            if (this.f20416m.mSubAction2 != null) {
                m14945b(this.f20416m.mSubAction2);
            }
            if (this.f20416m.iconImage != null) {
                this.f20408e.setGravity(17);
            } else {
                this.f20408e.setGravity(3);
            }
        }
    }

    /* renamed from: a */
    private void m14944a(ImageLoader imageLoader) {
        this.f20405b.setVisibility(0);
        imageLoader.load(this.f20405b);
    }

    /* renamed from: a */
    private void m14942a(int i) {
        this.f20406c.setVisibility(i);
    }

    /* renamed from: a */
    private void m14943a(final DialogAction dialogAction) {
        this.f20410g.setText(dialogAction.mActionName);
        this.f20410g.setVisibility(0);
        this.f20413j.setVisibility(0);
        if (dialogAction.mListener == null) {
            this.f20410g.setOnClickListener(this.f20417n);
        } else {
            this.f20410g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (dialogAction.mIsAutoDismiss) {
                        CustomerCommonDialog.this.dismiss();
                    }
                    dialogAction.mListener.onClick(view);
                }
            });
        }
    }

    /* renamed from: b */
    private void m14945b(final DialogAction dialogAction) {
        this.f20411h.setText(dialogAction.mActionName);
        this.f20414k.setVisibility(0);
        if (dialogAction.mListener == null) {
            this.f20411h.setOnClickListener(this.f20417n);
        } else {
            this.f20411h.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (dialogAction.mIsAutoDismiss) {
                        CustomerCommonDialog.this.dismiss();
                    }
                    dialogAction.mListener.onClick(view);
                }
            });
        }
    }

    /* renamed from: c */
    private void m14946c(final DialogAction dialogAction) {
        this.f20412i.setText(dialogAction.mActionName);
        if (dialogAction.mListener == null) {
            this.f20412i.setOnClickListener(this.f20417n);
        } else {
            this.f20412i.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
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
