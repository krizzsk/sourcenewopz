package com.didi.sdk.fastframe.view.dialog;

import android.content.DialogInterface;
import android.os.Bundle;

public class ProgressDialogFragment extends com.didi.sdk.view.dialog.ProgressDialogFragment {

    /* renamed from: b */
    private static final String f35927b = "message";

    /* renamed from: a */
    private DialogInterface.OnCancelListener f35928a = null;

    /* renamed from: c */
    private String f35929c;

    public void setContent(String str, boolean z) {
        this.f35929c = str;
        setCancelable(z);
        super.setContent(str, z);
    }

    public void setmCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.f35928a = onCancelListener;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("message", this.f35929c);
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        m25440a(bundle);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m25440a(bundle);
    }

    /* renamed from: a */
    private void m25440a(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("message");
            this.f35929c = string;
            super.setContent(string, isCancelable());
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnCancelListener onCancelListener = this.f35928a;
        if (onCancelListener != null) {
            onCancelListener.onCancel(getDialog());
        }
    }
}
