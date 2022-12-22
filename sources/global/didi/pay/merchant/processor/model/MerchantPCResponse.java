package global.didi.pay.merchant.processor.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/model/MerchantPCResponse;", "Lglobal/didi/pay/merchant/processor/model/MerchantWebResponse;", "()V", "type", "Lglobal/didi/pay/merchant/processor/model/MerchantRequestType;", "Companion", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MerchantProcessorModel.kt */
public final class MerchantPCResponse extends MerchantWebResponse {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public /* synthetic */ MerchantPCResponse(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private MerchantPCResponse() {
    }

    public MerchantRequestType type() {
        return MerchantRequestType.TYPE_PC;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/model/MerchantPCResponse$Companion;", "", "()V", "newIns", "Lglobal/didi/pay/merchant/processor/model/MerchantPCResponse;", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MerchantProcessorModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MerchantPCResponse newIns() {
            return new MerchantPCResponse((DefaultConstructorMarker) null);
        }
    }
}
