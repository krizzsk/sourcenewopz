package com.didi.sdk.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import com.didi.app.SchemeDispatcherImpl;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.spi.AbstractDelegateManager;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Router<T extends BaseBusinessContext> extends AbstractDelegateManager<Fragment> {
    private static final int MAX_PAGE_CACHE_SIZE = 50;
    private static Logger log = LoggerFactory.getLogger("Router");
    private static volatile Router mRouter = null;
    private LruCache<Class<? extends Fragment>, Fragment> mPageCache = new LruCache<>(50);
    private HashMap<IntentFilter, Class<? extends Fragment>> mPageFilters = new HashMap<>();

    private Router() {
        loadFragments();
    }

    public static Router getInstance() {
        if (mRouter == null) {
            synchronized (Router.class) {
                mRouter = new Router();
            }
        }
        return mRouter;
    }

    public void registerFilter(IntentFilter intentFilter, Class<? extends Fragment> cls) {
        synchronized (this.mPageFilters) {
            this.mPageFilters.put(intentFilter, cls);
            Logger logger = log;
            logger.info("registerFilter:" + cls.toString(), new Object[0]);
        }
    }

    public Fragment matchPage(T t, Intent intent) {
        return matchPage(t, intent, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.fragment.app.Fragment matchPage(T r6, android.content.Intent r7, boolean r8) {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.content.ComponentName r1 = r7.getComponent()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0026
            java.lang.String r1 = r1.getClassName()
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0022 }
            java.lang.Class<androidx.fragment.app.Fragment> r4 = androidx.fragment.app.Fragment.class
            boolean r4 = r4.isAssignableFrom(r1)     // Catch:{ ClassNotFoundException -> 0x0022 }
            if (r4 == 0) goto L_0x0026
            r0.add(r1)     // Catch:{ ClassNotFoundException -> 0x0022 }
            r1 = 1
            goto L_0x0027
        L_0x0022:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0026:
            r1 = 0
        L_0x0027:
            if (r1 != 0) goto L_0x0030
            android.content.Context r1 = r6.getContext()
            r5.fullMatch(r1, r7, r0)
        L_0x0030:
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0038
            r6 = 0
            return r6
        L_0x0038:
            if (r1 <= r2) goto L_0x0089
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "please make sure the intentFilter is unique\n"
            r6.append(r8)
            java.lang.Object[] r8 = new java.lang.Object[r2]
            android.net.Uri r7 = r7.getData()
            r8[r3] = r7
            java.lang.String r7 = "Intent Uri: %s"
            java.lang.String r7 = java.lang.String.format(r7, r8)
            r6.append(r7)
            java.lang.String r7 = "\n"
            r6.append(r7)
            java.util.Iterator r8 = r0.iterator()
        L_0x005e:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x007f
            java.lang.Object r0 = r8.next()
            java.lang.Class r0 = (java.lang.Class) r0
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.String r0 = r0.getName()
            r1[r3] = r0
            java.lang.String r0 = "  Page: [%s]"
            java.lang.String r0 = java.lang.String.format(r0, r1)
            r6.append(r0)
            r6.append(r7)
            goto L_0x005e
        L_0x007f:
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            java.lang.String r6 = r6.toString()
            r7.<init>(r6)
            throw r7
        L_0x0089:
            java.lang.Object r0 = r0.get(r3)
            java.lang.Class r0 = (java.lang.Class) r0
            androidx.fragment.app.Fragment r6 = r5.cls2Page(r6, r0, r7, r8)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.app.Router.matchPage(com.didi.sdk.app.BaseBusinessContext, android.content.Intent, boolean):androidx.fragment.app.Fragment");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.fragment.app.Fragment cls2Page(T r2, java.lang.Class<? extends androidx.fragment.app.Fragment> r3, android.content.Intent r4, boolean r5) {
        /*
            r1 = this;
            if (r5 == 0) goto L_0x000b
            androidx.collection.LruCache<java.lang.Class<? extends androidx.fragment.app.Fragment>, androidx.fragment.app.Fragment> r5 = r1.mPageCache
            java.lang.Object r5 = r5.get(r3)
            androidx.fragment.app.Fragment r5 = (androidx.fragment.app.Fragment) r5
            goto L_0x000c
        L_0x000b:
            r5 = 0
        L_0x000c:
            if (r5 != 0) goto L_0x0043
            java.lang.Object r3 = r3.newInstance()     // Catch:{ InstantiationException -> 0x003f, IllegalAccessException -> 0x003a }
            androidx.fragment.app.Fragment r3 = (androidx.fragment.app.Fragment) r3     // Catch:{ InstantiationException -> 0x003f, IllegalAccessException -> 0x003a }
            boolean r5 = r3 instanceof com.didi.sdk.app.IComponent     // Catch:{ InstantiationException -> 0x0037, IllegalAccessException -> 0x0034 }
            if (r5 == 0) goto L_0x001e
            r5 = r3
            com.didi.sdk.app.IComponent r5 = (com.didi.sdk.app.IComponent) r5     // Catch:{ InstantiationException -> 0x0037, IllegalAccessException -> 0x0034 }
            r5.setBusinessContext(r2)     // Catch:{ InstantiationException -> 0x0037, IllegalAccessException -> 0x0034 }
        L_0x001e:
            boolean r5 = r3 instanceof com.didi.sdk.app.IStatusBar     // Catch:{ InstantiationException -> 0x0037, IllegalAccessException -> 0x0034 }
            r0 = 0
            if (r5 == 0) goto L_0x002b
            r5 = r3
            com.didi.sdk.app.IStatusBar r5 = (com.didi.sdk.app.IStatusBar) r5     // Catch:{ InstantiationException -> 0x0037, IllegalAccessException -> 0x0034 }
            boolean r5 = r5.showStatusBar()     // Catch:{ InstantiationException -> 0x0037, IllegalAccessException -> 0x0034 }
            goto L_0x002c
        L_0x002b:
            r5 = 0
        L_0x002c:
            if (r5 != 0) goto L_0x002f
            r0 = 1
        L_0x002f:
            r2.changedStatusBar(r0)     // Catch:{ InstantiationException -> 0x0037, IllegalAccessException -> 0x0034 }
            r5 = r3
            goto L_0x0043
        L_0x0034:
            r2 = move-exception
            r5 = r3
            goto L_0x003b
        L_0x0037:
            r2 = move-exception
            r5 = r3
            goto L_0x0040
        L_0x003a:
            r2 = move-exception
        L_0x003b:
            r2.printStackTrace()
            goto L_0x0043
        L_0x003f:
            r2 = move-exception
        L_0x0040:
            r2.printStackTrace()
        L_0x0043:
            android.os.Bundle r2 = r4.getExtras()
            if (r2 != 0) goto L_0x004e
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
        L_0x004e:
            if (r5 == 0) goto L_0x005d
            android.os.Bundle r3 = r5.getArguments()
            if (r3 == 0) goto L_0x005a
            r3.putAll(r2)
            goto L_0x005d
        L_0x005a:
            r5.setArguments(r2)
        L_0x005d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.app.Router.cls2Page(com.didi.sdk.app.BaseBusinessContext, java.lang.Class, android.content.Intent, boolean):androidx.fragment.app.Fragment");
    }

    private void fullMatch(Context context, Intent intent, ArrayList<Class<? extends Fragment>> arrayList) {
        String action = intent.getAction();
        String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(context.getApplicationContext().getContentResolver());
        String scheme = intent.getScheme();
        Uri data = intent.getData();
        Set<String> categories = intent.getCategories();
        synchronized (this.mPageFilters) {
            for (IntentFilter next : this.mPageFilters.keySet()) {
                if (next.match(action, resolveTypeIfNeeded, scheme, data, categories, "NavigationImpl") > 0) {
                    arrayList.add(this.mPageFilters.get(next));
                }
            }
        }
    }

    private void loadFragments() {
        new HashSet();
        loadDelegateClasses(Fragment.class, new AbstractDelegateManager.DelegateListener<Class<? extends Fragment>>() {
            public void onDelegate(String str, Class<? extends Fragment> cls) {
                if (!TextUtils.isEmpty(str)) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addDataScheme(((ProductPrefix) ServiceLoader.load(ProductPrefix.class).get()).getProductPrefix() + SchemeDispatcherImpl.SCHEME_ONE_TRAVEL);
                    intentFilter.addDataAuthority(str, (String) null);
                    intentFilter.addDataPath("/entrance", 0);
                    Router.this.registerFilter(intentFilter, cls);
                }
            }
        });
    }
}
