package com.didi.addressnew.framework;

import android.app.Activity;
import com.didi.address.GlobalSugCallback;
import com.didi.address.model.SugParams;
import com.didi.addressnew.framework.switcher.scheduler.SwitcherImpl;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.omega.sdk.feedback.FeedbackConfig;

public class IDidiAddressNewApiImpl implements IDidiAddressNewApi {
    public void startSugActivity(Activity activity, SugParams sugParams, GlobalSugCallback globalSugCallback) {
        SystemUtils.log(5, FeedbackConfig.FT_SUG, "AddressApiImpl::selectAddress(4) +44", (Throwable) null, "com.didi.addressnew.framework.IDidiAddressNewApiImpl", 14);
        if (SwitcherImpl.getInstance() == null) {
            SwitcherImpl.createInstance(activity, sugParams, globalSugCallback);
        }
    }

    public void closeSugSession() {
        SystemUtils.log(5, FeedbackConfig.FT_SUG, "AddressApiImpl::closeSugSession() +104", (Throwable) null, "com.didi.addressnew.framework.IDidiAddressNewApiImpl", 21);
        if (SwitcherImpl.getInstance() != null) {
            SwitcherImpl.getInstance().closeSessionImediately();
        }
    }
}
