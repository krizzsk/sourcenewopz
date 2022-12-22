package global.didi.pay.merchantcore.model;

import android.os.Parcel;
import android.os.Parcelable;
import global.didi.pay.merchantcore.model.DModelObject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 +2\u00020\u0001:\u0001+BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ji\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0006\u0010$\u001a\u00020\u001fJ\b\u0010%\u001a\u00020\u0003H\u0016J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020#H\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006,"}, mo175978d2 = {"Lglobal/didi/pay/merchantcore/model/DPayRequest;", "Lglobal/didi/pay/merchantcore/model/DModelObject;", "merchantOrderId", "", "payOrderId", "merchantId", "appId", "timestamp", "nonceStr", "version", "sign", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getMerchantId", "getMerchantOrderId", "getNonceStr", "getPayOrderId", "getSign", "getTimestamp", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "illegal", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "merchantCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DPayRequest.kt */
public final class DPayRequest extends DModelObject {
    public static final Parcelable.Creator<DPayRequest> CREATOR = new DModelObject.Creator(DPayRequest.class);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final DPayRequest EMPTY = new DPayRequest("", "", "", "", "", "", "", "");
    public static final String FIELD_APP_ID = "app_id";
    public static final String FIELD_MERCHANT_ID = "merchant_id";
    public static final String FIELD_MERCHANT_ORDER_ID = "merchant_order_id";
    public static final String FIELD_NONCE_STR = "nonce_str";
    public static final String FIELD_PAY_ORDER_ID = "pay_order_id";
    public static final String FIELD_SIGN = "sign";
    public static final String FIELD_TIMESTAMP = "timestamp";
    public static final String FIELD_VERSION = "version";
    public static final DModelObject.Serializer<DPayRequest> SERIALIZER = new DPayRequest$Companion$SERIALIZER$1();
    private final String appId;
    private final String merchantId;
    private final String merchantOrderId;
    private final String nonceStr;
    private final String payOrderId;
    private final String sign;
    private final String timestamp;
    private final String version;

    public static /* synthetic */ DPayRequest copy$default(DPayRequest dPayRequest, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
        DPayRequest dPayRequest2 = dPayRequest;
        int i2 = i;
        return dPayRequest.copy((i2 & 1) != 0 ? dPayRequest2.merchantOrderId : str, (i2 & 2) != 0 ? dPayRequest2.payOrderId : str2, (i2 & 4) != 0 ? dPayRequest2.merchantId : str3, (i2 & 8) != 0 ? dPayRequest2.appId : str4, (i2 & 16) != 0 ? dPayRequest2.timestamp : str5, (i2 & 32) != 0 ? dPayRequest2.nonceStr : str6, (i2 & 64) != 0 ? dPayRequest2.version : str7, (i2 & 128) != 0 ? dPayRequest2.sign : str8);
    }

    public final String component1() {
        return this.merchantOrderId;
    }

    public final String component2() {
        return this.payOrderId;
    }

    public final String component3() {
        return this.merchantId;
    }

    public final String component4() {
        return this.appId;
    }

    public final String component5() {
        return this.timestamp;
    }

    public final String component6() {
        return this.nonceStr;
    }

    public final String component7() {
        return this.version;
    }

    public final String component8() {
        return this.sign;
    }

    public final DPayRequest copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        return new DPayRequest(str, str2, str3, str4, str5, str6, str7, str8);
    }

    public int hashCode() {
        String str = this.merchantOrderId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.payOrderId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.merchantId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.appId;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.timestamp;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.nonceStr;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.version;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.sign;
        if (str8 != null) {
            i = str8.hashCode();
        }
        return hashCode7 + i;
    }

    public final String getMerchantOrderId() {
        return this.merchantOrderId;
    }

    public final String getPayOrderId() {
        return this.payOrderId;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final String getNonceStr() {
        return this.nonceStr;
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getSign() {
        return this.sign;
    }

    public DPayRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.merchantOrderId = str;
        this.payOrderId = str2;
        this.merchantId = str3;
        this.appId = str4;
        this.timestamp = str5;
        this.nonceStr = str6;
        this.version = str7;
        this.sign = str8;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "dest");
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lglobal/didi/pay/merchantcore/model/DPayRequest$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lglobal/didi/pay/merchantcore/model/DPayRequest;", "EMPTY", "getEMPTY", "()Lglobal/didi/pay/merchantcore/model/DPayRequest;", "FIELD_APP_ID", "", "FIELD_MERCHANT_ID", "FIELD_MERCHANT_ORDER_ID", "FIELD_NONCE_STR", "FIELD_PAY_ORDER_ID", "FIELD_SIGN", "FIELD_TIMESTAMP", "FIELD_VERSION", "SERIALIZER", "Lglobal/didi/pay/merchantcore/model/DModelObject$Serializer;", "merchantCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: DPayRequest.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DPayRequest getEMPTY() {
            return DPayRequest.EMPTY;
        }
    }

    public final boolean illegal() {
        CharSequence charSequence = this.merchantOrderId;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = this.payOrderId;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                CharSequence charSequence3 = this.merchantId;
                if (!(charSequence3 == null || charSequence3.length() == 0)) {
                    CharSequence charSequence4 = this.appId;
                    if (!(charSequence4 == null || charSequence4.length() == 0)) {
                        CharSequence charSequence5 = this.timestamp;
                        if (!(charSequence5 == null || charSequence5.length() == 0)) {
                            CharSequence charSequence6 = this.nonceStr;
                            if (!(charSequence6 == null || charSequence6.length() == 0)) {
                                CharSequence charSequence7 = this.sign;
                                if (charSequence7 == null || charSequence7.length() == 0) {
                                    return true;
                                }
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        DPayRequest dPayRequest = this;
        if ((obj == null || !(obj instanceof DPayRequest) ? this : null) != null) {
            return false;
        }
        String str = this.merchantOrderId;
        if (obj != null) {
            DPayRequest dPayRequest2 = (DPayRequest) obj;
            if (!Intrinsics.areEqual((Object) str, (Object) dPayRequest2.merchantOrderId) || !Intrinsics.areEqual((Object) this.payOrderId, (Object) dPayRequest2.payOrderId) || !Intrinsics.areEqual((Object) this.merchantId, (Object) dPayRequest2.merchantId) || !Intrinsics.areEqual((Object) this.appId, (Object) dPayRequest2.appId) || !Intrinsics.areEqual((Object) this.timestamp, (Object) dPayRequest2.timestamp) || !Intrinsics.areEqual((Object) this.nonceStr, (Object) dPayRequest2.nonceStr) || !Intrinsics.areEqual((Object) this.sign, (Object) dPayRequest2.sign)) {
                return false;
            }
            return true;
        }
        throw new TypeCastException("null cannot be cast to non-null type global.didi.pay.merchantcore.model.DPayRequest");
    }

    public String toString() {
        return "merchant_order_id:" + this.merchantOrderId + ' ' + "pay_order_id:" + this.payOrderId + ' ' + "merchant_id:" + this.merchantId + ' ' + "app_id:" + this.appId + ' ' + "timestamp:" + this.timestamp + ' ' + "nonce_str:" + this.nonceStr + ' ' + "version:" + this.version + ' ' + "sign:" + this.sign;
    }
}
