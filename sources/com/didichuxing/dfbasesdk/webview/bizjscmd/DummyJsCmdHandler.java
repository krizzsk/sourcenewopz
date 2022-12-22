package com.didichuxing.dfbasesdk.webview.bizjscmd;

import com.didichuxing.dfbasesdk.utils.LogUtils;
import org.json.JSONObject;

public class DummyJsCmdHandler implements IBizJsCmdHandler {
    public boolean handleJsCmd(String str, JSONObject jSONObject) {
        LogUtils.m33563d("do nothing...");
        return false;
    }

    public void onUserCancel() {
        LogUtils.m33563d("do nothing...");
    }
}
