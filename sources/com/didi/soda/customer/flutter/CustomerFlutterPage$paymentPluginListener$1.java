package com.didi.soda.customer.flutter;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.soda.customer.app.constant.AppConst;
import com.didi.soda.customer.flutter.plugin.PaymentPlugin;
import com.didi.soda.customer.flutter.plugin.listener.OnCallPluginListener;
import com.didi.soda.customer.flutter.plugin.listener.OnPluginResultListener;
import com.didi.soda.customer.repo.CustomerActivityResultRepo;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.pay.BindCardHelper;
import com.didi.soda.pay.PayOmegaHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/soda/customer/flutter/CustomerFlutterPage$paymentPluginListener$1", "Lcom/didi/soda/customer/flutter/plugin/listener/OnCallPluginListener;", "callPlugin", "", "action", "", "params", "", "", "resultListener", "Lcom/didi/soda/customer/flutter/plugin/listener/OnPluginResultListener;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerFlutterPage.kt */
public final class CustomerFlutterPage$paymentPluginListener$1 implements OnCallPluginListener {
    final /* synthetic */ CustomerFlutterPage this$0;

    CustomerFlutterPage$paymentPluginListener$1(CustomerFlutterPage customerFlutterPage) {
        this.this$0 = customerFlutterPage;
    }

    public void callPlugin(String str, Map<String, ? extends Object> map, OnPluginResultListener onPluginResultListener) {
        Intrinsics.checkNotNullParameter(str, "action");
        if (Intrinsics.areEqual((Object) str, (Object) Intrinsics.stringPlus(PaymentPlugin.BIND_CARD, this.this$0.getPageId()))) {
            DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
            addCardParam.bindType = 14;
            addCardParam.isShowLoading = true;
            addCardParam.isSignAfterOrder = true;
            addCardParam.productLine = AppConst.BUSINESS_ID;
            BindCardHelper.bindCard(addCardParam, 1);
            this.this$0.m29058f();
            if (this.this$0.getScopeContext() != null) {
                this.this$0.f40891a = ((CustomerActivityResultRepo) RepoFactory.getRepo(CustomerActivityResultRepo.class)).subscribeResult(this.this$0.getScopeContext(), new Action1(this.this$0) {
                    public final /* synthetic */ CustomerFlutterPage f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void call(Object obj) {
                        CustomerFlutterPage$paymentPluginListener$1.m46895callPlugin$lambda0(OnPluginResultListener.this, this.f$1, (CustomerActivityResultRepo.ActivityResult) obj);
                    }
                }, 1);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: callPlugin$lambda-0  reason: not valid java name */
    public static final void m46895callPlugin$lambda0(OnPluginResultListener onPluginResultListener, CustomerFlutterPage customerFlutterPage, CustomerActivityResultRepo.ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(customerFlutterPage, "this$0");
        if (activityResult != null && activityResult.requestCode == 1) {
            if (onPluginResultListener != null) {
                OnPluginResultListener.DefaultImpls.onResult$default(onPluginResultListener, (Object) null, 1, (Object) null);
            }
            PayOmegaHelper.bindCardResult(activityResult, "flutter");
        }
        customerFlutterPage.m29058f();
    }
}
