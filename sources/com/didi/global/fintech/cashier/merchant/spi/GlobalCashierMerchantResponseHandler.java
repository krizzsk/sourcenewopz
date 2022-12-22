package com.didi.global.fintech.cashier.merchant.spi;

import android.app.Activity;
import android.content.Context;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierMerchantResponseHandler;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import global.didi.pay.merchant.processor.GlobalMerchantUnifiedPayProcessor;
import global.didi.pay.merchant.processor.model.MerchantRequestType;
import global.didi.pay.merchant.processor.model.MerchantResponseFactory;
import global.didi.pay.merchantcore.model.DPayResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "globalapi", value = {IGlobalCashierMerchantResponseHandler.class})
@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J3\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/merchant/spi/GlobalCashierMerchantResponseHandler;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierMerchantResponseHandler;", "()V", "onHandle", "", "context", "Landroid/content/Context;", "result", "", "fromType", "", "url", "(Landroid/content/Context;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "cashier_merchant_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierMerchantResponseHandler.kt */
public final class GlobalCashierMerchantResponseHandler implements IGlobalCashierMerchantResponseHandler {
    public void onHandle(Context context, Integer num, String str, String str2) {
        DPayResponse dPayResponse;
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "context");
        MerchantRequestType type = MerchantRequestType.Companion.type(str);
        if (num != null && num.intValue() == 1) {
            dPayResponse = DPayResponse.Companion.getSUCCESS();
        } else if (num != null && num.intValue() == 2) {
            dPayResponse = DPayResponse.Companion.getCANCEL();
        } else {
            dPayResponse = DPayResponse.Companion.getCANCEL();
        }
        Activity activity = null;
        if (type == null) {
            unit = null;
        } else {
            GlobalMerchantUnifiedPayProcessor.INS.onHandleMerchantResponse(context, MerchantResponseFactory.Companion.getInstance(type, dPayResponse, str2));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            GlobalCashierMerchantResponseHandler globalCashierMerchantResponseHandler = this;
            if (context instanceof Activity) {
                activity = (Activity) context;
            }
            if (activity != null) {
                activity.finish();
            }
        }
    }
}
