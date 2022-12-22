package com.didi.global.flutter.linker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;

public class ExternalAppRouterHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        Uri uri = request.getUri();
        Context context = request.getContext();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }
}
