package com.didichuxing.diface.biz.bioassay.fpp.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class DialogUtil {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f47229a;

    /* renamed from: b */
    private AlertDialog f47230b;

    public DialogUtil(Activity activity) {
        this.f47229a = activity;
    }

    public void showDialog(String str) {
        AlertDialog create = new AlertDialog.Builder(this.f47229a).setTitle(str).setNegativeButton(R.string.df_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                AutoTrackHelper.trackViewOnClick(dialogInterface, i);
                DialogUtil.this.f47229a.finish();
            }
        }).setCancelable(false).create();
        this.f47230b = create;
        SystemUtils.showDialog(create);
    }

    public void onDestory() {
        AlertDialog alertDialog = this.f47230b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.f47229a = null;
    }
}
