package com.didi.global.fintech.cashier.model.strategy;

import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.model.strategy.BaseStrategy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B)\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R#\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/strategy/PayInfoStrategy;", "Lcom/didi/global/fintech/cashier/model/strategy/BaseStrategy;", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "syncTimes", "", "action", "Lkotlin/Function2;", "Lcom/didi/global/fintech/cashier/model/strategy/BaseStrategy$Result;", "(ILkotlin/jvm/functions/Function2;)V", "getAction", "()Lkotlin/jvm/functions/Function2;", "getSyncTimes", "()I", "setSyncTimes", "(I)V", "handle", "model", "Companion", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayInfoStrategy.kt */
public final class PayInfoStrategy implements BaseStrategy<PayInfoResponse> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Function2<PayInfoStrategy, PayInfoResponse, BaseStrategy.Result> f21621c = PayInfoStrategy$Companion$Normal$1.INSTANCE;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final Function2<PayInfoStrategy, PayInfoResponse, BaseStrategy.Result> f21622d = PayInfoStrategy$Companion$Pix$1.INSTANCE;

    /* renamed from: a */
    private int f21623a;

    /* renamed from: b */
    private final Function2<PayInfoStrategy, PayInfoResponse, BaseStrategy.Result> f21624b;

    public PayInfoStrategy(int i, Function2<? super PayInfoStrategy, ? super PayInfoResponse, ? extends BaseStrategy.Result> function2) {
        Intrinsics.checkNotNullParameter(function2, "action");
        this.f21623a = i;
        this.f21624b = function2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PayInfoStrategy(int i, Function2 function2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 20 : i, function2);
    }

    public final int getSyncTimes() {
        return this.f21623a;
    }

    public final void setSyncTimes(int i) {
        this.f21623a = i;
    }

    public final Function2<PayInfoStrategy, PayInfoResponse, BaseStrategy.Result> getAction() {
        return this.f21624b;
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/strategy/PayInfoStrategy$Companion;", "", "()V", "Normal", "Lkotlin/Function2;", "Lcom/didi/global/fintech/cashier/model/strategy/PayInfoStrategy;", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "Lcom/didi/global/fintech/cashier/model/strategy/BaseStrategy$Result;", "getNormal", "()Lkotlin/jvm/functions/Function2;", "Pix", "getPix", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PayInfoStrategy.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function2<PayInfoStrategy, PayInfoResponse, BaseStrategy.Result> getNormal() {
            return PayInfoStrategy.f21621c;
        }

        public final Function2<PayInfoStrategy, PayInfoResponse, BaseStrategy.Result> getPix() {
            return PayInfoStrategy.f21622d;
        }
    }

    public BaseStrategy.Result handle(PayInfoResponse payInfoResponse) {
        Intrinsics.checkNotNullParameter(payInfoResponse, "model");
        return this.f21624b.invoke(this, payInfoResponse);
    }
}
