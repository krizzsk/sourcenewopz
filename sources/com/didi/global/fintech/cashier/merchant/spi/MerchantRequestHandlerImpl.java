package com.didi.global.fintech.cashier.merchant.spi;

import android.app.Activity;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.facade.CashierLaunchListener;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.global.fintech.cashier.user.utils.CashierUT;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.google.gson.Gson;
import global.didi.pay.merchant.processor.MerchantRequestHandler;
import global.didi.pay.merchant.processor.model.MerchantRequestType;
import global.didi.pay.merchantcore.model.DPayRequest;
import global.didi.pay.merchantcore.model.JsonUtilsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@ServiceProvider(alias = "globalapi", value = {MerchantRequestHandler.class})
@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/merchant/spi/MerchantRequestHandlerImpl;", "Lglobal/didi/pay/merchant/processor/MerchantRequestHandler;", "()V", "startMerchantRequest", "", "newVersion", "", "activity", "Landroid/app/Activity;", "type", "Lglobal/didi/pay/merchant/processor/model/MerchantRequestType;", "outTradeId", "", "payRequest", "Lglobal/didi/pay/merchantcore/model/DPayRequest;", "extraParam", "Lorg/json/JSONObject;", "cashier_merchant_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MerchantRequestHandlerImpl.kt */
public final class MerchantRequestHandlerImpl implements MerchantRequestHandler {

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MerchantRequestHandlerImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MerchantRequestType.values().length];
            iArr[MerchantRequestType.TYPE_MERCHANT_SDK.ordinal()] = 1;
            iArr[MerchantRequestType.TYPE_PC.ordinal()] = 2;
            iArr[MerchantRequestType.TYPE_H5.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void startMerchantRequest(boolean z, Activity activity, MerchantRequestType merchantRequestType, String str, DPayRequest dPayRequest, JSONObject jSONObject) {
        CashierParam cashierParam;
        String str2;
        String str3;
        String str4;
        Activity activity2 = activity;
        String str5 = str;
        DPayRequest dPayRequest2 = dPayRequest;
        JSONObject jSONObject2 = jSONObject;
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(merchantRequestType, "type");
        if (z) {
            int i = WhenMappings.$EnumSwitchMapping$0[merchantRequestType.ordinal()];
            if (i == 1) {
                String payOrderId = dPayRequest2 == null ? null : dPayRequest.getPayOrderId();
                if (dPayRequest2 == null) {
                    str2 = null;
                } else {
                    str2 = dPayRequest.getSign();
                }
                cashierParam = new CashierParam(str2, "RSA", new Gson().toJson((Object) dPayRequest2), payOrderId, (Map) null, (Map) null, (String) null, 112, (DefaultConstructorMarker) null);
                cashierParam.getExtraParams().put(CashierParam.PARAM_FROM_TYPE, merchantRequestType.string());
                Map<String, Object> extraParams = cashierParam.getExtraParams();
                if (jSONObject2 == null || (str3 = JsonUtilsKt.getStringOrNull(jSONObject2, "wsgenv")) == null) {
                    str3 = "";
                }
                extraParams.put(CashierParam.PARAM_MERCHANT_WSG_ENV, str3);
            } else if (i == 2) {
                cashierParam = CashierParam.Companion.insByOutTradeId(str5);
                cashierParam.getExtraParams().put(CashierParam.PARAM_FROM_TYPE, merchantRequestType.string());
            } else if (i == 3) {
                cashierParam = CashierParam.Companion.insByOutTradeId(str5);
                cashierParam.getExtraParams().put(CashierParam.PARAM_FROM_TYPE, merchantRequestType.string());
                Map<String, Object> extraParams2 = cashierParam.getExtraParams();
                if (jSONObject2 == null || (str4 = JsonUtilsKt.getStringOrNull(jSONObject2, "wsgenv")) == null) {
                    str4 = "";
                }
                extraParams2.put(CashierParam.PARAM_MERCHANT_WSG_ENV, str4);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            CashierFacade.Companion.getInstance().launch(activity2, cashierParam, (CashierLaunchListener) null);
            CashierUT.INSTANCE.trackMerchantsEN(merchantRequestType.string(), "", str5);
        }
    }
}
