package com.didi.dimina.container.page;

public interface DMPageLifecycleListener {

    public static class DefaultDMPageLifeCycleListener implements DMPageLifecycleListener {
        public void onCreate() {
        }

        public void onDestroy() {
        }

        public void onDomReady() {
        }

        public void onHide() {
        }

        public void onShow() {
        }
    }

    void onCreate();

    void onDestroy();

    void onDomReady();

    void onHide();

    void onShow();
}
