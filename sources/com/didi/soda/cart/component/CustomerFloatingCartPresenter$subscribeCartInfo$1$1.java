package com.didi.soda.cart.component;

import com.didi.soda.business.model.BusinessActionParam;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerBusinessManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerFloatingCartPresenter.kt */
final class CustomerFloatingCartPresenter$subscribeCartInfo$1$1 extends Lambda implements Function0<Unit> {
    public static final CustomerFloatingCartPresenter$subscribeCartInfo$1$1 INSTANCE = new CustomerFloatingCartPresenter$subscribeCartInfo$1$1();

    CustomerFloatingCartPresenter$subscribeCartInfo$1$1() {
        super(0);
    }

    public final void invoke() {
        ((ICustomerBusinessManager) CustomerManagerLoader.loadManager(ICustomerBusinessManager.class)).refreshBusinessPage(new BusinessActionParam(true, false, true));
    }
}
