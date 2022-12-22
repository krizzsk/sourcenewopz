package global.didi.pay.merchant.processor;

import android.content.Context;
import global.didi.pay.merchant.processor.contract.IMerchantProcessor;
import global.didi.pay.merchant.processor.contract.IMerchantSDKProcessor;
import global.didi.pay.merchant.processor.contract.IMerchantWebProcessor;
import global.didi.pay.merchant.processor.model.BaseMerchantResponse;
import global.didi.pay.merchant.processor.model.MerchantRequestType;
import global.didi.pay.merchant.processor.model.MerchantSDKResponse;
import global.didi.pay.merchant.processor.model.MerchantWebResponse;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/GlobalMerchantUnifiedPayProcessor;", "Lglobal/didi/pay/merchant/processor/contract/IMerchantProcessor;", "()V", "mMerchantSDKProcessor", "Lglobal/didi/pay/merchant/processor/contract/IMerchantSDKProcessor;", "getMMerchantSDKProcessor", "()Lglobal/didi/pay/merchant/processor/contract/IMerchantSDKProcessor;", "mMerchantSDKProcessor$delegate", "Lkotlin/Lazy;", "mMerchantWebProcessor", "Lglobal/didi/pay/merchant/processor/contract/IMerchantWebProcessor;", "getMMerchantWebProcessor", "()Lglobal/didi/pay/merchant/processor/contract/IMerchantWebProcessor;", "mMerchantWebProcessor$delegate", "onHandleMerchantRequest", "", "activity", "Landroid/app/Activity;", "request", "Lglobal/didi/pay/merchant/processor/model/BaseMerchantRequest;", "onHandleMerchantResponse", "", "context", "Landroid/content/Context;", "merchantResponse", "Lglobal/didi/pay/merchant/processor/model/BaseMerchantResponse;", "Companion", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalMerchantUnifiedPayProcessor.kt */
public final class GlobalMerchantUnifiedPayProcessor implements IMerchantProcessor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final GlobalMerchantUnifiedPayProcessor INS = new GlobalMerchantUnifiedPayProcessor();
    private final Lazy mMerchantSDKProcessor$delegate = LazyKt.lazy(GlobalMerchantUnifiedPayProcessor$mMerchantSDKProcessor$2.INSTANCE);
    private final Lazy mMerchantWebProcessor$delegate = LazyKt.lazy(GlobalMerchantUnifiedPayProcessor$mMerchantWebProcessor$2.INSTANCE);

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalMerchantUnifiedPayProcessor.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MerchantRequestType.values().length];
            iArr[MerchantRequestType.TYPE_MERCHANT_SDK.ordinal()] = 1;
            iArr[MerchantRequestType.TYPE_H5.ordinal()] = 2;
            iArr[MerchantRequestType.TYPE_PC.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final IMerchantSDKProcessor getMMerchantSDKProcessor() {
        return (IMerchantSDKProcessor) this.mMerchantSDKProcessor$delegate.getValue();
    }

    private final IMerchantWebProcessor getMMerchantWebProcessor() {
        return (IMerchantWebProcessor) this.mMerchantWebProcessor$delegate.getValue();
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/GlobalMerchantUnifiedPayProcessor$Companion;", "", "()V", "INS", "Lglobal/didi/pay/merchant/processor/GlobalMerchantUnifiedPayProcessor;", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalMerchantUnifiedPayProcessor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: global.didi.pay.merchant.processor.model.MerchantSDKRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: global.didi.pay.merchant.processor.model.MerchantWebRequest} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onHandleMerchantRequest(android.app.Activity r5, global.didi.pay.merchant.processor.model.BaseMerchantRequest r6) {
        /*
            r4 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = r4
            global.didi.pay.merchant.processor.GlobalMerchantUnifiedPayProcessor r0 = (global.didi.pay.merchant.processor.GlobalMerchantUnifiedPayProcessor) r0
            r0 = 0
            r1 = 1
            if (r6 != 0) goto L_0x000e
        L_0x000c:
            r2 = 0
            goto L_0x0015
        L_0x000e:
            boolean r2 = r6.illegal()
            if (r2 != r1) goto L_0x000c
            r2 = 1
        L_0x0015:
            r3 = 0
            if (r2 == 0) goto L_0x001a
            r2 = r4
            goto L_0x001b
        L_0x001a:
            r2 = r3
        L_0x001b:
            global.didi.pay.merchant.processor.GlobalMerchantUnifiedPayProcessor r2 = (global.didi.pay.merchant.processor.GlobalMerchantUnifiedPayProcessor) r2
            if (r2 != 0) goto L_0x005a
            if (r6 != 0) goto L_0x0023
            r0 = r3
            goto L_0x0027
        L_0x0023:
            global.didi.pay.merchant.processor.model.MerchantRequestType r0 = r6.type()
        L_0x0027:
            if (r0 != 0) goto L_0x002b
            r0 = -1
            goto L_0x0033
        L_0x002b:
            int[] r2 = global.didi.pay.merchant.processor.GlobalMerchantUnifiedPayProcessor.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r2[r0]
        L_0x0033:
            if (r0 == r1) goto L_0x004b
            r2 = 2
            if (r0 == r2) goto L_0x003c
            r2 = 3
            if (r0 == r2) goto L_0x003c
            goto L_0x0059
        L_0x003c:
            global.didi.pay.merchant.processor.contract.IMerchantWebProcessor r0 = r4.getMMerchantWebProcessor()
            boolean r2 = r6 instanceof global.didi.pay.merchant.processor.model.MerchantWebRequest
            if (r2 == 0) goto L_0x0047
            r3 = r6
            global.didi.pay.merchant.processor.model.MerchantWebRequest r3 = (global.didi.pay.merchant.processor.model.MerchantWebRequest) r3
        L_0x0047:
            r0.handleRequest(r5, r3)
            goto L_0x0059
        L_0x004b:
            global.didi.pay.merchant.processor.contract.IMerchantSDKProcessor r0 = r4.getMMerchantSDKProcessor()
            boolean r2 = r6 instanceof global.didi.pay.merchant.processor.model.MerchantSDKRequest
            if (r2 == 0) goto L_0x0056
            r3 = r6
            global.didi.pay.merchant.processor.model.MerchantSDKRequest r3 = (global.didi.pay.merchant.processor.model.MerchantSDKRequest) r3
        L_0x0056:
            r0.handleRequest(r5, r3)
        L_0x0059:
            return r1
        L_0x005a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: global.didi.pay.merchant.processor.GlobalMerchantUnifiedPayProcessor.onHandleMerchantRequest(android.app.Activity, global.didi.pay.merchant.processor.model.BaseMerchantRequest):boolean");
    }

    public void onHandleMerchantResponse(Context context, BaseMerchantResponse baseMerchantResponse) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(baseMerchantResponse, "merchantResponse");
        int i = WhenMappings.$EnumSwitchMapping$0[baseMerchantResponse.type().ordinal()];
        if (i == 1) {
            getMMerchantSDKProcessor().handleResponse(context, ((MerchantSDKResponse) baseMerchantResponse).getResponse());
        } else if (i == 2 || i == 3) {
            getMMerchantWebProcessor().handleResponse(context, (MerchantWebResponse) baseMerchantResponse);
        }
    }
}
