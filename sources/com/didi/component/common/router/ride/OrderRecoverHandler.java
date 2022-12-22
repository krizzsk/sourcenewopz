package com.didi.component.common.router.ride;

import android.net.Uri;
import com.didi.app.router.PageRouter;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import java.net.URLDecoder;
import java.util.Objects;

public class OrderRecoverHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        Uri uri = request.getUri();
        try {
            PageRouter.getInstance().forwardRide(request.getContext(), URLDecoder.decode(uri.getQueryParameter("oid"), "utf-8"), Integer.parseInt((String) Objects.requireNonNull(uri.getQueryParameter("bid"))), 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
