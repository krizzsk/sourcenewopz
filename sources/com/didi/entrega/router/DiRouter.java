package com.didi.entrega.router;

import com.didi.entrega.router.Request;
import com.didi.entrega.router.annotations.Route;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DiRouter {
    public static final String ROUTER_DEFAULT_WEB_VIEW = "diRouter#webview";

    /* renamed from: b */
    private static final DiRouter f21015b = new DiRouter();

    /* renamed from: a */
    volatile Route f21016a;

    /* renamed from: c */
    private final Map<Route, C8225a> f21017c = new HashMap();

    /* renamed from: d */
    private IRouterCallback f21018d;

    /* renamed from: e */
    private IDowngradeHandler f21019e;

    private DiRouter() {
    }

    public static void init(String str, IRouterCallback iRouterCallback) {
        f21015b.f21016a = Route.parse(str);
        if (f21015b.f21016a.getScheme() != null) {
            f21015b.f21017c.clear();
            DiRouter diRouter = f21015b;
            diRouter.f21017c.put(diRouter.f21016a, new C8225a(f21015b.f21016a, (IHubHandler) null));
            f21015b.f21018d = iRouterCallback;
            return;
        }
        throw new IllegalArgumentException("scheme is illegal.");
    }

    public static void setDowngradeHandler(IDowngradeHandler iDowngradeHandler) {
        f21015b.f21019e = iDowngradeHandler;
    }

    public static void registerIndexHub(String str, Object obj) {
        if (obj != null && (obj instanceof IHubHandler) && !f21015b.f21017c.isEmpty()) {
            Route parse = Route.parse(str);
            if (parse.equals(f21015b.f21016a)) {
                f21015b.f21017c.put(parse, new C8225a(parse, (IHubHandler) obj));
            }
        }
    }

    public static void registerHub(String str, Object obj) {
        DiRouter diRouter = f21015b;
        diRouter.m15398a(String.format("register hub:%s " + obj, new Object[]{str}), new Object[0]);
        if (obj != null && (obj instanceof IHubHandler) && !f21015b.f21017c.isEmpty()) {
            Route parse = Route.parse(str);
            if (parse.getScheme() == null) {
                parse.setScheme(f21015b.f21016a.getScheme());
            } else if (!C8227c.m15432a(parse.getScheme(), f21015b.f21016a.getScheme())) {
                return;
            }
            if (parse.getHost() == null) {
                parse.setHost(f21015b.f21016a.getHost());
            } else if (!C8227c.m15432a(parse.getHost(), f21015b.f21016a.getHost())) {
                return;
            }
            DiRouter diRouter2 = f21015b;
            C8225a aVar = diRouter2.f21017c.get(diRouter2.f21016a);
            aVar.mo62674b(parse);
            aVar.mo62672a(new C8225a(parse, (IHubHandler) obj));
        }
    }

    public static Request.Builder request() {
        return new Request.Builder(f21015b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Response mo62614a(Request request) {
        Response response = new Response(request);
        if (this.f21017c.isEmpty()) {
            response.mo62643a(-1);
            response.mo62645a("DiRouter not init.");
            return m15396a(response);
        }
        Route[] parents = request.mo62617a().parents();
        C8225a aVar = this.f21017c.get(this.f21016a);
        if (aVar.mo62673b() == null) {
            return m15395a(request, response, aVar);
        }
        C8225a aVar2 = aVar;
        int i = 0;
        while (i < parents.length) {
            C8225a a = m15397a(aVar2, parents[i], request, response);
            if (a == null) {
                return m15395a(request, response, aVar2);
            }
            i++;
            aVar2 = a;
        }
        if (aVar2.mo62673b() == null) {
            return m15395a(request, response, aVar);
        }
        if (request.getTarget() == null) {
            return m15395a(request, response, aVar2);
        }
        Route route = (Route) request.getTarget().getAnnotation(Route.class);
        if (route.interceptors() != null && route.interceptors().length > 0) {
            Class[] interceptors = route.interceptors();
            int length = interceptors.length;
            int i2 = 0;
            while (i2 < length) {
                try {
                    IInterceptor iInterceptor = (IInterceptor) interceptors[i2].newInstance();
                    if (iInterceptor.intercept(request, response)) {
                        response.mo62643a(-5);
                        response.mo62645a("Route is Intercepted by " + iInterceptor);
                        return m15396a(response);
                    }
                    i2++;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        response.mo62643a(0);
        response.mo62645a("ok");
        aVar2.mo62673b().openRoute(request, response);
        m15398a("openRoute request[%s] %s", request.getPath(), response);
        return m15396a(response);
    }

    /* renamed from: a */
    private C8225a m15397a(C8225a aVar, Route route, Request request, Response response) {
        Class<?> a;
        Route route2;
        C8225a a2 = aVar.mo62669a(route);
        if (a2 == null || a2.mo62673b() == null) {
            if (aVar.mo62673b() == null || (a = HubTable.m15401a(route.getPath())) == null || !IHubHandler.class.isAssignableFrom(a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (a == null) {
                route2 = null;
            } else {
                route2 = (Route) a.getAnnotation(Route.class);
            }
            if (!(route2 == null || route2.interceptors() == null)) {
                int i = 0;
                while (i < route2.interceptors().length) {
                    try {
                        IInterceptor iInterceptor = (IInterceptor) route2.interceptors()[i].newInstance();
                        if (iInterceptor.intercept(request, response)) {
                            response.mo62643a(-5);
                            response.mo62645a("Route is intercepted by " + iInterceptor);
                            return null;
                        }
                        arrayList.add(iInterceptor);
                        i++;
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InstantiationException e2) {
                        throw new RuntimeException(e2);
                    }
                }
            }
            aVar.mo62673b().openRoute(new Request.Builder(this).path(route.getAbsolutePath()).params(request.getExtras()).setFromPage(request.getFromPage()).build(), response);
            a2 = aVar.mo62669a(route);
            if (a2 != null) {
                a2.mo62671a((List<IInterceptor>) arrayList);
            }
        } else if (a2.mo62675c() != null) {
            for (IInterceptor next : a2.mo62675c()) {
                if (next.intercept(request, response)) {
                    response.mo62643a(-5);
                    response.mo62645a("Route is Intercepted by " + next);
                    return null;
                }
            }
        }
        return a2;
    }

    /* renamed from: a */
    private Response m15395a(Request request, Response response, C8225a aVar) {
        if (response.getCode() == -5) {
            return m15396a(response);
        }
        if (response.getCode() == -6) {
            return m15396a(response);
        }
        if (aVar == null) {
            response.mo62643a(-3);
            response.mo62645a("Not Found Hub for " + request.getPath());
        } else if (aVar.mo62673b() == null) {
            response.mo62643a(-4);
            response.mo62645a("Not Found hubHandler for " + aVar);
        } else {
            response.mo62643a(0);
            if (request.getTarget() != null) {
                aVar.mo62673b().openRoute(request, response);
            } else {
                IDowngradeHandler iDowngradeHandler = this.f21019e;
                if (iDowngradeHandler != null) {
                    Route downgrade = iDowngradeHandler.downgrade(Route.create(request.mo62617a()));
                    if (downgrade == null || downgrade.equals(request.mo62617a())) {
                        response.mo62643a(-6);
                        return m15396a(response);
                    } else if (!"http".equalsIgnoreCase(downgrade.getScheme()) && !"https".equalsIgnoreCase(downgrade.getScheme())) {
                        Request build = request().path(downgrade.getAbsolutePath()).build();
                        if (!request.mo62617a().equals(build.mo62617a())) {
                            return mo62614a(build);
                        }
                        response.mo62643a(-6);
                        return m15396a(response);
                    } else if (request.mo62619b()) {
                        return m15399b(aVar, downgrade, request, response);
                    } else {
                        response.mo62643a(-6);
                        return m15396a(response);
                    }
                } else if (request.mo62619b() && ("http".equalsIgnoreCase(request.mo62617a().getScheme()) || "https".equalsIgnoreCase(request.mo62617a().getScheme()))) {
                    return m15399b(aVar, request.mo62617a(), request, response);
                } else {
                    response.mo62643a(-6);
                    return m15396a(response);
                }
            }
        }
        return m15396a(response);
    }

    /* renamed from: b */
    private Response m15399b(C8225a aVar, Route route, Request request, Response response) {
        Request request2 = new Request(route, request.getExtras(), HubTable.m15401a("diRouter#webview"));
        request2.setFromPage(request.getFromPage());
        request2.mo62618a(request.mo62619b());
        response.mo62644a(request2);
        aVar.mo62673b().openRoute(request2, response);
        return m15396a(response);
    }

    /* renamed from: a */
    private Response m15396a(Response response) {
        m15398a("finish request[%s] result[code:%s, message:%s]", response.getRequestPath(), Response.codeToString(response.getCode()), response.getMessage());
        IRouterCallback iRouterCallback = this.f21018d;
        if (iRouterCallback != null) {
            iRouterCallback.onRoute(response);
        }
        return response;
    }

    /* renamed from: a */
    private void m15398a(String str, Object... objArr) {
        try {
            SystemUtils.log(4, "DiRouter", String.format(str, objArr), (Throwable) null, "com.didi.entrega.router.DiRouter", 318);
        } catch (Exception unused) {
        }
    }

    public static void clear() {
        f21015b.f21017c.clear();
    }
}
