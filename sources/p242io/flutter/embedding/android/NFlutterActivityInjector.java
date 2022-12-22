package p242io.flutter.embedding.android;

/* renamed from: io.flutter.embedding.android.NFlutterActivityInjector */
public interface NFlutterActivityInjector {

    /* renamed from: io.flutter.embedding.android.NFlutterActivityInjector$Observer */
    public interface Observer {
        @Deprecated
        void onActivityDestroy();

        @Deprecated
        void onActivityStop();

        void onTrimMemory(int i);
    }

    void injectFlutterActivityObserver(Observer observer);

    void releaseObserver();
}
