package org.mozilla.javascript;

import java.io.CharArrayWriter;
import java.io.FilenameFilter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.osgi.framework.VersionRange;

public abstract class RhinoException extends RuntimeException {
    private static final Pattern JAVA_STACK_PATTERN = Pattern.compile("_c_(.*)_\\d+");
    static final long serialVersionUID = 1883500631321581169L;
    private static StackStyle stackStyle;
    private int columnNumber;
    int[] interpreterLineData;
    Object interpreterStackInfo;
    private int lineNumber;
    private String lineSource;
    private String sourceName;

    static {
        stackStyle = StackStyle.RHINO;
        String property = System.getProperty("rhino.stack.style");
        if (property == null) {
            return;
        }
        if ("Rhino".equalsIgnoreCase(property)) {
            stackStyle = StackStyle.RHINO;
        } else if ("Mozilla".equalsIgnoreCase(property)) {
            stackStyle = StackStyle.MOZILLA;
        } else if ("V8".equalsIgnoreCase(property)) {
            stackStyle = StackStyle.V8;
        }
    }

    RhinoException() {
        Evaluator createInterpreter = Context.createInterpreter();
        if (createInterpreter != null) {
            createInterpreter.captureStackInfo(this);
        }
    }

    RhinoException(String str) {
        super(str);
        Evaluator createInterpreter = Context.createInterpreter();
        if (createInterpreter != null) {
            createInterpreter.captureStackInfo(this);
        }
    }

    public final String getMessage() {
        String details = details();
        if (this.sourceName == null || this.lineNumber <= 0) {
            return details;
        }
        StringBuilder sb = new StringBuilder(details);
        sb.append(" (");
        String str = this.sourceName;
        if (str != null) {
            sb.append(str);
        }
        if (this.lineNumber > 0) {
            sb.append('#');
            sb.append(this.lineNumber);
        }
        sb.append(VersionRange.RIGHT_OPEN);
        return sb.toString();
    }

    public String details() {
        return super.getMessage();
    }

    public final String sourceName() {
        return this.sourceName;
    }

    public final void initSourceName(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        } else if (this.sourceName == null) {
            this.sourceName = str;
        } else {
            throw new IllegalStateException();
        }
    }

    public final int lineNumber() {
        return this.lineNumber;
    }

    public final void initLineNumber(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.valueOf(i));
        } else if (this.lineNumber <= 0) {
            this.lineNumber = i;
        } else {
            throw new IllegalStateException();
        }
    }

    public final int columnNumber() {
        return this.columnNumber;
    }

    public final void initColumnNumber(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.valueOf(i));
        } else if (this.columnNumber <= 0) {
            this.columnNumber = i;
        } else {
            throw new IllegalStateException();
        }
    }

    public final String lineSource() {
        return this.lineSource;
    }

    public final void initLineSource(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        } else if (this.lineSource == null) {
            this.lineSource = str;
        } else {
            throw new IllegalStateException();
        }
    }

    /* access modifiers changed from: package-private */
    public final void recordErrorOrigin(String str, int i, String str2, int i2) {
        if (i == -1) {
            i = 0;
        }
        if (str != null) {
            initSourceName(str);
        }
        if (i != 0) {
            initLineNumber(i);
        }
        if (str2 != null) {
            initLineSource(str2);
        }
        if (i2 != 0) {
            initColumnNumber(i2);
        }
    }

    private String generateStackTrace() {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        super.printStackTrace(new PrintWriter(charArrayWriter));
        String charArrayWriter2 = charArrayWriter.toString();
        Evaluator createInterpreter = Context.createInterpreter();
        if (createInterpreter != null) {
            return createInterpreter.getPatchedStack(this, charArrayWriter2);
        }
        return null;
    }

    public String getScriptStackTrace() {
        return getScriptStackTrace(-1, (String) null);
    }

    public String getScriptStackTrace(int i, String str) {
        return formatStackTrace(getScriptStack(i, str), details());
    }

    static String formatStackTrace(ScriptStackElement[] scriptStackElementArr, String str) {
        StringBuilder sb = new StringBuilder();
        String systemProperty = SecurityUtilities.getSystemProperty("line.separator");
        if (stackStyle == StackStyle.V8 && !"null".equals(str)) {
            sb.append(str);
            sb.append(systemProperty);
        }
        for (ScriptStackElement scriptStackElement : scriptStackElementArr) {
            int i = C28911.$SwitchMap$org$mozilla$javascript$StackStyle[stackStyle.ordinal()];
            if (i == 1) {
                scriptStackElement.renderMozillaStyle(sb);
            } else if (i == 2) {
                scriptStackElement.renderV8Style(sb);
            } else if (i == 3) {
                scriptStackElement.renderJavaStyle(sb);
            }
            sb.append(systemProperty);
        }
        return sb.toString();
    }

    /* renamed from: org.mozilla.javascript.RhinoException$1 */
    static /* synthetic */ class C28911 {
        static final /* synthetic */ int[] $SwitchMap$org$mozilla$javascript$StackStyle;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.mozilla.javascript.StackStyle[] r0 = org.mozilla.javascript.StackStyle.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$mozilla$javascript$StackStyle = r0
                org.mozilla.javascript.StackStyle r1 = org.mozilla.javascript.StackStyle.MOZILLA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$mozilla$javascript$StackStyle     // Catch:{ NoSuchFieldError -> 0x001d }
                org.mozilla.javascript.StackStyle r1 = org.mozilla.javascript.StackStyle.V8     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$mozilla$javascript$StackStyle     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.mozilla.javascript.StackStyle r1 = org.mozilla.javascript.StackStyle.RHINO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.RhinoException.C28911.<clinit>():void");
        }
    }

    @Deprecated
    public String getScriptStackTrace(FilenameFilter filenameFilter) {
        return getScriptStackTrace();
    }

    public ScriptStackElement[] getScriptStack() {
        return getScriptStack(-1, (String) null);
    }

    public ScriptStackElement[] getScriptStack(int i, String str) {
        int i2 = i;
        String str2 = str;
        ArrayList arrayList = new ArrayList();
        ScriptStackElement[][] scriptStackElementArr = null;
        if (this.interpreterStackInfo != null) {
            Evaluator createInterpreter = Context.createInterpreter();
            if (createInterpreter instanceof Interpreter) {
                scriptStackElementArr = ((Interpreter) createInterpreter).getScriptStackElements(this);
            }
        }
        StackTraceElement[] stackTrace = getStackTrace();
        boolean z = str2 == null;
        int i3 = 0;
        int i4 = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            String fileName = stackTraceElement.getFileName();
            if (stackTraceElement.getMethodName().startsWith("_c_") && stackTraceElement.getLineNumber() > -1 && fileName != null && !fileName.endsWith(".java")) {
                String methodName = stackTraceElement.getMethodName();
                Matcher matcher = JAVA_STACK_PATTERN.matcher(methodName);
                String group = ("_c_script_0".equals(methodName) || !matcher.find()) ? null : matcher.group(1);
                if (!z && str2.equals(group)) {
                    z = true;
                } else if (z && (i2 < 0 || i4 < i2)) {
                    arrayList.add(new ScriptStackElement(fileName, group, stackTraceElement.getLineNumber()));
                    i4++;
                }
            } else if ("org.mozilla.javascript.Interpreter".equals(stackTraceElement.getClassName()) && "interpretLoop".equals(stackTraceElement.getMethodName()) && scriptStackElementArr != null && scriptStackElementArr.length > i3) {
                int i5 = i3 + 1;
                for (ScriptStackElement scriptStackElement : scriptStackElementArr[i3]) {
                    if (!z && str2.equals(scriptStackElement.functionName)) {
                        z = true;
                    } else if (z && (i2 < 0 || i4 < i2)) {
                        arrayList.add(scriptStackElement);
                        i4++;
                    }
                }
                i3 = i5;
            }
        }
        return (ScriptStackElement[]) arrayList.toArray(new ScriptStackElement[arrayList.size()]);
    }

    public void printStackTrace(PrintWriter printWriter) {
        if (this.interpreterStackInfo == null) {
            super.printStackTrace(printWriter);
        } else {
            printWriter.print(generateStackTrace());
        }
    }

    public void printStackTrace(PrintStream printStream) {
        if (this.interpreterStackInfo == null) {
            super.printStackTrace(printStream);
        } else {
            printStream.print(generateStackTrace());
        }
    }

    public static boolean usesMozillaStackStyle() {
        return stackStyle == StackStyle.MOZILLA;
    }

    public static void useMozillaStackStyle(boolean z) {
        stackStyle = z ? StackStyle.MOZILLA : StackStyle.RHINO;
    }

    public static void setStackStyle(StackStyle stackStyle2) {
        stackStyle = stackStyle2;
    }

    public static StackStyle getStackStyle() {
        return stackStyle;
    }
}
