package com.didi.rfusion.widget.dialog;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.widget.NestedScrollView;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFTextView;
import com.taxis99.R;

public class RFCommonDialog extends RFDialog {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public CommonModel f33486a;

    /* renamed from: b */
    private RFTextView f33487b;

    /* renamed from: c */
    private FrameLayout f33488c;

    /* renamed from: d */
    private NestedScrollView f33489d;

    /* renamed from: e */
    private boolean f33490e;

    public interface OnInflaterListener {
        View onInflater(LayoutInflater layoutInflater, ViewGroup viewGroup);
    }

    private RFCommonDialog() {
        this.f33486a = new CommonModel();
    }

    /* access modifiers changed from: protected */
    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FrameLayout frameLayout = (FrameLayout) layoutInflater.inflate(R.layout.rf_dialog_common, viewGroup, false);
        this.f33488c = frameLayout;
        return frameLayout;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        m23578e();
    }

    /* renamed from: e */
    private void m23578e() {
        if (!TextUtils.isEmpty(this.f33486a.message)) {
            setMessage(this.f33486a.message);
        }
        if (this.f33486a.view != null) {
            setView(this.f33486a.view);
        }
        if (this.f33486a.inflaterListener != null) {
            setView(this.f33486a.inflaterListener);
        }
    }

    /* renamed from: f */
    private void m23579f() {
        if (isPrepared() && this.f33490e) {
            this.f33488c.post(new Runnable() {
                public final void run() {
                    RFCommonDialog.this.m23581h();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void m23581h() {
        int dimens = (int) RFResUtils.getDimens(R.dimen.rf_dialog_margin_height);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f33488c.getLayoutParams();
        if (!TextUtils.isEmpty(getTitle())) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = dimens;
            layoutParams.gravity = 0;
            if (this.f33487b.getLineCount() <= 1) {
                this.f33487b.setGravity(1);
            } else {
                this.f33487b.setGravity(0);
            }
        } else {
            layoutParams.topMargin = dimens;
            layoutParams.bottomMargin = dimens;
            layoutParams.gravity = 17;
        }
        this.f33488c.setLayoutParams(layoutParams);
    }

    public void setMessage(CharSequence charSequence) {
        if (!isPrepared()) {
            this.f33486a.setMessage(charSequence);
            return;
        }
        if (!this.f33490e) {
            this.f33488c.removeAllViews();
            NestedScrollView nestedScrollView = (NestedScrollView) LayoutInflater.from(getContext()).inflate(R.layout.rf_layout_dialog_common_content, this.f33488c, false);
            this.f33489d = nestedScrollView;
            RFTextView rFTextView = (RFTextView) nestedScrollView.findViewById(R.id.rf_tv_content);
            this.f33487b = rFTextView;
            rFTextView.setLineSpacing((float) RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_6), 1.0f);
            this.f33488c.addView(this.f33489d);
            this.f33490e = true;
        }
        this.f33487b.setText(charSequence);
        m23579f();
    }

    public void setView(View view) {
        if (!isPrepared()) {
            this.f33486a.setView(view);
            return;
        }
        this.f33488c.removeAllViews();
        this.f33488c.addView(view);
        this.f33490e = false;
        m23580g();
    }

    /* renamed from: g */
    private void m23580g() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f33488c.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        layoutParams.gravity = 0;
        this.f33488c.setLayoutParams(layoutParams);
    }

    public void setView(OnInflaterListener onInflaterListener) {
        if (!isPrepared()) {
            this.f33486a.setView(onInflaterListener);
        } else if (onInflaterListener != null) {
            this.f33488c.addView(onInflaterListener.onInflater(LayoutInflater.from(getContext()), this.f33488c));
            this.f33490e = false;
            m23580g();
        }
    }

    public CharSequence getMessage() {
        return !isPrepared() ? this.f33486a.message : this.f33487b.getText();
    }

    public void setTitle(String str) {
        super.setTitle(str);
        m23579f();
    }

    public static class Builder extends RFDialogBuilder<Builder, RFCommonDialog> {
        CommonModel model = new CommonModel();

        public Builder setMessage(CharSequence charSequence) {
            this.model.setMessage(charSequence);
            return this;
        }

        public Builder setView(View view) {
            this.model.setView(view);
            return this;
        }

        public Builder setView(OnInflaterListener onInflaterListener) {
            this.model.setView(onInflaterListener);
            return this;
        }

        /* access modifiers changed from: protected */
        public RFCommonDialog createDialog() {
            RFCommonDialog rFCommonDialog = new RFCommonDialog();
            CommonModel unused = rFCommonDialog.f33486a = this.model;
            return rFCommonDialog;
        }
    }

    private static class CommonModel {
        public OnInflaterListener inflaterListener;
        public CharSequence message;
        public View view;

        private CommonModel() {
        }

        public void setMessage(CharSequence charSequence) {
            this.message = charSequence;
            this.view = null;
            this.inflaterListener = null;
        }

        public void setView(View view2) {
            this.view = view2;
            this.message = null;
            this.inflaterListener = null;
        }

        public void setView(OnInflaterListener onInflaterListener) {
            this.inflaterListener = onInflaterListener;
            this.message = null;
            this.view = null;
        }
    }
}
