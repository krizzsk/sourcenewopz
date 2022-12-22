package com.didi.soda.order.component.contact;

import android.content.Context;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.LiveHandler;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.tools.Cancelable;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.order.component.contact.OrderContactUtil;
import com.didichuxing.foundation.rpc.Rpc;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/order/component/contact/OrderContactUtil;", "", "()V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderContactUtil.kt */
public final class OrderContactUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final String f43365a = "OrderContactUtil";

    /* renamed from: b */
    private static final int f43366b = 1;

    /* renamed from: c */
    private static final int f43367c = 2;

    /* renamed from: d */
    private static final int f43368d = 3;

    @Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J<\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J2\u0010\u0015\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J0\u0010\u0019\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\r\u001a\u00020\b2\u0014\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\n0\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000fH\u0002J \u0010\u001e\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000fH\u0002J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006 "}, mo175978d2 = {"Lcom/didi/soda/order/component/contact/OrderContactUtil$Companion;", "", "()V", "IM_METHOD", "", "MESSAGE_METHOD", "PHONE_METHOD", "TAG", "", "doActivityContact", "", "context", "Landroid/content/Context;", "orderId", "orderInfoEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderInfoEntity;", "contactType", "contactRole", "doContact", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "doPageContact", "getRole", "Lcom/didi/soda/order/component/contact/IRole;", "roleType", "requestOrderInfoById", "action", "Lkotlin/Function1;", "trackContactPhone", "entity", "trackDoContact", "trackSendMessage", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderContactUtil.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void doPageContact(ScopeContext scopeContext, String str, OrderInfoEntity orderInfoEntity, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "orderId");
            if (!TextUtils.isEmpty(str) && scopeContext != null && !scopeContext.getLiveHandler().isDestroyed()) {
                Context context = GlobalContext.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                doContact(context, scopeContext, str, orderInfoEntity, i, i2);
            }
        }

        public final void doActivityContact(Context context, String str, OrderInfoEntity orderInfoEntity, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "orderId");
            if (!TextUtils.isEmpty(str) && context != null) {
                doContact(context, (ScopeContext) null, str, orderInfoEntity, i, i2);
            }
        }

        public final void doContact(Context context, ScopeContext scopeContext, String str, OrderInfoEntity orderInfoEntity, int i, int i2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "orderId");
            LogUtil.m29104i("OrderContactUtil", str + " callContactType=" + i + " contactJsRole=" + i2);
            if (orderInfoEntity != null) {
                IRole role = getRole(i2, orderInfoEntity);
                if (role != null) {
                    role.doRealContact(context, scopeContext, i);
                }
                trackDoContact(i2, i, orderInfoEntity);
                return;
            }
            requestOrderInfoById(scopeContext, str, new OrderContactUtil$Companion$doContact$1(i2, context, scopeContext, i));
        }

        private final void requestOrderInfoById(ScopeContext scopeContext, String str, Function1<? super OrderInfoEntity, Unit> function1) {
            LiveHandler liveHandler;
            if (scopeContext != null) {
                DialogUtil.showLoadingDialog(scopeContext, false);
            }
            Rpc orderDetailBatch = CustomerRpcManagerProxy.get().getOrderDetailBatch(str, new OrderContactUtil$Companion$requestOrderInfoById$rpc$1(function1));
            if (scopeContext != null && (liveHandler = scopeContext.getLiveHandler()) != null) {
                liveHandler.bind(new Cancelable() {
                    public final void cancel() {
                        OrderContactUtil.Companion.m47007requestOrderInfoById$lambda1(Rpc.this);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: requestOrderInfoById$lambda-1  reason: not valid java name */
        public static final void m47007requestOrderInfoById$lambda1(Rpc rpc) {
            rpc.cancel();
        }

        /* access modifiers changed from: private */
        public final IRole getRole(int i, OrderInfoEntity orderInfoEntity) {
            if (i == 1) {
                return new ShopRole(orderInfoEntity);
            }
            if (i != 2) {
                return null;
            }
            return new RiderRole(orderInfoEntity);
        }

        /* access modifiers changed from: private */
        public final void trackDoContact(int i, int i2, OrderInfoEntity orderInfoEntity) {
            if (i2 == 11) {
                trackSendMessage(i, orderInfoEntity);
            } else if (i2 == 22) {
                trackContactPhone(i, orderInfoEntity);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0023, code lost:
            if (android.text.TextUtils.isEmpty(r7.deliveryInfo.riderUid) == false) goto L_0x0028;
         */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void trackSendMessage(int r6, com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity r7) {
            /*
                r5 = this;
                r0 = 2
                r1 = 3
                if (r6 != r0) goto L_0x0026
                com.didi.soda.customer.foundation.rpc.entity.DeliveryInfoEntity r2 = r7.deliveryInfo
                java.lang.String r2 = r2.riderId
                java.lang.String r3 = "entity.deliveryInfo.riderId"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                com.didi.soda.customer.foundation.im.ImMessageHelper r3 = com.didi.soda.customer.foundation.p164im.ImMessageHelper.getInstance()
                java.lang.String r4 = r7.imSecret
                boolean r3 = r3.shouldUseImMessage(r4)
                if (r3 == 0) goto L_0x0029
                com.didi.soda.customer.foundation.rpc.entity.DeliveryInfoEntity r3 = r7.deliveryInfo
                java.lang.String r3 = r3.riderUid
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                boolean r3 = android.text.TextUtils.isEmpty(r3)
                if (r3 == 0) goto L_0x0028
                goto L_0x0029
            L_0x0026:
                java.lang.String r2 = ""
            L_0x0028:
                r0 = 3
            L_0x0029:
                r1 = 1
                if (r6 != r1) goto L_0x0035
                com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity r1 = r7.shopInfo
                java.lang.String r2 = r1.shopId
                java.lang.String r1 = "entity.shopInfo.shopId"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            L_0x0035:
                java.lang.String r1 = "sailing_c_x_orderdetail_contact_ck"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r1 = com.didi.soda.customer.foundation.tracker.OmegaTracker.Builder.create(r1)
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
                java.lang.String r3 = "to_whom"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r6 = r1.addEventParam(r3, r6)
                java.lang.String r1 = "entity_id"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r6 = r6.addEventParam(r1, r2)
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                java.lang.String r1 = "contact_method"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r6 = r6.addEventParam(r1, r0)
                java.lang.String r0 = r7.orderId
                java.lang.String r1 = "order_id"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r6 = r6.addEventParam(r1, r0)
                int r7 = r7.status
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                java.lang.String r0 = "order_status"
                com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r6 = r6.addEventParam(r0, r7)
                com.didi.soda.customer.foundation.tracker.OmegaTracker r6 = r6.build()
                r6.track()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.order.component.contact.OrderContactUtil.Companion.trackSendMessage(int, com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity):void");
        }

        private final void trackContactPhone(int i, OrderInfoEntity orderInfoEntity) {
            String str;
            if (i == 2) {
                str = orderInfoEntity.deliveryInfo.riderId;
                Intrinsics.checkNotNullExpressionValue(str, "entity.deliveryInfo.riderId");
            } else {
                str = "";
            }
            if (i == 1) {
                str = orderInfoEntity.shopInfo.shopId;
                Intrinsics.checkNotNullExpressionValue(str, "entity.shopInfo.shopId");
            }
            OmegaTracker.Builder.create(EventConst.Order.ORDER_CONTACT_CK).addEventParam(ParamConst.PARAM_TO_WHOM, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_ENTITY_ID, str).addEventParam(ParamConst.PARAM_CONTACT_METHOD, 1).addEventParam("order_id", orderInfoEntity.orderId).addEventParam("order_status", Integer.valueOf(orderInfoEntity.status)).build().track();
        }
    }
}
