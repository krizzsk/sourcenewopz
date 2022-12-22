package com.android.didi.safetoolkit.observer.lifecycle;

import java.util.ArrayList;
import java.util.List;

public final class LifecycleObserverCompat implements IComponentLifecycleObserver, ILifecycleObservable {
    private boolean mIsCreated = false;
    private boolean mIsDestroy = false;
    private boolean mIsHidden = false;
    private boolean mIsResumed = false;
    private boolean mIsStarted = false;
    private final List<ILifecycleObserver> mObserverList = new ArrayList();

    public void addLifecycleObserver(ILifecycleObserver iLifecycleObserver) {
        synchronized (this.mObserverList) {
            this.mObserverList.add(iLifecycleObserver);
            if (iLifecycleObserver instanceof IComponentLifecycleObserver) {
                addComponentObserver((IComponentLifecycleObserver) iLifecycleObserver);
            } else {
                addBaseObserver(iLifecycleObserver);
            }
        }
    }

    private void addComponentObserver(IComponentLifecycleObserver iComponentLifecycleObserver) {
        if (!this.mIsDestroy) {
            if (this.mIsCreated) {
                iComponentLifecycleObserver.onCreate();
            }
            if (this.mIsStarted) {
                iComponentLifecycleObserver.onStart();
            }
            if (this.mIsResumed) {
                iComponentLifecycleObserver.onResume();
            }
            if (this.mIsHidden) {
                iComponentLifecycleObserver.onHiddenChanged(true);
                return;
            }
            return;
        }
        if (!this.mIsResumed) {
            iComponentLifecycleObserver.onPause();
        }
        if (!this.mIsStarted) {
            iComponentLifecycleObserver.onStop();
        }
        iComponentLifecycleObserver.onDestroy();
        this.mObserverList.remove(iComponentLifecycleObserver);
    }

    private void addBaseObserver(ILifecycleObserver iLifecycleObserver) {
        if (this.mIsDestroy) {
            iLifecycleObserver.onDestroy();
            this.mObserverList.remove(iLifecycleObserver);
        } else if (this.mIsCreated) {
            iLifecycleObserver.onCreate();
        }
    }

    public boolean removeLifecycleObserver(ILifecycleObserver iLifecycleObserver) {
        boolean remove;
        synchronized (this.mObserverList) {
            remove = this.mObserverList.remove(iLifecycleObserver);
        }
        return remove;
    }

    public void onCreate() {
        this.mIsDestroy = false;
        this.mIsCreated = true;
        for (ILifecycleObserver onCreate : this.mObserverList) {
            onCreate.onCreate();
        }
    }

    public void onStart() {
        for (ILifecycleObserver next : this.mObserverList) {
            if (next instanceof IComponentLifecycleObserver) {
                ((IComponentLifecycleObserver) next).onStart();
            }
        }
        this.mIsStarted = true;
    }

    public void onHiddenChanged(boolean z) {
        for (ILifecycleObserver next : this.mObserverList) {
            if (next instanceof IComponentLifecycleObserver) {
                ((IComponentLifecycleObserver) next).onHiddenChanged(z);
            }
        }
        this.mIsHidden = z;
    }

    public void onResume() {
        for (ILifecycleObserver next : this.mObserverList) {
            if (next instanceof IComponentLifecycleObserver) {
                ((IComponentLifecycleObserver) next).onResume();
            }
        }
        this.mIsResumed = true;
    }

    public void onPause() {
        for (ILifecycleObserver next : this.mObserverList) {
            if (next instanceof IComponentLifecycleObserver) {
                ((IComponentLifecycleObserver) next).onPause();
            }
        }
        this.mIsResumed = false;
    }

    public void onStop() {
        for (ILifecycleObserver next : this.mObserverList) {
            if (next instanceof IComponentLifecycleObserver) {
                ((IComponentLifecycleObserver) next).onStop();
            }
        }
        this.mIsStarted = false;
    }

    public void onDestroy() {
        this.mIsCreated = false;
        this.mIsDestroy = true;
        for (ILifecycleObserver onDestroy : this.mObserverList) {
            onDestroy.onDestroy();
        }
        this.mObserverList.clear();
    }
}
