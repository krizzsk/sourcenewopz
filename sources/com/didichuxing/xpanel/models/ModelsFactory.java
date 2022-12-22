package com.didichuxing.xpanel.models;

import android.content.Context;
import com.didichuxing.xpanel.util.LogcatUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class ModelsFactory {

    /* renamed from: a */
    private static final String f49576a = "ModelsFactory";

    /* renamed from: b */
    private Map<String, Class<? extends IXPanelModelView>> f49577b;

    /* renamed from: c */
    private Map<String, Class<? extends IXPanelModel>> f49578c;

    /* renamed from: d */
    private Map<String, Integer> f49579d;

    /* renamed from: e */
    private List<String> f49580e;

    private ModelsFactory() {
        this.f49577b = Collections.synchronizedMap(new LinkedHashMap());
        this.f49578c = Collections.synchronizedMap(new LinkedHashMap());
        this.f49579d = Collections.synchronizedMap(new LinkedHashMap());
        this.f49580e = Collections.synchronizedList(new ArrayList());
    }

    /* renamed from: a */
    private void m35790a(String str, Class cls) {
        this.f49577b.put(str, cls);
    }

    /* renamed from: b */
    private void m35793b(String str, Class cls) {
        this.f49578c.put(str, cls);
    }

    /* renamed from: a */
    private void m35791a(String str, Integer num) {
        this.f49579d.put(str, num);
    }

    public IXPanelModelView newTemplateView(Context context, int i) {
        try {
            IXPanelModelView iXPanelModelView = (IXPanelModelView) this.f49577b.get(this.f49580e.get(i)).newInstance();
            iXPanelModelView.init(context);
            return iXPanelModelView;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public IXPanelModel newTemplateData(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Class cls = this.f49578c.get(str);
            if (cls == null) {
                return null;
            }
            IXPanelModel iXPanelModel = (IXPanelModel) cls.newInstance();
            if (iXPanelModel.defaultParse(jSONObject, jSONObject2)) {
                return iXPanelModel;
            }
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    private int m35789a(String str) {
        return this.f49580e.indexOf(str);
    }

    public static int getTemplateType(String str) {
        return get().m35789a(str);
    }

    public void register(String str, Class cls, Class cls2, Integer num) {
        if (m35792a(str, cls, cls2, num)) {
            this.f49580e.add(str);
            m35790a(str, cls);
            m35793b(str, cls2);
            m35791a(str, num);
        }
    }

    /* renamed from: a */
    private boolean m35792a(String str, Class cls, Class cls2, Integer num) {
        if (this.f49580e.contains(str)) {
            LogcatUtil.m35797w(f49576a, "template:" + str + ",value:" + num + " has been register,view：" + cls.getName() + ",Data:" + cls2.getName());
            return false;
        } else if (this.f49577b.containsKey(str)) {
            LogcatUtil.m35797w(f49576a, "View template:" + str + ",Class:" + cls.getName() + " has been register");
            return false;
        } else if (this.f49578c.containsKey(str)) {
            LogcatUtil.m35797w(f49576a, "Data template:" + str + ",Class:" + cls.getName() + " has been register");
            return false;
        } else if (!this.f49579d.containsKey(str)) {
            return true;
        } else {
            LogcatUtil.m35797w(f49576a, "ID template:" + str + ",value:" + num + " has been register");
            return false;
        }
    }

    public static ModelsFactory get() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final ModelsFactory INSTANCE = new ModelsFactory();

        private Holder() {
        }
    }
}
