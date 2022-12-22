package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.didichuxing.bigdata.p173dp.locsdk.Const;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.ThreadDispatcher */
public class ThreadDispatcher {

    /* renamed from: a */
    private static final IThreadDispatcher f45904a = new MainThreadDispatcher();

    /* renamed from: b */
    private static final IThreadDispatcher f45905b = new WorkThreadDispatcher();

    /* renamed from: c */
    private static final IThreadDispatcher f45906c = new NetThreadDispatcher();

    /* renamed from: d */
    private static final IThreadDispatcher f45907d = new FLPReuestDIDINLPThreadDispatcher();

    /* renamed from: e */
    private static final IThreadDispatcher f45908e = new StatThreadDispatcher();

    /* renamed from: f */
    private static final IThreadDispatcher f45909f = new ExtraWorkThreadDispatcher();

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.ThreadDispatcher$IThreadDispatcher */
    public interface IThreadDispatcher {
        Handler getHandler();

        Looper getLooper();

        boolean isAlive();

        boolean isCurrentThread();

        void post(Runnable runnable);

        void postDelayed(int i, Runnable runnable, long j);

        void postDelayed(Runnable runnable, long j);

        void removeCallbacks(int i);

        void removeCallbacks(Runnable runnable);

        void run(Runnable runnable);

        void start();

        void stop();
    }

    public static IThreadDispatcher getMainThread() {
        return f45904a;
    }

    public static IThreadDispatcher getWorkThread() {
        return f45905b;
    }

    public static IThreadDispatcher getNetThread() {
        return f45906c;
    }

    public static IThreadDispatcher getFlpRequestDidiNlpThread() {
        return f45907d;
    }

    public static IThreadDispatcher getStatThread() {
        return f45908e;
    }

    public static IThreadDispatcher getExtraWorkThread() {
        return f45909f;
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.ThreadDispatcher$AbsThreadDispatcher */
    private static abstract class AbsThreadDispatcher implements IThreadDispatcher {
        Handler mThreadHandler;

        private AbsThreadDispatcher() {
            this.mThreadHandler = null;
        }

        public boolean isAlive() {
            return this.mThreadHandler != null;
        }

        public boolean isCurrentThread() {
            return getLooper() == Looper.myLooper();
        }

        public Handler getHandler() {
            return this.mThreadHandler;
        }

        /* access modifiers changed from: package-private */
        public void setHandler(Handler handler) {
            this.mThreadHandler = handler;
        }

        public Looper getLooper() {
            Handler handler = this.mThreadHandler;
            if (handler != null) {
                return handler.getLooper();
            }
            return null;
        }

        public void run(Runnable runnable) {
            if (this.mThreadHandler != null && runnable != null) {
                if (Looper.myLooper() == this.mThreadHandler.getLooper()) {
                    runnable.run();
                } else {
                    this.mThreadHandler.post(runnable);
                }
            }
        }

        public void post(Runnable runnable) {
            Handler handler = this.mThreadHandler;
            if (handler != null && runnable != null) {
                handler.post(runnable);
            }
        }

        public void postDelayed(Runnable runnable, long j) {
            Handler handler = this.mThreadHandler;
            if (handler != null && runnable != null && j >= 0) {
                handler.postDelayed(runnable, j);
            }
        }

        public void postDelayed(int i, Runnable runnable, long j) {
            Handler handler = this.mThreadHandler;
            if (handler != null && runnable != null && j >= 0) {
                Message obtain = Message.obtain(handler, runnable);
                obtain.what = i;
                this.mThreadHandler.sendMessageDelayed(obtain, j);
            }
        }

        public void removeCallbacks(Runnable runnable) {
            Handler handler = this.mThreadHandler;
            if (handler != null) {
                handler.removeCallbacks(runnable);
            }
        }

        public void removeCallbacks(int i) {
            Handler handler = this.mThreadHandler;
            if (handler != null) {
                handler.removeMessages(i);
            }
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.ThreadDispatcher$MainThreadDispatcher */
    private static class MainThreadDispatcher extends AbsThreadDispatcher {
        public void start() {
        }

        public void stop() {
        }

        private MainThreadDispatcher() {
            super();
            setHandler(new Handler(Looper.getMainLooper()));
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.ThreadDispatcher$WorkThreadDispatcher */
    private static class WorkThreadDispatcher extends AbsThreadDispatcher {
        private WorkThreadDispatcher() {
            super();
        }

        public void start() {
            if (getHandler() == null) {
                HandlerThread handlerThread = new HandlerThread("LocSDKWorkThread[" + System.currentTimeMillis() + Const.jaRight, -1);
                handlerThread.start();
                setHandler(new Handler(handlerThread.getLooper()));
            }
        }

        public void stop() {
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
                handler.getLooper().quit();
                setHandler((Handler) null);
            }
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.ThreadDispatcher$NetThreadDispatcher */
    private static class NetThreadDispatcher extends AbsThreadDispatcher {
        private NetThreadDispatcher() {
            super();
        }

        public void start() {
            if (getHandler() == null) {
                HandlerThread handlerThread = new HandlerThread("LocSDKNetThread[" + System.currentTimeMillis() + Const.jaRight, -1);
                handlerThread.start();
                setHandler(new Handler(handlerThread.getLooper()));
            }
        }

        public void stop() {
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
                handler.getLooper().quit();
                setHandler((Handler) null);
            }
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.ThreadDispatcher$FLPReuestDIDINLPThreadDispatcher */
    private static class FLPReuestDIDINLPThreadDispatcher extends AbsThreadDispatcher {
        private FLPReuestDIDINLPThreadDispatcher() {
            super();
        }

        public void start() {
            if (getHandler() == null) {
                HandlerThread handlerThread = new HandlerThread("FLPReuestDIDINLPThread[" + System.currentTimeMillis() + Const.jaRight, -1);
                handlerThread.start();
                setHandler(new Handler(handlerThread.getLooper()));
            }
        }

        public void stop() {
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
                handler.getLooper().quit();
                setHandler((Handler) null);
            }
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.ThreadDispatcher$StatThreadDispatcher */
    private static class StatThreadDispatcher extends AbsThreadDispatcher {
        private StatThreadDispatcher() {
            super();
        }

        public void start() {
            if (getHandler() == null) {
                HandlerThread handlerThread = new HandlerThread("StatThreadDispatcher[" + System.currentTimeMillis() + Const.jaRight, 10);
                handlerThread.start();
                setHandler(new Handler(handlerThread.getLooper()));
            }
        }

        public void stop() {
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
                handler.getLooper().quit();
                setHandler((Handler) null);
            }
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.ThreadDispatcher$ExtraWorkThreadDispatcher */
    private static class ExtraWorkThreadDispatcher extends AbsThreadDispatcher {
        private ExtraWorkThreadDispatcher() {
            super();
        }

        public void start() {
            if (getHandler() == null) {
                HandlerThread handlerThread = new HandlerThread("ExtraWorkThread[" + System.currentTimeMillis() + Const.jaRight, 0);
                handlerThread.start();
                setHandler(new Handler(handlerThread.getLooper()));
            }
        }

        public void stop() {
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
                handler.getLooper().quit();
                setHandler((Handler) null);
            }
        }
    }
}
