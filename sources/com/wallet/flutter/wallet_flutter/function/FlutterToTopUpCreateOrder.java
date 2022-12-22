package com.wallet.flutter.wallet_flutter.function;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.didi.global.fintech.cashier.core.presenter.GlobalCashierBizPresenter;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.facade.CashierLaunchListener;
import com.didi.global.fintech.cashier.user.facade.FastPayFacade;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.payment.base.proxy.CommonProxyHolder;
import com.didi.payment.base.utils.NewCashierApolloUtils;
import com.didi.payment.base.utils.ServiceLoaderUtil;
import com.didi.payment.commonsdk.fastpay.FastPayUtils;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpUniPayActivity;
import com.didi.payment.wallet.password.PasswordDataVo;
import com.didi.payment.wallet.password.PasswordScene;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.wallet.dimina.DiminaLaunchModel;
import com.didiglobal.pay.paysecure.OpenCertificationListener;
import com.didiglobal.pay.paysecure.PaySecure;
import com.wallet.flutter.wallet_flutter.base.IFlutterMethodCall;
import com.wallet.flutter.wallet_flutter.http.PixOrderCreateRespEntity;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175977d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J8\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2&\u0010+\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020-\u0018\u00010,j\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020-\u0018\u0001`.H\u0002J \u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0006\u00102\u001a\u000203H\u0002J\u0018\u00104\u001a\u00020(2\u0006\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u0015H\u0002J(\u00105\u001a\u00020(2\u0006\u00106\u001a\u0002072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00108\u001a\u0002092\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020\nH\u0002J\b\u0010<\u001a\u00020(H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0017\u0010\u0011R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b \u0010\rR\u001a\u0010!\u001a\u00020\"X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006="}, mo175978d2 = {"Lcom/wallet/flutter/wallet_flutter/function/FlutterToTopUpCreateOrder;", "Lcom/wallet/flutter/wallet_flutter/base/IFlutterMethodCall;", "()V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "isHasResult", "", "()Z", "setHasResult", "(Z)V", "mProductLine", "", "getMProductLine", "()I", "setMProductLine", "(I)V", "pluginBindingId", "", "requestCode", "getRequestCode", "requestCode$delegate", "Lkotlin/Lazy;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "rootView", "Landroid/view/View;", "useFastPay", "getUseFastPay", "setUseFastPay", "viewModel", "Lcom/wallet/flutter/wallet_flutter/function/FlutterTopUpViewModel;", "getViewModel", "()Lcom/wallet/flutter/wallet_flutter/function/FlutterTopUpViewModel;", "setViewModel", "(Lcom/wallet/flutter/wallet_flutter/function/FlutterTopUpViewModel;)V", "createOrder", "", "lifeCycle", "Landroidx/lifecycle/LifecycleOwner;", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "launchCashier", "outOrderId", "pub_source", "order", "Lcom/wallet/flutter/wallet_flutter/http/PixOrderCreateRespEntity$OrderMetaData;", "launchOldCashier", "onCall", "call", "Lio/flutter/plugin/common/MethodCall;", "bindingOwner", "Lcom/wallet/flutter/wallet_flutter/base/IActivityAwareOwner;", "resultForFlutter", "success", "setResult", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FlutterToTopUpCreateOrder.kt */
public final class FlutterToTopUpCreateOrder implements IFlutterMethodCall {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public View f56049a;
    public Activity activity;

    /* renamed from: b */
    private String f56050b;

    /* renamed from: c */
    private MethodChannel.Result f56051c;

    /* renamed from: d */
    private boolean f56052d;

    /* renamed from: e */
    private final Lazy f56053e = LazyKt.lazy(new FlutterToTopUpCreateOrder$requestCode$2(this));

    /* renamed from: f */
    private int f56054f;

    /* renamed from: g */
    private boolean f56055g;
    public FlutterTopUpViewModel viewModel;

    public final Activity getActivity() {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            return activity2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        return null;
    }

    public final void setActivity(Activity activity2) {
        Intrinsics.checkNotNullParameter(activity2, "<set-?>");
        this.activity = activity2;
    }

    public final FlutterTopUpViewModel getViewModel() {
        FlutterTopUpViewModel flutterTopUpViewModel = this.viewModel;
        if (flutterTopUpViewModel != null) {
            return flutterTopUpViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public final void setViewModel(FlutterTopUpViewModel flutterTopUpViewModel) {
        Intrinsics.checkNotNullParameter(flutterTopUpViewModel, "<set-?>");
        this.viewModel = flutterTopUpViewModel;
    }

    public final boolean isHasResult() {
        return this.f56052d;
    }

    public final void setHasResult(boolean z) {
        this.f56052d = z;
    }

    /* renamed from: a */
    private final int m40372a() {
        return ((Number) this.f56053e.getValue()).intValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.util.HashMap} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCall(p242io.flutter.plugin.common.MethodCall r3, p242io.flutter.plugin.common.MethodChannel.Result r4, com.wallet.flutter.wallet_flutter.base.IActivityAwareOwner r5, java.lang.String r6) {
        /*
            r2 = this;
            java.lang.String r0 = "call"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "bindingOwner"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "pluginBindingId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = 0
            r2.f56052d = r0
            r2.f56051c = r4
            com.wallet.flutter.wallet_flutter.function.FlutterToTopUpCreateOrder$onCall$1 r4 = new com.wallet.flutter.wallet_flutter.function.FlutterToTopUpCreateOrder$onCall$1
            r4.<init>(r6)
            androidx.lifecycle.LifecycleObserver r4 = (androidx.lifecycle.LifecycleObserver) r4
            io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding r0 = r5.getActivityPluginBinding()
            if (r0 != 0) goto L_0x0027
            goto L_0x002e
        L_0x0027:
            androidx.lifecycle.Lifecycle r0 = p242io.flutter.embedding.engine.plugins.lifecycle.FlutterLifecycleAdapter.getActivityLifecycle(r0)
            r0.addObserver(r4)
        L_0x002e:
            io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding r4 = r5.getActivityPluginBinding()
            if (r4 != 0) goto L_0x0035
            goto L_0x003f
        L_0x0035:
            com.wallet.flutter.wallet_flutter.function.FlutterToTopUpCreateOrder$onCall$$inlined$addActivityResultListener$1 r0 = new com.wallet.flutter.wallet_flutter.function.FlutterToTopUpCreateOrder$onCall$$inlined$addActivityResultListener$1
            r0.<init>(r4, r2)
            io.flutter.plugin.common.PluginRegistry$ActivityResultListener r0 = (p242io.flutter.plugin.common.PluginRegistry.ActivityResultListener) r0
            r4.addActivityResultListener(r0)
        L_0x003f:
            io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding r4 = r5.getActivityPluginBinding()
            if (r4 != 0) goto L_0x0046
            goto L_0x0090
        L_0x0046:
            android.app.Activity r4 = r4.getActivity()
            if (r4 != 0) goto L_0x004d
            goto L_0x0090
        L_0x004d:
            boolean r5 = r4 instanceof androidx.lifecycle.LifecycleOwner
            r0 = 0
            if (r5 == 0) goto L_0x0056
            r5 = r4
            androidx.lifecycle.LifecycleOwner r5 = (androidx.lifecycle.LifecycleOwner) r5
            goto L_0x0057
        L_0x0056:
            r5 = r0
        L_0x0057:
            if (r5 != 0) goto L_0x005a
            goto L_0x0090
        L_0x005a:
            r2.f56050b = r6
            r2.setActivity(r4)
            android.view.Window r5 = r4.getWindow()
            r6 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r5 = r5.findViewById(r6)
            java.lang.String r6 = "activity.window.findViewById(android.R.id.content)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r2.f56049a = r5
            com.wallet.flutter.wallet_flutter.function.FlutterTopUpViewModel r5 = new com.wallet.flutter.wallet_flutter.function.FlutterTopUpViewModel
            android.app.Application r6 = r4.getApplication()
            java.lang.String r1 = "activity.application"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            r5.<init>(r6)
            r2.setViewModel(r5)
            androidx.lifecycle.LifecycleOwner r4 = (androidx.lifecycle.LifecycleOwner) r4
            java.lang.Object r3 = r3.arguments
            boolean r5 = r3 instanceof java.util.HashMap
            if (r5 == 0) goto L_0x008d
            r0 = r3
            java.util.HashMap r0 = (java.util.HashMap) r0
        L_0x008d:
            r2.m40373a((androidx.lifecycle.LifecycleOwner) r4, (java.util.HashMap<java.lang.String, java.lang.Object>) r0)
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wallet.flutter.wallet_flutter.function.FlutterToTopUpCreateOrder.onCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result, com.wallet.flutter.wallet_flutter.base.IActivityAwareOwner, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m40380a(boolean z) {
        if (!this.f56052d) {
            this.f56052d = true;
            MethodChannel.Result result = this.f56051c;
            if (result != null) {
                result.success(Boolean.valueOf(z));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m40381b() {
        if (m40372a() != -1) {
            getActivity().setResult(m40372a());
        }
    }

    public final int getMProductLine() {
        return this.f56054f;
    }

    public final void setMProductLine(int i) {
        this.f56054f = i;
    }

    public final boolean getUseFastPay() {
        return this.f56055g;
    }

    public final void setUseFastPay(boolean z) {
        this.f56055g = z;
    }

    /* renamed from: a */
    private final void m40373a(LifecycleOwner lifecycleOwner, HashMap<String, Object> hashMap) {
        T obj;
        if (hashMap != null) {
            SystemUtils.log(6, "walletTag", "createOrder", (Throwable) null, "com.wallet.flutter.wallet_flutter.function.FlutterToTopUpCreateOrder", 154);
            Map map = hashMap;
            for (Map.Entry entry : map.entrySet()) {
                SystemUtils.log(6, "walletTag", "key : " + ((String) entry.getKey()) + "  / value : " + entry.getValue(), (Throwable) null, "com.wallet.flutter.wallet_flutter.function.FlutterToTopUpCreateOrder", 156);
            }
            Object obj2 = hashMap.get(DiminaLaunchModel.PRODUCT_LINE);
            if (obj2 != null) {
                setMProductLine(Integer.parseInt(obj2.toString()));
            }
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            T t = "";
            objectRef.element = t;
            Object obj3 = hashMap.get(GlobalCashierBizPresenter.OMEGA_ATTR_PUB_SOURCE);
            if (obj3 != null) {
                objectRef.element = obj3.toString();
            }
            Object obj4 = hashMap.get("useFastPay");
            if (obj4 != null && Intrinsics.areEqual(obj4, (Object) true)) {
                setUseFastPay(true);
            }
            Object obj5 = hashMap.get("amountStr");
            if (!(obj5 == null || (obj = obj5.toString()) == null)) {
                t = obj;
            }
            getViewModel().isLoading().observe(lifecycleOwner, new FlutterToTopUpCreateOrder$createOrder$$inlined$observe$1(this));
            getViewModel().getFailedToast().observe(lifecycleOwner, new Observer() {
                public final void onChanged(Object obj) {
                    FlutterToTopUpCreateOrder.m40374a(FlutterToTopUpCreateOrder.this, (String) obj);
                }
            });
            getViewModel().getFailedResult().observe(lifecycleOwner, new Observer() {
                public final void onChanged(Object obj) {
                    FlutterToTopUpCreateOrder.m40375a(FlutterToTopUpCreateOrder.this, (Unit) obj);
                }
            });
            getViewModel().getToH5LiveData().observe(lifecycleOwner, new FlutterToTopUpCreateOrder$createOrder$$inlined$observe$2(this));
            getViewModel().getSuccessOrder().observe(lifecycleOwner, new Observer(objectRef) {
                public final /* synthetic */ Ref.ObjectRef f$1;

                {
                    this.f$1 = r2;
                }

                public final void onChanged(Object obj) {
                    FlutterToTopUpCreateOrder.m40376a(FlutterToTopUpCreateOrder.this, this.f$1, (PixOrderCreateRespEntity.OrderMetaData) obj);
                }
            });
            getViewModel().getPwdData().observe(lifecycleOwner, new Observer(t, this, hashMap) {
                public final /* synthetic */ String f$0;
                public final /* synthetic */ FlutterToTopUpCreateOrder f$1;
                public final /* synthetic */ HashMap f$2;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onChanged(Object obj) {
                    FlutterToTopUpCreateOrder.m40377a(this.f$0, this.f$1, this.f$2, (PasswordDataVo) obj);
                }
            });
            map.put("useFastPay", Boolean.valueOf(this.f56055g));
            map.put("thirdParty", FastPayUtils.INSTANCE.getThreeParty());
            map.put("thirdPartyAbility", FastPayUtils.INSTANCE.getThreePartyAbility());
            FlutterTopUpViewModel.topUp$default(getViewModel(), hashMap, (String) null, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m40374a(FlutterToTopUpCreateOrder flutterToTopUpCreateOrder, String str) {
        Intrinsics.checkNotNullParameter(flutterToTopUpCreateOrder, "this$0");
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            WalletToastNew.showFailedMsg(flutterToTopUpCreateOrder.getActivity(), str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m40375a(FlutterToTopUpCreateOrder flutterToTopUpCreateOrder, Unit unit) {
        Intrinsics.checkNotNullParameter(flutterToTopUpCreateOrder, "this$0");
        flutterToTopUpCreateOrder.m40380a(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m40376a(FlutterToTopUpCreateOrder flutterToTopUpCreateOrder, Ref.ObjectRef objectRef, PixOrderCreateRespEntity.OrderMetaData orderMetaData) {
        Intrinsics.checkNotNullParameter(flutterToTopUpCreateOrder, "this$0");
        Intrinsics.checkNotNullParameter(objectRef, "$pub_source");
        String outTradeId = orderMetaData == null ? null : orderMetaData.getOutTradeId();
        CharSequence charSequence = outTradeId;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            Intrinsics.checkNotNullExpressionValue(orderMetaData, "it");
            flutterToTopUpCreateOrder.m40379a(outTradeId, (String) objectRef.element, orderMetaData);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m40377a(String str, FlutterToTopUpCreateOrder flutterToTopUpCreateOrder, HashMap hashMap, PasswordDataVo passwordDataVo) {
        Intrinsics.checkNotNullParameter(str, "$amountStr");
        Intrinsics.checkNotNullParameter(flutterToTopUpCreateOrder, "this$0");
        if (passwordDataVo.getType() == 1) {
            OpenCertificationListener openCertificationListener = (OpenCertificationListener) ServiceLoaderUtil.getInstance().load(OpenCertificationListener.class);
            String paySessionId = passwordDataVo.getPaySessionId();
            if (openCertificationListener != null && paySessionId != null) {
                PaySecure.INSTANCE.verifyPayPassword(PasswordScene.CHECK_OUT_WALLET.name(), paySessionId, str, new FlutterToTopUpCreateOrder$createOrder$10$1(flutterToTopUpCreateOrder, hashMap), openCertificationListener);
            }
        }
    }

    /* renamed from: a */
    private final void m40379a(String str, String str2, PixOrderCreateRespEntity.OrderMetaData orderMetaData) {
        PixOrderCreateRespEntity.OrderMetaData.ToastInfo toastInfo;
        if (NewCashierApolloUtils.useNewCashier()) {
            CashierParam cashierParam = new CashierParam((String) null, (String) null, (String) null, (String) null, (Map) null, (Map) null, (String) null, 127, (DefaultConstructorMarker) null);
            cashierParam.setOutTradeId(str);
            cashierParam.getOmegaAttrs().put(GlobalCashierBizPresenter.OMEGA_ATTR_PUB_SOURCE, str2);
            Integer cashierType = orderMetaData.getCashierType();
            if (cashierType != null && cashierType.intValue() == 1) {
                FastPayFacade.Companion.getInstance().pay(getActivity(), 200, cashierParam);
                return;
            }
            if (orderMetaData.isFastPayToast() && (toastInfo = orderMetaData.getToastInfo()) != null) {
                if (Intrinsics.areEqual((Object) toastInfo.getType(), (Object) "info")) {
                    WalletToastNew.showMsg(getActivity(), toastInfo.getMessage());
                } else {
                    WalletToastNew.showFailedMsg(getActivity(), toastInfo.getMessage());
                }
            }
            CashierFacade.Companion.getInstance().launchForResult(getActivity(), 200, cashierParam, (CashierLaunchListener) new FlutterToTopUpCreateOrder$launchCashier$2(this, str, str2));
            return;
        }
        m40378a(str, str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m40378a(String str, String str2) {
        CommonProxyHolder.ICommonProxy proxy = CommonProxyHolder.getProxy();
        Object terminalId = proxy == null ? null : proxy.getTerminalId(getActivity());
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("product_line", 650);
        if (terminalId != null) {
            hashMap.put("wallet_terminal_id", terminalId);
            hashMap.put(GlobalCashierBizPresenter.OMEGA_ATTR_PUB_SOURCE, str2);
        }
        Activity activity2 = getActivity();
        PayParam payParam = new PayParam();
        payParam.outTradeId = str;
        payParam.omegaAttrs = hashMap;
        Unit unit = Unit.INSTANCE;
        WalletTopUpUniPayActivity.launch(activity2, payParam, 100);
    }
}
