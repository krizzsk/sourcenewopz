package com.didichuxing.security.quickjs;

import com.didichuxing.security.quickjs.TypeAdapter;
import java.io.Closeable;
import org.apache.commons.p071io.IOUtils;

public class JSContext implements TypeAdapter.Context, Closeable {
    private static final int EVAL_FLAG_MASK = 24;
    public static final int EVAL_FLAG_STRICT = 8;
    public static final int EVAL_FLAG_STRIP = 16;
    public static final int EVAL_TYPE_GLOBAL = 0;
    public static final int EVAL_TYPE_MODULE = 1;
    static final int TYPE_BOOLEAN = 1;
    static final int TYPE_EXCEPTION = 6;
    static final int TYPE_FLOAT64 = 7;
    static final int TYPE_INT = 0;
    static final int TYPE_NULL = 2;
    static final int TYPE_OBJECT = -1;
    static final int TYPE_STRING = -7;
    static final int TYPE_SYMBOL = -8;
    static final int TYPE_UNDEFINED = 3;
    private final NativeCleaner<JSValue> cleaner = new JSValueCleaner();
    final JSRuntime jsRuntime;
    long pointer;
    final QuickJS quickJS;

    JSContext(long j, QuickJS quickJS2, JSRuntime jSRuntime) {
        this.pointer = j;
        this.quickJS = quickJS2;
        this.jsRuntime = jSRuntime;
    }

    /* access modifiers changed from: package-private */
    public long checkClosed() {
        if (this.pointer != 0) {
            this.cleaner.clean();
            return this.pointer;
        }
        throw new IllegalStateException("The JSContext is closed");
    }

    public void evaluate(String str, String str2) {
        evaluateInternal(str, str2, 0, 0, (TypeAdapter) null);
    }

    public void evaluate(String str, String str2, int i, int i2) {
        evaluateInternal(str, str2, i, i2, (TypeAdapter) null);
    }

    public <T> T evaluate(String str, String str2, Class<T> cls) {
        return evaluateInternal(str, str2, 0, 0, this.quickJS.getAdapter(cls));
    }

    public <T> T evaluate(String str, String str2, TypeAdapter<T> typeAdapter) {
        return evaluateInternal(str, str2, 0, 0, typeAdapter);
    }

    public <T> T evaluate(String str, String str2, int i, int i2, Class<T> cls) {
        return evaluateInternal(str, str2, i, i2, this.quickJS.getAdapter(cls));
    }

    public <T> T evaluate(String str, String str2, int i, int i2, TypeAdapter<T> typeAdapter) {
        return evaluateInternal(str, str2, i, i2, typeAdapter);
    }

    /* JADX INFO: finally extract failed */
    private <T> T evaluateInternal(String str, String str2, int i, int i2, TypeAdapter<T> typeAdapter) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("Invalid type: " + i);
        } else if ((i2 & -25) == 0) {
            synchronized (this.jsRuntime) {
                checkClosed();
                long evaluate = QuickJS.evaluate(this.pointer, str, str2, i | i2);
                if (typeAdapter != null) {
                    T fromJSValue = typeAdapter.fromJSValue(this.quickJS, this, wrapAsJSValue(evaluate));
                    return fromJSValue;
                }
                try {
                    if (QuickJS.getValueTag(evaluate) != 6) {
                        QuickJS.destroyValue(this.pointer, evaluate);
                        return null;
                    }
                    throw new JSEvaluationException(QuickJS.getException(this.pointer));
                } catch (Throwable th) {
                    QuickJS.destroyValue(this.pointer, evaluate);
                    throw th;
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid flags: " + i2);
        }
    }

    public boolean executePendingJob() {
        boolean z;
        synchronized (this.jsRuntime) {
            checkClosed();
            int executePendingJob = QuickJS.executePendingJob(this.pointer);
            if (executePendingJob >= 0) {
                z = executePendingJob != 0;
            } else {
                throw new JSEvaluationException(QuickJS.getException(this.pointer));
            }
        }
        return z;
    }

    public JSObject getGlobalObject() {
        JSObject jSObject;
        synchronized (this.jsRuntime) {
            checkClosed();
            jSObject = (JSObject) wrapAsJSValue(QuickJS.getGlobalObject(this.pointer)).cast(JSObject.class);
        }
        return jSObject;
    }

    public JSUndefined createJSUndefined() {
        JSUndefined jSUndefined;
        synchronized (this.jsRuntime) {
            checkClosed();
            jSUndefined = (JSUndefined) wrapAsJSValue(QuickJS.createValueUndefined(this.pointer)).cast(JSUndefined.class);
        }
        return jSUndefined;
    }

    public JSNull createJSNull() {
        JSNull jSNull;
        synchronized (this.jsRuntime) {
            checkClosed();
            jSNull = (JSNull) wrapAsJSValue(QuickJS.createValueNull(this.pointer)).cast(JSNull.class);
        }
        return jSNull;
    }

    public JSBoolean createJSBoolean(boolean z) {
        JSBoolean jSBoolean;
        synchronized (this.jsRuntime) {
            checkClosed();
            jSBoolean = (JSBoolean) wrapAsJSValue(QuickJS.createValueBoolean(this.pointer, z)).cast(JSBoolean.class);
        }
        return jSBoolean;
    }

    public JSNumber createJSNumber(int i) {
        JSNumber jSNumber;
        synchronized (this.jsRuntime) {
            checkClosed();
            jSNumber = (JSNumber) wrapAsJSValue(QuickJS.createValueInt(this.pointer, i)).cast(JSNumber.class);
        }
        return jSNumber;
    }

    public JSNumber createJSNumber(double d) {
        JSNumber jSNumber;
        synchronized (this.jsRuntime) {
            checkClosed();
            jSNumber = (JSNumber) wrapAsJSValue(QuickJS.createValueFloat64(this.pointer, d)).cast(JSNumber.class);
        }
        return jSNumber;
    }

    public JSString createJSString(String str) {
        JSString jSString;
        synchronized (this.jsRuntime) {
            checkClosed();
            jSString = (JSString) wrapAsJSValue(QuickJS.createValueString(this.pointer, str)).cast(JSString.class);
        }
        return jSString;
    }

    public JSObject createJSObject() {
        JSObject jSObject;
        synchronized (this.jsRuntime) {
            checkClosed();
            jSObject = (JSObject) wrapAsJSValue(QuickJS.createValueObject(this.pointer)).cast(JSObject.class);
        }
        return jSObject;
    }

    public JSObject createJSObject(Object obj) {
        JSObject jSObject;
        synchronized (this.jsRuntime) {
            checkClosed();
            jSObject = (JSObject) wrapAsJSValue(QuickJS.createValueJavaObject(this.pointer, obj)).cast(JSObject.class);
        }
        return jSObject;
    }

    public JSArray createJSArray() {
        JSArray jSArray;
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArray = (JSArray) wrapAsJSValue(QuickJS.createValueArray(this.pointer)).cast(JSArray.class);
        }
        return jSArray;
    }

    private void checkArrayBounds(int i, int i2, int i3) {
        if (i2 < 0 || i3 <= 0 || i2 + i3 > i) {
            throw new IndexOutOfBoundsException("start = " + i2 + ", length = " + i3 + ", but array.length = " + i);
        }
    }

    public JSArrayBuffer createJSArrayBuffer(boolean[] zArr) {
        return createJSArrayBuffer(zArr, 0, zArr.length);
    }

    public JSArrayBuffer createJSArrayBuffer(boolean[] zArr, int i, int i2) {
        JSArrayBuffer jSArrayBuffer;
        checkArrayBounds(zArr.length, i, i2);
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArrayBuffer = (JSArrayBuffer) wrapAsJSValue(QuickJS.createValueArrayBufferZ(this.pointer, zArr, i, i2)).cast(JSArrayBuffer.class);
        }
        return jSArrayBuffer;
    }

    public JSArrayBuffer createJSArrayBuffer(byte[] bArr) {
        return createJSArrayBuffer(bArr, 0, bArr.length);
    }

    public JSArrayBuffer createJSArrayBuffer(byte[] bArr, int i, int i2) {
        JSArrayBuffer jSArrayBuffer;
        checkArrayBounds(bArr.length, i, i2);
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArrayBuffer = (JSArrayBuffer) wrapAsJSValue(QuickJS.createValueArrayBufferB(this.pointer, bArr, i, i2)).cast(JSArrayBuffer.class);
        }
        return jSArrayBuffer;
    }

    public JSArrayBuffer createJSArrayBuffer(char[] cArr) {
        return createJSArrayBuffer(cArr, 0, cArr.length);
    }

    public JSArrayBuffer createJSArrayBuffer(char[] cArr, int i, int i2) {
        JSArrayBuffer jSArrayBuffer;
        checkArrayBounds(cArr.length, i, i2);
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArrayBuffer = (JSArrayBuffer) wrapAsJSValue(QuickJS.createValueArrayBufferC(this.pointer, cArr, i, i2)).cast(JSArrayBuffer.class);
        }
        return jSArrayBuffer;
    }

    public JSArrayBuffer createJSArrayBuffer(short[] sArr) {
        return createJSArrayBuffer(sArr, 0, sArr.length);
    }

    public JSArrayBuffer createJSArrayBuffer(short[] sArr, int i, int i2) {
        JSArrayBuffer jSArrayBuffer;
        checkArrayBounds(sArr.length, i, i2);
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArrayBuffer = (JSArrayBuffer) wrapAsJSValue(QuickJS.createValueArrayBufferS(this.pointer, sArr, i, i2)).cast(JSArrayBuffer.class);
        }
        return jSArrayBuffer;
    }

    public JSArrayBuffer createJSArrayBuffer(int[] iArr) {
        return createJSArrayBuffer(iArr, 0, iArr.length);
    }

    public JSArrayBuffer createJSArrayBuffer(int[] iArr, int i, int i2) {
        JSArrayBuffer jSArrayBuffer;
        checkArrayBounds(iArr.length, i, i2);
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArrayBuffer = (JSArrayBuffer) wrapAsJSValue(QuickJS.createValueArrayBufferI(this.pointer, iArr, i, i2)).cast(JSArrayBuffer.class);
        }
        return jSArrayBuffer;
    }

    public JSArrayBuffer createJSArrayBuffer(long[] jArr) {
        return createJSArrayBuffer(jArr, 0, jArr.length);
    }

    public JSArrayBuffer createJSArrayBuffer(long[] jArr, int i, int i2) {
        JSArrayBuffer jSArrayBuffer;
        checkArrayBounds(jArr.length, i, i2);
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArrayBuffer = (JSArrayBuffer) wrapAsJSValue(QuickJS.createValueArrayBufferJ(this.pointer, jArr, i, i2)).cast(JSArrayBuffer.class);
        }
        return jSArrayBuffer;
    }

    public JSArrayBuffer createJSArrayBuffer(float[] fArr) {
        return createJSArrayBuffer(fArr, 0, fArr.length);
    }

    public JSArrayBuffer createJSArrayBuffer(float[] fArr, int i, int i2) {
        JSArrayBuffer jSArrayBuffer;
        checkArrayBounds(fArr.length, i, i2);
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArrayBuffer = (JSArrayBuffer) wrapAsJSValue(QuickJS.createValueArrayBufferF(this.pointer, fArr, i, i2)).cast(JSArrayBuffer.class);
        }
        return jSArrayBuffer;
    }

    public JSArrayBuffer createJSArrayBuffer(double[] dArr) {
        return createJSArrayBuffer(dArr, 0, dArr.length);
    }

    public JSArrayBuffer createJSArrayBuffer(double[] dArr, int i, int i2) {
        JSArrayBuffer jSArrayBuffer;
        checkArrayBounds(dArr.length, i, i2);
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArrayBuffer = (JSArrayBuffer) wrapAsJSValue(QuickJS.createValueArrayBufferD(this.pointer, dArr, i, i2)).cast(JSArrayBuffer.class);
        }
        return jSArrayBuffer;
    }

    public JSFunction createJSFunction(Object obj, Method method) {
        JSFunction jSFunction;
        if (obj == null) {
            throw new NullPointerException("instance == null");
        } else if (method != null) {
            synchronized (this.jsRuntime) {
                checkClosed();
                jSFunction = (JSFunction) wrapAsJSValue(QuickJS.createValueFunction(this.pointer, this, obj, method.name, method.getSignature(), method.returnType, method.parameterTypes, false)).cast(JSFunction.class);
            }
            return jSFunction;
        } else {
            throw new NullPointerException("method == null");
        }
    }

    public JSFunction createJSFunction(JSFunctionCallback jSFunctionCallback) {
        JSFunction jSFunction;
        if (jSFunctionCallback != null) {
            synchronized (this.jsRuntime) {
                checkClosed();
                JSFunctionCallback jSFunctionCallback2 = jSFunctionCallback;
                jSFunction = (JSFunction) wrapAsJSValue(QuickJS.createValueFunction(this.pointer, this, jSFunctionCallback2, "invoke", "(Lcom/didichuxing/security/quickjs/JSContext;[Lcom/didichuxing/security/quickjs/JSValue;)Lcom/didichuxing/security/quickjs/JSValue;", JSValue.class, new Class[]{JSContext.class, JSValue[].class}, true)).cast(JSFunction.class);
            }
            return jSFunction;
        }
        throw new NullPointerException("callback == null");
    }

    public JSFunction createJSFunctionS(Class cls, Method method) {
        JSFunction jSFunction;
        if (cls == null) {
            throw new NullPointerException("clazz == null");
        } else if (method != null) {
            String name = cls.getName();
            StringBuilder sb = new StringBuilder(name.length());
            for (int i = 0; i < name.length(); i++) {
                char charAt = name.charAt(i);
                if (charAt == '.') {
                    charAt = IOUtils.DIR_SEPARATOR_UNIX;
                }
                sb.append(charAt);
            }
            String sb2 = sb.toString();
            synchronized (this.jsRuntime) {
                checkClosed();
                jSFunction = (JSFunction) wrapAsJSValue(QuickJS.createValueFunctionS(this.pointer, this, sb2, method.name, method.getSignature(), method.returnType, method.parameterTypes)).cast(JSFunction.class);
            }
            return jSFunction;
        } else {
            throw new NullPointerException("method == null");
        }
    }

    public JSObject createJSPromise(PromiseExecutor promiseExecutor) {
        JSValue wrapAsJSValue;
        JSValue wrapAsJSValue2;
        JSValue wrapAsJSValue3;
        synchronized (this.jsRuntime) {
            checkClosed();
            long[] createValuePromise = QuickJS.createValuePromise(this.pointer);
            if (createValuePromise != null) {
                for (long valueTag : createValuePromise) {
                    if (QuickJS.getValueTag(valueTag) == 6) {
                        for (long destroyValue : createValuePromise) {
                            QuickJS.destroyValue(this.pointer, destroyValue);
                        }
                        throw new JSEvaluationException(QuickJS.getException(this.pointer));
                    }
                }
                wrapAsJSValue = wrapAsJSValue(createValuePromise[0]);
                wrapAsJSValue2 = wrapAsJSValue(createValuePromise[1]);
                wrapAsJSValue3 = wrapAsJSValue(createValuePromise[2]);
            } else {
                throw new NullPointerException("result == null");
            }
        }
        promiseExecutor.execute((JSFunction) wrapAsJSValue2.cast(JSFunction.class), (JSFunction) wrapAsJSValue3.cast(JSFunction.class));
        return (JSObject) wrapAsJSValue.cast(JSObject.class);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.didichuxing.security.quickjs.JSFloat64} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: com.didichuxing.security.quickjs.JSSymbol} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.didichuxing.security.quickjs.JSString} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.didichuxing.security.quickjs.JSObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: com.didichuxing.security.quickjs.JSArrayBuffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: com.didichuxing.security.quickjs.JSArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: com.didichuxing.security.quickjs.JSFunction} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: com.didichuxing.security.quickjs.JSInt} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: com.didichuxing.security.quickjs.JSBoolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: com.didichuxing.security.quickjs.JSNull} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: com.didichuxing.security.quickjs.JSUndefined} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: com.didichuxing.security.quickjs.JSInternal} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: com.didichuxing.security.quickjs.JSFloat64} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: com.didichuxing.security.quickjs.JSFloat64} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: com.didichuxing.security.quickjs.JSFloat64} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: com.didichuxing.security.quickjs.JSFloat64} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: com.didichuxing.security.quickjs.JSFloat64} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: com.didichuxing.security.quickjs.JSFloat64} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v29, resolved type: com.didichuxing.security.quickjs.JSFloat64} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v30, resolved type: com.didichuxing.security.quickjs.JSFloat64} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v31, resolved type: com.didichuxing.security.quickjs.JSFloat64} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v32, resolved type: com.didichuxing.security.quickjs.JSFloat64} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: com.didichuxing.security.quickjs.JSFloat64} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: com.didichuxing.security.quickjs.JSFloat64} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didichuxing.security.quickjs.JSValue wrapAsJSValue(long r8) {
        /*
            r7 = this;
            r0 = 0
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x00b7
            int r0 = com.didichuxing.security.quickjs.QuickJS.getValueTag(r8)
            r1 = -8
            if (r0 == r1) goto L_0x00ac
            r1 = -7
            if (r0 == r1) goto L_0x00a0
            r1 = -1
            if (r0 == r1) goto L_0x006a
            if (r0 == 0) goto L_0x0060
            r1 = 1
            if (r0 == r1) goto L_0x0056
            r1 = 2
            if (r0 == r1) goto L_0x0050
            r1 = 3
            if (r0 == r1) goto L_0x004a
            r1 = 6
            if (r0 == r1) goto L_0x0039
            r1 = 7
            if (r0 == r1) goto L_0x002b
            com.didichuxing.security.quickjs.JSInternal r0 = new com.didichuxing.security.quickjs.JSInternal
            r0.<init>(r8, r7)
            goto L_0x00b1
        L_0x002b:
            com.didichuxing.security.quickjs.JSFloat64 r0 = new com.didichuxing.security.quickjs.JSFloat64
            double r5 = com.didichuxing.security.quickjs.QuickJS.getValueFloat64(r8)
            r1 = r0
            r2 = r8
            r4 = r7
            r1.<init>(r2, r4, r5)
            goto L_0x00b1
        L_0x0039:
            long r0 = r7.pointer
            com.didichuxing.security.quickjs.QuickJS.destroyValue(r0, r8)
            com.didichuxing.security.quickjs.JSEvaluationException r8 = new com.didichuxing.security.quickjs.JSEvaluationException
            long r0 = r7.pointer
            com.didichuxing.security.quickjs.JSException r9 = com.didichuxing.security.quickjs.QuickJS.getException(r0)
            r8.<init>(r9)
            throw r8
        L_0x004a:
            com.didichuxing.security.quickjs.JSUndefined r0 = new com.didichuxing.security.quickjs.JSUndefined
            r0.<init>(r8, r7)
            goto L_0x00b1
        L_0x0050:
            com.didichuxing.security.quickjs.JSNull r0 = new com.didichuxing.security.quickjs.JSNull
            r0.<init>(r8, r7)
            goto L_0x00b1
        L_0x0056:
            com.didichuxing.security.quickjs.JSBoolean r0 = new com.didichuxing.security.quickjs.JSBoolean
            boolean r1 = com.didichuxing.security.quickjs.QuickJS.getValueBoolean(r8)
            r0.<init>(r8, r7, r1)
            goto L_0x00b1
        L_0x0060:
            com.didichuxing.security.quickjs.JSInt r0 = new com.didichuxing.security.quickjs.JSInt
            int r1 = com.didichuxing.security.quickjs.QuickJS.getValueInt(r8)
            r0.<init>(r8, r7, r1)
            goto L_0x00b1
        L_0x006a:
            long r0 = r7.pointer
            boolean r0 = com.didichuxing.security.quickjs.QuickJS.isValueFunction(r0, r8)
            if (r0 == 0) goto L_0x0078
            com.didichuxing.security.quickjs.JSFunction r0 = new com.didichuxing.security.quickjs.JSFunction
            r0.<init>(r8, r7)
            goto L_0x00b1
        L_0x0078:
            long r0 = r7.pointer
            boolean r0 = com.didichuxing.security.quickjs.QuickJS.isValueArray(r0, r8)
            if (r0 == 0) goto L_0x0086
            com.didichuxing.security.quickjs.JSArray r0 = new com.didichuxing.security.quickjs.JSArray
            r0.<init>(r8, r7)
            goto L_0x00b1
        L_0x0086:
            long r0 = r7.pointer
            boolean r0 = com.didichuxing.security.quickjs.QuickJS.isValueArrayBuffer(r0, r8)
            if (r0 == 0) goto L_0x0094
            com.didichuxing.security.quickjs.JSArrayBuffer r0 = new com.didichuxing.security.quickjs.JSArrayBuffer
            r0.<init>(r8, r7)
            goto L_0x00b1
        L_0x0094:
            com.didichuxing.security.quickjs.JSObject r0 = new com.didichuxing.security.quickjs.JSObject
            long r1 = r7.pointer
            java.lang.Object r1 = com.didichuxing.security.quickjs.QuickJS.getValueJavaObject(r1, r8)
            r0.<init>(r8, r7, r1)
            goto L_0x00b1
        L_0x00a0:
            com.didichuxing.security.quickjs.JSString r0 = new com.didichuxing.security.quickjs.JSString
            long r1 = r7.pointer
            java.lang.String r1 = com.didichuxing.security.quickjs.QuickJS.getValueString(r1, r8)
            r0.<init>(r8, r7, r1)
            goto L_0x00b1
        L_0x00ac:
            com.didichuxing.security.quickjs.JSSymbol r0 = new com.didichuxing.security.quickjs.JSSymbol
            r0.<init>(r8, r7)
        L_0x00b1:
            com.didichuxing.security.quickjs.NativeCleaner<com.didichuxing.security.quickjs.JSValue> r1 = r7.cleaner
            r1.register(r0, r8)
            return r0
        L_0x00b7:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Can't wrap null pointer as JSValue"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.security.quickjs.JSContext.wrapAsJSValue(long):com.didichuxing.security.quickjs.JSValue");
    }

    /* access modifiers changed from: package-private */
    public int getNotRemovedJSValueCount() {
        int size;
        synchronized (this.jsRuntime) {
            size = this.cleaner.size();
        }
        return size;
    }

    public void close() {
        synchronized (this.jsRuntime) {
            if (this.pointer != 0) {
                this.cleaner.forceClean();
                long j = this.pointer;
                this.pointer = 0;
                QuickJS.destroyContext(j);
            }
        }
    }

    private class JSValueCleaner extends NativeCleaner<JSValue> {
        private JSValueCleaner() {
        }

        public void onRemove(long j) {
            QuickJS.destroyValue(JSContext.this.pointer, j);
        }
    }
}
