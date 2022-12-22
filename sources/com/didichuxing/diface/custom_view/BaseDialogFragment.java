package com.didichuxing.diface.custom_view;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class BaseDialogFragment extends DialogFragment {

    /* renamed from: a */
    private Handler f47506a = new Handler(Looper.getMainLooper());

    public void show(final FragmentManager fragmentManager, final String str) {
        if (fragmentManager != null) {
            TextUtils.isEmpty(str);
            this.f47506a.removeCallbacksAndMessages((Object) null);
            this.f47506a.post(new Runnable() {
                public void run() {
                    Fragment findFragmentByTag;
                    if (!fragmentManager.isDestroyed() && (findFragmentByTag = fragmentManager.findFragmentByTag(str)) != BaseDialogFragment.this) {
                        if (findFragmentByTag != null && (findFragmentByTag instanceof DialogFragment)) {
                            ((DialogFragment) findFragmentByTag).dismissAllowingStateLoss();
                        }
                        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                        beginTransaction.add((Fragment) BaseDialogFragment.this, str);
                        beginTransaction.commitAllowingStateLoss();
                    }
                }
            });
            return;
        }
        throw new IllegalArgumentException("manager is null");
    }

    public void dismissAllowingStateLoss() {
        this.f47506a.removeCallbacksAndMessages((Object) null);
        this.f47506a.post(new Runnable() {
            public void run() {
                try {
                    BaseDialogFragment.super.dismissAllowingStateLoss();
                } catch (Exception unused) {
                }
            }
        });
    }

    public void dismiss() {
        dismissAllowingStateLoss();
    }
}
