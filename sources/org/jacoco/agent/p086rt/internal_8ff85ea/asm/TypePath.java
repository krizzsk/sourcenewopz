package org.jacoco.agent.p086rt.internal_8ff85ea.asm;

import org.osgi.framework.VersionRange;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.TypePath */
public class TypePath {
    public static final int ARRAY_ELEMENT = 0;
    public static final int INNER_TYPE = 1;
    public static final int TYPE_ARGUMENT = 3;
    public static final int WILDCARD_BOUND = 2;

    /* renamed from: b */
    byte[] f6587b;
    int offset;

    TypePath(byte[] bArr, int i) {
        this.f6587b = bArr;
        this.offset = i;
    }

    public int getLength() {
        return this.f6587b[this.offset];
    }

    public int getStep(int i) {
        return this.f6587b[this.offset + (i * 2) + 1];
    }

    public int getStepArgument(int i) {
        return this.f6587b[this.offset + (i * 2) + 2];
    }

    public static TypePath fromString(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int length = str.length();
        ByteVector byteVector = new ByteVector(length);
        byteVector.putByte(0);
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char charAt = str.charAt(i);
            if (charAt == '[') {
                byteVector.put11(0, 0);
            } else if (charAt == '.') {
                byteVector.put11(1, 0);
            } else if (charAt == '*') {
                byteVector.put11(2, 0);
            } else if (charAt >= '0' && charAt <= '9') {
                int i3 = charAt - '0';
                while (i2 < length) {
                    char charAt2 = str.charAt(i2);
                    if (charAt2 < '0' || charAt2 > '9') {
                        break;
                    }
                    i3 = ((i3 * 10) + charAt2) - 48;
                    i2++;
                }
                if (i2 < length && str.charAt(i2) == ';') {
                    i2++;
                }
                byteVector.put11(3, i3);
            }
            i = i2;
        }
        byteVector.data[0] = (byte) (byteVector.length / 2);
        return new TypePath(byteVector.data, 0);
    }

    public String toString() {
        int length = getLength();
        StringBuilder sb = new StringBuilder(length * 2);
        for (int i = 0; i < length; i++) {
            int step = getStep(i);
            if (step == 0) {
                sb.append(VersionRange.LEFT_CLOSED);
            } else if (step == 1) {
                sb.append('.');
            } else if (step == 2) {
                sb.append('*');
            } else if (step != 3) {
                sb.append('_');
            } else {
                sb.append(getStepArgument(i));
                sb.append(';');
            }
        }
        return sb.toString();
    }
}
