package com.didi.wallet.dimina;

import android.app.Activity;
import androidx.fragment.app.FragmentManager;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.mina.DefaultDMNavigator;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016J\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/wallet/dimina/DMNavigator;", "Lcom/didi/dimina/container/mina/DefaultDMNavigator;", "parentFragmentManager", "Landroidx/fragment/app/FragmentManager;", "childFragmentManager", "containerViewId", "", "activity", "Landroid/app/Activity;", "(Landroidx/fragment/app/FragmentManager;Landroidx/fragment/app/FragmentManager;ILandroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "closeDimina", "", "closePage", "", "navigateBack", "minaIndex", "stackIndex", "popCount", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DMNavigator.kt */
public final class DMNavigator extends DefaultDMNavigator {

    /* renamed from: a */
    private final FragmentManager f45168a;

    /* renamed from: b */
    private final Activity f45169b;

    public final Activity getActivity() {
        return this.f45169b;
    }

    public DMNavigator(FragmentManager fragmentManager, FragmentManager fragmentManager2, int i, Activity activity) {
        super(fragmentManager2, i);
        this.f45168a = fragmentManager;
        this.f45169b = activity;
    }

    public boolean navigateBack(int i, int i2, int i3) {
        boolean navigateBack = super.navigateBack(i, i2, i3);
        if (this.mPageStack.isEmpty() || DMMinaPool.size() == 0) {
            closePage();
        }
        return navigateBack;
    }

    public boolean closeDimina() {
        boolean closeDimina = super.closeDimina();
        if (this.mPageStack.isEmpty() || DMMinaPool.size() == 0) {
            closePage();
        }
        return closeDimina;
    }

    public final void closePage() {
        Activity activity = this.f45169b;
        if (activity != null) {
            activity.finish();
            return;
        }
        FragmentManager fragmentManager = this.f45168a;
        if (fragmentManager != null) {
            fragmentManager.popBackStack();
        }
    }
}
