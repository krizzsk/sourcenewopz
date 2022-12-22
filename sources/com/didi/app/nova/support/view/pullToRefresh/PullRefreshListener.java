package com.didi.app.nova.support.view.pullToRefresh;

public interface PullRefreshListener {
    void onMoveRefreshView(int i);

    void onMoveTargetView(int i);

    void onPullToRefresh();
}
