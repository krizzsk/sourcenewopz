package com.didichuxing.dfbasesdk.webview.bizjscmd;

import org.json.JSONObject;

public class DummyJsCommandHandler extends AbsJsCmdHandler {

    /* renamed from: a */
    private IBizJsCmdHandler f46949a = new DummyJsCmdHandler();

    public boolean handleJsCmd(String str, JSONObject jSONObject) {
        return this.f46949a.handleJsCmd(str, jSONObject);
    }

    public void onUserCancel() {
        this.f46949a.onUserCancel();
    }
}
