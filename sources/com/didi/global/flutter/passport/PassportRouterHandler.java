package com.didi.global.flutter.passport;

import android.content.Intent;
import android.net.Uri;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;

public class PassportRouterHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        Uri uri;
        if (request != null && (uri = request.getUri()) != null) {
            request.getContext().startActivity(new Intent("android.intent.action.VIEW", uri));
        }
    }
}
