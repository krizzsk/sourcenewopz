package global.didi.pay.merchant.processor.model;

import global.didi.pay.merchantcore.model.DPayResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/model/MerchantSDKResponse;", "Lglobal/didi/pay/merchant/processor/model/BaseMerchantResponse;", "response", "Lglobal/didi/pay/merchantcore/model/DPayResponse;", "(Lglobal/didi/pay/merchantcore/model/DPayResponse;)V", "getResponse", "()Lglobal/didi/pay/merchantcore/model/DPayResponse;", "type", "Lglobal/didi/pay/merchant/processor/model/MerchantRequestType;", "Companion", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MerchantProcessorModel.kt */
public final class MerchantSDKResponse extends BaseMerchantResponse {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final DPayResponse response;

    public /* synthetic */ MerchantSDKResponse(DPayResponse dPayResponse, DefaultConstructorMarker defaultConstructorMarker) {
        this(dPayResponse);
    }

    public final DPayResponse getResponse() {
        return this.response;
    }

    private MerchantSDKResponse(DPayResponse dPayResponse) {
        this.response = dPayResponse;
    }

    public MerchantRequestType type() {
        return MerchantRequestType.TYPE_MERCHANT_SDK;
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/model/MerchantSDKResponse$Companion;", "", "()V", "newIns", "Lglobal/didi/pay/merchant/processor/model/MerchantSDKResponse;", "intent", "Lglobal/didi/pay/merchantcore/model/DPayResponse;", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MerchantProcessorModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MerchantSDKResponse newIns(DPayResponse dPayResponse) {
            Intrinsics.checkNotNullParameter(dPayResponse, "intent");
            return new MerchantSDKResponse(dPayResponse, (DefaultConstructorMarker) null);
        }
    }
}
