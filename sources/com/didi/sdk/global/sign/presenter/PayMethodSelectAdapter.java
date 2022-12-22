package com.didi.sdk.global.sign.presenter;

import com.didi.sdk.global.DidiGlobalPayMethodListData;

public abstract class PayMethodSelectAdapter {
    private AdapterDataObserver observer;

    public interface AdapterDataObserver {
        void onFailed();

        void onFinished();

        void onSuccess(DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam);
    }

    public abstract void refreshPayMethodList(DidiGlobalPayMethodListData.Entrance entrance);

    public void notifyRefreshSuccess(DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam) {
        AdapterDataObserver adapterDataObserver = this.observer;
        if (adapterDataObserver != null) {
            adapterDataObserver.onSuccess(payMethodListParam);
        }
    }

    public void notifyRefreshFailed() {
        AdapterDataObserver adapterDataObserver = this.observer;
        if (adapterDataObserver != null) {
            adapterDataObserver.onFailed();
        }
    }

    public void notifyRefreshFinished() {
        AdapterDataObserver adapterDataObserver = this.observer;
        if (adapterDataObserver != null) {
            adapterDataObserver.onFinished();
        }
    }

    public void setObserver(AdapterDataObserver adapterDataObserver) {
        this.observer = adapterDataObserver;
    }
}
