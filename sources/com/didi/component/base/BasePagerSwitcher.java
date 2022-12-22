package com.didi.component.base;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.didi.component.core.Animations;
import com.didi.component.core.IPageSwitcher;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.INavigation;
import java.lang.ref.WeakReference;

public class BasePagerSwitcher implements IPageSwitcher {

    /* renamed from: a */
    private WeakReference<BusinessContext> f10980a;

    /* renamed from: b */
    private final WeakReference<Fragment> f10981b;

    public BasePagerSwitcher(BusinessContext businessContext, Fragment fragment) {
        WeakReference<Fragment> weakReference = null;
        this.f10980a = businessContext != null ? new WeakReference<>(businessContext) : null;
        this.f10981b = fragment != null ? new WeakReference<>(fragment) : weakReference;
    }

    public boolean forward(Class<? extends Fragment> cls, Bundle bundle) {
        return forward(cls, bundle, (Animations) null);
    }

    public boolean forward(Class<? extends Fragment> cls, Bundle bundle, Animations animations) {
        WeakReference<BusinessContext> weakReference = this.f10980a;
        BusinessContext businessContext = weakReference != null ? (BusinessContext) weakReference.get() : null;
        if (businessContext == null) {
            return false;
        }
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!bundle.containsKey(INavigation.BUNDLE_KEY_MAP_NEED)) {
            bundle.putBoolean(INavigation.BUNDLE_KEY_MAP_NEED, true);
        }
        intent.putExtras(bundle);
        intent.setClass(businessContext.getContext(), cls);
        if (animations == null) {
            animations = new Animations();
        }
        businessContext.getNavigation().transition(businessContext, intent, new INavigation.TransactionAnimation(animations.enterAnim(), animations.exitAnim(), animations.enterPopAnim(), animations.exitPopAnim()));
        return true;
    }

    public boolean forward(Intent intent) {
        return forward(intent, (Animations) null);
    }

    public boolean forward(Intent intent, Animations animations) {
        WeakReference<BusinessContext> weakReference = this.f10980a;
        BusinessContext businessContext = weakReference != null ? (BusinessContext) weakReference.get() : null;
        if (businessContext == null) {
            return false;
        }
        if (animations == null) {
            animations = new Animations();
        }
        businessContext.getNavigation().transition(businessContext, intent, new INavigation.TransactionAnimation(animations.enterAnim(), animations.exitAnim(), animations.enterPopAnim(), animations.exitPopAnim()));
        return true;
    }

    public boolean goBack() {
        return goBack((Bundle) null);
    }

    public boolean goBack(Bundle bundle) {
        WeakReference<BusinessContext> weakReference = this.f10980a;
        BusinessContext businessContext = weakReference != null ? (BusinessContext) weakReference.get() : null;
        if (businessContext == null) {
            return false;
        }
        if (bundle == null) {
            businessContext.getNavigation().popBackStack();
            return true;
        }
        businessContext.getNavigation().popBackStack(bundle);
        return true;
    }

    public boolean goBackRoot() {
        return goBackRoot((Bundle) null);
    }

    public boolean goBackRoot(Bundle bundle) {
        WeakReference<BusinessContext> weakReference = this.f10980a;
        BusinessContext businessContext = weakReference != null ? (BusinessContext) weakReference.get() : null;
        if (businessContext == null) {
            return false;
        }
        if (bundle == null) {
            businessContext.getNavigation().popBackStack(2);
            return true;
        }
        businessContext.getNavigation().popBackStack(2, bundle);
        return true;
    }

    public Fragment getHost() {
        WeakReference<Fragment> weakReference = this.f10981b;
        if (weakReference != null) {
            return (Fragment) weakReference.get();
        }
        return null;
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        WeakReference<Fragment> weakReference = this.f10981b;
        Fragment fragment = weakReference != null ? (Fragment) weakReference.get() : null;
        if (fragment != null) {
            fragment.startActivityForResult(intent, i, bundle);
        }
    }

    public void updateBusinessContext(BusinessContext businessContext) {
        this.f10980a = businessContext != null ? new WeakReference<>(businessContext) : null;
    }
}
