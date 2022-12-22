package com.didi.unifiedPay.spi;

import android.app.Activity;
import com.didi.unifiedPay.component.model.PayParam;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import global.didi.pay.merchant.GlobalMerchantUniPayActivity;
import global.didi.pay.merchant.processor.MerchantRequestHandler;
import global.didi.pay.merchant.processor.model.MerchantRequestType;
import global.didi.pay.merchantcore.model.DPayRequest;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@ServiceProvider(alias = "globalapi", value = {MerchantRequestHandler.class})
@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/unifiedPay/spi/MerchantRequestHandlerImpl;", "Lglobal/didi/pay/merchant/processor/MerchantRequestHandler;", "()V", "startMerchantRequest", "", "newVersion", "", "activity", "Landroid/app/Activity;", "type", "Lglobal/didi/pay/merchant/processor/model/MerchantRequestType;", "outTradeId", "", "payRequest", "Lglobal/didi/pay/merchantcore/model/DPayRequest;", "extraParam", "Lorg/json/JSONObject;", "pay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
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
        PayParam payParam;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(merchantRequestType, "type");
        if (!z) {
            int i = WhenMappings.$EnumSwitchMapping$0[merchantRequestType.ordinal()];
            if (i == 1) {
                payParam = PayParam.EMPTY_PARAM;
            } else if (i == 2) {
                payParam = new PayParam();
                payParam.outTradeId = str;
            } else if (i == 3) {
                payParam = new PayParam();
                payParam.outTradeId = str;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            PayParam payParam2 = payParam;
            GlobalMerchantUniPayActivity.Companion companion = GlobalMerchantUniPayActivity.Companion;
            Intrinsics.checkNotNullExpressionValue(payParam2, "payParam");
            companion.startActivity(activity, merchantRequestType, payParam2, dPayRequest, jSONObject);
        }
    }
}
