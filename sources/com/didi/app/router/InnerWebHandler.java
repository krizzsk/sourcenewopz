package com.didi.app.router;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.sdk.webview.WebActivity;
import com.didi.sdk.webview.WebViewModel;

public class InnerWebHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        WebViewModel buildWebViewModel = buildWebViewModel(request.getUri().toString(), "", true, true);
        Intent intent = new Intent(request.getContext(), WebActivity.class);
        intent.putExtra("web_view_model", buildWebViewModel);
        if (!(request.getContext() instanceof Activity)) {
            intent.addFlags(268435456);
        }
        request.getContext().startActivity(intent);
    }

    public static WebViewModel buildWebViewModel(String str, String str2, boolean z, boolean z2) {
        WebViewModel webViewModel = new WebViewModel();
        webViewModel.url = str;
        if (!TextUtils.isEmpty(str2)) {
            webViewModel.title = str2;
        }
        webViewModel.isPostBaseParams = z;
        webViewModel.isSupportCache = z2;
        return webViewModel;
    }
}
