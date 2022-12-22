package com.didi.addressnew.framework;

import android.app.Activity;
import com.didi.address.AddressException;
import com.didi.address.GlobalSugCallback;
import com.didi.address.model.SugParams;

public interface IDidiAddressNewApi {
    void closeSugSession();

    void startSugActivity(Activity activity, SugParams sugParams, GlobalSugCallback globalSugCallback) throws AddressException;
}
