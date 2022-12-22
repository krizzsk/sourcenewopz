package global.didi.pay.merchant.processor;

import android.app.Activity;
import global.didi.pay.merchant.processor.model.MerchantRequestType;
import global.didi.pay.merchantcore.model.DPayRequest;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0010"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/MerchantRequestHandler;", "", "startMerchantRequest", "", "newVersion", "", "activity", "Landroid/app/Activity;", "type", "Lglobal/didi/pay/merchant/processor/model/MerchantRequestType;", "outTradeId", "", "payRequest", "Lglobal/didi/pay/merchantcore/model/DPayRequest;", "extraParam", "Lorg/json/JSONObject;", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MerchantRequestHandler.kt */
public interface MerchantRequestHandler {
    void startMerchantRequest(boolean z, Activity activity, MerchantRequestType merchantRequestType, String str, DPayRequest dPayRequest, JSONObject jSONObject);
}
