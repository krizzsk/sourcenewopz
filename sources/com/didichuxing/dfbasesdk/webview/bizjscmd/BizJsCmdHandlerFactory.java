package com.didichuxing.dfbasesdk.webview.bizjscmd;

import com.didichuxing.dfbasesdk.webview.WebviewSceneTypes;

public class BizJsCmdHandlerFactory {
    public static IBizJsCmdHandler newJsCmdHandler(String str, String str2, int i, String str3) {
        if (WebviewSceneTypes.SCENE_TYPE_APPEAL.equals(str)) {
            return new C15327a(str2, i);
        }
        if (WebviewSceneTypes.SCENE_TYPE_SIGN_FACE_AGREEMENT.equals(str)) {
            return new SignAgreementJsCmdHandler(str3.contains("va=1"));
        }
        return new DummyJsCmdHandler();
    }
}
