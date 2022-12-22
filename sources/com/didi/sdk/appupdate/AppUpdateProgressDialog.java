package com.didi.sdk.appupdate;

import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.view.dialog.ProgressDialogFragment;

public class AppUpdateProgressDialog {

    /* renamed from: a */
    private static ProgressDialogFragment f35255a = new ProgressDialogFragment();

    public static synchronized void showDialog(FragmentActivity fragmentActivity, String str, boolean z) {
        synchronized (AppUpdateProgressDialog.class) {
            if (fragmentActivity != null) {
                try {
                    f35255a.setContent(str, z);
                    f35255a.show(fragmentActivity.getSupportFragmentManager(), (String) null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return;
    }

    public static synchronized void dismissProgressDialogFragmentSafely() {
        synchronized (AppUpdateProgressDialog.class) {
            if (f35255a.isAdded()) {
                try {
                    f35255a.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return;
    }
}
