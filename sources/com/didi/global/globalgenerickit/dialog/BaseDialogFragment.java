package com.didi.global.globalgenerickit.dialog;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public abstract class BaseDialogFragment extends DialogFragment {

    /* renamed from: a */
    private Handler f22057a = new Handler(Looper.getMainLooper());

    public void show(final FragmentManager fragmentManager, final String str) {
        if (TextUtils.isEmpty(str)) {
            str = "__didi_dialog";
        }
        this.f22057a.post(new Runnable() {
            public void run() {
                Fragment findFragmentByTag;
                FragmentManager fragmentManager = fragmentManager;
                if (fragmentManager != null && !fragmentManager.isDestroyed() && (findFragmentByTag = fragmentManager.findFragmentByTag(str)) != BaseDialogFragment.this) {
                    if (findFragmentByTag != null && (findFragmentByTag instanceof DialogFragment)) {
                        ((DialogFragment) findFragmentByTag).dismissAllowingStateLoss();
                    }
                    FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                    beginTransaction.add((Fragment) BaseDialogFragment.this, str);
                    beginTransaction.commitAllowingStateLoss();
                }
            }
        });
    }

    public void dismissAllowingStateLoss() {
        this.f22057a.removeCallbacksAndMessages((Object) null);
        this.f22057a.post(new Runnable() {
            public void run() {
                try {
                    BaseDialogFragment.super.dismissAllowingStateLoss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void dismiss() {
        dismissAllowingStateLoss();
    }
}
