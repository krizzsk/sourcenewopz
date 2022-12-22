package com.didi.global.fintech.cashier.core.spi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.api.Extend;
import com.didi.drouter.router.Request;
import com.didi.global.fintech.cashier.core.GlobalCashierMainActivity;
import com.didi.global.fintech.cashier.core.base.BaseCashierActivity;
import com.didi.global.fintech.cashier.model.net.request.CanChangeNewVersionRequest;
import com.didi.global.fintech.cashier.network.CashierNetwork;
import com.didi.global.fintech.cashier.network.processor.GlobalCommonParamsProcessor;
import com.didi.global.fintech.cashier.p117ui.omega.CashierOmegaUtils;
import com.didi.global.fintech.cashier.p117ui.widget.GlobalCashierLoadingView;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.facade.CashierResultListener;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.global.fintech.cashier.user.spi.IGlobalCashierProcessor;
import com.didi.sdk.util.UiThreadHandler;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "cashier", value = {IGlobalCashierProcessor.class})
@Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J1\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010\u0014J1\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010\u0017J\"\u0010\u0018\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\"\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006!"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/spi/GlobalCashierProcessorImpl;", "Lcom/didi/global/fintech/cashier/user/spi/IGlobalCashierProcessor;", "()V", "loadingView", "Lcom/didi/global/fintech/cashier/ui/widget/GlobalCashierLoadingView;", "getLoadingView", "()Lcom/didi/global/fintech/cashier/ui/widget/GlobalCashierLoadingView;", "setLoadingView", "(Lcom/didi/global/fintech/cashier/ui/widget/GlobalCashierLoadingView;)V", "dismissLoading", "", "launch", "activity", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "requestCode", "", "param", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/Integer;Lcom/didi/global/fintech/cashier/user/model/CashierParam;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Landroid/content/Intent;Ljava/lang/Integer;Lcom/didi/global/fintech/cashier/user/model/CashierParam;)V", "launchForResult", "listener", "Lcom/didi/global/fintech/cashier/user/facade/CashierResultListener;", "newVersionCheck", "callback", "Lcom/didi/global/fintech/cashier/user/spi/IGlobalCashierProcessor$Callback;", "showLoading", "context", "Landroid/content/Context;", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierProcessorImpl.kt */
public final class GlobalCashierProcessorImpl implements IGlobalCashierProcessor {

    /* renamed from: a */
    private GlobalCashierLoadingView f21487a;

    public void launchForResult(Fragment fragment, CashierParam cashierParam, CashierResultListener cashierResultListener) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(cashierParam, "param");
    }

    public final GlobalCashierLoadingView getLoadingView() {
        return this.f21487a;
    }

    public final void setLoadingView(GlobalCashierLoadingView globalCashierLoadingView) {
        this.f21487a = globalCashierLoadingView;
    }

    public void newVersionCheck(CashierParam cashierParam, IGlobalCashierProcessor.Callback callback) {
        Intrinsics.checkNotNullParameter(cashierParam, "param");
        Intrinsics.checkNotNullParameter(callback, "callback");
        CashierNetwork cashierNetwork = (CashierNetwork) CashierNetwork.Companion.getInstance(CashierFacade.Companion.getInstance().getApplication());
        CanChangeNewVersionRequest canChangeNewVersionRequest = new CanChangeNewVersionRequest((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        String outTradeId = cashierParam.getOutTradeId();
        String str = "";
        if (outTradeId == null) {
            outTradeId = str;
        }
        canChangeNewVersionRequest.setOut_trade_id(outTradeId);
        String bizContent = cashierParam.getBizContent();
        if (bizContent != null) {
            str = bizContent;
        }
        canChangeNewVersionRequest.setBiz_content(str);
        Unit unit = Unit.INSTANCE;
        cashierNetwork.canChangeNewVersion(canChangeNewVersionRequest, new GlobalCashierProcessorImpl$newVersionCheck$2(callback), new GlobalCashierProcessorImpl$newVersionCheck$3(new GlobalCommonParamsProcessor((String) null, (String) cashierParam.getExtraParams().get(CashierParam.PARAM_FROM_TYPE), 1, (DefaultConstructorMarker) null)));
    }

    public void showLoading(Context context) {
        UiThreadHandler.post(new Runnable(context) {
            public final /* synthetic */ Context f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                GlobalCashierProcessorImpl.m15746a(GlobalCashierProcessorImpl.this, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15746a(GlobalCashierProcessorImpl globalCashierProcessorImpl, Context context) {
        FragmentManager supportFragmentManager;
        GlobalCashierLoadingView loadingView;
        Intrinsics.checkNotNullParameter(globalCashierProcessorImpl, "this$0");
        boolean z = true;
        GlobalCashierProcessorImpl globalCashierProcessorImpl2 = globalCashierProcessorImpl.getLoadingView() == null ? globalCashierProcessorImpl : null;
        if (globalCashierProcessorImpl2 != null) {
            globalCashierProcessorImpl2.setLoadingView(GlobalCashierLoadingView.Companion.newInstance$default(GlobalCashierLoadingView.Companion, false, 1, (Object) null));
        }
        GlobalCashierLoadingView loadingView2 = globalCashierProcessorImpl.getLoadingView();
        if (loadingView2 == null || !loadingView2.isVisible()) {
            z = false;
        }
        if (z) {
            globalCashierProcessorImpl = null;
        }
        if (globalCashierProcessorImpl != null) {
            FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
            if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null && (loadingView = globalCashierProcessorImpl.getLoadingView()) != null) {
                loadingView.setCancelable(false);
                loadingView.show(supportFragmentManager, (String) null);
            }
        }
    }

    public void dismissLoading() {
        UiThreadHandler.post(new Runnable() {
            public final void run() {
                GlobalCashierProcessorImpl.m15745a(GlobalCashierProcessorImpl.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15745a(GlobalCashierProcessorImpl globalCashierProcessorImpl) {
        Intrinsics.checkNotNullParameter(globalCashierProcessorImpl, "this$0");
        GlobalCashierLoadingView loadingView = globalCashierProcessorImpl.getLoadingView();
        if (loadingView != null) {
            loadingView.dismissAllowingStateLoss();
        }
    }

    public void launch(Activity activity, Intent intent, Integer num, CashierParam cashierParam) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(cashierParam, "param");
        CashierOmegaUtils.Companion.setPubFromPage(activity.getComponentName().getClassName());
        if (intent == null && num == null) {
            Intent intent2 = new Intent(activity, GlobalCashierMainActivity.class);
            intent2.putExtra("args_param", cashierParam);
            intent2.putExtra(BaseCashierActivity.ARGS_UNIQUE_ID, GlobalCashierProcessorImplKt.m15747a(activity));
            Unit unit = Unit.INSTANCE;
            activity.startActivity(intent2);
        } else if (intent == null && num != null) {
            Intent intent3 = new Intent(activity, GlobalCashierMainActivity.class);
            intent3.putExtra("args_param", cashierParam);
            intent3.putExtra(BaseCashierActivity.ARGS_UNIQUE_ID, GlobalCashierProcessorImplKt.m15747a(activity));
            Unit unit2 = Unit.INSTANCE;
            activity.startActivityForResult(intent3, num.intValue());
        } else if (intent != null && num == null) {
            intent.putExtra("args_param", cashierParam);
            intent.putExtra(BaseCashierActivity.ARGS_UNIQUE_ID, GlobalCashierProcessorImplKt.m15747a(activity));
            Unit unit3 = Unit.INSTANCE;
            activity.startActivity(intent);
        } else if (intent != null && num != null) {
            intent.putExtra("args_param", cashierParam);
            intent.putExtra(BaseCashierActivity.ARGS_UNIQUE_ID, GlobalCashierProcessorImplKt.m15747a(activity));
            Unit unit4 = Unit.INSTANCE;
            activity.startActivityForResult(intent, num.intValue());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        r1 = r1.getComponentName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void launch(androidx.fragment.app.Fragment r6, android.content.Intent r7, java.lang.Integer r8, com.didi.global.fintech.cashier.user.model.CashierParam r9) {
        /*
            r5 = this;
            java.lang.String r0 = "fragment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "param"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            com.didi.global.fintech.cashier.ui.omega.CashierOmegaUtils$Companion r0 = com.didi.global.fintech.cashier.p117ui.omega.CashierOmegaUtils.Companion
            androidx.fragment.app.FragmentActivity r1 = r6.getActivity()
            r2 = 0
            if (r1 != 0) goto L_0x0016
        L_0x0014:
            r1 = r2
            goto L_0x0021
        L_0x0016:
            android.content.ComponentName r1 = r1.getComponentName()
            if (r1 != 0) goto L_0x001d
            goto L_0x0014
        L_0x001d:
            java.lang.String r1 = r1.getClassName()
        L_0x0021:
            r0.setPubFromPage(r1)
            java.lang.String r0 = "args_unique_id"
            java.lang.String r1 = "args_param"
            if (r7 != 0) goto L_0x0053
            if (r8 != 0) goto L_0x0053
            android.content.Intent r7 = new android.content.Intent
            android.content.Context r8 = r6.getContext()
            java.lang.Class<com.didi.global.fintech.cashier.core.GlobalCashierMainActivity> r3 = com.didi.global.fintech.cashier.core.GlobalCashierMainActivity.class
            r7.<init>(r8, r3)
            java.io.Serializable r9 = (java.io.Serializable) r9
            r7.putExtra(r1, r9)
            androidx.fragment.app.FragmentActivity r8 = r6.getActivity()
            if (r8 != 0) goto L_0x0043
            goto L_0x0049
        L_0x0043:
            android.app.Activity r8 = (android.app.Activity) r8
            java.lang.String r2 = com.didi.global.fintech.cashier.core.spi.GlobalCashierProcessorImplKt.m15747a(r8)
        L_0x0049:
            r7.putExtra(r0, r2)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            r6.startActivity(r7)
            goto L_0x00c2
        L_0x0053:
            if (r7 != 0) goto L_0x0081
            if (r8 == 0) goto L_0x0081
            android.content.Intent r7 = new android.content.Intent
            android.content.Context r3 = r6.getContext()
            java.lang.Class<com.didi.global.fintech.cashier.core.GlobalCashierMainActivity> r4 = com.didi.global.fintech.cashier.core.GlobalCashierMainActivity.class
            r7.<init>(r3, r4)
            java.io.Serializable r9 = (java.io.Serializable) r9
            r7.putExtra(r1, r9)
            androidx.fragment.app.FragmentActivity r9 = r6.getActivity()
            if (r9 != 0) goto L_0x006e
            goto L_0x0074
        L_0x006e:
            android.app.Activity r9 = (android.app.Activity) r9
            java.lang.String r2 = com.didi.global.fintech.cashier.core.spi.GlobalCashierProcessorImplKt.m15747a(r9)
        L_0x0074:
            r7.putExtra(r0, r2)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            int r8 = r8.intValue()
            r6.startActivityForResult(r7, r8)
            goto L_0x00c2
        L_0x0081:
            if (r7 == 0) goto L_0x00a0
            if (r8 != 0) goto L_0x00a0
            java.io.Serializable r9 = (java.io.Serializable) r9
            r7.putExtra(r1, r9)
            androidx.fragment.app.FragmentActivity r8 = r6.getActivity()
            if (r8 != 0) goto L_0x0091
            goto L_0x0097
        L_0x0091:
            android.app.Activity r8 = (android.app.Activity) r8
            java.lang.String r2 = com.didi.global.fintech.cashier.core.spi.GlobalCashierProcessorImplKt.m15747a(r8)
        L_0x0097:
            r7.putExtra(r0, r2)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            r6.startActivity(r7)
            goto L_0x00c2
        L_0x00a0:
            if (r7 == 0) goto L_0x00c2
            if (r8 == 0) goto L_0x00c2
            java.io.Serializable r9 = (java.io.Serializable) r9
            r7.putExtra(r1, r9)
            androidx.fragment.app.FragmentActivity r9 = r6.getActivity()
            if (r9 != 0) goto L_0x00b0
            goto L_0x00b6
        L_0x00b0:
            android.app.Activity r9 = (android.app.Activity) r9
            java.lang.String r2 = com.didi.global.fintech.cashier.core.spi.GlobalCashierProcessorImplKt.m15747a(r9)
        L_0x00b6:
            r7.putExtra(r0, r2)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            int r8 = r8.intValue()
            r6.startActivityForResult(r7, r8)
        L_0x00c2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.spi.GlobalCashierProcessorImpl.launch(androidx.fragment.app.Fragment, android.content.Intent, java.lang.Integer, com.didi.global.fintech.cashier.user.model.CashierParam):void");
    }

    public void launchForResult(Activity activity, CashierParam cashierParam, CashierResultListener cashierResultListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(cashierParam, "param");
        Request build = DRouter.build("");
        Context context = activity;
        Intent intent = new Intent(context, GlobalCashierMainActivity.class);
        intent.putExtra("args_param", cashierParam);
        intent.putExtra(BaseCashierActivity.ARGS_UNIQUE_ID, GlobalCashierProcessorImplKt.m15747a(activity));
        Unit unit = Unit.INSTANCE;
        ((Request) ((Request) build.putExtra(Extend.START_ACTIVITY_VIA_INTENT, (Parcelable) intent)).putExtra(Extend.START_ACTIVITY_REQUEST_CODE, 69)).start(context, new GlobalCashierProcessorImpl$launchForResult$2(cashierResultListener));
    }
}
