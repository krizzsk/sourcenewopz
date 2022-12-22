package com.android.didi.bfflib.task.taskmanager;

import android.os.Handler;
import android.os.Looper;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.android.didi.bfflib.concurrent.BffAbilityMapModel;
import com.android.didi.bfflib.concurrent.BffConcurrentFormStore;
import com.android.didi.bfflib.task.BffAnonymousProxyImpl;
import com.android.didi.bfflib.task.BffBaseProxyImpl;
import com.android.didi.bfflib.task.BffGroupProxyImpl;
import com.android.didi.bfflib.task.BffServiceProxyImpl;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class BffProxyManager {
    private static Handler mMainHandler = new Handler(Looper.getMainLooper());
    private boolean isFirstRequestInALoop;
    /* access modifiers changed from: private */
    public boolean isRequested;
    /* access modifiers changed from: private */
    public List<IBffProxy> taskList;

    private BffProxyManager() {
        this.taskList = new CopyOnWriteArrayList();
        this.isFirstRequestInALoop = true;
    }

    private static class BffProxyManagerHolder {
        /* access modifiers changed from: private */
        public static final BffProxyManager INSTANCE = new BffProxyManager();

        private BffProxyManagerHolder() {
        }
    }

    public static final BffProxyManager getInstance() {
        return BffProxyManagerHolder.INSTANCE;
    }

    public void cancel(IBffProxy.Ability ability) {
        for (IBffProxy next : this.taskList) {
            BffBaseProxyImpl bffBaseProxyImpl = (BffBaseProxyImpl) next;
            if (bffBaseProxyImpl.mAbilityList.contains(ability)) {
                if (next instanceof BffServiceProxyImpl) {
                    this.taskList.remove(next);
                    return;
                }
                if (next.getStatus() == 1) {
                    next.setStatus(3);
                }
                next.removeAbility(ability.getId());
                if (bffBaseProxyImpl.mAbilityList.size() == 0) {
                    getInstance().taskList.remove(next);
                    return;
                }
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void call(com.android.didi.bfflib.IBffProxy.Ability r6) {
        /*
            r5 = this;
            android.content.Context r0 = r6.getContext()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            boolean r0 = com.android.didi.bfflib.debug.BffDebugUtil.isDebug()
            if (r0 == 0) goto L_0x002f
            boolean r0 = com.android.didi.bfflib.debug.BffDebugUtil.isConcurrenceOpen()
            if (r0 != 0) goto L_0x002f
            com.android.didi.bfflib.task.taskmanager.BffProxyManager$1 r0 = new com.android.didi.bfflib.task.taskmanager.BffProxyManager$1
            android.content.Context r1 = r6.getContext()
            com.android.didi.bfflib.Bff$BffConfig r2 = com.android.didi.bfflib.Bff.getBffConfig()
            r0.<init>(r1, r2)
            r0.addAbility(r6)
            int r6 = r0.getStatus()
            if (r6 != 0) goto L_0x002e
            java.util.List<com.android.didi.bfflib.IBffProxy$Ability> r6 = r0.mAbilityList
            r0.requestAbilityInLoop(r6)
        L_0x002e:
            return
        L_0x002f:
            boolean r0 = r5.isFirstRequestInALoop
            if (r0 == 0) goto L_0x00ac
            r0 = 0
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            android.os.Looper r2 = android.os.Looper.myLooper()
            if (r1 != r2) goto L_0x0043
            android.os.MessageQueue r0 = android.os.Looper.myQueue()
            goto L_0x0093
        L_0x0043:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r1 < r2) goto L_0x0052
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            android.os.MessageQueue r0 = r0.getQueue()
            goto L_0x0093
        L_0x0052:
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            java.lang.Class r2 = r1.getClass()     // Catch:{ NoSuchFieldException -> 0x008b, IllegalAccessException -> 0x0083 }
            java.lang.String r3 = "mQueue"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x008b, IllegalAccessException -> 0x0083 }
            r3 = 1
            r2.setAccessible(r3)     // Catch:{ NoSuchFieldException -> 0x008b, IllegalAccessException -> 0x0083 }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ NoSuchFieldException -> 0x008b, IllegalAccessException -> 0x0083 }
            android.os.MessageQueue r1 = (android.os.MessageQueue) r1     // Catch:{ NoSuchFieldException -> 0x008b, IllegalAccessException -> 0x0083 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ NoSuchFieldException -> 0x0081, IllegalAccessException -> 0x007f }
            r0.<init>()     // Catch:{ NoSuchFieldException -> 0x0081, IllegalAccessException -> 0x007f }
            java.lang.String r2 = "main thread MessageQueue: "
            r0.append(r2)     // Catch:{ NoSuchFieldException -> 0x0081, IllegalAccessException -> 0x007f }
            r0.append(r1)     // Catch:{ NoSuchFieldException -> 0x0081, IllegalAccessException -> 0x007f }
            java.lang.String r0 = r0.toString()     // Catch:{ NoSuchFieldException -> 0x0081, IllegalAccessException -> 0x007f }
            com.android.didi.bfflib.utils.BffLog.m1480d(r0)     // Catch:{ NoSuchFieldException -> 0x0081, IllegalAccessException -> 0x007f }
            goto L_0x0092
        L_0x007f:
            r0 = move-exception
            goto L_0x0087
        L_0x0081:
            r0 = move-exception
            goto L_0x008f
        L_0x0083:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0087:
            r0.printStackTrace()
            goto L_0x0092
        L_0x008b:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x008f:
            r0.printStackTrace()
        L_0x0092:
            r0 = r1
        L_0x0093:
            if (r0 == 0) goto L_0x009d
            com.android.didi.bfflib.task.taskmanager.BffProxyManager$2 r1 = new com.android.didi.bfflib.task.taskmanager.BffProxyManager$2
            r1.<init>()
            r0.addIdleHandler(r1)
        L_0x009d:
            android.os.Handler r0 = mMainHandler
            com.android.didi.bfflib.task.taskmanager.BffProxyManager$3 r1 = new com.android.didi.bfflib.task.taskmanager.BffProxyManager$3
            r1.<init>()
            r2 = 200(0xc8, double:9.9E-322)
            r0.postDelayed(r1, r2)
            r0 = 0
            r5.isFirstRequestInALoop = r0
        L_0x00ac:
            java.util.List<com.android.didi.bfflib.IBffProxy> r0 = r5.taskList
            int r0 = r0.size()
            if (r0 != 0) goto L_0x00c2
            java.util.List<com.android.didi.bfflib.IBffProxy> r0 = r5.taskList
            com.android.didi.bfflib.task.BffBaseProxyImpl r1 = createTask(r6)
            com.android.didi.bfflib.IBffProxy r6 = r1.addAbility(r6)
            r0.add(r6)
            return
        L_0x00c2:
            java.util.List<com.android.didi.bfflib.IBffProxy> r0 = r5.taskList
            java.util.Iterator r0 = r0.iterator()
        L_0x00c8:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00de
            java.lang.Object r1 = r0.next()
            com.android.didi.bfflib.IBffProxy r1 = (com.android.didi.bfflib.IBffProxy) r1
            boolean r2 = r1.canAddAbilityInThisTask(r6)
            if (r2 == 0) goto L_0x00c8
            r1.addAbility(r6)
            return
        L_0x00de:
            java.util.List<com.android.didi.bfflib.IBffProxy> r0 = r5.taskList
            com.android.didi.bfflib.task.BffBaseProxyImpl r1 = createTask(r6)
            com.android.didi.bfflib.IBffProxy r6 = r1.addAbility(r6)
            r0.add(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.didi.bfflib.task.taskmanager.BffProxyManager.call(com.android.didi.bfflib.IBffProxy$Ability):void");
    }

    /* access modifiers changed from: private */
    public void requestAbilityInALoop() {
        for (IBffProxy next : this.taskList) {
            if (next.getStatus() == 0) {
                next.requestAbilityInLoop(((BffBaseProxyImpl) next).mAbilityList);
            }
        }
        this.isFirstRequestInALoop = true;
        this.isRequested = false;
    }

    public static BffBaseProxyImpl createTask(IBffProxy.Ability ability) {
        Map<String, List<String>> map;
        Map<String, List<String>> serviceTable = Bff.getBffConfig().getServiceTable();
        if (serviceTable.size() > 0) {
            for (Map.Entry next : serviceTable.entrySet()) {
                List list = (List) next.getValue();
                Iterator it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((String) it.next()).equals(ability.getId()) && ((String) next.getKey()).equals(ability.getServiceId())) {
                            final C15534 r0 = new BffServiceProxyImpl(ability.getContext(), Bff.getBffConfig(), list) {
                                public void removeCache() {
                                    BffProxyManager.getInstance().taskList.remove(this);
                                }
                            };
                            r0.setServiceId((String) next.getKey());
                            mMainHandler.postDelayed(new Runnable() {
                                public void run() {
                                    if (BffBaseProxyImpl.this.getStatus() == -1) {
                                        BffBaseProxyImpl.this.setStatus(0);
                                    }
                                }
                            }, (long) Bff.getBffConfig().getServiceMaximunWaitingTime());
                            return r0;
                        }
                    }
                }
            }
        }
        BffAbilityMapModel abilityMapModel = BffConcurrentFormStore.getInstance().getAbilityMapModel();
        if (abilityMapModel == null || abilityMapModel.errno != 0 || abilityMapModel.data == null) {
            map = Bff.getBffConfig().getMappingTable();
        } else {
            map = abilityMapModel.data;
        }
        if (map.size() > 0) {
            for (Map.Entry<String, List<String>> value : map.entrySet()) {
                List list2 = (List) value.getValue();
                Iterator it2 = list2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((String) it2.next()).equals(ability.getId())) {
                            return new BffGroupProxyImpl(ability.getContext(), Bff.getBffConfig(), list2) {
                                public void removeCache() {
                                    BffProxyManager.getInstance().taskList.remove(this);
                                }
                            };
                        }
                    }
                }
            }
        }
        return new BffAnonymousProxyImpl(ability.getContext(), Bff.getBffConfig()) {
            public void removeCache() {
                BffProxyManager.getInstance().taskList.remove(this);
            }
        };
    }
}
