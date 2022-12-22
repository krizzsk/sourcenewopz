package global.didi.pay.merchantcore.model;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo175978d2 = {"Lglobal/didi/pay/merchantcore/model/DPayCheckResult;", "", "msg", "Lglobal/didi/pay/merchantcore/model/DPayMsg;", "(Lglobal/didi/pay/merchantcore/model/DPayMsg;)V", "getMsg", "()Lglobal/didi/pay/merchantcore/model/DPayMsg;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "merchantCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DPayResponse.kt */
public final class DPayCheckResult {
    /* access modifiers changed from: private */
    public static final DPayCheckResult ALREADY_FINISH = new DPayCheckResult(new DPayMsg(10004, "the pay task already finished, please gen a new one"));
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final DPayCheckResult NOT_INSTALL_APP = new DPayCheckResult(new DPayMsg(10001, "not install"));
    /* access modifiers changed from: private */
    public static final DPayCheckResult NOT_SUPPORT = new DPayCheckResult(new DPayMsg(10002, "not support"));
    /* access modifiers changed from: private */
    public static final DPayCheckResult PARAM_ILLEGAL = new DPayCheckResult(new DPayMsg(10003, "params are not completed"));
    /* access modifiers changed from: private */
    public static final DPayCheckResult SUCCESS = new DPayCheckResult(new DPayMsg(0, "success"));
    private final DPayMsg msg;

    public static /* synthetic */ DPayCheckResult copy$default(DPayCheckResult dPayCheckResult, DPayMsg dPayMsg, int i, Object obj) {
        if ((i & 1) != 0) {
            dPayMsg = dPayCheckResult.msg;
        }
        return dPayCheckResult.copy(dPayMsg);
    }

    public static final DPayCheckResult getALREADY_FINISH() {
        return ALREADY_FINISH;
    }

    public static final DPayCheckResult getNOT_INSTALL_APP() {
        return NOT_INSTALL_APP;
    }

    public static final DPayCheckResult getNOT_SUPPORT() {
        return NOT_SUPPORT;
    }

    public static final DPayCheckResult getPARAM_ILLEGAL() {
        return PARAM_ILLEGAL;
    }

    public static final DPayCheckResult getSUCCESS() {
        return SUCCESS;
    }

    public final DPayMsg component1() {
        return this.msg;
    }

    public final DPayCheckResult copy(DPayMsg dPayMsg) {
        Intrinsics.checkParameterIsNotNull(dPayMsg, "msg");
        return new DPayCheckResult(dPayMsg);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof DPayCheckResult) && Intrinsics.areEqual((Object) this.msg, (Object) ((DPayCheckResult) obj).msg);
        }
        return true;
    }

    public int hashCode() {
        DPayMsg dPayMsg = this.msg;
        if (dPayMsg != null) {
            return dPayMsg.hashCode();
        }
        return 0;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0007R\u001c\u0010\u0011\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0014"}, mo175978d2 = {"Lglobal/didi/pay/merchantcore/model/DPayCheckResult$Companion;", "", "()V", "ALREADY_FINISH", "Lglobal/didi/pay/merchantcore/model/DPayCheckResult;", "ALREADY_FINISH$annotations", "getALREADY_FINISH", "()Lglobal/didi/pay/merchantcore/model/DPayCheckResult;", "NOT_INSTALL_APP", "NOT_INSTALL_APP$annotations", "getNOT_INSTALL_APP", "NOT_SUPPORT", "NOT_SUPPORT$annotations", "getNOT_SUPPORT", "PARAM_ILLEGAL", "PARAM_ILLEGAL$annotations", "getPARAM_ILLEGAL", "SUCCESS", "SUCCESS$annotations", "getSUCCESS", "merchantCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: DPayResponse.kt */
    public static final class Companion {
        @JvmStatic
        public static /* synthetic */ void ALREADY_FINISH$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void NOT_INSTALL_APP$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void NOT_SUPPORT$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void PARAM_ILLEGAL$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void SUCCESS$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DPayCheckResult getSUCCESS() {
            return DPayCheckResult.SUCCESS;
        }

        public final DPayCheckResult getNOT_INSTALL_APP() {
            return DPayCheckResult.NOT_INSTALL_APP;
        }

        public final DPayCheckResult getNOT_SUPPORT() {
            return DPayCheckResult.NOT_SUPPORT;
        }

        public final DPayCheckResult getPARAM_ILLEGAL() {
            return DPayCheckResult.PARAM_ILLEGAL;
        }

        public final DPayCheckResult getALREADY_FINISH() {
            return DPayCheckResult.ALREADY_FINISH;
        }
    }

    public DPayCheckResult(DPayMsg dPayMsg) {
        Intrinsics.checkParameterIsNotNull(dPayMsg, "msg");
        this.msg = dPayMsg;
    }

    public final DPayMsg getMsg() {
        return this.msg;
    }

    public String toString() {
        return String.valueOf(this.msg);
    }
}
