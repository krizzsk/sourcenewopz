package com.didi.soda.bill.view.item.logic;

import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.globalcart.anim.TotalPriceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ5\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2#\u0010\u0010\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\b0\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/soda/bill/view/item/logic/ItemViewTotalPriceLogic;", "Lcom/didi/soda/bill/view/item/logic/ItemViewAbsLogic;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "priceManager", "Lcom/didi/soda/globalcart/anim/TotalPriceManager;", "onDestroy", "", "live", "Lcom/didi/app/nova/skeleton/ILive;", "setTotalDisplay", "display", "", "startTotalPriceAnim", "newDisplay", "setTextBlock", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "text", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ItemViewTotalPriceLogic.kt */
public final class ItemViewTotalPriceLogic extends ItemViewAbsLogic {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static String f39249b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static String f39250c;

    /* renamed from: a */
    private final TotalPriceManager f39251a = new TotalPriceManager();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemViewTotalPriceLogic(ScopeContext scopeContext) {
        super(scopeContext);
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/bill/view/item/logic/ItemViewTotalPriceLogic$Companion;", "", "()V", "currDisplay", "", "getCurrDisplay", "()Ljava/lang/String;", "setCurrDisplay", "(Ljava/lang/String;)V", "oldDisplay", "getOldDisplay", "setOldDisplay", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ItemViewTotalPriceLogic.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getCurrDisplay() {
            return ItemViewTotalPriceLogic.f39249b;
        }

        public final void setCurrDisplay(String str) {
            ItemViewTotalPriceLogic.f39249b = str;
        }

        public final String getOldDisplay() {
            return ItemViewTotalPriceLogic.f39250c;
        }

        public final void setOldDisplay(String str) {
            ItemViewTotalPriceLogic.f39250c = str;
        }
    }

    public final void setTotalDisplay(String str) {
        f39250c = f39249b;
        f39249b = str;
    }

    public final void startTotalPriceAnim(String str, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "setTextBlock");
        if (CustomerApolloUtil.isBillPriceAnimOn()) {
            this.f39251a.startAnim(getScopeContext(), str, f39250c, function1);
        } else {
            function1.invoke(str);
        }
    }

    public void onDestroy(ILive iLive) {
        super.onDestroy(iLive);
        f39249b = null;
        f39250c = null;
        this.f39251a.release();
    }
}
