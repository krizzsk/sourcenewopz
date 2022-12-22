package com.didi.app.nova.support.view.pullToRefresh;

public interface IRefreshView {
    void onComplete();

    void onMove(boolean z, int i);

    void onPullToRefresh();

    void onRelease(boolean z);

    void onReset();
}
