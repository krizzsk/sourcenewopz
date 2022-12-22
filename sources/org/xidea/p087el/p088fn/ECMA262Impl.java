package org.xidea.p087el.p088fn;

import java.util.Date;
import java.util.List;
import org.xidea.p087el.impl.ExpressionFactoryImpl;
import org.xidea.p087el.impl.ReflectUtil;

/* renamed from: org.xidea.el.fn.ECMA262Impl */
public abstract class ECMA262Impl {
    private static final Class<?>[] ARRAY_CLASSES = {List.class, Object[].class, int[].class, float[].class, double[].class, long[].class, short[].class, byte[].class, char[].class};

    public static void setup(ExpressionFactoryImpl expressionFactoryImpl) {
        setup(expressionFactoryImpl, JSArray.class, ARRAY_CLASSES);
        setup(expressionFactoryImpl, JSNumber.class, Number.class);
        setup(expressionFactoryImpl, JSString.class, String.class);
        JSGlobal.setupVar(expressionFactoryImpl);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002e */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0033 A[Catch:{ Exception -> 0x0042 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void setup(org.xidea.p087el.impl.ExpressionFactoryImpl r10, java.lang.Class<? extends org.xidea.p087el.p088fn.JSObject> r11, java.lang.Class<?>... r12) {
        /*
            java.lang.reflect.Method[] r0 = r11.getMethods()     // Catch:{ Exception -> 0x0042 }
            int r1 = r0.length     // Catch:{ Exception -> 0x0042 }
            r2 = 0
            r3 = 0
        L_0x0007:
            if (r3 < r1) goto L_0x000a
            goto L_0x0042
        L_0x000a:
            r4 = r0[r3]     // Catch:{ Exception -> 0x0042 }
            java.lang.Class r5 = r4.getDeclaringClass()     // Catch:{ Exception -> 0x0042 }
            if (r5 != r11) goto L_0x003f
            java.lang.Object r5 = r11.newInstance()     // Catch:{ Exception -> 0x0042 }
            org.xidea.el.fn.JSObject r5 = (org.xidea.p087el.p088fn.JSObject) r5     // Catch:{ Exception -> 0x0042 }
            java.lang.Class[] r6 = r4.getParameterTypes()     // Catch:{ Exception -> 0x0042 }
            r5.method = r4     // Catch:{ Exception -> 0x0042 }
            int r7 = r6.length     // Catch:{ Exception -> 0x0042 }
            r8 = 2
            r9 = 1
            if (r7 != r8) goto L_0x0029
            r7 = r6[r9]     // Catch:{ Exception -> 0x0042 }
            java.lang.Class<java.lang.Object[]> r8 = java.lang.Object[].class
            if (r7 == r8) goto L_0x002b
        L_0x0029:
            r5.params = r6     // Catch:{ Exception -> 0x0042 }
        L_0x002b:
            r4.setAccessible(r9)     // Catch:{ Exception -> 0x002e }
        L_0x002e:
            int r6 = r12.length     // Catch:{ Exception -> 0x0042 }
            r7 = 0
        L_0x0030:
            if (r7 < r6) goto L_0x0033
            goto L_0x003f
        L_0x0033:
            r8 = r12[r7]     // Catch:{ Exception -> 0x0042 }
            java.lang.String r9 = r4.getName()     // Catch:{ Exception -> 0x0042 }
            r10.addMethod(r8, r9, r5)     // Catch:{ Exception -> 0x0042 }
            int r7 = r7 + 1
            goto L_0x0030
        L_0x003f:
            int r3 = r3 + 1
            goto L_0x0007
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xidea.p087el.p088fn.ECMA262Impl.setup(org.xidea.el.impl.ExpressionFactoryImpl, java.lang.Class, java.lang.Class[]):void");
    }

    private static Number parseNumber(String str, int i) {
        try {
            return Integer.valueOf(Integer.parseInt(str, i));
        } catch (Exception unused) {
            return Long.valueOf(Long.parseLong(str, i));
        }
    }

    public static boolean ToBoolean(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Number) {
            float floatValue = ((Number) obj).floatValue();
            return floatValue != 0.0f && !Float.isNaN(floatValue);
        } else if (obj instanceof String) {
            return ((String) obj).length() > 0;
        } else {
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return true;
        }
    }

    public static Number ToNumber(Object obj) {
        Object ToPrimitive = ToPrimitive(obj, String.class);
        if (ToPrimitive == null) {
            return 0;
        }
        if (ToPrimitive instanceof Boolean) {
            return Integer.valueOf(((Boolean) ToPrimitive).booleanValue() ? 1 : 0);
        }
        if (ToPrimitive instanceof Number) {
            return (Number) ToPrimitive;
        }
        String str = (String) ToPrimitive;
        try {
            if (str.indexOf(46) >= 0) {
                return Float.valueOf(Float.parseFloat(str));
            }
            if (str.length() > 1) {
                char charAt = str.charAt(0);
                char charAt2 = str.charAt(1);
                if (charAt == '+' || charAt == '-') {
                    if (str.length() > 2) {
                        char c = charAt2;
                        charAt2 = str.charAt(2);
                        charAt = c;
                    } else {
                        charAt = charAt2;
                    }
                }
                if (charAt == '0') {
                    if (charAt2 != 'x') {
                        if (charAt2 != 'X') {
                            return parseNumber(str, 10);
                        }
                    }
                    return parseNumber(str.substring(2), 16);
                } else if (str.indexOf(69) > 0 || str.indexOf(101) > 0) {
                    return Float.valueOf(Float.parseFloat(str));
                }
            }
            return parseNumber(str, 10);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    public static Object ToPrimitive(Object obj, Class<?> cls) {
        boolean z = true;
        if (cls == Number.class) {
            z = false;
        } else if (cls != String.class) {
            if (cls == null) {
                z = true ^ (obj instanceof Date);
            } else {
                throw new IllegalArgumentException("expectedType 只能是 Number或者String");
            }
        }
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof String)) {
            return obj;
        }
        if (z) {
            return String.valueOf(obj);
        }
        if (obj instanceof Date) {
            return new Long(((Date) obj).getTime());
        }
        return String.valueOf(obj);
    }

    public static Object ToValue(Object obj, Class<?> cls) {
        if (cls == String.class) {
            if (obj == null) {
                return null;
            }
            return obj.toString();
        } else if (cls != Character.class) {
            Class<? extends Object> wrapper = ReflectUtil.toWrapper(cls);
            if (Number.class.isAssignableFrom(wrapper)) {
                return ReflectUtil.toValue(ToNumber(obj), wrapper);
            }
            return wrapper == Boolean.class ? Boolean.valueOf(ToBoolean(ToPrimitive(obj, wrapper))) : obj;
        } else if (obj == null) {
            return 0;
        } else {
            Object ToPrimitive = ToPrimitive(obj, String.class);
            if (ToPrimitive instanceof Number) {
                return Character.valueOf((char) ((Number) ToPrimitive).intValue());
            }
            String str = (String) ToPrimitive;
            if (str.length() > 0) {
                return Character.valueOf(str.charAt(0));
            }
            return 0;
        }
    }

    public static String ToString(Object obj) {
        Object ToPrimitive = ToPrimitive(obj, String.class);
        if (ToPrimitive instanceof Number) {
            return toString((Number) ToPrimitive, 10);
        }
        return String.valueOf(ToPrimitive);
    }

    static String toString(Number number, int i) {
        if (i <= 0 || i > 36) {
            i = 10;
        }
        if ((number instanceof Double) || (number instanceof Float)) {
            return floatToString(number.doubleValue(), i);
        }
        return Long.toString(number.longValue(), i);
    }

    private static String floatToString(double d, int i) {
        if (Double.isNaN(d)) {
            return "NaN";
        }
        if (Double.isInfinite(d)) {
            return d > 0.0d ? "Infinity" : "-Infinity";
        }
        if (d == 0.0d) {
            return "0";
        }
        if (i == 10) {
            return Long.toString((long) d, i);
        }
        String d2 = Double.toString(d);
        return d2.endsWith(".0") ? d2.substring(0, d2.length() - 2) : d2;
    }
}
