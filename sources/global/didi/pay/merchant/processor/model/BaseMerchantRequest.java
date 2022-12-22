package global.didi.pay.merchant.processor.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0011\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/model/BaseMerchantRequest;", "", "fromType", "", "(Ljava/lang/String;)V", "getFromType", "()Ljava/lang/String;", "illegal", "", "type", "Lglobal/didi/pay/merchant/processor/model/MerchantRequestType;", "Companion", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MerchantProcessorModel.kt */
public abstract class BaseMerchantRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_PARAM_KEY_FROM_TYPE = "FROM_TYPE";
    private final String fromType;

    public abstract boolean illegal();

    public abstract MerchantRequestType type();

    public BaseMerchantRequest(String str) {
        this.fromType = str;
    }

    public final String getFromType() {
        return this.fromType;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/model/BaseMerchantRequest$Companion;", "", "()V", "EXTRA_PARAM_KEY_FROM_TYPE", "", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MerchantProcessorModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
