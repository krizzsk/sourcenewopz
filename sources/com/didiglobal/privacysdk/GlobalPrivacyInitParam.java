package com.didiglobal.privacysdk;

import com.didiglobal.privacysdk.GlobalPrivacyListeners;

public class GlobalPrivacyInitParam {
    public GlobalPrivacyListeners.IAppInfo appInfo;
    public GlobalPrivacyListeners.BaseActivityDelegate baseActivityDelegate;
    public boolean configThemeResInt;
    public String downloadDataUrl = "";
    public boolean finishActivityWhenAppRestarted = false;
    public GlobalPrivacyListeners.GetCommonInfoListener getCommonInfoListener;
    public boolean itemTitleBold = true;
    public GlobalPrivacyListeners.OnItemClickedListener onItemClickedListener;
    public int themeResInt;
    public GlobalPrivacyListeners.WebViewListener webViewListener;
}
