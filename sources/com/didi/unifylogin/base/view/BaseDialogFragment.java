package com.didi.unifylogin.base.view;

import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didi/unifylogin/base/view/BaseDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "handler", "Landroid/os/Handler;", "dismiss", "", "dismissAllowingStateLoss", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "OneLogin_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: BaseDialogFragment.kt */
public abstract class BaseDialogFragment extends DialogFragment {

    /* renamed from: a */
    private final Handler f44715a = new Handler(Looper.getMainLooper());

    public void show(FragmentManager fragmentManager, String str) {
        Intrinsics.checkParameterIsNotNull(fragmentManager, "manager");
        this.f44715a.removeCallbacksAndMessages((Object) null);
        this.f44715a.post(new BaseDialogFragment$show$1(this, fragmentManager, str));
    }

    public void dismissAllowingStateLoss() {
        this.f44715a.removeCallbacksAndMessages((Object) null);
        this.f44715a.post(new BaseDialogFragment$dismissAllowingStateLoss$1(this));
    }

    public void dismiss() {
        dismissAllowingStateLoss();
    }
}
