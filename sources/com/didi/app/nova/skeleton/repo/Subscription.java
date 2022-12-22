package com.didi.app.nova.skeleton.repo;

public interface Subscription {
    void activeChange(boolean z) throws Exception;

    boolean isUnsubscribed();

    void unsubscribe();
}
