package org.xidea.lite;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xidea.p087el.Expression;
import org.xidea.p087el.ExpressionFactory;
import org.xidea.p087el.ExpressionInfo;
import org.xidea.p087el.ValueStack;
import org.xidea.p087el.impl.ExpressionFactoryImpl;
import org.xidea.p087el.impl.ReflectUtil;
import org.xidea.p087el.p088fn.ECMA262Impl;

public class Template {
    public static final int BREAK_TYPE = 2;
    public static final int CAPTRUE_TYPE = 9;
    public static final int ELSE_TYPE = 6;
    public static final int EL_TYPE = 0;
    public static final String FOR_KEY = "for";
    public static final int FOR_TYPE = 5;
    private static final int FOR_TYPE_FIRST_STATUS = 517;
    private static final int FOR_TYPE_NO_STATUS = 261;
    public static final int IF_TYPE = 1;
    public static final int PLUGIN_TYPE = 7;
    public static final int VAR_TYPE = 8;
    public static final int XA_TYPE = 3;
    public static final int XT_TYPE = 4;
    private static Log log = LogFactory.getLog(Template.class);
    protected ExpressionFactory expressionFactory = new ExpressionFactoryImpl();
    private int forCount = 0;
    protected Object[] items;

    protected Template() {
    }

    public Template(List<Object> list) {
        this.items = compile(list);
    }

    public void render(Object obj, Writer writer) throws IOException {
        ValueStack valueStack;
        if (obj instanceof ValueStack) {
            valueStack = (ValueStack) obj;
        } else {
            valueStack = new Context(obj);
        }
        renderList(valueStack, this.items, writer);
    }

    /* access modifiers changed from: protected */
    public Expression createExpression(Object obj) {
        Expression create = this.expressionFactory.create(obj);
        if ((create instanceof ExpressionInfo) && ((ExpressionInfo) create).getVars().contains(FOR_KEY)) {
            this.forCount++;
        }
        return create;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008e, code lost:
        r3[1] = compile((java.util.List) r3[1]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0099, code lost:
        r3[1] = createExpression(r3[1]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a1, code lost:
        r0.add(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object[] compile(java.util.List<java.lang.Object> r8) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = r8.size()
            r2 = 1
            int r1 = r1 - r2
        L_0x000b:
            if (r1 >= 0) goto L_0x0012
            java.lang.Object[] r8 = r0.toArray()
            return r8
        L_0x0012:
            java.lang.Object r3 = r8.get(r1)
            boolean r4 = r3 instanceof java.util.List
            if (r4 == 0) goto L_0x00a5
            java.util.List r3 = (java.util.List) r3
            java.lang.Object[] r3 = r3.toArray()
            r4 = 0
            r5 = r3[r4]
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r3[r4] = r6
            r6 = 2
            switch(r5) {
                case 0: goto L_0x0099;
                case 1: goto L_0x0082;
                case 2: goto L_0x0033;
                case 3: goto L_0x0066;
                case 4: goto L_0x0099;
                case 5: goto L_0x0038;
                case 6: goto L_0x0082;
                case 7: goto L_0x0034;
                case 8: goto L_0x0099;
                case 9: goto L_0x008e;
                default: goto L_0x0033;
            }
        L_0x0033:
            goto L_0x00a1
        L_0x0034:
            r7.compilePlugin(r3, r0)
            goto L_0x00a1
        L_0x0038:
            r5 = r3[r6]
            org.xidea.el.Expression r5 = r7.createExpression(r5)
            r3[r6] = r5
            int r5 = r7.forCount
            r6 = r3[r2]
            java.util.List r6 = (java.util.List) r6
            java.lang.Object[] r6 = r7.compile(r6)
            r3[r2] = r6
            int r6 = r7.forCount
            if (r6 != r5) goto L_0x0059
            r6 = 261(0x105, float:3.66E-43)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r3[r4] = r6
            goto L_0x0063
        L_0x0059:
            if (r5 != 0) goto L_0x0063
            r6 = 517(0x205, float:7.24E-43)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r3[r4] = r6
        L_0x0063:
            r7.forCount = r5
            goto L_0x00a1
        L_0x0066:
            r4 = r3[r6]
            if (r4 == 0) goto L_0x0099
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = " "
            r4.<init>(r5)
            r5 = r3[r6]
            r4.append(r5)
            java.lang.String r5 = "=\""
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3[r6] = r4
            goto L_0x0099
        L_0x0082:
            r4 = r3[r6]
            if (r4 == 0) goto L_0x008e
            r4 = r3[r6]
            org.xidea.el.Expression r4 = r7.createExpression(r4)
            r3[r6] = r4
        L_0x008e:
            r4 = r3[r2]
            java.util.List r4 = (java.util.List) r4
            java.lang.Object[] r4 = r7.compile(r4)
            r3[r2] = r4
            goto L_0x00a1
        L_0x0099:
            r4 = r3[r2]
            org.xidea.el.Expression r4 = r7.createExpression(r4)
            r3[r2] = r4
        L_0x00a1:
            r0.add(r3)
            goto L_0x00a8
        L_0x00a5:
            r0.add(r3)
        L_0x00a8:
            int r1 = r1 + -1
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xidea.lite.Template.compile(java.util.List):java.lang.Object[]");
    }

    /* access modifiers changed from: protected */
    public void compilePlugin(Object[] objArr, List<Object> list) {
        try {
            int i = this.forCount;
            Expression createExpression = createExpression(objArr[2]);
            Class<?> cls = Class.forName((String) objArr[3]);
            Plugin plugin = (Plugin) cls.newInstance();
            ReflectUtil.setValues(plugin, (Map) createExpression.evaluate(new Object[0]));
            Object[] compile = compile((List) objArr[1]);
            if (cls == DefinePlugin.class) {
                this.forCount = i;
            }
            plugin.initialize(this, compile);
            objArr[3] = plugin;
        } catch (Exception e) {
            log.error("装载扩展失败", e);
        }
    }

    /* access modifiers changed from: protected */
    public void renderList(ValueStack valueStack, Object[] objArr, Writer writer) {
        int length = objArr.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length > 0) {
                String str = objArr[i];
                try {
                    if (str instanceof String) {
                        writer.write(str);
                    } else {
                        Object[] objArr2 = (Object[]) str;
                        int intValue = ((Integer) objArr2[0]).intValue();
                        if (intValue == 261) {
                            z = processFor(valueStack, objArr2, writer, 261);
                        } else if (intValue != 517) {
                            switch (intValue) {
                                case 0:
                                    processExpression(valueStack, objArr2, writer, false);
                                    continue;
                                case 1:
                                    z = processIf(valueStack, objArr2, writer);
                                    continue;
                                case 2:
                                    prossesBreak(objArr2);
                                    break;
                                case 3:
                                    processAttribute(valueStack, objArr2, writer);
                                    continue;
                                case 4:
                                    processExpression(valueStack, objArr2, writer, true);
                                    continue;
                                case 5:
                                    z = processFor(valueStack, objArr2, writer, 5);
                                    continue;
                                case 6:
                                    if (!z) {
                                        z = processElse(valueStack, objArr2, writer);
                                        break;
                                    } else {
                                        continue;
                                    }
                                case 7:
                                    break;
                                case 8:
                                    processVar(valueStack, objArr2);
                                    continue;
                                case 9:
                                    processCaptrue(valueStack, objArr2);
                                    continue;
                                default:
                                    continue;
                            }
                            prossesPlugin(valueStack, objArr2, writer);
                        } else {
                            z = processFor(valueStack, objArr2, writer, 517);
                        }
                    }
                } catch (Break e) {
                    int i2 = e.depth - 1;
                    e.depth = i2;
                    if (i2 > 0) {
                        throw e;
                    }
                } catch (Exception e2) {
                    if (log.isDebugEnabled()) {
                        log.debug(e2);
                    }
                }
                length = i;
            } else {
                return;
            }
        }
    }

    private void prossesPlugin(ValueStack valueStack, Object[] objArr, Writer writer) throws Exception {
        objArr[3].execute(valueStack, writer);
    }

    /* access modifiers changed from: protected */
    public void processExpression(ValueStack valueStack, Object[] objArr, Writer writer, boolean z) throws IOException {
        Object evaluate = objArr[1].evaluate((Object) valueStack);
        if (!z || evaluate == null) {
            writer.write(ECMA262Impl.ToString(evaluate));
        } else {
            printXMLText(ECMA262Impl.ToString(evaluate), writer);
        }
    }

    /* access modifiers changed from: protected */
    public boolean processIf(ValueStack valueStack, Object[] objArr, Writer writer) {
        if (!toBoolean(objArr[2].evaluate((Object) valueStack))) {
            return false;
        }
        renderList(valueStack, objArr[1], writer);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean processElse(ValueStack valueStack, Object[] objArr, Writer writer) {
        if (objArr[2] != null && !toBoolean(objArr[2].evaluate((Object) valueStack))) {
            return false;
        }
        renderList(valueStack, objArr[1], writer);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v12, resolved type: boolean} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean processFor(org.xidea.p087el.ValueStack r20, java.lang.Object[] r21, java.io.Writer r22, int r23) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            r0 = r22
            r3 = r23
            r4 = 1
            r5 = r21[r4]
            java.lang.Object[] r5 = (java.lang.Object[]) r5
            r6 = 3
            r6 = r21[r6]
            java.lang.String r6 = (java.lang.String) r6
            r7 = 5
            java.lang.String r8 = "for"
            if (r3 != r7) goto L_0x001e
            java.lang.Object r9 = r2.get(r8)
            org.xidea.lite.ForStatus r9 = (org.xidea.lite.ForStatus) r9
            goto L_0x001f
        L_0x001e:
            r9 = 0
        L_0x001f:
            r10 = 2
            r10 = r21[r10]
            org.xidea.el.Expression r10 = (org.xidea.p087el.Expression) r10
            java.lang.Object r10 = r10.evaluate((java.lang.Object) r2)
            boolean r11 = r10 instanceof java.util.Map     // Catch:{ all -> 0x00e7 }
            if (r11 == 0) goto L_0x0032
            java.util.Map r10 = (java.util.Map) r10     // Catch:{ all -> 0x00e7 }
            java.util.Set r10 = r10.keySet()     // Catch:{ all -> 0x00e7 }
        L_0x0032:
            boolean r11 = r10 instanceof java.util.Collection     // Catch:{ all -> 0x00e7 }
            r12 = 261(0x105, float:3.66E-43)
            r13 = 0
            if (r11 == 0) goto L_0x0082
            java.util.Collection r10 = (java.util.Collection) r10     // Catch:{ all -> 0x00e7 }
            int r11 = r10.size()     // Catch:{ all -> 0x00e7 }
            if (r11 <= 0) goto L_0x0042
            r13 = 1
        L_0x0042:
            if (r3 != r12) goto L_0x005b
            java.util.Iterator r4 = r10.iterator()     // Catch:{ all -> 0x00e7 }
        L_0x0048:
            boolean r10 = r4.hasNext()     // Catch:{ all -> 0x00e7 }
            if (r10 != 0) goto L_0x0050
            goto L_0x00d4
        L_0x0050:
            java.lang.Object r10 = r4.next()     // Catch:{ all -> 0x00e7 }
            r2.put(r6, r10)     // Catch:{ all -> 0x00e7 }
            r1.renderList(r2, r5, r0)     // Catch:{ all -> 0x00e7 }
            goto L_0x0048
        L_0x005b:
            org.xidea.lite.ForStatus r11 = new org.xidea.lite.ForStatus     // Catch:{ all -> 0x00e7 }
            int r12 = r10.size()     // Catch:{ all -> 0x00e7 }
            r11.<init>(r12)     // Catch:{ all -> 0x00e7 }
            r2.put(r8, r11)     // Catch:{ all -> 0x00e7 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x00e7 }
        L_0x006b:
            boolean r12 = r10.hasNext()     // Catch:{ all -> 0x00e7 }
            if (r12 != 0) goto L_0x0072
            goto L_0x00d4
        L_0x0072:
            java.lang.Object r12 = r10.next()     // Catch:{ all -> 0x00e7 }
            int r14 = r11.index     // Catch:{ all -> 0x00e7 }
            int r14 = r14 + r4
            r11.index = r14     // Catch:{ all -> 0x00e7 }
            r2.put(r6, r12)     // Catch:{ all -> 0x00e7 }
            r1.renderList(r2, r5, r0)     // Catch:{ all -> 0x00e7 }
            goto L_0x006b
        L_0x0082:
            boolean r11 = r10 instanceof java.lang.Number     // Catch:{ all -> 0x00e7 }
            if (r11 == 0) goto L_0x00a4
            java.lang.Number r10 = (java.lang.Number) r10     // Catch:{ all -> 0x00e7 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x00e7 }
            int r10 = java.lang.Math.max(r10, r13)     // Catch:{ all -> 0x00e7 }
            java.lang.Object[] r11 = new java.lang.Object[r10]     // Catch:{ all -> 0x00e7 }
            r14 = 0
        L_0x0093:
            if (r14 < r10) goto L_0x0096
            goto L_0x00ad
        L_0x0096:
            r15 = r11
            java.lang.Object[] r15 = (java.lang.Object[]) r15     // Catch:{ all -> 0x00e7 }
            int r16 = r14 + 1
            java.lang.Integer r17 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x00e7 }
            r15[r14] = r17     // Catch:{ all -> 0x00e7 }
            r14 = r16
            goto L_0x0093
        L_0x00a4:
            int r11 = java.lang.reflect.Array.getLength(r10)     // Catch:{ all -> 0x00e7 }
            r18 = r11
            r11 = r10
            r10 = r18
        L_0x00ad:
            if (r10 <= 0) goto L_0x00b1
            r14 = 1
            goto L_0x00b2
        L_0x00b1:
            r14 = 0
        L_0x00b2:
            if (r3 != r12) goto L_0x00c4
        L_0x00b4:
            if (r13 < r10) goto L_0x00b7
            goto L_0x00d3
        L_0x00b7:
            java.lang.Object r4 = java.lang.reflect.Array.get(r11, r13)     // Catch:{ all -> 0x00e7 }
            r2.put(r6, r4)     // Catch:{ all -> 0x00e7 }
            r1.renderList(r2, r5, r0)     // Catch:{ all -> 0x00e7 }
            int r13 = r13 + 1
            goto L_0x00b4
        L_0x00c4:
            org.xidea.lite.ForStatus r12 = new org.xidea.lite.ForStatus     // Catch:{ all -> 0x00e7 }
            r12.<init>(r10)     // Catch:{ all -> 0x00e7 }
            r2.put(r8, r12)     // Catch:{ all -> 0x00e7 }
        L_0x00cc:
            int r13 = r12.index     // Catch:{ all -> 0x00e7 }
            int r13 = r13 + r4
            r12.index = r13     // Catch:{ all -> 0x00e7 }
            if (r13 < r10) goto L_0x00da
        L_0x00d3:
            r13 = r14
        L_0x00d4:
            if (r3 != r7) goto L_0x00d9
            r2.put(r8, r9)
        L_0x00d9:
            return r13
        L_0x00da:
            int r13 = r12.index     // Catch:{ all -> 0x00e7 }
            java.lang.Object r13 = java.lang.reflect.Array.get(r11, r13)     // Catch:{ all -> 0x00e7 }
            r2.put(r6, r13)     // Catch:{ all -> 0x00e7 }
            r1.renderList(r2, r5, r0)     // Catch:{ all -> 0x00e7 }
            goto L_0x00cc
        L_0x00e7:
            r0 = move-exception
            if (r3 != r7) goto L_0x00ed
            r2.put(r8, r9)
        L_0x00ed:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xidea.lite.Template.processFor(org.xidea.el.ValueStack, java.lang.Object[], java.io.Writer, int):boolean");
    }

    /* access modifiers changed from: protected */
    public void processVar(ValueStack valueStack, Object[] objArr) {
        valueStack.put(objArr[2], objArr[1].evaluate((Object) valueStack));
    }

    /* access modifiers changed from: protected */
    public void processCaptrue(ValueStack valueStack, Object[] objArr) {
        StringWriter stringWriter = new StringWriter();
        renderList(valueStack, objArr[1], stringWriter);
        valueStack.put(objArr[2], stringWriter.toString());
    }

    /* access modifiers changed from: protected */
    public void processAttribute(ValueStack valueStack, Object[] objArr, Writer writer) throws IOException {
        Object evaluate = objArr[1].evaluate((Object) valueStack);
        if (objArr[2] == null) {
            printXMLAttribute(ECMA262Impl.ToString(evaluate), writer);
        } else if (evaluate != null) {
            writer.write(objArr[2]);
            printXMLAttribute(ECMA262Impl.ToString(evaluate), writer);
            writer.write(34);
        }
    }

    /* access modifiers changed from: protected */
    public void prossesBreak(Object[] objArr) {
        throw new Break(objArr[1].intValue());
    }

    /* access modifiers changed from: protected */
    public void printXMLAttribute(String str, Writer writer) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\"') {
                writer.write("&#34;");
            } else if (charAt == '&') {
                writer.write("&amp;");
            } else if (charAt != '<') {
                writer.write(charAt);
            } else {
                writer.write("&lt;");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void printXMLText(String str, Writer writer) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '&') {
                writer.write("&amp;");
            } else if (charAt != '<') {
                writer.write(charAt);
            } else {
                writer.write("&lt;");
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean toBoolean(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj instanceof String) {
            if (((String) obj).length() > 0) {
                return true;
            }
            return false;
        } else if (!(obj instanceof Number) || ((Number) obj).floatValue() != 0.0f) {
            return true;
        } else {
            return false;
        }
    }
}
