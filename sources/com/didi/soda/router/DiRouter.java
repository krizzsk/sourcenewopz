package com.didi.soda.router;

import android.util.Log;
import com.didi.soda.router.Request;
import com.didi.soda.router.annotations.Route;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DiRouter {
    public static final String ROUTER_DEFAULT_WEB_VIEW = "diRouter#webview";

    /* renamed from: b */
    private static final DiRouter f43648b = new DiRouter();

    /* renamed from: a */
    volatile Route f43649a;

    /* renamed from: c */
    private final Map<Route, C14169a> f43650c = new HashMap();

    /* renamed from: d */
    private IRouterCallback f43651d;

    /* renamed from: e */
    private IDowngradeHandler f43652e;

    private DiRouter() {
    }

    public static void init(String str, IRouterCallback iRouterCallback) {
        f43648b.f43649a = Route.parse(str);
        if (f43648b.f43649a.getScheme() != null) {
            f43648b.f43650c.clear();
            DiRouter diRouter = f43648b;
            diRouter.f43650c.put(diRouter.f43649a, new C14169a(f43648b.f43649a, (IHubHandler) null));
            f43648b.f43651d = iRouterCallback;
            return;
        }
        throw new IllegalArgumentException("scheme is illegal.");
    }

    public static void setDowngradeHandler(IDowngradeHandler iDowngradeHandler) {
        f43648b.f43652e = iDowngradeHandler;
    }

    public static void registerIndexHub(String str, Object obj) {
        if (obj != null && (obj instanceof IHubHandler) && !f43648b.f43650c.isEmpty()) {
            Route parse = Route.parse(str);
            if (parse.equals(f43648b.f43649a)) {
                f43648b.f43650c.put(parse, new C14169a(parse, (IHubHandler) obj));
            }
        }
    }

    public static void registerHub(String str, Object obj) {
        DiRouter diRouter = f43648b;
        diRouter.m30961a(String.format("register hub:%s " + obj, new Object[]{str}), new Object[0]);
        if (obj != null && (obj instanceof IHubHandler) && !f43648b.f43650c.isEmpty()) {
            Route parse = Route.parse(str);
            if (parse.getScheme() == null) {
                parse.setScheme(f43648b.f43649a.getScheme());
            } else if (!C14171c.m30995a(parse.getScheme(), f43648b.f43649a.getScheme())) {
                return;
            }
            if (parse.getHost() == null) {
                parse.setHost(f43648b.f43649a.getHost());
            } else if (!C14171c.m30995a(parse.getHost(), f43648b.f43649a.getHost())) {
                return;
            }
            DiRouter diRouter2 = f43648b;
            C14169a aVar = diRouter2.f43650c.get(diRouter2.f43649a);
            aVar.mo108785b(parse);
            aVar.mo108783a(new C14169a(parse, (IHubHandler) obj));
        }
    }

    public static Request.Builder request() {
        return new Request.Builder(f43648b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Response mo108726a(Request request) {
        Response response = new Response(request);
        if (this.f43650c.isEmpty()) {
            response.mo108754a(-1);
            response.mo108756a("DiRouter not init.");
            return m30959a(response);
        }
        Route[] parents = request.mo108729a().parents();
        C14169a aVar = this.f43650c.get(this.f43649a);
        if (aVar.mo108784b() == null) {
            return m30958a(request, response, aVar);
        }
        C14169a aVar2 = aVar;
        int i = 0;
        while (i < parents.length) {
            C14169a a = m30960a(aVar2, parents[i], request, response);
            if (a == null) {
                return m30958a(request, response, aVar2);
            }
            i++;
            aVar2 = a;
        }
        if (aVar2.mo108784b() == null) {
            return m30958a(request, response, aVar);
        }
        if (request.getTarget() == null) {
            return m30958a(request, response, aVar2);
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
                        response.mo108754a(-5);
                        response.mo108756a("Route is Intercepted by " + iInterceptor);
                        return m30959a(response);
                    }
                    i2++;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        response.mo108754a(0);
        response.mo108756a("ok");
        aVar2.mo108784b().openRoute(request, response);
        m30961a("openRoute request[%s] %s", request.getPath(), response);
        return m30959a(response);
    }

    /* renamed from: a */
    private C14169a m30960a(C14169a aVar, Route route, Request request, Response response) {
        Class<?> a;
        Route route2;
        C14169a a2 = aVar.mo108780a(route);
        if (a2 == null || a2.mo108784b() == null) {
            if (aVar.mo108784b() == null || (a = HubTable.m30964a(route.getPath())) == null || !IHubHandler.class.isAssignableFrom(a)) {
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
                            response.mo108754a(-5);
                            response.mo108756a("Route is intercepted by " + iInterceptor);
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
            aVar.mo108784b().openRoute(new Request.Builder(this).path(route.getAbsolutePath()).params(request.getExtras()).build(), response);
            a2 = aVar.mo108780a(route);
            if (a2 != null) {
                a2.mo108782a((List<IInterceptor>) arrayList);
            }
        } else if (a2.mo108786c() != null) {
            for (IInterceptor next : a2.mo108786c()) {
                if (next.intercept(request, response)) {
                    response.mo108754a(-5);
                    response.mo108756a("Route is Intercepted by " + next);
                    return null;
                }
            }
        }
        return a2;
    }

    /* renamed from: a */
    private Response m30958a(Request request, Response response, C14169a aVar) {
        if (response.getCode() == -5) {
            return m30959a(response);
        }
        if (response.getCode() == -6) {
            return m30959a(response);
        }
        if (aVar == null) {
            response.mo108754a(-3);
            response.mo108756a("Not Found Hub for " + request.getPath());
        } else if (aVar.mo108784b() == null) {
            response.mo108754a(-4);
            response.mo108756a("Not Found hubHandler for " + aVar);
        } else {
            response.mo108754a(0);
            if (request.getTarget() != null) {
                aVar.mo108784b().openRoute(request, response);
            } else {
                IDowngradeHandler iDowngradeHandler = this.f43652e;
                if (iDowngradeHandler != null) {
                    Route downgrade = iDowngradeHandler.downgrade(Route.create(request.mo108729a()));
                    if (downgrade == null || downgrade.equals(request.mo108729a())) {
                        response.mo108754a(-6);
                        return m30959a(response);
                    } else if (!"http".equalsIgnoreCase(downgrade.getScheme()) && !"https".equalsIgnoreCase(downgrade.getScheme())) {
                        Request build = request().path(downgrade.getAbsolutePath()).build();
                        if (!request.mo108729a().equals(build.mo108729a())) {
                            return mo108726a(build);
                        }
                        response.mo108754a(-6);
                        return m30959a(response);
                    } else if (request.mo108731b()) {
                        return m30962b(aVar, downgrade, request, response);
                    } else {
                        response.mo108754a(-6);
                        return m30959a(response);
                    }
                } else if (request.mo108731b() && ("http".equalsIgnoreCase(request.mo108729a().getScheme()) || "https".equalsIgnoreCase(request.mo108729a().getScheme()))) {
                    return m30962b(aVar, request.mo108729a(), request, response);
                } else {
                    response.mo108754a(-6);
                    return m30959a(response);
                }
            }
        }
        return m30959a(response);
    }

    /* renamed from: b */
    private Response m30962b(C14169a aVar, Route route, Request request, Response response) {
        Request request2 = new Request(route, request.getExtras(), HubTable.m30964a("diRouter#webview"));
        request2.mo108730a(request.mo108731b());
        response.mo108755a(request2);
        aVar.mo108784b().openRoute(request2, response);
        return m30959a(response);
    }

    /* renamed from: a */
    private Response m30959a(Response response) {
        m30961a("finish request[%s] result[code:%s, message:%s]", response.getRequestPath(), Response.codeToString(response.getCode()), response.getMessage());
        IRouterCallback iRouterCallback = this.f43651d;
        if (iRouterCallback != null) {
            iRouterCallback.onRoute(response);
        }
        return response;
    }

    /* renamed from: a */
    private void m30961a(String str, Object... objArr) {
        try {
            Log.i("DiRouter", String.format(str, objArr));
        } catch (Exception unused) {
        }
    }

    public static void clear() {
        f43648b.f43650c.clear();
    }
}
