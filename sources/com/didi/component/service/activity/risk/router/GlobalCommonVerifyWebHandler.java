package com.didi.component.service.activity.risk.router;

import android.content.Intent;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.service.activity.CommonVerifyWebActivity;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.sdk.webview.WebViewModel;

public class GlobalCommonVerifyWebHandler implements IRouterHandler {
    public static final String INTENT_VERIFY_ACTION = "common_web_verify_action";
    public static final String PARAM_WEB_URL = "weburl";

    public void handle(Request request, Result result) {
        WebViewModel buildWebViewModel = GlobalWebUrl.buildWebViewModel(request.getUri().getQueryParameter("weburl"));
        Intent intent = new Intent(request.getContext(), CommonVerifyWebActivity.class);
        intent.putExtra("web_view_model", buildWebViewModel);
        try {
            request.getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
