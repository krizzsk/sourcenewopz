package global.didi.pay.merchant.processor.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/model/MerchantH5Response;", "Lglobal/didi/pay/merchant/processor/model/MerchantWebResponse;", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "type", "Lglobal/didi/pay/merchant/processor/model/MerchantRequestType;", "Companion", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MerchantProcessorModel.kt */
public final class MerchantH5Response extends MerchantWebResponse {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String url;

    public /* synthetic */ MerchantH5Response(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public final String getUrl() {
        return this.url;
    }

    private MerchantH5Response(String str) {
        this.url = str;
    }

    public MerchantRequestType type() {
        return MerchantRequestType.TYPE_H5;
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/model/MerchantH5Response$Companion;", "", "()V", "newIns", "Lglobal/didi/pay/merchant/processor/model/MerchantH5Response;", "url", "", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MerchantProcessorModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MerchantH5Response newIns(String str) {
            return new MerchantH5Response(str, (DefaultConstructorMarker) null);
        }
    }
}
