package com.didichuxing.dfbasesdk.webview;

import org.json.JSONObject;

class JsBridgeImpl$1 implements Runnable {
    final /* synthetic */ C15329d this$0;
    final /* synthetic */ String val$command;
    final /* synthetic */ JSONObject val$jsonObject;

    JsBridgeImpl$1(C15329d dVar, String str, JSONObject jSONObject) {
        this.this$0 = dVar;
        this.val$command = str;
        this.val$jsonObject = jSONObject;
    }

    public void run() {
        this.this$0.f46958e.handleJsInvoke(this.val$command, this.val$jsonObject);
    }
}
