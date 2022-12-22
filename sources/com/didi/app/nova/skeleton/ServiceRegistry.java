package com.didi.app.nova.skeleton;

public interface ServiceRegistry {
    Object allocService(Class cls);

    void releaseService(Object obj);
}
