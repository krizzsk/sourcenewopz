package com.didi.app.nova.skeleton;

import android.os.Bundle;

public interface ScopeContext {
    boolean addObserver(IScopeLifecycle iScopeLifecycle);

    String alias();

    Object attach(String str, Object obj);

    Object detach(String str);

    void detachAll();

    Bundle getBundle();

    LiveHandler getLiveHandler();

    INavigator getNavigator();

    Object getObject(String str);

    ScopeContext getParent();

    boolean removeObserver(IScopeLifecycle iScopeLifecycle);
}
