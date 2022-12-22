package com.didi.global.globaluikit.dialog;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public abstract class LEGOBaseDialogFragment extends DialogFragment {

    /* renamed from: a */
    private Handler f22478a = new Handler(Looper.getMainLooper());

    public void show(final FragmentManager fragmentManager, final String str) {
        if (TextUtils.isEmpty(str)) {
            str = "__didi_dialog";
        }
        this.f22478a.post(new Runnable() {
            public void run() {
                Fragment findFragmentByTag;
                FragmentManager fragmentManager = fragmentManager;
                if (fragmentManager != null && !fragmentManager.isDestroyed() && (findFragmentByTag = fragmentManager.findFragmentByTag(str)) != LEGOBaseDialogFragment.this) {
                    if (findFragmentByTag instanceof DialogFragment) {
                        ((DialogFragment) findFragmentByTag).dismissAllowingStateLoss();
                    }
                    FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                    try {
                        beginTransaction.add((Fragment) LEGOBaseDialogFragment.this, str);
                        beginTransaction.commitAllowingStateLoss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void dismissAllowingStateLoss() {
        this.f22478a.removeCallbacksAndMessages((Object) null);
        this.f22478a.post(new Runnable() {
            public void run() {
                try {
                    LEGOBaseDialogFragment.super.dismissAllowingStateLoss();
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
