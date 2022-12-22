package com.didiglobal.enginecore.littleboy;

import android.os.Handler;
import android.os.Looper;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class LBTaskManager {

    /* renamed from: a */
    private static Handler f50185a = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public List<ILBTask> f50186b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f50187c;

    /* renamed from: d */
    private boolean f50188d;

    private LBTaskManager() {
        this.f50186b = new CopyOnWriteArrayList();
        this.f50188d = true;
    }

    private static class LBTaskManagerHolder {
        /* access modifiers changed from: private */
        public static final LBTaskManager INSTANCE = new LBTaskManager();

        private LBTaskManagerHolder() {
        }
    }

    public static LBTaskManager getInstance() {
        return LBTaskManagerHolder.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void call(com.didiglobal.enginecore.littleboy.LBAbility r6) {
        /*
            r5 = this;
            android.content.Context r0 = r6.getContext()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            boolean r0 = r5.f50188d
            if (r0 == 0) goto L_0x0084
            r0 = 0
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            android.os.Looper r2 = android.os.Looper.myLooper()
            if (r1 != r2) goto L_0x001b
            android.os.MessageQueue r0 = android.os.Looper.myQueue()
            goto L_0x006b
        L_0x001b:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r1 < r2) goto L_0x002a
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            android.os.MessageQueue r0 = r0.getQueue()
            goto L_0x006b
        L_0x002a:
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            java.lang.Class r2 = r1.getClass()     // Catch:{ NoSuchFieldException -> 0x0063, IllegalAccessException -> 0x005b }
            java.lang.String r3 = "mQueue"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x0063, IllegalAccessException -> 0x005b }
            r3 = 1
            r2.setAccessible(r3)     // Catch:{ NoSuchFieldException -> 0x0063, IllegalAccessException -> 0x005b }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ NoSuchFieldException -> 0x0063, IllegalAccessException -> 0x005b }
            android.os.MessageQueue r1 = (android.os.MessageQueue) r1     // Catch:{ NoSuchFieldException -> 0x0063, IllegalAccessException -> 0x005b }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ NoSuchFieldException -> 0x0059, IllegalAccessException -> 0x0057 }
            r0.<init>()     // Catch:{ NoSuchFieldException -> 0x0059, IllegalAccessException -> 0x0057 }
            java.lang.String r2 = "main thread MessageQueue: "
            r0.append(r2)     // Catch:{ NoSuchFieldException -> 0x0059, IllegalAccessException -> 0x0057 }
            r0.append(r1)     // Catch:{ NoSuchFieldException -> 0x0059, IllegalAccessException -> 0x0057 }
            java.lang.String r0 = r0.toString()     // Catch:{ NoSuchFieldException -> 0x0059, IllegalAccessException -> 0x0057 }
            com.android.didi.bfflib.utils.BffLog.m1480d(r0)     // Catch:{ NoSuchFieldException -> 0x0059, IllegalAccessException -> 0x0057 }
            goto L_0x006a
        L_0x0057:
            r0 = move-exception
            goto L_0x005f
        L_0x0059:
            r0 = move-exception
            goto L_0x0067
        L_0x005b:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x005f:
            r0.printStackTrace()
            goto L_0x006a
        L_0x0063:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0067:
            r0.printStackTrace()
        L_0x006a:
            r0 = r1
        L_0x006b:
            if (r0 == 0) goto L_0x0075
            com.didiglobal.enginecore.littleboy.LBTaskManager$1 r1 = new com.didiglobal.enginecore.littleboy.LBTaskManager$1
            r1.<init>()
            r0.addIdleHandler(r1)
        L_0x0075:
            android.os.Handler r0 = f50185a
            com.didiglobal.enginecore.littleboy.LBTaskManager$2 r1 = new com.didiglobal.enginecore.littleboy.LBTaskManager$2
            r1.<init>()
            r2 = 200(0xc8, double:9.9E-322)
            r0.postDelayed(r1, r2)
            r0 = 0
            r5.f50188d = r0
        L_0x0084:
            java.util.List<com.didiglobal.enginecore.littleboy.ILBTask> r0 = r5.f50186b
            int r0 = r0.size()
            if (r0 != 0) goto L_0x009a
            java.util.List<com.didiglobal.enginecore.littleboy.ILBTask> r0 = r5.f50186b
            com.didiglobal.enginecore.littleboy.LBBaseTask r1 = createTask(r6)
            com.didiglobal.enginecore.littleboy.ILBTask r6 = r1.addAbility(r6)
            r0.add(r6)
            return
        L_0x009a:
            java.util.List<com.didiglobal.enginecore.littleboy.ILBTask> r0 = r5.f50186b
            java.util.Iterator r0 = r0.iterator()
        L_0x00a0:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00b6
            java.lang.Object r1 = r0.next()
            com.didiglobal.enginecore.littleboy.ILBTask r1 = (com.didiglobal.enginecore.littleboy.ILBTask) r1
            boolean r2 = r1.canAddAbilityInThisTask(r6)
            if (r2 == 0) goto L_0x00a0
            r1.addAbility(r6)
            return
        L_0x00b6:
            java.util.List<com.didiglobal.enginecore.littleboy.ILBTask> r0 = r5.f50186b
            com.didiglobal.enginecore.littleboy.LBBaseTask r1 = createTask(r6)
            com.didiglobal.enginecore.littleboy.ILBTask r6 = r1.addAbility(r6)
            r0.add(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.enginecore.littleboy.LBTaskManager.call(com.didiglobal.enginecore.littleboy.LBAbility):void");
    }

    public void cancel(LBAbility lBAbility) {
        for (ILBTask next : this.f50186b) {
            LBBaseTask lBBaseTask = (LBBaseTask) next;
            if (lBBaseTask.mAbilityList.contains(lBAbility)) {
                if (next.getStatus() == 1) {
                    next.setStatus(3);
                }
                next.removeAbility(lBAbility.getRequestKey());
                if (lBBaseTask.mAbilityList.size() == 0) {
                    getInstance().f50186b.remove(next);
                    return;
                }
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36160a() {
        for (ILBTask next : this.f50186b) {
            if (next.getStatus() == 0) {
                next.requestAbilityInLoop(((LBBaseTask) next).mAbilityList);
            }
        }
        this.f50188d = true;
        this.f50187c = false;
    }

    public static LBBaseTask createTask(LBAbility lBAbility) {
        return new LBAnonymousTaskImpl(lBAbility.getContext()) {
            public void removeCache() {
                LBTaskManager.getInstance().f50186b.remove(this);
            }
        };
    }
}
