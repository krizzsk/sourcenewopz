package com.didi.drouter.store;

import android.content.Intent;
import android.net.Uri;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.IRouterInterceptor;
import com.didi.drouter.service.IFeatureMatcher;
import com.didi.drouter.utils.TextUtils;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RouterMeta {
    public static int ACTIVITY = 1;
    public static int FRAGMENT = 2;
    public static int HANDLER = 4;
    public static int INTERCEPTOR = 5;
    public static int SERVICE = 6;
    public static int VIEW = 3;

    /* renamed from: a */
    private int f19231a;

    /* renamed from: b */
    private Class<?> f19232b;

    /* renamed from: c */
    private int f19233c;

    /* renamed from: d */
    private boolean f19234d;

    /* renamed from: e */
    private String f19235e;

    /* renamed from: f */
    private String f19236f;

    /* renamed from: g */
    private String f19237g;

    /* renamed from: h */
    private String f19238h;

    /* renamed from: i */
    private Class<? extends IRouterInterceptor>[] f19239i;

    /* renamed from: j */
    private int f19240j;

    /* renamed from: k */
    private boolean f19241k;

    /* renamed from: l */
    private Intent f19242l;

    /* renamed from: m */
    private RouterKey f19243m;

    /* renamed from: n */
    private IRouterHandler f19244n;

    /* renamed from: o */
    private String f19245o;

    /* renamed from: p */
    private IFeatureMatcher<?> f19246p;

    /* renamed from: q */
    private ServiceKey f19247q;

    /* renamed from: r */
    private Object f19248r;

    /* renamed from: s */
    private boolean f19249s;

    /* renamed from: t */
    private int f19250t;

    /* renamed from: u */
    private Map<String, List<String>> f19251u;

    private RouterMeta(int i) {
        this.f19231a = i;
    }

    public static RouterMeta build(int i) {
        return new RouterMeta(i);
    }

    public RouterMeta assembleRouter(String str, String str2, String str3, String str4, Class<? extends IRouterInterceptor>[] clsArr, int i, int i2, boolean z) {
        this.f19235e = str;
        this.f19236f = str2;
        this.f19237g = str3;
        this.f19238h = str4;
        this.f19239i = clsArr;
        this.f19240j = i;
        this.f19233c = i2;
        this.f19241k = z;
        return this;
    }

    public RouterMeta assembleRouter(String str, String str2, String str3, Class<?> cls, Class<? extends IRouterInterceptor>[] clsArr, int i, int i2, boolean z) {
        this.f19235e = str;
        this.f19236f = str2;
        this.f19237g = str3;
        this.f19232b = cls;
        this.f19239i = clsArr;
        this.f19240j = i;
        this.f19233c = i2;
        this.f19241k = z;
        return this;
    }

    public RouterMeta assembleRouter(Intent intent) {
        this.f19242l = intent;
        return this;
    }

    public void setHandler(RouterKey routerKey, IRouterHandler iRouterHandler) {
        this.f19243m = routerKey;
        this.f19244n = iRouterHandler;
        this.f19234d = true;
    }

    public RouterMeta assembleService(Class<?> cls, String str, IFeatureMatcher<?> iFeatureMatcher, int i, int i2) {
        this.f19232b = cls;
        this.f19245o = str;
        this.f19246p = iFeatureMatcher;
        this.f19233c = i;
        this.f19250t = i2;
        return this;
    }

    public void setService(ServiceKey serviceKey, Object obj) {
        this.f19247q = serviceKey;
        this.f19248r = obj;
        this.f19234d = true;
    }

    public RouterMeta assembleInterceptor(Class<? extends IRouterInterceptor> cls, int i, boolean z, int i2) {
        this.f19232b = cls;
        this.f19233c = i;
        this.f19249s = z;
        this.f19250t = i2;
        return this;
    }

    public int getRouterType() {
        return this.f19231a;
    }

    public String getActivityClassName() {
        return this.f19238h;
    }

    public Class<?> getTargetClass() {
        return this.f19232b;
    }

    public String getSimpleClassName() {
        String str = this.f19238h;
        if (str != null) {
            return str.substring(str.lastIndexOf(".") + 1);
        }
        Class<?> cls = this.f19232b;
        if (cls != null) {
            return cls.getSimpleName();
        }
        IRouterHandler iRouterHandler = this.f19244n;
        if (iRouterHandler != null) {
            return iRouterHandler.getClass().getName().substring(this.f19244n.getClass().getName().lastIndexOf(".") + 1);
        }
        return null;
    }

    public Class<? extends IRouterInterceptor>[] getInterceptors() {
        return this.f19239i;
    }

    public int getThread() {
        return this.f19240j;
    }

    public boolean isHold() {
        return this.f19241k;
    }

    public Intent getIntent() {
        return this.f19242l;
    }

    public boolean isRegexMatch(Uri uri) {
        String scheme = uri.getScheme();
        String host = uri.getHost();
        String path = uri.getPath();
        return scheme != null && scheme.matches(this.f19235e) && host != null && host.matches(this.f19236f) && path != null && path.matches(this.f19237g);
    }

    public boolean isRegexUri() {
        return TextUtils.isRegex(this.f19235e) || TextUtils.isRegex(this.f19236f) || TextUtils.isRegex(this.f19237g);
    }

    public String getLegalUri() {
        return this.f19235e + HWMapConstant.HTTP.SEPARATOR + this.f19236f + this.f19237g;
    }

    public IRouterHandler getHandler() {
        return this.f19244n;
    }

    public String getServiceAlias() {
        return this.f19245o;
    }

    public int getCache() {
        return this.f19250t;
    }

    public ServiceKey getServiceKey() {
        return this.f19247q;
    }

    public Object getService() {
        return this.f19248r;
    }

    public IFeatureMatcher getFeatureMatcher() {
        return this.f19246p;
    }

    public boolean isGlobal() {
        return this.f19249s;
    }

    public int getPriority() {
        return this.f19233c;
    }

    public boolean isDynamic() {
        return this.f19234d;
    }

    public void addInterceptorHandled(String str, IRouterInterceptor iRouterInterceptor) {
        if (this.f19251u == null) {
            this.f19251u = new HashMap();
        }
        List list = this.f19251u.get(str);
        if (list == null) {
            list = new ArrayList();
            this.f19251u.put(str, list);
        }
        list.add(iRouterInterceptor.getClass().getSimpleName());
    }

    public void clearInterceptorHandled(String str) {
        Map<String, List<String>> map = this.f19251u;
        if (map != null) {
            map.remove(str);
        }
    }

    public List<String> getInterceptorHandled(String str) {
        Map<String, List<String>> map = this.f19251u;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }
}
