package kotlin.reflect.jvm.internal.impl.name;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import org.apache.commons.p071io.IOUtils;

public final class ClassId {

    /* renamed from: a */
    static final /* synthetic */ boolean f60725a = (!ClassId.class.desiredAssertionStatus());

    /* renamed from: b */
    private final FqName f60726b;

    /* renamed from: c */
    private final FqName f60727c;

    /* renamed from: d */
    private final boolean f60728d;

    /* renamed from: a */
    private static /* synthetic */ void m44766a(int i) {
        String str = (i == 5 || i == 6 || i == 7 || i == 9 || i == 13 || i == 14) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 5 || i == 6 || i == 7 || i == 9 || i == 13 || i == 14) ? 2 : 3)];
        switch (i) {
            case 1:
            case 3:
                objArr[0] = "packageFqName";
                break;
            case 2:
                objArr[0] = "relativeClassName";
                break;
            case 4:
                objArr[0] = "topLevelName";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 10:
                objArr[0] = "segment";
                break;
            case 11:
            case 12:
                objArr[0] = TypedValues.Custom.S_STRING;
                break;
            default:
                objArr[0] = "topLevelFqName";
                break;
        }
        if (i == 5) {
            objArr[1] = "getPackageFqName";
        } else if (i == 6) {
            objArr[1] = "getRelativeClassName";
        } else if (i == 7) {
            objArr[1] = "getShortClassName";
        } else if (i == 9) {
            objArr[1] = "asSingleFqName";
        } else if (i == 13 || i == 14) {
            objArr[1] = "asString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                objArr[2] = "<init>";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                break;
            case 8:
                objArr[2] = "createNestedClassId";
                break;
            case 10:
                objArr[2] = "startsWith";
                break;
            case 11:
            case 12:
                objArr[2] = "fromString";
                break;
            default:
                objArr[2] = "topLevel";
                break;
        }
        String format = String.format(str, objArr);
        throw ((i == 5 || i == 6 || i == 7 || i == 9 || i == 13 || i == 14) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    public static ClassId topLevel(FqName fqName) {
        if (fqName == null) {
            m44766a(0);
        }
        return new ClassId(fqName.parent(), fqName.shortName());
    }

    public ClassId(FqName fqName, FqName fqName2, boolean z) {
        if (fqName == null) {
            m44766a(1);
        }
        if (fqName2 == null) {
            m44766a(2);
        }
        this.f60726b = fqName;
        if (f60725a || !fqName2.isRoot()) {
            this.f60727c = fqName2;
            this.f60728d = z;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Class name must not be root: ");
        sb.append(fqName);
        sb.append(z ? " (local)" : "");
        throw new AssertionError(sb.toString());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ClassId(FqName fqName, Name name) {
        this(fqName, FqName.topLevel(name), false);
        if (fqName == null) {
            m44766a(3);
        }
        if (name == null) {
            m44766a(4);
        }
    }

    public FqName getPackageFqName() {
        FqName fqName = this.f60726b;
        if (fqName == null) {
            m44766a(5);
        }
        return fqName;
    }

    public FqName getRelativeClassName() {
        FqName fqName = this.f60727c;
        if (fqName == null) {
            m44766a(6);
        }
        return fqName;
    }

    public Name getShortClassName() {
        Name shortName = this.f60727c.shortName();
        if (shortName == null) {
            m44766a(7);
        }
        return shortName;
    }

    public boolean isLocal() {
        return this.f60728d;
    }

    public ClassId createNestedClassId(Name name) {
        if (name == null) {
            m44766a(8);
        }
        return new ClassId(getPackageFqName(), this.f60727c.child(name), this.f60728d);
    }

    public ClassId getOuterClassId() {
        FqName parent = this.f60727c.parent();
        if (parent.isRoot()) {
            return null;
        }
        return new ClassId(getPackageFqName(), parent, this.f60728d);
    }

    public boolean isNestedClass() {
        return !this.f60727c.parent().isRoot();
    }

    public FqName asSingleFqName() {
        if (this.f60726b.isRoot()) {
            FqName fqName = this.f60727c;
            if (fqName == null) {
                m44766a(9);
            }
            return fqName;
        }
        return new FqName(this.f60726b.asString() + "." + this.f60727c.asString());
    }

    public static ClassId fromString(String str) {
        if (str == null) {
            m44766a(11);
        }
        return fromString(str, false);
    }

    public static ClassId fromString(String str, boolean z) {
        String str2;
        if (str == null) {
            m44766a(12);
        }
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf == -1) {
            str2 = "";
        } else {
            String replace = str.substring(0, lastIndexOf).replace(IOUtils.DIR_SEPARATOR_UNIX, '.');
            str = str.substring(lastIndexOf + 1);
            str2 = replace;
        }
        return new ClassId(new FqName(str2), new FqName(str), z);
    }

    public String asString() {
        if (this.f60726b.isRoot()) {
            String asString = this.f60727c.asString();
            if (asString == null) {
                m44766a(13);
            }
            return asString;
        }
        String str = this.f60726b.asString().replace('.', IOUtils.DIR_SEPARATOR_UNIX) + "/" + this.f60727c.asString();
        if (str == null) {
            m44766a(14);
        }
        return str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ClassId classId = (ClassId) obj;
        if (!this.f60726b.equals(classId.f60726b) || !this.f60727c.equals(classId.f60727c) || this.f60728d != classId.f60728d) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((this.f60726b.hashCode() * 31) + this.f60727c.hashCode()) * 31) + Boolean.valueOf(this.f60728d).hashCode();
    }

    public String toString() {
        if (!this.f60726b.isRoot()) {
            return asString();
        }
        return "/" + asString();
    }
}
