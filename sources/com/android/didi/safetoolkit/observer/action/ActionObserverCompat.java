package com.android.didi.safetoolkit.observer.action;

import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

public final class ActionObserverCompat implements IActionObservable, IActionObserver {
    private final List<IActionObserver> mObserverList = new ArrayList();

    public void addActionObserver(IActionObserver iActionObserver) {
        synchronized (this.mObserverList) {
            this.mObserverList.add(iActionObserver);
        }
    }

    public boolean removeActionObserver(IActionObserver iActionObserver) {
        return this.mObserverList.remove(iActionObserver);
    }

    public void onBackPressed() {
        for (IActionObserver onBackPressed : this.mObserverList) {
            onBackPressed.onBackPressed();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        for (IActionObserver onActivityResult : this.mObserverList) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }
}
