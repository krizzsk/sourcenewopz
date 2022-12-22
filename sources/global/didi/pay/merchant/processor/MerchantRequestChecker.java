package global.didi.pay.merchant.processor;

import android.app.Activity;
import global.didi.pay.merchant.processor.model.MerchantSDKRequest;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/MerchantRequestChecker;", "", "isLogin", "", "login", "", "context", "Landroid/app/Activity;", "request", "Lglobal/didi/pay/merchant/processor/model/MerchantSDKRequest;", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MerchantRequestChecker.kt */
public interface MerchantRequestChecker {
    boolean isLogin();

    void login(Activity activity, MerchantSDKRequest merchantSDKRequest);
}
