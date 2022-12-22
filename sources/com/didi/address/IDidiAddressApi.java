package com.didi.address;

import android.app.Activity;
import android.app.Fragment;
import android.os.ResultReceiver;
import com.didi.address.model.SugParams;
import com.didi.address.view.ISugViewController;

public interface IDidiAddressApi {

    /* renamed from: com.didi.address.IDidiAddressApi$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$closeSugSession(IDidiAddressApi iDidiAddressApi) {
        }
    }

    void closeFragment();

    void closeSugSession();

    void enableCloseSugFragment(boolean z);

    ISugViewController getSugViewController();

    boolean onBackPressed();

    void selectAddress(Activity activity, int i, SugParams sugParams, GlobalSugCallback globalSugCallback) throws AddressException;

    void selectAddress(Fragment fragment, int i, SugParams sugParams, GlobalSugCallback globalSugCallback) throws AddressException;

    void setCommonAddress(Activity activity, SugParams sugParams);

    void setCommonAddress(Activity activity, SugParams sugParams, ResultReceiver resultReceiver);

    void setSugControlCallback(ISugControlCallback iSugControlCallback);

    void startSugActivity(Activity activity, SugParams sugParams, GlobalSugCallback globalSugCallback) throws AddressException;
}
