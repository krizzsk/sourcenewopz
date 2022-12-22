package com.didiglobal.privacysdk.app.globalpassenger;

import com.didiglobal.privacysdk.GlobalPrivacyListeners;
import com.didiglobal.privacysdk.util.GlobalApolloUtils;

public class GlobalPassengerItemDisplayListener implements GlobalPrivacyListeners.ItemDisplayListener {
    public boolean displayDiscountPush() {
        return GlobalApolloUtils.getDiscountPushSwitch(true);
    }

    public boolean displaySms() {
        return GlobalApolloUtils.getDiscountSMSSwitch(true);
    }

    public boolean displayDiscountEmail() {
        return GlobalApolloUtils.getDiscountEmailSwitch(true);
    }

    public boolean displayLocationShare() {
        return GlobalApolloUtils.getShareLocationSwitch(true);
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
