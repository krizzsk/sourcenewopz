package com.didi.component.service.activity.risk.dialog;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.component.common.dialog.IDialog;
import com.didi.component.core.dialog.DialogInfo;
import com.didi.sdk.view.dialog.AlertDialogFragment;

public class NormalDialog implements IDialog {

    /* renamed from: a */
    private int f15703a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public AlertDialogFragment f15704b;

    /* renamed from: c */
    private FragmentActivity f15705c;

    /* renamed from: d */
    private boolean f15706d;

    public void update(DialogInfo dialogInfo) {
    }

    private NormalDialog(FragmentActivity fragmentActivity, int i) {
        this.f15706d = false;
        this.f15703a = i;
        this.f15705c = fragmentActivity;
    }

    public int getId() {
        return this.f15703a;
    }

    public void show() {
        FragmentActivity fragmentActivity = this.f15705c;
        if (fragmentActivity != null && fragmentActivity.getSupportFragmentManager() != null) {
            this.f15706d = true;
            AlertDialogFragment alertDialogFragment = this.f15704b;
            FragmentManager supportFragmentManager = this.f15705c.getSupportFragmentManager();
            alertDialogFragment.show(supportFragmentManager, this.f15703a + "");
        }
    }

    public boolean isShowing() {
        return this.f15706d;
    }

    public void dismiss() {
        this.f15706d = false;
        this.f15704b.dismissAllowingStateLoss();
    }

    public boolean cancelable() {
        return this.f15704b.isCancelable();
    }

    public static class DialogBuilder {
        /* access modifiers changed from: private */
        public Integer mActionHappend;
        private FragmentActivity mContext;
        private NormalDialogInfo mDialogInfo;
        private AlertDialogFragment.OnDismissListener mDismissListener = new AlertDialogFragment.OnDismissListener() {
            public void onDismiss(AlertDialogFragment alertDialogFragment) {
                if (DialogBuilder.this.mActionHappend == null) {
                    DialogBuilder.this.handleOnClick(alertDialogFragment, 4);
                }
            }
        };
        private IDialog.DialogListener mListener;
        private AlertDialogFragment.OnClickListener mNegativeListener = new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                DialogBuilder.this.handleOnClick(alertDialogFragment, 1);
            }
        };
        private AlertDialogFragment.OnClickListener mNeutralListener = new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                DialogBuilder.this.handleOnClick(alertDialogFragment, 3);
            }
        };
        private AlertDialogFragment.OnClickListener mPositiveListener = new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                DialogBuilder.this.handleOnClick(alertDialogFragment, 2);
            }
        };

        public DialogBuilder(FragmentActivity fragmentActivity) {
            this.mContext = fragmentActivity;
        }

        public DialogBuilder setDialogInfo(NormalDialogInfo normalDialogInfo) {
            this.mDialogInfo = normalDialogInfo;
            return this;
        }

        public DialogBuilder setListener(IDialog.DialogListener dialogListener) {
            this.mListener = dialogListener;
            return this;
        }

        public NormalDialog build() {
            NormalDialog normalDialog = new NormalDialog(this.mContext, this.mDialogInfo.dialogId);
            AlertDialogFragment.Builder builder = new AlertDialogFragment.Builder(this.mContext);
            builder.setCancelable(this.mDialogInfo.f15716v);
            builder.setIconVisible(this.mDialogInfo.f15715u);
            builder.setCloseVisible(this.mDialogInfo.f15717w);
            builder.setOnDismissListener(this.mDismissListener);
            if (this.mDialogInfo.f15707m != 0) {
                builder.setIcon(this.mDialogInfo.f15707m);
            }
            if (this.mDialogInfo.f15708n != null) {
                builder.setIcon(this.mDialogInfo.f15708n);
            }
            if (this.mDialogInfo.f15709o != null) {
                builder.setIcon(this.mDialogInfo.f15709o);
            }
            if (!TextUtils.isEmpty(this.mDialogInfo.f15710p)) {
                builder.setTitle(this.mDialogInfo.f15710p);
            }
            if (!TextUtils.isEmpty(this.mDialogInfo.f15711q)) {
                builder.setMessage(this.mDialogInfo.f15711q);
            }
            if (!TextUtils.isEmpty(this.mDialogInfo.f15712r)) {
                builder.setPositiveButton(this.mDialogInfo.f15712r, this.mPositiveListener);
                builder.setPositiveButtonDefault();
            }
            if (!TextUtils.isEmpty(this.mDialogInfo.f15714t)) {
                builder.setNegativeButton(this.mDialogInfo.f15714t, this.mNegativeListener);
            }
            if (!TextUtils.isEmpty(this.mDialogInfo.f15713s)) {
                builder.setNeutralButton(this.mDialogInfo.f15713s, this.mNeutralListener);
            }
            AlertDialogFragment unused = normalDialog.f15704b = builder.create();
            return normalDialog;
        }

        /* access modifiers changed from: private */
        public void handleOnClick(AlertDialogFragment alertDialogFragment, int i) {
            IDialog.DialogListener dialogListener = this.mListener;
            if (dialogListener != null) {
                dialogListener.onAction(i);
            }
            try {
                alertDialogFragment.dismissAllowingStateLoss();
            } catch (Exception unused) {
            }
        }
    }
}
