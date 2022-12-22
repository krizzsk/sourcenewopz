package com.didi.app;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIBaseApplication;
import com.didi.sdk.onehotpatch.ONEPatchFacade;

public class DIDIApplicationWithHotPatch extends DIDIBaseApplication {

    /* renamed from: a */
    private static final String f8222a = "HotPatch";

    public void launchHotPatch(Context context) {
        super.launchHotPatch(context);
        try {
            SystemUtils.log(3, f8222a, "Used HotPatch!!", (Throwable) null, "com.didi.app.DIDIApplicationWithHotPatch", 21);
            ONEPatchFacade.launch(getAppContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
