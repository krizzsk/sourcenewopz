package com.didi.app.nova.skeleton;

public interface IScopeLifecycle {

    public enum PageStatus {
        Create,
        Start,
        Resume,
        Stop,
        Pause,
        Destroy
    }

    void onCreate(ILive iLive);

    void onDestroy(ILive iLive);

    void onPause(ILive iLive);

    void onResume(ILive iLive);

    void onStart(ILive iLive);

    void onStop(ILive iLive);
}
