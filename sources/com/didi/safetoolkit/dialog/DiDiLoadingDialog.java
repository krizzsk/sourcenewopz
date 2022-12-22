package com.didi.safetoolkit.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.didi.safetoolkit.util.SfStringGetter;
import com.taxis99.R;

public class DiDiLoadingDialog {

    /* renamed from: a */
    private Context f34514a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f34515b = false;

    /* renamed from: c */
    private DiDiProgressDialog f34516c;

    /* renamed from: d */
    private DialogInterface.OnCancelListener f34517d = new DialogInterface.OnCancelListener() {
        public void onCancel(DialogInterface dialogInterface) {
            boolean unused = DiDiLoadingDialog.this.f34515b = false;
        }
    };

    public DiDiLoadingDialog(Context context) {
        this.f34514a = context;
    }

    public void showLoadingDialog(boolean z) {
        try {
            showLoadingDialog(z, SfStringGetter.getString(R.string.sf_loading));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showLoadingDialog(boolean z, String str) {
        try {
            if (this.f34516c != null) {
                this.f34516c.dismiss();
                this.f34516c = null;
            }
            DiDiProgressDialog diDiProgressDialog = new DiDiProgressDialog(this.f34514a);
            this.f34516c = diDiProgressDialog;
            diDiProgressDialog.setOnCancelListener(this.f34517d);
            this.f34516c.showDialog(z, str);
            this.f34515b = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeLoadingDialog() {
        try {
            if (this.f34516c != null) {
                this.f34516c.dismiss();
                this.f34516c = null;
                this.f34514a = null;
            }
        } catch (Exception unused) {
        }
        this.f34516c = null;
        this.f34515b = false;
    }

    public boolean isLoading() {
        return this.f34515b;
    }
}
