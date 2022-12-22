package com.didi.soda.customer.repo;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.RepoManager;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;

public final class RepoFactory {

    /* renamed from: a */
    private static final String f41398a = "Repo";

    /* renamed from: b */
    private static volatile RepoManager f41399b;

    private RepoFactory() {
    }

    public static void clearAll() {
        if (f41399b != null) {
            Iterator<Class<?>> keyIterator = f41399b.keyIterator();
            ArrayList arrayList = new ArrayList();
            while (keyIterator.hasNext()) {
                Class next = keyIterator.next();
                boolean isAnnotationPresent = next.isAnnotationPresent(GlobalCache.class);
                LogUtil.m29104i(f41398a, next.getCanonicalName() + " : isGlobal=" + isAnnotationPresent);
                if (!isAnnotationPresent) {
                    arrayList.add(next);
                }
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                f41399b.remove((Class) arrayList.get(i));
            }
            f41399b.clear();
            f41399b = null;
        }
    }

    public static void clearRepo(Class<?> cls) {
        if (f41399b != null) {
            f41399b.remove(cls);
        }
    }

    public static <T extends Repo> T getRepo(Class<T> cls) {
        return m29318a().getRepo(cls);
    }

    /* renamed from: a */
    private static RepoManager m29318a() {
        if (f41399b == null) {
            synchronized (RepoManager.class) {
                RepoManager.Builder builder = new RepoManager.Builder();
                builder.monitor(new RepoManager.RepoMonitor() {
                    public void onRepoCreate(Repo repo) {
                    }

                    public void onRepoDestroy(Repo repo) {
                    }
                });
                builder.log(true);
                f41399b = builder.build();
            }
        }
        return f41399b;
    }
}
