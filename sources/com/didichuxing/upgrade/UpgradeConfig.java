package com.didichuxing.upgrade;

import android.app.Activity;
import java.util.Map;

public class UpgradeConfig {
    public static IConfig iConfig;

    public interface IConfig {
        void OmegaTrackEvent(String str, Map<String, Object> map);

        String getAppLanguage();

        String getCityId();

        String getCountryCode();

        String getCustomHost();

        String getPhone();

        String getUid();

        Activity getUpdateContext();

        void openWebView(String str);

        boolean showCustomDialog(String str, String str2, String str3, String str4, boolean z, IUpdateDialogCallback iUpdateDialogCallback);
    }
}
