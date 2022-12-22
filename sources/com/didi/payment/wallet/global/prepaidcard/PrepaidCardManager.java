package com.didi.payment.wallet.global.prepaidcard;

import android.content.Context;
import android.net.Uri;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.RouterCallback;
import com.didi.soda.compose.card.BaseCard;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/PrepaidCardManager;", "", "()V", "Companion", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PrepaidCardManager.kt */
public final class PrepaidCardManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PREPAID_CARD_URL = "taxis99OneTravel://one/prepayCard_banner";
    public static final String PREPAID_CARD_URL_PATH = "/prepayCard_banner";

    @Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\tJH\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u001e\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004JR\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/PrepaidCardManager$Companion;", "", "()V", "PREPAID_CARD_URL", "", "PREPAID_CARD_URL_PATH", "buildParamsUrl", "url", "params", "", "buildPrepaidUrl", "source", "scene", "fullKyc", "preApply", "cardId", "buildWalletUrl", "parseUrlParams", "", "start", "", "context", "Landroid/content/Context;", "listener", "Lcom/didi/drouter/router/RouterCallback;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PrepaidCardManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, String str, String str2, String str3, String str4, String str5, RouterCallback routerCallback, int i, Object obj) {
            companion.start(context, str, str2, str3, (i & 16) != 0 ? "1" : str4, (i & 32) != 0 ? "" : str5, (i & 64) != 0 ? null : routerCallback);
        }

        public final void start(Context context, String str, String str2, String str3, String str4, String str5, RouterCallback routerCallback) {
            DRouter.build(buildPrepaidUrl(PrepaidCardManager.PREPAID_CARD_URL, str, str2, str3, str4, str5)).start(context, routerCallback);
        }

        public static /* synthetic */ String buildPrepaidUrl$default(Companion companion, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 16) != 0) {
                str5 = "1";
            }
            String str7 = str5;
            if ((i & 32) != 0) {
                str6 = "";
            }
            return companion.buildPrepaidUrl(str, str2, str3, str4, str7, str6);
        }

        public final String buildPrepaidUrl(String str, String str2, String str3, String str4, String str5, String str6) {
            if (str == null) {
                return str;
            }
            try {
                return Uri.parse(str).buildUpon().appendQueryParameter("source", str2).appendQueryParameter("scene", str3).appendQueryParameter("pre_apply", str5).appendQueryParameter("full_kyc", str4).appendQueryParameter(BaseCard.KEY_CARD_ID, str6).build().toString();
            } catch (Exception unused) {
                return str;
            }
        }

        public final String buildParamsUrl(String str, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "params");
            if (str == null) {
                return str;
            }
            try {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                for (Map.Entry next : map.entrySet()) {
                    buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
                }
                return buildUpon.build().toString();
            } catch (Exception unused) {
                return str;
            }
        }

        public final Map<String, String> parseUrlParams(String str) {
            Map<String, String> linkedHashMap = new LinkedHashMap<>();
            try {
                Uri parse = Uri.parse(str);
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                Intrinsics.checkNotNullExpressionValue(queryParameterNames, "keys");
                for (String str2 : queryParameterNames) {
                    Intrinsics.checkNotNullExpressionValue(str2, "key");
                    linkedHashMap.put(str2, parse.getQueryParameter(str2));
                }
            } catch (Exception unused) {
            }
            return linkedHashMap;
        }

        public final String buildWalletUrl(String str) {
            boolean z = true;
            if (str == null || !StringsKt.startsWith$default(str, "http", false, 2, (Object) null)) {
                z = false;
            }
            return z ? Intrinsics.stringPlus("d", str) : str;
        }
    }
}
