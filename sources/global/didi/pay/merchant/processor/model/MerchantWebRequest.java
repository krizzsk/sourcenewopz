package global.didi.pay.merchant.processor.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001b\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/model/MerchantWebRequest;", "Lglobal/didi/pay/merchant/processor/model/BaseMerchantRequest;", "outTradeId", "", "fromType", "(Ljava/lang/String;Ljava/lang/String;)V", "extraParam", "Lorg/json/JSONObject;", "getExtraParam", "()Lorg/json/JSONObject;", "setExtraParam", "(Lorg/json/JSONObject;)V", "getOutTradeId", "()Ljava/lang/String;", "illegal", "", "type", "Lglobal/didi/pay/merchant/processor/model/MerchantRequestType;", "Companion", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MerchantProcessorModel.kt */
public final class MerchantWebRequest extends BaseMerchantRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private JSONObject extraParam;
    private final String outTradeId;

    public /* synthetic */ MerchantWebRequest(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public final String getOutTradeId() {
        return this.outTradeId;
    }

    private MerchantWebRequest(String str, String str2) {
        super(str2);
        this.outTradeId = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        if (r0.equals("pc") == false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        if (r0.equals(com.xiaojuchefu.prism.monitor.PrismConstants.Symbol.f56077H5) == false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        if (r0.equals("PC") == false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        if (r0.equals("H5") == false) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public global.didi.pay.merchant.processor.model.MerchantRequestType type() {
        /*
            r3 = this;
            java.lang.String r0 = r3.getFromType()
            if (r0 == 0) goto L_0x0045
            int r1 = r0.hashCode()
            r2 = 2285(0x8ed, float:3.202E-42)
            if (r1 == r2) goto L_0x0039
            r2 = 2547(0x9f3, float:3.569E-42)
            if (r1 == r2) goto L_0x002d
            r2 = 3277(0xccd, float:4.592E-42)
            if (r1 == r2) goto L_0x0024
            r2 = 3571(0xdf3, float:5.004E-42)
            if (r1 == r2) goto L_0x001b
            goto L_0x0045
        L_0x001b:
            java.lang.String r1 = "pc"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0036
            goto L_0x0045
        L_0x0024:
            java.lang.String r1 = "h5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0042
            goto L_0x0045
        L_0x002d:
            java.lang.String r1 = "PC"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0036
            goto L_0x0045
        L_0x0036:
            global.didi.pay.merchant.processor.model.MerchantRequestType r0 = global.didi.pay.merchant.processor.model.MerchantRequestType.TYPE_PC
            goto L_0x0047
        L_0x0039:
            java.lang.String r1 = "H5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0042
            goto L_0x0045
        L_0x0042:
            global.didi.pay.merchant.processor.model.MerchantRequestType r0 = global.didi.pay.merchant.processor.model.MerchantRequestType.TYPE_H5
            goto L_0x0047
        L_0x0045:
            global.didi.pay.merchant.processor.model.MerchantRequestType r0 = global.didi.pay.merchant.processor.model.MerchantRequestType.TYPE_H5
        L_0x0047:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: global.didi.pay.merchant.processor.model.MerchantWebRequest.type():global.didi.pay.merchant.processor.model.MerchantRequestType");
    }

    public final JSONObject getExtraParam() {
        return this.extraParam;
    }

    public final void setExtraParam(JSONObject jSONObject) {
        this.extraParam = jSONObject;
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\b"}, mo175978d2 = {"Lglobal/didi/pay/merchant/processor/model/MerchantWebRequest$Companion;", "", "()V", "newIns", "Lglobal/didi/pay/merchant/processor/model/MerchantWebRequest;", "outTradeId", "", "fromType", "payMerchantProcessor_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MerchantProcessorModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MerchantWebRequest newIns(String str, String str2) {
            return new MerchantWebRequest(str, str2, (DefaultConstructorMarker) null);
        }
    }

    public boolean illegal() {
        String str = this.outTradeId;
        if (str != null) {
            if (str.length() == 0) {
                return true;
            }
        }
        return false;
    }
}
