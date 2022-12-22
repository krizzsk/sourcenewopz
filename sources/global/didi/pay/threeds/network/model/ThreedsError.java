package global.didi.pay.threeds.network.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0005H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, mo175978d2 = {"Lglobal/didi/pay/threeds/network/model/ThreedsError;", "Ljava/io/Serializable;", "code", "", "message", "", "(ILjava/lang/String;)V", "getCode", "()I", "setCode", "(I)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "toString", "Companion", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ThreedsError.kt */
public final class ThreedsError implements Serializable {
    /* access modifiers changed from: private */
    public static final ThreedsError AUTHOR_ERROR = new ThreedsError(1001, "");
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ThreedsError INIT_ERROR = new ThreedsError(1000, "");
    /* access modifiers changed from: private */
    public static final ThreedsError NET_ERROR = new ThreedsError(1003, "");
    /* access modifiers changed from: private */
    public static final ThreedsError SERVER_ERROR = new ThreedsError(1004, "");
    /* access modifiers changed from: private */
    public static final ThreedsError VERIFY_ERROR = new ThreedsError(1002, "");
    private int code;
    private String message;

    public ThreedsError() {
        this(0, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public ThreedsError(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.code = i;
        this.message = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ThreedsError(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? "" : str);
    }

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, mo175978d2 = {"Lglobal/didi/pay/threeds/network/model/ThreedsError$Companion;", "", "()V", "AUTHOR_ERROR", "Lglobal/didi/pay/threeds/network/model/ThreedsError;", "getAUTHOR_ERROR", "()Lglobal/didi/pay/threeds/network/model/ThreedsError;", "INIT_ERROR", "getINIT_ERROR", "NET_ERROR", "getNET_ERROR", "SERVER_ERROR", "getSERVER_ERROR", "VERIFY_ERROR", "getVERIFY_ERROR", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ThreedsError.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ThreedsError getINIT_ERROR() {
            return ThreedsError.INIT_ERROR;
        }

        public final ThreedsError getAUTHOR_ERROR() {
            return ThreedsError.AUTHOR_ERROR;
        }

        public final ThreedsError getVERIFY_ERROR() {
            return ThreedsError.VERIFY_ERROR;
        }

        public final ThreedsError getNET_ERROR() {
            return ThreedsError.NET_ERROR;
        }

        public final ThreedsError getSERVER_ERROR() {
            return ThreedsError.SERVER_ERROR;
        }
    }

    public String toString() {
        return "code:" + this.code + " message:" + this.message;
    }
}
