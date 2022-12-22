package com.didi.beatles.p099im.views.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.views.dialog.IMAlertController;

/* renamed from: com.didi.beatles.im.views.dialog.IMAlertDialogFragment */
public class IMAlertDialogFragment extends DialogFragment {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public IMAlertController f10176a;

    /* renamed from: b */
    private OnDismissListener f10177b;

    /* renamed from: c */
    private OnCancelListener f10178c;

    /* renamed from: com.didi.beatles.im.views.dialog.IMAlertDialogFragment$OnCancelListener */
    public interface OnCancelListener {
        void onCancel(IMAlertDialogFragment iMAlertDialogFragment);
    }

    /* renamed from: com.didi.beatles.im.views.dialog.IMAlertDialogFragment$OnClickListener */
    public interface OnClickListener {
        void onClick(IMAlertDialogFragment iMAlertDialogFragment, View view);
    }

    /* renamed from: com.didi.beatles.im.views.dialog.IMAlertDialogFragment$OnDismissListener */
    public interface OnDismissListener {
        void onDismiss(IMAlertDialogFragment iMAlertDialogFragment);
    }

    /* renamed from: com.didi.beatles.im.views.dialog.IMAlertDialogFragment$RemindCheckboxListener */
    public interface RemindCheckboxListener {
        void onStateChanged(boolean z);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static IMAlertDialogFragment m6936b(Context context) {
        IMAlertDialogFragment iMAlertDialogFragment = new IMAlertDialogFragment();
        iMAlertDialogFragment.m6937c(context);
        return iMAlertDialogFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 16973939);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = getDialog();
        if (dialog == null || this.f10176a == null) {
            return null;
        }
        dialog.requestWindowFeature(1);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        return this.f10176a.getLayout();
    }

    public void show(FragmentManager fragmentManager, String str) {
        try {
            super.show(fragmentManager, str);
        } catch (Exception unused) {
        }
    }

    public int show(FragmentTransaction fragmentTransaction, String str) {
        try {
            return super.show(fragmentTransaction, str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public void dismiss() {
        if (getFragmentManager() != null) {
            try {
                super.dismiss();
            } catch (Exception unused) {
            }
        }
    }

    public void dismissAllowingStateLoss() {
        if (getFragmentManager() != null) {
            super.dismissAllowingStateLoss();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        m6931a();
        OnDismissListener onDismissListener = this.f10177b;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        OnCancelListener onCancelListener = this.f10178c;
        if (onCancelListener != null) {
            onCancelListener.onCancel(this);
        }
    }

    /* renamed from: c */
    private void m6937c(Context context) {
        this.f10176a = new IMAlertController(LayoutInflater.from(context));
    }

    /* renamed from: a */
    private void m6931a() {
        ViewParent parent;
        if (getView() != null && (parent = getView().getParent()) != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(getView());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6933a(OnDismissListener onDismissListener) {
        this.f10177b = onDismissListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6932a(OnCancelListener onCancelListener) {
        this.f10178c = onCancelListener;
    }

    /* renamed from: com.didi.beatles.im.views.dialog.IMAlertDialogFragment$Builder */
    public static class Builder {

        /* renamed from: P */
        IMAlertController.AlertParams f10179P;

        public Builder(Context context) {
            this.f10179P = new IMAlertController.AlertParams(context);
        }

        public Context getContext() {
            return this.f10179P.mContext;
        }

        public Builder setCancelable(boolean z) {
            this.f10179P.mCancelable = z;
            return this;
        }

        public Builder setOnDismissListener(OnDismissListener onDismissListener) {
            this.f10179P.mOnDismissListener = onDismissListener;
            return this;
        }

        public Builder setOnCancelListener(OnCancelListener onCancelListener) {
            this.f10179P.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.f10179P.mTitle = charSequence;
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.f10179P.mMessage = charSequence;
            return this;
        }

        public Builder setContentView(View view) {
            this.f10179P.mContentView = view;
            return this;
        }

        public Builder setIcon(int i) {
            this.f10179P.mIconId = i;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.f10179P.mIcon = drawable;
            return this;
        }

        public Builder setIcon(IMAlertController.IconType iconType) {
            this.f10179P.mIconType = iconType;
            return this;
        }

        public Builder setIconVisible(boolean z) {
            this.f10179P.mIsIconVisible = z;
            return this;
        }

        public Builder setRemindCheckBox(boolean z, RemindCheckboxListener remindCheckboxListener) {
            this.f10179P.mCheckboxIsShow = z;
            this.f10179P.mCheckboxListener = remindCheckboxListener;
            return this;
        }

        @Deprecated
        public Builder setPositiveButton(int i, View.OnClickListener onClickListener) {
            IMAlertController.AlertParams alertParams = this.f10179P;
            alertParams.mPositiveButtonText = alertParams.mContext.getText(i);
            this.f10179P.mPositiveButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        @Deprecated
        public Builder setPositiveButton(CharSequence charSequence, View.OnClickListener onClickListener) {
            this.f10179P.mPositiveButtonText = charSequence;
            this.f10179P.mPositiveButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        @Deprecated
        public Builder setNegativeButton(int i, View.OnClickListener onClickListener) {
            IMAlertController.AlertParams alertParams = this.f10179P;
            alertParams.mNegativeButtonText = alertParams.mContext.getText(i);
            this.f10179P.mNegativeButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        @Deprecated
        public Builder setNegativeButton(CharSequence charSequence, View.OnClickListener onClickListener) {
            this.f10179P.mNegativeButtonText = charSequence;
            this.f10179P.mNegativeButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        @Deprecated
        public Builder setNeutralButton(int i, View.OnClickListener onClickListener) {
            IMAlertController.AlertParams alertParams = this.f10179P;
            alertParams.mNeutralButtonText = alertParams.mContext.getText(i);
            this.f10179P.mNeutralButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        @Deprecated
        public Builder setNeutralButton(CharSequence charSequence, View.OnClickListener onClickListener) {
            this.f10179P.mNeutralButtonText = charSequence;
            this.f10179P.mNeutralButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        public Builder setPositiveButton(int i, OnClickListener onClickListener) {
            IMAlertController.AlertParams alertParams = this.f10179P;
            alertParams.mPositiveButtonText = alertParams.mContext.getText(i);
            this.f10179P.mPositiveButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, OnClickListener onClickListener) {
            this.f10179P.mPositiveButtonText = charSequence;
            this.f10179P.mPositiveButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        public Builder setNegativeButton(int i, OnClickListener onClickListener) {
            IMAlertController.AlertParams alertParams = this.f10179P;
            alertParams.mNegativeButtonText = alertParams.mContext.getText(i);
            this.f10179P.mNegativeButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, OnClickListener onClickListener) {
            this.f10179P.mNegativeButtonText = charSequence;
            this.f10179P.mNegativeButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        public Builder setNeutralButton(int i, OnClickListener onClickListener) {
            IMAlertController.AlertParams alertParams = this.f10179P;
            alertParams.mNeutralButtonText = alertParams.mContext.getText(i);
            this.f10179P.mNeutralButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, OnClickListener onClickListener) {
            this.f10179P.mNeutralButtonText = charSequence;
            this.f10179P.mNeutralButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        public IMAlertDialogFragment create() {
            IMAlertDialogFragment a = IMAlertDialogFragment.m6936b(getContext());
            this.f10179P.apply(a, a.f10176a);
            a.setCancelable(this.f10179P.mCancelable);
            a.m6933a(this.f10179P.mOnDismissListener);
            a.m6932a(this.f10179P.mOnCancelListener);
            return a;
        }
    }

    /* renamed from: com.didi.beatles.im.views.dialog.IMAlertDialogFragment$ListenerAdapter */
    static class ListenerAdapter implements View.OnClickListener {
        private IMAlertDialogFragment mFragment;
        private OnClickListener mListener;
        private View.OnClickListener mViewOnClickListener;

        ListenerAdapter(OnClickListener onClickListener) {
            this.mListener = onClickListener;
        }

        ListenerAdapter(View.OnClickListener onClickListener) {
            this.mViewOnClickListener = onClickListener;
        }

        public final void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            OnClickListener onClickListener = this.mListener;
            if (onClickListener != null) {
                onClickListener.onClick(this.mFragment, view);
                return;
            }
            View.OnClickListener onClickListener2 = this.mViewOnClickListener;
            if (onClickListener2 != null) {
                onClickListener2.onClick(view);
            }
        }

        public void attachAlertDialogFragment(IMAlertDialogFragment iMAlertDialogFragment) {
            this.mFragment = iMAlertDialogFragment;
        }
    }
}
