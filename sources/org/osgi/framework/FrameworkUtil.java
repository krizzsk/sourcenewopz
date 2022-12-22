package org.osgi.framework;

import java.lang.reflect.AccessibleObject;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import kotlin.text.Typography;
import org.apache.commons.p071io.IOUtils;

public class FrameworkUtil {
    private FrameworkUtil() {
    }

    public static Filter createFilter(String str) throws InvalidSyntaxException {
        return FilterImpl.newInstance(str);
    }

    public static boolean matchDistinguishedNameChain(String str, List<String> list) {
        return DNChainMatching.match(str, list);
    }

    public static Bundle getBundle(final Class<?> cls) {
        Object doPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() {
            public Object run() {
                return cls.getClassLoader();
            }
        });
        if (doPrivileged instanceof BundleReference) {
            return ((BundleReference) doPrivileged).getBundle();
        }
        return null;
    }

    private static final class FilterImpl implements Filter {
        private static final int AND = 7;
        private static final int APPROX = 2;
        private static final int EQUAL = 1;
        private static final int GREATER = 3;
        private static final int LESS = 4;
        private static final int NOT = 9;

        /* renamed from: OR */
        private static final int f6693OR = 8;
        private static final int PRESENT = 5;
        private static final int SUBSTRING = 6;
        private final String attr;
        private transient String filterString = null;

        /* renamed from: op */
        private final int f6694op;
        private final Object value;

        static FilterImpl newInstance(String str) throws InvalidSyntaxException {
            return new Parser(str).parse();
        }

        FilterImpl(int i, String str, Object obj) {
            this.f6694op = i;
            this.attr = str;
            this.value = obj;
        }

        public boolean match(ServiceReference<?> serviceReference) {
            return matches(new ServiceReferenceMap(serviceReference));
        }

        public boolean match(Dictionary<String, ?> dictionary) {
            return matches(new CaseInsensitiveMap(dictionary));
        }

        public boolean matchCase(Dictionary<String, ?> dictionary) {
            Object obj = null;
            switch (this.f6694op) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    if (dictionary != null) {
                        obj = dictionary.get(this.attr);
                    }
                    return compare(this.f6694op, obj, this.value);
                case 5:
                    if (dictionary != null) {
                        obj = dictionary.get(this.attr);
                    }
                    if (obj != null) {
                        return true;
                    }
                    return false;
                case 7:
                    for (FilterImpl matchCase : (FilterImpl[]) this.value) {
                        if (!matchCase.matchCase(dictionary)) {
                            return false;
                        }
                    }
                    return true;
                case 8:
                    for (FilterImpl matchCase2 : (FilterImpl[]) this.value) {
                        if (matchCase2.matchCase(dictionary)) {
                            return true;
                        }
                    }
                    return false;
                case 9:
                    return !((FilterImpl) this.value).matchCase(dictionary);
                default:
                    return false;
            }
        }

        public boolean matches(Map<String, ?> map) {
            Object obj = null;
            switch (this.f6694op) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    if (map != null) {
                        obj = map.get(this.attr);
                    }
                    return compare(this.f6694op, obj, this.value);
                case 5:
                    if (map != null) {
                        obj = map.get(this.attr);
                    }
                    if (obj != null) {
                        return true;
                    }
                    return false;
                case 7:
                    for (FilterImpl matches : (FilterImpl[]) this.value) {
                        if (!matches.matches(map)) {
                            return false;
                        }
                    }
                    return true;
                case 8:
                    for (FilterImpl matches2 : (FilterImpl[]) this.value) {
                        if (matches2.matches(map)) {
                            return true;
                        }
                    }
                    return false;
                case 9:
                    return !((FilterImpl) this.value).matches(map);
                default:
                    return false;
            }
        }

        public String toString() {
            String str = this.filterString;
            if (str != null) {
                return str;
            }
            String stringBuffer = normalize().toString();
            this.filterString = stringBuffer;
            return stringBuffer;
        }

        private StringBuffer normalize() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(VersionRange.LEFT_OPEN);
            int i = 0;
            switch (this.f6694op) {
                case 1:
                    stringBuffer.append(this.attr);
                    stringBuffer.append('=');
                    stringBuffer.append(encodeValue((String) this.value));
                    break;
                case 2:
                    stringBuffer.append(this.attr);
                    stringBuffer.append("~=");
                    stringBuffer.append(encodeValue(approxString((String) this.value)));
                    break;
                case 3:
                    stringBuffer.append(this.attr);
                    stringBuffer.append(">=");
                    stringBuffer.append(encodeValue((String) this.value));
                    break;
                case 4:
                    stringBuffer.append(this.attr);
                    stringBuffer.append("<=");
                    stringBuffer.append(encodeValue((String) this.value));
                    break;
                case 5:
                    stringBuffer.append(this.attr);
                    stringBuffer.append("=*");
                    break;
                case 6:
                    stringBuffer.append(this.attr);
                    stringBuffer.append('=');
                    String[] strArr = (String[]) this.value;
                    int length = strArr.length;
                    while (i < length) {
                        String str = strArr[i];
                        if (str == null) {
                            stringBuffer.append('*');
                        } else {
                            stringBuffer.append(encodeValue(str));
                        }
                        i++;
                    }
                    break;
                case 7:
                    stringBuffer.append(Typography.amp);
                    FilterImpl[] filterImplArr = (FilterImpl[]) this.value;
                    int length2 = filterImplArr.length;
                    while (i < length2) {
                        stringBuffer.append(filterImplArr[i].normalize());
                        i++;
                    }
                    break;
                case 8:
                    stringBuffer.append('|');
                    FilterImpl[] filterImplArr2 = (FilterImpl[]) this.value;
                    int length3 = filterImplArr2.length;
                    while (i < length3) {
                        stringBuffer.append(filterImplArr2[i].normalize());
                        i++;
                    }
                    break;
                case 9:
                    stringBuffer.append('!');
                    stringBuffer.append(((FilterImpl) this.value).normalize());
                    break;
            }
            stringBuffer.append(VersionRange.RIGHT_OPEN);
            return stringBuffer;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Filter)) {
                return false;
            }
            return toString().equals(obj.toString());
        }

        public int hashCode() {
            return toString().hashCode();
        }

        private static String encodeValue(String str) {
            int length = str.length();
            int i = length << 1;
            char[] cArr = new char[i];
            str.getChars(0, length, cArr, length);
            boolean z = false;
            int i2 = 0;
            while (length < i) {
                char c = cArr[length];
                if (c != '\\') {
                    switch (c) {
                        case '(':
                        case ')':
                        case '*':
                            break;
                    }
                }
                cArr[i2] = IOUtils.DIR_SEPARATOR_WINDOWS;
                i2++;
                z = true;
                cArr[i2] = c;
                i2++;
                length++;
            }
            return z ? new String(cArr, 0, i2) : str;
        }

        private boolean compare(int i, Object obj, Object obj2) {
            if (obj == null) {
                return false;
            }
            if (obj instanceof String) {
                return compare_String(i, (String) obj, obj2);
            }
            Class<?> cls = obj.getClass();
            if (cls.isArray()) {
                Class<?> componentType = cls.getComponentType();
                if (componentType.isPrimitive()) {
                    return compare_PrimitiveArray(i, componentType, obj, obj2);
                }
                return compare_ObjectArray(i, (Object[]) obj, obj2);
            } else if (obj instanceof Collection) {
                return compare_Collection(i, (Collection) obj, obj2);
            } else {
                if (obj instanceof Integer) {
                    return compare_Integer(i, ((Integer) obj).intValue(), obj2);
                }
                if (obj instanceof Long) {
                    return compare_Long(i, ((Long) obj).longValue(), obj2);
                }
                if (obj instanceof Byte) {
                    return compare_Byte(i, ((Byte) obj).byteValue(), obj2);
                }
                if (obj instanceof Short) {
                    return compare_Short(i, ((Short) obj).shortValue(), obj2);
                }
                if (obj instanceof Character) {
                    return compare_Character(i, ((Character) obj).charValue(), obj2);
                }
                if (obj instanceof Float) {
                    return compare_Float(i, ((Float) obj).floatValue(), obj2);
                }
                if (obj instanceof Double) {
                    return compare_Double(i, ((Double) obj).doubleValue(), obj2);
                }
                if (obj instanceof Boolean) {
                    return compare_Boolean(i, ((Boolean) obj).booleanValue(), obj2);
                }
                if (obj instanceof Comparable) {
                    return compare_Comparable(i, (Comparable) obj, obj2);
                }
                return compare_Unknown(i, obj, obj2);
            }
        }

        private boolean compare_Collection(int i, Collection<?> collection, Object obj) {
            for (Object compare : collection) {
                if (compare(i, compare, obj)) {
                    return true;
                }
            }
            return false;
        }

        private boolean compare_ObjectArray(int i, Object[] objArr, Object obj) {
            for (Object compare : objArr) {
                if (compare(i, compare, obj)) {
                    return true;
                }
            }
            return false;
        }

        private boolean compare_PrimitiveArray(int i, Class<?> cls, Object obj, Object obj2) {
            if (Integer.TYPE.isAssignableFrom(cls)) {
                for (int compare_Integer : (int[]) obj) {
                    if (compare_Integer(i, compare_Integer, obj2)) {
                        return true;
                    }
                }
                return false;
            } else if (Long.TYPE.isAssignableFrom(cls)) {
                for (long compare_Long : (long[]) obj) {
                    if (compare_Long(i, compare_Long, obj2)) {
                        return true;
                    }
                }
                return false;
            } else if (Byte.TYPE.isAssignableFrom(cls)) {
                for (byte compare_Byte : (byte[]) obj) {
                    if (compare_Byte(i, compare_Byte, obj2)) {
                        return true;
                    }
                }
                return false;
            } else if (Short.TYPE.isAssignableFrom(cls)) {
                for (short compare_Short : (short[]) obj) {
                    if (compare_Short(i, compare_Short, obj2)) {
                        return true;
                    }
                }
                return false;
            } else if (Character.TYPE.isAssignableFrom(cls)) {
                for (char compare_Character : (char[]) obj) {
                    if (compare_Character(i, compare_Character, obj2)) {
                        return true;
                    }
                }
                return false;
            } else if (Float.TYPE.isAssignableFrom(cls)) {
                for (float compare_Float : (float[]) obj) {
                    if (compare_Float(i, compare_Float, obj2)) {
                        return true;
                    }
                }
                return false;
            } else if (Double.TYPE.isAssignableFrom(cls)) {
                for (double compare_Double : (double[]) obj) {
                    if (compare_Double(i, compare_Double, obj2)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (Boolean.TYPE.isAssignableFrom(cls)) {
                    for (boolean compare_Boolean : (boolean[]) obj) {
                        if (compare_Boolean(i, compare_Boolean, obj2)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }

        private boolean compare_String(int i, String str, Object obj) {
            if (i == 1) {
                return str.equals(obj);
            }
            if (i == 2) {
                return approxString(str).equalsIgnoreCase(approxString((String) obj));
            }
            if (i != 3) {
                if (i != 4) {
                    if (i != 6) {
                        return false;
                    }
                    String[] strArr = (String[]) obj;
                    int length = strArr.length;
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < length) {
                        String str2 = strArr[i2];
                        int i4 = i2 + 1;
                        if (i4 < length) {
                            if (str2 == null) {
                                String str3 = strArr[i4];
                                if (str3 != null) {
                                    int indexOf = str.indexOf(str3, i3);
                                    if (indexOf == -1) {
                                        return false;
                                    }
                                    i3 = indexOf + str3.length();
                                    if (i2 + 2 < length) {
                                        i2 = i4;
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                int length2 = str2.length();
                                if (!str.regionMatches(i3, str2, 0, length2)) {
                                    return false;
                                }
                                i3 += length2;
                            }
                            i2++;
                        } else if (str2 == null) {
                            return true;
                        } else {
                            return str.endsWith(str2);
                        }
                    }
                    return true;
                } else if (str.compareTo((String) obj) <= 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (str.compareTo((String) obj) >= 0) {
                return true;
            } else {
                return false;
            }
        }

        private boolean compare_Integer(int i, int i2, Object obj) {
            if (i == 6) {
                return false;
            }
            try {
                int parseInt = Integer.parseInt(((String) obj).trim());
                return (i == 1 || i == 2) ? i2 == parseInt : i != 3 ? i == 4 && i2 <= parseInt : i2 >= parseInt;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }

        private boolean compare_Long(int i, long j, Object obj) {
            if (i == 6) {
                return false;
            }
            try {
                long parseLong = Long.parseLong(((String) obj).trim());
                return (i == 1 || i == 2) ? j == parseLong : i != 3 ? i == 4 && j <= parseLong : j >= parseLong;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }

        private boolean compare_Byte(int i, byte b, Object obj) {
            if (i == 6) {
                return false;
            }
            try {
                byte parseByte = Byte.parseByte(((String) obj).trim());
                return (i == 1 || i == 2) ? b == parseByte : i != 3 ? i == 4 && b <= parseByte : b >= parseByte;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }

        private boolean compare_Short(int i, short s, Object obj) {
            if (i == 6) {
                return false;
            }
            try {
                short parseShort = Short.parseShort(((String) obj).trim());
                return (i == 1 || i == 2) ? s == parseShort : i != 3 ? i == 4 && s <= parseShort : s >= parseShort;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }

        private boolean compare_Character(int i, char c, Object obj) {
            if (i == 6) {
                return false;
            }
            try {
                char charAt = ((String) obj).charAt(0);
                if (i != 1) {
                    if (i != 2) {
                        return i != 3 ? i == 4 && c <= charAt : c >= charAt;
                    }
                    if (c == charAt || Character.toUpperCase(c) == Character.toUpperCase(charAt) || Character.toLowerCase(c) == Character.toLowerCase(charAt)) {
                        return true;
                    }
                    return false;
                } else if (c == charAt) {
                    return true;
                } else {
                    return false;
                }
            } catch (IndexOutOfBoundsException unused) {
                return false;
            }
        }

        private boolean compare_Boolean(int i, boolean z, Object obj) {
            if (i == 6) {
                return false;
            }
            return (i == 1 || i == 2 || i == 3 || i == 4) && z == Boolean.valueOf(((String) obj).trim()).booleanValue();
        }

        private boolean compare_Float(int i, float f, Object obj) {
            if (i == 6) {
                return false;
            }
            try {
                float parseFloat = Float.parseFloat(((String) obj).trim());
                if (i == 1 || i == 2) {
                    if (Float.compare(f, parseFloat) == 0) {
                        return true;
                    }
                    return false;
                } else if (i != 3) {
                    if (i == 4 && Float.compare(f, parseFloat) <= 0) {
                        return true;
                    }
                    return false;
                } else if (Float.compare(f, parseFloat) >= 0) {
                    return true;
                } else {
                    return false;
                }
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }

        private boolean compare_Double(int i, double d, Object obj) {
            if (i == 6) {
                return false;
            }
            try {
                double parseDouble = Double.parseDouble(((String) obj).trim());
                if (i == 1 || i == 2) {
                    if (Double.compare(d, parseDouble) == 0) {
                        return true;
                    }
                    return false;
                } else if (i != 3) {
                    if (i == 4 && Double.compare(d, parseDouble) <= 0) {
                        return true;
                    }
                    return false;
                } else if (Double.compare(d, parseDouble) >= 0) {
                    return true;
                } else {
                    return false;
                }
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|(4:7|8|9|10)|13|14|15|16|17|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x004e, code lost:
            return null;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0034 */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* JADX WARNING: Removed duplicated region for block: B:20:? A[ExcHandler: NoSuchMethodException (unused java.lang.NoSuchMethodException), SYNTHETIC, Splitter:B:16:0x0041] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.lang.Object valueOf(java.lang.Class<?> r6, java.lang.String r7) {
            /*
                r0 = 0
                r1 = 1
                r2 = 0
                java.lang.String r3 = "valueOf"
                java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x0034 }
                java.lang.Class<java.lang.String> r5 = java.lang.String.class
                r4[r0] = r5     // Catch:{ NoSuchMethodException -> 0x0034 }
                java.lang.reflect.Method r3 = r6.getMethod(r3, r4)     // Catch:{ NoSuchMethodException -> 0x0034 }
                int r4 = r3.getModifiers()
                boolean r4 = java.lang.reflect.Modifier.isStatic(r4)
                if (r4 == 0) goto L_0x0034
                java.lang.Class r4 = r3.getReturnType()
                boolean r4 = r6.isAssignableFrom(r4)
                if (r4 == 0) goto L_0x0034
                setAccessible(r3)
                java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0033 }
                java.lang.String r7 = r7.trim()     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0033 }
                r6[r0] = r7     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0033 }
                java.lang.Object r6 = r3.invoke(r2, r6)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0033 }
                return r6
            L_0x0033:
                return r2
            L_0x0034:
                java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{  }
                java.lang.Class<java.lang.String> r4 = java.lang.String.class
                r3[r0] = r4     // Catch:{  }
                java.lang.reflect.Constructor r6 = r6.getConstructor(r3)     // Catch:{  }
                setAccessible(r6)
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ NoSuchMethodException -> 0x004e, NoSuchMethodException -> 0x004e }
                java.lang.String r7 = r7.trim()     // Catch:{ NoSuchMethodException -> 0x004e, NoSuchMethodException -> 0x004e }
                r1[r0] = r7     // Catch:{ NoSuchMethodException -> 0x004e, NoSuchMethodException -> 0x004e }
                java.lang.Object r6 = r6.newInstance(r1)     // Catch:{ NoSuchMethodException -> 0x004e, NoSuchMethodException -> 0x004e }
                return r6
            L_0x004e:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: org.osgi.framework.FrameworkUtil.FilterImpl.valueOf(java.lang.Class, java.lang.String):java.lang.Object");
        }

        private static void setAccessible(AccessibleObject accessibleObject) {
            if (!accessibleObject.isAccessible()) {
                AccessController.doPrivileged(new SetAccessibleAction(accessibleObject));
            }
        }

        private boolean compare_Comparable(int i, Comparable<Object> comparable, Object obj) {
            Object valueOf;
            if (i == 6 || (valueOf = valueOf(comparable.getClass(), (String) obj)) == null) {
                return false;
            }
            if (i == 1 || i == 2) {
                if (comparable.compareTo(valueOf) == 0) {
                    return true;
                }
                return false;
            } else if (i != 3) {
                if (i != 4) {
                    return false;
                }
                try {
                    if (comparable.compareTo(valueOf) <= 0) {
                        return true;
                    }
                    return false;
                } catch (Exception unused) {
                    return false;
                }
            } else if (comparable.compareTo(valueOf) >= 0) {
                return true;
            } else {
                return false;
            }
        }

        private boolean compare_Unknown(int i, Object obj, Object obj2) {
            Object valueOf;
            if (i == 6 || (valueOf = valueOf(obj.getClass(), (String) obj2)) == null) {
                return false;
            }
            if (i != 1 && i != 2 && i != 3 && i != 4) {
                return false;
            }
            try {
                return obj.equals(valueOf);
            } catch (Exception unused) {
                return false;
            }
        }

        private static String approxString(String str) {
            char[] charArray = str.toCharArray();
            boolean z = false;
            int i = 0;
            for (char c : charArray) {
                if (Character.isWhitespace(c)) {
                    z = true;
                } else {
                    charArray[i] = c;
                    i++;
                }
            }
            return z ? new String(charArray, 0, i) : str;
        }

        private static final class Parser {
            private final char[] filterChars;
            private final String filterstring;
            private int pos = 0;

            Parser(String str) {
                this.filterstring = str;
                this.filterChars = str.toCharArray();
            }

            /* access modifiers changed from: package-private */
            public FilterImpl parse() throws InvalidSyntaxException {
                try {
                    FilterImpl parse_filter = parse_filter();
                    if (this.pos == this.filterChars.length) {
                        return parse_filter;
                    }
                    throw new InvalidSyntaxException("Extraneous trailing characters: " + this.filterstring.substring(this.pos), this.filterstring);
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new InvalidSyntaxException("Filter ended abruptly", this.filterstring, e);
                }
            }

            private FilterImpl parse_filter() throws InvalidSyntaxException {
                skipWhiteSpace();
                char[] cArr = this.filterChars;
                int i = this.pos;
                if (cArr[i] == '(') {
                    this.pos = i + 1;
                    FilterImpl parse_filtercomp = parse_filtercomp();
                    skipWhiteSpace();
                    char[] cArr2 = this.filterChars;
                    int i2 = this.pos;
                    if (cArr2[i2] == ')') {
                        this.pos = i2 + 1;
                        skipWhiteSpace();
                        return parse_filtercomp;
                    }
                    throw new InvalidSyntaxException("Missing ')': " + this.filterstring.substring(this.pos), this.filterstring);
                }
                throw new InvalidSyntaxException("Missing '(': " + this.filterstring.substring(this.pos), this.filterstring);
            }

            private FilterImpl parse_filtercomp() throws InvalidSyntaxException {
                skipWhiteSpace();
                char[] cArr = this.filterChars;
                int i = this.pos;
                char c = cArr[i];
                if (c == '!') {
                    this.pos = i + 1;
                    return parse_not();
                } else if (c == '&') {
                    this.pos = i + 1;
                    return parse_and();
                } else if (c != '|') {
                    return parse_item();
                } else {
                    this.pos = i + 1;
                    return parse_or();
                }
            }

            private FilterImpl parse_and() throws InvalidSyntaxException {
                int i = this.pos;
                skipWhiteSpace();
                if (this.filterChars[this.pos] != '(') {
                    this.pos = i - 1;
                    return parse_item();
                }
                ArrayList arrayList = new ArrayList(10);
                while (this.filterChars[this.pos] == '(') {
                    arrayList.add(parse_filter());
                }
                return new FilterImpl(7, (String) null, arrayList.toArray(new FilterImpl[arrayList.size()]));
            }

            private FilterImpl parse_or() throws InvalidSyntaxException {
                int i = this.pos;
                skipWhiteSpace();
                if (this.filterChars[this.pos] != '(') {
                    this.pos = i - 1;
                    return parse_item();
                }
                ArrayList arrayList = new ArrayList(10);
                while (this.filterChars[this.pos] == '(') {
                    arrayList.add(parse_filter());
                }
                return new FilterImpl(8, (String) null, arrayList.toArray(new FilterImpl[arrayList.size()]));
            }

            private FilterImpl parse_not() throws InvalidSyntaxException {
                int i = this.pos;
                skipWhiteSpace();
                if (this.filterChars[this.pos] == '(') {
                    return new FilterImpl(9, (String) null, parse_filter());
                }
                this.pos = i - 1;
                return parse_item();
            }

            private FilterImpl parse_item() throws InvalidSyntaxException {
                String parse_attr = parse_attr();
                skipWhiteSpace();
                char[] cArr = this.filterChars;
                int i = this.pos;
                char c = cArr[i];
                if (c != '~') {
                    switch (c) {
                        case '<':
                            if (cArr[i + 1] == '=') {
                                this.pos = i + 2;
                                return new FilterImpl(4, parse_attr, parse_value());
                            }
                            break;
                        case '=':
                            if (cArr[i + 1] == '*') {
                                this.pos = i + 2;
                                skipWhiteSpace();
                                if (this.filterChars[this.pos] == ')') {
                                    return new FilterImpl(5, parse_attr, (Object) null);
                                }
                                this.pos = i;
                            }
                            this.pos++;
                            Object parse_substring = parse_substring();
                            if (parse_substring instanceof String) {
                                return new FilterImpl(1, parse_attr, parse_substring);
                            }
                            return new FilterImpl(6, parse_attr, parse_substring);
                        case '>':
                            if (cArr[i + 1] == '=') {
                                this.pos = i + 2;
                                return new FilterImpl(3, parse_attr, parse_value());
                            }
                            break;
                    }
                } else if (cArr[i + 1] == '=') {
                    this.pos = i + 2;
                    return new FilterImpl(2, parse_attr, parse_value());
                }
                throw new InvalidSyntaxException("Invalid operator: " + this.filterstring.substring(this.pos), this.filterstring);
            }

            private String parse_attr() throws InvalidSyntaxException {
                skipWhiteSpace();
                int i = this.pos;
                char c = this.filterChars[i];
                int i2 = i;
                while (c != '~' && c != '<' && c != '>' && c != '=' && c != '(' && c != ')') {
                    this.pos++;
                    if (!Character.isWhitespace(c)) {
                        i2 = this.pos;
                    }
                    c = this.filterChars[this.pos];
                }
                int i3 = i2 - i;
                if (i3 != 0) {
                    return new String(this.filterChars, i, i3);
                }
                throw new InvalidSyntaxException("Missing attr: " + this.filterstring.substring(this.pos), this.filterstring);
            }

            private String parse_value() throws InvalidSyntaxException {
                StringBuffer stringBuffer = new StringBuffer(this.filterChars.length - this.pos);
                while (true) {
                    char[] cArr = this.filterChars;
                    int i = this.pos;
                    char c = cArr[i];
                    if (c == '(') {
                        throw new InvalidSyntaxException("Invalid value: " + this.filterstring.substring(this.pos), this.filterstring);
                    } else if (c != ')') {
                        if (c == '\\') {
                            int i2 = i + 1;
                            this.pos = i2;
                            c = cArr[i2];
                        }
                        stringBuffer.append(c);
                        this.pos++;
                    } else if (stringBuffer.length() != 0) {
                        return stringBuffer.toString();
                    } else {
                        throw new InvalidSyntaxException("Missing value: " + this.filterstring.substring(this.pos), this.filterstring);
                    }
                }
            }

            private Object parse_substring() throws InvalidSyntaxException {
                Object obj;
                StringBuffer stringBuffer = new StringBuffer(this.filterChars.length - this.pos);
                ArrayList arrayList = new ArrayList(10);
                while (true) {
                    char[] cArr = this.filterChars;
                    int i = this.pos;
                    char c = cArr[i];
                    if (c != '\\') {
                        switch (c) {
                            case '(':
                                throw new InvalidSyntaxException("Invalid value: " + this.filterstring.substring(this.pos), this.filterstring);
                            case ')':
                                if (stringBuffer.length() > 0) {
                                    arrayList.add(stringBuffer.toString());
                                }
                                int size = arrayList.size();
                                if (size == 0) {
                                    return "";
                                }
                                if (size != 1 || (obj = arrayList.get(0)) == null) {
                                    return arrayList.toArray(new String[size]);
                                }
                                return obj;
                            case '*':
                                if (stringBuffer.length() > 0) {
                                    arrayList.add(stringBuffer.toString());
                                }
                                stringBuffer.setLength(0);
                                arrayList.add((Object) null);
                                this.pos++;
                                continue;
                        }
                    } else {
                        int i2 = i + 1;
                        this.pos = i2;
                        c = cArr[i2];
                    }
                    stringBuffer.append(c);
                    this.pos++;
                }
            }

            private void skipWhiteSpace() {
                int length = this.filterChars.length;
                while (true) {
                    int i = this.pos;
                    if (i < length && Character.isWhitespace(this.filterChars[i])) {
                        this.pos++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private static final class CaseInsensitiveMap extends AbstractMap<String, Object> implements Map<String, Object> {
        private final Dictionary<String, ?> dictionary;
        private final String[] keys;

        CaseInsensitiveMap(Dictionary<String, ?> dictionary2) {
            if (dictionary2 == null) {
                this.dictionary = null;
                this.keys = new String[0];
                return;
            }
            this.dictionary = dictionary2;
            ArrayList<String> arrayList = new ArrayList<>(dictionary2.size());
            Enumeration<String> keys2 = dictionary2.keys();
            while (keys2.hasMoreElements()) {
                String nextElement = keys2.nextElement();
                if (nextElement instanceof String) {
                    String str = nextElement;
                    for (String equalsIgnoreCase : arrayList) {
                        if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                            throw new IllegalArgumentException();
                        }
                    }
                    arrayList.add(str);
                }
            }
            this.keys = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }

        public Object get(Object obj) {
            String str = (String) obj;
            for (String str2 : this.keys) {
                if (str2.equalsIgnoreCase(str)) {
                    return this.dictionary.get(str2);
                }
            }
            return null;
        }

        public Set<Map.Entry<String, Object>> entrySet() {
            throw new UnsupportedOperationException();
        }
    }

    private static final class ServiceReferenceMap extends AbstractMap<String, Object> implements Map<String, Object> {
        private final ServiceReference<?> reference;

        ServiceReferenceMap(ServiceReference<?> serviceReference) {
            this.reference = serviceReference;
        }

        public Object get(Object obj) {
            ServiceReference<?> serviceReference = this.reference;
            if (serviceReference == null) {
                return null;
            }
            return serviceReference.getProperty((String) obj);
        }

        public Set<Map.Entry<String, Object>> entrySet() {
            throw new UnsupportedOperationException();
        }
    }

    private static final class SetAccessibleAction implements PrivilegedAction<Void> {
        private final AccessibleObject accessible;

        SetAccessibleAction(AccessibleObject accessibleObject) {
            this.accessible = accessibleObject;
        }

        public Void run() {
            this.accessible.setAccessible(true);
            return null;
        }
    }

    private static final class DNChainMatching {
        private static final String MINUS_WILDCARD = "-";
        private static final String STAR_WILDCARD = "*";

        private DNChainMatching() {
        }

        private static boolean rdnmatch(List<?> list, List<?> list2) {
            if (list.size() != list2.size()) {
                return false;
            }
            for (int i = 0; i < list.size(); i++) {
                String str = (String) list.get(i);
                String str2 = (String) list2.get(i);
                int indexOf = str.indexOf(61);
                int indexOf2 = str2.indexOf(61);
                if (indexOf != indexOf2 || !str.regionMatches(0, str2, 0, indexOf)) {
                    return false;
                }
                String substring = str2.substring(indexOf2);
                if (!str.substring(indexOf).equals(substring) && !substring.equals("=*") && !substring.equals("=#16012a")) {
                    return false;
                }
            }
            return true;
        }

        private static boolean dnmatch(List<?> list, List<?> list2) {
            int i;
            int i2;
            int size = list2.size();
            if (size == 0) {
                return false;
            }
            if (list2.get(0).equals("*")) {
                size--;
                i = 1;
            } else {
                i = 0;
            }
            if (list.size() < size) {
                return false;
            }
            if (list.size() <= size) {
                i2 = 0;
            } else if (!list2.get(0).equals("*")) {
                return false;
            } else {
                i2 = list.size() - size;
            }
            for (int i3 = 0; i3 < size; i3++) {
                if (!rdnmatch((List) list.get(i3 + i2), (List) list2.get(i3 + i))) {
                    return false;
                }
            }
            return true;
        }

        private static List<Object> parseDNchainPattern(String str) {
            String str2;
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                int length = str.length();
                int skipSpaces = skipSpaces(str, 0);
                char c = ';';
                while (skipSpaces < length) {
                    int i = skipSpaces;
                    int i2 = i;
                    boolean z = false;
                    while (i < length) {
                        c = str.charAt(i);
                        if (c != '\"') {
                            if (c == ';') {
                                if (!z) {
                                    break;
                                }
                            } else if (c == '\\' && (i = i + 1) == length) {
                                throw new IllegalArgumentException("unterminated escape");
                            }
                        } else {
                            z = !z;
                        }
                        if (c != ' ') {
                            i2 = i + 1;
                        }
                        i++;
                    }
                    arrayList.add(str.substring(skipSpaces, i2));
                    skipSpaces = skipSpaces(str, i + 1);
                }
                if (c != ';') {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        String str3 = (String) arrayList.get(i3);
                        if (!str3.equals("*") && !str3.equals("-")) {
                            ArrayList arrayList2 = new ArrayList();
                            if (str3.charAt(0) == '*') {
                                int skipSpaces2 = skipSpaces(str3, 1);
                                if (str3.charAt(skipSpaces2) == ',') {
                                    arrayList2.add("*");
                                    str2 = new X500Principal(str3.substring(skipSpaces2 + 1)).getName("CANONICAL");
                                } else {
                                    throw new IllegalArgumentException("invalid wildcard prefix");
                                }
                            } else {
                                str2 = new X500Principal(str3).getName("CANONICAL");
                            }
                            parseDN(str2, arrayList2);
                            arrayList.set(i3, arrayList2);
                        }
                    }
                    return arrayList;
                }
                throw new IllegalArgumentException("empty pattern");
            }
            throw new IllegalArgumentException("The pattern must not be null.");
        }

        private static List<Object> parseDNchain(List<String> list) {
            if (list != null) {
                ArrayList arrayList = new ArrayList(list.size());
                for (String x500Principal : list) {
                    String name = new X500Principal(x500Principal).getName("CANONICAL");
                    ArrayList arrayList2 = new ArrayList();
                    parseDN(name, arrayList2);
                    arrayList.add(arrayList2);
                }
                if (arrayList.size() != 0) {
                    return arrayList;
                }
                throw new IllegalArgumentException("empty DN chain");
            }
            throw new IllegalArgumentException("DN chain must not be null.");
        }

        private static int skipSpaces(String str, int i) {
            while (i < str.length() && str.charAt(i) == ' ') {
                i++;
            }
            return i;
        }

        private static void parseDN(String str, List<Object> list) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            char c = 0;
            while (i < str.length()) {
                int i2 = i;
                while (i2 < str.length() && (c = str.charAt(i2)) != ',' && c != '+') {
                    if (c == '\\') {
                        i2++;
                    }
                    i2++;
                }
                if (i2 <= str.length()) {
                    arrayList.add(str.substring(i, i2));
                    if (c != '+') {
                        list.add(arrayList);
                        arrayList = i2 != str.length() ? new ArrayList() : null;
                    }
                    i = i2 + 1;
                } else {
                    throw new IllegalArgumentException("unterminated escape " + str);
                }
            }
            if (arrayList != null) {
                throw new IllegalArgumentException("improperly terminated DN " + str);
            }
        }

        private static int skipWildCards(List<Object> list, int i) {
            while (true) {
                if (i >= list.size()) {
                    break;
                }
                Object obj = list.get(i);
                if (obj instanceof String) {
                    if (obj.equals("*") || obj.equals("-")) {
                        i++;
                    } else {
                        throw new IllegalArgumentException("expected wildcard in DN pattern");
                    }
                } else if (!(obj instanceof List)) {
                    throw new IllegalArgumentException("expected String or List in DN Pattern");
                }
            }
            return i;
        }

        private static boolean dnChainMatch(List<Object> list, int i, List<Object> list2, int i2) throws IllegalArgumentException {
            if (i >= list.size() || i2 >= list2.size()) {
                return false;
            }
            Object obj = list2.get(i2);
            if (obj instanceof String) {
                if (obj.equals("*") || obj.equals("-")) {
                    int skipWildCards = obj.equals("-") ? skipWildCards(list2, i2) : i2 + 1;
                    if (skipWildCards >= list2.size()) {
                        if (!obj.equals("-") && list.size() - 1 != i) {
                            return false;
                        }
                        return true;
                    } else if (!obj.equals("*")) {
                        while (i < list.size()) {
                            if (dnChainMatch(list, i, list2, skipWildCards)) {
                                return true;
                            }
                            i++;
                        }
                        return false;
                    } else if (dnChainMatch(list, i, list2, skipWildCards) || dnChainMatch(list, i + 1, list2, skipWildCards)) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    throw new IllegalArgumentException("expected wildcard in DN pattern");
                }
            } else if (obj instanceof List) {
                while (dnmatch((List) list.get(i), (List) obj)) {
                    i++;
                    i2++;
                    if (i >= list.size() && i2 >= list2.size()) {
                        return true;
                    }
                    if (i >= list.size()) {
                        if (skipWildCards(list2, i2) >= list2.size()) {
                            return true;
                        }
                        return false;
                    } else if (i2 >= list2.size()) {
                        return false;
                    } else {
                        obj = list2.get(i2);
                        if (obj instanceof String) {
                            if (obj.equals("*") || obj.equals("-")) {
                                return dnChainMatch(list, i, list2, i2);
                            }
                            throw new IllegalArgumentException("expected wildcard in DN pattern");
                        } else if (!(obj instanceof List)) {
                            throw new IllegalArgumentException("expected String or List in DN Pattern");
                        }
                    }
                }
                return false;
            } else {
                throw new IllegalArgumentException("expected String or List in DN Pattern");
            }
        }

        static boolean match(String str, List<String> list) {
            try {
                try {
                    return dnChainMatch(parseDNchain(list), 0, parseDNchainPattern(str), 0);
                } catch (RuntimeException e) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid match pattern: " + str);
                    illegalArgumentException.initCause(e);
                    throw illegalArgumentException;
                }
            } catch (RuntimeException e2) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Invalid DN chain: " + toString(list));
                illegalArgumentException2.initCause(e2);
                throw illegalArgumentException2;
            }
        }

        private static String toString(List<?> list) {
            if (list == null) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next());
                if (it.hasNext()) {
                    stringBuffer.append("; ");
                }
            }
            return stringBuffer.toString();
        }
    }
}
