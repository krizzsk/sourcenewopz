package org.xidea.p087el.json;

import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* renamed from: org.xidea.el.json.JSONDecoder */
public class JSONDecoder {
    private static final Pattern W3CDATE = Pattern.compile("^(\\d{4})(?:\\-(\\d{1,2})(?:\\-(\\d{1,2})(?:T(\\d{2})\\:(\\d{2})(?:\\:(\\d{2}(\\.\\d+)?))?(Z|[+\\-]\\d{2}\\:?\\d{2})?)?)?)?$");
    private static JSONDecoder decoder = new JSONDecoder(false);
    private static Log log = LogFactory.getLog(JSONDecoder.class);
    private boolean strict = false;

    public JSONDecoder(boolean z) {
        this.strict = z;
    }

    public Date parseW3Date(String str) throws ParseException {
        Matcher matcher = W3CDATE.matcher(str);
        if (!matcher.find()) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        instance.clear();
        String group = matcher.group(7);
        if (group != null) {
            instance.setTimeZone(TimeZone.getTimeZone("GMT" + group));
        }
        instance.set(1, Integer.parseInt(matcher.group(1)));
        String group2 = matcher.group(2);
        if (group2 != null) {
            instance.set(2, Integer.parseInt(group2) - 1);
            String group3 = matcher.group(3);
            if (group3 != null) {
                instance.set(5, Integer.parseInt(group3));
                String group4 = matcher.group(4);
                if (group4 != null) {
                    String group5 = matcher.group(5);
                    instance.set(10, Integer.parseInt(group4));
                    instance.set(12, Integer.parseInt(group5));
                    String group6 = matcher.group(6);
                    if (group6 != null) {
                        if (group6.length() > 2) {
                            int parseFloat = (int) Float.parseFloat(group6);
                            instance.set(13, parseFloat);
                            instance.set(14, (parseFloat * 1000) % 1000);
                        } else {
                            instance.set(13, Integer.parseInt(group6));
                        }
                    }
                }
            }
        }
        return instance.getTime();
    }

    public static <T> T decode(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[32];
        while (true) {
            int read = reader.read(cArr);
            if (read < 0) {
                return decode(sb.toString());
            }
            sb.append(cArr, 0, read);
        }
    }

    public static <T> T decode(String str) {
        return decoder.decode(str, (Class) null);
    }

    public <T> T decode(String str, Class<T> cls) {
        T parse = new JSONTokenizer(str, this.strict).parse();
        return (cls == null || cls == Object.class) ? parse : toValue(parse, cls);
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [java.lang.Class, java.lang.Class<T>] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T toValue(T r8, java.lang.Class<T> r9) {
        /*
            r7 = this;
            java.lang.String r0 = "JSON 类型异常"
            r1 = 0
            boolean r2 = r9.isPrimitive()     // Catch:{ Exception -> 0x0144 }
            java.lang.Class r9 = org.xidea.p087el.impl.ReflectUtil.toWrapper(r9)     // Catch:{ Exception -> 0x0144 }
            java.lang.Class<java.lang.Number> r3 = java.lang.Number.class
            boolean r3 = r3.isAssignableFrom(r9)     // Catch:{ Exception -> 0x0144 }
            r4 = 0
            if (r3 == 0) goto L_0x0023
            if (r2 == 0) goto L_0x001c
            if (r8 != 0) goto L_0x001c
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0144 }
        L_0x001c:
            java.lang.Number r8 = (java.lang.Number) r8     // Catch:{ Exception -> 0x0144 }
            java.lang.Number r8 = org.xidea.p087el.impl.ReflectUtil.toValue(r8, r9)     // Catch:{ Exception -> 0x0144 }
            return r8
        L_0x0023:
            java.lang.Class<java.lang.Boolean> r3 = java.lang.Boolean.class
            if (r3 != r9) goto L_0x0030
            if (r2 == 0) goto L_0x002f
            if (r8 != 0) goto L_0x002f
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x0144 }
        L_0x002f:
            return r8
        L_0x0030:
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            if (r3 == r9) goto L_0x0143
            if (r9 == 0) goto L_0x0143
            if (r8 == 0) goto L_0x0143
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            boolean r3 = r3.isAssignableFrom(r9)     // Catch:{ Exception -> 0x0144 }
            if (r3 != 0) goto L_0x0143
            java.lang.Class<java.util.Collection> r3 = java.util.Collection.class
            boolean r3 = r3.isAssignableFrom(r9)     // Catch:{ Exception -> 0x0144 }
            if (r3 == 0) goto L_0x004a
            goto L_0x0143
        L_0x004a:
            java.lang.Class<java.lang.Character> r3 = java.lang.Character.class
            if (r3 != r9) goto L_0x0076
            boolean r9 = r8 instanceof java.lang.String     // Catch:{ Exception -> 0x0144 }
            if (r9 == 0) goto L_0x005d
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x0144 }
            char r8 = r8.charAt(r4)     // Catch:{ Exception -> 0x0144 }
            java.lang.Character r8 = java.lang.Character.valueOf(r8)     // Catch:{ Exception -> 0x0144 }
            goto L_0x0075
        L_0x005d:
            boolean r9 = r8 instanceof java.lang.Number     // Catch:{ Exception -> 0x0144 }
            if (r9 == 0) goto L_0x006d
            java.lang.Number r8 = (java.lang.Number) r8     // Catch:{ Exception -> 0x0144 }
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x0144 }
            char r8 = (char) r8     // Catch:{ Exception -> 0x0144 }
            java.lang.Character r8 = java.lang.Character.valueOf(r8)     // Catch:{ Exception -> 0x0144 }
            goto L_0x0075
        L_0x006d:
            if (r2 == 0) goto L_0x0075
            if (r8 != 0) goto L_0x0075
            java.lang.Character r8 = java.lang.Character.valueOf(r4)     // Catch:{ Exception -> 0x0144 }
        L_0x0075:
            return r8
        L_0x0076:
            boolean r2 = r9.isArray()     // Catch:{ Exception -> 0x0144 }
            if (r2 == 0) goto L_0x00a3
            java.util.List r8 = (java.util.List) r8     // Catch:{ Exception -> 0x0144 }
            java.lang.Class r2 = r9.getComponentType()     // Catch:{ Exception -> 0x0144 }
            int r3 = r8.size()     // Catch:{ Exception -> 0x0144 }
            java.lang.Object r2 = java.lang.reflect.Array.newInstance(r2, r3)     // Catch:{ Exception -> 0x0144 }
            int r3 = r8.size()     // Catch:{ Exception -> 0x0144 }
        L_0x008e:
            if (r4 < r3) goto L_0x0091
            return r2
        L_0x0091:
            java.lang.Object r5 = r8.get(r4)     // Catch:{ Exception -> 0x0144 }
            java.lang.Class r6 = r9.getComponentType()     // Catch:{ Exception -> 0x0144 }
            java.lang.Object r5 = r7.toValue(r5, r6)     // Catch:{ Exception -> 0x0144 }
            java.lang.reflect.Array.set(r2, r4, r5)     // Catch:{ Exception -> 0x0144 }
            int r4 = r4 + 1
            goto L_0x008e
        L_0x00a3:
            java.lang.Class<java.util.Date> r2 = java.util.Date.class
            boolean r2 = r2.isAssignableFrom(r9)     // Catch:{ Exception -> 0x0144 }
            r3 = 1
            if (r2 == 0) goto L_0x00d4
            boolean r2 = r8 instanceof java.lang.String     // Catch:{ Exception -> 0x0144 }
            if (r2 == 0) goto L_0x00b7
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x0144 }
            java.util.Date r8 = r7.parseW3Date(r8)     // Catch:{ Exception -> 0x0144 }
            return r8
        L_0x00b7:
            java.lang.Class[] r2 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0144 }
            java.lang.Class<java.lang.Long> r5 = java.lang.Long.class
            r2[r4] = r5     // Catch:{ Exception -> 0x0144 }
            java.lang.reflect.Constructor r9 = r9.getConstructor(r2)     // Catch:{ Exception -> 0x0144 }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0144 }
            java.lang.Number r8 = (java.lang.Number) r8     // Catch:{ Exception -> 0x0144 }
            long r5 = r8.longValue()     // Catch:{ Exception -> 0x0144 }
            java.lang.Long r8 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x0144 }
            r2[r4] = r8     // Catch:{ Exception -> 0x0144 }
            java.lang.Object r8 = r9.newInstance(r2)     // Catch:{ Exception -> 0x0144 }
            return r8
        L_0x00d4:
            boolean r2 = r8 instanceof java.lang.String     // Catch:{ Exception -> 0x0144 }
            if (r2 == 0) goto L_0x00f6
            java.lang.Class<java.lang.Class> r2 = java.lang.Class.class
            if (r9 != r2) goto L_0x00e3
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x0144 }
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ Exception -> 0x0144 }
            return r8
        L_0x00e3:
            java.lang.Class[] r2 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0144 }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r2[r4] = r5     // Catch:{ Exception -> 0x0144 }
            java.lang.reflect.Constructor r9 = r9.getConstructor(r2)     // Catch:{ Exception -> 0x0144 }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0144 }
            r2[r4] = r8     // Catch:{ Exception -> 0x0144 }
            java.lang.Object r8 = r9.newInstance(r2)     // Catch:{ Exception -> 0x0144 }
            return r8
        L_0x00f6:
            boolean r2 = r8 instanceof java.util.Map     // Catch:{ Exception -> 0x0144 }
            if (r2 == 0) goto L_0x0131
            java.util.Map r8 = (java.util.Map) r8     // Catch:{ Exception -> 0x0144 }
            java.lang.String r2 = "class"
            java.lang.Object r2 = r8.get(r2)     // Catch:{ Exception -> 0x0144 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0144 }
            if (r2 == 0) goto L_0x010a
            java.lang.Class r9 = java.lang.Class.forName(r2)     // Catch:{ Exception -> 0x0144 }
        L_0x010a:
            java.lang.Object r2 = r9.newInstance()     // Catch:{ Exception -> 0x0144 }
            java.util.Set r3 = r8.keySet()     // Catch:{ Exception -> 0x0144 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x0144 }
        L_0x0116:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x0144 }
            if (r4 != 0) goto L_0x011d
            return r2
        L_0x011d:
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x0144 }
            java.lang.Class r5 = org.xidea.p087el.impl.ReflectUtil.getPropertyType(r9, r4)     // Catch:{ Exception -> 0x0144 }
            java.lang.Object r6 = r8.get(r4)     // Catch:{ Exception -> 0x0144 }
            java.lang.Object r5 = r7.toValue(r6, r5)     // Catch:{ Exception -> 0x0144 }
            org.xidea.p087el.impl.ReflectUtil.setValue(r2, r4, r5)     // Catch:{ Exception -> 0x0144 }
            goto L_0x0116
        L_0x0131:
            org.apache.commons.logging.Log r8 = log     // Catch:{ Exception -> 0x0144 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0144 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0144 }
            r2.append(r9)     // Catch:{ Exception -> 0x0144 }
            java.lang.String r9 = r2.toString()     // Catch:{ Exception -> 0x0144 }
            r8.warn(r9)     // Catch:{ Exception -> 0x0144 }
            return r1
        L_0x0143:
            return r8
        L_0x0144:
            r8 = move-exception
            org.apache.commons.logging.Log r9 = log
            r9.warn(r0, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xidea.p087el.json.JSONDecoder.toValue(java.lang.Object, java.lang.Class):java.lang.Object");
    }
}
