package com.didi.onekeyshare.view;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;

public class ProgressDialogUtil {

    /* renamed from: a */
    private DownloadProgressDialogFragment f29781a;

    public void showDialogLoading(Context context) {
        showDialogLoading(context, (String) null);
    }

    public void showDialogLoading(Context context, String str) {
        if (this.f29781a != null) {
            dismissDialog();
        }
        if (context instanceof FragmentActivity) {
            DownloadProgressDialogFragment downloadProgressDialogFragment = new DownloadProgressDialogFragment();
            this.f29781a = downloadProgressDialogFragment;
            downloadProgressDialogFragment.setContent(str);
            this.f29781a.setCancelable(false);
            this.f29781a.show(((FragmentActivity) context).getSupportFragmentManager(), "loading");
        }
    }

    public void dismissDialog() {
        DownloadProgressDialogFragment downloadProgressDialogFragment = this.f29781a;
        if (downloadProgressDialogFragment != null) {
            downloadProgressDialogFragment.dismiss();
            this.f29781a = null;
        }
    }
}
