package com.didi.rfusion.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.utils.RFUtils;
import com.didi.rfusion.utils.tracker.RFTrackerHelper;
import com.didi.rfusion.widget.RFIconView;
import com.didi.rfusion.widget.RFTextView;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.didi.rfusion.widget.layout.RFSuperFrameLayout;
import com.taxis99.R;

public abstract class RFDialog extends Dialog {

    /* renamed from: a */
    private static final String f33491a = "RFDialog";

    /* renamed from: b */
    private static final int f33492b = 3;

    /* renamed from: c */
    private static final int f33493c = 0;

    /* renamed from: d */
    private static final int f33494d = 1;

    /* renamed from: e */
    private static final int f33495e = 2;

    /* renamed from: f */
    private ViewGroup f33496f;

    /* renamed from: g */
    private View f33497g;

    /* renamed from: h */
    private RFSuperFrameLayout f33498h;

    /* renamed from: i */
    private ImageView f33499i;
    protected boolean isShowShadow;

    /* renamed from: j */
    private TextView f33500j;

    /* renamed from: k */
    private ViewGroup f33501k;

    /* renamed from: l */
    private LinearLayout f33502l;

    /* renamed from: m */
    private RFIconView f33503m;

    /* renamed from: n */
    private SparseArray<ActionModel> f33504n;

    /* renamed from: o */
    private RFDialogModel f33505o;

    /* renamed from: p */
    private DismissListenerWrapper f33506p;

    /* renamed from: q */
    private boolean f33507q;

    public TransformAnimation getEnterAnimation() {
        return null;
    }

    public TransformAnimation getExitAnimation() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
    }

    /* access modifiers changed from: protected */
    public abstract View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public RFDialog() {
        this.isShowShadow = true;
        this.f33504n = new SparseArray<>(3);
        this.f33505o = new RFDialogModel();
    }

    public RFDialog(RFDialogModel rFDialogModel) {
        this.isShowShadow = true;
        this.f33504n = new SparseArray<>(3);
        this.f33505o = rFDialogModel;
    }

    public final View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        setCancelable(false);
        this.f33496f = (ViewGroup) layoutInflater.inflate(R.layout.rf_dialog, viewGroup, false);
        m23588e();
        onCreate();
        return this.f33496f;
    }

    /* renamed from: e */
    private void m23588e() {
        this.f33498h = (RFSuperFrameLayout) findViewById(R.id.rf_sfl_frame);
        this.f33499i = (ImageView) findViewById(R.id.rf_iv_banner);
        this.f33500j = (TextView) findViewById(R.id.rf_tv_title);
        this.f33501k = (ViewGroup) findViewById(R.id.rf_fl_content_container);
        this.f33502l = (LinearLayout) findViewById(R.id.rf_ll_actions);
        this.f33503m = (RFIconView) findViewById(R.id.rf_icon_close);
        View onInflateView = onInflateView(LayoutInflater.from(getContext()), this.f33501k);
        this.f33501k.addView(onInflateView);
        this.f33497g = onInflateView;
        this.f33507q = true;
        m23589f();
    }

    /* renamed from: f */
    private void m23589f() {
        setTitle(this.f33505o.getTitle());
        if (this.f33505o.getBannerRes() > 0) {
            setBanner(this.f33505o.getBannerRes());
        }
        if (!TextUtils.isEmpty(this.f33505o.getBannerUrl())) {
            setBanner(this.f33505o.getBannerUrl());
        }
        if (this.f33505o.getMainAction() != null) {
            m23583a(0, this.f33505o.getMainAction());
        }
        if (this.f33505o.getSubAction1() != null) {
            m23583a(1, this.f33505o.getSubAction1());
        }
        if (this.f33505o.getSubAction2() != null) {
            m23583a(2, this.f33505o.getSubAction2());
        }
        setOnDismissListener(this.f33505o.getOnDismissListener());
        setCancelable(this.f33505o.isCancelable());
        m23585a(this.f33505o.getCloseModel());
    }

    public void onShow() {
        RFTrackerHelper.trackDialogShow();
    }

    public void onDismiss() {
        DismissListenerWrapper dismissListenerWrapper = this.f33506p;
        if (dismissListenerWrapper != null) {
            dismissListenerWrapper.listener.onDismiss(this, this.f33506p.bundle);
        }
    }

    public void onDestroy() {
        this.f33507q = false;
    }

    /* access modifiers changed from: protected */
    public View getContentView() {
        return this.f33497g;
    }

    /* access modifiers changed from: protected */
    public <T> T findViewById(int i) {
        return this.f33496f.findViewById(i);
    }

    /* access modifiers changed from: protected */
    public Context getContext() {
        return this.f33496f.getContext();
    }

    /* access modifiers changed from: protected */
    public boolean isPrepared() {
        return this.f33507q;
    }

    /* access modifiers changed from: protected */
    public boolean isShadowShow() {
        return this.isShowShadow;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo87707a(boolean z) {
        this.isShowShadow = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo87706a(RFDialogModel rFDialogModel) {
        this.f33505o = rFDialogModel;
    }

    public void setBanner(int i) {
        if (!this.f33507q) {
            this.f33505o.setBannerRes(i);
            return;
        }
        this.f33499i.setImageResource(i);
        this.f33499i.setVisibility(0);
        m23590g();
    }

    public void setBanner(String str) {
        if (!this.f33507q) {
            this.f33505o.setBannerUrl(str);
            return;
        }
        this.f33499i.setVisibility(0);
        ((RequestBuilder) Glide.with(getContext()).load(str).placeholder((int) R.drawable.rf_img_banner_default)).into(this.f33499i);
        m23590g();
    }

    /* renamed from: g */
    private void m23590g() {
        if (this.f33507q) {
            this.f33498h.setMaxHeight((int) RFResUtils.getDimens(getContext(), R.dimen.rf_dialog_max_height));
        }
    }

    public void setTitle(String str) {
        if (!this.f33507q) {
            this.f33505o.setTitle(str);
        } else if (!TextUtils.isEmpty(str)) {
            this.f33500j.setVisibility(0);
            this.f33500j.setText(str);
        } else {
            this.f33500j.setVisibility(8);
            this.f33500j.setText((CharSequence) null);
        }
    }

    public void setMainAction(CharSequence charSequence, RFDialogInterface.OnClickListener onClickListener) {
        if (!this.f33507q) {
            this.f33505o.setMainAction(new ActionModel(charSequence, onClickListener));
        } else {
            m23583a(0, new ActionModel(charSequence, onClickListener));
        }
    }

    public void setSubAction1(CharSequence charSequence, RFDialogInterface.OnClickListener onClickListener) {
        if (!this.f33507q) {
            this.f33505o.setSubAction1(new ActionModel(charSequence, onClickListener));
        } else {
            m23583a(1, new ActionModel(charSequence, onClickListener));
        }
    }

    public void setSubAction2(CharSequence charSequence, RFDialogInterface.OnClickListener onClickListener) {
        if (!this.f33507q) {
            this.f33505o.setSubAction2(new ActionModel(charSequence, onClickListener));
        } else {
            m23583a(2, new ActionModel(charSequence, onClickListener));
        }
    }

    public void setOnDismissListener(RFDialogInterface.OnDismissListener onDismissListener) {
        if (!this.f33507q) {
            this.f33505o.setOnDismissListener(onDismissListener);
        } else if (onDismissListener == null) {
            this.f33506p = null;
        } else {
            DismissListenerWrapper dismissListenerWrapper = new DismissListenerWrapper();
            this.f33506p = dismissListenerWrapper;
            dismissListenerWrapper.listener = onDismissListener;
        }
    }

    public void show(ScopeContext scopeContext, String str) {
        if (scopeContext != null) {
            scopeContext.getNavigator().showDialog(this, str);
        }
    }

    public void dismiss(Bundle bundle) {
        dismiss();
        DismissListenerWrapper dismissListenerWrapper = this.f33506p;
        if (dismissListenerWrapper != null) {
            dismissListenerWrapper.bundle = bundle;
        }
    }

    public String getTitle() {
        if (!this.f33507q) {
            return this.f33505o.getTitle();
        }
        return this.f33500j.getText().toString();
    }

    /* renamed from: a */
    private void m23583a(int i, ActionModel actionModel) {
        this.f33504n.put(i, actionModel);
        m23591h();
    }

    /* renamed from: h */
    private void m23591h() {
        this.f33502l.removeAllViews();
        boolean z = this.f33504n.size() >= 3 && !RFUtils.isPadFlavor();
        this.f33502l.setOrientation(z ? 1 : 0);
        int i = 0;
        while (i < 3) {
            ActionModel actionModel = this.f33504n.get(i);
            if (actionModel != null) {
                View a = m23582a(z, i == 0, actionModel);
                if (z) {
                    this.f33502l.addView(a);
                } else {
                    this.f33502l.addView(a, 0);
                }
                if (i < this.f33504n.size() - 1) {
                    if (z) {
                        this.f33502l.addView(m23587b(z));
                    } else {
                        this.f33502l.addView(m23587b(z), 0);
                    }
                }
            }
            i++;
        }
    }

    /* renamed from: a */
    private View m23582a(boolean z, boolean z2, ActionModel actionModel) {
        LinearLayout.LayoutParams layoutParams;
        RFTextView rFTextView = (RFTextView) LayoutInflater.from(getContext()).inflate(R.layout.rf_layout_dialog_action, this.f33502l, false);
        int dimens = (int) RFResUtils.getDimens(R.dimen.rf_dialog_action_height);
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, dimens);
        } else {
            layoutParams = new LinearLayout.LayoutParams(0, dimens);
            layoutParams.weight = 1.0f;
        }
        rFTextView.setLayoutParams(layoutParams);
        rFTextView.setTypeface(z2 ? 1 : 3);
        rFTextView.setTextColor(RFResUtils.getColor(z2 ? R.color.rf_color_brands_1_100 : R.color.rf_color_gery_2_40_666666));
        rFTextView.setText(actionModel.text);
        rFTextView.setOnClickListener(new View.OnClickListener(actionModel) {
            public final /* synthetic */ RFDialog.ActionModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                RFDialog.this.m23584a(this.f$1, view);
            }
        });
        return rFTextView;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23584a(ActionModel actionModel, View view) {
        if (actionModel.listener != null) {
            actionModel.listener.onClick(this);
        }
        if (this.f33505o.isAutoDismiss()) {
            dismiss();
        }
    }

    /* renamed from: b */
    private View m23587b(boolean z) {
        LinearLayout.LayoutParams layoutParams;
        View view = new View(getContext());
        int dimens = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_dimen_1);
        int dimens2 = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_dialog_action_height);
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, dimens);
        } else {
            layoutParams = new LinearLayout.LayoutParams(dimens, dimens2);
        }
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(RFResUtils.getColor(getContext(), R.color.rf_color_gery_5_90_E5E5E5));
        return view;
    }

    /* renamed from: a */
    private void m23585a(CloseModel closeModel) {
        if (closeModel != null) {
            this.f33503m.setVisibility(closeModel.isCloseable ? 0 : 8);
            this.f33503m.setOnClickListener(new View.OnClickListener(closeModel) {
                public final /* synthetic */ RFDialog.CloseModel f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    RFDialog.this.m23586a(this.f$1, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23586a(CloseModel closeModel, View view) {
        dismiss();
        if (closeModel.listener != null) {
            closeModel.listener.onClick(this);
        }
    }

    private static class DismissListenerWrapper {
        Bundle bundle;
        RFDialogInterface.OnDismissListener listener;

        private DismissListenerWrapper() {
        }
    }

    public static class ActionModel implements Cloneable {
        public RFDialogInterface.OnClickListener listener;
        public CharSequence text;

        public ActionModel(CharSequence charSequence, RFDialogInterface.OnClickListener onClickListener) {
            this.text = charSequence;
            this.listener = onClickListener;
        }
    }

    public static class CloseModel implements Cloneable {
        public boolean isCloseable;
        public RFDialogInterface.OnClickListener listener;

        public CloseModel(boolean z, RFDialogInterface.OnClickListener onClickListener) {
            this.isCloseable = z;
            this.listener = onClickListener;
        }
    }
}
