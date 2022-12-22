package com.didi.entrega.customer.repo;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.RepoManager;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;

public final class RepoFactory {

    /* renamed from: a */
    private static final String f20231a = "Repo";

    /* renamed from: b */
    private static volatile RepoManager f20232b;

    private RepoFactory() {
    }

    public static void clearAll() {
        if (f20232b != null) {
            Iterator<Class<?>> keyIterator = f20232b.keyIterator();
            ArrayList arrayList = new ArrayList();
            while (keyIterator.hasNext()) {
                Class next = keyIterator.next();
                boolean isAnnotationPresent = next.isAnnotationPresent(GlobalCache.class);
                LogUtil.m14765i(f20231a, next.getCanonicalName() + " : isGlobal=" + isAnnotationPresent);
                if (!isAnnotationPresent) {
                    arrayList.add(next);
                }
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                f20232b.remove((Class) arrayList.get(i));
            }
            f20232b.clear();
            f20232b = null;
        }
    }

    public static void clearRepo(Class<?> cls) {
        if (f20232b != null) {
            f20232b.remove(cls);
        }
    }

    public static <T extends Repo> T getRepo(Class<T> cls) {
        return m14879a().getRepo(cls);
    }

    /* renamed from: a */
    private static RepoManager m14879a() {
        if (f20232b == null) {
            synchronized (RepoManager.class) {
                RepoManager.Builder builder = new RepoManager.Builder();
                builder.monitor(new RepoManager.RepoMonitor() {
                    public void onRepoCreate(Repo repo) {
                    }

                    public void onRepoDestroy(Repo repo) {
                    }
                });
                builder.log(true);
                f20232b = builder.build();
            }
        }
        return f20232b;
    }
}
