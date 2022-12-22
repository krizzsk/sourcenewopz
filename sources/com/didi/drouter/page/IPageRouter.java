package com.didi.drouter.page;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;

public interface IPageRouter {

    public interface IPageObserver {
        void onPageChange(IPageBean iPageBean, IPageBean iPageBean2);
    }

    void addPageObserver(IPageObserver iPageObserver, LifecycleOwner lifecycleOwner);

    Bundle execute(String str, Bundle bundle);

    IPageBean getCurPage();

    void popPage();

    void removePageObserver(IPageObserver iPageObserver);

    void showPage(IPageBean iPageBean);
}
