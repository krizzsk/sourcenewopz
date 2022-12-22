package com.didi.rfusion.widget.dialog;

import android.os.Bundle;

public interface RFDialogInterface {

    public interface OnClickListener {
        void onClick(RFDialog rFDialog);
    }

    public interface OnDismissListener {
        void onDismiss(RFDialog rFDialog, Bundle bundle);
    }
}
