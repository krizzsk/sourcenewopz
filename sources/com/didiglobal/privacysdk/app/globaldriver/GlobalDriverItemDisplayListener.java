package com.didiglobal.privacysdk.app.globaldriver;

import com.didiglobal.privacysdk.GlobalPrivacyListeners;
import com.didiglobal.privacysdk.util.GlobalApolloUtils;

public class GlobalDriverItemDisplayListener implements GlobalPrivacyListeners.ItemDisplayListener {
    public boolean displayDiscountEmail() {
        return false;
    }

    public boolean displayDiscountPush() {
        return false;
    }

    public boolean displayLocationShare() {
        return false;
    }

    public boolean displaySms() {
        return false;
    }

    public boolean displayDownloadData() {
        return GlobalApolloUtils.getDownloadDataSwitch(false);
    }

    public boolean displaySystemPermission() {
        return GlobalApolloUtils.getSystemPermissionsSwitch(false);
    }

    public boolean displayDeleteAccount() {
        return GlobalApolloUtils.getDeleteAccountSwitch(true);
    }
}
