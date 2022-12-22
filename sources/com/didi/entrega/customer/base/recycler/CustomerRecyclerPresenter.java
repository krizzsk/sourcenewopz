package com.didi.entrega.customer.base.recycler;

import com.didi.app.nova.support.view.recyclerview.data.ChildDataItemManager;
import com.didi.entrega.customer.app.ComponentLogicProvider;
import com.didi.entrega.customer.base.binder.ComponentLogicUnit;
import com.didi.entrega.customer.base.recycler.CustomerRecyclerView;
import com.didi.entrega.customer.component.feed.base.FooterViewIPresenter;
import com.didi.entrega.customer.component.feed.base.HeaderViewIPresenter;
import com.didi.entrega.customer.mvp.loadmore.LoadMoreModel;
import com.didi.nova.assembly.components.recyclerview.BaseRecyclerPresenter;

public abstract class CustomerRecyclerPresenter<V extends CustomerRecyclerView> extends BaseRecyclerPresenter<V> implements ComponentLogicProvider, FooterViewIPresenter, HeaderViewIPresenter {
    private ChildDataItemManager<LoadMoreModel> mLoadMoreDataItemManager;
    private LoadMoreModel mLoadMoreModel;
    private ComponentLogicUnit mLogicUnit;

    public void onFooterErrorClicked() {
    }

    public void onFooterNoMoreClicked() {
    }

    public void onFooterSignInClicked() {
    }

    public void onLoadMore() {
    }

    public void onPullTargetMove(int i) {
    }

    public void onPullToRefresh() {
    }

    public ComponentLogicUnit provideComponentLogicUnit() {
        return null;
    }

    public void generateLoadMoreModel() {
        this.mLoadMoreModel = new LoadMoreModel(getContext());
    }

    public ComponentLogicUnit getComponentLogicUnit() {
        return this.mLogicUnit;
    }

    public LoadMoreModel getLoadMoreModel() {
        return this.mLoadMoreModel;
    }

    public void initDataManagers() {
        LoadMoreModel loadMoreModel = this.mLoadMoreModel;
        if (loadMoreModel != null) {
            ChildDataItemManager<LoadMoreModel> createChildDataItemManager = createChildDataItemManager(loadMoreModel);
            this.mLoadMoreDataItemManager = createChildDataItemManager;
            addFootDataManager(createChildDataItemManager);
        }
    }

    public void onCreate() {
        super.onCreate();
        ComponentLogicUnit provideComponentLogicUnit = provideComponentLogicUnit();
        this.mLogicUnit = provideComponentLogicUnit;
        if (provideComponentLogicUnit != null) {
            provideComponentLogicUnit.onBindLogic();
        }
    }

    public void showFooterBottomStubView(int i) {
        this.mLoadMoreModel.mIsBottomStubShow = true;
        this.mLoadMoreModel.mStubHeight = i;
        updateLoadMoreModelData();
    }

    public void hideFooterBottomStubView() {
        if (this.mLoadMoreModel.mIsBottomStubShow) {
            this.mLoadMoreModel.mIsBottomStubShow = false;
            this.mLoadMoreModel.mStubHeight = 0;
            updateLoadMoreModelData();
        }
    }

    public void showFooterStubView() {
        if (!this.mLoadMoreModel.mIsBottomStubShow && !this.mLoadMoreModel.mIsCartStubShow) {
            this.mLoadMoreModel.mIsCartStubShow = true;
            updateLoadMoreModelData();
        }
    }

    public void hideFooterStubView() {
        if (!this.mLoadMoreModel.mIsBottomStubShow && this.mLoadMoreModel.mIsCartStubShow) {
            this.mLoadMoreModel.mIsCartStubShow = false;
            updateLoadMoreModelData();
        }
    }

    public boolean updateFooterStubViewHeight(int i) {
        if (this.mLoadMoreModel.mIsBottomStubShow || this.mLoadMoreModel.mStubHeight == i) {
            return false;
        }
        this.mLoadMoreModel.mStubHeight = i;
        updateLoadMoreModelData();
        return true;
    }

    public void updateLoadMoreModelPadding(int i, int i2, int i3, int i4) {
        this.mLoadMoreModel.mPaddingLeft = i;
        this.mLoadMoreModel.mPaddingTop = i2;
        this.mLoadMoreModel.mPaddingRight = i3;
        this.mLoadMoreModel.mPaddingBottom = i4;
        updateLoadMoreModelData();
    }

    public void updateAutoLoadModelState(int i) {
        this.mLoadMoreModel.mState = i;
    }

    public void updateLoadMoreModelState(int i) {
        updateLoadMoreModelState(i, (String) null);
    }

    public void updateLoadMoreModelState(int i, String str) {
        this.mLoadMoreModel.mState = i;
        this.mLoadMoreModel.mDescription = str;
        updateLoadMoreModelData();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.mLoadMoreDataItemManager = null;
        ComponentLogicUnit componentLogicUnit = this.mLogicUnit;
        if (componentLogicUnit != null) {
            componentLogicUnit.clearAll();
            this.mLogicUnit = null;
        }
    }

    private void updateLoadMoreModelData() {
        ChildDataItemManager<LoadMoreModel> childDataItemManager = this.mLoadMoreDataItemManager;
        if (childDataItemManager != null) {
            childDataItemManager.setItem(this.mLoadMoreModel);
        }
    }
}
