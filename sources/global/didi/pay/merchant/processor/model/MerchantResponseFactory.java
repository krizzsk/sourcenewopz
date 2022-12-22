package global.didi.pay.merchant.processor.model;

import global.didi.pay.merchantcore.model.DPayResponse;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/model/MerchantResponseFactory;", "", "()V", "Companion", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MerchantProcessorModel.kt */
public final class MerchantResponseFactory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final BaseMerchantResponse getInstance(MerchantRequestType merchantRequestType, DPayResponse dPayResponse, String str) {
        return Companion.getInstance(merchantRequestType, dPayResponse, str);
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007¨\u0006\u000b"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/model/MerchantResponseFactory$Companion;", "", "()V", "getInstance", "Lglobal/didi/pay/merchant/processor/model/BaseMerchantResponse;", "type", "Lglobal/didi/pay/merchant/processor/model/MerchantRequestType;", "response", "Lglobal/didi/pay/merchantcore/model/DPayResponse;", "url", "", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MerchantProcessorModel.kt */
    public static final class Companion {

        @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: MerchantProcessorModel.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[MerchantRequestType.values().length];
                iArr[MerchantRequestType.TYPE_MERCHANT_SDK.ordinal()] = 1;
                iArr[MerchantRequestType.TYPE_PC.ordinal()] = 2;
                iArr[MerchantRequestType.TYPE_H5.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BaseMerchantResponse getInstance(MerchantRequestType merchantRequestType, DPayResponse dPayResponse, String str) {
            Intrinsics.checkNotNullParameter(merchantRequestType, "type");
            Intrinsics.checkNotNullParameter(dPayResponse, "response");
            int i = WhenMappings.$EnumSwitchMapping$0[merchantRequestType.ordinal()];
            if (i == 1) {
                return MerchantSDKResponse.Companion.newIns(dPayResponse);
            }
            if (i == 2) {
                return MerchantPCResponse.Companion.newIns();
            }
            if (i == 3) {
                return MerchantH5Response.Companion.newIns(str);
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
