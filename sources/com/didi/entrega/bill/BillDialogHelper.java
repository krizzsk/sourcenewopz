package com.didi.entrega.bill;

import com.didi.app.nova.skeleton.INavigator;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.entrega.bill.BillDialogHelper;
import com.didi.entrega.customer.foundation.rpc.entity.AlertBtnEntity;
import com.didi.entrega.customer.foundation.rpc.entity.AlertEntity;
import com.didi.entrega.customer.widget.dialog.SodaWindowFactory;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerContactManager;
import com.didi.rfusion.widget.dialog.RFCommonDialog;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/entrega/bill/BillDialogHelper;", "", "()V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillDialogHelper.kt */
public final class BillDialogHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final int f19459a = 1;

    /* renamed from: b */
    private static final int f19460b = 0;

    @Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/entrega/bill/BillDialogHelper$Companion;", "", "()V", "BTN_MAIN", "", "BTN_SUB1", "getBillCardListener", "Lcom/didi/rfusion/widget/dialog/RFDialogInterface$OnClickListener;", "action", "", "navigator", "Lcom/didi/app/nova/skeleton/INavigator;", "showBillCardDialog", "", "entity", "Lcom/didi/entrega/customer/foundation/rpc/entity/AlertEntity;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillDialogHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void showBillCardDialog(INavigator iNavigator, AlertEntity alertEntity) {
            Intrinsics.checkNotNullParameter(iNavigator, "navigator");
            Intrinsics.checkNotNullParameter(alertEntity, "entity");
            RFCommonDialog.Builder message = ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(alertEntity.getTitle())).setMessage(alertEntity.getContent());
            List<AlertBtnEntity> btnList = alertEntity.getBtnList();
            if (btnList != null) {
                int i = 0;
                for (Object next : btnList) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    AlertBtnEntity alertBtnEntity = (AlertBtnEntity) next;
                    if (i == 0) {
                        message.setSubAction1(alertBtnEntity.getDesc(), BillDialogHelper.Companion.getBillCardListener(alertBtnEntity.getAction(), iNavigator));
                    } else if (i == 1) {
                        message.setMainAction(alertBtnEntity.getDesc(), BillDialogHelper.Companion.getBillCardListener(alertBtnEntity.getAction(), iNavigator));
                    }
                    i = i2;
                }
            }
            SodaWindowFactory.showDialog(iNavigator, (Dialog) message.create());
        }

        private final RFDialogInterface.OnClickListener getBillCardListener(String str, INavigator iNavigator) {
            if (Intrinsics.areEqual((Object) str, (Object) "leave")) {
                return new RFDialogInterface.OnClickListener() {
                    public final void onClick(RFDialog rFDialog) {
                        BillDialogHelper.Companion.m46334getBillCardListener$lambda1(INavigator.this, rFDialog);
                    }
                };
            }
            if (Intrinsics.areEqual((Object) str, (Object) AlertBtnEntity.ACTION_STAY)) {
                return $$Lambda$BillDialogHelper$Companion$iTZ9wxnLoJ01bL60CVqbJ8veaIw.INSTANCE;
            }
            return null;
        }

        /* access modifiers changed from: private */
        /* renamed from: getBillCardListener$lambda-1  reason: not valid java name */
        public static final void m46334getBillCardListener$lambda1(INavigator iNavigator, RFDialog rFDialog) {
            Intrinsics.checkNotNullParameter(iNavigator, "$navigator");
            ((ICustomerContactManager) CustomerManagerLoader.loadManager(ICustomerContactManager.class)).clear();
            iNavigator.popToRoot();
            rFDialog.dismiss();
        }

        /* access modifiers changed from: private */
        /* renamed from: getBillCardListener$lambda-2  reason: not valid java name */
        public static final void m46335getBillCardListener$lambda2(RFDialog rFDialog) {
            rFDialog.dismiss();
        }
    }
}
