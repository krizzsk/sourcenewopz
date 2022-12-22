package com.didi.greatwall.protocol;

import com.didi.greatwall.util.log.GLogger;
import java.util.HashMap;
import org.json.JSONObject;

public class ComponentBridge {

    /* renamed from: a */
    private static final ComponentBridge f22967a = new ComponentBridge();

    /* renamed from: b */
    private GLogger f22968b = GLogger.getLogger();

    /* renamed from: c */
    private HashMap<String, ComponentListener> f22969c = new HashMap<>();

    public static ComponentBridge getInstance() {
        return f22967a;
    }

    private ComponentBridge() {
    }

    public synchronized void executeFinish(String str, int i, JSONObject jSONObject) {
        ComponentListener componentListener = this.f22969c.get(str);
        GLogger gLogger = this.f22968b;
        gLogger.info("component [" + str + "] execute finish,lis = " + componentListener + ",jsonObject = " + jSONObject);
        m16525a(str);
        if (componentListener != null) {
            componentListener.onFinish(i, jSONObject);
        }
    }

    public synchronized void addExecuteCallback(String str, ComponentListener componentListener) {
        GLogger gLogger = this.f22968b;
        gLogger.info("addExecuteCallback componentID = " + str + ",listener = " + componentListener);
        this.f22969c.put(str, componentListener);
    }

    /* renamed from: a */
    private synchronized void m16525a(String str) {
        GLogger gLogger = this.f22968b;
        gLogger.info("removeExecuteCallback componentID = " + str + ",listener = " + this.f22969c.remove(str));
    }
}
