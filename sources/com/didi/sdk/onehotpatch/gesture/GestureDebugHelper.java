package com.didi.sdk.onehotpatch.gesture;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GesturePoint;
import android.gesture.GestureStore;
import android.gesture.GestureStroke;
import android.gesture.Prediction;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Window;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import com.didi.sdk.onehotpatch.commonstatic.util.ConfigManager;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.security.safecollector.WsgSecInfo;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GestureDebugHelper {
    private static final int CLEAR_INVALID_POINTS = 5000;
    private static final int INTERVAL_REQUEST_CALLBACK = 10000;
    private static final String MSG_CLEAR_INVALID_POINTS_TOKEN = "_clear_invalid_points_token";
    private static final String MSG_SET_CALLBACK_TOKEN = "_set_callback";
    private static final int SET_CALLBACK_ATTEMPT_COUNT = 4;
    private static final int WHAT_READ_SP_FILE = 2;
    private static final int WHAT_RECOGNIZE_GESTURE = 1;
    /* access modifiers changed from: private */
    public static Map<Integer, String> callbackTokenMap = new HashMap();
    /* access modifiers changed from: private */
    public static Map<Integer, String> clearTokenMap = new HashMap();
    /* access modifiers changed from: private */
    public static Context context;
    /* access modifiers changed from: private */
    public static boolean gestureDebugSwitch = false;
    /* access modifiers changed from: private */
    public static GestureStore gestureStore;
    /* access modifiers changed from: private */
    public static Handler uiHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public static WorkHandler workHandler;

    public static void init(Application application) {
        registerActivityLifecycleCallback(application);
    }

    private static void registerActivityLifecycleCallback(Application application) {
        context = application;
        HandlerThread handlerThread = new HandlerThread("gesture_work_thread");
        handlerThread.start();
        WorkHandler workHandler2 = new WorkHandler(handlerThread.getLooper());
        workHandler = workHandler2;
        workHandler2.sendEmptyMessage(2);
        application.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacksImpl());
    }

    public static void setWindowCallBack(Activity activity) {
        Window.Callback callback;
        if (activity != null && activity.getWindow() != null && (callback = activity.getWindow().getCallback()) != null && !(callback instanceof WinCallback)) {
            Map<Integer, String> map = callbackTokenMap;
            Integer valueOf = Integer.valueOf(identityHashCode(activity));
            map.put(valueOf, identityHashCode(activity) + MSG_SET_CALLBACK_TOKEN);
            Map<Integer, String> map2 = clearTokenMap;
            Integer valueOf2 = Integer.valueOf(identityHashCode(activity));
            map2.put(valueOf2, identityHashCode(activity) + MSG_CLEAR_INVALID_POINTS_TOKEN);
            uiHandler.removeCallbacksAndMessages(callbackTokenMap.get(Integer.valueOf(identityHashCode(activity))));
            uiHandler.removeCallbacksAndMessages(clearTokenMap.get(Integer.valueOf(identityHashCode(activity))));
            ProxyInvoke proxyInvoke = new ProxyInvoke(callback, activity);
            activity.getWindow().setCallback(proxyInvoke.getProxy());
            uiHandler.postDelayed(proxyInvoke, callbackTokenMap.get(Integer.valueOf(identityHashCode(activity))), 10000);
        }
    }

    public static int identityHashCode(Object obj) {
        return System.identityHashCode(obj);
    }

    private static class ActivityLifecycleCallbacksImpl implements Application.ActivityLifecycleCallbacks {
        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        private ActivityLifecycleCallbacksImpl() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            GestureDebugHelper.workHandler.sendEmptyMessage(2);
            Logger.log("gestureDebugSwitch " + GestureDebugHelper.gestureDebugSwitch, new Object[0]);
            if (GestureDebugHelper.gestureDebugSwitch) {
                String string = ConfigManager.getString(GestureDebugHelper.context, "gesture_debug_page", "");
                boolean z = true;
                if (!TextUtils.isEmpty(string)) {
                    String[] split = string.substring(1, string.length() - 1).replace(Const.jsQuote, "").split(",");
                    String name = activity.getClass().getName();
                    String substring = name.substring(name.lastIndexOf(".") + 1);
                    if (!(split == null || split.length == 0)) {
                        boolean z2 = false;
                        for (String str : split) {
                            if (TextUtils.isEmpty(str) || TextUtils.equals(substring, str)) {
                                z2 = true;
                            }
                        }
                        z = z2;
                    }
                }
                Logger.log("curPageGestureDebug " + z, new Object[0]);
                if (z) {
                    GestureDebugHelper.setWindowCallBack(activity);
                }
            }
        }

        public void onActivityDestroyed(Activity activity) {
            if (GestureDebugHelper.callbackTokenMap.containsKey(Integer.valueOf(GestureDebugHelper.identityHashCode(activity))) && GestureDebugHelper.callbackTokenMap.get(Integer.valueOf(GestureDebugHelper.identityHashCode(activity))) != null) {
                GestureDebugHelper.uiHandler.removeCallbacksAndMessages(GestureDebugHelper.callbackTokenMap.get(Integer.valueOf(GestureDebugHelper.identityHashCode(activity))));
                GestureDebugHelper.callbackTokenMap.remove(Integer.valueOf(GestureDebugHelper.identityHashCode(activity)));
            }
            if (GestureDebugHelper.clearTokenMap.containsKey(Integer.valueOf(GestureDebugHelper.identityHashCode(activity))) && GestureDebugHelper.clearTokenMap.get(Integer.valueOf(GestureDebugHelper.identityHashCode(activity))) != null) {
                GestureDebugHelper.uiHandler.removeCallbacksAndMessages(GestureDebugHelper.clearTokenMap.get(Integer.valueOf(GestureDebugHelper.identityHashCode(activity))));
                GestureDebugHelper.clearTokenMap.remove(Integer.valueOf(GestureDebugHelper.identityHashCode(activity)));
            }
        }
    }

    private static class ProxyInvoke implements Runnable, InvocationHandler {
        private WeakReference<Activity> activityWeakReference;
        public int anotherPointerEventCount = 0;
        private int attemptCount = 0;
        private String callbackMsgToken;
        private String clearMsgToken;
        private ClearTask clearTask = new ClearTask();
        private long downMillis = 0;
        public int fristPoniterEventCount = 0;
        private boolean isListeningForGestures;
        private boolean mointorGesture = true;
        private int pointIndex = 0;
        private ArrayList<GesturePoint> strokeBuffer = new ArrayList<>();
        private Window.Callback winCallback;
        private WinCallback winCallbackProxy;
        private CircleQueue xyCoordQueue = new CircleQueue();

        public ProxyInvoke(Window.Callback callback, Activity activity) {
            this.winCallbackProxy = (WinCallback) Proxy.newProxyInstance(callback.getClass().getClassLoader(), new Class[]{WinCallback.class}, this);
            this.activityWeakReference = new WeakReference<>(activity);
            this.winCallback = callback;
            this.callbackMsgToken = (String) GestureDebugHelper.callbackTokenMap.get(Integer.valueOf(GestureDebugHelper.identityHashCode(activity)));
            this.clearMsgToken = (String) GestureDebugHelper.clearTokenMap.get(Integer.valueOf(GestureDebugHelper.identityHashCode(activity)));
        }

        public WinCallback getProxy() {
            return this.winCallbackProxy;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (method.getName().equals("dispatchTouchEvent") && this.mointorGesture && objArr != null && (objArr[0] instanceof MotionEvent) && ((Activity) this.activityWeakReference.get()) != null) {
                processEvent(objArr[0]);
            }
            return method.invoke(this.winCallback, objArr);
        }

        public void run() {
            this.attemptCount++;
            Activity activity = (Activity) this.activityWeakReference.get();
            if (activity == null || this.attemptCount >= 4) {
                this.mointorGesture = false;
                this.xyCoordQueue.clear();
                this.strokeBuffer.clear();
                GestureDebugHelper.uiHandler.removeCallbacksAndMessages(this.callbackMsgToken);
                GestureDebugHelper.uiHandler.removeCallbacksAndMessages(this.clearMsgToken);
                return;
            }
            GestureDebugHelper.setWindowCallBack(activity);
            GestureDebugHelper.uiHandler.postDelayed(this, this.callbackMsgToken, 10000);
        }

        private void processEvent(MotionEvent motionEvent) {
            GestureDebugHelper.uiHandler.removeCallbacksAndMessages(this.clearMsgToken);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            if (actionMasked != 5) {
                                if (actionMasked == 6 && this.isListeningForGestures) {
                                    this.anotherPointerEventCount++;
                                    return;
                                }
                                return;
                            } else if (this.isListeningForGestures) {
                                this.anotherPointerEventCount = 1;
                                return;
                            } else {
                                return;
                            }
                        }
                    } else if (this.isListeningForGestures) {
                        int i = this.pointIndex + 1;
                        this.pointIndex = i;
                        if (i % 3 == 0) {
                            this.xyCoordQueue.enqueue(motionEvent.getX());
                            this.xyCoordQueue.enqueue(motionEvent.getY());
                        }
                        if (motionEvent.getPointerCount() == 2) {
                            this.anotherPointerEventCount++;
                        }
                        this.fristPoniterEventCount++;
                        this.clearTask.strokeBuffer = this.strokeBuffer;
                        this.clearTask.xyCoordQueue = this.xyCoordQueue;
                        GestureDebugHelper.uiHandler.postDelayed(this.clearTask, this.clearMsgToken, 5000);
                        return;
                    } else {
                        return;
                    }
                }
                if (SystemClock.uptimeMillis() - this.downMillis > 5000) {
                    this.xyCoordQueue.clear();
                } else if (this.isListeningForGestures) {
                    this.fristPoniterEventCount++;
                    touchUp();
                }
            } else {
                this.fristPoniterEventCount = 1;
                this.anotherPointerEventCount = 0;
                this.xyCoordQueue.clear();
                this.strokeBuffer.clear();
                this.downMillis = SystemClock.uptimeMillis();
                this.isListeningForGestures = true;
                this.xyCoordQueue.enqueue(motionEvent.getX());
                this.xyCoordQueue.enqueue(motionEvent.getY());
                this.clearTask.strokeBuffer = this.strokeBuffer;
                this.clearTask.xyCoordQueue = this.xyCoordQueue;
                GestureDebugHelper.uiHandler.postDelayed(this.clearTask, this.clearMsgToken, 5000);
            }
        }

        private void touchUp() {
            this.isListeningForGestures = false;
            this.pointIndex = 0;
            if (this.xyCoordQueue.queueLength() <= 20) {
                this.xyCoordQueue.clear();
                this.strokeBuffer.clear();
            } else if (Math.abs(this.fristPoniterEventCount - this.anotherPointerEventCount) > 10) {
                Logger.log("不是两个手指同时绘制的轨迹", new Object[0]);
                this.xyCoordQueue.clear();
                this.strokeBuffer.clear();
            } else {
                float[] dequeueAll = this.xyCoordQueue.dequeueAll();
                for (int i = 0; i < dequeueAll.length; i += 2) {
                    this.strokeBuffer.add(new GesturePoint(dequeueAll[i], dequeueAll[i + 1], -1));
                }
                Gesture gesture = new Gesture();
                gesture.addStroke(new GestureStroke(this.strokeBuffer));
                this.xyCoordQueue.clear();
                this.strokeBuffer.clear();
                Message obtain = Message.obtain();
                obtain.obj = gesture;
                obtain.what = 1;
                GestureDebugHelper.workHandler.sendMessage(obtain);
            }
        }
    }

    private static class ClearTask implements Runnable {
        public ArrayList<GesturePoint> strokeBuffer;
        public CircleQueue xyCoordQueue;

        public void run() {
            ArrayList<GesturePoint> arrayList = this.strokeBuffer;
            if (arrayList != null) {
                arrayList.clear();
                this.strokeBuffer = null;
            }
            CircleQueue circleQueue = this.xyCoordQueue;
            if (circleQueue != null) {
                circleQueue.clear();
                this.xyCoordQueue = null;
            }
        }
    }

    private static class WorkHandler extends Handler {
        public WorkHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                try {
                    if (GestureDebugHelper.gestureStore == null) {
                        GestureStore unused = GestureDebugHelper.gestureStore = new GestureStore();
                        GestureDebugHelper.gestureStore.load(GestureDebugHelper.context.getAssets().open("hotpatch_gesture"), true);
                    }
                    ArrayList<Prediction> recognize = GestureDebugHelper.gestureStore.recognize((Gesture) message.obj);
                    if (recognize != null) {
                        Iterator<Prediction> it = recognize.iterator();
                        while (it.hasNext()) {
                            Prediction next = it.next();
                            Logger.log("手势匹配分数:" + next.score, new Object[0]);
                            if (next.score > 5.0d) {
                                Intent intent = new Intent("com.didi.sdk.onehotpatch.debug");
                                intent.addFlags(268435456);
                                intent.setPackage(WsgSecInfo.packageName(GestureDebugHelper.context));
                                GestureDebugHelper.context.startActivity(intent);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (i == 2) {
                boolean unused2 = GestureDebugHelper.gestureDebugSwitch = ConfigManager.getBoolean(GestureDebugHelper.context, "gesture_debug_switch", false);
                Logger.log("read gestureDebugSwitch from sp: " + GestureDebugHelper.gestureDebugSwitch, new Object[0]);
            }
        }
    }
}
