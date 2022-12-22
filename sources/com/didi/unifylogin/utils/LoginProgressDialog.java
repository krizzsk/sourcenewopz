package com.didi.unifylogin.utils;

import androidx.fragment.app.FragmentActivity;
import com.didi.unifylogin.base.view.ProgressDialogFragment;

public class LoginProgressDialog {

    /* renamed from: a */
    private static ProgressDialogFragment f44938a;

    public static synchronized void showDialog(FragmentActivity fragmentActivity, String str, boolean z) {
        synchronized (LoginProgressDialog.class) {
            if (fragmentActivity != null) {
                if (f44938a == null) {
                    f44938a = new ProgressDialogFragment();
                }
                if (!f44938a.isAdded()) {
                    try {
                        f44938a.setContent(str, z);
                        f44938a.show(fragmentActivity.getSupportFragmentManager(), (String) null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        return;
    }

    public static synchronized void dismissProgressDialogFragmentSafely() {
        synchronized (LoginProgressDialog.class) {
            try {
                if (f44938a != null) {
                    f44938a.dismiss();
                }
                f44938a = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return;
    }
}
