package global.didi.pay.merchant.processor.model;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/model/MerchantSDKRequest;", "Lglobal/didi/pay/merchant/processor/model/BaseMerchantRequest;", "requestIntent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "getRequestIntent", "()Landroid/content/Intent;", "illegal", "", "type", "Lglobal/didi/pay/merchant/processor/model/MerchantRequestType;", "Companion", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MerchantProcessorModel.kt */
public final class MerchantSDKRequest extends BaseMerchantRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Intent requestIntent;

    public /* synthetic */ MerchantSDKRequest(Intent intent, DefaultConstructorMarker defaultConstructorMarker) {
        this(intent);
    }

    public final Intent getRequestIntent() {
        return this.requestIntent;
    }

    private MerchantSDKRequest(Intent intent) {
        super("MERCHANT_SDK");
        this.requestIntent = intent;
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/model/MerchantSDKRequest$Companion;", "", "()V", "newIns", "Lglobal/didi/pay/merchant/processor/model/MerchantSDKRequest;", "intent", "Landroid/content/Intent;", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MerchantProcessorModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MerchantSDKRequest newIns(Intent intent) {
            return new MerchantSDKRequest(intent, (DefaultConstructorMarker) null);
        }
    }

    public MerchantRequestType type() {
        return MerchantRequestType.TYPE_MERCHANT_SDK;
    }

    public boolean illegal() {
        return this.requestIntent == null;
    }
}
