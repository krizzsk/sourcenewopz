package org.xidea.lite;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xidea.p087el.json.JSONDecoder;

public class TemplateEngine {
    private static final Log log = LogFactory.getLog(TemplateEngine.class);
    protected URI base;
    protected Map<String, Template> templateMap = new WeakHashMap();

    protected TemplateEngine() {
    }

    public TemplateEngine(URI uri) {
        this.base = uri.normalize();
    }

    public void render(String str, Object obj, Writer writer) throws IOException {
        getTemplate(str).render(obj, writer);
        writer.flush();
    }

    public Template getTemplate(String str) throws IOException {
        Template template = this.templateMap.get(str);
        if (template != null) {
            return template;
        }
        Template createTemplate = createTemplate(str);
        this.templateMap.put(str, createTemplate);
        return createTemplate;
    }

    public void clear(String str) {
        this.templateMap.remove(str);
    }

    /* access modifiers changed from: protected */
    public Template createTemplate(String str) throws IOException {
        return new Template((List) ((List) JSONDecoder.decode(getLiteCode(str))).get(1));
    }

    /* access modifiers changed from: protected */
    public String getLiteCode(String str) throws IOException {
        InputStream inputStream;
        URI resolve = this.base.resolve(str.substring(1));
        if ("classpath".equals(this.base.getScheme())) {
            inputStream = TemplateEngine.class.getResourceAsStream(this.base.normalize().getPath());
        } else {
            inputStream = resolve.toURL().openStream();
        }
        return loadText(inputStream);
    }

    /* access modifiers changed from: protected */
    public String loadText(InputStream inputStream) throws IOException {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[256];
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read < 0) {
                    return sb.toString();
                }
                sb.append(cArr, 0, read);
            }
        } finally {
            inputStream.close();
        }
    }
}
