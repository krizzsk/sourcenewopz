package com.didi.nova.assembly.components.recyclerview;

import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.app.nova.support.view.recyclerview.data.BaseDataManager;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataItemManager;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.nova.assembly.components.recyclerview.BaseRecyclerView;
import java.util.List;

public abstract class BaseRecyclerPresenter<V extends BaseRecyclerView> extends IPresenter<V> {
    private NovaRecyclerAdapter mNovaRecyclerAdapter;

    /* access modifiers changed from: protected */
    public abstract void initDataManagers();

    public void onCreate() {
        super.onCreate();
        this.mNovaRecyclerAdapter = ((BaseRecyclerView) getLogicView()).getNovaRecyclerAdapter();
        initDataManagers();
    }

    /* access modifiers changed from: protected */
    public final <T> ChildDataItemManager<T> createChildDataItemManager() {
        return new ChildDataItemManager<>(this.mNovaRecyclerAdapter);
    }

    /* access modifiers changed from: protected */
    public final <T> ChildDataItemManager<T> createChildDataItemManager(T t) {
        return new ChildDataItemManager<>(this.mNovaRecyclerAdapter, t);
    }

    /* access modifiers changed from: protected */
    public final <T> ChildDataListManager<T> createChildDataListManager() {
        return new ChildDataListManager<>(this.mNovaRecyclerAdapter);
    }

    /* access modifiers changed from: protected */
    public final <T> ChildDataListManager<T> createChildDataListManager(List<T> list) {
        return new ChildDataListManager<>(this.mNovaRecyclerAdapter, list);
    }

    public final void addDataManager(BaseDataManager baseDataManager) {
        this.mNovaRecyclerAdapter.addDataManager(baseDataManager);
    }

    public final void addDataManagers(BaseDataManager... baseDataManagerArr) {
        this.mNovaRecyclerAdapter.addDataManagers(baseDataManagerArr);
    }

    public final void addDataManagers(List<BaseDataManager> list) {
        this.mNovaRecyclerAdapter.addDataManagers(list);
    }

    public final void addFootDataManager(BaseDataManager baseDataManager) {
        this.mNovaRecyclerAdapter.addFootDataManager(baseDataManager);
    }

    public final void clearDataManagers() {
        this.mNovaRecyclerAdapter.clearDataManagers();
    }

    public final <T> T getItem(int i) {
        return this.mNovaRecyclerAdapter.getItem(i);
    }
}
