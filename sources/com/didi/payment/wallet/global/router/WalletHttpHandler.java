package com.didi.payment.wallet.global.router;

import android.content.Intent;
import android.net.Uri;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.payment.base.view.webview.CustomNavModel;
import com.didi.payment.base.view.webview.PayBaseWebActivity;
import com.didi.payment.base.view.webview.WalletWebActivity;
import com.didi.payment.base.view.webview.WebModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/router/WalletHttpHandler;", "Lcom/didi/drouter/router/IRouterHandler;", "()V", "handle", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletHttpHandler.kt */
public final class WalletHttpHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        CustomNavModel customNavModel;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        Uri uri = request.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "request.uri");
        int i = request.getInt("layout_id");
        String string = request.getString("title");
        if (i != 0) {
            customNavModel = new CustomNavModel();
            customNavModel.layoutId = i;
            customNavModel.title = string;
        } else {
            customNavModel = null;
        }
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        String substring = uri2.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
        WebModel webModel = new WebModel(substring, customNavModel);
        Intent intent = new Intent(request.getContext(), WalletWebActivity.class);
        intent.putExtra(PayBaseWebActivity.EXTRA_WEB_MODEL, webModel);
        request.getContext().startActivity(intent);
    }
}
