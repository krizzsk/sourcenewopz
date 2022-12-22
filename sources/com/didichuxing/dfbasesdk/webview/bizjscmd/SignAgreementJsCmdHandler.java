package com.didichuxing.dfbasesdk.webview.bizjscmd;

import com.didichuxing.dfbasesdk.ottoevent.SignFaceAgreementEvent;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.didichuxing.dfbasesdk.webview.CloseWebviewEvent;
import com.didichuxing.dfbasesdk.webview.JSCommands;
import com.didichuxing.dfbasesdk.webview.JsCallbackEvent;
import org.json.JSONObject;

public class SignAgreementJsCmdHandler implements IBizJsCmdHandler {

    /* renamed from: a */
    private final boolean f46950a;

    SignAgreementJsCmdHandler(boolean z) {
        this.f46950a = z;
    }

    public boolean handleJsCmd(String str, JSONObject jSONObject) {
        if (((str.hashCode() == -1092566672 && str.equals(JSCommands.SIGN_FACE_AGREEMENT)) ? (char) 0 : 65535) != 0) {
            return false;
        }
        int optInt = jSONObject.optInt("agree");
        BusUtils.post(new JsCallbackEvent(str).append("agree", Integer.valueOf(optInt)).build());
        BusUtils.post(new SignFaceAgreementEvent(optInt));
        BusUtils.post(new CloseWebviewEvent());
        return true;
    }

    public void onUserCancel() {
        if (!this.f46950a) {
            BusUtils.post(new SignFaceAgreementEvent());
        }
    }
}
