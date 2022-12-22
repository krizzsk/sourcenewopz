package com.didi.foundation.sdk.service;

import android.content.Context;
import java.util.Map;

public class LocaleConfig {
    public String city_id;
    public String country_id = "";
    public ErrorTrackCallBack errorTrackCallBack;
    public boolean isDebug = false;
    public boolean isGlobal = false;
    public LoadConfCallBack localAssetsLanguageConfData;
    public PreInitCB preInitCB;
    public LoadConfCallBack remoteLanguageConfData;

    public interface ErrorTrackCallBack {
        void trackError(String str, String str2);
    }

    public interface LoadConfCallBack {
        Map<String, Object> loadConf(Context context);
    }

    public interface PreInitCB {
        void onPreInit(Context context);
    }
}
