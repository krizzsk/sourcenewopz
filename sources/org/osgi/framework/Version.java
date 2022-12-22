package org.osgi.framework;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Version implements Comparable<Version> {
    private static final String SEPARATOR = ".";
    public static final Version emptyVersion = new Version(0, 0, 0);
    private transient int hash;
    private final int major;
    private final int micro;
    private final int minor;
    private final String qualifier;
    private transient String versionString;

    public Version(int i, int i2, int i3) {
        this(i, i2, i3, (String) null);
    }

    public Version(int i, int i2, int i3, String str) {
        str = str == null ? "" : str;
        this.major = i;
        this.minor = i2;
        this.micro = i3;
        this.qualifier = str;
        validate();
    }

    public Version(String str) {
        int i;
        try {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".", true);
            int parseInt = parseInt(stringTokenizer.nextToken(), str);
            String str2 = "";
            int i2 = 0;
            if (stringTokenizer.hasMoreTokens()) {
                stringTokenizer.nextToken();
                int parseInt2 = parseInt(stringTokenizer.nextToken(), str);
                if (stringTokenizer.hasMoreTokens()) {
                    stringTokenizer.nextToken();
                    int parseInt3 = parseInt(stringTokenizer.nextToken(), str);
                    if (stringTokenizer.hasMoreTokens()) {
                        stringTokenizer.nextToken();
                        str2 = stringTokenizer.nextToken(str2);
                        if (stringTokenizer.hasMoreTokens()) {
                            throw new IllegalArgumentException("invalid version \"" + str + "\": invalid format");
                        }
                    }
                    i = parseInt3;
                    i2 = parseInt2;
                    this.major = parseInt;
                    this.minor = i2;
                    this.micro = i;
                    this.qualifier = str2;
                    validate();
                }
                i2 = parseInt2;
            }
            i = 0;
            this.major = parseInt;
            this.minor = i2;
            this.micro = i;
            this.qualifier = str2;
            validate();
        } catch (NoSuchElementException e) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("invalid version \"" + str + "\": invalid format");
            illegalArgumentException.initCause(e);
            throw illegalArgumentException;
        }
    }

    private static int parseInt(String str, String str2) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("invalid version \"" + str2 + "\": non-numeric \"" + str + Const.jsQuote);
            illegalArgumentException.initCause(e);
            throw illegalArgumentException;
        }
    }

    private void validate() {
        if (this.major < 0) {
            throw new IllegalArgumentException("invalid version \"" + toString0() + "\": negative number \"" + this.major + Const.jsQuote);
        } else if (this.minor < 0) {
            throw new IllegalArgumentException("invalid version \"" + toString0() + "\": negative number \"" + this.minor + Const.jsQuote);
        } else if (this.micro >= 0) {
            for (char c : this.qualifier.toCharArray()) {
                if (('A' > c || c > 'Z') && (('a' > c || c > 'z') && !(('0' <= c && c <= '9') || c == '_' || c == '-'))) {
                    throw new IllegalArgumentException("invalid version \"" + toString0() + "\": invalid qualifier \"" + this.qualifier + Const.jsQuote);
                }
            }
        } else {
            throw new IllegalArgumentException("invalid version \"" + toString0() + "\": negative number \"" + this.micro + Const.jsQuote);
        }
    }

    public static Version parseVersion(String str) {
        if (str == null) {
            return emptyVersion;
        }
        return valueOf(str);
    }

    public static Version valueOf(String str) {
        String trim = str.trim();
        if (trim.length() == 0) {
            return emptyVersion;
        }
        return new Version(trim);
    }

    public int getMajor() {
        return this.major;
    }

    public int getMinor() {
        return this.minor;
    }

    public int getMicro() {
        return this.micro;
    }

    public String getQualifier() {
        return this.qualifier;
    }

    public String toString() {
        return toString0();
    }

    /* access modifiers changed from: package-private */
    public String toString0() {
        String str = this.versionString;
        if (str != null) {
            return str;
        }
        int length = this.qualifier.length();
        StringBuffer stringBuffer = new StringBuffer(length + 20);
        stringBuffer.append(this.major);
        stringBuffer.append(".");
        stringBuffer.append(this.minor);
        stringBuffer.append(".");
        stringBuffer.append(this.micro);
        if (length > 0) {
            stringBuffer.append(".");
            stringBuffer.append(this.qualifier);
        }
        String stringBuffer2 = stringBuffer.toString();
        this.versionString = stringBuffer2;
        return stringBuffer2;
    }

    public int hashCode() {
        int i = this.hash;
        if (i != 0) {
            return i;
        }
        int hashCode = ((((((16337 + this.major) * 31) + this.minor) * 31) + this.micro) * 31) + this.qualifier.hashCode();
        this.hash = hashCode;
        return hashCode;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Version)) {
            return false;
        }
        Version version = (Version) obj;
        if (this.major == version.major && this.minor == version.minor && this.micro == version.micro && this.qualifier.equals(version.qualifier)) {
            return true;
        }
        return false;
    }

    public int compareTo(Version version) {
        if (version == this) {
            return 0;
        }
        int i = this.major - version.major;
        if (i != 0) {
            return i;
        }
        int i2 = this.minor - version.minor;
        if (i2 != 0) {
            return i2;
        }
        int i3 = this.micro - version.micro;
        if (i3 != 0) {
            return i3;
        }
        return this.qualifier.compareTo(version.qualifier);
    }
}
