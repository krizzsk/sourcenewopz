package com.didi.component.service.activity.risk.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.component.service.activity.MexicoCurpAuthWebActivity;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.sdk.webview.WebViewModel;

public class OpenBindCurpHandler implements IRouterHandler {
    public static final String BIND_CURP = "1";

    public void handle(Request request, Result result) {
        Uri uri = request.getUri();
        String queryParameter = uri.getQueryParameter("verify_style");
        String queryParameter2 = uri.getQueryParameter("auth_h5_url");
        if ("1".equals(queryParameter) && !TextUtils.isEmpty(queryParameter2)) {
            WebViewModel webViewModel = new WebViewModel();
            webViewModel.url = queryParameter2;
            webViewModel.isSupportCache = false;
            Intent intent = new Intent(request.getContext(), MexicoCurpAuthWebActivity.class);
            intent.putExtra("web_view_model", webViewModel);
            intent.putExtra("CPF_AUTH_SOURCE_KEY", 3);
            Context context = request.getContext();
            if (context instanceof Activity) {
                context.startActivity(intent);
            }
        }
    }
}
