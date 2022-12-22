package com.didi.unifylogin.api;

import com.didi.unifylogin.base.log.LogListener;
import com.didi.unifylogin.base.net.LoginNetModeListener;
import com.didi.unifylogin.listener.LoginListeners;

public class LoginInitParam {
    public final int appId;
    public String brand;
    public String customBaseUrl = "";
    public int defCountryId = -1;
    public LoginListeners.FaceListener faceListener;
    public LoginListeners.GlobalizationListener globalizationListener;
    public boolean isGlobal = false;
    public boolean isRussia = false;
    public LoginListeners.LocationListener locationListener;
    public LogListener logListener;
    public LoginNetModeListener netModeListener;
    public LoginListeners.NetParamListener netParamListener;
    public LoginListeners.RiskParamListener riskParamListener;
    public String terminalId;
    public boolean useCustomBaseUrl = false;
    public LoginListeners.WebViewListener webViewListener;
    public LoginListeners.WriteBackListener writeBackListener;

    public LoginInitParam(int i) {
        this.appId = i;
    }
}
