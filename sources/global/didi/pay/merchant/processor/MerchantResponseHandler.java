package global.didi.pay.merchant.processor;

import android.app.Activity;
import global.didi.pay.merchantcore.model.DPayRequest;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/MerchantResponseHandler;", "", "startMerchantResponse", "", "activity", "Landroid/app/Activity;", "payRequest", "Lglobal/didi/pay/merchantcore/model/DPayRequest;", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MerchantResponseHandler.kt */
public interface MerchantResponseHandler {
    void startMerchantResponse(Activity activity, DPayRequest dPayRequest);
}
