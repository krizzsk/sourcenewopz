package kotlin.reflect.jvm.internal.impl.descriptors;

import com.didi.sdk.push.ServerParam;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Visibilities.kt */
public final class Visibilities {
    public static final Visibilities INSTANCE = new Visibilities();

    /* renamed from: a */
    private static final Map<Visibility, Integer> f60186a;

    /* renamed from: b */
    private static final Public f60187b = Public.INSTANCE;

    /* compiled from: Visibilities.kt */
    public static final class Private extends Visibility {
        public static final Private INSTANCE = new Private();

        private Private() {
            super("private", false);
        }
    }

    private Visibilities() {
    }

    /* compiled from: Visibilities.kt */
    public static final class PrivateToThis extends Visibility {
        public static final PrivateToThis INSTANCE = new PrivateToThis();

        public String getInternalDisplayName() {
            return "private/*private to this*/";
        }

        private PrivateToThis() {
            super("private_to_this", false);
        }
    }

    /* compiled from: Visibilities.kt */
    public static final class Protected extends Visibility {
        public static final Protected INSTANCE = new Protected();

        private Protected() {
            super("protected", true);
        }
    }

    /* compiled from: Visibilities.kt */
    public static final class Internal extends Visibility {
        public static final Internal INSTANCE = new Internal();

        private Internal() {
            super("internal", false);
        }
    }

    /* compiled from: Visibilities.kt */
    public static final class Public extends Visibility {
        public static final Public INSTANCE = new Public();

        private Public() {
            super("public", true);
        }
    }

    /* compiled from: Visibilities.kt */
    public static final class Local extends Visibility {
        public static final Local INSTANCE = new Local();

        private Local() {
            super("local", false);
        }
    }

    /* compiled from: Visibilities.kt */
    public static final class Inherited extends Visibility {
        public static final Inherited INSTANCE = new Inherited();

        private Inherited() {
            super("inherited", false);
        }
    }

    /* compiled from: Visibilities.kt */
    public static final class InvisibleFake extends Visibility {
        public static final InvisibleFake INSTANCE = new InvisibleFake();

        private InvisibleFake() {
            super("invisible_fake", false);
        }
    }

    /* compiled from: Visibilities.kt */
    public static final class Unknown extends Visibility {
        public static final Unknown INSTANCE = new Unknown();

        private Unknown() {
            super("unknown", false);
        }
    }

    static {
        Map createMapBuilder = MapsKt.createMapBuilder();
        createMapBuilder.put(PrivateToThis.INSTANCE, 0);
        createMapBuilder.put(Private.INSTANCE, 0);
        createMapBuilder.put(Internal.INSTANCE, 1);
        createMapBuilder.put(Protected.INSTANCE, 1);
        createMapBuilder.put(Public.INSTANCE, 2);
        f60186a = MapsKt.build(createMapBuilder);
    }

    public final Integer compareLocal$compiler_common(Visibility visibility, Visibility visibility2) {
        Intrinsics.checkNotNullParameter(visibility, ServerParam.PARAM_FIRST);
        Intrinsics.checkNotNullParameter(visibility2, "second");
        if (visibility == visibility2) {
            return 0;
        }
        Integer num = f60186a.get(visibility);
        Integer num2 = f60186a.get(visibility2);
        if (num == null || num2 == null || Intrinsics.areEqual((Object) num, (Object) num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public final boolean isPrivate(Visibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        return visibility == Private.INSTANCE || visibility == PrivateToThis.INSTANCE;
    }
}
