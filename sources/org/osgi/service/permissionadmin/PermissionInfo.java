package org.osgi.service.permissionadmin;

import kotlin.text.Typography;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.p071io.IOUtils;
import org.osgi.framework.VersionRange;

public class PermissionInfo {
    private final String actions;
    private final String name;
    private final String type;

    public PermissionInfo(String str, String str2, String str3) {
        this.type = str;
        this.name = str2;
        this.actions = str3;
        if (str == null) {
            throw new NullPointerException("type is null");
        } else if (str2 == null && str3 != null) {
            throw new IllegalArgumentException("name missing");
        }
    }

    public PermissionInfo(String str) {
        String str2;
        if (str == null) {
            throw new NullPointerException("missing encoded permission");
        } else if (str.length() != 0) {
            try {
                char[] charArray = str.toCharArray();
                int length = charArray.length;
                int i = 0;
                while (Character.isWhitespace(charArray[i])) {
                    i++;
                }
                if (charArray[i] == '(') {
                    do {
                        i++;
                    } while (Character.isWhitespace(charArray[i]));
                    int i2 = i;
                    while (!Character.isWhitespace(charArray[i2]) && charArray[i2] != ')') {
                        i2++;
                    }
                    if (i2 == i || charArray[i] == '\"') {
                        throw new IllegalArgumentException("expecting type");
                    }
                    String str3 = new String(charArray, i, i2 - i);
                    while (Character.isWhitespace(charArray[i2])) {
                        i2++;
                    }
                    String str4 = null;
                    if (charArray[i2] == '\"') {
                        int i3 = i2 + 1;
                        int i4 = i3;
                        while (charArray[i4] != '\"') {
                            if (charArray[i4] == '\\') {
                                i4++;
                            }
                            i4++;
                        }
                        String unescapeString = unescapeString(charArray, i3, i4);
                        int i5 = i4 + 1;
                        if (Character.isWhitespace(charArray[i5])) {
                            while (Character.isWhitespace(charArray[i5])) {
                                i5++;
                            }
                            if (charArray[i5] == '\"') {
                                int i6 = i5 + 1;
                                int i7 = i6;
                                while (charArray[i7] != '\"') {
                                    if (charArray[i7] == '\\') {
                                        i7++;
                                    }
                                    i7++;
                                }
                                str2 = unescapeString(charArray, i6, i7);
                                do {
                                    i7++;
                                } while (Character.isWhitespace(charArray[i7]));
                                int i8 = i7;
                                str4 = unescapeString;
                                i2 = i8;
                            }
                        }
                        String str5 = unescapeString;
                        i2 = i5;
                        str2 = null;
                        str4 = str5;
                    } else {
                        str2 = null;
                    }
                    char c = charArray[i2];
                    do {
                        i2++;
                        if (i2 >= length || !Character.isWhitespace(charArray[i2])) {
                            if (c == ')' || i2 != length) {
                                throw new IllegalArgumentException("expecting close parenthesis");
                            }
                            this.type = str3;
                            this.name = str4;
                            this.actions = str2;
                            return;
                        }
                        i2++;
                        break;
                    } while (!Character.isWhitespace(charArray[i2]));
                    if (c == ')') {
                    }
                    throw new IllegalArgumentException("expecting close parenthesis");
                }
                throw new IllegalArgumentException("expecting open parenthesis");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new IllegalArgumentException("parsing terminated abruptly");
            }
        } else {
            throw new IllegalArgumentException("empty encoded permission");
        }
    }

    public final String getEncoded() {
        int length = this.type.length() + 8;
        String str = this.name;
        int i = 0;
        int length2 = str == null ? 0 : str.length();
        String str2 = this.actions;
        if (str2 != null) {
            i = str2.length();
        }
        StringBuffer stringBuffer = new StringBuffer(length + ((length2 + i) << 1));
        stringBuffer.append(VersionRange.LEFT_OPEN);
        stringBuffer.append(this.type);
        if (this.name != null) {
            stringBuffer.append(" \"");
            escapeString(this.name, stringBuffer);
            if (this.actions != null) {
                stringBuffer.append("\" \"");
                escapeString(this.actions, stringBuffer);
            }
            stringBuffer.append(Typography.quote);
        }
        stringBuffer.append(VersionRange.RIGHT_OPEN);
        return stringBuffer.toString();
    }

    public String toString() {
        return getEncoded();
    }

    public final String getType() {
        return this.type;
    }

    public final String getName() {
        return this.name;
    }

    public final String getActions() {
        return this.actions;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PermissionInfo)) {
            return false;
        }
        PermissionInfo permissionInfo = (PermissionInfo) obj;
        if (this.type.equals(permissionInfo.type)) {
            if (!((this.name == null) ^ (permissionInfo.name == null))) {
                if (!((this.actions == null) ^ (permissionInfo.actions == null))) {
                    String str = this.name;
                    if (str == null) {
                        return true;
                    }
                    if (this.actions == null) {
                        return str.equals(permissionInfo.name);
                    }
                    if (!str.equals(permissionInfo.name) || !this.actions.equals(permissionInfo.actions)) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() + 527;
        String str = this.name;
        if (str == null) {
            return hashCode;
        }
        int hashCode2 = (hashCode * 31) + str.hashCode();
        String str2 = this.actions;
        return str2 != null ? (hashCode2 * 31) + str2.hashCode() : hashCode2;
    }

    private static void escapeString(String str, StringBuffer stringBuffer) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == 10) {
                stringBuffer.append("\\n");
            } else if (charAt == 13) {
                stringBuffer.append("\\r");
            } else if (charAt == '\"' || charAt == '\\') {
                stringBuffer.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                stringBuffer.append(charAt);
            } else {
                stringBuffer.append(charAt);
            }
        }
    }

    private static String unescapeString(char[] cArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 - i);
        while (i < i2) {
            char c = cArr[i];
            if (c == '\\' && (i = i + 1) < i2 && (c = cArr[i]) != '\"' && c != '\\') {
                if (c == 'n') {
                    c = 10;
                } else if (c != 'r') {
                    i--;
                    c = IOUtils.DIR_SEPARATOR_WINDOWS;
                } else {
                    c = CharUtils.f5620CR;
                }
            }
            stringBuffer.append(c);
            i++;
        }
        return stringBuffer.toString();
    }
}
