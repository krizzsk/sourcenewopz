package kotlin.reflect.jvm.internal.impl.name;

import com.didi.beatles.p099im.access.utils.IMTextUtils;

public final class Name implements Comparable<Name> {

    /* renamed from: a */
    private final String f60738a;

    /* renamed from: b */
    private final boolean f60739b;

    /* renamed from: a */
    private static /* synthetic */ void m44771a(int i) {
        String str = (i == 1 || i == 2 || i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 1 || i == 2 || i == 3 || i == 4) ? 2 : 3)];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[0] = "name";
        }
        if (i == 1) {
            objArr[1] = "asString";
        } else if (i == 2) {
            objArr[1] = "getIdentifier";
        } else if (i == 3 || i == 4) {
            objArr[1] = "asStringStripSpecialMarkers";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            case 5:
                objArr[2] = "identifier";
                break;
            case 6:
                objArr[2] = "isValidIdentifier";
                break;
            case 7:
                objArr[2] = "special";
                break;
            case 8:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        throw ((i == 1 || i == 2 || i == 3 || i == 4) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    private Name(String str, boolean z) {
        if (str == null) {
            m44771a(0);
        }
        this.f60738a = str;
        this.f60739b = z;
    }

    public String asString() {
        String str = this.f60738a;
        if (str == null) {
            m44771a(1);
        }
        return str;
    }

    public String getIdentifier() {
        if (!this.f60739b) {
            String asString = asString();
            if (asString == null) {
                m44771a(2);
            }
            return asString;
        }
        throw new IllegalStateException("not identifier: " + this);
    }

    public boolean isSpecial() {
        return this.f60739b;
    }

    public int compareTo(Name name) {
        return this.f60738a.compareTo(name.f60738a);
    }

    public static Name identifier(String str) {
        if (str == null) {
            m44771a(5);
        }
        return new Name(str, false);
    }

    public static boolean isValidIdentifier(String str) {
        if (str == null) {
            m44771a(6);
        }
        if (str.isEmpty() || str.startsWith(IMTextUtils.STREET_IMAGE_TAG_START)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '.' || charAt == '/' || charAt == '\\') {
                return false;
            }
        }
        return true;
    }

    public static Name special(String str) {
        if (str == null) {
            m44771a(7);
        }
        if (str.startsWith(IMTextUtils.STREET_IMAGE_TAG_START)) {
            return new Name(str, true);
        }
        throw new IllegalArgumentException("special name must start with '<': " + str);
    }

    public static Name guessByFirstCharacter(String str) {
        if (str == null) {
            m44771a(8);
        }
        if (str.startsWith(IMTextUtils.STREET_IMAGE_TAG_START)) {
            return special(str);
        }
        return identifier(str);
    }

    public String toString() {
        return this.f60738a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Name)) {
            return false;
        }
        Name name = (Name) obj;
        return this.f60739b == name.f60739b && this.f60738a.equals(name.f60738a);
    }

    public int hashCode() {
        return (this.f60738a.hashCode() * 31) + (this.f60739b ? 1 : 0);
    }
}
