package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.popmgr;

import android.content.Context;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.base.dialog.GlobalAlertDialog;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.ServiceLoaderUtil;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp;
import com.didi.payment.wallet.global.prepaidcard.PrepaidApplyDialog;
import com.didi.payment.wallet.global.utils.WalletSPUtils;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.IDialogManager;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.WalletHomeDialog;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.WalletHomeDialogManager;
import com.didi.payment.wallet.password.PasswordScene;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import com.didi.payment.wallet_ui.dialog.WalletDrawerContent;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.audiorecorder.Constants;
import com.didiglobal.pay.paysecure.OpenCertificationListener;
import com.didiglobal.pay.paysecure.PaySecure;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/popmgr/PopUpApiTask;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/popmgr/PopTask;", "taskId", "", "(I)V", "mModel", "Lcom/didi/payment/wallet/global/model/WalletPageModel;", "respData", "Lcom/didi/payment/wallet/global/model/resp/WalletPopUpWindowResp;", "canShow", "", "context", "Landroid/content/Context;", "dismiss", "", "getEndOfDayInMillis", "", "popUpKycInfoDialog", "bizData", "Lcom/didi/payment/wallet/global/model/resp/WalletPopUpWindowResp$Data;", "reqData", "onFinish", "Lkotlin/Function0;", "show", "showPwdGuideDialog", "Companion", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.PopUpApiTask */
/* compiled from: PopUpApiTask.kt */
public final class PopUpApiTask extends PopTask {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: c */
    private static final String f32766c = "DDF-PopUpApiTask";

    /* renamed from: a */
    private WalletPageModel f32767a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WalletPopUpWindowResp f32768b;

    public void dismiss(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/popmgr/PopUpApiTask$Companion;", "", "()V", "TAG", "", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.PopUpApiTask$Companion */
    /* compiled from: PopUpApiTask.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public PopUpApiTask(int i) {
        super(i, 3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0034, code lost:
        if (r9 != false) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean canShow(android.content.Context r9) {
        /*
            r8 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp r0 = r8.f32768b
            if (r0 != 0) goto L_0x000b
            r0 = 0
            goto L_0x000f
        L_0x000b:
            com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp$Data r0 = r0.getData()
        L_0x000f:
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0037
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeDialogManager r0 = com.didi.payment.wallet.global.wallet.view.view.home.p142v2.WalletHomeDialogManager.INSTANCE
            com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp r3 = r8.f32768b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp$Data r3 = r3.getData()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.Integer r3 = r3.getType()
            com.didi.payment.wallet.global.wallet.view.view.home.v2.IDialogManager r0 = r0.findDialogManager(r3)
            if (r0 != 0) goto L_0x002d
        L_0x002b:
            r9 = 0
            goto L_0x0034
        L_0x002d:
            boolean r9 = r0.read(r9)
            if (r9 != r1) goto L_0x002b
            r9 = 1
        L_0x0034:
            if (r9 == 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r1 = 0
        L_0x0038:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r1)
            java.lang.String r0 = "canShow = "
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r9)
            r2 = 6
            r5 = 0
            r7 = 48
            java.lang.String r3 = "DDF-PopUpApiTask"
            java.lang.String r6 = "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.PopUpApiTask"
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.view.view.home.p142v2.popmgr.PopUpApiTask.canShow(android.content.Context):boolean");
    }

    public void show(Context context) {
        WalletPopUpWindowResp.Data data;
        Intrinsics.checkNotNullParameter(context, "context");
        SystemUtils.log(6, f32766c, "show", (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.PopUpApiTask", 53);
        WalletPopUpWindowResp walletPopUpWindowResp = this.f32768b;
        if (walletPopUpWindowResp != null && (data = walletPopUpWindowResp.getData()) != null) {
            Integer type = data.getType();
            if (type != null && type.intValue() == 3) {
                WalletHomeDialog walletHomeDialog = new WalletHomeDialog(walletPopUpWindowResp);
                if (!walletHomeDialog.isVisible()) {
                    walletHomeDialog.show(((FragmentActivity) context).getSupportFragmentManager(), "home");
                }
            } else if (type != null && type.intValue() == 2) {
                m23147a(context, data);
            } else if (type != null && type.intValue() == 4) {
                PrepaidApplyDialog prepaidApplyDialog = new PrepaidApplyDialog(walletPopUpWindowResp);
                if (!prepaidApplyDialog.isVisible()) {
                    prepaidApplyDialog.show(((FragmentActivity) context).getSupportFragmentManager(), "prepaid");
                }
            } else if (type != null && type.intValue() == 5) {
                m23149b(context, data);
            }
            IDialogManager findDialogManager = WalletHomeDialogManager.INSTANCE.findDialogManager(data.getType());
            if (findDialogManager != null) {
                findDialogManager.write(context);
            }
        }
    }

    public void reqData(Context context, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "onFinish");
        SystemUtils.log(6, f32766c, "reqData start", (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.PopUpApiTask", 89);
        boolean z = true;
        if (getStatus() == 1) {
            SystemUtils.log(6, f32766c, "reqData cancel:  req is not finish", (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.PopUpApiTask", 91);
            return;
        }
        setStatus(1);
        if (this.f32767a == null) {
            this.f32767a = new WalletPageModel(context);
        }
        long currentTimeMillis = System.currentTimeMillis();
        Long homeKycDialogNextShowTime = WalletSPUtils.getHomeKycDialogNextShowTime(context);
        Intrinsics.checkNotNullExpressionValue(homeKycDialogNextShowTime, "nextShownTime");
        if (currentTimeMillis >= homeKycDialogNextShowTime.longValue()) {
            z = false;
        }
        WalletPageModel walletPageModel = this.f32767a;
        if (walletPageModel != null) {
            walletPageModel.getPopUpWindowInfo(z, new PopUpApiTask$reqData$1(this, function0, context));
        }
    }

    /* renamed from: a */
    private final void m23147a(Context context, WalletPopUpWindowResp.Data data) {
        Integer type;
        if (data.getType() != null && (type = data.getType()) != null && type.intValue() == 2) {
            GlobalAlertDialog globalAlertDialog = new GlobalAlertDialog();
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            arrayList.add(data.getButtonText());
            arrayList2.add(new GlobalAlertDialog.OnBtnClickListener() {
                public final void onBtnClick(DialogFragment dialogFragment, int i) {
                    PopUpApiTask.m23148a(GlobalAlertDialog.this, dialogFragment, i);
                }
            });
            arrayList.add(data.getNegativeButtonText());
            arrayList2.add(new GlobalAlertDialog.OnBtnClickListener() {
                public final void onBtnClick(DialogFragment dialogFragment, int i) {
                    PopUpApiTask.m23150b(GlobalAlertDialog.this, dialogFragment, i);
                }
            });
            globalAlertDialog.setButtons(arrayList);
            globalAlertDialog.setListeners(arrayList2);
            globalAlertDialog.setTitle(data.getTitle());
            globalAlertDialog.setMsg(data.getSubTitle());
            if (!globalAlertDialog.isVisible()) {
                FinOmegaSDK.trackEvent("ibt_password_popup_sw");
                globalAlertDialog.show(((FragmentActivity) context).getSupportFragmentManager(), "pwdDialog");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23148a(GlobalAlertDialog globalAlertDialog, DialogFragment dialogFragment, int i) {
        Intrinsics.checkNotNullParameter(globalAlertDialog, "$dialog");
        FinOmegaSDK.trackEvent("ibt_password_popup_set_ck");
        OpenCertificationListener openCertificationListener = (OpenCertificationListener) ServiceLoaderUtil.getInstance().load(OpenCertificationListener.class);
        if (openCertificationListener != null) {
            PaySecure.INSTANCE.createPayPassword(PasswordScene.HOME_PAGE.name(), openCertificationListener, new PopUpApiTask$showPwdGuideDialog$1$1());
        }
        globalAlertDialog.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m23150b(GlobalAlertDialog globalAlertDialog, DialogFragment dialogFragment, int i) {
        Intrinsics.checkNotNullParameter(globalAlertDialog, "$dialog");
        globalAlertDialog.dismiss();
    }

    /* renamed from: b */
    private final void m23149b(Context context, WalletPopUpWindowResp.Data data) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        WalletDialog.Companion companion = WalletDialog.Companion;
        WalletDrawerContent.Builder builder = new WalletDrawerContent.Builder();
        builder.setTitle(data.getTitle());
        builder.setContent(data.getSubTitle());
        builder.setFirstBtnText(data.getButtonText());
        builder.setFirstClickListener(new PopUpApiTask$popUpKycInfoDialog$1$1(data, context, objectRef));
        builder.setSecondBtnText(data.getNegativeButtonText());
        builder.setSecondClickListener(new PopUpApiTask$popUpKycInfoDialog$1$2(objectRef, data));
        builder.setImageUrl(data.getPictureUrl());
        builder.setShowClose(false);
        Unit unit = Unit.INSTANCE;
        objectRef.element = WalletDialog.Companion.configDrawer$default(companion, context, builder, false, false, 4, (Object) null);
        SystemUtils.showDialog((WalletDialog) objectRef.element);
        WalletSPUtils.setHomeKycDialogNextShowTime(context, Long.valueOf(m23146a()));
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("url", data.getLinkUrl());
        linkedHashMap.put("pub_page", "wallethome");
        linkedHashMap.put("pub_from_page", "");
        FinOmegaSDK.trackEvent("fin_wallet_home_popup_btn_sw", linkedHashMap);
    }

    /* renamed from: a */
    private final long m23146a() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTimeInMillis() + ((long) Constants.TIME_DAY);
    }
}
