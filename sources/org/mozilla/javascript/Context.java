package org.mozilla.javascript;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.mozilla.javascript.TopLevel;
import org.mozilla.javascript.ast.AstRoot;
import org.mozilla.javascript.ast.ScriptNode;
import org.mozilla.javascript.debug.DebuggableScript;
import org.mozilla.javascript.debug.Debugger;
import org.mozilla.javascript.xml.XMLLib;

public class Context {
    public static final int FEATURE_DYNAMIC_SCOPE = 7;
    public static final int FEATURE_E4X = 6;
    public static final int FEATURE_ENHANCED_JAVA_ACCESS = 13;
    public static final int FEATURE_LOCATION_INFORMATION_IN_ERROR = 10;
    public static final int FEATURE_MEMBER_EXPR_AS_FUNCTION_NAME = 2;
    public static final int FEATURE_NON_ECMA_GET_YEAR = 1;
    public static final int FEATURE_PARENT_PROTO_PROPERTIES = 5;
    @Deprecated
    public static final int FEATURE_PARENT_PROTO_PROPRTIES = 5;
    public static final int FEATURE_RESERVED_KEYWORD_AS_IDENTIFIER = 3;
    public static final int FEATURE_STRICT_EVAL = 9;
    public static final int FEATURE_STRICT_MODE = 11;
    public static final int FEATURE_STRICT_VARS = 8;
    public static final int FEATURE_TO_STRING_AS_SOURCE = 4;
    public static final int FEATURE_V8_EXTENSIONS = 14;
    public static final int FEATURE_WARNING_AS_ERROR = 12;
    public static final int VERSION_1_0 = 100;
    public static final int VERSION_1_1 = 110;
    public static final int VERSION_1_2 = 120;
    public static final int VERSION_1_3 = 130;
    public static final int VERSION_1_4 = 140;
    public static final int VERSION_1_5 = 150;
    public static final int VERSION_1_6 = 160;
    public static final int VERSION_1_7 = 170;
    public static final int VERSION_1_8 = 180;
    public static final int VERSION_DEFAULT = 0;
    public static final int VERSION_ES6 = 200;
    public static final int VERSION_UNKNOWN = -1;
    private static Class<?> codegenClass = Kit.classOrNull("org.mozilla.javascript.optimizer.Codegen");
    public static final Object[] emptyArgs = ScriptRuntime.emptyArgs;
    public static final String errorReporterProperty = "error reporter";
    private static String implementationVersion = null;
    private static Class<?> interpreterClass = Kit.classOrNull("org.mozilla.javascript.Interpreter");
    public static final String languageVersionProperty = "language version";
    Set<String> activationNames;
    private ClassLoader applicationClassLoader;
    XMLLib cachedXMLLib;
    /* access modifiers changed from: private */
    public ClassShutter classShutter;
    NativeCall currentActivationCall;
    Debugger debugger;
    private Object debuggerData;
    private int enterCount;
    private ErrorReporter errorReporter;
    private final ContextFactory factory;
    public boolean generateObserverCount;
    private boolean generatingDebug;
    private boolean generatingDebugChanged;
    private boolean generatingSource;
    private boolean hasClassShutter;
    int instructionCount;
    int instructionThreshold;
    Object interpreterSecurityDomain;
    boolean isContinuationsTopCall;
    ObjToIntMap iterating;
    Object lastInterpreterFrame;
    private Locale locale;
    private int maximumInterpreterStackDepth;
    private int optimizationLevel;
    ObjArray previousInterpreterInvocations;
    private Object propertyListeners;
    RegExpProxy regExpProxy;
    int scratchIndex;
    Scriptable scratchScriptable;
    long scratchUint32;
    private Object sealKey;
    private boolean sealed;
    private SecurityController securityController;
    private Map<Object, Object> threadLocalMap;
    Scriptable topCallScope;
    BaseFunction typeErrorThrower;
    boolean useDynamicScope;
    int version;
    private WrapFactory wrapFactory;

    public interface ClassShutterSetter {
        ClassShutter getClassShutter();

        void setClassShutter(ClassShutter classShutter);
    }

    public static boolean isValidLanguageVersion(int i) {
        switch (i) {
            case 0:
            case 100:
            case 110:
            case 120:
            case 130:
            case 140:
            case 150:
            case 160:
            case 170:
            case 180:
            case 200:
                return true;
            default:
                return false;
        }
    }

    public static boolean isValidOptimizationLevel(int i) {
        return -1 <= i && i <= 9;
    }

    @Deprecated
    public static void setCachingEnabled(boolean z) {
    }

    @Deprecated
    public Context() {
        this(ContextFactory.getGlobal());
    }

    protected Context(ContextFactory contextFactory) {
        this.generatingSource = true;
        int i = 0;
        this.generateObserverCount = false;
        if (contextFactory != null) {
            this.factory = contextFactory;
            this.version = 0;
            this.optimizationLevel = codegenClass == null ? -1 : i;
            this.maximumInterpreterStackDepth = Integer.MAX_VALUE;
            return;
        }
        throw new IllegalArgumentException("factory == null");
    }

    public static Context getCurrentContext() {
        return VMBridge.instance.getContext(VMBridge.instance.getThreadContextHelper());
    }

    public static Context enter() {
        return enter((Context) null);
    }

    @Deprecated
    public static Context enter(Context context) {
        return enter(context, ContextFactory.getGlobal());
    }

    static final Context enter(Context context, ContextFactory contextFactory) {
        Object threadContextHelper = VMBridge.instance.getThreadContextHelper();
        Context context2 = VMBridge.instance.getContext(threadContextHelper);
        if (context2 == null) {
            if (context == null) {
                context = contextFactory.makeContext();
                if (context.enterCount == 0) {
                    contextFactory.onContextCreated(context);
                    if (contextFactory.isSealed() && !context.isSealed()) {
                        context.seal((Object) null);
                    }
                } else {
                    throw new IllegalStateException("factory.makeContext() returned Context instance already associated with some thread");
                }
            } else if (context.enterCount != 0) {
                throw new IllegalStateException("can not use Context instance already associated with some thread");
            }
            VMBridge.instance.setContext(threadContextHelper, context);
            context2 = context;
        }
        context2.enterCount++;
        return context2;
    }

    public static void exit() {
        Object threadContextHelper = VMBridge.instance.getThreadContextHelper();
        Context context = VMBridge.instance.getContext(threadContextHelper);
        if (context != null) {
            if (context.enterCount < 1) {
                Kit.codeBug();
            }
            int i = context.enterCount - 1;
            context.enterCount = i;
            if (i == 0) {
                VMBridge.instance.setContext(threadContextHelper, (Context) null);
                context.factory.onContextReleased(context);
                return;
            }
            return;
        }
        throw new IllegalStateException("Calling Context.exit without previous Context.enter");
    }

    @Deprecated
    public static Object call(ContextAction contextAction) {
        return call(ContextFactory.getGlobal(), contextAction);
    }

    public static Object call(ContextFactory contextFactory, final Callable callable, final Scriptable scriptable, final Scriptable scriptable2, final Object[] objArr) {
        if (contextFactory == null) {
            contextFactory = ContextFactory.getGlobal();
        }
        return call(contextFactory, new ContextAction() {
            public Object run(Context context) {
                return callable.call(context, scriptable, scriptable2, objArr);
            }
        });
    }

    static Object call(ContextFactory contextFactory, ContextAction contextAction) {
        try {
            return contextAction.run(enter((Context) null, contextFactory));
        } finally {
            exit();
        }
    }

    @Deprecated
    public static void addContextListener(ContextListener contextListener) {
        if ("org.mozilla.javascript.tools.debugger.Main".equals(contextListener.getClass().getName())) {
            Class<?> cls = contextListener.getClass();
            Class[] clsArr = {Kit.classOrNull("org.mozilla.javascript.ContextFactory")};
            try {
                cls.getMethod("attachTo", clsArr).invoke(contextListener, new Object[]{ContextFactory.getGlobal()});
            } catch (Exception e) {
                RuntimeException runtimeException = new RuntimeException();
                Kit.initCause(runtimeException, e);
                throw runtimeException;
            }
        } else {
            ContextFactory.getGlobal().addListener(contextListener);
        }
    }

    @Deprecated
    public static void removeContextListener(ContextListener contextListener) {
        ContextFactory.getGlobal().addListener(contextListener);
    }

    public final ContextFactory getFactory() {
        return this.factory;
    }

    public final boolean isSealed() {
        return this.sealed;
    }

    public final void seal(Object obj) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.sealed = true;
        this.sealKey = obj;
    }

    public final void unseal(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        } else if (this.sealKey != obj) {
            throw new IllegalArgumentException();
        } else if (this.sealed) {
            this.sealed = false;
            this.sealKey = null;
        } else {
            throw new IllegalStateException();
        }
    }

    static void onSealedMutation() {
        throw new IllegalStateException();
    }

    public final int getLanguageVersion() {
        return this.version;
    }

    public void setLanguageVersion(int i) {
        int i2;
        if (this.sealed) {
            onSealedMutation();
        }
        checkLanguageVersion(i);
        Object obj = this.propertyListeners;
        if (!(obj == null || i == (i2 = this.version))) {
            firePropertyChangeImpl(obj, languageVersionProperty, Integer.valueOf(i2), Integer.valueOf(i));
        }
        this.version = i;
    }

    public static void checkLanguageVersion(int i) {
        if (!isValidLanguageVersion(i)) {
            throw new IllegalArgumentException("Bad language version: " + i);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0079 A[SYNTHETIC, Splitter:B:27:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0013 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getImplementationVersion() {
        /*
            r7 = this;
            java.lang.String r0 = " "
            java.lang.String r1 = implementationVersion
            if (r1 != 0) goto L_0x0082
            r1 = 0
            java.lang.Class<org.mozilla.javascript.Context> r2 = org.mozilla.javascript.Context.class
            java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch:{ IOException -> 0x0081 }
            java.lang.String r3 = "META-INF/MANIFEST.MF"
            java.util.Enumeration r2 = r2.getResources(r3)     // Catch:{ IOException -> 0x0081 }
        L_0x0013:
            boolean r3 = r2.hasMoreElements()
            if (r3 == 0) goto L_0x0082
            java.lang.Object r3 = r2.nextElement()
            java.net.URL r3 = (java.net.URL) r3
            java.io.InputStream r3 = r3.openStream()     // Catch:{ IOException -> 0x007d, all -> 0x0076 }
            java.util.jar.Manifest r4 = new java.util.jar.Manifest     // Catch:{ IOException -> 0x007e, all -> 0x0073 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x007e, all -> 0x0073 }
            java.util.jar.Attributes r4 = r4.getMainAttributes()     // Catch:{ IOException -> 0x007e, all -> 0x0073 }
            java.lang.String r5 = "Mozilla Rhino"
            java.lang.String r6 = "Implementation-Title"
            java.lang.String r6 = r4.getValue(r6)     // Catch:{ IOException -> 0x007e, all -> 0x0073 }
            boolean r5 = r5.equals(r6)     // Catch:{ IOException -> 0x007e, all -> 0x0073 }
            if (r5 == 0) goto L_0x006b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x007e, all -> 0x0073 }
            r5.<init>()     // Catch:{ IOException -> 0x007e, all -> 0x0073 }
            java.lang.String r6 = "Rhino "
            r5.append(r6)     // Catch:{ IOException -> 0x007e, all -> 0x0073 }
            java.lang.String r6 = "Implementation-Version"
            java.lang.String r6 = r4.getValue(r6)     // Catch:{ IOException -> 0x007e, all -> 0x0073 }
            r5.append(r6)     // Catch:{ IOException -> 0x007e, all -> 0x0073 }
            r5.append(r0)     // Catch:{ IOException -> 0x007e, all -> 0x0073 }
            java.lang.String r6 = "Built-Date"
            java.lang.String r4 = r4.getValue(r6)     // Catch:{ IOException -> 0x007e, all -> 0x0073 }
            java.lang.String r6 = "-"
            java.lang.String r4 = r4.replaceAll(r6, r0)     // Catch:{ IOException -> 0x007e, all -> 0x0073 }
            r5.append(r4)     // Catch:{ IOException -> 0x007e, all -> 0x0073 }
            java.lang.String r4 = r5.toString()     // Catch:{ IOException -> 0x007e, all -> 0x0073 }
            implementationVersion = r4     // Catch:{ IOException -> 0x007e, all -> 0x0073 }
            if (r3 == 0) goto L_0x006a
            r3.close()     // Catch:{ IOException -> 0x006a }
        L_0x006a:
            return r4
        L_0x006b:
            if (r3 == 0) goto L_0x0013
        L_0x006d:
            r3.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x0013
        L_0x0071:
            goto L_0x0013
        L_0x0073:
            r0 = move-exception
            r1 = r3
            goto L_0x0077
        L_0x0076:
            r0 = move-exception
        L_0x0077:
            if (r1 == 0) goto L_0x007c
            r1.close()     // Catch:{ IOException -> 0x007c }
        L_0x007c:
            throw r0
        L_0x007d:
            r3 = r1
        L_0x007e:
            if (r3 == 0) goto L_0x0013
            goto L_0x006d
        L_0x0081:
            return r1
        L_0x0082:
            java.lang.String r0 = implementationVersion
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Context.getImplementationVersion():java.lang.String");
    }

    public final ErrorReporter getErrorReporter() {
        ErrorReporter errorReporter2 = this.errorReporter;
        return errorReporter2 == null ? DefaultErrorReporter.instance : errorReporter2;
    }

    public final ErrorReporter setErrorReporter(ErrorReporter errorReporter2) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (errorReporter2 != null) {
            ErrorReporter errorReporter3 = getErrorReporter();
            if (errorReporter2 == errorReporter3) {
                return errorReporter3;
            }
            Object obj = this.propertyListeners;
            if (obj != null) {
                firePropertyChangeImpl(obj, errorReporterProperty, errorReporter3, errorReporter2);
            }
            this.errorReporter = errorReporter2;
            return errorReporter3;
        }
        throw new IllegalArgumentException();
    }

    public final Locale getLocale() {
        if (this.locale == null) {
            this.locale = Locale.getDefault();
        }
        return this.locale;
    }

    public final Locale setLocale(Locale locale2) {
        if (this.sealed) {
            onSealedMutation();
        }
        Locale locale3 = this.locale;
        this.locale = locale2;
        return locale3;
    }

    public final void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.propertyListeners = Kit.addListener(this.propertyListeners, propertyChangeListener);
    }

    public final void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.propertyListeners = Kit.removeListener(this.propertyListeners, propertyChangeListener);
    }

    /* access modifiers changed from: package-private */
    public final void firePropertyChange(String str, Object obj, Object obj2) {
        Object obj3 = this.propertyListeners;
        if (obj3 != null) {
            firePropertyChangeImpl(obj3, str, obj, obj2);
        }
    }

    private void firePropertyChangeImpl(Object obj, String str, Object obj2, Object obj3) {
        int i = 0;
        while (true) {
            Object listener = Kit.getListener(obj, i);
            if (listener != null) {
                if (listener instanceof PropertyChangeListener) {
                    ((PropertyChangeListener) listener).propertyChange(new PropertyChangeEvent(this, str, obj2, obj3));
                }
                i++;
            } else {
                return;
            }
        }
    }

    public static void reportWarning(String str, String str2, int i, String str3, int i2) {
        Context context = getContext();
        if (context.hasFeature(12)) {
            reportError(str, str2, i, str3, i2);
        } else {
            context.getErrorReporter().warning(str, str2, i, str3, i2);
        }
    }

    public static void reportWarning(String str) {
        int[] iArr = {0};
        reportWarning(str, getSourcePositionFromStack(iArr), iArr[0], (String) null, 0);
    }

    public static void reportWarning(String str, Throwable th) {
        int[] iArr = {0};
        String sourcePositionFromStack = getSourcePositionFromStack(iArr);
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        printWriter.println(str);
        th.printStackTrace(printWriter);
        printWriter.flush();
        reportWarning(stringWriter.toString(), sourcePositionFromStack, iArr[0], (String) null, 0);
    }

    public static void reportError(String str, String str2, int i, String str3, int i2) {
        Context currentContext = getCurrentContext();
        if (currentContext != null) {
            currentContext.getErrorReporter().error(str, str2, i, str3, i2);
            return;
        }
        throw new EvaluatorException(str, str2, i, str3, i2);
    }

    public static void reportError(String str) {
        int[] iArr = {0};
        reportError(str, getSourcePositionFromStack(iArr), iArr[0], (String) null, 0);
    }

    public static EvaluatorException reportRuntimeError(String str, String str2, int i, String str3, int i2) {
        Context currentContext = getCurrentContext();
        if (currentContext != null) {
            return currentContext.getErrorReporter().runtimeError(str, str2, i, str3, i2);
        }
        throw new EvaluatorException(str, str2, i, str3, i2);
    }

    static EvaluatorException reportRuntimeError0(String str) {
        return reportRuntimeError(ScriptRuntime.getMessage0(str));
    }

    static EvaluatorException reportRuntimeError1(String str, Object obj) {
        return reportRuntimeError(ScriptRuntime.getMessage1(str, obj));
    }

    static EvaluatorException reportRuntimeError2(String str, Object obj, Object obj2) {
        return reportRuntimeError(ScriptRuntime.getMessage2(str, obj, obj2));
    }

    static EvaluatorException reportRuntimeError3(String str, Object obj, Object obj2, Object obj3) {
        return reportRuntimeError(ScriptRuntime.getMessage3(str, obj, obj2, obj3));
    }

    static EvaluatorException reportRuntimeError4(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        return reportRuntimeError(ScriptRuntime.getMessage4(str, obj, obj2, obj3, obj4));
    }

    public static EvaluatorException reportRuntimeError(String str) {
        int[] iArr = {0};
        return reportRuntimeError(str, getSourcePositionFromStack(iArr), iArr[0], (String) null, 0);
    }

    public final ScriptableObject initStandardObjects() {
        return initStandardObjects((ScriptableObject) null, false);
    }

    public final ScriptableObject initSafeStandardObjects() {
        return initSafeStandardObjects((ScriptableObject) null, false);
    }

    public final Scriptable initStandardObjects(ScriptableObject scriptableObject) {
        return initStandardObjects(scriptableObject, false);
    }

    public final Scriptable initSafeStandardObjects(ScriptableObject scriptableObject) {
        return initSafeStandardObjects(scriptableObject, false);
    }

    public ScriptableObject initStandardObjects(ScriptableObject scriptableObject, boolean z) {
        return ScriptRuntime.initStandardObjects(this, scriptableObject, z);
    }

    public ScriptableObject initSafeStandardObjects(ScriptableObject scriptableObject, boolean z) {
        return ScriptRuntime.initSafeStandardObjects(this, scriptableObject, z);
    }

    public static Object getUndefinedValue() {
        return Undefined.instance;
    }

    public final Object evaluateString(Scriptable scriptable, String str, String str2, int i, Object obj) {
        Script compileString = compileString(str, str2, i, obj);
        if (compileString != null) {
            return compileString.exec(this, scriptable);
        }
        return null;
    }

    public final Object evaluateReader(Scriptable scriptable, Reader reader, String str, int i, Object obj) throws IOException {
        Script compileReader = compileReader(scriptable, reader, str, i, obj);
        if (compileReader != null) {
            return compileReader.exec(this, scriptable);
        }
        return null;
    }

    public Object executeScriptWithContinuations(Script script, Scriptable scriptable) throws ContinuationPending {
        if (script instanceof InterpretedFunction) {
            InterpretedFunction interpretedFunction = (InterpretedFunction) script;
            if (interpretedFunction.isScript()) {
                return callFunctionWithContinuations(interpretedFunction, scriptable, ScriptRuntime.emptyArgs);
            }
        }
        throw new IllegalArgumentException("Script argument was not a script or was not created by interpreted mode ");
    }

    public Object callFunctionWithContinuations(Callable callable, Scriptable scriptable, Object[] objArr) throws ContinuationPending {
        if (!(callable instanceof InterpretedFunction)) {
            throw new IllegalArgumentException("Function argument was not created by interpreted mode ");
        } else if (!ScriptRuntime.hasTopCall(this)) {
            this.isContinuationsTopCall = true;
            return ScriptRuntime.doTopCall(callable, this, scriptable, scriptable, objArr);
        } else {
            throw new IllegalStateException("Cannot have any pending top calls when executing a script with continuations");
        }
    }

    public ContinuationPending captureContinuation() {
        return new ContinuationPending(Interpreter.captureContinuation(this));
    }

    public Object resumeContinuation(Object obj, Scriptable scriptable, Object obj2) throws ContinuationPending {
        return Interpreter.restartContinuation((NativeContinuation) obj, this, scriptable, new Object[]{obj2});
    }

    public final boolean stringIsCompilableUnit(String str) {
        boolean z;
        CompilerEnvirons compilerEnvirons = new CompilerEnvirons();
        compilerEnvirons.initFromContext(this);
        compilerEnvirons.setGeneratingSource(false);
        Parser parser = new Parser(compilerEnvirons, DefaultErrorReporter.instance);
        try {
            parser.parse(str, (String) null, 1);
            z = false;
        } catch (EvaluatorException unused) {
            z = true;
        }
        if (!z || !parser.eof()) {
            return true;
        }
        return false;
    }

    @Deprecated
    public final Script compileReader(Scriptable scriptable, Reader reader, String str, int i, Object obj) throws IOException {
        return compileReader(reader, str, i, obj);
    }

    public final Script compileReader(Reader reader, String str, int i, Object obj) throws IOException {
        return (Script) compileImpl((Scriptable) null, reader, (String) null, str, i < 0 ? 0 : i, obj, false, (Evaluator) null, (ErrorReporter) null);
    }

    public final Script compileString(String str, String str2, int i, Object obj) {
        return compileString(str, (Evaluator) null, (ErrorReporter) null, str2, i < 0 ? 0 : i, obj);
    }

    /* access modifiers changed from: package-private */
    public final Script compileString(String str, Evaluator evaluator, ErrorReporter errorReporter2, String str2, int i, Object obj) {
        try {
            return (Script) compileImpl((Scriptable) null, (Reader) null, str, str2, i, obj, false, evaluator, errorReporter2);
        } catch (IOException unused) {
            throw new RuntimeException();
        }
    }

    public final Function compileFunction(Scriptable scriptable, String str, String str2, int i, Object obj) {
        return compileFunction(scriptable, str, (Evaluator) null, (ErrorReporter) null, str2, i, obj);
    }

    /* access modifiers changed from: package-private */
    public final Function compileFunction(Scriptable scriptable, String str, Evaluator evaluator, ErrorReporter errorReporter2, String str2, int i, Object obj) {
        try {
            return (Function) compileImpl(scriptable, (Reader) null, str, str2, i, obj, true, evaluator, errorReporter2);
        } catch (IOException unused) {
            throw new RuntimeException();
        }
    }

    public final String decompileScript(Script script, int i) {
        return ((NativeFunction) script).decompile(i, 0);
    }

    public final String decompileFunction(Function function, int i) {
        if (function instanceof BaseFunction) {
            return ((BaseFunction) function).decompile(i, 0);
        }
        return "function " + function.getClassName() + "() {\n\t[native code]\n}\n";
    }

    public final String decompileFunctionBody(Function function, int i) {
        return function instanceof BaseFunction ? ((BaseFunction) function).decompile(i, 1) : "[native code]\n";
    }

    public Scriptable newObject(Scriptable scriptable) {
        NativeObject nativeObject = new NativeObject();
        ScriptRuntime.setBuiltinProtoAndParent(nativeObject, scriptable, TopLevel.Builtins.Object);
        return nativeObject;
    }

    public Scriptable newObject(Scriptable scriptable, String str) {
        return newObject(scriptable, str, ScriptRuntime.emptyArgs);
    }

    public Scriptable newObject(Scriptable scriptable, String str, Object[] objArr) {
        return ScriptRuntime.newObject(this, scriptable, str, objArr);
    }

    public Scriptable newArray(Scriptable scriptable, int i) {
        NativeArray nativeArray = new NativeArray((long) i);
        ScriptRuntime.setBuiltinProtoAndParent(nativeArray, scriptable, TopLevel.Builtins.Array);
        return nativeArray;
    }

    public Scriptable newArray(Scriptable scriptable, Object[] objArr) {
        if (objArr.getClass().getComponentType() == ScriptRuntime.ObjectClass) {
            NativeArray nativeArray = new NativeArray(objArr);
            ScriptRuntime.setBuiltinProtoAndParent(nativeArray, scriptable, TopLevel.Builtins.Array);
            return nativeArray;
        }
        throw new IllegalArgumentException();
    }

    public final Object[] getElements(Scriptable scriptable) {
        return ScriptRuntime.getArrayElements(scriptable);
    }

    public static boolean toBoolean(Object obj) {
        return ScriptRuntime.toBoolean(obj);
    }

    public static double toNumber(Object obj) {
        return ScriptRuntime.toNumber(obj);
    }

    public static String toString(Object obj) {
        return ScriptRuntime.toString(obj);
    }

    public static Scriptable toObject(Object obj, Scriptable scriptable) {
        return ScriptRuntime.toObject(scriptable, obj);
    }

    @Deprecated
    public static Scriptable toObject(Object obj, Scriptable scriptable, Class<?> cls) {
        return ScriptRuntime.toObject(scriptable, obj);
    }

    public static Object javaToJS(Object obj, Scriptable scriptable) {
        if ((obj instanceof String) || (obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof Scriptable)) {
            return obj;
        }
        if (obj instanceof Character) {
            return String.valueOf(((Character) obj).charValue());
        }
        Context context = getContext();
        return context.getWrapFactory().wrap(context, scriptable, obj, (Class<?>) null);
    }

    public static Object jsToJava(Object obj, Class<?> cls) throws EvaluatorException {
        return NativeJavaObject.coerceTypeImpl(cls, obj);
    }

    @Deprecated
    public static Object toType(Object obj, Class<?> cls) throws IllegalArgumentException {
        try {
            return jsToJava(obj, cls);
        } catch (EvaluatorException e) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(e.getMessage());
            Kit.initCause(illegalArgumentException, e);
            throw illegalArgumentException;
        }
    }

    public static RuntimeException throwAsScriptRuntimeEx(Throwable th) {
        Context context;
        while (th instanceof InvocationTargetException) {
            th = ((InvocationTargetException) th).getTargetException();
        }
        if ((th instanceof Error) && ((context = getContext()) == null || !context.hasFeature(13))) {
            throw ((Error) th);
        } else if (th instanceof RhinoException) {
            throw ((RhinoException) th);
        } else {
            throw new WrappedException(th);
        }
    }

    public final boolean isGeneratingDebug() {
        return this.generatingDebug;
    }

    public final void setGeneratingDebug(boolean z) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.generatingDebugChanged = true;
        if (z && getOptimizationLevel() > 0) {
            setOptimizationLevel(0);
        }
        this.generatingDebug = z;
    }

    public final boolean isGeneratingSource() {
        return this.generatingSource;
    }

    public final void setGeneratingSource(boolean z) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.generatingSource = z;
    }

    public final int getOptimizationLevel() {
        return this.optimizationLevel;
    }

    public final void setOptimizationLevel(int i) {
        if (this.sealed) {
            onSealedMutation();
        }
        int i2 = -1;
        if (i == -2) {
            i = -1;
        }
        checkOptimizationLevel(i);
        if (codegenClass != null) {
            i2 = i;
        }
        this.optimizationLevel = i2;
    }

    public static void checkOptimizationLevel(int i) {
        if (!isValidOptimizationLevel(i)) {
            throw new IllegalArgumentException("Optimization level outside [-1..9]: " + i);
        }
    }

    public final int getMaximumInterpreterStackDepth() {
        return this.maximumInterpreterStackDepth;
    }

    public final void setMaximumInterpreterStackDepth(int i) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (this.optimizationLevel != -1) {
            throw new IllegalStateException("Cannot set maximumInterpreterStackDepth when optimizationLevel != -1");
        } else if (i >= 1) {
            this.maximumInterpreterStackDepth = i;
        } else {
            throw new IllegalArgumentException("Cannot set maximumInterpreterStackDepth to less than 1");
        }
    }

    public final void setSecurityController(SecurityController securityController2) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (securityController2 == null) {
            throw new IllegalArgumentException();
        } else if (this.securityController != null) {
            throw new SecurityException("Can not overwrite existing SecurityController object");
        } else if (!SecurityController.hasGlobal()) {
            this.securityController = securityController2;
        } else {
            throw new SecurityException("Can not overwrite existing global SecurityController object");
        }
    }

    public final synchronized void setClassShutter(ClassShutter classShutter2) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (classShutter2 == null) {
            throw new IllegalArgumentException();
        } else if (!this.hasClassShutter) {
            this.classShutter = classShutter2;
            this.hasClassShutter = true;
        } else {
            throw new SecurityException("Cannot overwrite existing ClassShutter object");
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized ClassShutter getClassShutter() {
        return this.classShutter;
    }

    public final synchronized ClassShutterSetter getClassShutterSetter() {
        if (this.hasClassShutter) {
            return null;
        }
        this.hasClassShutter = true;
        return new ClassShutterSetter() {
            public void setClassShutter(ClassShutter classShutter) {
                ClassShutter unused = Context.this.classShutter = classShutter;
            }

            public ClassShutter getClassShutter() {
                return Context.this.classShutter;
            }
        };
    }

    public final Object getThreadLocal(Object obj) {
        Map<Object, Object> map = this.threadLocalMap;
        if (map == null) {
            return null;
        }
        return map.get(obj);
    }

    public final synchronized void putThreadLocal(Object obj, Object obj2) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (this.threadLocalMap == null) {
            this.threadLocalMap = new HashMap();
        }
        this.threadLocalMap.put(obj, obj2);
    }

    public final void removeThreadLocal(Object obj) {
        if (this.sealed) {
            onSealedMutation();
        }
        Map<Object, Object> map = this.threadLocalMap;
        if (map != null) {
            map.remove(obj);
        }
    }

    public final void setWrapFactory(WrapFactory wrapFactory2) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (wrapFactory2 != null) {
            this.wrapFactory = wrapFactory2;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final WrapFactory getWrapFactory() {
        if (this.wrapFactory == null) {
            this.wrapFactory = new WrapFactory();
        }
        return this.wrapFactory;
    }

    public final Debugger getDebugger() {
        return this.debugger;
    }

    public final Object getDebuggerContextData() {
        return this.debuggerData;
    }

    public final void setDebugger(Debugger debugger2, Object obj) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.debugger = debugger2;
        this.debuggerData = obj;
    }

    public static DebuggableScript getDebuggableView(Script script) {
        if (script instanceof NativeFunction) {
            return ((NativeFunction) script).getDebuggableView();
        }
        return null;
    }

    public boolean hasFeature(int i) {
        return getFactory().hasFeature(this, i);
    }

    public XMLLib.Factory getE4xImplementationFactory() {
        return getFactory().getE4xImplementationFactory();
    }

    public final int getInstructionObserverThreshold() {
        return this.instructionThreshold;
    }

    public final void setInstructionObserverThreshold(int i) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (i >= 0) {
            this.instructionThreshold = i;
            setGenerateObserverCount(i > 0);
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setGenerateObserverCount(boolean z) {
        this.generateObserverCount = z;
    }

    /* access modifiers changed from: protected */
    public void observeInstructionCount(int i) {
        getFactory().observeInstructionCount(this, i);
    }

    public GeneratedClassLoader createClassLoader(ClassLoader classLoader) {
        return getFactory().createClassLoader(classLoader);
    }

    public final ClassLoader getApplicationClassLoader() {
        if (this.applicationClassLoader == null) {
            ContextFactory factory2 = getFactory();
            ClassLoader applicationClassLoader2 = factory2.getApplicationClassLoader();
            if (applicationClassLoader2 == null) {
                ClassLoader currentThreadClassLoader = VMBridge.instance.getCurrentThreadClassLoader();
                if (currentThreadClassLoader != null && Kit.testIfCanLoadRhinoClasses(currentThreadClassLoader)) {
                    return currentThreadClassLoader;
                }
                Class<?> cls = factory2.getClass();
                if (cls != ScriptRuntime.ContextFactoryClass) {
                    applicationClassLoader2 = cls.getClassLoader();
                } else {
                    applicationClassLoader2 = getClass().getClassLoader();
                }
            }
            this.applicationClassLoader = applicationClassLoader2;
        }
        return this.applicationClassLoader;
    }

    public final void setApplicationClassLoader(ClassLoader classLoader) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (classLoader == null) {
            this.applicationClassLoader = null;
        } else if (Kit.testIfCanLoadRhinoClasses(classLoader)) {
            this.applicationClassLoader = classLoader;
        } else {
            throw new IllegalArgumentException("Loader can not resolve Rhino classes");
        }
    }

    static Context getContext() {
        Context currentContext = getCurrentContext();
        if (currentContext != null) {
            return currentContext;
        }
        throw new RuntimeException("No Context associated with current Thread");
    }

    private Object compileImpl(Scriptable scriptable, Reader reader, String str, String str2, int i, Object obj, boolean z, Evaluator evaluator, ErrorReporter errorReporter2) throws IOException {
        AstRoot astRoot;
        if (str2 == null) {
            str2 = "unnamed script";
        }
        if (obj == null || getSecurityController() != null) {
            boolean z2 = false;
            if (!((reader == null) ^ (str == null))) {
                Kit.codeBug();
            }
            if (scriptable == null) {
                z2 = true;
            }
            if (!(z2 ^ z)) {
                Kit.codeBug();
            }
            CompilerEnvirons compilerEnvirons = new CompilerEnvirons();
            compilerEnvirons.initFromContext(this);
            if (errorReporter2 == null) {
                errorReporter2 = compilerEnvirons.getErrorReporter();
            }
            if (!(this.debugger == null || reader == null)) {
                str = Kit.readReader(reader);
                reader = null;
            }
            Parser parser = new Parser(compilerEnvirons, errorReporter2);
            if (z) {
                parser.calledByCompileFunction = true;
            }
            if (str != null) {
                astRoot = parser.parse(str, str2, i);
            } else {
                astRoot = parser.parse(reader, str2, i);
            }
            if (!z || (astRoot.getFirstChild() != null && astRoot.getFirstChild().getType() == 109)) {
                ScriptNode transformTree = new IRFactory(compilerEnvirons, errorReporter2).transformTree(astRoot);
                if (evaluator == null) {
                    evaluator = createCompiler();
                }
                Object compile = evaluator.compile(compilerEnvirons, transformTree, transformTree.getEncodedSource(), z);
                if (this.debugger != null) {
                    if (str == null) {
                        Kit.codeBug();
                    }
                    if (compile instanceof DebuggableScript) {
                        notifyDebugger_r(this, (DebuggableScript) compile, str);
                    } else {
                        throw new RuntimeException("NOT SUPPORTED");
                    }
                }
                if (z) {
                    return evaluator.createFunctionObject(this, scriptable, compile, obj);
                }
                return evaluator.createScriptObject(compile, obj);
            }
            throw new IllegalArgumentException("compileFunction only accepts source with single JS function: " + str);
        }
        throw new IllegalArgumentException("securityDomain should be null if setSecurityController() was never called");
    }

    private static void notifyDebugger_r(Context context, DebuggableScript debuggableScript, String str) {
        context.debugger.handleCompilationDone(context, debuggableScript, str);
        for (int i = 0; i != debuggableScript.getFunctionCount(); i++) {
            notifyDebugger_r(context, debuggableScript.getFunction(i), str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = codegenClass;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.mozilla.javascript.Evaluator createCompiler() {
        /*
            r1 = this;
            int r0 = r1.optimizationLevel
            if (r0 < 0) goto L_0x000f
            java.lang.Class<?> r0 = codegenClass
            if (r0 == 0) goto L_0x000f
            java.lang.Object r0 = org.mozilla.javascript.Kit.newInstanceOrNull(r0)
            org.mozilla.javascript.Evaluator r0 = (org.mozilla.javascript.Evaluator) r0
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            if (r0 != 0) goto L_0x0016
            org.mozilla.javascript.Evaluator r0 = createInterpreter()
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Context.createCompiler():org.mozilla.javascript.Evaluator");
    }

    static Evaluator createInterpreter() {
        return (Evaluator) Kit.newInstanceOrNull(interpreterClass);
    }

    static String getSourcePositionFromStack(int[] iArr) {
        int lineNumber;
        Evaluator createInterpreter;
        Context currentContext = getCurrentContext();
        if (currentContext == null) {
            return null;
        }
        if (currentContext.lastInterpreterFrame != null && (createInterpreter = createInterpreter()) != null) {
            return createInterpreter.getSourcePositionFromStack(currentContext, iArr);
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (i < length) {
            StackTraceElement stackTraceElement = stackTrace[i];
            String fileName = stackTraceElement.getFileName();
            if (fileName == null || fileName.endsWith(".java") || (lineNumber = stackTraceElement.getLineNumber()) < 0) {
                i++;
            } else {
                iArr[0] = lineNumber;
                return fileName;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public RegExpProxy getRegExpProxy() {
        Class<?> classOrNull;
        if (this.regExpProxy == null && (classOrNull = Kit.classOrNull("org.mozilla.javascript.regexp.RegExpImpl")) != null) {
            this.regExpProxy = (RegExpProxy) Kit.newInstanceOrNull(classOrNull);
        }
        return this.regExpProxy;
    }

    /* access modifiers changed from: package-private */
    public final boolean isVersionECMA1() {
        int i = this.version;
        return i == 0 || i >= 130;
    }

    /* access modifiers changed from: package-private */
    public SecurityController getSecurityController() {
        SecurityController global2 = SecurityController.global();
        if (global2 != null) {
            return global2;
        }
        return this.securityController;
    }

    public final boolean isGeneratingDebugChanged() {
        return this.generatingDebugChanged;
    }

    public void addActivationName(String str) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (this.activationNames == null) {
            this.activationNames = new HashSet();
        }
        this.activationNames.add(str);
    }

    public final boolean isActivationNeeded(String str) {
        Set<String> set = this.activationNames;
        return set != null && set.contains(str);
    }

    public void removeActivationName(String str) {
        if (this.sealed) {
            onSealedMutation();
        }
        Set<String> set = this.activationNames;
        if (set != null) {
            set.remove(str);
        }
    }
}
