package com.didi.unifylogin.base.api;

import com.didi.unifylogin.base.log.LogListener;
import com.didi.unifylogin.base.net.LoginNetModeListener;
import com.didi.unifylogin.base.net.LoginNetParamListener;

public class LoginBaseParam {
    public String customBaseUrl = "";
    public boolean isGlobal = false;
    public boolean isRussia = false;
    public LogListener logListener;
    public LoginNetModeListener netModeListener;
    public LoginNetParamListener netParamListener;
    public boolean useCustomBaseUrl = false;
}
