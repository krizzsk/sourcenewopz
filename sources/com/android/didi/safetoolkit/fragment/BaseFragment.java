package com.android.didi.safetoolkit.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.android.didi.safetoolkit.observer.action.ActionObserverCompat;
import com.android.didi.safetoolkit.observer.action.IActionObservable;
import com.android.didi.safetoolkit.observer.action.IActionObserver;
import com.android.didi.safetoolkit.observer.lifecycle.ILifecycleObservable;
import com.android.didi.safetoolkit.observer.lifecycle.ILifecycleObserver;
import com.android.didi.safetoolkit.observer.lifecycle.LifecycleObserverCompat;
import com.didi.global.loading.app.AbsLoadingFragment;

public abstract class BaseFragment extends AbsLoadingFragment implements IActionObservable, IActionObserver, ILifecycleObservable {
    private ActionObserverCompat mActionObserverCompat = new ActionObserverCompat();
    protected Activity mActivity;
    private LifecycleObserverCompat mLifeObserverCompat = new LifecycleObserverCompat();
    private View root;

    /* access modifiers changed from: protected */
    public abstract void findViews();

    /* access modifiers changed from: protected */
    public abstract int getLayoutRes();

    /* access modifiers changed from: protected */
    public abstract void initData();

    /* access modifiers changed from: protected */
    public abstract void initObjects();

    /* access modifiers changed from: protected */
    public boolean isAutoCall() {
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract void parseBundle(Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract void setListener();

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(getLayoutRes(), viewGroup, false);
        this.root = inflate;
        return inflate;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (isAutoCall()) {
            parseBundle(getArguments());
            findViews();
            initObjects();
            initData();
            setListener();
        }
        this.mLifeObserverCompat.onCreate();
    }

    public final void addLifecycleObserver(ILifecycleObserver iLifecycleObserver) {
        this.mLifeObserverCompat.addLifecycleObserver(iLifecycleObserver);
    }

    public final boolean removeLifecycleObserver(ILifecycleObserver iLifecycleObserver) {
        return this.mLifeObserverCompat.removeLifecycleObserver(iLifecycleObserver);
    }

    public void addActionObserver(IActionObserver iActionObserver) {
        this.mActionObserverCompat.addActionObserver(iActionObserver);
    }

    public boolean removeActionObserver(IActionObserver iActionObserver) {
        return this.mActionObserverCompat.removeActionObserver(iActionObserver);
    }

    public final <T extends View> T findViewById(int i) {
        return this.root.findViewById(i);
    }

    public String getTitle() {
        return getClass().getSimpleName();
    }

    public void onStart() {
        super.onStart();
        this.mLifeObserverCompat.onStart();
    }

    public void onResume() {
        super.onResume();
        this.mLifeObserverCompat.onResume();
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            removeParentActionObserver();
        } else {
            addParentActionObserver();
        }
        this.mLifeObserverCompat.onHiddenChanged(z);
    }

    public void onPause() {
        super.onPause();
        this.mLifeObserverCompat.onPause();
    }

    public void onStop() {
        super.onStop();
        this.mLifeObserverCompat.onStop();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mLifeObserverCompat.onDestroy();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = getActivity();
        addParentActionObserver();
    }

    public void onDetach() {
        removeParentActionObserver();
        super.onDetach();
        this.mActivity = null;
    }

    /* access modifiers changed from: protected */
    public void addParentActionObserver() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof IActionObservable) {
            ((IActionObservable) parentFragment).addActionObserver(this);
            return;
        }
        Activity activity = this.mActivity;
        if (activity instanceof IActionObservable) {
            ((IActionObservable) activity).addActionObserver(this);
        }
    }

    /* access modifiers changed from: protected */
    public void removeParentActionObserver() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof IActionObservable) {
            ((IActionObservable) parentFragment).removeActionObserver(this);
            return;
        }
        Activity activity = this.mActivity;
        if (activity instanceof IActionObservable) {
            ((IActionObservable) activity).removeActionObserver(this);
        }
    }

    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.mActionObserverCompat.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        this.mActionObserverCompat.onBackPressed();
    }
}
