package com.didi.entrega.security;

import com.didi.entrega.security.Contract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SecurityView.kt */
final class SecurityView$initItemBinders$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SecurityView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SecurityView$initItemBinders$1(SecurityView securityView) {
        super(0);
        this.this$0 = securityView;
    }

    public final Unit invoke() {
        Contract.AbsSecurityPresenter absSecurityPresenter = (Contract.AbsSecurityPresenter) this.this$0.getPresenter();
        if (absSecurityPresenter == null) {
            return null;
        }
        absSecurityPresenter.verifyCurp();
        return Unit.INSTANCE;
    }
}
