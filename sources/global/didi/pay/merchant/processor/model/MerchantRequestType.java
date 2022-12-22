package global.didi.pay.merchant.processor.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/model/MerchantRequestType;", "", "(Ljava/lang/String;I)V", "string", "", "TYPE_MERCHANT_SDK", "TYPE_H5", "TYPE_PC", "Companion", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MerchantProcessorModel.kt */
public enum MerchantRequestType {
    TYPE_MERCHANT_SDK,
    TYPE_H5,
    TYPE_PC;
    
    public static final Companion Companion = null;

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/model/MerchantRequestType$Companion;", "", "()V", "type", "Lglobal/didi/pay/merchant/processor/model/MerchantRequestType;", "fromType", "", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MerchantProcessorModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MerchantRequestType type(String str) {
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != -1355676381) {
                    if (hashCode != 2285) {
                        if (hashCode == 2547 && str.equals("PC")) {
                            return MerchantRequestType.TYPE_PC;
                        }
                    } else if (str.equals("H5")) {
                        return MerchantRequestType.TYPE_H5;
                    }
                } else if (str.equals("MERCHANT_SDK")) {
                    return MerchantRequestType.TYPE_MERCHANT_SDK;
                }
            }
            return null;
        }
    }

    public final String string() {
        if (this == TYPE_MERCHANT_SDK) {
            return "MERCHANT_SDK";
        }
        if (this == TYPE_H5) {
            return "H5";
        }
        return this == TYPE_PC ? "PC" : "NATIVE";
    }
}
