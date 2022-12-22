package com.didi.global.globalgenerickit.template.yoga;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.didi.global.globalgenerickit.CommonEventListener;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globalgenerickit.GGKViewBinder;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class CDNTemplateBinder implements GGKViewBinder {
    private Object javascriptValue;
    private int leftAndRightMargin = 0;
    private ScriptableObject scope;

    public void bind(View view, GGKData gGKData) {
    }

    public void onCDNCached(XMLCacheEntity xMLCacheEntity) {
    }

    public void setJavascriptValue(Object obj) {
        this.javascriptValue = obj;
    }

    public ScriptableObject getJSScope() {
        return this.scope;
    }

    public View createView(Context context, GGKData gGKData) {
        if (TextUtils.isEmpty(gGKData.getCdn())) {
            return null;
        }
        CDNCacheManager instance = CDNCacheManager.getInstance(context);
        XMLCacheEntity xMLCacheEntity = instance.get(gGKData.getCdn());
        if (xMLCacheEntity == null) {
            instance.tryCache(gGKData, this);
            return null;
        }
        XCardNode parse = new TemplateParser().parse(xMLCacheEntity.element, gGKData.getData());
        if (parse == null) {
            return null;
        }
        XCardRenderer xCardRenderer = new XCardRenderer(context, this.leftAndRightMargin, gGKData);
        xCardRenderer.bindEventListener(gGKData.getEventListener());
        View render = xCardRenderer.render(parse);
        if (!TextUtils.isEmpty(xMLCacheEntity.script)) {
            org.mozilla.javascript.Context enter = org.mozilla.javascript.Context.enter();
            ScriptableObject initSafeStandardObjects = enter.initSafeStandardObjects();
            this.scope = initSafeStandardObjects;
            ScriptableObject.putProperty((Scriptable) this.scope, "xpJsTool", org.mozilla.javascript.Context.javaToJS(this.javascriptValue, initSafeStandardObjects));
            enter.evaluateString(this.scope, xMLCacheEntity.script, gGKData.getTemplate(), 1, (Object) null);
        }
        return render;
    }

    public EventListener createEventListener(GGKData gGKData) {
        return new CommonEventListener(gGKData);
    }
}
