package com.didi.map.utils.logger;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didi.map.utils.logger.a */
/* compiled from: LoggerPrinter */
class C10237a implements Printer {

    /* renamed from: a */
    private static final int f29062a = 2;

    /* renamed from: b */
    private final ThreadLocal<String> f29063b = new ThreadLocal<>();

    /* renamed from: c */
    private final List<LogAdapter> f29064c = new ArrayList();

    C10237a() {
    }

    /* renamed from: t */
    public Printer mo79954t(String str) {
        if (str != null) {
            this.f29063b.set(str);
        }
        return this;
    }

    /* renamed from: d */
    public void mo79948d(String str, Object... objArr) {
        m20463a(3, (Throwable) null, str, objArr);
    }

    /* renamed from: d */
    public void mo79947d(Object obj) {
        m20463a(3, (Throwable) null, C10238b.m20473a(obj), new Object[0]);
    }

    /* renamed from: e */
    public void mo79949e(String str, Object... objArr) {
        mo79950e((Throwable) null, str, objArr);
    }

    /* renamed from: e */
    public void mo79950e(Throwable th, String str, Object... objArr) {
        m20463a(6, th, str, objArr);
    }

    /* renamed from: w */
    public void mo79956w(String str, Object... objArr) {
        m20463a(5, (Throwable) null, str, objArr);
    }

    /* renamed from: i */
    public void mo79951i(String str, Object... objArr) {
        m20463a(4, (Throwable) null, str, objArr);
    }

    /* renamed from: v */
    public void mo79955v(String str, Object... objArr) {
        m20463a(2, (Throwable) null, str, objArr);
    }

    public void wtf(String str, Object... objArr) {
        m20463a(7, (Throwable) null, str, objArr);
    }

    public void json(String str) {
        if (C10238b.m20475a((CharSequence) str)) {
            mo79947d("Empty/Null json content");
            return;
        }
        try {
            String trim = str.trim();
            if (trim.startsWith(Const.joLeft)) {
                mo79947d(new JSONObject(trim).toString(2));
            } else if (trim.startsWith(Const.jaLeft)) {
                mo79947d(new JSONArray(trim).toString(2));
            } else {
                mo79949e("Invalid Json", new Object[0]);
            }
        } catch (JSONException unused) {
            mo79949e("Invalid Json", new Object[0]);
        }
    }

    public void xml(String str) {
        if (C10238b.m20475a((CharSequence) str)) {
            mo79947d("Empty/Null xml content");
            return;
        }
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            newTransformer.transform(streamSource, streamResult);
            mo79947d(streamResult.getWriter().toString().replaceFirst(IMTextUtils.STREET_IMAGE_TAG_END, ">\n"));
        } catch (TransformerException unused) {
            mo79949e("Invalid xml", new Object[0]);
        }
    }

    public synchronized void log(int i, String str, String str2, Throwable th) {
        if (!(th == null || str2 == null)) {
            str2 = str2 + " : " + C10238b.m20474a(th);
        }
        if (th != null && str2 == null) {
            str2 = C10238b.m20474a(th);
        }
        if (C10238b.m20475a((CharSequence) str2)) {
            str2 = "Empty/NULL log message";
        }
        for (LogAdapter next : this.f29064c) {
            if (next.isLoggable(i, str)) {
                next.log(i, str, str2);
            }
        }
    }

    public void clearLogAdapters() {
        this.f29064c.clear();
    }

    public void addAdapter(LogAdapter logAdapter) {
        this.f29064c.add(C10238b.m20477b(logAdapter));
    }

    /* renamed from: a */
    private synchronized void m20463a(int i, Throwable th, String str, Object... objArr) {
        C10238b.m20477b(str);
        log(i, m20461a(), m20462a(str, objArr), th);
    }

    /* renamed from: a */
    private String m20461a() {
        String str = this.f29063b.get();
        if (str == null) {
            return null;
        }
        this.f29063b.remove();
        return str;
    }

    /* renamed from: a */
    private String m20462a(String str, Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(str, objArr);
    }
}
