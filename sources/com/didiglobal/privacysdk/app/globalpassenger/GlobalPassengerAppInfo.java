package com.didiglobal.privacysdk.app.globalpassenger;

import com.didiglobal.privacysdk.GlobalPrivacyListeners;

public class GlobalPassengerAppInfo implements GlobalPrivacyListeners.IAppInfo {
    public GlobalPrivacyListeners.ItemDisplayListener getItemDisplayListener() {
        return new GlobalPassengerItemDisplayListener();
    }

    public GlobalPrivacyListeners.IPrivacyStrings getIPrivacyStrings() {
        return new GlobalPassengerPrivacyStrings();
    }
}
