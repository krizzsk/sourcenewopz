package com.didi.soda.customer.biz.order;

import android.text.TextUtils;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.Comparator;
import java.util.Map;

public class OrderLimitQueue extends LimitMap<String, OrderInfoEntity> {

    /* renamed from: a */
    private static final int f40414a = 5;

    public OrderLimitQueue() {
        super(5);
        addComparator(new OrderComparator());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void add(com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x0026
            java.lang.String r0 = r3.orderId     // Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x0008
            goto L_0x0026
        L_0x0008:
            java.lang.String r0 = r3.orderId     // Catch:{ all -> 0x0023 }
            com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity r0 = r2.getOrderById(r0)     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x001c
            int r1 = r3.status     // Catch:{ all -> 0x0023 }
            int r0 = r0.status     // Catch:{ all -> 0x0023 }
            if (r1 < r0) goto L_0x0021
            java.lang.String r0 = r3.orderId     // Catch:{ all -> 0x0023 }
            r2.offer(r0, r3)     // Catch:{ all -> 0x0023 }
            goto L_0x0021
        L_0x001c:
            java.lang.String r0 = r3.orderId     // Catch:{ all -> 0x0023 }
            r2.offer(r0, r3)     // Catch:{ all -> 0x0023 }
        L_0x0021:
            monitor-exit(r2)
            return
        L_0x0023:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x0026:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.biz.order.OrderLimitQueue.add(com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void resort() {
        /*
            r4 = this;
            monitor-enter(r4)
            int r0 = r4.size()     // Catch:{ all -> 0x0056 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r4)
            return
        L_0x0009:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0056 }
            java.util.Set r1 = r4.getEntrySet()     // Catch:{ all -> 0x0056 }
            r0.<init>(r1)     // Catch:{ all -> 0x0056 }
            java.util.Comparator r1 = r4.getComparator()     // Catch:{ all -> 0x0056 }
            java.util.Collections.sort(r0, r1)     // Catch:{ all -> 0x0056 }
            r4.clear()     // Catch:{ all -> 0x0056 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0056 }
        L_0x0020:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x0054
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0056 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x0056 }
            java.lang.Object r2 = r1.getValue()     // Catch:{ all -> 0x0056 }
            com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity r2 = (com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity) r2     // Catch:{ all -> 0x0056 }
            boolean r2 = r4.m28657a(r2)     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x0039
            goto L_0x0020
        L_0x0039:
            int r2 = r4.size()     // Catch:{ all -> 0x0056 }
            int r3 = r4.getLimitSize()     // Catch:{ all -> 0x0056 }
            if (r2 < r3) goto L_0x0044
            goto L_0x0054
        L_0x0044:
            java.lang.Object r2 = r1.getKey()     // Catch:{ all -> 0x0056 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0056 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x0056 }
            com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity r1 = (com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity) r1     // Catch:{ all -> 0x0056 }
            r4.offer(r2, r1)     // Catch:{ all -> 0x0056 }
            goto L_0x0020
        L_0x0054:
            monitor-exit(r4)
            return
        L_0x0056:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.biz.order.OrderLimitQueue.resort():void");
    }

    public OrderInfoEntity getOrderById(String str) {
        if (TextUtils.isEmpty(str) || size() <= 0) {
            return null;
        }
        return (OrderInfoEntity) get(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String getOrderIds(java.util.List<java.lang.String> r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            int r0 = r6.size()     // Catch:{ all -> 0x0059 }
            r1 = 0
            if (r0 != 0) goto L_0x0012
            if (r7 == 0) goto L_0x0010
            int r0 = r7.size()     // Catch:{ all -> 0x0059 }
            if (r0 != 0) goto L_0x0012
        L_0x0010:
            monitor-exit(r6)
            return r1
        L_0x0012:
            java.util.Set r0 = r6.getKeySet()     // Catch:{ all -> 0x0059 }
            java.util.HashSet r2 = new java.util.HashSet     // Catch:{ all -> 0x0059 }
            r2.<init>()     // Catch:{ all -> 0x0059 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0059 }
        L_0x001f:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x0059 }
            if (r3 == 0) goto L_0x0044
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x0059 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0059 }
            com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity r4 = r6.getOrderById(r3)     // Catch:{ all -> 0x0059 }
            if (r4 == 0) goto L_0x0040
            com.didi.soda.customer.foundation.rpc.entity.DebtInfoEntity r5 = r4.debtInfo     // Catch:{ all -> 0x0059 }
            if (r5 == 0) goto L_0x0040
            com.didi.soda.customer.foundation.rpc.entity.DebtInfoEntity r4 = r4.debtInfo     // Catch:{ all -> 0x0059 }
            int r4 = r4.isStatusPaying     // Catch:{ all -> 0x0059 }
            r5 = 1
            if (r4 != r5) goto L_0x001f
            r2.add(r3)     // Catch:{ all -> 0x0059 }
            goto L_0x001f
        L_0x0040:
            r2.add(r3)     // Catch:{ all -> 0x0059 }
            goto L_0x001f
        L_0x0044:
            r2.addAll(r7)     // Catch:{ all -> 0x0059 }
            int r7 = r2.size()     // Catch:{ all -> 0x0059 }
            if (r7 != 0) goto L_0x004f
            monitor-exit(r6)
            return r1
        L_0x004f:
            java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x0059 }
            java.lang.String r7 = r6.dealOrderIdsStr(r7)     // Catch:{ all -> 0x0059 }
            monitor-exit(r6)
            return r7
        L_0x0059:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.biz.order.OrderLimitQueue.getOrderIds(java.util.List):java.lang.String");
    }

    public String dealOrderIdsStr(String str) {
        return str.replace(" ", "").replace(Const.jaLeft, "").replace(Const.jaRight, "");
    }

    /* renamed from: a */
    private boolean m28657a(OrderInfoEntity orderInfoEntity) {
        int i = orderInfoEntity.status;
        boolean z = i == 0 || i == 100 || i == 120 || i == 140 || i == 200 || i == 300 || i == 400 || i == 500;
        if (orderInfoEntity.debtInfo != null && orderInfoEntity.debtInfo.isComplete == 0) {
            z = true;
        }
        return !z;
    }

    static class OrderComparator implements Comparator<Map.Entry<String, OrderInfoEntity>> {
        OrderComparator() {
        }

        public int compare(Map.Entry<String, OrderInfoEntity> entry, Map.Entry<String, OrderInfoEntity> entry2) {
            if (entry.getValue().debtInfo != null) {
                return 1;
            }
            if (entry2.getValue().debtInfo != null || entry.getValue().createTime > entry2.getValue().createTime) {
                return -1;
            }
            if (entry.getValue().createTime < entry2.getValue().createTime) {
                return 1;
            }
            return 0;
        }
    }
}
