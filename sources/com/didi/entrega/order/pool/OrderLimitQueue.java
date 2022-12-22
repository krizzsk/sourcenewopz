package com.didi.entrega.order.pool;

import android.text.TextUtils;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderInfoEntity;
import com.didichuxing.bigdata.p173dp.locsdk.Const;

public class OrderLimitQueue extends LimitMap<String, OrderInfoEntity> {

    /* renamed from: a */
    private static final int f20915a = 10;

    public OrderLimitQueue() {
        super(10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void add(com.didi.entrega.customer.foundation.rpc.entity.order.OrderInfoEntity r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 == 0) goto L_0x003c
            com.didi.entrega.customer.foundation.rpc.entity.order.OrderData r0 = r5.getOrderData()     // Catch:{ all -> 0x0039 }
            if (r0 != 0) goto L_0x000a
            goto L_0x003c
        L_0x000a:
            com.didi.entrega.customer.foundation.rpc.entity.order.OrderData r0 = r5.getOrderData()     // Catch:{ all -> 0x0039 }
            java.lang.String r0 = r0.getOrderId()     // Catch:{ all -> 0x0039 }
            com.didi.entrega.customer.foundation.rpc.entity.order.OrderData r1 = r5.getOrderData()     // Catch:{ all -> 0x0039 }
            int r1 = r1.getStatus()     // Catch:{ all -> 0x0039 }
            com.didi.entrega.customer.foundation.rpc.entity.order.OrderInfoEntity r2 = r4.getOrderById(r0)     // Catch:{ all -> 0x0039 }
            if (r2 == 0) goto L_0x0034
            com.didi.entrega.customer.foundation.rpc.entity.order.OrderData r3 = r2.getOrderData()     // Catch:{ all -> 0x0039 }
            if (r3 == 0) goto L_0x0034
            com.didi.entrega.customer.foundation.rpc.entity.order.OrderData r2 = r2.getOrderData()     // Catch:{ all -> 0x0039 }
            int r2 = r2.getStatus()     // Catch:{ all -> 0x0039 }
            if (r1 < r2) goto L_0x0037
            r4.offer(r0, r5)     // Catch:{ all -> 0x0039 }
            goto L_0x0037
        L_0x0034:
            r4.offer(r0, r5)     // Catch:{ all -> 0x0039 }
        L_0x0037:
            monitor-exit(r4)
            return
        L_0x0039:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L_0x003c:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.order.pool.OrderLimitQueue.add(com.didi.entrega.customer.foundation.rpc.entity.order.OrderInfoEntity):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onChange() {
        /*
            r4 = this;
            monitor-enter(r4)
            int r0 = r4.size()     // Catch:{ all -> 0x004f }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r4)
            return
        L_0x0009:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x004f }
            java.util.Set r1 = r4.getEntrySet()     // Catch:{ all -> 0x004f }
            r0.<init>(r1)     // Catch:{ all -> 0x004f }
            r4.clear()     // Catch:{ all -> 0x004f }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x004f }
        L_0x0019:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x004f }
            if (r1 == 0) goto L_0x004d
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x004f }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x004f }
            java.lang.Object r2 = r1.getValue()     // Catch:{ all -> 0x004f }
            com.didi.entrega.customer.foundation.rpc.entity.order.OrderInfoEntity r2 = (com.didi.entrega.customer.foundation.rpc.entity.order.OrderInfoEntity) r2     // Catch:{ all -> 0x004f }
            boolean r2 = r4.m15336a(r2)     // Catch:{ all -> 0x004f }
            if (r2 == 0) goto L_0x0032
            goto L_0x0019
        L_0x0032:
            int r2 = r4.size()     // Catch:{ all -> 0x004f }
            int r3 = r4.getLimitSize()     // Catch:{ all -> 0x004f }
            if (r2 < r3) goto L_0x003d
            goto L_0x004d
        L_0x003d:
            java.lang.Object r2 = r1.getKey()     // Catch:{ all -> 0x004f }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x004f }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x004f }
            com.didi.entrega.customer.foundation.rpc.entity.order.OrderInfoEntity r1 = (com.didi.entrega.customer.foundation.rpc.entity.order.OrderInfoEntity) r1     // Catch:{ all -> 0x004f }
            r4.offer(r2, r1)     // Catch:{ all -> 0x004f }
            goto L_0x0019
        L_0x004d:
            monitor-exit(r4)
            return
        L_0x004f:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.order.pool.OrderLimitQueue.onChange():void");
    }

    public OrderInfoEntity getOrderById(String str) {
        if (TextUtils.isEmpty(str) || size() <= 0) {
            return null;
        }
        return (OrderInfoEntity) get(str);
    }

    public synchronized String getOrderIds() {
        if (size() == 0) {
            return null;
        }
        return dealOrderIdsStr(getKeySet().toString());
    }

    public String dealOrderIdsStr(String str) {
        return str.replace(" ", "").replace(Const.jaLeft, "").replace(Const.jaRight, "");
    }

    /* renamed from: a */
    private boolean m15336a(OrderInfoEntity orderInfoEntity) {
        if (orderInfoEntity == null || orderInfoEntity.getOrderData() == null) {
            return true;
        }
        boolean z = false;
        int status = orderInfoEntity.getOrderData().getStatus();
        if (status == 0 || status == 1100 || status == 1200 || status == 1300 || status == 1400 || status == 1500 || status == 1600) {
            z = true;
        }
        if (orderInfoEntity.getOrderData().getStatus() > 1800 && orderInfoEntity.getOrderData().getRealComplete() == 0) {
            z = true;
        }
        return !z;
    }
}
