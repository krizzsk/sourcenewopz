package com.didi.global.fintech.cashier.core.spi;

import com.didi.global.fintech.cashier.core.action.IGlobalCashierPasswordActionHandler;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;

@ServiceProvider(alias = "cashier_password", value = {IGlobalCashierPasswordActionHandler.class})
@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/spi/GlobalCashierPasswordActionHandler;", "Lcom/didi/global/fintech/cashier/core/action/IGlobalCashierPasswordActionHandler;", "()V", "handle", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "action", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "param", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "onDestroy", "", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPasswordActionHandler.kt */
public final class GlobalCashierPasswordActionHandler implements IGlobalCashierPasswordActionHandler {
    public void onDestroy() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.didi.global.fintech.cashier.core.GlobalCashierMainActivity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.didi.global.fintech.cashier.core.GlobalCashierMainActivity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.didi.global.fintech.cashier.core.GlobalCashierMainActivity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: com.didi.global.fintech.cashier.core.GlobalCashierMainActivity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: com.didi.global.fintech.cashier.core.GlobalCashierMainActivity} */
    /* JADX WARNING: type inference failed for: r3v7, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handle(androidx.fragment.app.FragmentActivity r11, com.didi.global.fintech.cashier.model.net.request.CashierAction r12, com.didi.global.fintech.cashier.user.model.CashierParam r13) {
        /*
            r10 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = r10
            com.didi.global.fintech.cashier.core.spi.GlobalCashierPasswordActionHandler r0 = (com.didi.global.fintech.cashier.core.spi.GlobalCashierPasswordActionHandler) r0
            r0 = 0
            r1 = 1
            if (r12 != 0) goto L_0x000e
        L_0x000c:
            r2 = 0
            goto L_0x0015
        L_0x000e:
            boolean r2 = r12.password()
            if (r2 != r1) goto L_0x000c
            r2 = 1
        L_0x0015:
            if (r2 == 0) goto L_0x001f
            com.didi.global.fintech.cashier.model.net.request.CashierActionData r2 = r12.getActionData()
            if (r2 == 0) goto L_0x001f
            r2 = 1
            goto L_0x0020
        L_0x001f:
            r2 = 0
        L_0x0020:
            r3 = 0
            if (r2 == 0) goto L_0x0025
            r2 = r10
            goto L_0x0026
        L_0x0025:
            r2 = r3
        L_0x0026:
            com.didi.global.fintech.cashier.core.spi.GlobalCashierPasswordActionHandler r2 = (com.didi.global.fintech.cashier.core.spi.GlobalCashierPasswordActionHandler) r2
            if (r2 != 0) goto L_0x002b
            return r0
        L_0x002b:
            if (r12 != 0) goto L_0x002f
            r12 = r3
            goto L_0x0033
        L_0x002f:
            com.didi.global.fintech.cashier.model.net.request.CashierActionData r12 = r12.getActionData()
        L_0x0033:
            java.lang.Class<com.didiglobal.pay.paysecure.OpenCertificationListener> r2 = com.didiglobal.pay.paysecure.OpenCertificationListener.class
            com.didichuxing.foundation.spi.ServiceLoader r2 = com.didichuxing.foundation.spi.ServiceLoader.load(r2)
            java.lang.String r4 = "load(OpenCertificationListener::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r4 = r2.iterator()
            boolean r4 = r4.hasNext()
            if (r4 != 0) goto L_0x004b
            return r0
        L_0x004b:
            java.util.Iterator r2 = r2.iterator()
            java.lang.Object r2 = r2.next()
            r9 = r2
            com.didiglobal.pay.paysecure.OpenCertificationListener r9 = (com.didiglobal.pay.paysecure.OpenCertificationListener) r9
            if (r12 != 0) goto L_0x005a
            goto L_0x0100
        L_0x005a:
            java.lang.Integer r2 = r12.isSet()
            if (r2 == 0) goto L_0x00a3
            java.lang.Integer r2 = r12.isSet()
            if (r2 != 0) goto L_0x0067
            goto L_0x00a3
        L_0x0067:
            int r2 = r2.intValue()
            if (r2 != r1) goto L_0x00a3
            java.lang.String r0 = r12.getPaySessionId()
            java.lang.String r2 = ""
            if (r0 == 0) goto L_0x0077
            r6 = r0
            goto L_0x0078
        L_0x0077:
            r6 = r2
        L_0x0078:
            java.lang.String r0 = r12.getScene()
            if (r0 == 0) goto L_0x0080
            r5 = r0
            goto L_0x0081
        L_0x0080:
            r5 = r2
        L_0x0081:
            if (r13 != 0) goto L_0x0084
            goto L_0x0088
        L_0x0084:
            java.lang.String r3 = r13.getNeedPayFeeTextDisplay()
        L_0x0088:
            if (r3 != 0) goto L_0x0094
            java.lang.String r12 = r12.getBrandName()
            if (r12 == 0) goto L_0x0092
            r7 = r12
            goto L_0x0095
        L_0x0092:
            r7 = r2
            goto L_0x0095
        L_0x0094:
            r7 = r3
        L_0x0095:
            com.didiglobal.pay.paysecure.PaySecure r4 = com.didiglobal.pay.paysecure.PaySecure.INSTANCE
            com.didi.global.fintech.cashier.core.spi.GlobalCashierPasswordActionHandler$handle$2$1$1 r12 = new com.didi.global.fintech.cashier.core.spi.GlobalCashierPasswordActionHandler$handle$2$1$1
            r12.<init>(r11)
            r8 = r12
            com.didiglobal.pay.paysecure.PayPwdResultListener r8 = (com.didiglobal.pay.paysecure.PayPwdResultListener) r8
            r4.verifyPayPassword(r5, r6, r7, r8, r9)
            goto L_0x0100
        L_0x00a3:
            java.lang.Integer r13 = r12.isSet()
            if (r13 == 0) goto L_0x0100
            java.lang.Integer r12 = r12.isSet()
            if (r12 != 0) goto L_0x00b0
            goto L_0x0100
        L_0x00b0:
            int r12 = r12.intValue()
            if (r12 != 0) goto L_0x0100
            boolean r12 = r11 instanceof com.didi.global.fintech.cashier.core.GlobalCashierMainActivity
            if (r12 == 0) goto L_0x00bd
            r3 = r11
            com.didi.global.fintech.cashier.core.GlobalCashierMainActivity r3 = (com.didi.global.fintech.cashier.core.GlobalCashierMainActivity) r3
        L_0x00bd:
            if (r3 != 0) goto L_0x00c0
            goto L_0x00ca
        L_0x00c0:
            com.didi.global.fintech.cashier.core.contract.IGlobalMainCashierPresenter r12 = r3.getPresenter()
            if (r12 != 0) goto L_0x00c7
            goto L_0x00ca
        L_0x00c7:
            r12.omegaPasswordPopupSw()
        L_0x00ca:
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogFactory r12 = com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogFactory.INSTANCE
            r13 = r11
            android.content.Context r13 = (android.content.Context) r13
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogFactory$TYPE r2 = com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogFactory.TYPE.BOTTOM
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogCommonConfig r3 = com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogCommonConfig.PASSWORD_GUIDE
            com.didi.global.fintech.cashier.user.facade.CashierFacade$Companion r4 = com.didi.global.fintech.cashier.user.facade.CashierFacade.Companion
            com.didi.global.fintech.cashier.user.facade.CashierFacade r4 = r4.getInstance()
            com.didi.global.fintech.cashier.user.theme.ThemeType r4 = r4.getTheme()
            boolean r4 = r4.latour()
            r3.setHorizontal(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogBaseConfig r3 = (com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogBaseConfig) r3
            r4 = 2
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogCallback[] r4 = new com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogCallback[r4]
            com.didi.global.fintech.cashier.core.spi.GlobalCashierPasswordActionHandler$handle$2$1$3 r5 = new com.didi.global.fintech.cashier.core.spi.GlobalCashierPasswordActionHandler$handle$2$1$3
            r5.<init>(r11, r9)
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogCallback r5 = (com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogCallback) r5
            r4[r0] = r5
            com.didi.global.fintech.cashier.core.spi.GlobalCashierPasswordActionHandler$handle$2$1$4 r11 = new com.didi.global.fintech.cashier.core.spi.GlobalCashierPasswordActionHandler$handle$2$1$4
            r11.<init>()
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogCallback r11 = (com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogCallback) r11
            r4[r1] = r11
            r12.showDialog(r13, r2, r3, r4)
        L_0x0100:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.spi.GlobalCashierPasswordActionHandler.handle(androidx.fragment.app.FragmentActivity, com.didi.global.fintech.cashier.model.net.request.CashierAction, com.didi.global.fintech.cashier.user.model.CashierParam):boolean");
    }
}
