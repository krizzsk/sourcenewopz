package com.didi.soda.search.component.base;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.customer.listener.LoadingViewSupporter;
import com.didi.soda.search.component.header.SearchHeaderInterface;

public abstract class AbsSearchResultComponent<V extends IView, P extends IPresenter> extends MvpComponent {
    public abstract void setLoadingViewSupporter(LoadingViewSupporter loadingViewSupporter);

    public abstract void setSearchHeaderInterface(SearchHeaderInterface searchHeaderInterface);

    public AbsSearchResultComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }
}
