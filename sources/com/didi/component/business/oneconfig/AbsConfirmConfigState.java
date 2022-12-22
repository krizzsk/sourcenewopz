package com.didi.component.business.oneconfig;

import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.BusinessContext;

public abstract class AbsConfirmConfigState {
    public static boolean isInSugPage = false;
    public static boolean isLoadingInConfirmPage = false;
    public static boolean isShowPopInConfirmPage = false;
    protected BusinessContext mBusinessContext;
    protected IConfirmConfigCallback mConfigCallback;

    public interface IConfirmConfigCallback {
        void onChangeSelf();

        void onNetFail();

        void onNetStart();

        void onNetSuccess();
    }

    public abstract boolean dispatchInterceptStartAddress(Address address);

    /* access modifiers changed from: protected */
    public abstract void getMisConfigFromNet(Address address);

    public abstract void reGetMisConfigFromNet();

    public abstract void subscribeConfig();

    public abstract void unsubscribeConfig();

    public AbsConfirmConfigState(BusinessContext businessContext, IConfirmConfigCallback iConfirmConfigCallback) {
        this.mBusinessContext = businessContext;
        this.mConfigCallback = iConfirmConfigCallback;
    }
}
