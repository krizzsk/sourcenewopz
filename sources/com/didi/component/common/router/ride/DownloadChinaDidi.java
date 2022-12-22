package com.didi.component.common.router.ride;

import com.didi.component.business.util.Utils;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;

public class DownloadChinaDidi implements IRouterHandler {
    public void handle(Request request, Result result) {
        Utils.launchGooglePlayStoreAppDetail("com.sdu.didi.psnger");
    }
}
