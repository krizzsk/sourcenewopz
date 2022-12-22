package com.didi.sdk.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.log.TraceLogUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.view.dialog.AlertController;
import com.didichuxing.bigdata.p173dp.locsdk.Const;

@Deprecated
public class AlertDialogFragment extends AlertDialogBase {

    /* renamed from: a */
    private OnDismissListener f37963a;

    /* renamed from: b */
    private OnCancelListener f37964b;
    protected AlertController mAlertController;

    public interface OnCancelListener {
        void onCancel(AlertDialogFragment alertDialogFragment);
    }

    public interface OnClickListener {
        void onClick(AlertDialogFragment alertDialogFragment, View view);
    }

    public interface OnDismissListener {
        void onDismiss(AlertDialogFragment alertDialogFragment);
    }

    public interface RemindCheckboxListener {
        void onStateChanged(boolean z);
    }

    public AlertController getAlertController() {
        return this.mAlertController;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static AlertDialogFragment m26873b(Context context) {
        AlertDialogFragment alertDialogFragment = new AlertDialogFragment();
        alertDialogFragment.m26874c(context);
        return alertDialogFragment;
    }

    /* access modifiers changed from: protected */
    public View getRootView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        AlertController alertController = this.mAlertController;
        if (alertController != null) {
            return alertController.getLayout();
        }
        UiThreadHandler.post(new Runnable() {
            public void run() {
                AlertDialogFragment.this.dismiss();
            }
        });
        return null;
    }

    public TextView getMessageView() {
        return this.mAlertController.getTextMessage();
    }

    public void show(FragmentManager fragmentManager, String str) {
        try {
            super.show(fragmentManager, str);
            if (this.mAlertController != null) {
                String title = this.mAlertController.getTitle();
                String message = this.mAlertController.getMessage();
                TraceLogUtil.addLogWithTab("alert_stat", "[title" + title + "][msg=" + message + Const.jaRight);
            }
        } catch (Exception e) {
            Log.e("AlertDialogFragment", "show dialog error", e);
        }
    }

    public int show(FragmentTransaction fragmentTransaction, String str) {
        int i = 0;
        try {
            if (!isAdded() && !isVisible()) {
                if (!isRemoving()) {
                    int show = super.show(fragmentTransaction, str);
                    try {
                        if (this.mAlertController == null) {
                            return show;
                        }
                        String title = this.mAlertController.getTitle();
                        String message = this.mAlertController.getMessage();
                        TraceLogUtil.addLogWithTab("alert_stat", "[title" + title + "][msg=" + message + Const.jaRight);
                        return show;
                    } catch (Exception e) {
                        e = e;
                        i = show;
                        Log.e("AlertDialogFragment", "show dialog error", e);
                        return i;
                    }
                }
            }
            return 0;
        } catch (Exception e2) {
            e = e2;
            Log.e("AlertDialogFragment", "show dialog error", e);
            return i;
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
        m26868a();
        OnDismissListener onDismissListener = this.f37963a;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        OnCancelListener onCancelListener = this.f37964b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(this);
        }
    }

    /* renamed from: c */
    private void m26874c(Context context) {
        this.mAlertController = new AlertController(LayoutInflater.from(context), this);
    }

    /* renamed from: a */
    private void m26868a() {
        ViewParent parent;
        if (getView() != null && (parent = getView().getParent()) != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(getView());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26870a(OnDismissListener onDismissListener) {
        this.f37963a = onDismissListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26869a(OnCancelListener onCancelListener) {
        this.f37964b = onCancelListener;
    }

    public static class Builder {

        /* renamed from: P */
        public AlertController.AlertParams f37965P;

        @Deprecated
        public Builder setIconVisible(boolean z) {
            return this;
        }

        @Deprecated
        public Builder setRemindCheckBox(boolean z, RemindCheckboxListener remindCheckboxListener) {
            return this;
        }

        public Builder(Context context) {
            this.f37965P = new AlertController.AlertParams(context);
        }

        public Context getContext() {
            return this.f37965P.mContext;
        }

        public Builder hideDiverContentLine() {
            this.f37965P.setHideDiverContentLine(true);
            return this;
        }

        public Builder showDiverContentLine() {
            this.f37965P.setHideDiverContentLine(false);
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.f37965P.mCancelable = z;
            return this;
        }

        public Builder setDefaultButtonTxtColor(int i) {
            this.f37965P.mDefaultButtonTextColorId = getContext().getResources().getColor(i);
            return this;
        }

        public Builder setDefaultButtonColor(int i) {
            this.f37965P.mDefaultButtonTextColorId = i;
            return this;
        }

        public Builder setSupprtMullineTitle(boolean z) {
            this.f37965P.isSupportMullineTitle = z;
            return this;
        }

        public Builder setOnDismissListener(OnDismissListener onDismissListener) {
            this.f37965P.mOnDismissListener = onDismissListener;
            return this;
        }

        public Builder setOnCancelListener(OnCancelListener onCancelListener) {
            this.f37965P.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setContentView(View view) {
            this.f37965P.mCustomContentView = view;
            return this;
        }

        public Builder setCloseVisible(boolean z) {
            this.f37965P.mIsCloseVisible = z;
            return this;
        }

        public Builder setIcon(int i) {
            this.f37965P.mIconId = i;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.f37965P.mIcon = drawable;
            return this;
        }

        public Builder setIcon(AlertController.IconType iconType) {
            this.f37965P.mIconType = iconType;
            return this;
        }

        public Builder setLink(CharSequence charSequence, OnClickListener onClickListener) {
            this.f37965P.mLinkHint = charSequence;
            this.f37965P.linkListener = new ListenerAdapter(onClickListener);
            return this;
        }

        public Builder setBackground(int i) {
            this.f37965P.background = i;
            return this;
        }

        public Builder setLinkIconVisible(boolean z) {
            this.f37965P.mLinkIconVisible = z;
            return this;
        }

        public Builder setLinkForceCenter() {
            this.f37965P.mLinkForceCenter = true;
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.f37965P.mTitle = charSequence;
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.f37965P.mMessage = charSequence;
            return this;
        }

        public Builder setRemindCheckBox(CharSequence charSequence, RemindCheckboxListener remindCheckboxListener) {
            this.f37965P.mCheckboxHintText = charSequence;
            this.f37965P.mCheckboxListener = remindCheckboxListener;
            return this;
        }

        public Builder setPositiveButton(int i, OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f37965P;
            alertParams.mPositiveButtonText = alertParams.mContext.getText(i);
            this.f37965P.mPositiveButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        public Builder setPositiveButton(int i) {
            AlertController.AlertParams alertParams = this.f37965P;
            alertParams.mPositiveButtonText = alertParams.mContext.getText(i);
            this.f37965P.mPositiveButtonListener = new ListenerAdapter((OnClickListener) new DefaultListener());
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, OnClickListener onClickListener) {
            this.f37965P.mPositiveButtonText = charSequence;
            this.f37965P.mPositiveButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence) {
            this.f37965P.mPositiveButtonText = charSequence;
            this.f37965P.mPositiveButtonListener = new ListenerAdapter((OnClickListener) new DefaultListener());
            return this;
        }

        public Builder setNegativeButton(int i, OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f37965P;
            alertParams.mNegativeButtonText = alertParams.mContext.getText(i);
            this.f37965P.mNegativeButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        public Builder setNegativeButton(int i) {
            AlertController.AlertParams alertParams = this.f37965P;
            alertParams.mNegativeButtonText = alertParams.mContext.getText(i);
            this.f37965P.mNegativeButtonListener = new ListenerAdapter((OnClickListener) new DefaultListener());
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, OnClickListener onClickListener) {
            this.f37965P.mNegativeButtonText = charSequence;
            this.f37965P.mNegativeButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence) {
            this.f37965P.mNegativeButtonText = charSequence;
            this.f37965P.mNegativeButtonListener = new ListenerAdapter((OnClickListener) new DefaultListener());
            return this;
        }

        public Builder setNeutralButton(int i, OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f37965P;
            alertParams.mNeutralButtonText = alertParams.mContext.getText(i);
            this.f37965P.mNeutralButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        public Builder setNeutralButton(int i) {
            AlertController.AlertParams alertParams = this.f37965P;
            alertParams.mNeutralButtonText = alertParams.mContext.getText(i);
            this.f37965P.mNeutralButtonListener = new ListenerAdapter((OnClickListener) new DefaultListener());
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, OnClickListener onClickListener) {
            this.f37965P.mNeutralButtonText = charSequence;
            this.f37965P.mNeutralButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence) {
            this.f37965P.mNeutralButtonText = charSequence;
            this.f37965P.mNeutralButtonListener = new ListenerAdapter((OnClickListener) new DefaultListener());
            return this;
        }

        @Deprecated
        public Builder setPositiveButton(int i, View.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f37965P;
            alertParams.mPositiveButtonText = alertParams.mContext.getText(i);
            this.f37965P.mPositiveButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        @Deprecated
        public Builder setPositiveButton(CharSequence charSequence, View.OnClickListener onClickListener) {
            this.f37965P.mPositiveButtonText = charSequence;
            this.f37965P.mPositiveButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        @Deprecated
        public Builder setNegativeButton(int i, View.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f37965P;
            alertParams.mNegativeButtonText = alertParams.mContext.getText(i);
            this.f37965P.mNegativeButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        @Deprecated
        public Builder setNegativeButton(CharSequence charSequence, View.OnClickListener onClickListener) {
            this.f37965P.mNegativeButtonText = charSequence;
            this.f37965P.mNegativeButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        @Deprecated
        public Builder setNeutralButton(int i, View.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f37965P;
            alertParams.mNeutralButtonText = alertParams.mContext.getText(i);
            this.f37965P.mNeutralButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        @Deprecated
        public Builder setNeutralButton(CharSequence charSequence, View.OnClickListener onClickListener) {
            this.f37965P.mNeutralButtonText = charSequence;
            this.f37965P.mNeutralButtonListener = new ListenerAdapter(onClickListener);
            return this;
        }

        public Builder setNegativeButtonDefault() {
            this.f37965P.mIsNegativeDefault = true;
            return this;
        }

        public Builder setPositiveButtonDefault() {
            this.f37965P.mIsPositiveDefault = true;
            return this;
        }

        public Builder setNeutralButtonDefault() {
            this.f37965P.mIsNeutralDefault = true;
            return this;
        }

        public void setCustomCheckLayout(View view) {
            this.f37965P.mCustomCheckLayout = view;
        }

        public AlertDialogFragment create() {
            AlertDialogFragment a = AlertDialogFragment.m26873b(getContext());
            this.f37965P.apply(a, a.mAlertController);
            a.setCancelable(this.f37965P.mCancelable);
            a.m26870a(this.f37965P.mOnDismissListener);
            a.m26869a(this.f37965P.mOnCancelListener);
            return a;
        }
    }

    static class ListenerAdapter implements View.OnClickListener {
        private AlertDialogFragment mFragment;
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

        public void attachAlertDialogFragment(AlertDialogFragment alertDialogFragment) {
            this.mFragment = alertDialogFragment;
        }
    }

    static class DefaultListener implements OnClickListener {
        DefaultListener() {
        }

        public void onClick(AlertDialogFragment alertDialogFragment, View view) {
            if (alertDialogFragment != null) {
                alertDialogFragment.dismiss();
            }
        }
    }
}
