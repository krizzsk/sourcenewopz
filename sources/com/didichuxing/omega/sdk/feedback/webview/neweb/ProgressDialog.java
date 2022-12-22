package com.didichuxing.omega.sdk.feedback.webview.neweb;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class ProgressDialog extends AlertDialog {
    private Context mContext;

    public ProgressDialog(Context context) {
        super(context);
        this.mContext = context;
    }

    public ProgressDialog(Context context, int i) {
        super(context, i);
        this.mContext = context;
    }

    public static ProgressDialog show(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        SystemUtils.showDialog(progressDialog);
        return progressDialog;
    }

    public static ProgressDialog show(Context context, int i) {
        ProgressDialog progressDialog = new ProgressDialog(context, i);
        SystemUtils.showDialog(progressDialog);
        return progressDialog;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        setView(LayoutInflater.from(this.mContext).inflate(R.layout.layout_progress_dialog, (ViewGroup) null));
        super.onCreate(bundle);
    }

    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            int applyDimension = (int) TypedValue.applyDimension(1, 120.0f, this.mContext.getResources().getDisplayMetrics());
            window.setLayout(applyDimension, applyDimension);
        }
    }
}
