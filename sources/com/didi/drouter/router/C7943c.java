package com.didi.drouter.router;

import com.didi.drouter.store.RouterMeta;
import com.didi.drouter.utils.RouterLogger;
import com.didi.drouter.utils.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.didi.drouter.router.c */
/* compiled from: ResultAgent */
class C7943c {

    /* renamed from: a */
    static final String f19199a = "DRouter_start_activity_request_number";

    /* renamed from: b */
    static final String f19200b = "not_found";

    /* renamed from: c */
    static final String f19201c = "timeout";

    /* renamed from: d */
    static final String f19202d = "error";

    /* renamed from: e */
    static final String f19203e = "stop_by_interceptor";

    /* renamed from: f */
    static final String f19204f = "stop_by_router_target";

    /* renamed from: g */
    static final String f19205g = "complete";

    /* renamed from: h */
    static final String f19206h = "request_cancel";

    /* renamed from: i */
    static final String f19207i = "redirect_by_interceptor";

    /* renamed from: j */
    static final String f19208j = "redirect_by_router_target";
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static final Map<String, Result> f19209l = new ConcurrentHashMap();

    /* renamed from: k */
    Request f19210k;

    /* renamed from: m */
    private final Map<String, Request> f19211m = new ConcurrentHashMap();

    /* renamed from: n */
    private final Map<String, RouterMeta> f19212n = new ConcurrentHashMap();

    /* renamed from: o */
    private final Map<String, String> f19213o = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: p */
    public RouterCallback f19214p;

    C7943c(Request request, Map<Request, RouterMeta> map, Result result, RouterCallback routerCallback) {
        f19209l.put(request.getNumber(), result);
        this.f19210k = request;
        this.f19214p = routerCallback;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                Request request2 = (Request) next.getKey();
                f19209l.put(request2.getNumber(), result);
                this.f19211m.put(request2.getNumber(), request2);
                this.f19212n.put(request2.getNumber(), next.getValue());
            }
        }
        if (request.f19180b != null) {
            request.f19180b.getLifecycle().addObserver(new ResultAgent$1(this, request));
        }
    }

    /* renamed from: a */
    static Request m14367a(String str) {
        Result c = m14375c(str);
        if (c != null) {
            return c.f19188a.f19211m.get(str);
        }
        return null;
    }

    /* renamed from: b */
    static RouterMeta m14373b(String str) {
        Result c = m14375c(str);
        if (c != null) {
            return c.f19188a.f19212n.get(str);
        }
        return null;
    }

    /* renamed from: c */
    static Result m14375c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f19209l.get(str);
    }

    /* renamed from: a */
    static void m14370a(Request request, String str) {
        if (request != null && m14375c(request.getNumber()) != null) {
            RouterMeta b = m14373b(request.getNumber());
            m14374b(request.getNumber(), str);
            RouterMonitor.handleRequest(request, b, str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static synchronized void m14374b(String str, String str2) {
        synchronized (C7943c.class) {
            Result c = m14375c(str);
            if (c != null) {
                if (c.f19188a.f19210k.getNumber().equals(str)) {
                    if (c.f19188a.f19211m.size() > 1) {
                        RouterLogger.getCoreLogger().mo59002w("be careful, all request \"%s\" will be cleared", str);
                    }
                    for (String next : c.f19188a.f19211m.keySet()) {
                        if (!c.f19188a.f19213o.containsKey(next)) {
                            m14376c(next, str2);
                        }
                    }
                } else {
                    m14376c(str, str2);
                }
                if (c.f19188a.f19213o.size() == c.f19188a.f19211m.size()) {
                    m14371a(c);
                }
            }
        }
    }

    /* renamed from: c */
    private static synchronized void m14376c(String str, String str2) {
        synchronized (C7943c.class) {
            Result result = f19209l.get(str);
            if (result != null) {
                if ("timeout".equals(str2)) {
                    RouterLogger.getCoreLogger().mo59002w("request \"%s\" time out and force-complete", str);
                }
                result.f19188a.f19213o.put(str, str2);
                f19209l.remove(str);
                RouterLogger.getCoreLogger().mo59000d("==== request \"%s\" complete, reason \"%s\" ====", str, str2);
            }
        }
    }

    /* renamed from: a */
    private static synchronized void m14371a(Result result) {
        synchronized (C7943c.class) {
            RouterLogger.getCoreLogger().mo59000d("primary request \"%s\" complete, all reason %s", result.f19188a.f19210k.getNumber(), result.f19188a.f19213o.toString());
            f19209l.remove(result.f19188a.f19210k.getNumber());
            if (result.f19188a.f19214p != null) {
                result.f19188a.f19214p.onResult(result);
            }
            if (!f19209l.containsKey(result.f19188a.f19210k.getNumber())) {
                RouterLogger.getCoreLogger().mo59000d("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", new Object[0]);
            }
        }
    }
}
