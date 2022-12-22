package p242io.flutter.embedding.engine.dart;

import androidx.tracing.Trace;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import p242io.flutter.FlutterInjector;
import p242io.flutter.Log;
import p242io.flutter.embedding.engine.FlutterJNI;
import p242io.flutter.embedding.engine.dart.DartMessenger;
import p242io.flutter.plugin.common.BinaryMessenger;

/* renamed from: io.flutter.embedding.engine.dart.DartMessenger */
class DartMessenger implements PlatformMessageHandler, BinaryMessenger {

    /* renamed from: a */
    private static final String f57610a = "DartMessenger";

    /* renamed from: b */
    private final FlutterJNI f57611b;

    /* renamed from: c */
    private final Map<String, HandlerInfo> f57612c;

    /* renamed from: d */
    private Map<String, List<BufferedMessageInfo>> f57613d;

    /* renamed from: e */
    private final Object f57614e;

    /* renamed from: f */
    private final AtomicBoolean f57615f;

    /* renamed from: g */
    private final Map<Integer, BinaryMessenger.BinaryReply> f57616g;

    /* renamed from: h */
    private int f57617h;

    /* renamed from: i */
    private final DartMessengerTaskQueue f57618i;

    /* renamed from: j */
    private WeakHashMap<BinaryMessenger.TaskQueue, DartMessengerTaskQueue> f57619j;

    /* renamed from: k */
    private TaskQueueFactory f57620k;

    /* renamed from: io.flutter.embedding.engine.dart.DartMessenger$DartMessengerTaskQueue */
    interface DartMessengerTaskQueue {
        void dispatch(Runnable runnable);
    }

    /* renamed from: io.flutter.embedding.engine.dart.DartMessenger$TaskQueueFactory */
    interface TaskQueueFactory {
        DartMessengerTaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions);
    }

    public /* synthetic */ BinaryMessenger.TaskQueue makeBackgroundTaskQueue() {
        return BinaryMessenger.CC.$default$makeBackgroundTaskQueue(this);
    }

    DartMessenger(FlutterJNI flutterJNI, TaskQueueFactory taskQueueFactory) {
        this.f57612c = new HashMap();
        this.f57613d = new HashMap();
        this.f57614e = new Object();
        this.f57615f = new AtomicBoolean(false);
        this.f57616g = new HashMap();
        this.f57617h = 1;
        this.f57618i = new PlatformTaskQueue();
        this.f57619j = new WeakHashMap<>();
        this.f57611b = flutterJNI;
        this.f57620k = taskQueueFactory;
    }

    DartMessenger(FlutterJNI flutterJNI) {
        this(flutterJNI, new DefaultTaskQueueFactory());
    }

    /* renamed from: io.flutter.embedding.engine.dart.DartMessenger$TaskQueueToken */
    private static class TaskQueueToken implements BinaryMessenger.TaskQueue {
        private TaskQueueToken() {
        }
    }

    /* renamed from: io.flutter.embedding.engine.dart.DartMessenger$DefaultTaskQueueFactory */
    private static class DefaultTaskQueueFactory implements TaskQueueFactory {
        ExecutorService executorService = FlutterInjector.instance().executorService();

        DefaultTaskQueueFactory() {
        }

        public DartMessengerTaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions) {
            if (taskQueueOptions.getIsSerial()) {
                return new SerialTaskQueue(this.executorService);
            }
            return new ConcurrentTaskQueue(this.executorService);
        }
    }

    /* renamed from: io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo */
    private static class HandlerInfo {
        public final BinaryMessenger.BinaryMessageHandler handler;
        public final DartMessengerTaskQueue taskQueue;

        HandlerInfo(BinaryMessenger.BinaryMessageHandler binaryMessageHandler, DartMessengerTaskQueue dartMessengerTaskQueue) {
            this.handler = binaryMessageHandler;
            this.taskQueue = dartMessengerTaskQueue;
        }
    }

    /* renamed from: io.flutter.embedding.engine.dart.DartMessenger$BufferedMessageInfo */
    private static class BufferedMessageInfo {
        public final ByteBuffer message;
        long messageData;
        int replyId;

        BufferedMessageInfo(ByteBuffer byteBuffer, int i, long j) {
            this.message = byteBuffer;
            this.replyId = i;
            this.messageData = j;
        }
    }

    /* renamed from: io.flutter.embedding.engine.dart.DartMessenger$ConcurrentTaskQueue */
    static class ConcurrentTaskQueue implements DartMessengerTaskQueue {
        private final ExecutorService executor;

        ConcurrentTaskQueue(ExecutorService executorService) {
            this.executor = executorService;
        }

        public void dispatch(Runnable runnable) {
            this.executor.execute(runnable);
        }
    }

    /* renamed from: io.flutter.embedding.engine.dart.DartMessenger$SerialTaskQueue */
    static class SerialTaskQueue implements DartMessengerTaskQueue {
        private final ExecutorService executor;
        private final AtomicBoolean isRunning = new AtomicBoolean(false);
        private final ConcurrentLinkedQueue<Runnable> queue = new ConcurrentLinkedQueue<>();

        SerialTaskQueue(ExecutorService executorService) {
            this.executor = executorService;
        }

        public void dispatch(Runnable runnable) {
            this.queue.add(runnable);
            this.executor.execute(new Runnable() {
                public final void run() {
                    DartMessenger.SerialTaskQueue.this.lambda$dispatch$0$DartMessenger$SerialTaskQueue();
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: flush */
        public void lambda$flush$1$DartMessenger$SerialTaskQueue() {
            if (this.isRunning.compareAndSet(false, true)) {
                try {
                    Runnable poll = this.queue.poll();
                    if (poll != null) {
                        poll.run();
                    }
                } finally {
                    this.isRunning.set(false);
                    if (!this.queue.isEmpty()) {
                        this.executor.execute(new Runnable() {
                            public final void run() {
                                DartMessenger.SerialTaskQueue.this.lambda$flush$1$DartMessenger$SerialTaskQueue();
                            }
                        });
                    }
                }
            }
        }
    }

    public BinaryMessenger.TaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions) {
        DartMessengerTaskQueue makeBackgroundTaskQueue = this.f57620k.makeBackgroundTaskQueue(taskQueueOptions);
        TaskQueueToken taskQueueToken = new TaskQueueToken();
        this.f57619j.put(taskQueueToken, makeBackgroundTaskQueue);
        return taskQueueToken;
    }

    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        setMessageHandler(str, binaryMessageHandler, (BinaryMessenger.TaskQueue) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0076, code lost:
        r10 = r10.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007e, code lost:
        if (r10.hasNext() == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0080, code lost:
        r11 = (p242io.flutter.embedding.engine.dart.DartMessenger.BufferedMessageInfo) r10.next();
        m41433a(r9, r8.f57612c.get(r9), r11.message, r11.replyId, r11.messageData);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setMessageHandler(java.lang.String r9, p242io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler r10, p242io.flutter.plugin.common.BinaryMessenger.TaskQueue r11) {
        /*
            r8 = this;
            if (r10 != 0) goto L_0x002a
            java.lang.String r10 = "DartMessenger"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Removing handler for channel '"
            r11.append(r0)
            r11.append(r9)
            java.lang.String r0 = "'"
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            p242io.flutter.Log.m41140v(r10, r11)
            java.lang.Object r0 = r8.f57614e
            monitor-enter(r0)
            java.util.Map<java.lang.String, io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo> r10 = r8.f57612c     // Catch:{ all -> 0x0027 }
            r10.remove(r9)     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x0027:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r9
        L_0x002a:
            r0 = 0
            if (r11 == 0) goto L_0x0041
            java.util.WeakHashMap<io.flutter.plugin.common.BinaryMessenger$TaskQueue, io.flutter.embedding.engine.dart.DartMessenger$DartMessengerTaskQueue> r0 = r8.f57619j
            java.lang.Object r11 = r0.get(r11)
            r0 = r11
            io.flutter.embedding.engine.dart.DartMessenger$DartMessengerTaskQueue r0 = (p242io.flutter.embedding.engine.dart.DartMessenger.DartMessengerTaskQueue) r0
            if (r0 == 0) goto L_0x0039
            goto L_0x0041
        L_0x0039:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Unrecognized TaskQueue, use BinaryMessenger to create your TaskQueue (ex makeBackgroundTaskQueue)."
            r9.<init>(r10)
            throw r9
        L_0x0041:
            java.lang.String r11 = "DartMessenger"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Setting handler for channel '"
            r1.append(r2)
            r1.append(r9)
            java.lang.String r2 = "'"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            p242io.flutter.Log.m41140v(r11, r1)
            java.lang.Object r11 = r8.f57614e
            monitor-enter(r11)
            java.util.Map<java.lang.String, io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo> r1 = r8.f57612c     // Catch:{ all -> 0x009c }
            io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo r2 = new io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo     // Catch:{ all -> 0x009c }
            r2.<init>(r10, r0)     // Catch:{ all -> 0x009c }
            r1.put(r9, r2)     // Catch:{ all -> 0x009c }
            java.util.Map<java.lang.String, java.util.List<io.flutter.embedding.engine.dart.DartMessenger$BufferedMessageInfo>> r10 = r8.f57613d     // Catch:{ all -> 0x009c }
            java.lang.Object r10 = r10.remove(r9)     // Catch:{ all -> 0x009c }
            java.util.List r10 = (java.util.List) r10     // Catch:{ all -> 0x009c }
            if (r10 != 0) goto L_0x0075
            monitor-exit(r11)     // Catch:{ all -> 0x009c }
            return
        L_0x0075:
            monitor-exit(r11)     // Catch:{ all -> 0x009c }
            java.util.Iterator r10 = r10.iterator()
        L_0x007a:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x009b
            java.lang.Object r11 = r10.next()
            io.flutter.embedding.engine.dart.DartMessenger$BufferedMessageInfo r11 = (p242io.flutter.embedding.engine.dart.DartMessenger.BufferedMessageInfo) r11
            java.util.Map<java.lang.String, io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo> r0 = r8.f57612c
            java.lang.Object r0 = r0.get(r9)
            r3 = r0
            io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo r3 = (p242io.flutter.embedding.engine.dart.DartMessenger.HandlerInfo) r3
            java.nio.ByteBuffer r4 = r11.message
            int r5 = r11.replyId
            long r6 = r11.messageData
            r1 = r8
            r2 = r9
            r1.m41433a(r2, r3, r4, r5, r6)
            goto L_0x007a
        L_0x009b:
            return
        L_0x009c:
            r9 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x009c }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p242io.flutter.embedding.engine.dart.DartMessenger.setMessageHandler(java.lang.String, io.flutter.plugin.common.BinaryMessenger$BinaryMessageHandler, io.flutter.plugin.common.BinaryMessenger$TaskQueue):void");
    }

    public void enableBufferingIncomingMessages() {
        this.f57615f.set(true);
    }

    public void disableBufferingIncomingMessages() {
        Map<String, List<BufferedMessageInfo>> map;
        synchronized (this.f57614e) {
            this.f57615f.set(false);
            map = this.f57613d;
            this.f57613d = new HashMap();
        }
        for (Map.Entry next : map.entrySet()) {
            for (BufferedMessageInfo bufferedMessageInfo : (List) next.getValue()) {
                m41433a((String) next.getKey(), (HandlerInfo) null, bufferedMessageInfo.message, bufferedMessageInfo.replyId, bufferedMessageInfo.messageData);
            }
        }
    }

    public void send(String str, ByteBuffer byteBuffer) {
        Log.m41140v(f57610a, "Sending message over channel '" + str + "'");
        send(str, byteBuffer, (BinaryMessenger.BinaryReply) null);
    }

    public void send(String str, ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
        Trace.beginSection("DartMessenger#send on " + str);
        Log.m41140v(f57610a, "Sending message with callback over channel '" + str + "'");
        try {
            int i = this.f57617h;
            this.f57617h = i + 1;
            if (binaryReply != null) {
                this.f57616g.put(Integer.valueOf(i), binaryReply);
            }
            if (byteBuffer == null) {
                this.f57611b.dispatchEmptyPlatformMessage(str, i);
            } else {
                this.f57611b.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i);
            }
        } finally {
            Trace.endSection();
        }
    }

    /* renamed from: a */
    private void m41431a(HandlerInfo handlerInfo, ByteBuffer byteBuffer, int i) {
        if (handlerInfo != null) {
            try {
                Log.m41140v(f57610a, "Deferring to registered handler to process message.");
                handlerInfo.handler.onMessage(byteBuffer, new Reply(this.f57611b, i));
            } catch (Exception e) {
                Log.m41137e(f57610a, "Uncaught exception in binary message listener", e);
                this.f57611b.invokePlatformMessageEmptyResponseCallback(i);
            } catch (Error e2) {
                m41432a(e2);
            }
        } else {
            Log.m41140v(f57610a, "No registered handler for message. Responding to Dart with empty reply message.");
            this.f57611b.invokePlatformMessageEmptyResponseCallback(i);
        }
    }

    /* renamed from: a */
    private void m41433a(String str, HandlerInfo handlerInfo, ByteBuffer byteBuffer, int i, long j) {
        HandlerInfo handlerInfo2 = handlerInfo;
        DartMessengerTaskQueue dartMessengerTaskQueue = handlerInfo2 != null ? handlerInfo2.taskQueue : null;
        $$Lambda$DartMessenger$3kX_ohgxwecVw1YG60ZOf3NN9OM r0 = new Runnable(str, handlerInfo, byteBuffer, i, j) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ DartMessenger.HandlerInfo f$2;
            public final /* synthetic */ ByteBuffer f$3;
            public final /* synthetic */ int f$4;
            public final /* synthetic */ long f$5;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
            }

            public final void run() {
                DartMessenger.this.m41434b(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
            }
        };
        if (dartMessengerTaskQueue == null) {
            dartMessengerTaskQueue = this.f57618i;
        }
        dartMessengerTaskQueue.dispatch(r0);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m41434b(String str, HandlerInfo handlerInfo, ByteBuffer byteBuffer, int i, long j) {
        Trace.beginSection("DartMessenger#handleMessageFromDart on " + str);
        try {
            m41431a(handlerInfo, byteBuffer, i);
            if (byteBuffer != null && byteBuffer.isDirect()) {
                byteBuffer.limit(0);
            }
        } finally {
            this.f57611b.cleanupMessageData(j);
            Trace.endSection();
        }
    }

    public void handleMessageFromDart(String str, ByteBuffer byteBuffer, int i, long j) {
        HandlerInfo handlerInfo;
        boolean z;
        Log.m41140v(f57610a, "Received message from Dart over channel '" + str + "'");
        synchronized (this.f57614e) {
            handlerInfo = this.f57612c.get(str);
            z = this.f57615f.get() && handlerInfo == null;
            if (z) {
                if (!this.f57613d.containsKey(str)) {
                    this.f57613d.put(str, new LinkedList());
                }
                this.f57613d.get(str).add(new BufferedMessageInfo(byteBuffer, i, j));
            }
        }
        if (!z) {
            m41433a(str, handlerInfo, byteBuffer, i, j);
        }
    }

    public void handlePlatformMessageResponse(int i, ByteBuffer byteBuffer) {
        Log.m41140v(f57610a, "Received message reply from Dart.");
        BinaryMessenger.BinaryReply remove = this.f57616g.remove(Integer.valueOf(i));
        if (remove != null) {
            try {
                Log.m41140v(f57610a, "Invoking registered callback for reply from Dart.");
                remove.reply(byteBuffer);
                if (byteBuffer != null && byteBuffer.isDirect()) {
                    byteBuffer.limit(0);
                }
            } catch (Exception e) {
                Log.m41137e(f57610a, "Uncaught exception in binary message reply handler", e);
            } catch (Error e2) {
                m41432a(e2);
            }
        }
    }

    /* renamed from: a */
    public int mo172510a() {
        return this.f57616g.size();
    }

    /* renamed from: a */
    private static void m41432a(Error error) {
        Thread currentThread = Thread.currentThread();
        if (currentThread.getUncaughtExceptionHandler() != null) {
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, error);
            return;
        }
        throw error;
    }

    /* renamed from: io.flutter.embedding.engine.dart.DartMessenger$Reply */
    static class Reply implements BinaryMessenger.BinaryReply {
        private final AtomicBoolean done = new AtomicBoolean(false);
        private final FlutterJNI flutterJNI;
        private final int replyId;

        Reply(FlutterJNI flutterJNI2, int i) {
            this.flutterJNI = flutterJNI2;
            this.replyId = i;
        }

        public void reply(ByteBuffer byteBuffer) {
            if (this.done.getAndSet(true)) {
                throw new IllegalStateException("Reply already submitted");
            } else if (byteBuffer == null) {
                this.flutterJNI.invokePlatformMessageEmptyResponseCallback(this.replyId);
            } else {
                this.flutterJNI.invokePlatformMessageResponseCallback(this.replyId, byteBuffer, byteBuffer.position());
            }
        }
    }
}
