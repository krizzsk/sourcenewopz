package com.didichuxing.omega.sdk.feedback.shake;

import android.text.TextUtils;
import com.didichuxing.afanty.common.utils.Constants;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;

public class ShakeConfig {
    public static final String JavascriptInterface = "OmgJSBridge";
    public static String TIYAN_BASEURL = "";
    public static final String TIYAN_BID = "&tiyan_bid=";

    public static String getTiyanUrl() {
        if (!TextUtils.isEmpty(TIYAN_BASEURL)) {
            return TIYAN_BASEURL;
        }
        IToggle toggle = Apollo.getToggle(Constants.AFANTY_CONFIG_TOGGLE_NAME);
        if (toggle == null) {
            return TIYAN_BASEURL;
        }
        if (!toggle.allow()) {
            return TIYAN_BASEURL;
        }
        IExperiment experiment = toggle.getExperiment();
        if (experiment == null) {
            return TIYAN_BASEURL;
        }
        String str = (String) experiment.getParam(Constants.TIYAN_URL_PRE_KEY, "");
        TIYAN_BASEURL = str;
        return str;
    }
}
