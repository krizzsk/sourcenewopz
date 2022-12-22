package global.didi.pay.merchant.processor.contract;

import android.app.Activity;
import android.content.Context;
import global.didi.pay.merchant.processor.model.MerchantSDKRequest;
import global.didi.pay.merchantcore.model.DPayResponse;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/contract/IMerchantSDKProcessor;", "", "handleRequest", "", "activity", "Landroid/app/Activity;", "request", "Lglobal/didi/pay/merchant/processor/model/MerchantSDKRequest;", "handleResponse", "context", "Landroid/content/Context;", "response", "Lglobal/didi/pay/merchantcore/model/DPayResponse;", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IMerchantSDKProcessor.kt */
public interface IMerchantSDKProcessor {
    void handleRequest(Activity activity, MerchantSDKRequest merchantSDKRequest);

    void handleResponse(Context context, DPayResponse dPayResponse);
}
