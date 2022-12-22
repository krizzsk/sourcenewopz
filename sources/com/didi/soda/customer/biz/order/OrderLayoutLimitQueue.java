package com.didi.soda.customer.biz.order;

import android.text.TextUtils;
import com.didi.soda.customer.foundation.rpc.entity.OrderData;
import com.didi.soda.customer.foundation.rpc.entity.OrderLayoutEntity;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.Comparator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00112\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0002\u0011\u0012B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0010\u001a\u00020\tH\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/soda/customer/biz/order/OrderLayoutLimitQueue;", "Lcom/didi/soda/customer/biz/order/LimitMap;", "", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderLayoutEntity;", "()V", "orderIds", "getOrderIds", "()Ljava/lang/String;", "add", "", "entity", "dealOrderIdsStr", "getOrderById", "orderId", "needDoWithOut", "", "resort", "Companion", "OrderComparator", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderLayoutLimitQueue.kt */
public final class OrderLayoutLimitQueue extends LimitMap<String, OrderLayoutEntity> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final int f40413a = 5;

    public OrderLayoutLimitQueue() {
        super(5);
        addComparator(new OrderComparator());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String getOrderIds() {
        /*
            r4 = this;
            monitor-enter(r4)
            int r0 = r4.size()     // Catch:{ all -> 0x003a }
            r1 = 0
            if (r0 != 0) goto L_0x000a
            monitor-exit(r4)
            return r1
        L_0x000a:
            java.util.Set r0 = r4.getKeySet()     // Catch:{ all -> 0x003a }
            java.util.HashSet r2 = new java.util.HashSet     // Catch:{ all -> 0x003a }
            r2.<init>()     // Catch:{ all -> 0x003a }
            java.util.Set r2 = (java.util.Set) r2     // Catch:{ all -> 0x003a }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x003a }
        L_0x0019:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x003a }
            if (r3 == 0) goto L_0x0029
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x003a }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x003a }
            r2.add(r3)     // Catch:{ all -> 0x003a }
            goto L_0x0019
        L_0x0029:
            int r0 = r2.size()     // Catch:{ all -> 0x003a }
            if (r0 != 0) goto L_0x0030
            goto L_0x0038
        L_0x0030:
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x003a }
            java.lang.String r1 = r4.dealOrderIdsStr(r0)     // Catch:{ all -> 0x003a }
        L_0x0038:
            monitor-exit(r4)
            return r1
        L_0x003a:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.biz.order.OrderLayoutLimitQueue.getOrderIds():java.lang.String");
    }

    public final synchronized void add(OrderLayoutEntity orderLayoutEntity) {
        OrderData orderData = null;
        if ((orderLayoutEntity == null ? null : orderLayoutEntity.getOrderData()) != null) {
            OrderData orderData2 = orderLayoutEntity.getOrderData();
            OrderLayoutEntity orderById = getOrderById(orderData2.getOrderId());
            if (orderById != null) {
                orderData = orderById.getOrderData();
            }
            if (orderData == null) {
                offer(orderData2.getOrderId(), orderLayoutEntity);
            } else if (orderData2.getStatus() >= orderById.getOrderData().getStatus()) {
                offer(orderData2.getOrderId(), orderLayoutEntity);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void resort() {
        /*
            r4 = this;
            monitor-enter(r4)
            int r0 = r4.size()     // Catch:{ all -> 0x005c }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r4)
            return
        L_0x0009:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x005c }
            java.util.Set r1 = r4.getEntrySet()     // Catch:{ all -> 0x005c }
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x005c }
            r0.<init>(r1)     // Catch:{ all -> 0x005c }
            r1 = r0
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x005c }
            java.util.Comparator r2 = r4.getComparator()     // Catch:{ all -> 0x005c }
            java.util.Collections.sort(r1, r2)     // Catch:{ all -> 0x005c }
            r4.clear()     // Catch:{ all -> 0x005c }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x005c }
            java.lang.String r1 = "list.iterator()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ all -> 0x005c }
        L_0x002a:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x005c }
            if (r1 == 0) goto L_0x005a
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x005c }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x005c }
            java.lang.Object r2 = r1.getValue()     // Catch:{ all -> 0x005c }
            com.didi.soda.customer.foundation.rpc.entity.OrderLayoutEntity r2 = (com.didi.soda.customer.foundation.rpc.entity.OrderLayoutEntity) r2     // Catch:{ all -> 0x005c }
            boolean r2 = r4.m28656a(r2)     // Catch:{ all -> 0x005c }
            if (r2 == 0) goto L_0x0043
            goto L_0x002a
        L_0x0043:
            int r2 = r4.size()     // Catch:{ all -> 0x005c }
            int r3 = r4.getLimitSize()     // Catch:{ all -> 0x005c }
            if (r2 < r3) goto L_0x004e
            goto L_0x005a
        L_0x004e:
            java.lang.Object r2 = r1.getKey()     // Catch:{ all -> 0x005c }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x005c }
            r4.offer(r2, r1)     // Catch:{ all -> 0x005c }
            goto L_0x002a
        L_0x005a:
            monitor-exit(r4)
            return
        L_0x005c:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.biz.order.OrderLayoutLimitQueue.resort():void");
    }

    public final OrderLayoutEntity getOrderById(String str) {
        if (TextUtils.isEmpty(str) || size() <= 0) {
            return null;
        }
        return (OrderLayoutEntity) get(str);
    }

    public final String dealOrderIdsStr(String str) {
        Intrinsics.checkNotNullParameter(str, "orderIds");
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str, " ", "", false, 4, (Object) null), Const.jaLeft, "", false, 4, (Object) null), Const.jaRight, "", false, 4, (Object) null);
    }

    /* renamed from: a */
    private final boolean m28656a(OrderLayoutEntity orderLayoutEntity) {
        boolean z = false;
        if ((orderLayoutEntity == null ? null : orderLayoutEntity.getOrderData()) != null) {
            int status = orderLayoutEntity.getOrderData().getStatus();
            if (status == 0 || status == 100 || status == 120 || status == 140 || status == 200 || status == 300 || status == 400 || status == 500) {
                z = true;
            }
            if (orderLayoutEntity.getOrderData().getRealComplete() == 0) {
                z = true;
            }
        }
        return !z;
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u000022\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u0001j\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002`\u0005B\u0005¢\u0006\u0002\u0010\u0006J8\u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0016\u0010\n\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0017¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/customer/biz/order/OrderLayoutLimitQueue$OrderComparator;", "Ljava/util/Comparator;", "", "", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderLayoutEntity;", "Lkotlin/Comparator;", "()V", "compare", "", "entity1", "entity2", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderLayoutLimitQueue.kt */
    public static final class OrderComparator implements Comparator<Map.Entry<? extends String, ? extends OrderLayoutEntity>> {
        public int compare(Map.Entry<String, OrderLayoutEntity> entry, Map.Entry<String, OrderLayoutEntity> entry2) {
            OrderData orderData;
            Intrinsics.checkNotNullParameter(entry, "entity1");
            Intrinsics.checkNotNullParameter(entry2, "entity2");
            OrderLayoutEntity value = entry.getValue();
            OrderLayoutEntity value2 = entry2.getValue();
            OrderData orderData2 = null;
            if (value == null) {
                orderData = null;
            } else {
                orderData = value.getOrderData();
            }
            if (orderData == null) {
                return 0;
            }
            if (value2 != null) {
                orderData2 = value2.getOrderData();
            }
            if (orderData2 == null) {
                return 0;
            }
            OrderData orderData3 = value.getOrderData();
            OrderData orderData4 = value2.getOrderData();
            if (orderData3.getRealComplete() == 0) {
                return 1;
            }
            if (orderData4.getRealComplete() == 0 || orderData3.getCreateTime() > orderData4.getCreateTime()) {
                return -1;
            }
            if (orderData3.getCreateTime() < orderData4.getCreateTime()) {
                return 1;
            }
            return 0;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/biz/order/OrderLayoutLimitQueue$Companion;", "", "()V", "QUEUE_LENGTH", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderLayoutLimitQueue.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
