package com.didi.payment.commonsdk.fastpay;

import com.didi.global.fintech.cashier.user.facade.FastPayFacade;
import com.didi.global.fintech.cashier.user.model.FastPayCashierEnv;
import com.didi.global.fintech.cashier.user.model.ThirdParty;
import com.didi.global.fintech.cashier.user.model.ThirdPartyAbility;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/fastpay/FastPayUtils;", "", "()V", "getThreeParty", "", "getThreePartyAbility", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayUtils.kt */
public final class FastPayUtils {
    public static final FastPayUtils INSTANCE = new FastPayUtils();

    private FastPayUtils() {
    }

    public final String getThreeParty() {
        ThirdParty thirdParty;
        FastPayCashierEnv cashierEnv = FastPayFacade.Companion.getInstance().cashierEnv();
        if (cashierEnv == null) {
            thirdParty = null;
        } else {
            thirdParty = cashierEnv.getThird_party();
        }
        String json = new Gson().toJson((Object) thirdParty);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(thirdParty)");
        return json;
    }

    public final String getThreePartyAbility() {
        ThirdPartyAbility thirdPartyAbility;
        FastPayCashierEnv cashierEnv = FastPayFacade.Companion.getInstance().cashierEnv();
        if (cashierEnv == null) {
            thirdPartyAbility = null;
        } else {
            thirdPartyAbility = cashierEnv.getThird_party_ability();
        }
        String json = new Gson().toJson((Object) thirdPartyAbility);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(thirdPartyAbility)");
        return json;
    }
}
