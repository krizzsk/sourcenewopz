package org.osgi.service.condpermadmin;

import java.util.ArrayList;
import kotlin.text.Typography;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.p071io.IOUtils;
import org.osgi.framework.VersionRange;

public class ConditionInfo {
    private final String[] args;
    private final String type;

    public ConditionInfo(String str, String[] strArr) {
        this.type = str;
        this.args = strArr != null ? (String[]) strArr.clone() : new String[0];
        if (str == null) {
            throw new NullPointerException("type is null");
        }
    }

    public ConditionInfo(String str) {
        int i;
        if (str == null) {
            throw new NullPointerException("missing encoded condition");
        } else if (str.length() != 0) {
            try {
                char[] charArray = str.toCharArray();
                int length = charArray.length;
                int i2 = 0;
                while (Character.isWhitespace(charArray[i2])) {
                    i2++;
                }
                if (charArray[i2] == '[') {
                    do {
                        i2++;
                    } while (Character.isWhitespace(charArray[i2]));
                    int i3 = i2;
                    while (!Character.isWhitespace(charArray[i3]) && charArray[i3] != ']') {
                        i3++;
                    }
                    if (i3 == i2 || charArray[i2] == '\"') {
                        throw new IllegalArgumentException("expecting type");
                    }
                    this.type = new String(charArray, i2, i3 - i2);
                    while (Character.isWhitespace(charArray[i])) {
                        i3 = i + 1;
                    }
                    ArrayList arrayList = new ArrayList();
                    while (charArray[i] == '\"') {
                        int i4 = i + 1;
                        int i5 = i4;
                        while (charArray[i5] != '\"') {
                            if (charArray[i5] == '\\') {
                                i5++;
                            }
                            i5++;
                        }
                        arrayList.add(unescapeString(charArray, i4, i5));
                        i = i5 + 1;
                        if (Character.isWhitespace(charArray[i])) {
                            while (Character.isWhitespace(charArray[i])) {
                                i++;
                            }
                        }
                    }
                    this.args = (String[]) arrayList.toArray(new String[arrayList.size()]);
                    char c = charArray[i];
                    while (true) {
                        i++;
                        if (i >= length || !Character.isWhitespace(charArray[i])) {
                            if (c == ']' || i != length) {
                                throw new IllegalArgumentException("expecting close bracket");
                            }
                            return;
                        }
                    }
                    if (c == ']') {
                    }
                    throw new IllegalArgumentException("expecting close bracket");
                }
                throw new IllegalArgumentException("expecting open bracket");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new IllegalArgumentException("parsing terminated abruptly");
            }
        } else {
            throw new IllegalArgumentException("empty encoded condition");
        }
    }

    public final String getEncoded() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(VersionRange.LEFT_CLOSED);
        stringBuffer.append(this.type);
        for (String escapeString : this.args) {
            stringBuffer.append(" \"");
            escapeString(escapeString, stringBuffer);
            stringBuffer.append(Typography.quote);
        }
        stringBuffer.append(VersionRange.RIGHT_CLOSED);
        return stringBuffer.toString();
    }

    public String toString() {
        return getEncoded();
    }

    public final String getType() {
        return this.type;
    }

    public final String[] getArgs() {
        return (String[]) this.args.clone();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConditionInfo)) {
            return false;
        }
        ConditionInfo conditionInfo = (ConditionInfo) obj;
        if (!this.type.equals(conditionInfo.type) || this.args.length != conditionInfo.args.length) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = this.args;
            if (i >= strArr.length) {
                return true;
            }
            if (!strArr[i].equals(conditionInfo.args[i])) {
                return false;
            }
            i++;
        }
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() + 527;
        int i = 0;
        while (true) {
            String[] strArr = this.args;
            if (i >= strArr.length) {
                return hashCode;
            }
            hashCode = (hashCode * 31) + strArr[i].hashCode();
            i++;
        }
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
