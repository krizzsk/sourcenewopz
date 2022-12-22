package com.didi.app.router;

import android.content.Context;
import android.net.Uri;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.global.globaluikit.toast.LEGOToastHelper;

public class ShowToastHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        int i;
        Context context = request.getContext();
        Uri uri = request.getUri();
        String queryParameter = uri.getQueryParameter("text");
        try {
            i = Integer.parseInt(uri.getQueryParameter("style"));
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        if (i == 2) {
            LEGOToastHelper.showShortNagToast(context, queryParameter);
        } else if (i == 1) {
            LEGOToastHelper.showShortPosToast(context, queryParameter);
        } else {
            LEGOToastHelper.showToast(context, queryParameter);
        }
    }
}
