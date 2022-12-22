package com.didi.addressold.vamos;

import android.app.Activity;
import android.app.Fragment;
import android.os.ResultReceiver;
import com.didi.address.ISugControlCallback;
import com.didi.address.model.SugParams;
import com.didi.address.view.ISugViewController;

public interface IDidiAddressApi {
    void closeFragment();

    void enableCloseSugFragment(boolean z);

    ISugViewController getSugViewController();

    boolean onBackPressed();

    void selectAddress(Activity activity, int i, SugParams sugParams, GlobalSugCallback globalSugCallback) throws AddressException;

    void selectAddress(Fragment fragment, int i, SugParams sugParams, GlobalSugCallback globalSugCallback) throws AddressException;

    void setCommonAddress(Activity activity, SugParams sugParams);

    void setCommonAddress(Activity activity, SugParams sugParams, ResultReceiver resultReceiver);

    void setSugControlCallback(ISugControlCallback iSugControlCallback);
}
