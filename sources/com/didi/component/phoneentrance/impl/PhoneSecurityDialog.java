package com.didi.component.phoneentrance.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.views.imageView.IMRoundedImageView;
import com.didi.sdk.view.dialog.AlertDialogBase;
import com.taxis99.R;

public class PhoneSecurityDialog extends AlertDialogBase {

    /* renamed from: a */
    private View f15234a;

    /* renamed from: b */
    private ImageView f15235b;

    /* renamed from: c */
    private TextView f15236c;

    /* renamed from: d */
    private TextView f15237d;

    /* renamed from: e */
    private Button f15238e;

    /* renamed from: f */
    private Button f15239f;

    public interface OnCancelClickedListener {
        void onCancelClicked(PhoneSecurityDialog phoneSecurityDialog);
    }

    public interface OnConfirmClickedListener {
        void onConfirmClicked(PhoneSecurityDialog phoneSecurityDialog);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static PhoneSecurityDialog m10929b(Context context) {
        PhoneSecurityDialog phoneSecurityDialog = new PhoneSecurityDialog();
        phoneSecurityDialog.m10932c(context);
        return phoneSecurityDialog;
    }

    /* renamed from: c */
    private void m10932c(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_phone_security_dialog_layout, (ViewGroup) null);
        this.f15234a = inflate;
        this.f15235b = (ImageView) inflate.findViewById(R.id.iv_phone_security_icon);
        this.f15236c = (TextView) this.f15234a.findViewById(R.id.tv_phone_security_title);
        this.f15237d = (TextView) this.f15234a.findViewById(R.id.tv_phone_security_content);
        this.f15238e = (Button) this.f15234a.findViewById(R.id.bt_phone_security_left);
        this.f15239f = (Button) this.f15234a.findViewById(R.id.bt_phone_security_right);
        ((IMRoundedImageView) this.f15234a.findViewById(R.id.iv_phone_security_icon)).setCornerType(1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10921a(int i) {
        this.f15235b.setImageResource(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10926a(CharSequence charSequence) {
        this.f15236c.setText(charSequence);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10931b(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f15237d.setVisibility(8);
            return;
        }
        this.f15237d.setVisibility(0);
        this.f15237d.setText(charSequence);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10928a(CharSequence charSequence, final OnConfirmClickedListener onConfirmClickedListener) {
        this.f15239f.setText(charSequence);
        this.f15239f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                onConfirmClickedListener.onConfirmClicked(PhoneSecurityDialog.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10927a(CharSequence charSequence, final OnCancelClickedListener onCancelClickedListener) {
        this.f15238e.setText(charSequence);
        this.f15238e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                onCancelClickedListener.onCancelClicked(PhoneSecurityDialog.this);
            }
        });
    }

    /* access modifiers changed from: protected */
    public View getRootView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return this.f15234a;
    }

    public static class Builder {
        private OnCancelClickedListener mCancelListener;
        private CharSequence mCancelText;
        private OnConfirmClickedListener mConfirmListener;
        private CharSequence mConfirmText;
        private CharSequence mContent;
        private int mImageId = R.drawable.global_phone_security_dialog_icon;
        private CharSequence mTitle;

        public Builder setImage(int i) {
            this.mImageId = i;
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.mTitle = charSequence;
            return this;
        }

        public Builder setContent(CharSequence charSequence) {
            this.mContent = charSequence;
            return this;
        }

        public Builder setConfirmListener(CharSequence charSequence, OnConfirmClickedListener onConfirmClickedListener) {
            this.mConfirmText = charSequence;
            this.mConfirmListener = onConfirmClickedListener;
            return this;
        }

        public Builder setCancelListener(CharSequence charSequence, OnCancelClickedListener onCancelClickedListener) {
            this.mCancelText = charSequence;
            this.mCancelListener = onCancelClickedListener;
            return this;
        }

        public PhoneSecurityDialog build(Context context) {
            PhoneSecurityDialog a = PhoneSecurityDialog.m10929b(context);
            a.m10921a(this.mImageId);
            a.m10926a(this.mTitle);
            a.m10931b(this.mContent);
            a.m10928a(this.mConfirmText, this.mConfirmListener);
            a.m10927a(this.mCancelText, this.mCancelListener);
            return a;
        }
    }
}
