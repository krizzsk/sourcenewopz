package com.didi.beatles.p099im.common;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.beatles.p099im.utils.IMLog;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.didi.beatles.im.common.IMLifecycleHandler */
public class IMLifecycleHandler {

    /* renamed from: a */
    private static final String f9144a = "IMLifecycleHandler";

    /* renamed from: b */
    private static final boolean f9145b = Log.isLoggable(f9144a, 3);

    private IMLifecycleHandler() {
    }

    /* renamed from: a */
    private static LifeCycleController m6205a() {
        return new LifeCycleController();
    }

    /* renamed from: b */
    private static SupportLifeCycleController m6207b() {
        return new SupportLifeCycleController();
    }

    public static Controller attach(Activity activity) {
        if (activity instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) activity;
            Fragment findFragmentByTag = fragmentActivity.getSupportFragmentManager().findFragmentByTag(f9144a);
            if (findFragmentByTag == null || !(findFragmentByTag instanceof SupportLifeCycleController)) {
                SupportLifeCycleController b = m6207b();
                fragmentActivity.getSupportFragmentManager().beginTransaction().add((Fragment) b, f9144a).commit();
                return b.controller;
            }
            m6208c();
            return ((SupportLifeCycleController) findFragmentByTag).controller;
        }
        android.app.Fragment findFragmentByTag2 = activity.getFragmentManager().findFragmentByTag(f9144a);
        if (findFragmentByTag2 == null || !(findFragmentByTag2 instanceof LifeCycleController)) {
            LifeCycleController a = m6205a();
            activity.getFragmentManager().beginTransaction().add(a, f9144a).commit();
            return a.controller;
        }
        m6208c();
        return ((LifeCycleController) findFragmentByTag2).controller;
    }

    /* renamed from: a */
    private static void m6206a(Activity activity) {
        if (activity instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) activity;
            Fragment findFragmentByTag = fragmentActivity.getSupportFragmentManager().findFragmentByTag(f9144a);
            if (findFragmentByTag != null) {
                fragmentActivity.getSupportFragmentManager().beginTransaction().remove(findFragmentByTag).commit();
                return;
            }
            return;
        }
        android.app.Fragment findFragmentByTag2 = activity.getFragmentManager().findFragmentByTag(f9144a);
        if (findFragmentByTag2 != null) {
            activity.getFragmentManager().beginTransaction().remove(findFragmentByTag2).commit();
        }
    }

    /* renamed from: c */
    private static void m6208c() {
        IMLog.m6631d(f9144a, "attach: Controller already attached. Abort this one.");
    }

    /* renamed from: com.didi.beatles.im.common.IMLifecycleHandler$LifeCycleController */
    public static class LifeCycleController extends android.app.Fragment {
        /* access modifiers changed from: private */
        public Controller controller = new Controller();

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
        }

        public void onPause() {
            super.onPause();
            this.controller.onPause();
        }

        public void onResume() {
            super.onResume();
            this.controller.onResume();
        }

        public void onDestroy() {
            super.onDestroy();
        }
    }

    /* renamed from: com.didi.beatles.im.common.IMLifecycleHandler$SupportLifeCycleController */
    public static class SupportLifeCycleController extends Fragment {
        /* access modifiers changed from: private */
        public Controller controller = new Controller();

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
        }

        public void onPause() {
            super.onPause();
            this.controller.onPause();
        }

        public void onResume() {
            super.onResume();
            this.controller.onResume();
        }

        public void onDestroy() {
            super.onDestroy();
        }
    }

    /* renamed from: com.didi.beatles.im.common.IMLifecycleHandler$Controller */
    public static class Controller implements IMBaseLifecycle {
        private boolean abortMsgAfterPause;
        private Handler handler;
        private boolean isResumed;
        private Queue<Runnable> pendingMsg;

        public void onCreate() {
        }

        public void onDestroy() {
        }

        private Controller() {
            this.isResumed = false;
            this.pendingMsg = new LinkedList();
            this.abortMsgAfterPause = false;
            this.handler = new Handler(Looper.getMainLooper());
        }

        public void setAbortMsgAfterPause(boolean z) {
            this.abortMsgAfterPause = z;
        }

        public void onResume() {
            this.isResumed = true;
            while (!this.pendingMsg.isEmpty()) {
                post(this.pendingMsg.remove());
            }
        }

        public void onPause() {
            this.isResumed = false;
        }

        public void post(Runnable runnable) {
            if (this.isResumed) {
                this.handler.post(runnable);
            } else if (!this.abortMsgAfterPause) {
                this.pendingMsg.add(runnable);
            }
        }
    }
}
