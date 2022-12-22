package com.wallet.flutter.wallet_flutter.router;

import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.flutter.nacho.Nacho;
import com.didi.payment.base.exts.ApplicationContextProvider;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/wallet/flutter/wallet_flutter/router/WalletBoletoRouterHandler;", "Lcom/didi/drouter/router/IRouterHandler;", "()V", "handle", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletBoletoRouterHandler.kt */
public final class WalletBoletoRouterHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        String str;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        String uri = request.getUri().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "request.uri.toString()");
        CharSequence charSequence = uri;
        if (StringsKt.contains$default(charSequence, (CharSequence) "/wallet_topup_boleto", false, 2, (Object) null)) {
            String stringPlus = Intrinsics.stringPlus("&terminalId=", WalletCommonParamsUtil.getTerminalId(ApplicationContextProvider.Companion.getContext()));
            String substring = uri.substring(StringsKt.indexOf$default(charSequence, "/wallet_topup_boleto", 0, false, 6, (Object) null));
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            if (StringsKt.contains$default((CharSequence) substring, (CharSequence) "?", false, 2, (Object) null)) {
                str = Intrinsics.stringPlus(substring, stringPlus);
            } else {
                str = new Regex(ParamKeys.SIGN_AND).replaceFirst(Intrinsics.stringPlus(substring, stringPlus), "?");
            }
            Nacho.Router().open(request.getContext(), str);
        }
    }
}
