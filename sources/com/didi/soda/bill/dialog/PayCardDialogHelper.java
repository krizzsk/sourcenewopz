package com.didi.soda.bill.dialog;

import com.didi.app.nova.skeleton.INavigator;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.rfusion.widget.dialog.RFCommonDialog;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.didi.soda.bill.component.Contract;
import com.didi.soda.bill.dialog.PayCardDialogHelper;
import com.didi.soda.customer.foundation.rpc.entity.bill.AlertBtnEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.AlertEntity;
import com.didi.soda.customer.widget.dialog.SodaWindowFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/bill/dialog/PayCardDialogHelper;", "", "()V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayCardDialogHelper.kt */
public final class PayCardDialogHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final int f38987a = 0;

    /* renamed from: b */
    private static final int f38988b = 1;

    /* renamed from: c */
    private static final int f38989c = 2;

    @Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/soda/bill/dialog/PayCardDialogHelper$Companion;", "", "()V", "BTN_MAIN", "", "BTN_SUB1", "BTN_SUB2", "getBillCardErrorListener", "Lcom/didi/rfusion/widget/dialog/RFDialogInterface$OnClickListener;", "action", "", "listener", "Lcom/didi/soda/bill/component/Contract$IPayCardErrorListener;", "showBillCardErrorDialog", "", "navigator", "Lcom/didi/app/nova/skeleton/INavigator;", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/AlertEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PayCardDialogHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final RFDialogInterface.OnClickListener getBillCardErrorListener(String str, Contract.IPayCardErrorListener iPayCardErrorListener) {
            if (str == null) {
                return null;
            }
            int hashCode = str.hashCode();
            if (hashCode != -1171153032) {
                if (hashCode != 3548) {
                    if (hashCode != 554962037) {
                        if (hashCode == 735364746 && str.equals(AlertBtnEntity.ACTION_EDIT_ADDRESS)) {
                            return new RFDialogInterface.OnClickListener() {
                                public final void onClick(RFDialog rFDialog) {
                                    PayCardDialogHelper.Companion.m46781getBillCardErrorListener$lambda3(Contract.IPayCardErrorListener.this, rFDialog);
                                }
                            };
                        }
                        return null;
                    } else if (!str.equals(AlertBtnEntity.ACTION_CASH_PAY)) {
                        return null;
                    } else {
                        return new RFDialogInterface.OnClickListener() {
                            public final void onClick(RFDialog rFDialog) {
                                PayCardDialogHelper.Companion.m46778getBillCardErrorListener$lambda0(Contract.IPayCardErrorListener.this, rFDialog);
                            }
                        };
                    }
                } else if (!str.equals("ok")) {
                    return null;
                } else {
                    return new RFDialogInterface.OnClickListener() {
                        public final void onClick(RFDialog rFDialog) {
                            PayCardDialogHelper.Companion.m46780getBillCardErrorListener$lambda2(Contract.IPayCardErrorListener.this, rFDialog);
                        }
                    };
                }
            } else if (!str.equals(AlertBtnEntity.ACTION_OTHER_PAY)) {
                return null;
            } else {
                return new RFDialogInterface.OnClickListener() {
                    public final void onClick(RFDialog rFDialog) {
                        PayCardDialogHelper.Companion.m46779getBillCardErrorListener$lambda1(Contract.IPayCardErrorListener.this, rFDialog);
                    }
                };
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: getBillCardErrorListener$lambda-0  reason: not valid java name */
        public static final void m46778getBillCardErrorListener$lambda0(Contract.IPayCardErrorListener iPayCardErrorListener, RFDialog rFDialog) {
            Intrinsics.checkNotNullParameter(iPayCardErrorListener, "$listener");
            iPayCardErrorListener.onCashPay();
            rFDialog.dismiss();
        }

        /* access modifiers changed from: private */
        /* renamed from: getBillCardErrorListener$lambda-1  reason: not valid java name */
        public static final void m46779getBillCardErrorListener$lambda1(Contract.IPayCardErrorListener iPayCardErrorListener, RFDialog rFDialog) {
            Intrinsics.checkNotNullParameter(iPayCardErrorListener, "$listener");
            iPayCardErrorListener.onOtherPay();
            rFDialog.dismiss();
        }

        /* access modifiers changed from: private */
        /* renamed from: getBillCardErrorListener$lambda-2  reason: not valid java name */
        public static final void m46780getBillCardErrorListener$lambda2(Contract.IPayCardErrorListener iPayCardErrorListener, RFDialog rFDialog) {
            Intrinsics.checkNotNullParameter(iPayCardErrorListener, "$listener");
            iPayCardErrorListener.onDismiss();
            rFDialog.dismiss();
        }

        /* access modifiers changed from: private */
        /* renamed from: getBillCardErrorListener$lambda-3  reason: not valid java name */
        public static final void m46781getBillCardErrorListener$lambda3(Contract.IPayCardErrorListener iPayCardErrorListener, RFDialog rFDialog) {
            Intrinsics.checkNotNullParameter(iPayCardErrorListener, "$listener");
            iPayCardErrorListener.onEditAddress();
            rFDialog.dismiss();
        }

        public final void showBillCardErrorDialog(INavigator iNavigator, AlertEntity alertEntity, Contract.IPayCardErrorListener iPayCardErrorListener) {
            Intrinsics.checkNotNullParameter(iNavigator, "navigator");
            Intrinsics.checkNotNullParameter(alertEntity, "entity");
            Intrinsics.checkNotNullParameter(iPayCardErrorListener, "listener");
            RFCommonDialog.Builder builder = (RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(alertEntity.getTitle())).setMessage(alertEntity.getContent()).setBanner(alertEntity.getImg());
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
                        builder.setMainAction(alertBtnEntity.getDesc(), PayCardDialogHelper.Companion.getBillCardErrorListener(alertBtnEntity.getAction(), iPayCardErrorListener));
                    } else if (i == 1) {
                        builder.setSubAction1(alertBtnEntity.getDesc(), PayCardDialogHelper.Companion.getBillCardErrorListener(alertBtnEntity.getAction(), iPayCardErrorListener));
                    } else if (i == 2) {
                        builder.setSubAction2(alertBtnEntity.getDesc(), PayCardDialogHelper.Companion.getBillCardErrorListener(alertBtnEntity.getAction(), iPayCardErrorListener));
                    }
                    i = i2;
                }
            }
            SodaWindowFactory.showDialog(iNavigator, (Dialog) builder.create());
        }
    }
}
