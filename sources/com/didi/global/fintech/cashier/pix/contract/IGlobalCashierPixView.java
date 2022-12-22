package com.didi.global.fintech.cashier.pix.contract;

import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPayView;
import com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/pix/contract/IGlobalCashierPixView;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPayView;", "setOnCancelClickListener", "", "listener", "Lkotlin/Function0;", "setOnConfirmClickListener", "setOnPaidClickListener", "updatePixCode", "pix", "", "updateState", "state", "Lcom/didi/global/fintech/cashier/pix/contract/IGlobalCashierPixController$State;", "visibility", "visible", "", "Companion", "Type", "cashier_pix_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierPixView.kt */
public interface IGlobalCashierPixView extends IGlobalCashierPayView {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String TYPE_PIX_NORMAL = "pix_page";
    public static final String TYPE_PIX_PREPAY = "pix_prepay_page";

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/pix/contract/IGlobalCashierPixView$Type;", "", "(Ljava/lang/String;I)V", "Normal", "Prepay", "cashier_pix_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IGlobalCashierPixView.kt */
    public enum Type {
        Normal,
        Prepay
    }

    void setOnCancelClickListener(Function0<Unit> function0);

    void setOnConfirmClickListener(Function0<Unit> function0);

    void setOnPaidClickListener(Function0<Unit> function0);

    void updatePixCode(String str);

    void updateState(IGlobalCashierPixController.State state);

    void visibility(boolean z);

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/pix/contract/IGlobalCashierPixView$Companion;", "", "()V", "TYPE_PIX_NORMAL", "", "TYPE_PIX_PREPAY", "cashier_pix_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IGlobalCashierPixView.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String TYPE_PIX_NORMAL = "pix_page";
        public static final String TYPE_PIX_PREPAY = "pix_prepay_page";

        private Companion() {
        }
    }
}
