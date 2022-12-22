package com.didi.beatles.p099im.task;

import com.didi.beatles.p099im.api.entity.GiftUploadResponse;
import com.didi.beatles.p099im.module.entity.IMMessage;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.didi.beatles.im.task.IMUploadQueue */
public class IMUploadQueue {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f9651a = IMUploadQueue.class.getSimpleName();

    /* renamed from: d */
    private static IMUploadQueue f9652d;

    /* renamed from: b */
    private Queue<TaskItem> f9653b = new LinkedList();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f9654c = false;

    /* renamed from: com.didi.beatles.im.task.IMUploadQueue$UploadCallback */
    public interface UploadCallback {
        void uploadFail(IMMessage iMMessage);

        void uploadSuccess(GiftUploadResponse giftUploadResponse, IMMessage iMMessage);
    }

    public static IMUploadQueue getInstance() {
        if (f9652d == null) {
            synchronized (IMUploadQueue.class) {
                if (f9652d == null) {
                    f9652d = new IMUploadQueue();
                }
            }
        }
        return f9652d;
    }

    private IMUploadQueue() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean offer(com.didi.beatles.p099im.module.entity.IMMessage r3, com.didi.beatles.p099im.task.IMUploadQueue.UploadCallback r4) {
        /*
            r2 = this;
            java.util.Queue<com.didi.beatles.im.task.IMUploadQueue$TaskItem> r0 = r2.f9653b
            monitor-enter(r0)
            com.didi.beatles.im.task.IMUploadQueue$TaskItem r1 = new com.didi.beatles.im.task.IMUploadQueue$TaskItem     // Catch:{ all -> 0x0021 }
            r1.<init>(r3, r4)     // Catch:{ all -> 0x0021 }
            java.util.Queue<com.didi.beatles.im.task.IMUploadQueue$TaskItem> r3 = r2.f9653b     // Catch:{ all -> 0x0021 }
            boolean r3 = r3.offer(r1)     // Catch:{ all -> 0x0021 }
            if (r3 == 0) goto L_0x001e
            java.util.Queue<com.didi.beatles.im.task.IMUploadQueue$TaskItem> r3 = r2.f9653b     // Catch:{ all -> 0x0021 }
            int r3 = r3.size()     // Catch:{ all -> 0x0021 }
            r4 = 1
            if (r3 != r4) goto L_0x001c
            r2.m6523c()     // Catch:{ all -> 0x0021 }
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            return r4
        L_0x001e:
            r3 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            return r3
        L_0x0021:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.task.IMUploadQueue.offer(com.didi.beatles.im.module.entity.IMMessage, com.didi.beatles.im.task.IMUploadQueue$UploadCallback):boolean");
    }

    /* renamed from: b */
    private TaskItem m6522b() {
        TaskItem poll;
        synchronized (this.f9653b) {
            poll = this.f9653b.poll();
        }
        return poll;
    }

    public boolean isEmpty() {
        return this.f9653b.isEmpty();
    }

    public void destory() {
        Queue<TaskItem> queue = this.f9653b;
        if (queue != null) {
            queue.clear();
            this.f9653b = null;
        }
        if (f9652d != null) {
            f9652d = null;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004c, code lost:
        return;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m6523c() {
        /*
            r5 = this;
            java.util.Queue<com.didi.beatles.im.task.IMUploadQueue$TaskItem> r0 = r5.f9653b
            monitor-enter(r0)
            boolean r1 = r5.f9654c     // Catch:{ all -> 0x004d }
            if (r1 == 0) goto L_0x0010
            java.lang.String r1 = f9651a     // Catch:{ all -> 0x004d }
            java.lang.String r2 = "loop is running,return"
            com.didi.beatles.p099im.utils.IMLog.m6631d(r1, r2)     // Catch:{ all -> 0x004d }
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            return
        L_0x0010:
            com.didi.beatles.im.task.IMUploadQueue$TaskItem r1 = r5.m6522b()     // Catch:{ all -> 0x004d }
            if (r1 == 0) goto L_0x0048
            java.lang.String r2 = f9651a     // Catch:{ all -> 0x004d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x004d }
            r3.<init>()     // Catch:{ all -> 0x004d }
            java.lang.String r4 = "start upload file "
            r3.append(r4)     // Catch:{ all -> 0x004d }
            com.didi.beatles.im.module.entity.IMMessage r4 = r1.message     // Catch:{ all -> 0x004d }
            java.lang.String r4 = r4.getFile_name()     // Catch:{ all -> 0x004d }
            r3.append(r4)     // Catch:{ all -> 0x004d }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x004d }
            com.didi.beatles.p099im.utils.IMLog.m6631d(r2, r3)     // Catch:{ all -> 0x004d }
            r2 = 1
            r5.f9654c = r2     // Catch:{ all -> 0x004d }
            com.didi.beatles.im.net.IMHttpManager r2 = com.didi.beatles.p099im.net.IMHttpManager.getInstance()     // Catch:{ all -> 0x004d }
            com.didi.beatles.im.module.entity.IMMessage r3 = r1.message     // Catch:{ all -> 0x004d }
            java.lang.String r3 = r3.getFile_name()     // Catch:{ all -> 0x004d }
            com.didi.beatles.im.task.IMUploadQueue$1 r4 = new com.didi.beatles.im.task.IMUploadQueue$1     // Catch:{ all -> 0x004d }
            r4.<init>(r1)     // Catch:{ all -> 0x004d }
            r2.upLoadImage(r3, r4)     // Catch:{ all -> 0x004d }
            goto L_0x004b
        L_0x0048:
            r1 = 0
            r5.f9654c = r1     // Catch:{ all -> 0x004d }
        L_0x004b:
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            return
        L_0x004d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.task.IMUploadQueue.m6523c():void");
    }

    /* renamed from: com.didi.beatles.im.task.IMUploadQueue$TaskItem */
    public class TaskItem {
        UploadCallback callback;
        IMMessage message;

        public TaskItem(IMMessage iMMessage, UploadCallback uploadCallback) {
            this.message = iMMessage;
            this.callback = uploadCallback;
        }
    }
}
