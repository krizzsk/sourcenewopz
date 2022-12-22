package com.didi.entrega.order.contact;

import android.content.Context;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.LiveHandler;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.tools.Cancelable;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.foundation.util.DialogUtil;
import com.didi.entrega.order.contact.OrderContactUtil;
import com.didichuxing.foundation.rpc.Rpc;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/entrega/order/contact/OrderContactUtil;", "", "()V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderContactUtil.kt */
public final class OrderContactUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final String f20864a = "OrderContactUtil";

    /* renamed from: b */
    private static final int f20865b = 1;

    /* renamed from: c */
    private static final int f20866c = 2;

    /* renamed from: d */
    private static final int f20867d = 3;

    @Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J<\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\r\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J2\u0010\u0016\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J0\u0010\u001a\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\r\u001a\u00020\b2\u0014\u0010\u001b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\n0\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/entrega/order/contact/OrderContactUtil$Companion;", "", "()V", "IM_METHOD", "", "MESSAGE_METHOD", "PHONE_METHOD", "TAG", "", "doActivityContact", "", "context", "Landroid/content/Context;", "orderId", "IMContactModel", "Lcom/didi/entrega/order/contact/IMContactModel;", "contactType", "contactRole", "doContact", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "orderInfoEntity", "doPageContact", "getRole", "Lcom/didi/entrega/order/contact/IRole;", "roleType", "requestOrderInfoById", "action", "Lkotlin/Function1;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderContactUtil.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void doPageContact(ScopeContext scopeContext, String str, IMContactModel iMContactModel, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "orderId");
            if (!TextUtils.isEmpty(str) && scopeContext != null && !scopeContext.getLiveHandler().isDestroyed()) {
                Context context = GlobalContext.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                doContact(context, scopeContext, str, iMContactModel, i, i2);
            }
        }

        public final void doActivityContact(Context context, String str, IMContactModel iMContactModel, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "orderId");
            if (!TextUtils.isEmpty(str) && context != null) {
                doContact(context, (ScopeContext) null, str, iMContactModel, i, i2);
            }
        }

        public final void doContact(Context context, ScopeContext scopeContext, String str, IMContactModel iMContactModel, int i, int i2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "orderId");
            LogUtil.m14765i("OrderContactUtil", str + " callContactType=" + i + " contactJsRole=" + i2);
            if (iMContactModel != null) {
                IRole role = getRole(i2, iMContactModel);
                if (role != null) {
                    role.doRealContact(context, scopeContext, i);
                    return;
                }
                return;
            }
            requestOrderInfoById(scopeContext, str, new OrderContactUtil$Companion$doContact$1(i2, context, scopeContext, i));
        }

        private final void requestOrderInfoById(ScopeContext scopeContext, String str, Function1<? super IMContactModel, Unit> function1) {
            LiveHandler liveHandler;
            if (scopeContext != null) {
                DialogUtil.showLoadingDialog(scopeContext, false);
            }
            Rpc orderDetailBatch = CustomerRpcManagerProxy.get().getOrderDetailBatch(str, new OrderContactUtil$Companion$requestOrderInfoById$rpc$1(function1));
            if (scopeContext != null && (liveHandler = scopeContext.getLiveHandler()) != null) {
                liveHandler.bind(new Cancelable() {
                    public final void cancel() {
                        OrderContactUtil.Companion.m46396requestOrderInfoById$lambda1(Rpc.this);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: requestOrderInfoById$lambda-1  reason: not valid java name */
        public static final void m46396requestOrderInfoById$lambda1(Rpc rpc) {
            rpc.cancel();
        }

        /* access modifiers changed from: private */
        public final IRole getRole(int i, IMContactModel iMContactModel) {
            if (i == 2) {
                return new RiderRole(iMContactModel);
            }
            return null;
        }
    }
}
