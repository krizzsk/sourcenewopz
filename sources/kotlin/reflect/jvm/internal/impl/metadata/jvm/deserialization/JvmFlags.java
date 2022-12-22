package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;

/* compiled from: JvmFlags.kt */
public final class JvmFlags {
    public static final JvmFlags INSTANCE = new JvmFlags();

    /* renamed from: a */
    private static final Flags.BooleanFlagField f60706a = Flags.FlagField.booleanFirst();

    /* renamed from: b */
    private static final Flags.BooleanFlagField f60707b;

    /* renamed from: c */
    private static final Flags.BooleanFlagField f60708c;

    private JvmFlags() {
    }

    static {
        Flags.BooleanFlagField booleanFirst = Flags.FlagField.booleanFirst();
        f60707b = booleanFirst;
        f60708c = Flags.FlagField.booleanAfter(booleanFirst);
    }

    public final Flags.BooleanFlagField getIS_MOVED_FROM_INTERFACE_COMPANION() {
        return f60706a;
    }
}
