package com.didi.component.common.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.sdk.webview.WebActivity;
import com.didi.sdk.webview.WebViewModel;

public class GlobalWebHandler implements IRouterHandler {
    public static final String PARAM_WEBURL = "weburl";

    public void handle(Request request, Result result) {
        Uri uri;
        if (request != null && (uri = request.getUri()) != null) {
            String queryParameter = uri.getQueryParameter("weburl");
            if (TextUtils.isEmpty(queryParameter)) {
                return;
            }
            if (queryParameter.startsWith("http") || queryParameter.startsWith("https")) {
                WebViewModel buildWebViewModel = GlobalWebUrl.buildWebViewModel(queryParameter, uri.getQueryParameter("title"), GRouterUtil.parseInt(uri.getQueryParameter("isPostBaseParams"), 1) == 1, true);
                buildWebViewModel.isFromOutApp = true;
                Context context = request.getContext();
                if (context != null) {
                    Intent intent = new Intent(context, WebActivity.class);
                    intent.putExtra("web_view_model", buildWebViewModel);
                    if (!(context instanceof Activity)) {
                        intent.addFlags(268435456);
                        intent.addFlags(8388608);
                    }
                    context.startActivity(intent);
                }
            }
        }
    }
}
