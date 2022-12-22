package com.android.didi.safetoolkit.widget.progressbar;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class ProgressDialog extends AlertDialog {
    private TextView mMessage;
    private ProgressBar mProgress;

    public ProgressDialog(Context context) {
        super(context);
        init();
    }

    public ProgressDialog(Context context, int i) {
        super(context, i);
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.progress_dialog_layout, (ViewGroup) null);
        this.mProgress = (ProgressBar) inflate.findViewById(R.id.progress_bar);
        this.mMessage = (TextView) inflate.findViewById(R.id.message_text);
        this.mProgress.setIndeterminate(true);
        setView(inflate);
    }

    public static ProgressDialog show(Context context, CharSequence charSequence, CharSequence charSequence2) {
        return show(context, charSequence, charSequence2, false, (DialogInterface.OnCancelListener) null);
    }

    public static ProgressDialog show(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z) {
        return show(context, charSequence, charSequence2, z, (DialogInterface.OnCancelListener) null);
    }

    public static ProgressDialog show(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(charSequence);
        progressDialog.setMessage(charSequence2);
        progressDialog.setCancelable(z);
        progressDialog.setOnCancelListener(onCancelListener);
        SystemUtils.showDialog(progressDialog);
        return progressDialog;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mProgress.getIndeterminateDrawable().setColorFilter(getContext().getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
    }

    public void setMessage(CharSequence charSequence) {
        if (this.mProgress != null) {
            this.mMessage.setText(charSequence);
        }
    }
}
