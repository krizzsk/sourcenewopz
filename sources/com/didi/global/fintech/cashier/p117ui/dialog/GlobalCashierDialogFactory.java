package com.didi.global.fintech.cashier.p117ui.dialog;

import android.content.Context;
import com.didi.global.fintech.cashier.p117ui.kts.ContextKtxKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J;\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\f\"\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000e¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogFactory;", "", "()V", "showDialog", "", "context", "Landroid/content/Context;", "type", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogFactory$TYPE;", "config", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogBaseConfig;", "callbacks", "", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogCallback;", "(Landroid/content/Context;Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogFactory$TYPE;Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogBaseConfig;[Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogCallback;)V", "TYPE", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogFactory */
/* compiled from: GlobalCashierDialogFactory.kt */
public final class GlobalCashierDialogFactory {
    public static final GlobalCashierDialogFactory INSTANCE = new GlobalCashierDialogFactory();

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogFactory$TYPE;", "", "(Ljava/lang/String;I)V", "CENTER", "BOTTOM", "SUCCESS", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogFactory$TYPE */
    /* compiled from: GlobalCashierDialogFactory.kt */
    public enum TYPE {
        CENTER,
        BOTTOM,
        SUCCESS
    }

    private GlobalCashierDialogFactory() {
    }

    public final void showDialog(Context context, TYPE type, GlobalCashierDialogBaseConfig globalCashierDialogBaseConfig, GlobalCashierDialogCallback... globalCashierDialogCallbackArr) {
        Context context2 = context;
        TYPE type2 = type;
        GlobalCashierDialogBaseConfig globalCashierDialogBaseConfig2 = globalCashierDialogBaseConfig;
        GlobalCashierDialogCallback[] globalCashierDialogCallbackArr2 = globalCashierDialogCallbackArr;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(type2, "type");
        Intrinsics.checkNotNullParameter(globalCashierDialogBaseConfig2, "config");
        Intrinsics.checkNotNullParameter(globalCashierDialogCallbackArr2, "callbacks");
        KFunction kFunction = null;
        if (type2 == TYPE.CENTER && (globalCashierDialogBaseConfig2 instanceof GlobalCashierDialogCommonConfig)) {
            GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig = (GlobalCashierDialogCommonConfig) globalCashierDialogBaseConfig2;
            String title = globalCashierDialogCommonConfig.title(context);
            String subTitle = globalCashierDialogCommonConfig.subTitle(context);
            String positiveText = globalCashierDialogCommonConfig.positiveText(context);
            String negativeText = globalCashierDialogCommonConfig.negativeText(context);
            GlobalCashierDialogCallback globalCashierDialogCallback = (GlobalCashierDialogCallback) ArraysKt.getOrNull((T[]) globalCashierDialogCallbackArr2, 0);
            KFunction globalCashierDialogFactory$showDialog$1$1 = globalCashierDialogCallback == null ? null : new GlobalCashierDialogFactory$showDialog$1$1(globalCashierDialogCallback);
            GlobalCashierDialogCallback globalCashierDialogCallback2 = (GlobalCashierDialogCallback) ArraysKt.getOrNull((T[]) globalCashierDialogCallbackArr2, 1);
            if (globalCashierDialogCallback2 != null) {
                kFunction = new GlobalCashierDialogFactory$showDialog$2$1(globalCashierDialogCallback2);
            }
            ContextKtxKt.showSimpleCenterDialog(context, title, subTitle, positiveText, (Function0) globalCashierDialogFactory$showDialog$1$1, negativeText, (Function0) kFunction);
        } else if (type2 == TYPE.BOTTOM && (globalCashierDialogBaseConfig2 instanceof GlobalCashierDialogCommonConfig)) {
            GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig2 = (GlobalCashierDialogCommonConfig) globalCashierDialogBaseConfig2;
            String title2 = globalCashierDialogCommonConfig2.title(context);
            String subTitle2 = globalCashierDialogCommonConfig2.subTitle(context);
            boolean isHorizontal = globalCashierDialogCommonConfig2.isHorizontal();
            String positiveText2 = globalCashierDialogCommonConfig2.positiveText(context);
            String negativeText2 = globalCashierDialogCommonConfig2.negativeText(context);
            GlobalCashierDialogCallback globalCashierDialogCallback3 = (GlobalCashierDialogCallback) ArraysKt.getOrNull((T[]) globalCashierDialogCallbackArr2, 0);
            KFunction globalCashierDialogFactory$showDialog$3$1 = globalCashierDialogCallback3 == null ? null : new GlobalCashierDialogFactory$showDialog$3$1(globalCashierDialogCallback3);
            GlobalCashierDialogCallback globalCashierDialogCallback4 = (GlobalCashierDialogCallback) ArraysKt.getOrNull((T[]) globalCashierDialogCallbackArr2, 1);
            if (globalCashierDialogCallback4 != null) {
                kFunction = new GlobalCashierDialogFactory$showDialog$4$1(globalCashierDialogCallback4);
            }
            ContextKtxKt.showBottomDialog$default(context, title2, subTitle2, false, isHorizontal, negativeText2, (Function0) kFunction, positiveText2, (Function0) globalCashierDialogFactory$showDialog$3$1, 4, (Object) null);
        } else if (type2 == TYPE.SUCCESS && (globalCashierDialogBaseConfig2 instanceof GlobalCashierDialogSuccessConfig)) {
            GlobalCashierDialogSuccessConfig globalCashierDialogSuccessConfig = (GlobalCashierDialogSuccessConfig) globalCashierDialogBaseConfig2;
            String status = globalCashierDialogSuccessConfig.status(context);
            String symbol = globalCashierDialogSuccessConfig.getSymbol();
            String price = globalCashierDialogSuccessConfig.getPrice();
            String tipContent = globalCashierDialogSuccessConfig.getTipContent();
            String okText = globalCashierDialogSuccessConfig.okText(context);
            GlobalCashierDialogCallback globalCashierDialogCallback5 = (GlobalCashierDialogCallback) ArraysKt.getOrNull((T[]) globalCashierDialogCallbackArr2, 0);
            if (globalCashierDialogCallback5 != null) {
                kFunction = new GlobalCashierDialogFactory$showDialog$5$1(globalCashierDialogCallback5);
            }
            ContextKtxKt.showPaySuccessDialog(context, status, symbol, price, tipContent, okText, (Function0) kFunction);
        }
    }
}
