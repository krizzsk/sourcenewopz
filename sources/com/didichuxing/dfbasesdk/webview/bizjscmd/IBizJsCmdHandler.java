package com.didichuxing.dfbasesdk.webview.bizjscmd;

import org.json.JSONObject;

public interface IBizJsCmdHandler {
    boolean handleJsCmd(String str, JSONObject jSONObject);

    void onUserCancel();
}
