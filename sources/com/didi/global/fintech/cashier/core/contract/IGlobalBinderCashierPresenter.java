package com.didi.global.fintech.cashier.core.contract;

import com.didi.global.fintech.cashier.p117ui.IGlobalCashierBaseViewHolder;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000 \f*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\fJ\u001e\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006H&J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\r"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/contract/IGlobalBinderCashierPresenter;", "D", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalBizCashierPresenter;", "addViewBinder", "", "binder", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseViewBinder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "onBackPressed", "", "type", "", "Companion", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierPresenters.kt */
public interface IGlobalBinderCashierPresenter<D> extends IGlobalBizCashierPresenter {
    public static final String BACK_TYPE_HEADER = "header";
    public static final String BACK_TYPE_KEY = "key";
    public static final Companion Companion = Companion.$$INSTANCE;

    boolean addViewBinder(IGlobalCashierBaseViewBinder<? extends IGlobalCashierBaseViewHolder, D> iGlobalCashierBaseViewBinder);

    void onBackPressed(String str);

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/contract/IGlobalBinderCashierPresenter$Companion;", "", "()V", "BACK_TYPE_HEADER", "", "BACK_TYPE_KEY", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IGlobalCashierPresenters.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String BACK_TYPE_HEADER = "header";
        public static final String BACK_TYPE_KEY = "key";

        private Companion() {
        }
    }
}
