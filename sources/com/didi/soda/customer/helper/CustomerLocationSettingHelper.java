package com.didi.soda.customer.helper;

import android.app.Activity;
import android.content.Context;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didichuxing.bigdata.p173dp.locsdk.setting.LocationSettingRequestManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0004\u001d\u001e\u001f B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\"\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013JT\u0010\u0014\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0001\u0010\u0011\u001a\u00020\u000428\u0010\u0017\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\t\u0018\u00010\u0018R\u0018\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, mo175978d2 = {"Lcom/didi/soda/customer/helper/CustomerLocationSettingHelper;", "", "()V", "mCurrentRequestScene", "", "getMCurrentRequestScene$annotations", "mIsWindowShown", "", "handleActivityResult", "", "requestCode", "resultCode", "callback", "Lcom/didi/soda/customer/helper/CustomerLocationSettingHelper$ILocationSettingResultHandleCallback;", "startLocationSettingRequest", "activity", "Landroid/app/Activity;", "scene", "requestCallback", "Lcom/didi/soda/customer/helper/CustomerLocationSettingHelper$ILocationSettingRequestCallback;", "updateWindowShownStatus", "ctx", "Landroid/content/Context;", "method", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "refresh", "isWindowShown", "Companion", "CustomerLocationSettingHolder", "ILocationSettingRequestCallback", "ILocationSettingResultHandleCallback", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerLocationSettingHelper.kt */
public final class CustomerLocationSettingHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: c */
    private static final String f41344c = "CustomerLocationSettingHelper";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final CustomerLocationSettingHelper f41345d = CustomerLocationSettingHolder.INSTANCE.getHolder();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f41346a;

    /* renamed from: b */
    private int f41347b;

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/customer/helper/CustomerLocationSettingHelper$ILocationSettingRequestCallback;", "", "onFailed", "", "isWindowShown", "", "onSuccess", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerLocationSettingHelper.kt */
    public interface ILocationSettingRequestCallback {
        void onFailed(boolean z);

        void onSuccess();
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/helper/CustomerLocationSettingHelper$ILocationSettingResultHandleCallback;", "", "onCanceled", "", "onOpened", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerLocationSettingHelper.kt */
    public interface ILocationSettingResultHandleCallback {
        void onCanceled();

        void onOpened();
    }

    public /* synthetic */ CustomerLocationSettingHelper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @LocationSettingScene
    /* renamed from: a */
    private static /* synthetic */ void m29298a() {
    }

    private CustomerLocationSettingHelper() {
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/customer/helper/CustomerLocationSettingHelper$CustomerLocationSettingHolder;", "", "()V", "holder", "Lcom/didi/soda/customer/helper/CustomerLocationSettingHelper;", "getHolder", "()Lcom/didi/soda/customer/helper/CustomerLocationSettingHelper;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerLocationSettingHelper.kt */
    private static final class CustomerLocationSettingHolder {
        public static final CustomerLocationSettingHolder INSTANCE = new CustomerLocationSettingHolder();
        private static final CustomerLocationSettingHelper holder = new CustomerLocationSettingHelper((DefaultConstructorMarker) null);

        private CustomerLocationSettingHolder() {
        }

        public final CustomerLocationSettingHelper getHolder() {
            return holder;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/customer/helper/CustomerLocationSettingHelper$Companion;", "", "()V", "TAG", "", "instance", "Lcom/didi/soda/customer/helper/CustomerLocationSettingHelper;", "getInstance", "()Lcom/didi/soda/customer/helper/CustomerLocationSettingHelper;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerLocationSettingHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CustomerLocationSettingHelper getInstance() {
            return CustomerLocationSettingHelper.f41345d;
        }
    }

    public final void handleActivityResult(int i, int i2, ILocationSettingResultHandleCallback iLocationSettingResultHandleCallback) {
        Intrinsics.checkNotNullParameter(iLocationSettingResultHandleCallback, "callback");
        if (4368 == i) {
            if (i2 == -1) {
                LogUtil.m29104i(f41344c, "location Setting request ok click----");
                iLocationSettingResultHandleCallback.onOpened();
            } else if (i2 == 0) {
                LogUtil.m29104i(f41344c, "location Setting request cancel click----");
                iLocationSettingResultHandleCallback.onCanceled();
            }
            this.f41346a = false;
        }
    }

    public final void startLocationSettingRequest(Activity activity, @LocationSettingScene int i, ILocationSettingRequestCallback iLocationSettingRequestCallback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f41347b = i;
        LocationSettingRequestManager.getInstance().checkSettingRequest(activity, new CustomerLocationSettingHelper$startLocationSettingRequest$1(this, iLocationSettingRequestCallback, i, activity));
    }

    public final void updateWindowShownStatus(Context context, @LocationSettingScene int i, Function2<? super Boolean, ? super Boolean, Unit> function2) {
        LogUtil.m29100d(f41344c, Intrinsics.stringPlus("checkNeedRefreshData-----", Boolean.valueOf(this.f41346a)));
        if (context != null) {
            if (this.f41346a) {
                boolean isGpsEnabled = CustomerSystemUtil.isGpsEnabled(context);
                if (!isGpsEnabled || i != this.f41347b) {
                    if (function2 != null) {
                        function2.invoke(false, true);
                    }
                } else if (function2 != null) {
                    function2.invoke(true, true);
                }
                this.f41346a = false;
                HomeOmegaHelper.getInstance().locationServiceSettingCk(i, isGpsEnabled);
            } else if (function2 != null) {
                function2.invoke(false, false);
            }
        }
    }
}
