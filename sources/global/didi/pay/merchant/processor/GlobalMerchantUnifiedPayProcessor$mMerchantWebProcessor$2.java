package global.didi.pay.merchant.processor;

import global.didi.pay.merchant.processor.impl.MerchantWebProcessor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lglobal/didi/pay/merchant/processor/impl/MerchantWebProcessor;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalMerchantUnifiedPayProcessor.kt */
final class GlobalMerchantUnifiedPayProcessor$mMerchantWebProcessor$2 extends Lambda implements Function0<MerchantWebProcessor> {
    public static final GlobalMerchantUnifiedPayProcessor$mMerchantWebProcessor$2 INSTANCE = new GlobalMerchantUnifiedPayProcessor$mMerchantWebProcessor$2();

    GlobalMerchantUnifiedPayProcessor$mMerchantWebProcessor$2() {
        super(0);
    }

    public final MerchantWebProcessor invoke() {
        return new MerchantWebProcessor();
    }
}
