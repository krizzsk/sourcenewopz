package com.didi.entrega.orderlist.omega;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import com.didi.entrega.customer.foundation.rpc.entity.order.HistoryOrderInfoEntity;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderListItemEntity;
import com.didi.entrega.customer.foundation.tracker.OmegaTracker;
import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import com.didi.entrega.customer.foundation.tracker.event.EventConst;
import com.didi.entrega.customer.foundation.tracker.param.ParamConst;
import com.didi.entrega.customer.foundation.util.GsonUtil;
import com.didi.entrega.customer.foundation.util.OnceActionUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J'\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0012J)\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015J\u001e\u0010\u001b\u001a\u00020\t2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u0010J\u0006\u0010 \u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, mo175978d2 = {"Lcom/didi/entrega/orderlist/omega/OrderListOmegaHelper;", "", "()V", "mActionPool", "Lcom/didi/entrega/customer/foundation/util/OnceActionUtil$ActionPool;", "mScopeContextWr", "Ljava/lang/ref/WeakReference;", "Lcom/didi/app/nova/skeleton/ScopeContext;", "attach", "", "scopeContext", "detach", "trackOrderButtonCK", "model", "Lcom/didi/entrega/orderlist/binder/OrderListItemModel;", "index", "", "clickType", "(Lcom/didi/entrega/orderlist/binder/OrderListItemModel;Ljava/lang/Integer;Ljava/lang/Integer;)V", "trackOrderCK", "orderId", "", "orderStatus", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "trackOrderListApiError", "errCode", "errMsg", "trackOrderListSW", "orderList", "", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderListItemEntity;", "baseIndex", "trackReturnBk", "Companion", "OrderListExposeEntity", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderListOmegaHelper.kt */
public final class OrderListOmegaHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final OrderListOmegaHelper f20997c = new OrderListOmegaHelper();

    /* renamed from: a */
    private WeakReference<ScopeContext> f20998a;

    /* renamed from: b */
    private OnceActionUtil.ActionPool f20999b;

    public final void attach(ScopeContext scopeContext) {
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        this.f20998a = new WeakReference<>(scopeContext);
        this.f20999b = new OnceActionUtil.ActionPool();
    }

    public final void detach(ScopeContext scopeContext) {
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        WeakReference<ScopeContext> weakReference = this.f20998a;
        if (Intrinsics.areEqual((Object) weakReference == null ? null : (ScopeContext) weakReference.get(), (Object) scopeContext)) {
            this.f20998a = null;
            this.f20999b = null;
        }
    }

    public final void trackReturnBk() {
        OmegaTracker.Builder.create(EventConst.Order.SAILING_C_E_MYORDERPAGE_RETURN_CK).build().track();
    }

    public final void trackOrderCK(String str, Integer num, Integer num2) {
        int i;
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Order.SAILING_C_E_MYORDERPAGE_ORDER_CK);
        int i2 = 0;
        Object obj = str;
        if (str == null) {
            obj = 0;
        }
        OmegaTracker.Builder addEventParam = create.addEventParam("order_id", obj);
        if (num == null) {
            i = 0;
        } else {
            i = num.intValue();
        }
        OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("order_status", Integer.valueOf(i));
        if (num2 != null) {
            i2 = num2.intValue();
        }
        addEventParam2.addEventParam("index", Integer.valueOf(i2)).build().track();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0036, code lost:
        r5 = r5.getOrderInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void trackOrderButtonCK(com.didi.entrega.orderlist.binder.OrderListItemModel r5, java.lang.Integer r6, java.lang.Integer r7) {
        /*
            r4 = this;
            java.lang.String r0 = "model"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "sailing_c_e_myorderpage_order_button_ck"
            com.didi.entrega.customer.foundation.tracker.OmegaTracker$Builder r0 = com.didi.entrega.customer.foundation.tracker.OmegaTracker.Builder.create(r0)
            com.didi.entrega.customer.foundation.rpc.entity.order.OrderListItemEntity r1 = r5.getData()
            r2 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            if (r1 != 0) goto L_0x0018
            goto L_0x0027
        L_0x0018:
            com.didi.entrega.customer.foundation.rpc.entity.order.HistoryOrderInfoEntity r1 = r1.getOrderInfo()
            if (r1 != 0) goto L_0x001f
            goto L_0x0027
        L_0x001f:
            java.lang.String r1 = r1.getOrderId()
            if (r1 != 0) goto L_0x0026
            goto L_0x0027
        L_0x0026:
            r3 = r1
        L_0x0027:
            java.lang.String r1 = "order_id"
            com.didi.entrega.customer.foundation.tracker.OmegaTracker$Builder r0 = r0.addEventParam(r1, r3)
            com.didi.entrega.customer.foundation.rpc.entity.order.OrderListItemEntity r5 = r5.getData()
            if (r5 != 0) goto L_0x0036
        L_0x0034:
            r5 = 0
            goto L_0x0041
        L_0x0036:
            com.didi.entrega.customer.foundation.rpc.entity.order.HistoryOrderInfoEntity r5 = r5.getOrderInfo()
            if (r5 != 0) goto L_0x003d
            goto L_0x0034
        L_0x003d:
            int r5 = r5.getStatus()
        L_0x0041:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r1 = "order_status"
            com.didi.entrega.customer.foundation.tracker.OmegaTracker$Builder r5 = r0.addEventParam(r1, r5)
            if (r6 != 0) goto L_0x0050
            r6 = 0
            goto L_0x0054
        L_0x0050:
            int r6 = r6.intValue()
        L_0x0054:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r0 = "index"
            com.didi.entrega.customer.foundation.tracker.OmegaTracker$Builder r5 = r5.addEventParam(r0, r6)
            if (r7 != 0) goto L_0x0061
            goto L_0x0065
        L_0x0061:
            int r2 = r7.intValue()
        L_0x0065:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            java.lang.String r7 = "click_type"
            com.didi.entrega.customer.foundation.tracker.OmegaTracker$Builder r5 = r5.addEventParam(r7, r6)
            com.didi.entrega.customer.foundation.tracker.OmegaTracker r5 = r5.build()
            r5.track()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.orderlist.omega.OrderListOmegaHelper.trackOrderButtonCK(com.didi.entrega.orderlist.binder.OrderListItemModel, java.lang.Integer, java.lang.Integer):void");
    }

    public final void trackOrderListSW(List<OrderListItemEntity> list, int i) {
        int size;
        ArrayList arrayList = new ArrayList();
        Collection collection = list;
        int i2 = 0;
        if (!(collection == null || collection.isEmpty()) && list.size() - 1 >= 0) {
            while (true) {
                int i3 = i2 + 1;
                OrderListItemEntity orderListItemEntity = list.get(i2);
                Integer num = null;
                OrderListExposeEntity orderListExposeEntity = new OrderListExposeEntity((String) null, (Integer) null, (Integer) null, 0, 15, (DefaultConstructorMarker) null);
                HistoryOrderInfoEntity orderInfo = orderListItemEntity.getOrderInfo();
                orderListExposeEntity.setOrder_id(orderInfo == null ? null : orderInfo.getOrderId());
                HistoryOrderInfoEntity orderInfo2 = orderListItemEntity.getOrderInfo();
                orderListExposeEntity.setOrder_status(orderInfo2 == null ? null : Integer.valueOf(orderInfo2.getStatus()));
                HistoryOrderInfoEntity orderInfo3 = orderListItemEntity.getOrderInfo();
                if (orderInfo3 != null) {
                    num = Integer.valueOf(orderInfo3.getDebtStatus());
                }
                orderListExposeEntity.setArrears_order_status(num);
                orderListExposeEntity.setIndex(i2 + i);
                arrayList.add(orderListExposeEntity);
                if (i3 > size) {
                    break;
                }
                i2 = i3;
            }
        }
        OmegaTracker.Builder.create(EventConst.Order.SAILING_C_E_MYORDERPAGE_COMMON_SW).addEventParam(ParamConst.PARAM_ORDER_LIST, GsonUtil.toJson(arrayList)).build().track();
    }

    public final void trackOrderListApiError(int i, String str) {
        ErrorTracker.Builder addErrorType = ErrorTracker.create(ErrorConst.ErrorName.TECH_C_SERVICE_API_ORDER_LIST_API_ERROR).addModuleName("order").addErrorType(String.valueOf(i));
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            str = "";
        }
        addErrorType.addErrorMsg(str).build().trackError();
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/entrega/orderlist/omega/OrderListOmegaHelper$Companion;", "", "()V", "instance", "Lcom/didi/entrega/orderlist/omega/OrderListOmegaHelper;", "getInstance", "()Lcom/didi/entrega/orderlist/omega/OrderListOmegaHelper;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderListOmegaHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OrderListOmegaHelper getInstance() {
            return OrderListOmegaHelper.f20997c;
        }
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J<\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\f¨\u0006$"}, mo175978d2 = {"Lcom/didi/entrega/orderlist/omega/OrderListOmegaHelper$OrderListExposeEntity;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "order_id", "", "order_status", "", "arrears_order_status", "index", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;I)V", "getArrears_order_status", "()Ljava/lang/Integer;", "setArrears_order_status", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getIndex", "()I", "setIndex", "(I)V", "getOrder_id", "()Ljava/lang/String;", "setOrder_id", "(Ljava/lang/String;)V", "getOrder_status", "setOrder_status", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;I)Lcom/didi/entrega/orderlist/omega/OrderListOmegaHelper$OrderListExposeEntity;", "equals", "", "other", "", "hashCode", "toString", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderListOmegaHelper.kt */
    public static final class OrderListExposeEntity implements IEntity {
        private Integer arrears_order_status;
        private int index;
        private String order_id;
        private Integer order_status;

        public OrderListExposeEntity() {
            this((String) null, (Integer) null, (Integer) null, 0, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ OrderListExposeEntity copy$default(OrderListExposeEntity orderListExposeEntity, String str, Integer num, Integer num2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = orderListExposeEntity.order_id;
            }
            if ((i2 & 2) != 0) {
                num = orderListExposeEntity.order_status;
            }
            if ((i2 & 4) != 0) {
                num2 = orderListExposeEntity.arrears_order_status;
            }
            if ((i2 & 8) != 0) {
                i = orderListExposeEntity.index;
            }
            return orderListExposeEntity.copy(str, num, num2, i);
        }

        public final String component1() {
            return this.order_id;
        }

        public final Integer component2() {
            return this.order_status;
        }

        public final Integer component3() {
            return this.arrears_order_status;
        }

        public final int component4() {
            return this.index;
        }

        public final OrderListExposeEntity copy(String str, Integer num, Integer num2, int i) {
            return new OrderListExposeEntity(str, num, num2, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OrderListExposeEntity)) {
                return false;
            }
            OrderListExposeEntity orderListExposeEntity = (OrderListExposeEntity) obj;
            return Intrinsics.areEqual((Object) this.order_id, (Object) orderListExposeEntity.order_id) && Intrinsics.areEqual((Object) this.order_status, (Object) orderListExposeEntity.order_status) && Intrinsics.areEqual((Object) this.arrears_order_status, (Object) orderListExposeEntity.arrears_order_status) && this.index == orderListExposeEntity.index;
        }

        public int hashCode() {
            String str = this.order_id;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.order_status;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.arrears_order_status;
            if (num2 != null) {
                i = num2.hashCode();
            }
            return ((hashCode2 + i) * 31) + this.index;
        }

        public String toString() {
            return "OrderListExposeEntity(order_id=" + this.order_id + ", order_status=" + this.order_status + ", arrears_order_status=" + this.arrears_order_status + ", index=" + this.index + VersionRange.RIGHT_OPEN;
        }

        public OrderListExposeEntity(String str, Integer num, Integer num2, int i) {
            this.order_id = str;
            this.order_status = num;
            this.arrears_order_status = num2;
            this.index = i;
        }

        public final String getOrder_id() {
            return this.order_id;
        }

        public final void setOrder_id(String str) {
            this.order_id = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ OrderListExposeEntity(String str, Integer num, Integer num2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : num, (i2 & 4) != 0 ? 0 : num2, (i2 & 8) != 0 ? 0 : i);
        }

        public final Integer getOrder_status() {
            return this.order_status;
        }

        public final void setOrder_status(Integer num) {
            this.order_status = num;
        }

        public final Integer getArrears_order_status() {
            return this.arrears_order_status;
        }

        public final void setArrears_order_status(Integer num) {
            this.arrears_order_status = num;
        }

        public final int getIndex() {
            return this.index;
        }

        public final void setIndex(int i) {
            this.index = i;
        }
    }
}
