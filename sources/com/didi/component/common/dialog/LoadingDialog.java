package com.didi.component.common.dialog;

import android.content.DialogInterface;
import com.didi.component.common.dialog.IDialog;
import com.didi.component.core.dialog.DialogInfo;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.view.dialog.ProgressDialogFragment;

class LoadingDialog implements IDialog {

    /* renamed from: a */
    private int f11568a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public BusinessContext f11569b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CancelableProgressDialogFragment f11570c;

    /* renamed from: d */
    private boolean f11571d;

    private LoadingDialog(int i) {
        this.f11571d = false;
        this.f11568a = i;
    }

    public int getId() {
        return this.f11568a;
    }

    public void show() {
        this.f11571d = true;
        this.f11569b.getNavigation().showDialog(this.f11570c);
    }

    public boolean isShowing() {
        return this.f11571d;
    }

    public void dismiss() {
        this.f11569b.getNavigation().dismissDialog(this.f11570c);
        this.f11571d = false;
    }

    public void update(DialogInfo dialogInfo) {
        if (dialogInfo instanceof LoadingDialogInfo) {
            LoadingDialogInfo loadingDialogInfo = (LoadingDialogInfo) dialogInfo;
            this.f11570c.setContent(loadingDialogInfo.f11572a, loadingDialogInfo.cancelable);
        }
    }

    public boolean cancelable() {
        return this.f11570c.isCancelable();
    }

    public static final class DialogBuilder {
        private BusinessContext mBizCtx;
        private LoadingDialogInfo mDialogInfo;
        private IDialog.DialogListener mListener;

        public DialogBuilder(BusinessContext businessContext) {
            this.mBizCtx = businessContext;
        }

        public void setDialogInfo(LoadingDialogInfo loadingDialogInfo) {
            this.mDialogInfo = loadingDialogInfo;
        }

        public void setListener(IDialog.DialogListener dialogListener) {
            this.mListener = dialogListener;
        }

        public LoadingDialog build() {
            LoadingDialog loadingDialog = new LoadingDialog(this.mDialogInfo.dialogId);
            BusinessContext unused = loadingDialog.f11569b = this.mBizCtx;
            CancelableProgressDialogFragment unused2 = loadingDialog.f11570c = new CancelableProgressDialogFragment();
            loadingDialog.f11570c.setContent(this.mDialogInfo.f11572a, this.mDialogInfo.cancelable);
            loadingDialog.f11570c.setCancelable(this.mDialogInfo.cancelable);
            loadingDialog.f11570c.setDialogListener(this.mListener);
            return loadingDialog;
        }
    }

    public static class CancelableProgressDialogFragment extends ProgressDialogFragment {
        private IDialog.DialogListener mListener;

        public void setDialogListener(IDialog.DialogListener dialogListener) {
            this.mListener = dialogListener;
        }

        public void onCancel(DialogInterface dialogInterface) {
            IDialog.DialogListener dialogListener = this.mListener;
            if (dialogListener != null) {
                dialogListener.onAction(1);
            }
        }
    }
}
