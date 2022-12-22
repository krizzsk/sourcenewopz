package com.didi.sdk.resource.warehouse.image;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.resource.warehouse.image.provider.FrescoCacheProvider;
import com.didi.sdk.resource.warehouse.image.provider.GlideCacheProvider;
import com.didi.sdk.resource.warehouse.image.strategy.FixedIntervalRetryStrategy;
import com.didi.sdk.resource.warehouse.tools.LogUtil;
import java.util.HashMap;
import java.util.Map;

public class OnlineImageCacheManager {
    public static int DEFAULT_MAX_RETRY_COUNT = 5;
    public static final long DRAWABLE_ID_NONE = -1;

    /* renamed from: a */
    private static final String f37106a = OnlineImageCacheManager.class.getSimpleName();

    /* renamed from: b */
    private static OnlineImageCacheManager f37107b;

    /* renamed from: c */
    private static final IRetryStrategy f37108c = new FixedIntervalRetryStrategy(1000, DEFAULT_MAX_RETRY_COUNT);

    /* renamed from: d */
    private Context f37109d;

    /* renamed from: e */
    private Map<String, CacheItem> f37110e = new HashMap();

    /* renamed from: f */
    private Map<Long, CacheItem> f37111f = new HashMap();

    /* renamed from: g */
    private Map<String, ICacheProvider> f37112g = new HashMap();

    public static synchronized OnlineImageCacheManager getInstance(Context context) {
        OnlineImageCacheManager onlineImageCacheManager;
        synchronized (OnlineImageCacheManager.class) {
            if (f37107b == null) {
                f37107b = new OnlineImageCacheManager(context);
            }
            onlineImageCacheManager = f37107b;
        }
        return onlineImageCacheManager;
    }

    private OnlineImageCacheManager(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            this.f37109d = applicationContext;
            registerCacheProvider(new GlideCacheProvider(applicationContext));
            registerCacheProvider(new FrescoCacheProvider());
            return;
        }
        throw new NullPointerException(f37106a + ".new:context is null");
    }

    public void registerCacheProvider(ICacheProvider iCacheProvider) {
        String str = f37106a;
        LogUtil.m26314i(str, "registerCacheProvider:provider = " + iCacheProvider);
        if (iCacheProvider != null) {
            this.f37112g.put(iCacheProvider.getProviderKey(), iCacheProvider);
        }
    }

    public void register(String str, PriorityType priorityType, String str2) {
        register(-1, str, priorityType, this.f37112g.get(str2), f37108c);
    }

    public void register(long j, String str, PriorityType priorityType, String str2) {
        register(j, str, priorityType, this.f37112g.get(str2), f37108c);
    }

    public void register(String str, PriorityType priorityType, String str2, IRetryStrategy iRetryStrategy) {
        register(-1, str, priorityType, this.f37112g.get(str2), iRetryStrategy);
    }

    public void register(long j, String str, PriorityType priorityType, String str2, IRetryStrategy iRetryStrategy) {
        register(j, str, priorityType, this.f37112g.get(str2), iRetryStrategy);
    }

    public void register(String str, PriorityType priorityType, ICacheProvider iCacheProvider) {
        register(-1, str, priorityType, iCacheProvider, f37108c);
    }

    public void register(long j, String str, PriorityType priorityType, ICacheProvider iCacheProvider) {
        register(j, str, priorityType, iCacheProvider, f37108c);
    }

    public void register(String str, PriorityType priorityType, ICacheProvider iCacheProvider, IRetryStrategy iRetryStrategy) {
        register(-1, str, priorityType, iCacheProvider, iRetryStrategy);
    }

    public void register(long j, String str, PriorityType priorityType, ICacheProvider iCacheProvider, IRetryStrategy iRetryStrategy) {
        String str2 = f37106a;
        LogUtil.m26314i(str2, "register:url = " + str + ", priorityType = " + priorityType + ", provider = " + iCacheProvider + ", strategy = " + iRetryStrategy);
        if (TextUtils.isEmpty(str)) {
            LogUtil.m26313e(f37106a, "register:url is empty");
        } else if (iCacheProvider == null) {
            String str3 = f37106a;
            LogUtil.m26313e(str3, "register:provider is null, url = " + str);
        } else {
            if (iRetryStrategy == null) {
                String str4 = f37106a;
                LogUtil.m26316w(str4, "register:strategy is null, url = " + str + ", priorityType = " + priorityType + ", provider = " + iCacheProvider);
            }
            CacheItem cacheItem = new CacheItem(j, str, priorityType, iCacheProvider, iRetryStrategy);
            this.f37110e.put(str, cacheItem);
            if (j >= 0) {
                this.f37111f.put(Long.valueOf(j), cacheItem);
            }
            iCacheProvider.cache(str, priorityType, iRetryStrategy);
        }
    }

    public boolean hasCache(String str, String str2) {
        ICacheProvider iCacheProvider;
        if (!TextUtils.isEmpty(str) && (iCacheProvider = this.f37112g.get(str2)) != null) {
            return iCacheProvider.hasCache(str);
        }
        return false;
    }
}
