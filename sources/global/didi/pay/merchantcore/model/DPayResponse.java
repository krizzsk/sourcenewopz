package global.didi.pay.merchantcore.model;

import android.os.Parcel;
import android.os.Parcelable;
import global.didi.pay.merchantcore.model.DModelObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, mo175978d2 = {"Lglobal/didi/pay/merchantcore/model/DPayResponse;", "Lglobal/didi/pay/merchantcore/model/DModelObject;", "payStatus", "", "msg", "Lglobal/didi/pay/merchantcore/model/DPayMsg;", "(ILglobal/didi/pay/merchantcore/model/DPayMsg;)V", "getMsg", "()Lglobal/didi/pay/merchantcore/model/DPayMsg;", "getPayStatus", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "merchantCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DPayResponse.kt */
public final class DPayResponse extends DModelObject {
    /* access modifiers changed from: private */
    public static final DPayResponse CANCEL = new DPayResponse(3, new DPayMsg(20001, "Cancel"));
    public static final Parcelable.Creator<DPayResponse> CREATOR = new DModelObject.Creator(DPayResponse.class);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FIELD_MSG = "msg";
    public static final String FIELD_PAY_STATUS = "pay_status";
    public static final int PAY_STATUS_CANCEL = 3;
    public static final int PAY_STATUS_FAILED = 2;
    public static final int PAY_STATUS_SUCCESS = 1;
    public static final int PAY_STATUS_UNKNOWN = 4;
    public static final DModelObject.Serializer<DPayResponse> SERIALIZER = new DPayResponse$Companion$SERIALIZER$1();
    /* access modifiers changed from: private */
    public static final DPayResponse SUCCESS = new DPayResponse(1, new DPayMsg(0, "Success"));
    private final DPayMsg msg;
    private final int payStatus;

    public static /* synthetic */ DPayResponse copy$default(DPayResponse dPayResponse, int i, DPayMsg dPayMsg, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = dPayResponse.payStatus;
        }
        if ((i2 & 2) != 0) {
            dPayMsg = dPayResponse.msg;
        }
        return dPayResponse.copy(i, dPayMsg);
    }

    public final int component1() {
        return this.payStatus;
    }

    public final DPayMsg component2() {
        return this.msg;
    }

    public final DPayResponse copy(int i, DPayMsg dPayMsg) {
        Intrinsics.checkParameterIsNotNull(dPayMsg, "msg");
        return new DPayResponse(i, dPayMsg);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DPayResponse)) {
            return false;
        }
        DPayResponse dPayResponse = (DPayResponse) obj;
        return this.payStatus == dPayResponse.payStatus && Intrinsics.areEqual((Object) this.msg, (Object) dPayResponse.msg);
    }

    public int hashCode() {
        int i = this.payStatus * 31;
        DPayMsg dPayMsg = this.msg;
        return i + (dPayMsg != null ? dPayMsg.hashCode() : 0);
    }

    public DPayResponse(int i, DPayMsg dPayMsg) {
        Intrinsics.checkParameterIsNotNull(dPayMsg, "msg");
        this.payStatus = i;
        this.msg = dPayMsg;
    }

    public final DPayMsg getMsg() {
        return this.msg;
    }

    public final int getPayStatus() {
        return this.payStatus;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "dest");
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String toString() {
        return "PayStatus:" + this.payStatus + "; " + this.msg;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0015"}, mo175978d2 = {"Lglobal/didi/pay/merchantcore/model/DPayResponse$Companion;", "", "()V", "CANCEL", "Lglobal/didi/pay/merchantcore/model/DPayResponse;", "getCANCEL", "()Lglobal/didi/pay/merchantcore/model/DPayResponse;", "CREATOR", "Landroid/os/Parcelable$Creator;", "FIELD_MSG", "", "FIELD_PAY_STATUS", "PAY_STATUS_CANCEL", "", "PAY_STATUS_FAILED", "PAY_STATUS_SUCCESS", "PAY_STATUS_UNKNOWN", "SERIALIZER", "Lglobal/didi/pay/merchantcore/model/DModelObject$Serializer;", "SUCCESS", "getSUCCESS", "merchantCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: DPayResponse.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DPayResponse getSUCCESS() {
            return DPayResponse.SUCCESS;
        }

        public final DPayResponse getCANCEL() {
            return DPayResponse.CANCEL;
        }
    }
}
