package com.didiglobal.privacysdk.app.globaldriver;

import com.didiglobal.privacysdk.GlobalPrivacyListeners;

public class GlobalDriverAppInfo implements GlobalPrivacyListeners.IAppInfo {
    public GlobalPrivacyListeners.ItemDisplayListener getItemDisplayListener() {
        return new GlobalDriverItemDisplayListener();
    }

    public GlobalPrivacyListeners.IPrivacyStrings getIPrivacyStrings() {
        return new GlobalDriverPrivacyStrings();
    }
}
