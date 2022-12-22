package com.didi.global.fintech.cashier.user.utils;

import com.didi.dimina.container.secondparty.trace.inner.LogBase;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0002J*\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006H\u0002J$\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0007¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/user/utils/CashierUT;", "", "()V", "addGlobalAttrs", "", "attrs", "", "", "trackEvent", "eventId", "trackMerchantsEN", "fromType", "productId", "outTradeId", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CashierUT.kt */
public final class CashierUT {
    public static final CashierUT INSTANCE = new CashierUT();

    private CashierUT() {
    }

    public final void trackMerchantsEN(String str, String str2, String str3) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(CashierParam.PARAM_FROM_TYPE, str);
        if (str2 == null) {
            str2 = "";
        }
        linkedHashMap.put("product_id", str2);
        if (str3 == null) {
            str3 = "";
        }
        linkedHashMap.put("out_trade_id", str3);
        m15959a("ibgfintech_didipay_sdk_merchants_en", linkedHashMap);
    }

    /* renamed from: a */
    static /* synthetic */ void m15958a(CashierUT cashierUT, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        cashierUT.m15959a(str, map);
    }

    /* renamed from: a */
    private final void m15959a(String str, Map<String, Object> map) {
        if (map == null) {
            map = new LinkedHashMap<>();
        }
        m15960a(map);
        OmegaSDKAdapter.trackEvent(str, map);
    }

    /* renamed from: a */
    private final void m15960a(Map<String, Object> map) {
        map.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        map.put("pub_subbiz", "payment");
        map.put(LogBase.KEY_UID, CashierFacade.Companion.getInstance().getInitConfig().getUid());
    }
}
