package com.didi.component.common.dialog;

import android.text.TextUtils;
import android.view.View;
import com.didi.component.common.dialog.IDialog;
import com.didi.component.core.dialog.DialogInfo;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.view.dialog.AlertDialogFragment;

class NormalDialog implements IDialog {

    /* renamed from: a */
    private int f11576a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public AlertDialogFragment f11577b;

    /* renamed from: c */
    private BusinessContext f11578c;

    /* renamed from: d */
    private boolean f11579d;

    public void update(DialogInfo dialogInfo) {
    }

    private NormalDialog(BusinessContext businessContext, int i) {
        this.f11579d = false;
        this.f11576a = i;
        this.f11578c = businessContext;
    }

    public int getId() {
        return this.f11576a;
    }

    public void show() {
        this.f11579d = true;
        this.f11578c.getNavigation().showDialog(this.f11577b);
    }

    public boolean isShowing() {
        return this.f11579d;
    }

    public void dismiss() {
        this.f11578c.getNavigation().dismissDialog(this.f11577b);
        this.f11579d = false;
    }

    public boolean cancelable() {
        return this.f11577b.isCancelable();
    }

    public static class DialogBuilder {
        /* access modifiers changed from: private */
        public Integer mActionHappend;
        private BusinessContext mBizCtx;
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

        public DialogBuilder(BusinessContext businessContext) {
            this.mBizCtx = businessContext;
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
            NormalDialog normalDialog = new NormalDialog(this.mBizCtx, this.mDialogInfo.dialogId);
            AlertDialogFragment.Builder builder = new AlertDialogFragment.Builder(this.mBizCtx.getContext());
            builder.setCancelable(this.mDialogInfo.f11589j);
            builder.setIconVisible(this.mDialogInfo.f11588i);
            builder.setCloseVisible(this.mDialogInfo.f11590k);
            builder.setOnDismissListener(this.mDismissListener);
            builder.setSupprtMullineTitle(this.mDialogInfo.f11591l);
            if (this.mDialogInfo.f11580a != 0) {
                builder.setIcon(this.mDialogInfo.f11580a);
            }
            if (this.mDialogInfo.f11581b != null) {
                builder.setIcon(this.mDialogInfo.f11581b);
            }
            if (this.mDialogInfo.f11582c != null) {
                builder.setIcon(this.mDialogInfo.f11582c);
            }
            if (!TextUtils.isEmpty(this.mDialogInfo.f11583d)) {
                builder.setTitle(this.mDialogInfo.f11583d);
            }
            if (!TextUtils.isEmpty(this.mDialogInfo.f11584e)) {
                builder.setMessage(this.mDialogInfo.f11584e);
            }
            if (!TextUtils.isEmpty(this.mDialogInfo.f11585f)) {
                builder.setPositiveButton(this.mDialogInfo.f11585f, this.mPositiveListener);
                builder.setPositiveButtonDefault();
            }
            if (!TextUtils.isEmpty(this.mDialogInfo.f11587h)) {
                builder.setNegativeButton(this.mDialogInfo.f11587h, this.mNegativeListener);
            }
            if (!TextUtils.isEmpty(this.mDialogInfo.f11586g)) {
                builder.setNeutralButton(this.mDialogInfo.f11586g, this.mNeutralListener);
            }
            AlertDialogFragment unused = normalDialog.f11577b = builder.create();
            return normalDialog;
        }

        /* access modifiers changed from: private */
        public void handleOnClick(AlertDialogFragment alertDialogFragment, int i) {
            this.mActionHappend = Integer.valueOf(i);
            IDialog.DialogListener dialogListener = this.mListener;
            if (dialogListener != null) {
                dialogListener.onAction(i);
            }
            if (alertDialogFragment != null && alertDialogFragment.isAdded()) {
                this.mBizCtx.getNavigation().dismissDialog(alertDialogFragment);
            }
        }
    }
}
