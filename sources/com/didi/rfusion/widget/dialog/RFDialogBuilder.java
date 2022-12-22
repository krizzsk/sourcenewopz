package com.didi.rfusion.widget.dialog;

import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogBuilder;
import com.didi.rfusion.widget.dialog.RFDialogInterface;

public abstract class RFDialogBuilder<B extends RFDialogBuilder, D extends RFDialog> {
    private final RFDialogModel dialogModel = new RFDialogModel();

    /* access modifiers changed from: protected */
    public abstract D createDialog();

    public B setTitle(String str) {
        this.dialogModel.setTitle(str);
        return this;
    }

    public B setBanner(String str) {
        this.dialogModel.setBannerUrl(str);
        return this;
    }

    public B setBanner(int i) {
        this.dialogModel.setBannerRes(i);
        return this;
    }

    public B setMainAction(String str, RFDialogInterface.OnClickListener onClickListener) {
        this.dialogModel.setMainAction(new RFDialog.ActionModel(str, onClickListener));
        return this;
    }

    public B setSubAction1(String str, RFDialogInterface.OnClickListener onClickListener) {
        this.dialogModel.setSubAction1(new RFDialog.ActionModel(str, onClickListener));
        return this;
    }

    public B setSubAction2(String str, RFDialogInterface.OnClickListener onClickListener) {
        this.dialogModel.setSubAction2(new RFDialog.ActionModel(str, onClickListener));
        return this;
    }

    public B setCancelable(boolean z) {
        this.dialogModel.setCancelable(z);
        return this;
    }

    public B setCloseable(boolean z) {
        this.dialogModel.setCloseable(z);
        return this;
    }

    public B setCloseable(boolean z, RFDialogInterface.OnClickListener onClickListener) {
        this.dialogModel.setCloseable(new RFDialog.CloseModel(z, onClickListener));
        return this;
    }

    public B setAutoDismiss(boolean z) {
        this.dialogModel.setAutoDismiss(z);
        return this;
    }

    public D create() {
        D createDialog = createDialog();
        createDialog.mo87706a(this.dialogModel);
        return createDialog;
    }
}
