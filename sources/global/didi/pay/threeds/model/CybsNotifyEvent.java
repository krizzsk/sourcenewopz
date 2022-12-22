package global.didi.pay.threeds.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\n"}, mo175978d2 = {"Lglobal/didi/pay/threeds/model/CybsNotifyEvent;", "Ljava/io/Serializable;", "type", "", "authId", "(Ljava/lang/String;Ljava/lang/String;)V", "getAuthId", "()Ljava/lang/String;", "getType", "Companion", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CybsNotifyEvent.kt */
public final class CybsNotifyEvent implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TYPE_3DS_1dot0 = "1.0";
    public static final String TYPE_3DS_CANCEL = "TYPE_3DS_CANCEL";
    private final String authId;
    private final String type;

    public CybsNotifyEvent(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "type");
        this.type = str;
        this.authId = str2;
    }

    public final String getAuthId() {
        return this.authId;
    }

    public final String getType() {
        return this.type;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lglobal/didi/pay/threeds/model/CybsNotifyEvent$Companion;", "", "()V", "TYPE_3DS_1dot0", "", "TYPE_3DS_CANCEL", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CybsNotifyEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
