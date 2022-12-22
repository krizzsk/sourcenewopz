package org.osgi.framework;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class VersionRange {
    private static final String ENDPOINT_DELIMITER = ",";
    public static final char LEFT_CLOSED = '[';
    private static final String LEFT_CLOSED_DELIMITER = "[";
    private static final String LEFT_DELIMITERS = "[(";
    public static final char LEFT_OPEN = '(';
    private static final String LEFT_OPEN_DELIMITER = "(";
    public static final char RIGHT_CLOSED = ']';
    private static final String RIGHT_CLOSED_DELIMITER = "]";
    private static final String RIGHT_DELIMITERS = ")]";
    public static final char RIGHT_OPEN = ')';
    private static final String RIGHT_OPEN_DELIMITER = ")";
    private final boolean empty;
    private transient int hash;
    private final Version left;
    private final boolean leftClosed;
    private final Version right;
    private final boolean rightClosed;
    private transient String versionRangeString;

    public VersionRange(char c, Version version, Version version2, char c2) {
        if (c != '[' && c != '(') {
            throw new IllegalArgumentException("invalid leftType \"" + c + Const.jsQuote);
        } else if (c2 != ')' && c2 != ']') {
            throw new IllegalArgumentException("invalid rightType \"" + c2 + Const.jsQuote);
        } else if (version != null) {
            boolean z = true;
            this.leftClosed = c == '[';
            this.rightClosed = c2 != ']' ? false : z;
            this.left = version;
            this.right = version2;
            this.empty = isEmpty0();
        } else {
            throw new IllegalArgumentException("null leftEndpoint argument");
        }
    }

    public VersionRange(String str) {
        try {
            StringTokenizer stringTokenizer = new StringTokenizer(str, LEFT_DELIMITERS, true);
            String trim = stringTokenizer.nextToken().trim();
            trim = trim.length() == 0 ? stringTokenizer.nextToken() : trim;
            boolean equals = "[".equals(trim);
            if (equals || LEFT_OPEN_DELIMITER.equals(trim)) {
                Version parseVersion = parseVersion(stringTokenizer.nextToken(","), str);
                stringTokenizer.nextToken();
                String nextToken = stringTokenizer.nextToken(RIGHT_DELIMITERS);
                String nextToken2 = stringTokenizer.nextToken();
                boolean equals2 = "]".equals(nextToken2);
                if (!equals2) {
                    if (!RIGHT_OPEN_DELIMITER.equals(nextToken2)) {
                        throw new IllegalArgumentException("invalid range \"" + str + "\": invalid format");
                    }
                }
                Version parseVersion2 = parseVersion(nextToken, str);
                if (stringTokenizer.hasMoreTokens()) {
                    if (stringTokenizer.nextToken("").trim().length() != 0) {
                        throw new IllegalArgumentException("invalid range \"" + str + "\": invalid format");
                    }
                }
                this.leftClosed = equals;
                this.rightClosed = equals2;
                this.left = parseVersion;
                this.right = parseVersion2;
                this.empty = isEmpty0();
            } else if (!stringTokenizer.hasMoreTokens()) {
                this.leftClosed = true;
                this.rightClosed = false;
                this.left = parseVersion(trim, str);
                this.right = null;
                this.empty = false;
            } else {
                throw new IllegalArgumentException("invalid range \"" + str + "\": invalid format");
            }
        } catch (NoSuchElementException e) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("invalid range \"" + str + "\": invalid format");
            illegalArgumentException.initCause(e);
            throw illegalArgumentException;
        }
    }

    private static Version parseVersion(String str, String str2) {
        try {
            return Version.valueOf(str);
        } catch (IllegalArgumentException e) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("invalid range \"" + str2 + "\": " + e.getMessage());
            illegalArgumentException.initCause(e);
            throw illegalArgumentException;
        }
    }

    public Version getLeft() {
        return this.left;
    }

    public Version getRight() {
        return this.right;
    }

    public char getLeftType() {
        return this.leftClosed ? LEFT_CLOSED : LEFT_OPEN;
    }

    public char getRightType() {
        return this.rightClosed ? RIGHT_CLOSED : RIGHT_OPEN;
    }

    public boolean includes(Version version) {
        if (this.empty || this.left.compareTo(version) >= this.leftClosed) {
            return false;
        }
        Version version2 = this.right;
        if (version2 != null && version2.compareTo(version) < (!this.rightClosed)) {
            return false;
        }
        return true;
    }

    public VersionRange intersection(VersionRange... versionRangeArr) {
        if (versionRangeArr == null || versionRangeArr.length == 0) {
            return this;
        }
        boolean z = this.leftClosed;
        boolean z2 = this.rightClosed;
        Version version = this.left;
        Version version2 = this.right;
        for (VersionRange versionRange : versionRangeArr) {
            int compareTo = version.compareTo(versionRange.left);
            boolean z3 = true;
            if (compareTo == 0) {
                z = z && versionRange.leftClosed;
            } else if (compareTo < 0) {
                version = versionRange.left;
                z = versionRange.leftClosed;
            }
            Version version3 = versionRange.right;
            if (version3 != null) {
                if (version2 == null) {
                    z2 = versionRange.rightClosed;
                    version2 = version3;
                } else {
                    int compareTo2 = version2.compareTo(version3);
                    if (compareTo2 == 0) {
                        if (!z2 || !versionRange.rightClosed) {
                            z3 = false;
                        }
                        z2 = z3;
                    } else if (compareTo2 > 0) {
                        version2 = versionRange.right;
                        z2 = versionRange.rightClosed;
                    }
                }
            }
        }
        return new VersionRange(z ? LEFT_CLOSED : LEFT_OPEN, version, version2, z2 ? RIGHT_CLOSED : RIGHT_OPEN);
    }

    public boolean isEmpty() {
        return this.empty;
    }

    private boolean isEmpty0() {
        Version version = this.right;
        if (version == null) {
            return false;
        }
        int compareTo = this.left.compareTo(version);
        if (compareTo == 0) {
            if (!this.leftClosed || !this.rightClosed) {
                return true;
            }
            return false;
        } else if (compareTo > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isExact() {
        Version version;
        if (this.empty || (version = this.right) == null) {
            return false;
        }
        if (this.leftClosed) {
            if (this.rightClosed) {
                return this.left.equals(version);
            }
            int major = this.left.getMajor();
            int minor = this.left.getMinor();
            int micro = this.left.getMicro();
            if (new Version(major, minor, micro, this.left.getQualifier() + "-").compareTo(this.right) >= 0) {
                return true;
            }
            return false;
        } else if (this.rightClosed) {
            int major2 = this.left.getMajor();
            int minor2 = this.left.getMinor();
            int micro2 = this.left.getMicro();
            return new Version(major2, minor2, micro2, this.left.getQualifier() + "-").equals(this.right);
        } else {
            int major3 = this.left.getMajor();
            int minor3 = this.left.getMinor();
            int micro3 = this.left.getMicro();
            if (new Version(major3, minor3, micro3, this.left.getQualifier() + "--").compareTo(this.right) >= 0) {
                return true;
            }
            return false;
        }
    }

    public String toString() {
        String str = this.versionRangeString;
        if (str != null) {
            return str;
        }
        String version = this.left.toString();
        Version version2 = this.right;
        if (version2 == null) {
            StringBuffer stringBuffer = new StringBuffer(version.length() + 1);
            stringBuffer.append(this.left.toString0());
            String stringBuffer2 = stringBuffer.toString();
            this.versionRangeString = stringBuffer2;
            return stringBuffer2;
        }
        StringBuffer stringBuffer3 = new StringBuffer(version.length() + version2.toString().length() + 5);
        stringBuffer3.append(this.leftClosed ? LEFT_CLOSED : LEFT_OPEN);
        stringBuffer3.append(this.left.toString0());
        stringBuffer3.append(",");
        stringBuffer3.append(this.right.toString0());
        stringBuffer3.append(this.rightClosed ? RIGHT_CLOSED : RIGHT_OPEN);
        String stringBuffer4 = stringBuffer3.toString();
        this.versionRangeString = stringBuffer4;
        return stringBuffer4;
    }

    public int hashCode() {
        int i = this.hash;
        if (i != 0) {
            return i;
        }
        if (this.empty) {
            this.hash = 31;
            return 31;
        }
        int i2 = 7;
        int hashCode = (((this.leftClosed ? 7 : 5) + 31) * 31) + this.left.hashCode();
        Version version = this.right;
        if (version != null) {
            int hashCode2 = ((hashCode * 31) + version.hashCode()) * 31;
            if (!this.rightClosed) {
                i2 = 5;
            }
            hashCode = hashCode2 + i2;
        }
        this.hash = hashCode;
        return hashCode;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VersionRange)) {
            return false;
        }
        VersionRange versionRange = (VersionRange) obj;
        if (this.empty && versionRange.empty) {
            return true;
        }
        if (this.right == null) {
            if (this.leftClosed == versionRange.leftClosed && versionRange.right == null && this.left.equals(versionRange.left)) {
                return true;
            }
            return false;
        } else if (this.leftClosed != versionRange.leftClosed || this.rightClosed != versionRange.rightClosed || !this.left.equals(versionRange.left) || !this.right.equals(versionRange.right)) {
            return false;
        } else {
            return true;
        }
    }

    public String toFilterString(String str) {
        if (str.length() != 0) {
            boolean z = false;
            for (char c : str.toCharArray()) {
                if (c == '=' || c == '>' || c == '<' || c == '~' || c == '(' || c == ')') {
                    throw new IllegalArgumentException("invalid attributeName \"" + str + Const.jsQuote);
                }
            }
            StringBuffer stringBuffer = new StringBuffer(128);
            boolean z2 = !this.leftClosed && (this.right == null || !this.rightClosed);
            if (z2 || this.right != null) {
                z = true;
            }
            if (z) {
                stringBuffer.append("(&");
            }
            if (z2) {
                stringBuffer.append(LEFT_OPEN);
                stringBuffer.append(str);
                stringBuffer.append("=*)");
            }
            if (this.leftClosed) {
                stringBuffer.append(LEFT_OPEN);
                stringBuffer.append(str);
                stringBuffer.append(">=");
                stringBuffer.append(this.left.toString0());
                stringBuffer.append(RIGHT_OPEN);
            } else {
                stringBuffer.append("(!(");
                stringBuffer.append(str);
                stringBuffer.append("<=");
                stringBuffer.append(this.left.toString0());
                stringBuffer.append("))");
            }
            if (this.right != null) {
                if (this.rightClosed) {
                    stringBuffer.append(LEFT_OPEN);
                    stringBuffer.append(str);
                    stringBuffer.append("<=");
                    stringBuffer.append(this.right.toString0());
                    stringBuffer.append(RIGHT_OPEN);
                } else {
                    stringBuffer.append("(!(");
                    stringBuffer.append(str);
                    stringBuffer.append(">=");
                    stringBuffer.append(this.right.toString0());
                    stringBuffer.append("))");
                }
            }
            if (z) {
                stringBuffer.append(RIGHT_OPEN);
            }
            return stringBuffer.toString();
        }
        throw new IllegalArgumentException("invalid attributeName \"" + str + Const.jsQuote);
    }

    public static VersionRange valueOf(String str) {
        return new VersionRange(str);
    }
}
