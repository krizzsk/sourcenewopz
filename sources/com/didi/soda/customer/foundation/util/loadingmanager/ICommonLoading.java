package com.didi.soda.customer.foundation.util.loadingmanager;

import android.view.View;
import com.didi.app.nova.skeleton.ScopeContext;

public interface ICommonLoading {
    void hideBlockLoading();

    void hideLoading();

    boolean isLoading();

    void setLoadingView(ScopeContext scopeContext, View view, View view2);

    void setLoadingViewContain(View view);

    void showBlockLoading();

    void showLoading(boolean z);
}
