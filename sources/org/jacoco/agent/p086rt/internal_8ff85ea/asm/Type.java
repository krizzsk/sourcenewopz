package org.jacoco.agent.p086rt.internal_8ff85ea.asm;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.MotionEventCompat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.apache.commons.p071io.IOUtils;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.osgi.framework.VersionRange;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.Type */
public class Type {
    public static final int ARRAY = 9;
    public static final int BOOLEAN = 1;
    public static final Type BOOLEAN_TYPE = new Type(1, (char[]) null, 1509950721, 1);
    public static final int BYTE = 3;
    public static final Type BYTE_TYPE = new Type(3, (char[]) null, 1107297537, 1);
    public static final int CHAR = 2;
    public static final Type CHAR_TYPE = new Type(2, (char[]) null, 1124075009, 1);
    public static final int DOUBLE = 8;
    public static final Type DOUBLE_TYPE = new Type(8, (char[]) null, 1141048066, 1);
    public static final int FLOAT = 6;
    public static final Type FLOAT_TYPE = new Type(6, (char[]) null, 1174536705, 1);
    public static final int INT = 5;
    public static final Type INT_TYPE = new Type(5, (char[]) null, 1224736769, 1);
    public static final int LONG = 7;
    public static final Type LONG_TYPE = new Type(7, (char[]) null, 1241579778, 1);
    public static final int METHOD = 11;
    public static final int OBJECT = 10;
    public static final int SHORT = 4;
    public static final Type SHORT_TYPE = new Type(4, (char[]) null, 1392510721, 1);
    public static final int VOID = 0;
    public static final Type VOID_TYPE = new Type(0, (char[]) null, 1443168256, 1);
    private final char[] buf;
    private final int len;
    private final int off;
    private final int sort;

    private Type(int i, char[] cArr, int i2, int i3) {
        this.sort = i;
        this.buf = cArr;
        this.off = i2;
        this.len = i3;
    }

    public static Type getType(String str) {
        return getType(str.toCharArray(), 0);
    }

    public static Type getObjectType(String str) {
        char[] charArray = str.toCharArray();
        return new Type(charArray[0] == '[' ? 9 : 10, charArray, 0, charArray.length);
    }

    public static Type getMethodType(String str) {
        return getType(str.toCharArray(), 0);
    }

    public static Type getMethodType(Type type, Type... typeArr) {
        return getType(getMethodDescriptor(type, typeArr));
    }

    public static Type getType(Class<?> cls) {
        if (!cls.isPrimitive()) {
            return getType(getDescriptor(cls));
        }
        if (cls == Integer.TYPE) {
            return INT_TYPE;
        }
        if (cls == Void.TYPE) {
            return VOID_TYPE;
        }
        if (cls == Boolean.TYPE) {
            return BOOLEAN_TYPE;
        }
        if (cls == Byte.TYPE) {
            return BYTE_TYPE;
        }
        if (cls == Character.TYPE) {
            return CHAR_TYPE;
        }
        if (cls == Short.TYPE) {
            return SHORT_TYPE;
        }
        if (cls == Double.TYPE) {
            return DOUBLE_TYPE;
        }
        if (cls == Float.TYPE) {
            return FLOAT_TYPE;
        }
        return LONG_TYPE;
    }

    public static Type getType(Constructor<?> constructor) {
        return getType(getConstructorDescriptor(constructor));
    }

    public static Type getType(Method method) {
        return getType(getMethodDescriptor(method));
    }

    public static Type[] getArgumentTypes(String str) {
        char[] charArray = str.toCharArray();
        int i = 1;
        int i2 = 1;
        int i3 = 0;
        while (true) {
            int i4 = i2 + 1;
            char c = charArray[i2];
            if (c == ')') {
                break;
            } else if (c == 'L') {
                while (true) {
                    i2 = i4 + 1;
                    if (charArray[i4] == ';') {
                        break;
                    }
                    i4 = i2;
                }
                i3++;
            } else {
                if (c != '[') {
                    i3++;
                }
                i2 = i4;
            }
        }
        Type[] typeArr = new Type[i3];
        int i5 = 0;
        while (charArray[i] != ')') {
            typeArr[i5] = getType(charArray, i);
            i += typeArr[i5].len + (typeArr[i5].sort == 10 ? 2 : 0);
            i5++;
        }
        return typeArr;
    }

    public static Type[] getArgumentTypes(Method method) {
        Class[] parameterTypes = method.getParameterTypes();
        Type[] typeArr = new Type[parameterTypes.length];
        for (int length = parameterTypes.length - 1; length >= 0; length--) {
            typeArr[length] = getType((Class<?>) parameterTypes[length]);
        }
        return typeArr;
    }

    public static Type getReturnType(String str) {
        char[] charArray = str.toCharArray();
        int i = 1;
        while (true) {
            int i2 = i + 1;
            char c = charArray[i];
            if (c == ')') {
                return getType(charArray, i2);
            }
            if (c == 'L') {
                while (true) {
                    i = i2 + 1;
                    if (charArray[i2] == ';') {
                        break;
                    }
                    i2 = i;
                }
            } else {
                i = i2;
            }
        }
    }

    public static Type getReturnType(Method method) {
        return getType(method.getReturnType());
    }

    public static int getArgumentsAndReturnSizes(String str) {
        int i;
        char charAt;
        int i2 = 1;
        int i3 = 1;
        int i4 = 1;
        while (true) {
            i = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 == ')') {
                break;
            } else if (charAt2 == 'L') {
                while (true) {
                    i3 = i + 1;
                    if (str.charAt(i) == ';') {
                        break;
                    }
                    i = i3;
                }
                i4++;
            } else {
                if (charAt2 == '[') {
                    while (true) {
                        charAt = str.charAt(i);
                        if (charAt != '[') {
                            break;
                        }
                        i++;
                    }
                    if (charAt == 'D' || charAt == 'J') {
                        i4--;
                    }
                } else {
                    i4 = (charAt2 == 'D' || charAt2 == 'J') ? i4 + 2 : i4 + 1;
                }
                i3 = i;
            }
        }
        char charAt3 = str.charAt(i);
        int i5 = i4 << 2;
        if (charAt3 == 'V') {
            i2 = 0;
        } else if (charAt3 == 'D' || charAt3 == 'J') {
            i2 = 2;
        }
        return i5 | i2;
    }

    private static Type getType(char[] cArr, int i) {
        int i2;
        char c = cArr[i];
        if (c == 'F') {
            return FLOAT_TYPE;
        }
        if (c == 'L') {
            int i3 = 1;
            while (cArr[i + i3] != ';') {
                i3++;
            }
            return new Type(10, cArr, i + 1, i3 - 1);
        } else if (c == 'S') {
            return SHORT_TYPE;
        } else {
            if (c == 'V') {
                return VOID_TYPE;
            }
            if (c == 'I') {
                return INT_TYPE;
            }
            if (c == 'J') {
                return LONG_TYPE;
            }
            if (c == 'Z') {
                return BOOLEAN_TYPE;
            }
            if (c != '[') {
                switch (c) {
                    case 'B':
                        return BYTE_TYPE;
                    case 'C':
                        return CHAR_TYPE;
                    case 'D':
                        return DOUBLE_TYPE;
                    default:
                        return new Type(11, cArr, i, cArr.length - i);
                }
            } else {
                int i4 = 1;
                while (true) {
                    i2 = i + i4;
                    if (cArr[i2] != '[') {
                        break;
                    }
                    i4++;
                }
                if (cArr[i2] == 'L') {
                    do {
                        i4++;
                    } while (cArr[i + i4] != ';');
                }
                return new Type(9, cArr, i, i4 + 1);
            }
        }
    }

    public int getSort() {
        return this.sort;
    }

    public int getDimensions() {
        int i = 1;
        while (this.buf[this.off + i] == '[') {
            i++;
        }
        return i;
    }

    public Type getElementType() {
        return getType(this.buf, this.off + getDimensions());
    }

    public String getClassName() {
        switch (this.sort) {
            case 0:
                return "void";
            case 1:
                return TypedValues.Custom.S_BOOLEAN;
            case 2:
                return "char";
            case 3:
                return "byte";
            case 4:
                return "short";
            case 5:
                return "int";
            case 6:
                return "float";
            case 7:
                return "long";
            case 8:
                return "double";
            case 9:
                StringBuilder sb = new StringBuilder(getElementType().getClassName());
                for (int dimensions = getDimensions(); dimensions > 0; dimensions--) {
                    sb.append("[]");
                }
                return sb.toString();
            case 10:
                return new String(this.buf, this.off, this.len).replace(IOUtils.DIR_SEPARATOR_UNIX, '.');
            default:
                return null;
        }
    }

    public String getInternalName() {
        return new String(this.buf, this.off, this.len);
    }

    public Type[] getArgumentTypes() {
        return getArgumentTypes(getDescriptor());
    }

    public Type getReturnType() {
        return getReturnType(getDescriptor());
    }

    public int getArgumentsAndReturnSizes() {
        return getArgumentsAndReturnSizes(getDescriptor());
    }

    public String getDescriptor() {
        StringBuilder sb = new StringBuilder();
        getDescriptor(sb);
        return sb.toString();
    }

    public static String getMethodDescriptor(Type type, Type... typeArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(VersionRange.LEFT_OPEN);
        for (Type descriptor : typeArr) {
            descriptor.getDescriptor(sb);
        }
        sb.append(VersionRange.RIGHT_OPEN);
        type.getDescriptor(sb);
        return sb.toString();
    }

    private void getDescriptor(StringBuilder sb) {
        char[] cArr = this.buf;
        if (cArr == null) {
            sb.append((char) ((this.off & -16777216) >>> 24));
        } else if (this.sort == 10) {
            sb.append(Matrix.MATRIX_TYPE_RANDOM_LT);
            sb.append(this.buf, this.off, this.len);
            sb.append(';');
        } else {
            sb.append(cArr, this.off, this.len);
        }
    }

    public static String getInternalName(Class<?> cls) {
        return cls.getName().replace('.', IOUtils.DIR_SEPARATOR_UNIX);
    }

    public static String getDescriptor(Class<?> cls) {
        StringBuilder sb = new StringBuilder();
        getDescriptor(sb, cls);
        return sb.toString();
    }

    public static String getConstructorDescriptor(Constructor<?> constructor) {
        Class[] parameterTypes = constructor.getParameterTypes();
        StringBuilder sb = new StringBuilder();
        sb.append(VersionRange.LEFT_OPEN);
        for (Class descriptor : parameterTypes) {
            getDescriptor(sb, descriptor);
        }
        sb.append(")V");
        return sb.toString();
    }

    public static String getMethodDescriptor(Method method) {
        Class[] parameterTypes = method.getParameterTypes();
        StringBuilder sb = new StringBuilder();
        sb.append(VersionRange.LEFT_OPEN);
        for (Class descriptor : parameterTypes) {
            getDescriptor(sb, descriptor);
        }
        sb.append(VersionRange.RIGHT_OPEN);
        getDescriptor(sb, method.getReturnType());
        return sb.toString();
    }

    private static void getDescriptor(StringBuilder sb, Class<?> cls) {
        char c;
        while (!cls.isPrimitive()) {
            if (cls.isArray()) {
                sb.append(VersionRange.LEFT_CLOSED);
                cls = cls.getComponentType();
            } else {
                sb.append(Matrix.MATRIX_TYPE_RANDOM_LT);
                String name = cls.getName();
                int length = name.length();
                for (int i = 0; i < length; i++) {
                    char charAt = name.charAt(i);
                    if (charAt == '.') {
                        charAt = IOUtils.DIR_SEPARATOR_UNIX;
                    }
                    sb.append(charAt);
                }
                sb.append(';');
                return;
            }
        }
        if (cls == Integer.TYPE) {
            c = 'I';
        } else if (cls == Void.TYPE) {
            c = 'V';
        } else if (cls == Boolean.TYPE) {
            c = Matrix.MATRIX_TYPE_ZERO;
        } else if (cls == Byte.TYPE) {
            c = 'B';
        } else if (cls == Character.TYPE) {
            c = 'C';
        } else if (cls == Short.TYPE) {
            c = 'S';
        } else if (cls == Double.TYPE) {
            c = 'D';
        } else {
            c = cls == Float.TYPE ? 'F' : 'J';
        }
        sb.append(c);
    }

    public int getSize() {
        if (this.buf == null) {
            return this.off & 255;
        }
        return 1;
    }

    public int getOpcode(int i) {
        int i2 = 4;
        if (i == 46 || i == 79) {
            if (this.buf == null) {
                i2 = (this.off & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
            }
            return i + i2;
        }
        if (this.buf == null) {
            i2 = (this.off & 16711680) >> 16;
        }
        return i + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Type)) {
            return false;
        }
        Type type = (Type) obj;
        int i = this.sort;
        if (i != type.sort) {
            return false;
        }
        if (i >= 9) {
            int i2 = this.len;
            if (i2 != type.len) {
                return false;
            }
            int i3 = this.off;
            int i4 = type.off;
            int i5 = i2 + i3;
            while (i3 < i5) {
                if (this.buf[i3] != type.buf[i4]) {
                    return false;
                }
                i3++;
                i4++;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.sort;
        int i2 = i * 13;
        if (i >= 9) {
            int i3 = this.off;
            int i4 = this.len + i3;
            while (i3 < i4) {
                i2 = (i2 + this.buf[i3]) * 17;
                i3++;
            }
        }
        return i2;
    }

    public String toString() {
        return getDescriptor();
    }
}
