package com.didi.sdk.sidebar.account;

import com.didi.sdk.sidebar.templet.BottomTitleFragment;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;

public class SettingsFragment extends BottomTitleFragment {
    public void onResume() {
        super.onResume();
        OmegaSDKAdapter.trackEvent("pas_setting_sw");
    }
}
