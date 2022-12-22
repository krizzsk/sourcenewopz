package com.didi.beatles.p099im.views.dialog;

import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/* renamed from: com.didi.beatles.im.views.dialog.IMBaseDialogFragment */
public abstract class IMBaseDialogFragment extends DialogFragment {

    /* renamed from: a */
    private Handler f10180a = new Handler(Looper.getMainLooper());

    public void show(final FragmentManager fragmentManager, final String str) {
        if (fragmentManager != null) {
            this.f10180a.removeCallbacksAndMessages((Object) null);
            this.f10180a.post(new Runnable() {
                public void run() {
                    Fragment findFragmentByTag;
                    if (!fragmentManager.isDestroyed() && (findFragmentByTag = fragmentManager.findFragmentByTag(str)) != IMBaseDialogFragment.this) {
                        if (findFragmentByTag != null && (findFragmentByTag instanceof DialogFragment)) {
                            ((DialogFragment) findFragmentByTag).dismissAllowingStateLoss();
                        }
                        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                        beginTransaction.add((Fragment) IMBaseDialogFragment.this, str);
                        beginTransaction.commitAllowingStateLoss();
                    }
                }
            });
            return;
        }
        throw new IllegalArgumentException("manager is null");
    }

    public void dismissAllowingStateLoss() {
        this.f10180a.removeCallbacksAndMessages((Object) null);
        this.f10180a.post(new Runnable() {
            public void run() {
                try {
                    IMBaseDialogFragment.super.dismissAllowingStateLoss();
                } catch (Exception unused) {
                }
            }
        });
    }

    public void dismiss() {
        dismissAllowingStateLoss();
    }
}
