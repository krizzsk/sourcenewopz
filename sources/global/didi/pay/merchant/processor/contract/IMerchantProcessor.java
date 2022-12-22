package global.didi.pay.merchant.processor.contract;

import android.app.Activity;
import android.content.Context;
import global.didi.pay.merchant.processor.model.BaseMerchantRequest;
import global.didi.pay.merchant.processor.model.BaseMerchantResponse;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/contract/IMerchantProcessor;", "", "onHandleMerchantRequest", "", "activity", "Landroid/app/Activity;", "request", "Lglobal/didi/pay/merchant/processor/model/BaseMerchantRequest;", "onHandleMerchantResponse", "", "context", "Landroid/content/Context;", "response", "Lglobal/didi/pay/merchant/processor/model/BaseMerchantResponse;", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IMerchantProcessor.kt */
public interface IMerchantProcessor {
    boolean onHandleMerchantRequest(Activity activity, BaseMerchantRequest baseMerchantRequest);

    void onHandleMerchantResponse(Context context, BaseMerchantResponse baseMerchantResponse);
}
