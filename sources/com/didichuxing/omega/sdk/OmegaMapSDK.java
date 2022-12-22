package com.didichuxing.omega.sdk;

import com.didichuxing.omega.sdk.OmegaMapConfig;
import com.didichuxing.omega.sdk.common.OmegaConfig;

public class OmegaMapSDK {
    public static void init(OmegaMapConfig.IConfig iConfig) {
        OmegaMapConfig.config = iConfig;
        if (iConfig != null) {
            OmegaConfig.setUploadHost(iConfig.getUploadHost());
            OmegaConfig.SWITCH_FULL_AUTO_UI = iConfig.getSwitchAutoUI();
        }
    }
}
