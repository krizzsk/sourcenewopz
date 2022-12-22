package com.didi.safetoolkit.dialog;

import android.os.Build;
import androidx.fragment.app.FragmentActivity;

public class LoadingProgressDialog {

    /* renamed from: a */
    private static DiDiLoadingDialog f34520a;

    /* renamed from: a */
    private static boolean m24378a(FragmentActivity fragmentActivity) {
        if (Build.VERSION.SDK_INT <= 17) {
            return !fragmentActivity.isFinishing();
        }
        if (fragmentActivity.isFinishing() || fragmentActivity.isDestroyed()) {
            return false;
        }
        return true;
    }

    public static synchronized void showDialog(FragmentActivity fragmentActivity, String str, boolean z) {
        synchronized (LoadingProgressDialog.class) {
            dismissProgressDialogFragmentSafely();
            if (f34520a == null) {
                f34520a = new DiDiLoadingDialog(fragmentActivity);
            }
            f34520a.showLoadingDialog(z, str);
        }
    }

    public static synchronized void dismissProgressDialogFragmentSafely() {
        synchronized (LoadingProgressDialog.class) {
            if (f34520a != null) {
                f34520a.removeLoadingDialog();
                f34520a = null;
            }
        }
    }
}
