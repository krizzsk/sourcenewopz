package com.didi.drouter.page;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.collection.ArraySet;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.page.IPageBean;
import com.didi.drouter.page.IPageRouter;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import com.didi.drouter.utils.RouterLogger;
import com.taxis99.R;
import java.util.Set;

public abstract class RouterPageAbs implements IPageRouter {
    protected Bundle bundle = new Bundle();
    protected IPageBean currentPage = new IPageBean.EmptyPageBean();
    protected Set<IPageRouter.IPageObserver> observers = new ArraySet();

    public Bundle execute(String str, Bundle bundle2) {
        return null;
    }

    public void popPage() {
    }

    public IPageBean getCurPage() {
        return this.currentPage;
    }

    public void addPageObserver(final IPageRouter.IPageObserver iPageObserver, LifecycleOwner lifecycleOwner) {
        this.observers.add(iPageObserver);
        if (lifecycleOwner != null) {
            lifecycleOwner.getLifecycle().addObserver(new LifecycleObserver() {
                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                public void onDestroy(LifecycleOwner lifecycleOwner) {
                    RouterPageAbs.this.removePageObserver(iPageObserver);
                }
            });
        }
    }

    public void removePageObserver(IPageRouter.IPageObserver iPageObserver) {
        this.observers.remove(iPageObserver);
    }

    /* access modifiers changed from: protected */
    public void notifyPageChanged(IPageBean iPageBean) {
        if (!iPageBean.getPageUri().equals(this.currentPage.getPageUri())) {
            for (IPageRouter.IPageObserver onPageChange : this.observers) {
                onPageChange.onPageChange(this.currentPage, iPageBean);
            }
            this.currentPage = iPageBean;
        }
    }

    /* access modifiers changed from: protected */
    public Fragment newFragment(String str) {
        final Fragment[] fragmentArr = {null};
        DRouter.build(str).start((Context) null, new RouterCallback() {
            public void onResult(Result result) {
                fragmentArr[0] = result.getFragment();
            }
        });
        if (fragmentArr[0] != null) {
            return fragmentArr[0];
        }
        RouterLogger.getCoreLogger().mo59001e("PageRouter get null fragment with uri: \"%s\", StackTrace:\n %s", str, new Throwable());
        return new EmptyFragment();
    }

    /* access modifiers changed from: protected */
    public void addArgsForFragment(Fragment fragment, Bundle... bundleArr) {
        Bundle bundle2 = new Bundle();
        if (fragment.getArguments() != null) {
            bundle2.putAll(fragment.getArguments());
        }
        for (Bundle bundle3 : bundleArr) {
            if (bundle3 != null) {
                bundle2.putAll(bundle3);
            }
        }
        fragment.setArguments(bundle2);
    }

    public static class EmptyFragment extends Fragment {
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            TextView textView = new TextView(getContext());
            textView.setText(R.string.drouter_empty_fragment);
            return textView;
        }
    }
}
