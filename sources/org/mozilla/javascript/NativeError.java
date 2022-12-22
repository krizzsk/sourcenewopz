package org.mozilla.javascript;

import java.io.Serializable;
import java.lang.reflect.Method;
import org.osgi.framework.Constants;

final class NativeError extends IdScriptableObject {
    private static final int ConstructorId_captureStackTrace = -1;
    public static final int DEFAULT_STACK_LIMIT = -1;
    private static final Method ERROR_DELEGATE_GET_STACK;
    private static final Method ERROR_DELEGATE_SET_STACK;
    private static final Object ERROR_TAG = "Error";
    private static final int Id_constructor = 1;
    private static final int Id_toSource = 3;
    private static final int Id_toString = 2;
    private static final int MAX_PROTOTYPE_ID = 3;
    private static final String STACK_HIDE_KEY = "_stackHide";
    static final long serialVersionUID = -5338413581437645187L;
    private RhinoException stackProvider;

    public String getClassName() {
        return "Error";
    }

    NativeError() {
    }

    static {
        Class<NativeError> cls = NativeError.class;
        try {
            ERROR_DELEGATE_GET_STACK = cls.getMethod("getStackDelegated", new Class[]{Scriptable.class});
            ERROR_DELEGATE_SET_STACK = cls.getMethod("setStackDelegated", new Class[]{Scriptable.class, Object.class});
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    static void init(Scriptable scriptable, boolean z) {
        NativeError nativeError = new NativeError();
        ScriptableObject.putProperty((Scriptable) nativeError, "name", (Object) "Error");
        ScriptableObject.putProperty((Scriptable) nativeError, "message", (Object) "");
        ScriptableObject.putProperty((Scriptable) nativeError, "fileName", (Object) "");
        ScriptableObject.putProperty((Scriptable) nativeError, "lineNumber", (Object) 0);
        nativeError.setAttributes("name", 2);
        nativeError.setAttributes("message", 2);
        nativeError.exportAsJSClass(3, scriptable, z);
        NativeCallSite.init(nativeError, z);
    }

    static NativeError make(Context context, Scriptable scriptable, IdFunctionObject idFunctionObject, Object[] objArr) {
        NativeError nativeError = new NativeError();
        nativeError.setPrototype((Scriptable) idFunctionObject.get(Constants.SCOPE_PROTOTYPE, idFunctionObject));
        nativeError.setParentScope(scriptable);
        int length = objArr.length;
        if (length >= 1) {
            if (objArr[0] != Undefined.instance) {
                ScriptableObject.putProperty((Scriptable) nativeError, "message", (Object) ScriptRuntime.toString(objArr[0]));
            }
            if (length >= 2) {
                ScriptableObject.putProperty((Scriptable) nativeError, "fileName", objArr[1]);
                if (length >= 3) {
                    ScriptableObject.putProperty((Scriptable) nativeError, "lineNumber", (Object) Integer.valueOf(ScriptRuntime.toInt32(objArr[2])));
                }
            }
        }
        return nativeError;
    }

    /* access modifiers changed from: protected */
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        addIdFunctionProperty(idFunctionObject, ERROR_TAG, -1, "captureStackTrace", 2);
        ProtoProps protoProps = new ProtoProps();
        associateValue("_ErrorPrototypeProps", protoProps);
        IdFunctionObject idFunctionObject2 = idFunctionObject;
        ProtoProps protoProps2 = protoProps;
        idFunctionObject2.defineProperty("stackTraceLimit", protoProps2, ProtoProps.GET_STACK_LIMIT, ProtoProps.SET_STACK_LIMIT, 0);
        idFunctionObject2.defineProperty("prepareStackTrace", protoProps2, ProtoProps.GET_PREPARE_STACK, ProtoProps.SET_PREPARE_STACK, 0);
        super.fillConstructorProperties(idFunctionObject);
    }

    public String toString() {
        Object js_toString = js_toString(this);
        return js_toString instanceof String ? (String) js_toString : super.toString();
    }

    /* access modifiers changed from: protected */
    public void initPrototypeId(int i) {
        String str;
        int i2 = 0;
        if (i == 1) {
            str = "constructor";
            i2 = 1;
        } else if (i == 2) {
            str = "toString";
        } else if (i == 3) {
            str = "toSource";
        } else {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(ERROR_TAG, i, str, i2);
    }

    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(ERROR_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        if (methodId == -1) {
            js_captureStackTrace(context, scriptable2, objArr);
            return Undefined.instance;
        } else if (methodId == 1) {
            return make(context, scriptable, idFunctionObject, objArr);
        } else {
            if (methodId == 2) {
                return js_toString(scriptable2);
            }
            if (methodId == 3) {
                return js_toSource(context, scriptable, scriptable2);
            }
            throw new IllegalArgumentException(String.valueOf(methodId));
        }
    }

    public void setStackProvider(RhinoException rhinoException) {
        if (this.stackProvider == null) {
            this.stackProvider = rhinoException;
            defineProperty("stack", this, ERROR_DELEGATE_GET_STACK, ERROR_DELEGATE_SET_STACK, 2);
        }
    }

    public Object getStackDelegated(Scriptable scriptable) {
        Object obj;
        if (this.stackProvider == null) {
            return NOT_FOUND;
        }
        int i = -1;
        Function function = null;
        ProtoProps protoProps = (ProtoProps) ((NativeError) getPrototype()).getAssociatedValue("_ErrorPrototypeProps");
        if (protoProps != null) {
            i = protoProps.getStackTraceLimit();
            function = protoProps.getPrepareStackTrace();
        }
        ScriptStackElement[] scriptStack = this.stackProvider.getScriptStack(i, (String) getAssociatedValue(STACK_HIDE_KEY));
        if (function == null) {
            obj = RhinoException.formatStackTrace(scriptStack, this.stackProvider.details());
        } else {
            obj = callPrepareStack(function, scriptStack);
        }
        setStackDelegated(scriptable, obj);
        return obj;
    }

    public void setStackDelegated(Scriptable scriptable, Object obj) {
        scriptable.delete("stack");
        this.stackProvider = null;
        scriptable.put("stack", scriptable, obj);
    }

    private Object callPrepareStack(Function function, ScriptStackElement[] scriptStackElementArr) {
        Context currentContext = Context.getCurrentContext();
        Object[] objArr = new Object[scriptStackElementArr.length];
        for (int i = 0; i < scriptStackElementArr.length; i++) {
            NativeCallSite nativeCallSite = (NativeCallSite) currentContext.newObject(this, "CallSite");
            nativeCallSite.setElement(scriptStackElementArr[i]);
            objArr[i] = nativeCallSite;
        }
        return function.call(currentContext, function, this, new Object[]{this, currentContext.newArray((Scriptable) this, objArr)});
    }

    private static Object js_toString(Scriptable scriptable) {
        Object property = ScriptableObject.getProperty(scriptable, "name");
        String scriptRuntime = (property == NOT_FOUND || property == Undefined.instance) ? "Error" : ScriptRuntime.toString(property);
        Object property2 = ScriptableObject.getProperty(scriptable, "message");
        String scriptRuntime2 = (property2 == NOT_FOUND || property2 == Undefined.instance) ? "" : ScriptRuntime.toString(property2);
        if (scriptRuntime.toString().length() == 0) {
            return scriptRuntime2;
        }
        if (scriptRuntime2.toString().length() == 0) {
            return scriptRuntime;
        }
        return scriptRuntime + ": " + scriptRuntime2;
    }

    private static String js_toSource(Context context, Scriptable scriptable, Scriptable scriptable2) {
        int int32;
        Object property = ScriptableObject.getProperty(scriptable2, "name");
        Object property2 = ScriptableObject.getProperty(scriptable2, "message");
        Object property3 = ScriptableObject.getProperty(scriptable2, "fileName");
        Object property4 = ScriptableObject.getProperty(scriptable2, "lineNumber");
        StringBuilder sb = new StringBuilder();
        sb.append("(new ");
        if (property == NOT_FOUND) {
            property = Undefined.instance;
        }
        sb.append(ScriptRuntime.toString(property));
        sb.append("(");
        if (!(property2 == NOT_FOUND && property3 == NOT_FOUND && property4 == NOT_FOUND)) {
            if (property2 == NOT_FOUND) {
                property2 = "";
            }
            sb.append(ScriptRuntime.uneval(context, scriptable, property2));
            if (!(property3 == NOT_FOUND && property4 == NOT_FOUND)) {
                sb.append(", ");
                if (property3 == NOT_FOUND) {
                    property3 = "";
                }
                sb.append(ScriptRuntime.uneval(context, scriptable, property3));
                if (!(property4 == NOT_FOUND || (int32 = ScriptRuntime.toInt32(property4)) == 0)) {
                    sb.append(", ");
                    sb.append(ScriptRuntime.toString((double) int32));
                }
            }
        }
        sb.append("))");
        return sb.toString();
    }

    private static void js_captureStackTrace(Context context, Scriptable scriptable, Object[] objArr) {
        Object obj;
        ScriptableObject scriptableObject = (ScriptableObject) ScriptRuntime.toObjectOrNull(context, objArr[0], scriptable);
        Function function = objArr.length > 1 ? (Function) ScriptRuntime.toObjectOrNull(context, objArr[1], scriptable) : null;
        NativeError nativeError = (NativeError) context.newObject(scriptable, "Error");
        nativeError.setStackProvider(new EvaluatorException("[object Object]"));
        if (!(function == null || (obj = function.get("name", (Scriptable) function)) == null || Undefined.instance.equals(obj))) {
            nativeError.associateValue(STACK_HIDE_KEY, Context.toString(obj));
        }
        scriptableObject.defineProperty("stack", nativeError, ERROR_DELEGATE_GET_STACK, ERROR_DELEGATE_SET_STACK, 0);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0029 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int findPrototypeId(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.length()
            r1 = 3
            r2 = 0
            r3 = 8
            if (r0 != r3) goto L_0x001d
            char r0 = r5.charAt(r1)
            r3 = 111(0x6f, float:1.56E-43)
            if (r0 != r3) goto L_0x0015
            java.lang.String r0 = "toSource"
            goto L_0x0027
        L_0x0015:
            r1 = 116(0x74, float:1.63E-43)
            if (r0 != r1) goto L_0x0025
            r1 = 2
            java.lang.String r0 = "toString"
            goto L_0x0027
        L_0x001d:
            r1 = 11
            if (r0 != r1) goto L_0x0025
            r1 = 1
            java.lang.String r0 = "constructor"
            goto L_0x0027
        L_0x0025:
            r0 = 0
            r1 = 0
        L_0x0027:
            if (r0 == 0) goto L_0x0032
            if (r0 == r5) goto L_0x0032
            boolean r5 = r0.equals(r5)
            if (r5 != 0) goto L_0x0032
            goto L_0x0033
        L_0x0032:
            r2 = r1
        L_0x0033:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeError.findPrototypeId(java.lang.String):int");
    }

    private static final class ProtoProps implements Serializable {
        static final Method GET_PREPARE_STACK;
        static final Method GET_STACK_LIMIT;
        static final String KEY = "_ErrorPrototypeProps";
        static final Method SET_PREPARE_STACK;
        static final Method SET_STACK_LIMIT;
        private static final long serialVersionUID = 1907180507775337939L;
        private Function prepareStackTrace;
        private int stackTraceLimit;

        private ProtoProps() {
            this.stackTraceLimit = -1;
        }

        static {
            Class<ProtoProps> cls = ProtoProps.class;
            try {
                GET_STACK_LIMIT = cls.getMethod("getStackTraceLimit", new Class[]{Scriptable.class});
                SET_STACK_LIMIT = cls.getMethod("setStackTraceLimit", new Class[]{Scriptable.class, Object.class});
                GET_PREPARE_STACK = cls.getMethod("getPrepareStackTrace", new Class[]{Scriptable.class});
                SET_PREPARE_STACK = cls.getMethod("setPrepareStackTrace", new Class[]{Scriptable.class, Object.class});
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

        public Object getStackTraceLimit(Scriptable scriptable) {
            int i = this.stackTraceLimit;
            if (i >= 0) {
                return Integer.valueOf(i);
            }
            return Double.valueOf(Double.POSITIVE_INFINITY);
        }

        public int getStackTraceLimit() {
            return this.stackTraceLimit;
        }

        public void setStackTraceLimit(Scriptable scriptable, Object obj) {
            double number = Context.toNumber(obj);
            if (Double.isNaN(number) || Double.isInfinite(number)) {
                this.stackTraceLimit = -1;
            } else {
                this.stackTraceLimit = (int) number;
            }
        }

        public Object getPrepareStackTrace(Scriptable scriptable) {
            Function prepareStackTrace2 = getPrepareStackTrace();
            return prepareStackTrace2 == null ? Undefined.instance : prepareStackTrace2;
        }

        public Function getPrepareStackTrace() {
            return this.prepareStackTrace;
        }

        public void setPrepareStackTrace(Scriptable scriptable, Object obj) {
            if (obj == null || Undefined.instance.equals(obj)) {
                this.prepareStackTrace = null;
            } else if (obj instanceof Function) {
                this.prepareStackTrace = (Function) obj;
            }
        }
    }
}
