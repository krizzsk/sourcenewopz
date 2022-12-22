package com.didi.soda.order.omega;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.util.ApiErrorUtil;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\u000fJ\u0010\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0019\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/soda/order/omega/OrderOmegaHelper;", "", "scopeContextWr", "Lcom/didi/app/nova/skeleton/ScopeContext;", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "orderId", "", "orderStatus", "", "(Lcom/didi/app/nova/skeleton/ScopeContext;Ljava/lang/String;I)V", "mOrderId", "mOrderStatus", "mScopeContextWr", "Ljava/lang/ref/WeakReference;", "setOrderStatus", "", "traceRefundTotalTipsCk", "trackGetOrderPluginError", "msg", "trackPushSetClick", "type", "trackPushSetShow", "trackRateClick", "sourcePage", "trackRateShow", "trackRefundDetailSw", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderOmegaHelper.kt */
public final class OrderOmegaHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private WeakReference<ScopeContext> f43519a;

    /* renamed from: b */
    private String f43520b = "";

    /* renamed from: c */
    private int f43521c;

    public OrderOmegaHelper(ScopeContext scopeContext) {
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContextWr");
        this.f43519a = new WeakReference<>(scopeContext);
    }

    public OrderOmegaHelper(ScopeContext scopeContext, String str, int i) {
        this.f43519a = new WeakReference<>(scopeContext);
        this.f43520b = str == null ? "" : str;
        this.f43521c = i;
    }

    public final void setOrderStatus(String str, int i) {
        if (str == null) {
            str = "";
        }
        this.f43520b = str;
        this.f43521c = i;
    }

    public final void trackRateShow(String str) {
        ScopeContext scopeContext = (ScopeContext) this.f43519a.get();
        if (scopeContext != null) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Order.ORDER_ORDER_RATE_SHOW, scopeContext);
            if (str == null) {
                str = "";
            }
            create.addEventParam("from_page", str).addEventParam("order_id", this.f43520b).build().track();
        }
    }

    public final void trackRateClick(String str) {
        ScopeContext scopeContext = (ScopeContext) this.f43519a.get();
        if (scopeContext != null) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Order.ORDER_ORDER_RATE_CLICK, scopeContext);
            if (str == null) {
                str = "";
            }
            create.addEventParam("from_page", str).addEventParam("order_id", this.f43520b).build().track();
        }
    }

    public final void trackPushSetClick(int i) {
        Object obj = this.f43519a.get();
        Intrinsics.checkNotNull(obj);
        OmegaTracker.Builder.create(EventConst.Order.ORDER_PUSH_REMIND_CK, (ScopeContext) obj).addEventParam("order_id", this.f43520b).addEventParam("button_type", Integer.valueOf(i)).build().track();
    }

    public final void trackPushSetShow() {
        Object obj = this.f43519a.get();
        Intrinsics.checkNotNull(obj);
        OmegaTracker.Builder.create(EventConst.Order.ORDER_PUSH_REMIND_SW, (ScopeContext) obj).addEventParam("order_id", this.f43520b).build().track();
    }

    public final void trackRefundDetailSw(String str) {
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Order.SAILING_C_X_ORDERDETAIL_REFUND_POPUP_SW);
        if (str == null) {
            str = "";
        }
        create.addEventParam("order_id", str).build().track();
    }

    public final void traceRefundTotalTipsCk(String str) {
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Order.SAILING_C_X_ORDERDETAIL_REFUND_RULE_CK);
        if (str == null) {
            str = "";
        }
        create.addEventParam("order_id", str).build().track();
    }

    public final void trackGetOrderPluginError(String str) {
        Intrinsics.checkNotNullParameter(str, "msg");
        ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_ORDER_GET_PLUGIN_ERROR).addErrorMsg(str).addModuleName("order").build().trackError();
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/order/omega/OrderOmegaHelper$Companion;", "", "()V", "trackGetOrderDetailError", "", "key", "", "msg", "errorCode", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderOmegaHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void trackGetOrderDetailError(String str, String str2, int i) {
            Intrinsics.checkNotNullParameter(str, "key");
            if (str2 == null) {
                str2 = "order detail request error";
            }
            ErrorTracker.create(str).addErrorMsg(str2).addErrorType(ApiErrorUtil.Companion.getErrorType(String.valueOf(i))).addModuleName("order").build().trackError();
        }
    }
}
