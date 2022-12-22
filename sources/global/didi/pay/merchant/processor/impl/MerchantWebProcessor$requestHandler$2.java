package global.didi.pay.merchant.processor.impl;

import com.didichuxing.foundation.spi.ServiceLoader;
import global.didi.pay.merchant.processor.MerchantRequestHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didichuxing/foundation/spi/ServiceLoader;", "Lglobal/didi/pay/merchant/processor/MerchantRequestHandler;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MerchantWebProcessor.kt */
final class MerchantWebProcessor$requestHandler$2 extends Lambda implements Function0<ServiceLoader<MerchantRequestHandler>> {
    public static final MerchantWebProcessor$requestHandler$2 INSTANCE = new MerchantWebProcessor$requestHandler$2();

    MerchantWebProcessor$requestHandler$2() {
        super(0);
    }

    public final ServiceLoader<MerchantRequestHandler> invoke() {
        return ServiceLoader.load(MerchantRequestHandler.class);
    }
}
