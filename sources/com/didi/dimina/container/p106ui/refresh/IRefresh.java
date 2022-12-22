package com.didi.dimina.container.p106ui.refresh;

/* renamed from: com.didi.dimina.container.ui.refresh.IRefresh */
public interface IRefresh {

    /* renamed from: com.didi.dimina.container.ui.refresh.IRefresh$RefreshListener */
    public interface RefreshListener {
        boolean enableRefresh();

        void onRefresh();
    }

    void refreshAuto();

    void refreshFinished();

    void setDisableRefreshScroll(boolean z);

    void setRefreshListener(RefreshListener refreshListener);

    void setRefreshOverView(AbsOverView absOverView);
}
