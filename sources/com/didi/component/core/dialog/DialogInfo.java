package com.didi.component.core.dialog;

public abstract class DialogInfo {
    public boolean cancelable;
    public int dialogId;

    protected DialogInfo(int i) {
        this.dialogId = i;
    }

    public int getDialogId() {
        return this.dialogId;
    }

    public void setDialogId(int i) {
        this.dialogId = i;
    }

    public DialogInfo setCancelable(boolean z) {
        this.cancelable = z;
        return this;
    }
}
