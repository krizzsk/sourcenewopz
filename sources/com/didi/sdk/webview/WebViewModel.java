package com.didi.sdk.webview;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class WebViewModel implements Serializable {
    public boolean canChangeWebViewTitle = true;
    @Deprecated
    public String customparams = "";
    public boolean isAddCommonParam = false;
    public boolean isCommonModel = false;
    @Deprecated
    public boolean isFromBuiness = false;
    public boolean isFromOutApp = false;
    public boolean isFromPaypal = false;
    public boolean isPostBaseParams = true;
    public boolean isSuportJs = true;
    public boolean isSuportSpeechJs = true;
    public boolean isSupportCache = true;
    public Map<String, Object> queryParamMap = new HashMap();
    @Deprecated
    public int rightTextResId = -1;
    public String title = "";
    public String url = "";
    public boolean useHtmlHeadTitle = true;

    public WebViewModel addParam(String str, String str2) {
        this.queryParamMap.put(str, str2);
        return this;
    }

    public WebViewModel setParams(Map<String, Object> map) {
        this.queryParamMap.putAll(map);
        return this;
    }
}
