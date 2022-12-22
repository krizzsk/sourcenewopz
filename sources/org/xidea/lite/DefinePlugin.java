package org.xidea.lite;

import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xidea.p087el.Invocable;
import org.xidea.p087el.ValueStack;

public class DefinePlugin implements Invocable, Plugin {
    private static Log log = LogFactory.getLog(DefinePlugin.class);
    private Object[] children;
    private Object instance;
    private String name;
    private String[] params;
    private Template template;
    private String type;

    public void initialize(Template template2, Object[] objArr) {
        this.template = template2;
        this.children = objArr;
        String str = this.type;
        if (str != null) {
            try {
                this.instance = Class.forName(str).newInstance();
            } catch (Exception e) {
                Log log2 = log;
                log2.warn("无法装载扩展：" + this.type, e);
            }
        }
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setParams(List<String> list) {
        this.params = (String[]) list.toArray(new String[list.size()]);
    }

    public void setType(String str) {
        this.type = str;
    }

    public void execute(ValueStack valueStack, Writer writer) {
        Object obj = this.instance;
        if (obj == null) {
            valueStack.put(this.name, this);
        } else {
            valueStack.put(this.name, obj);
        }
    }

    public Object invoke(Object obj, Object... objArr) throws Exception {
        StringWriter stringWriter = new StringWriter();
        apply(obj, stringWriter, objArr);
        return stringWriter.toString();
    }

    public void apply(Object obj, Writer writer, Object... objArr) {
        int min = Math.min(objArr.length, this.params.length);
        Context context = new Context((Object) null);
        while (true) {
            int i = min - 1;
            if (min <= 0) {
                this.template.renderList(context, this.children, writer);
                return;
            } else {
                context.put(this.params[i], objArr[i]);
                min = i;
            }
        }
    }
}
