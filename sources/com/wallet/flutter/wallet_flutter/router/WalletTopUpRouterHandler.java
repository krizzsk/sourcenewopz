package com.wallet.flutter.wallet_flutter.router;

import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.flutter.nacho.Nacho;
import com.didi.payment.base.exts.ApplicationContextProvider;
import com.didi.payment.base.tracker.FinExtAttrBiz;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/wallet/flutter/wallet_flutter/router/WalletTopUpRouterHandler;", "Lcom/didi/drouter/router/IRouterHandler;", "()V", "handle", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletTopUpRouterHandler.kt */
public final class WalletTopUpRouterHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        if (request.getContext() != null) {
            String terminalId = WalletCommonParamsUtil.getTerminalId(ApplicationContextProvider.Companion.getContext());
            String uri = request.getUri().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "request.uri.toString()");
            String substring = uri.substring(StringsKt.indexOf$default((CharSequence) uri, "/ddw_top_up", 0, false, 6, (Object) null) + 11);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            if (WalletApolloUtil.getTopUpIsNew()) {
                String stringPlus = Intrinsics.stringPlus("&terminalId=", WalletCommonParamsUtil.getTerminalId(ApplicationContextProvider.Companion.getContext()));
                if (!StringsKt.contains$default((CharSequence) substring, (CharSequence) "?", false, 2, (Object) null)) {
                    stringPlus = new Regex(ParamKeys.SIGN_AND).replaceFirst(stringPlus, "?");
                }
                String stringPlus2 = Intrinsics.stringPlus(substring, stringPlus);
                new FinExtAttrBiz().updateExtAttrs2FinGlobalAttrs(request.getString("ext"));
                Nacho.Router().open(request.getContext(), Intrinsics.stringPlus("/wallet_topup_main", stringPlus2));
            } else if (terminalId.equals("5")) {
                DRouter.build(Intrinsics.stringPlus("GuaranaOneTravel://one/payment_topup_channel", substring)).start();
            } else if (terminalId.equals("7")) {
                DRouter.build(Intrinsics.stringPlus("globalOneTravel://one/payment_topup_channel", substring)).start();
            }
        }
    }
}
