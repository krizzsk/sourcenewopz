package com.didi.app.nova.support.view.recyclerview.view;

import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.INovaLayoutManager;

public interface INovaRecyclerView {

    public interface LoadMoreListener {
        void onLoadMore();
    }

    boolean isAutoPreLoad();

    boolean isScrollable();

    void scrollToItem(Object obj);

    void setFootLoadMoreEnable(boolean z);

    void setItemDecorationEnable(boolean z);

    void setItemDragEnable(boolean z);

    void setItemMvpEnable(boolean z);

    void setItemTouchControlEnable(boolean z);

    void setLoadMoreListener(LoadMoreListener loadMoreListener);

    void setNovaLayoutManager(INovaLayoutManager iNovaLayoutManager);

    void setPreLoadNumber(int i);

    void smoothScrollToItem(Object obj);
}
