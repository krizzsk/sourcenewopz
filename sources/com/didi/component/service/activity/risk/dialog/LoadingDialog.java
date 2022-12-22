package com.didi.component.service.activity.risk.dialog;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.component.common.dialog.IDialog;
import com.didi.component.core.dialog.DialogInfo;
import com.didi.sdk.view.dialog.ProgressDialogFragment;

public class LoadingDialog implements IDialog {

    /* renamed from: a */
    private int f15698a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public FragmentActivity f15699b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CancelableProgressDialogFragment f15700c;

    /* renamed from: d */
    private boolean f15701d;

    private LoadingDialog(int i) {
        this.f15701d = false;
        this.f15698a = i;
    }

    public int getId() {
        return this.f15698a;
    }

    public void show() {
        FragmentActivity fragmentActivity = this.f15699b;
        if (fragmentActivity != null && fragmentActivity.getSupportFragmentManager() != null) {
            this.f15701d = true;
            CancelableProgressDialogFragment cancelableProgressDialogFragment = this.f15700c;
            FragmentManager supportFragmentManager = this.f15699b.getSupportFragmentManager();
            cancelableProgressDialogFragment.show(supportFragmentManager, this.f15698a + "");
        }
    }

    public boolean isShowing() {
        return this.f15701d;
    }

    public void dismiss() {
        this.f15701d = false;
        this.f15700c.dismissAllowingStateLoss();
    }

    public void update(DialogInfo dialogInfo) {
        if (dialogInfo instanceof LoadingDialogInfo) {
            LoadingDialogInfo loadingDialogInfo = (LoadingDialogInfo) dialogInfo;
            this.f15700c.setContent(loadingDialogInfo.getMessage(), loadingDialogInfo.cancelable);
        }
    }

    public boolean cancelable() {
        return this.f15700c.isCancelable();
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

    public static final class DialogBuilder {
        private FragmentActivity mContext;
        private LoadingDialogInfo mDialogInfo;
        private IDialog.DialogListener mListener;

        public DialogBuilder(FragmentActivity fragmentActivity) {
            this.mContext = fragmentActivity;
        }

        public void setDialogInfo(LoadingDialogInfo loadingDialogInfo) {
            this.mDialogInfo = loadingDialogInfo;
        }

        public void setListener(IDialog.DialogListener dialogListener) {
            this.mListener = dialogListener;
        }

        public LoadingDialog build() {
            LoadingDialog loadingDialog = new LoadingDialog(this.mDialogInfo.dialogId);
            FragmentActivity unused = loadingDialog.f15699b = this.mContext;
            CancelableProgressDialogFragment unused2 = loadingDialog.f15700c = new CancelableProgressDialogFragment();
            loadingDialog.f15700c.setContent(this.mDialogInfo.getMessage(), this.mDialogInfo.cancelable);
            loadingDialog.f15700c.setCancelable(this.mDialogInfo.cancelable);
            loadingDialog.f15700c.setDialogListener(this.mListener);
            return loadingDialog;
        }
    }
}
