package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;

/* compiled from: KotlinClassHeader.kt */
public final class KotlinClassHeader {

    /* renamed from: a */
    private final Kind f60666a;

    /* renamed from: b */
    private final JvmMetadataVersion f60667b;

    /* renamed from: c */
    private final String[] f60668c;

    /* renamed from: d */
    private final String[] f60669d;

    /* renamed from: e */
    private final String[] f60670e;

    /* renamed from: f */
    private final String f60671f;

    /* renamed from: g */
    private final int f60672g;

    /* renamed from: h */
    private final String f60673h;

    /* renamed from: a */
    private final boolean m44746a(int i, int i2) {
        return (i & i2) != 0;
    }

    public KotlinClassHeader(Kind kind, JvmMetadataVersion jvmMetadataVersion, String[] strArr, String[] strArr2, String[] strArr3, String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(jvmMetadataVersion, "metadataVersion");
        this.f60666a = kind;
        this.f60667b = jvmMetadataVersion;
        this.f60668c = strArr;
        this.f60669d = strArr2;
        this.f60670e = strArr3;
        this.f60671f = str;
        this.f60672g = i;
        this.f60673h = str2;
    }

    public final Kind getKind() {
        return this.f60666a;
    }

    public final JvmMetadataVersion getMetadataVersion() {
        return this.f60667b;
    }

    public final String[] getData() {
        return this.f60668c;
    }

    public final String[] getIncompatibleData() {
        return this.f60669d;
    }

    public final String[] getStrings() {
        return this.f60670e;
    }

    /* compiled from: KotlinClassHeader.kt */
    public enum Kind {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);
        
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        public static final Map<Integer, Kind> entryById = null;

        /* renamed from: id */
        private final int f60674id;

        @JvmStatic
        public static final Kind getById(int i) {
            return Companion.getById(i);
        }

        private Kind(int i) {
            this.f60674id = i;
        }

        public final int getId() {
            return this.f60674id;
        }

        static {
            int i;
            Companion = new Companion((DefaultConstructorMarker) null);
            Kind[] values = values();
            Map<Integer, Kind> linkedHashMap = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
            for (Kind kind : values) {
                linkedHashMap.put(Integer.valueOf(kind.getId()), kind);
            }
            entryById = linkedHashMap;
        }

        /* compiled from: KotlinClassHeader.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Kind getById(int i) {
                Kind kind = (Kind) Kind.entryById.get(Integer.valueOf(i));
                return kind == null ? Kind.UNKNOWN : kind;
            }
        }
    }

    public final String getMultifileClassName() {
        String str = this.f60671f;
        if (getKind() == Kind.MULTIFILE_CLASS_PART) {
            return str;
        }
        return null;
    }

    public final List<String> getMultifilePartNames() {
        String[] strArr = this.f60668c;
        List<String> list = null;
        if (!(getKind() == Kind.MULTIFILE_CLASS)) {
            strArr = null;
        }
        if (strArr != null) {
            list = ArraysKt.asList((T[]) strArr);
        }
        return list != null ? list : CollectionsKt.emptyList();
    }

    public final boolean isUnstableJvmIrBinary() {
        return m44746a(this.f60672g, 16) && !m44746a(this.f60672g, 32);
    }

    public final boolean isUnstableFirBinary() {
        return m44746a(this.f60672g, 64) && !m44746a(this.f60672g, 32);
    }

    public final boolean isPreRelease() {
        return m44746a(this.f60672g, 2);
    }

    public String toString() {
        return this.f60666a + " version=" + this.f60667b;
    }
}
