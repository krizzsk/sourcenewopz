package com.didi.drouter.router;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import androidx.collection.ArraySet;
import com.didi.drouter.api.Extend;
import com.didi.drouter.remote.RemoteBridge;
import com.didi.drouter.store.RouterMeta;
import com.didi.drouter.store.RouterStore;
import com.didi.drouter.store.Statistics;
import com.didi.drouter.utils.RouterLogger;
import com.didi.drouter.utils.TextUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class RouterLoader {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Request f19194a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public RouterCallback f19195b;

    private RouterLoader() {
    }

    /* renamed from: a */
    static RouterLoader m14358a(Request request, RouterCallback routerCallback) {
        RouterLoader routerLoader = new RouterLoader();
        routerLoader.f19194a = request;
        routerLoader.f19195b = routerCallback;
        return routerLoader;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo58874a() {
        boolean z = false;
        RouterLogger.getCoreLogger().mo59000d("---------------------------------------------------------------------------", new Object[0]);
        RouterLogger coreLogger = RouterLogger.getCoreLogger();
        Object[] objArr = new Object[3];
        objArr[0] = this.f19194a.getNumber();
        objArr[1] = this.f19194a.getUri();
        if (this.f19195b != null) {
            z = true;
        }
        objArr[2] = Boolean.valueOf(z);
        coreLogger.mo59000d("primary request \"%s\", router uri \"%s\", need callback \"%s\"", objArr);
        if (TextUtils.isEmpty(this.f19194a.f19181c)) {
            m14360b();
        } else {
            m14363e();
        }
    }

    /* renamed from: b */
    private void m14360b() {
        Statistics.track("local_request");
        TextUtils.appendExtra(this.f19194a.getExtra(), TextUtils.getQuery(this.f19194a.getUri()));
        Map<Request, RouterMeta> c = m14361c();
        if (!c.isEmpty()) {
            final Result result = new Result(this.f19194a, c, this.f19195b);
            if (c.size() > 1) {
                RouterLogger.getCoreLogger().mo59002w("warning: request match %s targets", Integer.valueOf(c.size()));
            }
            ArrayList<Map.Entry> arrayList = new ArrayList<>(c.entrySet());
            Collections.sort(arrayList, new RouterComparator());
            final boolean[] zArr = {false};
            for (final Map.Entry entry : arrayList) {
                if (zArr[0]) {
                    C7943c.m14370a((Request) entry.getKey(), "stop_by_router_target");
                } else {
                    InterceptorHandler.m14351a((Request) entry.getKey(), (RouterMeta) entry.getValue(), new IInterceptor() {
                        public void onContinue() {
                            ((Request) entry.getKey()).f19186h = new IInterceptor() {
                                public void onContinue() {
                                }

                                public void onInterrupt() {
                                    RouterLogger.getCoreLogger().mo59002w("request \"%s\" stop all remains requests", ((Request) entry.getKey()).getNumber());
                                    zArr[0] = true;
                                }

                                public void onRedirect(String str, Bundle... bundleArr) {
                                    zArr[0] = true;
                                    RouterMonitor.handleRequest((Request) entry.getKey(), (RouterMeta) entry.getValue(), "redirect_by_router_target");
                                    RouterLoader.this.f19194a.rebuild(str, bundleArr);
                                    RouterLoader.this.mo58874a();
                                }
                            };
                            C7944d.m14378a((Request) entry.getKey(), (RouterMeta) entry.getValue(), result, RouterLoader.this.f19195b);
                            ((Request) entry.getKey()).f19186h = null;
                        }

                        public void onInterrupt() {
                            C7943c.m14370a((Request) entry.getKey(), "stop_by_interceptor");
                        }

                        public void onRedirect(String str, Bundle... bundleArr) {
                            RouterMonitor.handleRequest((Request) entry.getKey(), (RouterMeta) entry.getValue(), "redirect_by_interceptor");
                            RouterLoader.this.f19194a.rebuild(str, bundleArr);
                            RouterLoader.this.mo58874a();
                        }
                    });
                }
            }
            return;
        }
        RouterLogger.getCoreLogger().mo59002w("warning: there is no request target match", new Object[0]);
        new Result(this.f19194a, (Map<Request, RouterMeta>) null, this.f19195b);
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            this.f19194a.putExtra("stack_trace", Log.getStackTraceString(e));
            C7943c.m14370a(this.f19194a, "not_found");
        }
    }

    /* renamed from: c */
    private Map<Request, RouterMeta> m14361c() {
        HashMap hashMap = new HashMap();
        Parcelable parcelable = this.f19194a.getParcelable(Extend.START_ACTIVITY_VIA_INTENT);
        if (parcelable instanceof Intent) {
            this.f19194a.getExtra().remove(Extend.START_ACTIVITY_VIA_INTENT);
            Intent intent = (Intent) parcelable;
            RouterLogger.getCoreLogger().mo59000d("request %s, intent \"%s\"", this.f19194a.getNumber(), intent);
            List<ResolveInfo> queryIntentActivities = this.f19194a.getContext().getPackageManager().queryIntentActivities(intent, 65536);
            if (!queryIntentActivities.isEmpty()) {
                this.f19194a.f19182d = 1;
                RouterLogger.getCoreLogger().mo59000d("request \"%s\" find target class \"%s\", type \"%s\"", this.f19194a.getNumber(), queryIntentActivities.get(0).activityInfo.name, Integer.valueOf(this.f19194a.f19182d));
                hashMap.put(this.f19194a, RouterMeta.build(1).assembleRouter(intent));
            }
        } else {
            Set<RouterMeta> d = m14362d();
            int i = 0;
            for (RouterMeta next : d) {
                int i2 = i + 1;
                Request a = m14356a(this.f19194a, d.size() > 1, next.getRouterType(), i);
                RouterLogger.getCoreLogger().mo59000d("request \"%s\" find target class \"%s\", type \"%s\", priority \"%s\"", a.getNumber(), next.getSimpleClassName(), Integer.valueOf(next.getRouterType()), Integer.valueOf(next.getPriority()));
                hashMap.put(a, next);
                i = i2;
            }
        }
        return hashMap;
    }

    /* renamed from: d */
    private Set<RouterMeta> m14362d() {
        Set<RouterMeta> routerMetas = RouterStore.getRouterMetas(TextUtils.getUriKey(this.f19194a.getUri()));
        String string = this.f19194a.getString(Extend.START_ACTIVITY_WITH_DEFAULT_SCHEME_HOST);
        if (!TextUtils.isEmpty(string) && this.f19194a.getUri().toString().startsWith(string.toLowerCase())) {
            for (RouterMeta next : RouterStore.getRouterMetas(TextUtils.getUriKey(this.f19194a.getUri().getPath()))) {
                if (next.getRouterType() == 1) {
                    routerMetas.add(next);
                }
            }
        }
        SparseArray sparseArray = new SparseArray();
        ArraySet arraySet = new ArraySet();
        for (RouterMeta next2 : routerMetas) {
            if (next2.getRouterType() == 1) {
                if (sparseArray.get(0) != null) {
                    RouterLogger.getCoreLogger().mo59002w("warning: request match more than one activity and this \"%s\" will be ignored", next2.getSimpleClassName());
                } else {
                    sparseArray.put(0, next2);
                }
            } else if (next2.getRouterType() == 2) {
                if (sparseArray.get(1) != null) {
                    RouterLogger.getCoreLogger().mo59002w("warning: request match more than one fragment and this \"%s\" will be ignored", next2.getSimpleClassName());
                } else {
                    sparseArray.put(1, next2);
                }
            } else if (next2.getRouterType() == 3) {
                if (sparseArray.get(2) != null) {
                    RouterLogger.getCoreLogger().mo59002w("warning: request match more than one view and this \"%s\" will be ignored", next2.getSimpleClassName());
                } else {
                    sparseArray.put(2, next2);
                }
            } else if (next2.getRouterType() == 4) {
                arraySet.add(next2);
            }
        }
        if (sparseArray.get(0) != null) {
            arraySet.add(sparseArray.get(0));
        } else if (sparseArray.get(1) != null) {
            arraySet.add(sparseArray.get(1));
        } else if (sparseArray.get(2) != null) {
            arraySet.add(sparseArray.get(2));
        }
        return arraySet;
    }

    /* renamed from: e */
    private void m14363e() {
        Statistics.track("remote_request");
        HashMap hashMap = new HashMap();
        WeakReference weakReference = null;
        hashMap.put(this.f19194a, (Object) null);
        Result result = new Result(this.f19194a, hashMap, this.f19195b);
        String str = this.f19194a.f19181c;
        int i = this.f19194a.f19183e;
        if (this.f19194a.f19180b != null) {
            weakReference = new WeakReference(this.f19194a.f19180b);
        }
        RemoteBridge.load(str, i, weakReference).start(this.f19194a, result, this.f19195b);
    }

    /* renamed from: a */
    private static Request m14356a(Request request, boolean z, int i, int i2) {
        request.f19182d = z ? -1 : i;
        if (!z) {
            return request;
        }
        Request build = Request.build(request.getUri().toString());
        build.extra = request.extra;
        build.addition = request.addition;
        build.f19179a = request.f19179a;
        build.f19180b = request.f19180b;
        build.f19181c = request.f19181c;
        build.f19183e = request.f19183e;
        build.f19184f = request.f19184f;
        build.f19185g = request.getNumber() + "_" + i2;
        build.f19182d = i;
        return build;
    }

    private static class RouterComparator implements Comparator<Map.Entry<Request, RouterMeta>> {
        private RouterComparator() {
        }

        public int compare(Map.Entry<Request, RouterMeta> entry, Map.Entry<Request, RouterMeta> entry2) {
            return entry2.getValue().getPriority() - entry.getValue().getPriority();
        }
    }
}
