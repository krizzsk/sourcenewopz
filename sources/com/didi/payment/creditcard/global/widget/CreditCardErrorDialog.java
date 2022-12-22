package com.didi.payment.creditcard.global.widget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.didi.payment.creditcard.global.model.bean.SignResult;
import com.didi.payment.creditcard.global.p130v2.utils.CreditCardOmegaUtil;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import com.didi.payment.wallet_ui.dialog.WalletSystemContent;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/creditcard/global/widget/CreditCardErrorDialog;", "", "()V", "Companion", "creditcard_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreditCardErrorDialog.kt */
public final class CreditCardErrorDialog {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\r"}, mo175978d2 = {"Lcom/didi/payment/creditcard/global/widget/CreditCardErrorDialog$Companion;", "", "()V", "getSystemBuilder", "Lcom/didi/payment/wallet_ui/dialog/WalletSystemContent$Builder;", "context", "Landroid/content/Context;", "result", "Lcom/didi/payment/creditcard/global/model/bean/SignResult;", "dialog", "Lcom/didi/payment/wallet_ui/dialog/WalletDialog;", "showBindFailureDialog", "", "creditcard_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CreditCardErrorDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void showBindFailureDialog(Context context, SignResult signResult) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (signResult != null) {
                WalletDialog createSystem$default = WalletDialog.Companion.createSystem$default(WalletDialog.Companion, context, false, false, 6, (Object) null);
                createSystem$default.setContentView((View) getSystemBuilder(context, signResult, createSystem$default).build(context));
                SystemUtils.showDialog(createSystem$default);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:41:0x00c1  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00ca  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final com.didi.payment.wallet_ui.dialog.WalletSystemContent.Builder getSystemBuilder(android.content.Context r5, com.didi.payment.creditcard.global.model.bean.SignResult r6, com.didi.payment.wallet_ui.dialog.WalletDialog r7) {
            /*
                r4 = this;
                com.didi.payment.wallet_ui.dialog.WalletSystemContent$Builder r0 = new com.didi.payment.wallet_ui.dialog.WalletSystemContent$Builder
                r0.<init>()
                java.lang.String r1 = r6.dialogTitle
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L_0x0016
                int r1 = r1.length()
                if (r1 != 0) goto L_0x0014
                goto L_0x0016
            L_0x0014:
                r1 = 0
                goto L_0x0017
            L_0x0016:
                r1 = 1
            L_0x0017:
                if (r1 != 0) goto L_0x001e
                java.lang.String r1 = r6.dialogTitle
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                goto L_0x0027
            L_0x001e:
                r1 = 2131956721(0x7f1313f1, float:1.9550006E38)
                java.lang.String r1 = r5.getString(r1)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            L_0x0027:
                r0.setTitle(r1)
                java.lang.String r1 = r6.errMsg
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setContent(r1)
                java.lang.String r1 = r6.csPhone
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                if (r1 == 0) goto L_0x0040
                int r1 = r1.length()
                if (r1 != 0) goto L_0x003e
                goto L_0x0040
            L_0x003e:
                r1 = 0
                goto L_0x0041
            L_0x0040:
                r1 = 1
            L_0x0041:
                if (r1 != 0) goto L_0x0083
                java.lang.String r1 = r6.buttonConfirm
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                if (r1 == 0) goto L_0x0052
                int r1 = r1.length()
                if (r1 != 0) goto L_0x0050
                goto L_0x0052
            L_0x0050:
                r1 = 0
                goto L_0x0053
            L_0x0052:
                r1 = 1
            L_0x0053:
                if (r1 != 0) goto L_0x0083
                java.lang.String r1 = r6.buttonConfirm
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setFirstBtnText(r1)
                com.didi.payment.creditcard.global.widget.-$$Lambda$CreditCardErrorDialog$Companion$WpNpRhkltcA3d78VmQkul7OCJVY r1 = new com.didi.payment.creditcard.global.widget.-$$Lambda$CreditCardErrorDialog$Companion$WpNpRhkltcA3d78VmQkul7OCJVY
                r1.<init>(r5, r7, r0)
                r0.setFirstClickListener(r1)
                java.lang.String r5 = r6.buttonCancel
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                if (r5 == 0) goto L_0x0070
                int r5 = r5.length()
                if (r5 != 0) goto L_0x0071
            L_0x0070:
                r2 = 1
            L_0x0071:
                if (r2 != 0) goto L_0x00ab
                java.lang.String r5 = r6.buttonCancel
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r0.setSecondBtnText(r5)
                com.didi.payment.creditcard.global.widget.-$$Lambda$CreditCardErrorDialog$Companion$vP5MdoSTwGGXxd_xgZtOqWpZUs8 r5 = new com.didi.payment.creditcard.global.widget.-$$Lambda$CreditCardErrorDialog$Companion$vP5MdoSTwGGXxd_xgZtOqWpZUs8
                r5.<init>(r6, r0)
                r0.setSecondClickListener(r5)
                goto L_0x00ab
            L_0x0083:
                java.lang.String r1 = r6.buttonCancel
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                if (r1 == 0) goto L_0x008f
                int r1 = r1.length()
                if (r1 != 0) goto L_0x0090
            L_0x008f:
                r2 = 1
            L_0x0090:
                if (r2 != 0) goto L_0x0097
                java.lang.String r5 = r6.buttonCancel
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                goto L_0x00a0
            L_0x0097:
                r1 = 2131956718(0x7f1313ee, float:1.955E38)
                java.lang.String r5 = r5.getString(r1)
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            L_0x00a0:
                r0.setFirstBtnText(r5)
                com.didi.payment.creditcard.global.widget.-$$Lambda$CreditCardErrorDialog$Companion$tC1vWkG7CoNlPD3Wy0poymuhk2w r5 = new com.didi.payment.creditcard.global.widget.-$$Lambda$CreditCardErrorDialog$Companion$tC1vWkG7CoNlPD3Wy0poymuhk2w
                r5.<init>(r0, r7)
                r0.setFirstClickListener(r5)
            L_0x00ab:
                com.didi.payment.creditcard.global.v2.utils.CreditCardOmegaUtil$Companion r5 = com.didi.payment.creditcard.global.p130v2.utils.CreditCardOmegaUtil.Companion
                int r6 = r6.errNo
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
                java.lang.CharSequence r7 = r0.getFirstBtnText()
                java.lang.String r7 = java.lang.String.valueOf(r7)
                java.lang.CharSequence r1 = r0.getSecondBtnText()
                if (r1 == 0) goto L_0x00ca
                java.lang.CharSequence r1 = r0.getSecondBtnText()
                java.lang.String r1 = java.lang.String.valueOf(r1)
                goto L_0x00cb
            L_0x00ca:
                r1 = 0
            L_0x00cb:
                r5.errorShowTrace(r6, r7, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.creditcard.global.widget.CreditCardErrorDialog.Companion.getSystemBuilder(android.content.Context, com.didi.payment.creditcard.global.model.bean.SignResult, com.didi.payment.wallet_ui.dialog.WalletDialog):com.didi.payment.wallet_ui.dialog.WalletSystemContent$Builder");
        }

        /* access modifiers changed from: private */
        /* renamed from: getSystemBuilder$lambda-3$lambda-0  reason: not valid java name */
        public static final void m46524getSystemBuilder$lambda3$lambda0(SignResult signResult, Context context, WalletDialog walletDialog, WalletSystemContent.Builder builder, View view) {
            Intrinsics.checkNotNullParameter(signResult, "$result");
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(walletDialog, "$dialog");
            Intrinsics.checkNotNullParameter(builder, "$this_apply");
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(Intrinsics.stringPlus("tel:", signResult.csPhone)));
            intent.setFlags(268435456);
            context.startActivity(intent);
            walletDialog.dismiss();
            CreditCardOmegaUtil.Companion.errorCkTrace(Integer.valueOf(signResult.errNo), String.valueOf(builder.getFirstBtnText()), builder.getSecondBtnText() != null ? String.valueOf(builder.getSecondBtnText()) : null, "1");
        }

        /* access modifiers changed from: private */
        /* renamed from: getSystemBuilder$lambda-3$lambda-1  reason: not valid java name */
        public static final void m46525getSystemBuilder$lambda3$lambda1(WalletDialog walletDialog, SignResult signResult, WalletSystemContent.Builder builder, View view) {
            Intrinsics.checkNotNullParameter(walletDialog, "$dialog");
            Intrinsics.checkNotNullParameter(signResult, "$result");
            Intrinsics.checkNotNullParameter(builder, "$this_apply");
            walletDialog.dismiss();
            CreditCardOmegaUtil.Companion.errorCkTrace(Integer.valueOf(signResult.errNo), String.valueOf(builder.getFirstBtnText()), String.valueOf(builder.getSecondBtnText()), "2");
        }

        /* access modifiers changed from: private */
        /* renamed from: getSystemBuilder$lambda-3$lambda-2  reason: not valid java name */
        public static final void m46526getSystemBuilder$lambda3$lambda2(SignResult signResult, WalletSystemContent.Builder builder, WalletDialog walletDialog, View view) {
            Intrinsics.checkNotNullParameter(signResult, "$result");
            Intrinsics.checkNotNullParameter(builder, "$this_apply");
            Intrinsics.checkNotNullParameter(walletDialog, "$dialog");
            CreditCardOmegaUtil.Companion.errorCkTrace(Integer.valueOf(signResult.errNo), String.valueOf(builder.getFirstBtnText()), (String) null, "1");
            walletDialog.dismiss();
        }
    }
}
