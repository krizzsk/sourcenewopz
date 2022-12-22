package org.mozilla.javascript.tools.shell;

import com.didi.sdk.onehotpatch.openapi.HotpatchStateConst;
import com.didi.sdk.sidebar.history.constant.HistoryRecordConstant;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextAction;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.ErrorReporter;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.ImporterTopLevel;
import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Synchronizer;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.Wrapper;
import org.mozilla.javascript.commonjs.module.Require;
import org.mozilla.javascript.commonjs.module.RequireBuilder;
import org.mozilla.javascript.commonjs.module.provider.SoftCachingModuleScriptProvider;
import org.mozilla.javascript.commonjs.module.provider.UrlModuleSourceProvider;
import org.mozilla.javascript.serialize.ScriptableInputStream;
import org.mozilla.javascript.serialize.ScriptableOutputStream;
import org.mozilla.javascript.tools.ToolErrorReporter;

public class Global extends ImporterTopLevel {
    static final long serialVersionUID = 4029130780977538005L;
    boolean attemptedJLineLoad;
    private ShellConsole console;
    private HashMap<String, String> doctestCanonicalizations;
    private PrintStream errStream;
    NativeArray history;
    private InputStream inStream;
    boolean initialized;
    private PrintStream outStream;
    private String[] prompts = {"js> ", "  > "};
    private QuitAction quitAction;
    private boolean sealedStdLib = false;

    public Global() {
    }

    public Global(Context context) {
        init(context);
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    public void initQuitAction(QuitAction quitAction2) {
        if (quitAction2 == null) {
            throw new IllegalArgumentException("quitAction is null");
        } else if (this.quitAction == null) {
            this.quitAction = quitAction2;
        } else {
            throw new IllegalArgumentException("The method is once-call.");
        }
    }

    public void init(ContextFactory contextFactory) {
        contextFactory.call(new ContextAction() {
            public Object run(Context context) {
                Global.this.init(context);
                return null;
            }
        });
    }

    public void init(Context context) {
        Context context2 = context;
        initStandardObjects(context2, this.sealedStdLib);
        defineFunctionProperties(new String[]{"defineClass", "deserialize", "doctest", "gc", "help", HotpatchStateConst.LOAD, "loadClass", "print", "quit", "readline", "readFile", "readUrl", "runCommand", "seal", "serialize", "spawn", "sync", "toint32", "version", "write"}, Global.class, 2);
        Environment.defineClass(this);
        defineProperty("environment", (Object) new Environment(this), 2);
        NativeArray nativeArray = (NativeArray) context2.newArray((Scriptable) this, 0);
        this.history = nativeArray;
        defineProperty(HistoryRecordConstant.VAMOS_HISTORY, (Object) nativeArray, 2);
        this.initialized = true;
    }

    public Require installRequire(Context context, List<String> list, boolean z) {
        RequireBuilder requireBuilder = new RequireBuilder();
        requireBuilder.setSandboxed(z);
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (String next : list) {
                try {
                    URI uri = new URI(next);
                    if (!uri.isAbsolute()) {
                        uri = new File(next).toURI().resolve("");
                    }
                    if (!uri.toString().endsWith("/")) {
                        uri = new URI(uri + "/");
                    }
                    arrayList.add(uri);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        requireBuilder.setModuleScriptProvider(new SoftCachingModuleScriptProvider(new UrlModuleSourceProvider(arrayList, (Iterable<URI>) null)));
        Require createRequire = requireBuilder.createRequire(context, this);
        createRequire.install(this);
        return createRequire;
    }

    public static void help(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        getInstance(function).getOut().println(ToolErrorReporter.getMessage("msg.help"));
    }

    /* renamed from: gc */
    public static void m3788gc(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        System.gc();
    }

    public static Object print(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        return doPrint(objArr, function, true);
    }

    public static Object write(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        return doPrint(objArr, function, false);
    }

    private static Object doPrint(Object[] objArr, Function function, boolean z) {
        PrintStream out = getInstance(function).getOut();
        for (int i = 0; i < objArr.length; i++) {
            if (i > 0) {
                out.print(" ");
            }
            out.print(Context.toString(objArr[i]));
        }
        if (z) {
            out.println();
        }
        return Context.getUndefinedValue();
    }

    public static void quit(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        Global instance = getInstance(function);
        if (instance.quitAction != null) {
            int i = 0;
            if (objArr.length != 0) {
                i = ScriptRuntime.toInt32(objArr[0]);
            }
            instance.quitAction.quit(context, i);
        }
    }

    public static double version(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        double languageVersion = (double) context.getLanguageVersion();
        if (objArr.length > 0) {
            context.setLanguageVersion((int) Context.toNumber(objArr[0]));
        }
        return languageVersion;
    }

    public static void load(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            String context2 = Context.toString(objArr[i]);
            try {
                Main.processFile(context, scriptable, context2);
                i++;
            } catch (IOException e) {
                throw Context.reportRuntimeError(ToolErrorReporter.getMessage("msg.couldnt.read.source", context2, e.getMessage()));
            } catch (VirtualMachineError e2) {
                e2.printStackTrace();
                throw Context.reportRuntimeError(ToolErrorReporter.getMessage("msg.uncaughtJSException", e2.toString()));
            }
        }
    }

    public static void defineClass(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> cls = getClass(objArr);
        if (Scriptable.class.isAssignableFrom(cls)) {
            ScriptableObject.defineClass(scriptable, cls);
            return;
        }
        throw reportRuntimeError("msg.must.implement.Scriptable");
    }

    public static void loadClass(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IllegalAccessException, InstantiationException {
        Class<?> cls = getClass(objArr);
        if (Script.class.isAssignableFrom(cls)) {
            ((Script) cls.newInstance()).exec(context, scriptable);
            return;
        }
        throw reportRuntimeError("msg.must.implement.Script");
    }

    private static Class<?> getClass(Object[] objArr) {
        if (objArr.length != 0) {
            Wrapper wrapper = objArr[0];
            if (wrapper instanceof Wrapper) {
                Object unwrap = wrapper.unwrap();
                if (unwrap instanceof Class) {
                    return (Class) unwrap;
                }
            }
            String context = Context.toString(objArr[0]);
            try {
                return Class.forName(context);
            } catch (ClassNotFoundException unused) {
                throw reportRuntimeError("msg.class.not.found", context);
            }
        } else {
            throw reportRuntimeError("msg.expected.string.arg");
        }
    }

    public static void serialize(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IOException {
        if (objArr.length >= 2) {
            Object obj = objArr[0];
            ScriptableOutputStream scriptableOutputStream = new ScriptableOutputStream(new FileOutputStream(Context.toString(objArr[1])), ScriptableObject.getTopLevelScope(scriptable));
            scriptableOutputStream.writeObject(obj);
            scriptableOutputStream.close();
            return;
        }
        throw Context.reportRuntimeError("Expected an object to serialize and a filename to write the serialization to");
    }

    public static Object deserialize(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IOException, ClassNotFoundException {
        if (objArr.length >= 1) {
            FileInputStream fileInputStream = new FileInputStream(Context.toString(objArr[0]));
            Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
            ScriptableInputStream scriptableInputStream = new ScriptableInputStream(fileInputStream, topLevelScope);
            Object readObject = scriptableInputStream.readObject();
            scriptableInputStream.close();
            return Context.toObject(readObject, topLevelScope);
        }
        throw Context.reportRuntimeError("Expected a filename to read the serialization from");
    }

    public String[] getPrompts(Context context) {
        if (ScriptableObject.hasProperty((Scriptable) this, "prompts")) {
            Object property = ScriptableObject.getProperty((Scriptable) this, "prompts");
            if (property instanceof Scriptable) {
                Scriptable scriptable = (Scriptable) property;
                if (ScriptableObject.hasProperty(scriptable, 0) && ScriptableObject.hasProperty(scriptable, 1)) {
                    Object property2 = ScriptableObject.getProperty(scriptable, 0);
                    if (property2 instanceof Function) {
                        property2 = ((Function) property2).call(context, this, scriptable, new Object[0]);
                    }
                    this.prompts[0] = Context.toString(property2);
                    Object property3 = ScriptableObject.getProperty(scriptable, 1);
                    if (property3 instanceof Function) {
                        property3 = ((Function) property3).call(context, this, scriptable, new Object[0]);
                    }
                    this.prompts[1] = Context.toString(property3);
                }
            }
        }
        return this.prompts;
    }

    public static Object doctest(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        if (objArr.length == 0) {
            return Boolean.FALSE;
        }
        String context2 = Context.toString(objArr[0]);
        Global instance = getInstance(function);
        return new Integer(instance.runDoctest(context, instance, context2, (String) null, 0));
    }

    public int runDoctest(Context context, Scriptable scriptable, String str, String str2, int i) {
        PrintStream printStream;
        StringBuilder sb;
        Context context2 = context;
        String str3 = str2;
        this.doctestCanonicalizations = new HashMap<>();
        String[] split = str.split("\r\n?|\n");
        String trim = this.prompts[0].trim();
        String trim2 = this.prompts[1].trim();
        int i2 = 0;
        while (i2 < split.length && !split[i2].trim().startsWith(trim)) {
            i2++;
        }
        int i3 = 0;
        while (i2 < split.length) {
            String substring = split[i2].trim().substring(trim.length());
            int i4 = i2 + 1;
            String str4 = substring + "\n";
            while (i4 < split.length && split[i4].trim().startsWith(trim2)) {
                str4 = (str4 + split[i4].trim().substring(trim2.length())) + "\n";
                i4++;
            }
            int i5 = i4;
            String str5 = "";
            while (i5 < split.length && !split[i5].trim().startsWith(trim)) {
                str5 = str5 + split[i5] + "\n";
                i5++;
            }
            PrintStream out = getOut();
            PrintStream err = getErr();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            setOut(new PrintStream(byteArrayOutputStream));
            setErr(new PrintStream(byteArrayOutputStream2));
            ByteArrayOutputStream byteArrayOutputStream3 = byteArrayOutputStream;
            ErrorReporter errorReporter = context.getErrorReporter();
            context2.setErrorReporter(new ToolErrorReporter(false, getErr()));
            int i6 = i3 + 1;
            PrintStream printStream2 = out;
            String str6 = str5;
            int i7 = i5;
            String[] strArr = split;
            String str7 = "";
            ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream3;
            String str8 = trim;
            ErrorReporter errorReporter2 = errorReporter;
            String str9 = str4;
            try {
                Object evaluateString = context.evaluateString(scriptable, str4, "doctest input", 1, (Object) null);
                String context3 = (evaluateString == Context.getUndefinedValue() || ((evaluateString instanceof Function) && str9.trim().startsWith("function"))) ? str7 : Context.toString(evaluateString);
                setOut(printStream2);
                setErr(err);
                context2.setErrorReporter(errorReporter2);
                sb = new StringBuilder();
                sb.append(context3);
            } catch (RhinoException e) {
                printStream = printStream2;
                ToolErrorReporter.reportException(context.getErrorReporter(), e);
                setOut(printStream);
                setErr(err);
                context2.setErrorReporter(errorReporter2);
                sb = new StringBuilder();
                sb.append(str7);
            } catch (Throwable th) {
                th = th;
                setOut(printStream);
                setErr(err);
                context2.setErrorReporter(errorReporter2);
                byteArrayOutputStream2.toString();
                byteArrayOutputStream4.toString();
                throw th;
            }
            sb.append(byteArrayOutputStream2.toString());
            sb.append(byteArrayOutputStream4.toString());
            String sb2 = sb.toString();
            String str10 = str6;
            if (!doctestOutputMatches(str10, sb2)) {
                String str11 = "doctest failure running:\n" + str9 + "expected: " + str10 + "actual: " + sb2 + "\n";
                if (str3 != null) {
                    throw Context.reportRuntimeError(str11, str3, (i + i7) - 1, (String) null, 0);
                }
                throw Context.reportRuntimeError(str11);
            }
            trim = str8;
            i2 = i7;
            split = strArr;
            i3 = i6;
        }
        return i3;
    }

    private boolean doctestOutputMatches(String str, String str2) {
        String trim = str.trim();
        String replace = str2.trim().replace("\r\n", "\n");
        if (trim.equals(replace)) {
            return true;
        }
        for (Map.Entry next : this.doctestCanonicalizations.entrySet()) {
            trim = trim.replace((CharSequence) next.getKey(), (CharSequence) next.getValue());
        }
        if (trim.equals(replace)) {
            return true;
        }
        Pattern compile = Pattern.compile("@[0-9a-fA-F]+");
        Matcher matcher = compile.matcher(trim);
        Matcher matcher2 = compile.matcher(replace);
        while (matcher.find() && matcher2.find() && matcher2.start() == matcher.start()) {
            int start = matcher.start();
            if (!trim.substring(0, start).equals(replace.substring(0, start))) {
                return false;
            }
            String group = matcher.group();
            String group2 = matcher2.group();
            String str3 = this.doctestCanonicalizations.get(group);
            if (str3 == null) {
                this.doctestCanonicalizations.put(group, group2);
                trim = trim.replace(group, group2);
            } else if (!group2.equals(str3)) {
                return false;
            }
            if (trim.equals(replace)) {
                return true;
            }
        }
        return false;
    }

    public static Object spawn(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        Runner runner;
        Scriptable parentScope = function.getParentScope();
        if (objArr.length != 0 && (objArr[0] instanceof Function)) {
            Object[] objArr2 = null;
            if (objArr.length > 1 && (objArr[1] instanceof Scriptable)) {
                objArr2 = context.getElements(objArr[1]);
            }
            if (objArr2 == null) {
                objArr2 = ScriptRuntime.emptyArgs;
            }
            runner = new Runner(parentScope, objArr[0], objArr2);
        } else if (objArr.length == 0 || !(objArr[0] instanceof Script)) {
            throw reportRuntimeError("msg.spawn.args");
        } else {
            runner = new Runner(parentScope, objArr[0]);
        }
        runner.factory = context.getFactory();
        Thread thread = new Thread(runner);
        thread.start();
        return thread;
    }

    public static Object sync(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        if (objArr.length < 1 || objArr.length > 2 || !(objArr[0] instanceof Function)) {
            throw reportRuntimeError("msg.sync.args");
        }
        Object obj = null;
        if (objArr.length == 2 && objArr[1] != Undefined.instance) {
            obj = objArr[1];
        }
        return new Synchronizer(objArr[0], obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: java.io.PrintStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: java.io.PrintStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v2, resolved type: java.io.PrintStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: java.io.PrintStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: java.io.OutputStream} */
    /* JADX WARNING: type inference failed for: r14v5 */
    /* JADX WARNING: type inference failed for: r14v6 */
    /* JADX WARNING: type inference failed for: r14v7 */
    /* JADX WARNING: type inference failed for: r14v8, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r14v9, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object runCommand(org.mozilla.javascript.Context r20, org.mozilla.javascript.Scriptable r21, java.lang.Object[] r22, org.mozilla.javascript.Function r23) throws java.io.IOException {
        /*
            r0 = r22
            int r1 = r0.length
            if (r1 == 0) goto L_0x01a1
            r2 = 0
            r3 = 1
            if (r1 != r3) goto L_0x000f
            r3 = r0[r2]
            boolean r3 = r3 instanceof org.mozilla.javascript.Scriptable
            if (r3 != 0) goto L_0x01a1
        L_0x000f:
            int r3 = r1 + -1
            r4 = r0[r3]
            boolean r4 = r4 instanceof org.mozilla.javascript.Scriptable
            java.lang.String r5 = "err"
            java.lang.String r6 = "output"
            if (r4 == 0) goto L_0x010c
            r3 = r0[r3]
            org.mozilla.javascript.Scriptable r3 = (org.mozilla.javascript.Scriptable) r3
            int r1 = r1 + -1
            java.lang.String r4 = "env"
            java.lang.Object r4 = org.mozilla.javascript.ScriptableObject.getProperty((org.mozilla.javascript.Scriptable) r3, (java.lang.String) r4)
            java.lang.Object r8 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r4 == r8) goto L_0x008d
            if (r4 != 0) goto L_0x0030
            java.lang.String[] r4 = new java.lang.String[r2]
            goto L_0x008e
        L_0x0030:
            boolean r8 = r4 instanceof org.mozilla.javascript.Scriptable
            if (r8 == 0) goto L_0x0086
            org.mozilla.javascript.Scriptable r4 = (org.mozilla.javascript.Scriptable) r4
            java.lang.Object[] r8 = org.mozilla.javascript.ScriptableObject.getPropertyIds(r4)
            int r9 = r8.length
            java.lang.String[] r9 = new java.lang.String[r9]
            r10 = 0
        L_0x003e:
            int r11 = r8.length
            if (r10 == r11) goto L_0x0084
            r11 = r8[r10]
            boolean r12 = r11 instanceof java.lang.String
            if (r12 == 0) goto L_0x004e
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = org.mozilla.javascript.ScriptableObject.getProperty((org.mozilla.javascript.Scriptable) r4, (java.lang.String) r11)
            goto L_0x0061
        L_0x004e:
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            java.lang.String r12 = java.lang.Integer.toString(r11)
            java.lang.Object r11 = org.mozilla.javascript.ScriptableObject.getProperty((org.mozilla.javascript.Scriptable) r4, (int) r11)
            r19 = r12
            r12 = r11
            r11 = r19
        L_0x0061:
            java.lang.Object r13 = org.mozilla.javascript.ScriptableObject.NOT_FOUND
            if (r12 != r13) goto L_0x0067
            java.lang.Object r12 = org.mozilla.javascript.Undefined.instance
        L_0x0067:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r11)
            r11 = 61
            r13.append(r11)
            java.lang.String r11 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r12)
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            r9[r10] = r11
            int r10 = r10 + 1
            goto L_0x003e
        L_0x0084:
            r4 = r9
            goto L_0x008e
        L_0x0086:
            java.lang.String r0 = "msg.runCommand.bad.env"
            java.lang.RuntimeException r0 = reportRuntimeError(r0)
            throw r0
        L_0x008d:
            r4 = 0
        L_0x008e:
            java.lang.String r8 = "dir"
            java.lang.Object r8 = org.mozilla.javascript.ScriptableObject.getProperty((org.mozilla.javascript.Scriptable) r3, (java.lang.String) r8)
            java.lang.Object r9 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r8 == r9) goto L_0x00a2
            java.io.File r9 = new java.io.File
            java.lang.String r8 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r8)
            r9.<init>(r8)
            goto L_0x00a3
        L_0x00a2:
            r9 = 0
        L_0x00a3:
            java.lang.String r8 = "input"
            java.lang.Object r8 = org.mozilla.javascript.ScriptableObject.getProperty((org.mozilla.javascript.Scriptable) r3, (java.lang.String) r8)
            java.lang.Object r10 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r8 == r10) goto L_0x00b2
            java.io.InputStream r8 = toInputStream(r8)
            goto L_0x00b3
        L_0x00b2:
            r8 = 0
        L_0x00b3:
            java.lang.Object r10 = org.mozilla.javascript.ScriptableObject.getProperty((org.mozilla.javascript.Scriptable) r3, (java.lang.String) r6)
            java.lang.Object r11 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r10 == r11) goto L_0x00c8
            java.io.OutputStream r11 = toOutputStream(r10)
            if (r11 != 0) goto L_0x00c9
            java.io.ByteArrayOutputStream r11 = new java.io.ByteArrayOutputStream
            r11.<init>()
            r12 = r11
            goto L_0x00ca
        L_0x00c8:
            r11 = 0
        L_0x00c9:
            r12 = 0
        L_0x00ca:
            java.lang.Object r13 = org.mozilla.javascript.ScriptableObject.getProperty((org.mozilla.javascript.Scriptable) r3, (java.lang.String) r5)
            java.lang.Object r14 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r13 == r14) goto L_0x00df
            java.io.OutputStream r14 = toOutputStream(r13)
            if (r14 != 0) goto L_0x00e0
            java.io.ByteArrayOutputStream r14 = new java.io.ByteArrayOutputStream
            r14.<init>()
            r15 = r14
            goto L_0x00e1
        L_0x00df:
            r14 = 0
        L_0x00e0:
            r15 = 0
        L_0x00e1:
            java.lang.String r2 = "args"
            java.lang.Object r2 = org.mozilla.javascript.ScriptableObject.getProperty((org.mozilla.javascript.Scriptable) r3, (java.lang.String) r2)
            java.lang.Object r7 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r2 == r7) goto L_0x00fe
            org.mozilla.javascript.Scriptable r7 = getTopLevelScope(r21)
            org.mozilla.javascript.Scriptable r2 = org.mozilla.javascript.Context.toObject(r2, r7)
            r7 = r20
            java.lang.Object[] r7 = r7.getElements(r2)
            r2 = r7
            r7 = r11
            r17 = r12
            goto L_0x0102
        L_0x00fe:
            r7 = r11
            r17 = r12
            r2 = 0
        L_0x0102:
            r11 = r8
            r19 = r13
            r13 = r3
            r3 = r10
            r10 = r9
            r9 = r4
            r4 = r19
            goto L_0x0118
        L_0x010c:
            r2 = 0
            r3 = 0
            r4 = 0
            r7 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = 0
        L_0x0118:
            org.mozilla.javascript.tools.shell.Global r8 = getInstance(r23)
            if (r7 != 0) goto L_0x0127
            if (r8 == 0) goto L_0x0125
            java.io.PrintStream r7 = r8.getOut()
            goto L_0x0127
        L_0x0125:
            java.io.PrintStream r7 = java.lang.System.out
        L_0x0127:
            r12 = r7
            if (r14 != 0) goto L_0x0134
            if (r8 == 0) goto L_0x0131
            java.io.PrintStream r7 = r8.getErr()
            goto L_0x0133
        L_0x0131:
            java.io.PrintStream r7 = java.lang.System.err
        L_0x0133:
            r14 = r7
        L_0x0134:
            if (r2 != 0) goto L_0x0138
            r7 = r1
            goto L_0x013a
        L_0x0138:
            int r7 = r2.length
            int r7 = r7 + r1
        L_0x013a:
            java.lang.String[] r8 = new java.lang.String[r7]
            r7 = 0
        L_0x013d:
            if (r7 == r1) goto L_0x014a
            r18 = r0[r7]
            java.lang.String r18 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r18)
            r8[r7] = r18
            int r7 = r7 + 1
            goto L_0x013d
        L_0x014a:
            if (r2 == 0) goto L_0x015d
            r0 = 0
        L_0x014d:
            int r7 = r2.length
            if (r0 == r7) goto L_0x015d
            int r7 = r1 + r0
            r16 = r2[r0]
            java.lang.String r16 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r16)
            r8[r7] = r16
            int r0 = r0 + 1
            goto L_0x014d
        L_0x015d:
            r0 = r13
            r13 = r14
            int r1 = runProcess(r8, r9, r10, r11, r12, r13)
            if (r17 == 0) goto L_0x017f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r3)
            r2.append(r3)
            java.lang.String r3 = r17.toString()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            org.mozilla.javascript.ScriptableObject.putProperty((org.mozilla.javascript.Scriptable) r0, (java.lang.String) r6, (java.lang.Object) r2)
        L_0x017f:
            if (r15 == 0) goto L_0x019b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r4)
            r2.append(r3)
            java.lang.String r3 = r15.toString()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            org.mozilla.javascript.ScriptableObject.putProperty((org.mozilla.javascript.Scriptable) r0, (java.lang.String) r5, (java.lang.Object) r2)
        L_0x019b:
            java.lang.Integer r0 = new java.lang.Integer
            r0.<init>(r1)
            return r0
        L_0x01a1:
            java.lang.String r0 = "msg.runCommand.bad.args"
            java.lang.RuntimeException r0 = reportRuntimeError(r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.tools.shell.Global.runCommand(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, java.lang.Object[], org.mozilla.javascript.Function):java.lang.Object");
    }

    public static void seal(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        int i = 0;
        while (i != objArr.length) {
            Object obj = objArr[i];
            if ((obj instanceof ScriptableObject) && obj != Undefined.instance) {
                i++;
            } else if (!(obj instanceof Scriptable) || obj == Undefined.instance) {
                throw reportRuntimeError("msg.shell.seal.not.object");
            } else {
                throw reportRuntimeError("msg.shell.seal.not.scriptable");
            }
        }
        for (int i2 = 0; i2 != objArr.length; i2++) {
            objArr[i2].sealObject();
        }
    }

    public static Object readFile(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IOException {
        if (objArr.length != 0) {
            String scriptRuntime = ScriptRuntime.toString(objArr[0]);
            String str = null;
            if (objArr.length >= 2) {
                str = ScriptRuntime.toString(objArr[1]);
            }
            return readUrl(scriptRuntime, str, true);
        }
        throw reportRuntimeError("msg.shell.readFile.bad.args");
    }

    public static Object readUrl(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IOException {
        if (objArr.length != 0) {
            String scriptRuntime = ScriptRuntime.toString(objArr[0]);
            String str = null;
            if (objArr.length >= 2) {
                str = ScriptRuntime.toString(objArr[1]);
            }
            return readUrl(scriptRuntime, str, false);
        }
        throw reportRuntimeError("msg.shell.readUrl.bad.args");
    }

    public static Object toint32(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        Object obj = objArr.length != 0 ? objArr[0] : Undefined.instance;
        if (obj instanceof Integer) {
            return obj;
        }
        return ScriptRuntime.wrapInt(ScriptRuntime.toInt32(obj));
    }

    private boolean loadJLine(Charset charset) {
        if (!this.attemptedJLineLoad) {
            this.attemptedJLineLoad = true;
            this.console = ShellConsole.getConsole(this, charset);
        }
        if (this.console != null) {
            return true;
        }
        return false;
    }

    public ShellConsole getConsole(Charset charset) {
        if (!loadJLine(charset)) {
            this.console = ShellConsole.getConsole(getIn(), getErr(), charset);
        }
        return this.console;
    }

    public InputStream getIn() {
        if (this.inStream == null && !this.attemptedJLineLoad && loadJLine(Charset.defaultCharset())) {
            this.inStream = this.console.getIn();
        }
        InputStream inputStream = this.inStream;
        return inputStream == null ? System.in : inputStream;
    }

    public void setIn(InputStream inputStream) {
        this.inStream = inputStream;
    }

    public PrintStream getOut() {
        PrintStream printStream = this.outStream;
        return printStream == null ? System.out : printStream;
    }

    public void setOut(PrintStream printStream) {
        this.outStream = printStream;
    }

    public PrintStream getErr() {
        PrintStream printStream = this.errStream;
        return printStream == null ? System.err : printStream;
    }

    public void setErr(PrintStream printStream) {
        this.errStream = printStream;
    }

    public void setSealedStdLib(boolean z) {
        this.sealedStdLib = z;
    }

    private static Global getInstance(Function function) {
        Scriptable parentScope = function.getParentScope();
        if (parentScope instanceof Global) {
            return (Global) parentScope;
        }
        throw reportRuntimeError("msg.bad.shell.function.scope", String.valueOf(parentScope));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(1:2)(1:3)|(2:5|6)(1:7)|8|(1:10)(1:11)|(1:13)(1:14)|15|16|(1:18)|(1:20)|(1:22)|23|24|25|26) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x005a */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005f A[Catch:{ InterruptedException -> 0x005a }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0064 A[Catch:{ InterruptedException -> 0x005a }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0069 A[Catch:{ InterruptedException -> 0x005a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int runProcess(java.lang.String[] r2, java.lang.String[] r3, java.io.File r4, java.io.InputStream r5, java.io.OutputStream r6, java.io.OutputStream r7) throws java.io.IOException {
        /*
            r0 = 0
            if (r3 != 0) goto L_0x000c
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()
            java.lang.Process r2 = r3.exec(r2, r0, r4)
            goto L_0x0014
        L_0x000c:
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()
            java.lang.Process r2 = r1.exec(r2, r3, r4)
        L_0x0014:
            if (r5 == 0) goto L_0x0024
            org.mozilla.javascript.tools.shell.PipeThread r3 = new org.mozilla.javascript.tools.shell.PipeThread     // Catch:{ all -> 0x0074 }
            r4 = 0
            java.io.OutputStream r1 = r2.getOutputStream()     // Catch:{ all -> 0x0074 }
            r3.<init>(r4, r5, r1)     // Catch:{ all -> 0x0074 }
            r3.start()     // Catch:{ all -> 0x0074 }
            goto L_0x002c
        L_0x0024:
            java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ all -> 0x0074 }
            r3.close()     // Catch:{ all -> 0x0074 }
            r3 = r0
        L_0x002c:
            r4 = 1
            if (r6 == 0) goto L_0x003c
            org.mozilla.javascript.tools.shell.PipeThread r5 = new org.mozilla.javascript.tools.shell.PipeThread     // Catch:{ all -> 0x0074 }
            java.io.InputStream r1 = r2.getInputStream()     // Catch:{ all -> 0x0074 }
            r5.<init>(r4, r1, r6)     // Catch:{ all -> 0x0074 }
            r5.start()     // Catch:{ all -> 0x0074 }
            goto L_0x0044
        L_0x003c:
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ all -> 0x0074 }
            r5.close()     // Catch:{ all -> 0x0074 }
            r5 = r0
        L_0x0044:
            if (r7 == 0) goto L_0x0053
            org.mozilla.javascript.tools.shell.PipeThread r0 = new org.mozilla.javascript.tools.shell.PipeThread     // Catch:{ all -> 0x0074 }
            java.io.InputStream r6 = r2.getErrorStream()     // Catch:{ all -> 0x0074 }
            r0.<init>(r4, r6, r7)     // Catch:{ all -> 0x0074 }
            r0.start()     // Catch:{ all -> 0x0074 }
            goto L_0x005a
        L_0x0053:
            java.io.InputStream r4 = r2.getErrorStream()     // Catch:{ all -> 0x0074 }
            r4.close()     // Catch:{ all -> 0x0074 }
        L_0x005a:
            r2.waitFor()     // Catch:{ InterruptedException -> 0x005a }
            if (r5 == 0) goto L_0x0062
            r5.join()     // Catch:{ InterruptedException -> 0x005a }
        L_0x0062:
            if (r3 == 0) goto L_0x0067
            r3.join()     // Catch:{ InterruptedException -> 0x005a }
        L_0x0067:
            if (r0 == 0) goto L_0x006c
            r0.join()     // Catch:{ InterruptedException -> 0x005a }
        L_0x006c:
            int r3 = r2.exitValue()     // Catch:{ all -> 0x0074 }
            r2.destroy()
            return r3
        L_0x0074:
            r3 = move-exception
            r2.destroy()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.tools.shell.Global.runProcess(java.lang.String[], java.lang.String[], java.io.File, java.io.InputStream, java.io.OutputStream, java.io.OutputStream):int");
    }

    static void pipe(boolean z, InputStream inputStream, OutputStream outputStream) throws IOException {
        int i;
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                if (!z) {
                    i = inputStream.read(bArr, 0, 4096);
                } else {
                    try {
                        i = inputStream.read(bArr, 0, 4096);
                    } catch (IOException unused) {
                    }
                }
                if (i < 0) {
                    break;
                } else if (z) {
                    outputStream.write(bArr, 0, i);
                    outputStream.flush();
                } else {
                    outputStream.write(bArr, 0, i);
                    outputStream.flush();
                }
            }
            if (z) {
            } else {
                outputStream.close();
            }
        } finally {
            if (z) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            } else {
                outputStream.close();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.io.InputStream toInputStream(java.lang.Object r4) throws java.io.IOException {
        /*
            boolean r0 = r4 instanceof org.mozilla.javascript.Wrapper
            r1 = 0
            if (r0 == 0) goto L_0x0040
            r0 = r4
            org.mozilla.javascript.Wrapper r0 = (org.mozilla.javascript.Wrapper) r0
            java.lang.Object r0 = r0.unwrap()
            boolean r2 = r0 instanceof java.io.InputStream
            if (r2 == 0) goto L_0x0016
            java.io.InputStream r0 = (java.io.InputStream) r0
            r3 = r1
            r1 = r0
            r0 = r3
            goto L_0x0041
        L_0x0016:
            boolean r2 = r0 instanceof byte[]
            if (r2 == 0) goto L_0x0026
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
            byte[] r0 = (byte[]) r0
            byte[] r0 = (byte[]) r0
            r2.<init>(r0)
            r0 = r1
            r1 = r2
            goto L_0x0041
        L_0x0026:
            boolean r2 = r0 instanceof java.io.Reader
            if (r2 == 0) goto L_0x0031
            java.io.Reader r0 = (java.io.Reader) r0
            java.lang.String r0 = readReader(r0)
            goto L_0x0041
        L_0x0031:
            boolean r2 = r0 instanceof char[]
            if (r2 == 0) goto L_0x0040
            java.lang.String r2 = new java.lang.String
            char[] r0 = (char[]) r0
            char[] r0 = (char[]) r0
            r2.<init>(r0)
            r0 = r2
            goto L_0x0041
        L_0x0040:
            r0 = r1
        L_0x0041:
            if (r1 != 0) goto L_0x0052
            if (r0 != 0) goto L_0x0049
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r4)
        L_0x0049:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            byte[] r4 = r0.getBytes()
            r1.<init>(r4)
        L_0x0052:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.tools.shell.Global.toInputStream(java.lang.Object):java.io.InputStream");
    }

    private static OutputStream toOutputStream(Object obj) {
        if (obj instanceof Wrapper) {
            Object unwrap = ((Wrapper) obj).unwrap();
            if (unwrap instanceof OutputStream) {
                return (OutputStream) unwrap;
            }
        }
        return null;
    }

    private static String readUrl(String str, String str2, boolean z) throws IOException {
        int i;
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        String contentType;
        InputStream inputStream2 = null;
        if (!z) {
            try {
                URLConnection openConnection = new URL(str).openConnection();
                inputStream = openConnection.getInputStream();
                i = openConnection.getContentLength();
                if (i <= 0) {
                    i = 1024;
                }
                if (str2 == null && (contentType = openConnection.getContentType()) != null) {
                    str2 = getCharCodingFromType(contentType);
                }
            } catch (Throwable th) {
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                throw th;
            }
        } else {
            File file = new File(str);
            if (!file.exists()) {
                throw new FileNotFoundException("File not found: " + str);
            } else if (file.canRead()) {
                long length = file.length();
                int i2 = (int) length;
                if (((long) i2) != length) {
                    throw new IOException("Too big file size: " + length);
                } else if (i2 == 0) {
                    return "";
                } else {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    i = i2;
                    inputStream = fileInputStream;
                }
            } else {
                throw new IOException("Cannot read file: " + str);
            }
        }
        if (str2 == null) {
            inputStreamReader = new InputStreamReader(inputStream);
        } else {
            inputStreamReader = new InputStreamReader(inputStream, str2);
        }
        String readReader = readReader(inputStreamReader, i);
        if (inputStream != null) {
            inputStream.close();
        }
        return readReader;
    }

    public static Object readline(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IOException {
        Global instance = getInstance(function);
        if (objArr.length > 0) {
            return instance.console.readLine(Context.toString(objArr[0]));
        }
        return instance.console.readLine();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004a A[LOOP:3: B:22:0x004a->B:24:0x0052, LOOP_START, PHI: r1 
      PHI: (r1v1 int) = (r1v0 int), (r1v2 int) binds: [B:21:0x0048, B:24:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getCharCodingFromType(java.lang.String r9) {
        /*
            r0 = 59
            int r0 = r9.indexOf(r0)
            if (r0 < 0) goto L_0x005a
            int r1 = r9.length()
        L_0x000c:
            int r0 = r0 + 1
            r8 = 32
            if (r0 == r1) goto L_0x0019
            char r2 = r9.charAt(r0)
            if (r2 > r8) goto L_0x0019
            goto L_0x000c
        L_0x0019:
            r3 = 1
            r4 = 0
            r7 = 7
            java.lang.String r2 = "charset"
            r5 = r9
            r6 = r0
            boolean r2 = r2.regionMatches(r3, r4, r5, r6, r7)
            if (r2 == 0) goto L_0x005a
            int r0 = r0 + 7
        L_0x0028:
            if (r0 == r1) goto L_0x0033
            char r2 = r9.charAt(r0)
            if (r2 > r8) goto L_0x0033
            int r0 = r0 + 1
            goto L_0x0028
        L_0x0033:
            if (r0 == r1) goto L_0x005a
            char r2 = r9.charAt(r0)
            r3 = 61
            if (r2 != r3) goto L_0x005a
        L_0x003d:
            int r0 = r0 + 1
            if (r0 == r1) goto L_0x0048
            char r2 = r9.charAt(r0)
            if (r2 > r8) goto L_0x0048
            goto L_0x003d
        L_0x0048:
            if (r0 == r1) goto L_0x005a
        L_0x004a:
            int r2 = r1 + -1
            char r2 = r9.charAt(r2)
            if (r2 > r8) goto L_0x0055
            int r1 = r1 + -1
            goto L_0x004a
        L_0x0055:
            java.lang.String r9 = r9.substring(r0, r1)
            return r9
        L_0x005a:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.tools.shell.Global.getCharCodingFromType(java.lang.String):java.lang.String");
    }

    private static String readReader(Reader reader) throws IOException {
        return readReader(reader, 4096);
    }

    private static String readReader(Reader reader, int i) throws IOException {
        char[] cArr = new char[i];
        int i2 = 0;
        while (true) {
            int read = reader.read(cArr, i2, cArr.length - i2);
            if (read < 0) {
                return new String(cArr, 0, i2);
            }
            i2 += read;
            if (i2 == cArr.length) {
                char[] cArr2 = new char[(cArr.length * 2)];
                System.arraycopy(cArr, 0, cArr2, 0, i2);
                cArr = cArr2;
            }
        }
    }

    static RuntimeException reportRuntimeError(String str) {
        return Context.reportRuntimeError(ToolErrorReporter.getMessage(str));
    }

    static RuntimeException reportRuntimeError(String str, String str2) {
        return Context.reportRuntimeError(ToolErrorReporter.getMessage(str, str2));
    }
}
