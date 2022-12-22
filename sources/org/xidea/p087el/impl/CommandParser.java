package org.xidea.p087el.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xidea.p087el.ExpressionFactory;
import org.xidea.p087el.ExpressionSyntaxException;
import org.xidea.p087el.Reference;
import org.xidea.p087el.ReferenceExpression;

/* renamed from: org.xidea.el.impl.CommandParser */
public class CommandParser {
    private static final ExpressionFactory factory = ExpressionFactoryImpl.getInstance();
    private static final Log log = LogFactory.getLog(CommandParser.class);
    public Map<Class<?>, Convertor<? extends Object>> convertorMap = Convertor.DEFAULT_MAP;
    private Map<String, String[]> params;

    public CommandParser(String[] strArr) {
        if (strArr != null) {
            this.params = parseArgs(strArr);
        }
    }

    public Map<String, String[]> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String[]> map) {
        this.params = map;
    }

    public void addConvertor(Class<? extends Object> cls, Convertor<? extends Object> convertor) {
        if (!(this.convertorMap instanceof HashMap)) {
            this.convertorMap = new HashMap(this.convertorMap);
        }
        this.convertorMap.put(cls, convertor);
    }

    public static void setup(Object obj, String[] strArr) {
        new CommandParser(strArr).setup(obj);
    }

    public void setup(Object obj) {
        setup(obj, this.params);
    }

    public void setup(Object obj, Map<String, String[]> map) {
        for (String next : map.keySet()) {
            if (next != null && next.length() > 0 && Character.isJavaIdentifierStart(next.charAt(0))) {
                try {
                    Reference prepare = getReference(next).prepare(obj);
                    if (prepare != null && prepare.getType() != null) {
                        prepare.setValue(getValue(map.get(next), prepare.getType(), obj, next));
                    } else if (obj != null) {
                        Log log2 = log;
                        log2.warn("找不到相关属性：" + next);
                        if (log.isInfoEnabled()) {
                            Set<String> keySet = ReflectUtil.map(obj).keySet();
                            Log log3 = log;
                            log3.info("当前对象可能属性有：" + keySet);
                        }
                    }
                } catch (ExpressionSyntaxException e) {
                    Log log4 = log;
                    log4.debug("无效属性：" + next, e);
                }
            }
        }
    }

    private ReferenceExpression getReference(String str) {
        return (ReferenceExpression) factory.create(str);
    }

    /* access modifiers changed from: protected */
    public Map<String, String[]> parseArgs(String[] strArr) {
        HashMap hashMap = new HashMap();
        String str = null;
        for (String str2 : strArr) {
            if (str2.startsWith("-")) {
                str = str2.substring(1);
            } else {
                List list = (List) hashMap.get(str);
                if (list == null) {
                    list = new ArrayList();
                    hashMap.put(str, list);
                }
                list.add(str2);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            List list2 = (List) entry.getValue();
            entry.setValue(list2.toArray(new String[list2.size()]));
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004f A[LOOP:1: B:18:0x004b->B:21:0x004f, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T getValue(java.lang.String[] r4, java.lang.Class<? extends T> r5, java.lang.Object r6, java.lang.String r7) {
        /*
            r3 = this;
            boolean r0 = r5.isArray()
            r1 = 0
            if (r0 == 0) goto L_0x0020
            java.lang.Class r0 = r5.getComponentType()
            int r5 = r4.length
            java.lang.Object r2 = java.lang.reflect.Array.newInstance(r0, r5)
        L_0x0010:
            int r5 = r4.length
            if (r1 < r5) goto L_0x0014
            return r2
        L_0x0014:
            r5 = r4[r1]
            java.lang.Object r5 = r3.getValue((java.lang.String) r5, r0, (java.lang.Object) r6, (java.lang.String) r7)
            java.lang.reflect.Array.set(r2, r1, r5)
            int r1 = r1 + 1
            goto L_0x0010
        L_0x0020:
            java.lang.Class<java.util.Collection> r0 = java.util.Collection.class
            boolean r0 = r0.isAssignableFrom(r5)
            if (r0 == 0) goto L_0x0075
            java.lang.Class<java.util.ArrayList> r6 = java.util.ArrayList.class
            boolean r6 = r5.isAssignableFrom(r6)
            if (r6 == 0) goto L_0x0037
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
        L_0x0035:
            r6 = r5
            goto L_0x004b
        L_0x0037:
            java.lang.Class<java.util.HashSet> r6 = java.util.HashSet.class
            boolean r6 = r5.isAssignableFrom(r6)
            if (r6 == 0) goto L_0x0045
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            goto L_0x0035
        L_0x0045:
            java.lang.Object r6 = r5.newInstance()     // Catch:{ Exception -> 0x0057 }
            java.util.Collection r6 = (java.util.Collection) r6     // Catch:{ Exception -> 0x0057 }
        L_0x004b:
            int r5 = r4.length
            if (r1 < r5) goto L_0x004f
            return r6
        L_0x004f:
            r5 = r4[r1]
            r6.add(r5)
            int r1 = r1 + 1
            goto L_0x004b
        L_0x0057:
            r4 = move-exception
            org.apache.commons.logging.Log r6 = log
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "创建对象失败"
            r7.<init>(r0)
            java.lang.String r5 = r5.getName()
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.error(r5, r4)
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            r5.<init>(r4)
            throw r5
        L_0x0075:
            int r0 = r4.length
            int r0 = r0 + -1
            r4 = r4[r0]
            java.lang.Object r4 = r3.getValue((java.lang.String) r4, r5, (java.lang.Object) r6, (java.lang.String) r7)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xidea.p087el.impl.CommandParser.getValue(java.lang.String[], java.lang.Class, java.lang.Object, java.lang.String):java.lang.Object");
    }

    public <T> T getValue(String str, Class<? extends T> cls, Object obj, String str2) {
        Convertor convertor = this.convertorMap.get(cls);
        if (convertor != null) {
            return convertor.getValue(str, cls, obj, str2);
        }
        Log log2 = log;
        log2.error("unsuport type:" + cls + ":" + str2);
        return null;
    }

    public String toString() {
        if (this.params == null) {
            return "*EMPTY*";
        }
        StringBuilder sb = new StringBuilder();
        for (String next : this.params.keySet()) {
            sb.append(next);
            sb.append("=>\n");
            String[] strArr = this.params.get(next);
            if (this.params != null) {
                for (String append : strArr) {
                    sb.append("\t");
                    sb.append(append);
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }
}
