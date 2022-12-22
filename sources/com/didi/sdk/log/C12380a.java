package com.didi.sdk.log;

import android.text.TextUtils;
import android.util.Log;
import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didi.sdk.log.a */
/* compiled from: LoggerPrinter */
final class C12380a implements Printer {

    /* renamed from: a */
    private static final int f36447a = 4000;

    /* renamed from: b */
    private static final int f36448b = 4;

    /* renamed from: c */
    private static final int f36449c = 3;

    /* renamed from: d */
    private static final Settings f36450d = new Settings();

    /* renamed from: e */
    private static final char f36451e = '╔';

    /* renamed from: f */
    private static final char f36452f = '╚';

    /* renamed from: g */
    private static final char f36453g = '╟';

    /* renamed from: h */
    private static final char f36454h = '║';

    /* renamed from: i */
    private static final String f36455i = "════════════════════════════════════════════";

    /* renamed from: j */
    private static final String f36456j = "────────────────────────────────────────────";

    /* renamed from: k */
    private static final String f36457k = "╔════════════════════════════════════════════════════════════════════════════════════════";

    /* renamed from: l */
    private static final String f36458l = "╚════════════════════════════════════════════════════════════════════════════════════════";

    /* renamed from: m */
    private static final String f36459m = "╟────────────────────────────────────────────────────────────────────────────────────────";

    /* renamed from: n */
    private static final ThreadLocal<String> f36460n = new ThreadLocal<>();

    /* renamed from: o */
    private static final ThreadLocal<Integer> f36461o = new ThreadLocal<>();

    /* renamed from: p */
    private static String f36462p = Logger.DEFAULT_TAG;

    C12380a() {
    }

    public Settings init(String str) {
        if (str == null) {
            throw new NullPointerException("tag may not be null");
        } else if (str.trim().length() != 0) {
            f36462p = str;
            return f36450d;
        } else {
            throw new IllegalStateException("tag may not be empty");
        }
    }

    public Settings getSettings() {
        return f36450d;
    }

    /* renamed from: t */
    public Printer mo92485t(String str, int i) {
        if (str != null) {
            f36460n.set(str);
        }
        f36461o.set(Integer.valueOf(i));
        return this;
    }

    /* renamed from: d */
    public void mo92477d(String str, Object... objArr) {
        m25831a(3, str, objArr);
    }

    /* renamed from: e */
    public void mo92478e(String str, Object... objArr) {
        mo92479e((Throwable) null, str, objArr);
    }

    /* renamed from: e */
    public void mo92479e(Throwable th, String str, Object... objArr) {
        if (!(th == null || str == null)) {
            str = str + " : " + th.toString();
        }
        if (th != null && str == null) {
            str = th.toString();
        }
        if (str == null) {
            str = "No message/exception is set";
        }
        m25831a(6, str, objArr);
    }

    /* renamed from: w */
    public void mo92487w(String str, Object... objArr) {
        m25831a(5, str, objArr);
    }

    /* renamed from: i */
    public void mo92481i(String str, Object... objArr) {
        m25831a(4, str, objArr);
    }

    /* renamed from: v */
    public void mo92486v(String str, Object... objArr) {
        m25831a(2, str, objArr);
    }

    public void wtf(String str, Object... objArr) {
        m25831a(7, str, objArr);
    }

    public void json(String str) {
        if (TextUtils.isEmpty(str)) {
            mo92477d("Empty/Null json content", new Object[0]);
            return;
        }
        try {
            if (str.startsWith(Const.joLeft)) {
                mo92477d(new JSONObject(str).toString(4), new Object[0]);
            } else if (str.startsWith(Const.jaLeft)) {
                mo92477d(new JSONArray(str).toString(4), new Object[0]);
            }
        } catch (JSONException e) {
            mo92478e(e.getCause().getMessage() + "\n" + str, new Object[0]);
        }
    }

    public void xml(String str) {
        if (TextUtils.isEmpty(str)) {
            mo92477d("Empty/Null xml content", new Object[0]);
            return;
        }
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            newTransformer.transform(streamSource, streamResult);
            mo92477d(streamResult.getWriter().toString().replaceFirst(IMTextUtils.STREET_IMAGE_TAG_END, ">\n"), new Object[0]);
        } catch (TransformerException e) {
            mo92478e(e.getCause().getMessage() + "\n" + str, new Object[0]);
        }
    }

    public void normalLog(String str) {
        if (!TextUtils.isEmpty(str) && f36450d.getLogLevel() != LogLevel.NONE) {
            m25835b(3, m25825a(), str);
        }
    }

    /* renamed from: a */
    private synchronized void m25831a(int i, String str, Object... objArr) {
        f36450d.getLogLevel();
        LogLevel logLevel = LogLevel.NONE;
    }

    /* renamed from: a */
    private void m25828a(int i, String str) {
        m25835b(i, str, f36457k);
    }

    /* renamed from: a */
    private void m25829a(int i, String str, int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (f36450d.isShowThreadInfo()) {
            m25835b(i, str, "║ Thread: " + Thread.currentThread().getName());
            m25836c(i, str);
        }
        int a = m25824a(stackTrace) + f36450d.getMethodOffset();
        if (i2 + a > stackTrace.length) {
            i2 = (stackTrace.length - a) - 1;
        }
        String str2 = "";
        while (i2 > 0) {
            int i3 = i2 + a;
            if (i3 < stackTrace.length) {
                str2 = str2 + "   ";
                m25835b(i, str, "║ " + str2 + m25826a(stackTrace[i3].getClassName()) + "." + stackTrace[i3].getMethodName() + " " + " (" + stackTrace[i3].getFileName() + ":" + stackTrace[i3].getLineNumber() + ")");
            }
            i2--;
        }
    }

    /* renamed from: b */
    private void m25834b(int i, String str) {
        m25835b(i, str, f36458l);
    }

    /* renamed from: c */
    private void m25836c(int i, String str) {
        m25835b(i, str, f36459m);
    }

    /* renamed from: a */
    private void m25830a(int i, String str, String str2) {
        for (String str3 : str2.split(System.getProperty("line.separator"))) {
            m25835b(i, str, "║ " + str3);
        }
    }

    /* renamed from: b */
    private void m25835b(int i, String str, String str2) {
        String b = m25833b(str);
        if (i == 2) {
            SystemUtils.log(2, b, str2, (Throwable) null, "com.didi.sdk.log.LoggerPrinter", 318);
        } else if (i == 4) {
            SystemUtils.log(4, b, str2, (Throwable) null, "com.didi.sdk.log.LoggerPrinter", 315);
        } else if (i == 5) {
            SystemUtils.log(5, b, str2, (Throwable) null, "com.didi.sdk.log.LoggerPrinter", 321);
        } else if (i == 6) {
            SystemUtils.log(6, b, str2, (Throwable) null, "com.didi.sdk.log.LoggerPrinter", 312);
        } else if (i != 7) {
            SystemUtils.log(3, b, str2, (Throwable) null, "com.didi.sdk.log.LoggerPrinter", 329);
        } else {
            Log.wtf(b, str2);
        }
    }

    /* renamed from: a */
    private String m25826a(String str) {
        return str.substring(str.lastIndexOf(".") + 1);
    }

    /* renamed from: b */
    private String m25833b(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(f36462p, str)) {
            return f36462p;
        }
        return str;
    }

    /* renamed from: a */
    private String m25825a() {
        String str = f36460n.get();
        if (str == null) {
            return f36462p;
        }
        f36460n.remove();
        return str;
    }

    /* renamed from: a */
    private String m25827a(String str, Object... objArr) {
        return objArr.length == 0 ? str : String.format(str, objArr);
    }

    /* renamed from: b */
    private int m25832b() {
        Integer num = f36461o.get();
        int methodCount = f36450d.getMethodCount();
        if (num != null) {
            f36461o.remove();
            methodCount = num.intValue();
        }
        if (methodCount >= 0) {
            return methodCount;
        }
        throw new IllegalStateException("methodCount cannot be negative");
    }

    /* renamed from: a */
    private int m25824a(StackTraceElement[] stackTraceElementArr) {
        for (int i = 3; i < stackTraceElementArr.length; i++) {
            String className = stackTraceElementArr[i].getClassName();
            if (!className.equals(C12380a.class.getName()) && !className.equals(Logger.class.getName())) {
                return i - 1;
            }
        }
        return -1;
    }
}
