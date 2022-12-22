package global.didi.pay.merchantcore.model;

import android.os.Parcel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lglobal/didi/pay/merchantcore/model/ParcelUtils;", "", "()V", "Companion", "merchantCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ParcelUtils.kt */
public final class ParcelUtils {
    private static final int BOOLEAN_FALSE_VALUE = 0;
    private static final int BOOLEAN_TRUE_VALUE = 1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int NO_FILE_DESCRIPTOR = 0;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lglobal/didi/pay/merchantcore/model/ParcelUtils$Companion;", "", "()V", "BOOLEAN_FALSE_VALUE", "", "BOOLEAN_TRUE_VALUE", "NO_FILE_DESCRIPTOR", "readBoolean", "", "in", "Landroid/os/Parcel;", "writeBoolean", "", "dest", "value", "merchantCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: ParcelUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void writeBoolean(Parcel parcel, boolean z) {
            Intrinsics.checkParameterIsNotNull(parcel, "dest");
            parcel.writeInt(z ? 1 : 0);
        }

        public final boolean readBoolean(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return parcel.readInt() == 1;
        }
    }

    private ParcelUtils() {
        throw new RuntimeException();
    }
}
