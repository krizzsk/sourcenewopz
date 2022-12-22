package global.didi.pay.merchant.processor.contract;

import android.app.Activity;
import android.content.Context;
import global.didi.pay.merchant.processor.model.MerchantWebRequest;
import global.didi.pay.merchant.processor.model.MerchantWebResponse;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/contract/IMerchantWebProcessor;", "", "handleRequest", "", "activity", "Landroid/app/Activity;", "request", "Lglobal/didi/pay/merchant/processor/model/MerchantWebRequest;", "handleResponse", "context", "Landroid/content/Context;", "response", "Lglobal/didi/pay/merchant/processor/model/MerchantWebResponse;", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IMerchantWebProcessor.kt */
public interface IMerchantWebProcessor {
    void handleRequest(Activity activity, MerchantWebRequest merchantWebRequest);

    void handleResponse(Context context, MerchantWebResponse merchantWebResponse);
}
