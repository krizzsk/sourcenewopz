package com.didi.component.common.dialog;

import android.content.DialogInterface;
import com.didi.component.common.dialog.IDialog;
import com.didi.component.common.dialog.ToastDialogInfo;
import com.didi.component.core.dialog.DialogInfo;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BusinessContext;

public class ToastDialog implements IDialog {

    /* renamed from: a */
    private int f11592a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CustomToastDialog f11593b;

    private ToastDialog(int i) {
        this.f11592a = i;
    }

    public int getId() {
        return this.f11592a;
    }

    public void show() {
        CustomToastDialog customToastDialog = this.f11593b;
        if (customToastDialog != null && !customToastDialog.isShowing()) {
            SystemUtils.showDialog(this.f11593b);
        }
    }

    public boolean isShowing() {
        CustomToastDialog customToastDialog = this.f11593b;
        return customToastDialog != null && customToastDialog.isShowing();
    }

    public void dismiss() {
        CustomToastDialog customToastDialog = this.f11593b;
        if (customToastDialog != null && customToastDialog.isShowing()) {
            this.f11593b.dismiss();
        }
    }

    public void update(DialogInfo dialogInfo) {
        if (dialogInfo instanceof ToastDialogInfo) {
            ToastDialogInfo toastDialogInfo = (ToastDialogInfo) dialogInfo;
            this.f11593b.setCancelable(toastDialogInfo.cancelable);
            this.f11593b.setCanceledOnTouchOutside(toastDialogInfo.cancelable);
            if (toastDialogInfo.f11594a != null) {
                this.f11593b.setIcon(toastDialogInfo.f11594a);
            } else {
                ToastDialogInfo.IconType iconType = toastDialogInfo.f11595b;
            }
            this.f11593b.setMessage(toastDialogInfo.f11596c);
        }
    }

    public boolean cancelable() {
        return this.f11593b.isCancelable();
    }

    public static class DialogBuilder {
        private BusinessContext mBizCtx;
        private ToastDialogInfo mDialogInfo;
        /* access modifiers changed from: private */
        public IDialog.DialogListener mListener;

        public DialogBuilder(BusinessContext businessContext) {
            this.mBizCtx = businessContext;
        }

        public void setDialogInfo(ToastDialogInfo toastDialogInfo) {
            this.mDialogInfo = toastDialogInfo;
        }

        public void setListener(IDialog.DialogListener dialogListener) {
            this.mListener = dialogListener;
        }

        public ToastDialog build() {
            ToastDialog toastDialog = new ToastDialog(this.mDialogInfo.dialogId);
            CustomToastDialog unused = toastDialog.f11593b = new CustomToastDialog(this.mBizCtx.getContext());
            toastDialog.f11593b.setCancelable(this.mDialogInfo.cancelable);
            toastDialog.f11593b.setCanceledOnTouchOutside(this.mDialogInfo.cancelable);
            toastDialog.f11593b.setMessage(this.mDialogInfo.f11596c);
            toastDialog.f11593b.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    if (DialogBuilder.this.mListener != null) {
                        DialogBuilder.this.mListener.onAction(-1);
                    }
                }
            });
            return toastDialog;
        }
    }
}
