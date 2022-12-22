package kotlin.reflect.jvm.internal.impl.incremental.components;

import com.wallet.flutter.wallet_flutter.function.FlutterShareMethod;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LookupTracker.kt */
public interface LookupTracker {
    boolean getRequiresPosition();

    void record(String str, Position position, String str2, ScopeKind scopeKind, String str3);

    /* compiled from: LookupTracker.kt */
    public static final class DO_NOTHING implements LookupTracker {
        public static final DO_NOTHING INSTANCE = new DO_NOTHING();

        public boolean getRequiresPosition() {
            return false;
        }

        public void record(String str, Position position, String str2, ScopeKind scopeKind, String str3) {
            Intrinsics.checkNotNullParameter(str, FlutterShareMethod.filePathKey);
            Intrinsics.checkNotNullParameter(position, "position");
            Intrinsics.checkNotNullParameter(str2, "scopeFqName");
            Intrinsics.checkNotNullParameter(scopeKind, "scopeKind");
            Intrinsics.checkNotNullParameter(str3, "name");
        }

        private DO_NOTHING() {
        }
    }
}
