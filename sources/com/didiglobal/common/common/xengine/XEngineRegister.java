package com.didiglobal.common.common.xengine;

import android.text.TextUtils;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.register.XERegisterModel;

public class XEngineRegister {
    public static void register(XERegisterModel xERegisterModel) {
        XERegister.registerTemplate(xERegisterModel);
    }

    public static void unregister(String str) {
        XERegister.unregisterTemplate(str);
    }

    public static void unregister(XERegisterModel xERegisterModel) {
        if (xERegisterModel != null && !TextUtils.isEmpty(xERegisterModel.requestKey)) {
            unregister(xERegisterModel.requestKey);
        }
    }
}
