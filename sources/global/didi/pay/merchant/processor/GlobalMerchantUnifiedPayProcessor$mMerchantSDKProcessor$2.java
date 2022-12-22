package global.didi.pay.merchant.processor;

import global.didi.pay.merchant.processor.impl.MerchantSDKProcessor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lglobal/didi/pay/merchant/processor/impl/MerchantSDKProcessor;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalMerchantUnifiedPayProcessor.kt */
final class GlobalMerchantUnifiedPayProcessor$mMerchantSDKProcessor$2 extends Lambda implements Function0<MerchantSDKProcessor> {
    public static final GlobalMerchantUnifiedPayProcessor$mMerchantSDKProcessor$2 INSTANCE = new GlobalMerchantUnifiedPayProcessor$mMerchantSDKProcessor$2();

    GlobalMerchantUnifiedPayProcessor$mMerchantSDKProcessor$2() {
        super(0);
    }

    public final MerchantSDKProcessor invoke() {
        return new MerchantSDKProcessor();
    }
}
