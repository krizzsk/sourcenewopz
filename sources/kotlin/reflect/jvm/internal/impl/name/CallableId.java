package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.p071io.IOUtils;

/* compiled from: CallableId.kt */
public final class CallableId {

    /* renamed from: a */
    private static final Companion f60718a = new Companion((DefaultConstructorMarker) null);
    @Deprecated

    /* renamed from: f */
    private static final Name f60719f;
    @Deprecated

    /* renamed from: g */
    private static final FqName f60720g;

    /* renamed from: b */
    private final FqName f60721b;

    /* renamed from: c */
    private final FqName f60722c;

    /* renamed from: d */
    private final Name f60723d;

    /* renamed from: e */
    private final FqName f60724e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallableId)) {
            return false;
        }
        CallableId callableId = (CallableId) obj;
        return Intrinsics.areEqual((Object) this.f60721b, (Object) callableId.f60721b) && Intrinsics.areEqual((Object) this.f60722c, (Object) callableId.f60722c) && Intrinsics.areEqual((Object) this.f60723d, (Object) callableId.f60723d) && Intrinsics.areEqual((Object) this.f60724e, (Object) callableId.f60724e);
    }

    public int hashCode() {
        int hashCode = this.f60721b.hashCode() * 31;
        FqName fqName = this.f60722c;
        int i = 0;
        int hashCode2 = (((hashCode + (fqName == null ? 0 : fqName.hashCode())) * 31) + this.f60723d.hashCode()) * 31;
        FqName fqName2 = this.f60724e;
        if (fqName2 != null) {
            i = fqName2.hashCode();
        }
        return hashCode2 + i;
    }

    public CallableId(FqName fqName, FqName fqName2, Name name, FqName fqName3) {
        Intrinsics.checkNotNullParameter(fqName, "packageName");
        Intrinsics.checkNotNullParameter(name, "callableName");
        this.f60721b = fqName;
        this.f60722c = fqName2;
        this.f60723d = name;
        this.f60724e = fqName3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CallableId(FqName fqName, FqName fqName2, Name name, FqName fqName3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fqName, fqName2, name, (i & 8) != 0 ? null : fqName3);
    }

    public final FqName getPackageName() {
        return this.f60721b;
    }

    public final FqName getClassName() {
        return this.f60722c;
    }

    public final Name getCallableName() {
        return this.f60723d;
    }

    /* compiled from: CallableId.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Name special = Name.special("<local>");
        Intrinsics.checkNotNullExpressionValue(special, "special(\"<local>\")");
        f60719f = special;
        FqName fqName = FqName.topLevel(special);
        Intrinsics.checkNotNullExpressionValue(fqName, "topLevel(LOCAL_NAME)");
        f60720g = fqName;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CallableId(FqName fqName, Name name) {
        this(fqName, (FqName) null, name, (FqName) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(fqName, "packageName");
        Intrinsics.checkNotNullParameter(name, "callableName");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String asString = getPackageName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "packageName.asString()");
        sb.append(StringsKt.replace$default(asString, '.', (char) IOUtils.DIR_SEPARATOR_UNIX, false, 4, (Object) null));
        sb.append("/");
        if (getClassName() != null) {
            sb.append(getClassName());
            sb.append(".");
        }
        sb.append(getCallableName());
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
