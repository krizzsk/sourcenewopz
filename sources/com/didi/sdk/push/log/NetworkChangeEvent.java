package com.didi.sdk.push.log;

import com.didi.unifylogin.utils.LoginOmegaUtil;
import java.util.HashMap;
import java.util.Map;

public class NetworkChangeEvent extends LogEvent {
    private String currentNetwork;
    private String lastNetwork;

    public void setLastNetwork(String str) {
        this.lastNetwork = str;
    }

    public void setCurrentNetwork(String str) {
        this.currentNetwork = str;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(LoginOmegaUtil.OLD_USER, this.lastNetwork);
        hashMap.put("new", this.currentNetwork);
        return hashMap;
    }
}
