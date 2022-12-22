package global.didi.pay.merchantcore.model;

import android.os.Parcel;
import android.os.Parcelable;
import global.didi.pay.merchantcore.model.DModelObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, mo175978d2 = {"Lglobal/didi/pay/merchantcore/model/DPayMsg;", "Lglobal/didi/pay/merchantcore/model/DModelObject;", "errno", "", "msgContent", "", "(ILjava/lang/String;)V", "getErrno", "()I", "getMsgContent", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "merchantCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DPayResponse.kt */
public final class DPayMsg extends DModelObject {
    public static final Parcelable.Creator<DPayMsg> CREATOR = new DModelObject.Creator(DPayMsg.class);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int ERRNO_MERCHANT_APP_ON_TOP = 30002;
    public static final int ERRNO_MERCHANT_SDK_NEED_UPGRADE = 40001;
    public static final int ERRNO_NOT_INSTALL_APP = 10001;
    public static final int ERRNO_NOT_SUPPORT_MERCHANT = 10002;
    public static final int ERRNO_NO_RESPONSE_RETURN = 30001;
    public static final int ERRNO_OK = 0;
    public static final int ERRNO_PAY_CANCEL = 20001;
    public static final int ERRNO_PAY_PARAM_ILLEGAL = 10003;
    public static final int ERRNO_PAY_TASK_ALREADY_FINISH = 10004;
    public static final String FIELD_ERRNO = "errno";
    public static final String FIELD_MSG_CONTENT = "msg_content";
    public static final DModelObject.Serializer<DPayMsg> SERIALIZER = new DPayMsg$Companion$SERIALIZER$1();
    private final int errno;
    private final String msgContent;

    public static /* synthetic */ DPayMsg copy$default(DPayMsg dPayMsg, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = dPayMsg.errno;
        }
        if ((i2 & 2) != 0) {
            str = dPayMsg.msgContent;
        }
        return dPayMsg.copy(i, str);
    }

    public final int component1() {
        return this.errno;
    }

    public final String component2() {
        return this.msgContent;
    }

    public final DPayMsg copy(int i, String str) {
        return new DPayMsg(i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DPayMsg)) {
            return false;
        }
        DPayMsg dPayMsg = (DPayMsg) obj;
        return this.errno == dPayMsg.errno && Intrinsics.areEqual((Object) this.msgContent, (Object) dPayMsg.msgContent);
    }

    public int hashCode() {
        int i = this.errno * 31;
        String str = this.msgContent;
        return i + (str != null ? str.hashCode() : 0);
    }

    public final int getErrno() {
        return this.errno;
    }

    public final String getMsgContent() {
        return this.msgContent;
    }

    public DPayMsg(int i, String str) {
        this.errno = i;
        this.msgContent = str;
    }

    public String toString() {
        return "Errno:" + this.errno + "; MsgContent:" + this.msgContent;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lglobal/didi/pay/merchantcore/model/DPayMsg$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lglobal/didi/pay/merchantcore/model/DPayMsg;", "ERRNO_MERCHANT_APP_ON_TOP", "", "ERRNO_MERCHANT_SDK_NEED_UPGRADE", "ERRNO_NOT_INSTALL_APP", "ERRNO_NOT_SUPPORT_MERCHANT", "ERRNO_NO_RESPONSE_RETURN", "ERRNO_OK", "ERRNO_PAY_CANCEL", "ERRNO_PAY_PARAM_ILLEGAL", "ERRNO_PAY_TASK_ALREADY_FINISH", "FIELD_ERRNO", "", "FIELD_MSG_CONTENT", "SERIALIZER", "Lglobal/didi/pay/merchantcore/model/DModelObject$Serializer;", "merchantCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: DPayResponse.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "dest");
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }
}
