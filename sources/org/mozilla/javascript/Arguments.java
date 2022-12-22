package org.mozilla.javascript;

final class Arguments extends IdScriptableObject {
    private static final String FTAG = "Arguments";
    private static final int Id_callee = 1;
    private static final int Id_caller = 3;
    private static final int Id_length = 2;
    private static final int MAX_INSTANCE_ID = 3;
    static final long serialVersionUID = 4275508002492040609L;
    private NativeCall activation;
    private Object[] args;
    private int calleeAttr = 2;
    private Object calleeObj;
    private int callerAttr = 2;
    private Object callerObj;
    private int lengthAttr = 2;
    private Object lengthObj;

    public String getClassName() {
        return FTAG;
    }

    /* access modifiers changed from: protected */
    public String getInstanceIdName(int i) {
        if (i == 1) {
            return "callee";
        }
        if (i == 2) {
            return "length";
        }
        if (i != 3) {
            return null;
        }
        return "caller";
    }

    /* access modifiers changed from: protected */
    public int getMaxInstanceId() {
        return 3;
    }

    public Arguments(NativeCall nativeCall) {
        this.activation = nativeCall;
        Scriptable parentScope = nativeCall.getParentScope();
        setParentScope(parentScope);
        setPrototype(ScriptableObject.getObjectPrototype(parentScope));
        Object[] objArr = nativeCall.originalArgs;
        this.args = objArr;
        this.lengthObj = Integer.valueOf(objArr.length);
        NativeFunction nativeFunction = nativeCall.function;
        this.calleeObj = nativeFunction;
        int languageVersion = nativeFunction.getLanguageVersion();
        if (languageVersion > 130 || languageVersion == 0) {
            this.callerObj = NOT_FOUND;
        } else {
            this.callerObj = null;
        }
    }

    private Object arg(int i) {
        if (i >= 0) {
            Object[] objArr = this.args;
            if (objArr.length > i) {
                return objArr[i];
            }
        }
        return NOT_FOUND;
    }

    private void putIntoActivation(int i, Object obj) {
        String paramOrVarName = this.activation.function.getParamOrVarName(i);
        NativeCall nativeCall = this.activation;
        nativeCall.put(paramOrVarName, nativeCall, obj);
    }

    private Object getFromActivation(int i) {
        String paramOrVarName = this.activation.function.getParamOrVarName(i);
        NativeCall nativeCall = this.activation;
        return nativeCall.get(paramOrVarName, nativeCall);
    }

    private void replaceArg(int i, Object obj) {
        if (sharedWithActivation(i)) {
            putIntoActivation(i, obj);
        }
        synchronized (this) {
            if (this.args == this.activation.originalArgs) {
                this.args = (Object[]) this.args.clone();
            }
            this.args[i] = obj;
        }
    }

    private void removeArg(int i) {
        synchronized (this) {
            if (this.args[i] != NOT_FOUND) {
                if (this.args == this.activation.originalArgs) {
                    this.args = (Object[]) this.args.clone();
                }
                this.args[i] = NOT_FOUND;
            }
        }
    }

    public boolean has(int i, Scriptable scriptable) {
        if (arg(i) != NOT_FOUND) {
            return true;
        }
        return super.has(i, scriptable);
    }

    public Object get(int i, Scriptable scriptable) {
        Object arg = arg(i);
        if (arg == NOT_FOUND) {
            return super.get(i, scriptable);
        }
        return sharedWithActivation(i) ? getFromActivation(i) : arg;
    }

    private boolean sharedWithActivation(int i) {
        NativeFunction nativeFunction = this.activation.function;
        int paramCount = nativeFunction.getParamCount();
        if (i >= paramCount) {
            return false;
        }
        if (i < paramCount - 1) {
            String paramOrVarName = nativeFunction.getParamOrVarName(i);
            for (int i2 = i + 1; i2 < paramCount; i2++) {
                if (paramOrVarName.equals(nativeFunction.getParamOrVarName(i2))) {
                    return false;
                }
            }
        }
        return true;
    }

    public void put(int i, Scriptable scriptable, Object obj) {
        if (arg(i) == NOT_FOUND) {
            super.put(i, scriptable, obj);
        } else {
            replaceArg(i, obj);
        }
    }

    public void delete(int i) {
        if (i >= 0 && i < this.args.length) {
            removeArg(i);
        }
        super.delete(i);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int findInstanceIdInfo(java.lang.String r7) {
        /*
            r6 = this;
            int r0 = r7.length()
            r1 = 3
            r2 = 2
            r3 = 1
            r4 = 0
            r5 = 6
            if (r0 != r5) goto L_0x0028
            r0 = 5
            char r0 = r7.charAt(r0)
            r5 = 101(0x65, float:1.42E-43)
            if (r0 != r5) goto L_0x0018
            java.lang.String r0 = "callee"
            r5 = 1
            goto L_0x002a
        L_0x0018:
            r5 = 104(0x68, float:1.46E-43)
            if (r0 != r5) goto L_0x0020
            java.lang.String r0 = "length"
            r5 = 2
            goto L_0x002a
        L_0x0020:
            r5 = 114(0x72, float:1.6E-43)
            if (r0 != r5) goto L_0x0028
            java.lang.String r0 = "caller"
            r5 = 3
            goto L_0x002a
        L_0x0028:
            r0 = 0
            r5 = 0
        L_0x002a:
            if (r0 == 0) goto L_0x0035
            if (r0 == r7) goto L_0x0035
            boolean r0 = r0.equals(r7)
            if (r0 != 0) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r4 = r5
        L_0x0036:
            if (r4 != 0) goto L_0x003d
            int r7 = super.findInstanceIdInfo(r7)
            return r7
        L_0x003d:
            if (r4 == r3) goto L_0x004f
            if (r4 == r2) goto L_0x004c
            if (r4 != r1) goto L_0x0046
            int r7 = r6.callerAttr
            goto L_0x0051
        L_0x0046:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>()
            throw r7
        L_0x004c:
            int r7 = r6.lengthAttr
            goto L_0x0051
        L_0x004f:
            int r7 = r6.calleeAttr
        L_0x0051:
            int r7 = instanceIdInfo(r7, r4)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Arguments.findInstanceIdInfo(java.lang.String):int");
    }

    /* access modifiers changed from: protected */
    public Object getInstanceIdValue(int i) {
        NativeCall nativeCall;
        if (i == 1) {
            return this.calleeObj;
        }
        if (i == 2) {
            return this.lengthObj;
        }
        if (i != 3) {
            return super.getInstanceIdValue(i);
        }
        Object obj = this.callerObj;
        if (obj == UniqueTag.NULL_VALUE) {
            return null;
        }
        if (obj != null || (nativeCall = this.activation.parentActivationCall) == null) {
            return obj;
        }
        return nativeCall.get("arguments", nativeCall);
    }

    /* access modifiers changed from: protected */
    public void setInstanceIdValue(int i, Object obj) {
        if (i == 1) {
            this.calleeObj = obj;
        } else if (i == 2) {
            this.lengthObj = obj;
        } else if (i != 3) {
            super.setInstanceIdValue(i, obj);
        } else {
            if (obj == null) {
                obj = UniqueTag.NULL_VALUE;
            }
            this.callerObj = obj;
        }
    }

    /* access modifiers changed from: protected */
    public void setInstanceIdAttributes(int i, int i2) {
        if (i == 1) {
            this.calleeAttr = i2;
        } else if (i == 2) {
            this.lengthAttr = i2;
        } else if (i != 3) {
            super.setInstanceIdAttributes(i, i2);
        } else {
            this.callerAttr = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public Object[] getIds(boolean z) {
        int intValue;
        Object[] ids = super.getIds(z);
        Object[] objArr = this.args;
        if (objArr.length == 0) {
            return ids;
        }
        int length = objArr.length;
        boolean[] zArr = new boolean[length];
        int length2 = objArr.length;
        for (int i = 0; i != ids.length; i++) {
            Object obj = ids[i];
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) >= 0 && intValue < this.args.length && !zArr[intValue]) {
                zArr[intValue] = true;
                length2--;
            }
        }
        if (!z) {
            for (int i2 = 0; i2 < length; i2++) {
                if (!zArr[i2] && super.has(i2, (Scriptable) this)) {
                    zArr[i2] = true;
                    length2--;
                }
            }
        }
        if (length2 == 0) {
            return ids;
        }
        Object[] objArr2 = new Object[(ids.length + length2)];
        System.arraycopy(ids, 0, objArr2, length2, ids.length);
        int i3 = 0;
        for (int i4 = 0; i4 != this.args.length; i4++) {
            if (!zArr[i4]) {
                objArr2[i3] = Integer.valueOf(i4);
                i3++;
            }
        }
        if (i3 != length2) {
            Kit.codeBug();
        }
        return objArr2;
    }

    /* access modifiers changed from: protected */
    public ScriptableObject getOwnPropertyDescriptor(Context context, Object obj) {
        double number = ScriptRuntime.toNumber(obj);
        int i = (int) number;
        if (number != ((double) i)) {
            return super.getOwnPropertyDescriptor(context, obj);
        }
        Object arg = arg(i);
        if (arg == NOT_FOUND) {
            return super.getOwnPropertyDescriptor(context, obj);
        }
        if (sharedWithActivation(i)) {
            arg = getFromActivation(i);
        }
        if (super.has(i, (Scriptable) this)) {
            ScriptableObject ownPropertyDescriptor = super.getOwnPropertyDescriptor(context, obj);
            ownPropertyDescriptor.put("value", (Scriptable) ownPropertyDescriptor, arg);
            return ownPropertyDescriptor;
        }
        Scriptable parentScope = getParentScope();
        if (parentScope == null) {
            parentScope = this;
        }
        return buildDataDescriptor(parentScope, arg, 0);
    }

    /* access modifiers changed from: protected */
    public void defineOwnProperty(Context context, Object obj, ScriptableObject scriptableObject, boolean z) {
        super.defineOwnProperty(context, obj, scriptableObject, z);
        double number = ScriptRuntime.toNumber(obj);
        int i = (int) number;
        if (number != ((double) i) || arg(i) == NOT_FOUND) {
            return;
        }
        if (isAccessorDescriptor(scriptableObject)) {
            removeArg(i);
            return;
        }
        Object property = getProperty((Scriptable) scriptableObject, "value");
        if (property != NOT_FOUND) {
            replaceArg(i, property);
            if (isFalse(getProperty((Scriptable) scriptableObject, "writable"))) {
                removeArg(i);
            }
        }
    }
}
