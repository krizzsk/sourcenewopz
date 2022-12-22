package com.didi.dimina.container.bridge;

import android.graphics.Color;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.ColorUtil;
import org.json.JSONObject;

public class PageStyleSubJSBridge {

    /* renamed from: a */
    private final DMPage f16627a;

    public PageStyleSubJSBridge(DMPage dMPage) {
        this.f16627a = dMPage;
    }

    public void setBackgroundColor(JSONObject jSONObject, CallbackFunction callbackFunction) {
        String optString = jSONObject.optString("backgroundColor");
        if (ColorUtil.isValidColorStr(optString)) {
            this.f16627a.setBackgroundColor(Color.parseColor(ColorUtil.convert3To6(optString)));
            CallBackUtil.onSuccess(callbackFunction);
            return;
        }
        CallBackUtil.onFail("backgroundColor is invalid", callbackFunction);
    }
}
