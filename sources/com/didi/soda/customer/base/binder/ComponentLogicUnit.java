package com.didi.soda.customer.base.binder;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.RepoManager;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class ComponentLogicUnit {
    private RepoManager mRepoManager = null;

    public abstract void onBindLogic();

    public void clearAll() {
        RepoManager repoManager = this.mRepoManager;
        if (repoManager != null) {
            Iterator<Class<?>> keyIterator = repoManager.keyIterator();
            ArrayList arrayList = new ArrayList();
            while (keyIterator.hasNext()) {
                arrayList.add(keyIterator.next());
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.mRepoManager.remove((Class) arrayList.get(i));
            }
            this.mRepoManager.clear();
            this.mRepoManager = null;
        }
    }

    public void clearLogic(Class<?> cls) {
        RepoManager repoManager = this.mRepoManager;
        if (repoManager != null) {
            repoManager.remove(cls);
        }
    }

    public <T extends Repo> T getLogic(Class<T> cls) {
        return repoManager().getRepo(cls);
    }

    private RepoManager repoManager() {
        if (this.mRepoManager == null) {
            RepoManager.Builder builder = new RepoManager.Builder();
            builder.monitor(new RepoManager.RepoMonitor() {
                public void onRepoCreate(Repo repo) {
                }

                public void onRepoDestroy(Repo repo) {
                }
            });
            builder.log(true);
            this.mRepoManager = builder.build();
        }
        return this.mRepoManager;
    }
}
