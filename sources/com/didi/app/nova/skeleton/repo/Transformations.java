package com.didi.app.nova.skeleton.repo;

import com.didi.app.nova.skeleton.ScopeContext;

public class Transformations {
    private Transformations() {
    }

    public static <X, Y> LiveData<Y> map(Repo<X> repo, final Repo<Y> repo2, final Function<X, Y> function) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(repo.getLiveData(), new Action1<X>() {
            public void call(X x) {
                repo2.setValue(function.apply(x));
            }
        });
        return mediatorLiveData;
    }

    public static <X, Y> LiveData<Y> map(Repo<X> repo, final Repo<Y> repo2, ScopeContext scopeContext, final Function<X, Y> function) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(repo.getLiveData(), scopeContext, new Action1<X>() {
            public void call(X x) {
                repo2.setValue(function.apply(x));
            }
        });
        return mediatorLiveData;
    }
}
