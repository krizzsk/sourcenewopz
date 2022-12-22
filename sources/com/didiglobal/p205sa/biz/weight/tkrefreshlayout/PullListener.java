package com.didiglobal.p205sa.biz.weight.tkrefreshlayout;

/* renamed from: com.didiglobal.sa.biz.weight.tkrefreshlayout.PullListener */
public interface PullListener {
    void onFinishLoadMore();

    void onFinishRefresh();

    void onLoadMore(TwinklingRefreshLayout twinklingRefreshLayout);

    void onLoadmoreCanceled();

    void onPullDownReleasing(TwinklingRefreshLayout twinklingRefreshLayout, float f);

    void onPullUpReleasing(TwinklingRefreshLayout twinklingRefreshLayout, float f);

    void onPullingDown(TwinklingRefreshLayout twinklingRefreshLayout, float f);

    void onPullingUp(TwinklingRefreshLayout twinklingRefreshLayout, float f);

    void onRefresh(TwinklingRefreshLayout twinklingRefreshLayout);

    void onRefreshCanceled();
}
