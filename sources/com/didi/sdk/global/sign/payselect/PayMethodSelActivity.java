package com.didi.sdk.global.sign.payselect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.api.Extend;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import com.didi.payment.base.tracker.FinExtAttrBiz;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletTopUpOmegaUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.fastframe.util.CollectionUtil;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.DidiGlobalPayPalData;
import com.didi.sdk.global.DidiGlobalPayPayData;
import com.didi.sdk.global.base.EventObserver;
import com.didi.sdk.global.base.p151ui.BaseActivity;
import com.didi.sdk.global.base.p151ui.BaseVM;
import com.didi.sdk.global.sign.activity.GlobalBasePayMethodListActivity;
import com.didi.sdk.global.sign.model.event.PayMethodConfirmEvent;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.model.local.PaySelPageData;
import com.didi.sdk.global.sign.payselect.module.NetErrModule;
import com.didi.sdk.global.sign.payselect.module.PaySelModuleMgr;
import com.didi.sdk.global.sign.payselect.utils.GuidePopViewHelper;
import com.didi.sdk.global.sign.payselect.utils.PaySelRouter;
import com.didi.sdk.global.sign.payselect.utils.PaySelUT;
import com.didi.sdk.global.sign.view.helper.PayMethodSelectCloseHelper;
import com.didi.sdk.util.ToastHelper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.taxis99.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0013H\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0013H\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0013H\u0002J\b\u0010!\u001a\u00020\u0019H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020\u0019H\u0002J\b\u0010$\u001a\u00020\u0019H\u0002J\b\u0010%\u001a\u00020\u0019H\u0002J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0013H\u0002J\"\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\b\u0010\u001c\u001a\u0004\u0018\u00010+H\u0014J\b\u0010,\u001a\u00020\u0019H\u0016J\u0012\u0010-\u001a\u00020\u00192\b\u0010.\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010/\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0013H\u0002J\u0010\u00100\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0013H\u0002J\u0012\u00101\u001a\u00020\u00192\b\u00102\u001a\u0004\u0018\u000103H\u0014J\b\u00104\u001a\u00020\u0019H\u0014J\u0010\u00105\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0013H\u0002J\u0010\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u000208H\u0007J\b\u00109\u001a\u00020\u0019H\u0014J\b\u0010:\u001a\u00020\u0019H\u0002J\b\u0010;\u001a\u00020\u0019H\u0002J\u0012\u0010<\u001a\u00020\u00192\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\u0010\u0010?\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000¨\u0006A"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/PayMethodSelActivity;", "Lcom/didi/sdk/global/base/ui/BaseActivity;", "Lcom/didi/sdk/global/sign/payselect/PayMethodSelVM;", "()V", "contentView", "Landroid/widget/LinearLayout;", "finExtAttrBiz", "Lcom/didi/payment/base/tracker/FinExtAttrBiz;", "ivBack", "Landroid/view/View;", "mParam", "Lcom/didi/sdk/global/DidiGlobalPayMethodListData$PayMethodListParam;", "moduleMgr", "Lcom/didi/sdk/global/sign/payselect/module/PaySelModuleMgr;", "needRefreshByTopUp", "", "netErrModule", "Lcom/didi/sdk/global/sign/payselect/module/NetErrModule;", "pendingGuideItemData", "Lcom/didi/sdk/global/sign/model/local/PaySelItemData;", "scrollView", "Landroid/widget/ScrollView;", "titleBarContainer", "Landroid/view/ViewGroup;", "finish", "", "getActId", "", "data", "getNextPageExtAttrs", "getTitleBarView", "go2NewTopUpPage", "info", "initData", "initListener", "initView", "jumpToPayPalV2Page", "jumpToPayPayPage", "on99PayPayMethodClicked", "onActivityResult", "requestCode", "", "resultCode", "Landroid/content/Intent;", "onBackPressed", "onBackPressedWrapper", "clickedInfo", "onClkArrow", "onClkSelect", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onGlobalPayMethodClicked", "onReceiveEvent", "event", "Lcom/didi/sdk/global/sign/model/event/PayMethodConfirmEvent;", "onResume", "parseIntentParam", "playHelpVoice", "setResult", "results", "Lcom/didi/sdk/global/DidiGlobalPayMethodListData$PayMethodListResult;", "subscribeUi", "vm", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayMethodSelActivity.kt */
public final class PayMethodSelActivity extends BaseActivity<PayMethodSelVM> {

    /* renamed from: a */
    private View f36215a;

    /* renamed from: b */
    private ViewGroup f36216b;

    /* renamed from: c */
    private LinearLayout f36217c;

    /* renamed from: d */
    private ScrollView f36218d;

    /* renamed from: e */
    private DidiGlobalPayMethodListData.PayMethodListParam f36219e;

    /* renamed from: f */
    private NetErrModule f36220f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final PaySelModuleMgr f36221g = new PaySelModuleMgr();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public PaySelItemData f36222h;

    /* renamed from: i */
    private final FinExtAttrBiz f36223i = new FinExtAttrBiz();

    /* renamed from: j */
    private boolean f36224j;

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0031, code lost:
        r0 = r0.configInfo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r5) {
        /*
            r4 = this;
            com.didi.sdk.apm.SystemUtils.hookOnlyFullscreenOpaque(r4)
            super.onCreate(r5)
            org.greenrobot.eventbus.EventBus r5 = org.greenrobot.eventbus.EventBus.getDefault()
            r5.register(r4)
            r5 = 2131626084(0x7f0e0864, float:1.8879394E38)
            r4.setContentView((int) r5)
            r4.m25602a()
            r4.m25611b()
            r4.m25614c()
            com.didi.sdk.global.base.ui.BaseVM r5 = r4.getVm()
            com.didi.sdk.global.sign.payselect.PayMethodSelVM r5 = (com.didi.sdk.global.sign.payselect.PayMethodSelVM) r5
            r4.subscribeUi((com.didi.sdk.global.sign.payselect.PayMethodSelVM) r5)
            r4.m25619e()
            com.didi.payment.base.tracker.FinExtAttrBiz r5 = r4.f36223i
            com.didi.sdk.global.DidiGlobalPayMethodListData$PayMethodListParam r0 = r4.f36219e
            r1 = 0
            if (r0 != 0) goto L_0x0031
        L_0x002f:
            r0 = r1
            goto L_0x0038
        L_0x0031:
            com.didi.sdk.global.DidiGlobalPayMethodListData$PayMethodConfigInfo r0 = r0.configInfo
            if (r0 != 0) goto L_0x0036
            goto L_0x002f
        L_0x0036:
            java.lang.String r0 = r0.extOmegaAttrs
        L_0x0038:
            java.lang.String r2 = "PayMethodSelActivity init"
            r5.updateExtAttrs2FinGlobalAttrs(r0, r2)
            com.didi.sdk.global.sign.payselect.utils.PaySelUT r5 = com.didi.sdk.global.sign.payselect.utils.PaySelUT.INSTANCE
            r0 = r4
            android.content.Context r0 = (android.content.Context) r0
            com.didi.sdk.global.DidiGlobalPayMethodListData$PayMethodListParam r2 = r4.f36219e
            java.lang.String r3 = ""
            if (r2 != 0) goto L_0x0049
            goto L_0x004f
        L_0x0049:
            java.lang.String r2 = r2.resourceId
            if (r2 != 0) goto L_0x004e
            goto L_0x004f
        L_0x004e:
            r3 = r2
        L_0x004f:
            r5.init(r0, r3)
            com.didi.sdk.global.base.ui.BaseVM r5 = r4.getVm()
            com.didi.sdk.global.sign.payselect.PayMethodSelVM r5 = (com.didi.sdk.global.sign.payselect.PayMethodSelVM) r5
            androidx.lifecycle.MutableLiveData r5 = r5.getBizDataLD()
            java.lang.Object r5 = r5.getValue()
            com.didi.sdk.global.sign.model.local.PaySelPageData r5 = (com.didi.sdk.global.sign.model.local.PaySelPageData) r5
            if (r5 != 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            java.util.List<com.didi.sdk.global.sign.model.local.PaySelItemData> r1 = r5.payMethodList
        L_0x0067:
            if (r1 == 0) goto L_0x006e
            com.didi.sdk.global.sign.payselect.utils.PaySelUT r5 = com.didi.sdk.global.sign.payselect.utils.PaySelUT.INSTANCE
            r5.show(r1)
        L_0x006e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.global.sign.payselect.PayMethodSelActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        DidiGlobalPayMethodListData.PayMethodConfigInfo payMethodConfigInfo;
        super.onResume();
        FinExtAttrBiz finExtAttrBiz = this.f36223i;
        DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = this.f36219e;
        String str = null;
        if (!(payMethodListParam == null || (payMethodConfigInfo = payMethodListParam.configInfo) == null)) {
            str = payMethodConfigInfo.extOmegaAttrs;
        }
        finExtAttrBiz.updateExtAttrs2FinGlobalAttrs(str, FinExtAttrBiz.FROM_PAYSEL_RESUME);
        if (this.f36224j) {
            this.f36224j = false;
            ((PayMethodSelVM) getVm()).refreshDataFromServer(190, "");
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
        GlobalBasePayMethodListActivity.sAdapter = null;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        SystemUtils.log(3, "wallet", "OnActivityResult, requestCode=" + i + ", resultCode=" + i2, (Throwable) null, "com.didi.sdk.global.sign.payselect.PayMethodSelActivity", 113);
        String str = "";
        if (i != 1) {
            if (i != 3) {
                if (i != 5) {
                    if (i != 6) {
                        switch (i) {
                            case 8:
                            case 10:
                                ((PayMethodSelVM) getVm()).refreshDataFromServer(190, str);
                                return;
                            case 9:
                                ((PayMethodSelVM) getVm()).refreshDataFromServer();
                                return;
                            default:
                                return;
                        }
                    }
                } else if (i2 == -1) {
                    ((PayMethodSelVM) getVm()).refreshDataFromLocal(121, str);
                    return;
                } else {
                    return;
                }
            } else if (i2 == -1 && intent != null && intent.getIntExtra("errno", -1) == 0) {
                ((PayMethodSelVM) getVm()).refreshDataFromServer(152, str);
                return;
            } else {
                return;
            }
        }
        if (i2 == -1) {
            String stringExtra = intent != null ? intent.getStringExtra("card_index") : str;
            PayMethodSelVM payMethodSelVM = (PayMethodSelVM) getVm();
            if (stringExtra != null) {
                str = stringExtra;
            }
            payMethodSelVM.refreshDataFromServer(150, str);
        }
    }

    /* renamed from: a */
    private final void m25602a() {
        View findViewById = findViewById(R.id.iv_payment_paysel_back);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View>(R.id.iv_payment_paysel_back)");
        this.f36215a = findViewById;
        View findViewById2 = findViewById(R.id.payment_paysel_titlebar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.payment_paysel_titlebar)");
        this.f36216b = (ViewGroup) findViewById2;
        View findViewById3 = findViewById(R.id.payment_paysel_content);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.payment_paysel_content)");
        this.f36217c = (LinearLayout) findViewById3;
        ViewStub viewStub = (ViewStub) findViewById(R.id.payment_paysel_net_err_vb);
        Intrinsics.checkNotNullExpressionValue(viewStub, "netErrViewStub");
        this.f36220f = NetErrModule.Companion.create(this, viewStub);
        View findViewById4 = findViewById(R.id.payment_paysel_scroll_view);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.payment_paysel_scroll_view)");
        ScrollView scrollView = (ScrollView) findViewById4;
        this.f36218d = scrollView;
        if (scrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            scrollView = null;
        }
        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            public final void onScrollChanged() {
                PayMethodSelActivity.m25606a(PayMethodSelActivity.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25606a(PayMethodSelActivity payMethodSelActivity) {
        Intrinsics.checkNotNullParameter(payMethodSelActivity, "this$0");
        ScrollView scrollView = payMethodSelActivity.f36218d;
        if (scrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            scrollView = null;
        }
        if (scrollView.getScrollY() > UIUtil.dip2px(payMethodSelActivity, 20.0f)) {
            GuidePopViewHelper.dismiss();
        }
    }

    /* renamed from: b */
    private final void m25611b() {
        View view = this.f36215a;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PayMethodSelActivity.m25608a(PayMethodSelActivity.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25608a(PayMethodSelActivity payMethodSelActivity, View view) {
        Intrinsics.checkNotNullParameter(payMethodSelActivity, "this$0");
        payMethodSelActivity.onBackPressed();
        PaySelUT.INSTANCE.trackCloseBtn();
    }

    /* renamed from: c */
    private final void m25614c() {
        m25617d();
        if (this.f36219e != null) {
            ViewModel viewModel = new ViewModelProvider(this).get(PayMethodSelVM.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…yMethodSelVM::class.java)");
            setVm((BaseVM) viewModel);
            DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = this.f36219e;
            Intrinsics.checkNotNull(payMethodListParam);
            ((PayMethodSelVM) getVm()).init(payMethodListParam, GlobalBasePayMethodListActivity.sAdapter);
            GlobalBasePayMethodListActivity.sAdapter = null;
            ((PayMethodSelVM) getVm()).loadData();
        }
    }

    /* renamed from: d */
    private final void m25617d() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f36219e = (DidiGlobalPayMethodListData.PayMethodListParam) intent.getSerializableExtra("pay_method_list_param");
        }
        if (this.f36219e == null) {
            finish();
        }
    }

    public void subscribeUi(PayMethodSelVM payMethodSelVM) {
        Intrinsics.checkNotNullParameter(payMethodSelVM, "vm");
        super.subscribeUi(payMethodSelVM);
        LifecycleOwner lifecycleOwner = this;
        payMethodSelVM.getBizDataLD().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PayMethodSelActivity.m25610a(PayMethodSelActivity.this, (PaySelPageData) obj);
            }
        });
        payMethodSelVM.getUpdatePaySelItemLD().observe(lifecycleOwner, new EventObserver(new PayMethodSelActivity$subscribeUi$2(this)));
        payMethodSelVM.getOnClkArrowEvent().observe(lifecycleOwner, new EventObserver(new PayMethodSelActivity$subscribeUi$3(this)));
        payMethodSelVM.getOnClkSelectEvent().observe(lifecycleOwner, new EventObserver(new PayMethodSelActivity$subscribeUi$4(this)));
        payMethodSelVM.getOpenH5Event().observe(lifecycleOwner, new EventObserver(new PayMethodSelActivity$subscribeUi$5(this)));
        payMethodSelVM.getMockClkEvent().observe(lifecycleOwner, new EventObserver(new PayMethodSelActivity$subscribeUi$6(this)));
        payMethodSelVM.getClosePageEvent().observe(lifecycleOwner, new EventObserver(new PayMethodSelActivity$subscribeUi$7(this)));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25610a(PayMethodSelActivity payMethodSelActivity, PaySelPageData paySelPageData) {
        Intrinsics.checkNotNullParameter(payMethodSelActivity, "this$0");
        if (paySelPageData != null) {
            PaySelModuleMgr paySelModuleMgr = payMethodSelActivity.f36221g;
            FragmentActivity fragmentActivity = payMethodSelActivity;
            LinearLayout linearLayout = payMethodSelActivity.f36217c;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentView");
                linearLayout = null;
            }
            paySelModuleMgr.addModule(fragmentActivity, linearLayout, paySelPageData);
        }
    }

    public void onBackPressed() {
        List<PaySelItemData> selectedPayMethod = ((PayMethodSelVM) getVm()).getSelectedPayMethod();
        DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = this.f36219e;
        Intrinsics.checkNotNull(payMethodListParam);
        boolean z = false;
        if (payMethodListParam.from == DidiGlobalPayMethodListData.Entrance.FROM_SPLIT_FARE || CollectionUtil.isEmpty((Collection) selectedPayMethod)) {
            finish();
            overridePendingTransition(0, R.anim.one_payment_out_to_right);
        } else if (Intrinsics.areEqual((Object) ((PayMethodSelVM) getVm()).isNetErrorLD().getValue(), (Object) true)) {
            finish();
        } else {
            PayMethodSelectCloseHelper.SelectionValidationResult validateSelectionV2 = PayMethodSelectCloseHelper.validateSelectionV2(selectedPayMethod, this.f36221g.hasSelectablePayItem());
            if (validateSelectionV2 != PayMethodSelectCloseHelper.SelectionValidationResult.SUCCESS) {
                Context context = this;
                ToastHelper.showLongInfo(context, PayMethodSelectCloseHelper.getValidationErrorMessage(context, validateSelectionV2), (int) R.drawable.pay_toast_error);
                return;
            }
            DidiGlobalPayMethodListData.PayMethodListResult prepareSelectedPayMethodResult = PayMethodSelectCloseHelper.prepareSelectedPayMethodResult(selectedPayMethod, 1);
            if (((PayMethodSelVM) getVm()).getHasRequestDataFromServer() || PayMethodSelectCloseHelper.isChannelRefreshed(this, this.f36219e, prepareSelectedPayMethodResult)) {
                z = true;
            }
            prepareSelectedPayMethodResult.hasRefreshed = z;
            SystemUtils.log(3, "wallet", Intrinsics.stringPlus("hasRefreshed? ", Boolean.valueOf(prepareSelectedPayMethodResult.hasRefreshed)), (Throwable) null, "com.didi.sdk.global.sign.payselect.PayMethodSelActivity", 259);
            m25604a(prepareSelectedPayMethodResult);
        }
    }

    /* renamed from: a */
    private final void m25604a(DidiGlobalPayMethodListData.PayMethodListResult payMethodListResult) {
        Intent intent = new Intent();
        intent.putExtra("pay_method_list_result", payMethodListResult);
        setResult(-1, intent);
        finish();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_none, R.anim.bottom_out);
    }

    /* renamed from: e */
    private final void m25619e() {
        TextView textView = (TextView) findViewById(R.id.tv_payment_method_title);
        if (textView != null) {
            textView.postDelayed(new Runnable(textView) {
                public final /* synthetic */ TextView f$0;

                {
                    this.f$0 = r1;
                }

                public final void run() {
                    PayMethodSelActivity.m25603a(this.f$0);
                }
            }, 60);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25603a(TextView textView) {
        textView.setFocusable(true);
        textView.sendAccessibilityEvent(128);
    }

    /* renamed from: a */
    private final void m25605a(PaySelItemData paySelItemData) {
        if (paySelItemData == null || paySelItemData.style != 3) {
            for (PaySelItemData next : ((PayMethodSelVM) getVm()).getSelectedPayMethod()) {
                SystemUtils.log(3, "wallet", "wrapper, method name: " + next.title + ", style=" + next.style, (Throwable) null, "com.didi.sdk.global.sign.payselect.PayMethodSelActivity", 299);
                if (next.style == 3) {
                    SystemUtils.log(3, "wallet", "no auto onBackPressed as switch item is selected", (Throwable) null, "com.didi.sdk.global.sign.payselect.PayMethodSelActivity", 304);
                    return;
                }
            }
            onBackPressed();
            return;
        }
        SystemUtils.log(3, "wallet", "no auto onBackPressed as switch item is involved", (Throwable) null, "com.didi.sdk.global.sign.payselect.PayMethodSelActivity", 295);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m25612b(PaySelItemData paySelItemData) {
        if (paySelItemData == null) {
            m25605a(paySelItemData);
            return;
        }
        SystemUtils.log(3, "wallet", "onPayMethodSelected, name:" + paySelItemData.title + ", channelId=" + paySelItemData.channelId + ", cardIndex=" + paySelItemData.cardIndex, (Throwable) null, "com.didi.sdk.global.sign.payselect.PayMethodSelActivity", 317);
        int i = paySelItemData.channelId;
        if (i != 120) {
            if (i == 121) {
                DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = this.f36219e;
                if (payMethodListParam != null) {
                    Intrinsics.checkNotNull(payMethodListParam);
                    if (payMethodListParam.from == DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION) {
                        PaySelRouter.INSTANCE.jumpToEnterprisePage(this);
                        return;
                    }
                }
                m25605a(paySelItemData);
                return;
            } else if (!(i == 150 || i == 190 || i == 212 || i == 182 || i == 183)) {
                switch (i) {
                    case 152:
                    case 153:
                    case 154:
                        break;
                    default:
                        SystemUtils.log(6, "wallet", "onClkSelect:null", (Throwable) null, "com.didi.sdk.global.sign.payselect.PayMethodSelActivity", 344);
                        return;
                }
            }
        }
        m25605a(paySelItemData);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m25615c(PaySelItemData paySelItemData) {
        if (paySelItemData != null) {
            SystemUtils.log(3, "wallet", "onPayMethodClicked, name:" + paySelItemData.title + ", channelId=" + paySelItemData.channelId + ", cardIndex=" + paySelItemData.cardIndex, (Throwable) null, "com.didi.sdk.global.sign.payselect.PayMethodSelActivity", 354);
            int i = paySelItemData.channelId;
            if (i == 120) {
                m25624h(paySelItemData);
            } else if (i == 121) {
                PaySelRouter.INSTANCE.jumpToEnterprisePage(this);
            } else if (i == 150) {
                PaySelRouter.INSTANCE.jumpToCreditCardActivity(this, paySelItemData, this.f36219e, m25616d(paySelItemData));
            } else if (i == 152) {
                PaySelRouter.INSTANCE.jumpToPayPalPage(this, paySelItemData);
            } else if (i == 190) {
                m25621f(paySelItemData);
            } else if (i == 182) {
                m25620f();
            } else if (i == 183) {
                m25622g();
            }
        }
    }

    /* renamed from: d */
    private final String m25616d(PaySelItemData paySelItemData) {
        DidiGlobalPayMethodListData.PayMethodConfigInfo payMethodConfigInfo;
        DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = this.f36219e;
        String str = null;
        if (!(payMethodListParam == null || (payMethodConfigInfo = payMethodListParam.configInfo) == null)) {
            str = payMethodConfigInfo.extOmegaAttrs;
        }
        String e = m25618e(paySelItemData);
        return !TextUtils.isEmpty(e) ? this.f36223i.getNextPageExt(e) : str;
    }

    /* renamed from: e */
    private final String m25618e(PaySelItemData paySelItemData) {
        String str = paySelItemData.logData;
        if (str == null) {
            return "";
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray(FirebaseAnalytics.Param.PROMOTION_ID);
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return "";
            }
            int length = optJSONArray.length();
            String str2 = "";
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    String optString = optJSONArray.optString(i, "");
                    if (!TextUtils.isEmpty(optString)) {
                        str2 = str2 + optString + ',';
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            if (!StringsKt.endsWith$default(str2, ",", false, 2, (Object) null)) {
                return str2;
            }
            int length2 = str2.length() - 1;
            if (str2 != null) {
                String substring = str2.substring(0, length2);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: f */
    private final void m25620f() {
        DidiGlobalPayPayData.AddPayPayParam addPayPayParam = new DidiGlobalPayPayData.AddPayPayParam();
        addPayPayParam.bindType = 8;
        DidiGlobalPayApiFactory.createDidiPay().startAddPayPayActivity((Activity) this, addPayPayParam, (DidiGlobalPayPayData.PayPayCallback) new DidiGlobalPayPayData.PayPayCallback() {
            public final void onResult(int i, String str) {
                PayMethodSelActivity.m25607a(PayMethodSelActivity.this, i, str);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25607a(PayMethodSelActivity payMethodSelActivity, int i, String str) {
        Intrinsics.checkNotNullParameter(payMethodSelActivity, "this$0");
        if (i == 0) {
            ToastHelper.showLongInfo((Context) payMethodSelActivity, payMethodSelActivity.getString(R.string.one_payment_global_paylist_add_paypay_success), (int) R.drawable.global_ic_toast_success);
            ((PayMethodSelVM) payMethodSelActivity.getVm()).refreshDataFromServer(182, "");
        }
    }

    /* renamed from: g */
    private final void m25622g() {
        DidiGlobalPayPalData.AddPayPalParam addPayPalParam = new DidiGlobalPayPalData.AddPayPalParam();
        addPayPalParam.bindType = 8;
        DidiGlobalPayApiFactory.createDidiPay().startAddNewPayPalActivity((Activity) this, addPayPalParam, (DidiGlobalPayPalData.PayPalCallback) new DidiGlobalPayPalData.PayPalCallback() {
            public final void onResult(int i, String str) {
                PayMethodSelActivity.m25613b(PayMethodSelActivity.this, i, str);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m25613b(PayMethodSelActivity payMethodSelActivity, int i, String str) {
        Intrinsics.checkNotNullParameter(payMethodSelActivity, "this$0");
        if (i == 0) {
            ((PayMethodSelVM) payMethodSelActivity.getVm()).refreshDataFromServer(183, "");
        }
    }

    /* renamed from: f */
    private final void m25621f(PaySelItemData paySelItemData) {
        if (paySelItemData.status == 1) {
            if (WalletApolloUtil.getTopUpIsNew()) {
                m25623g(paySelItemData);
            } else if (((PayMethodSelVM) getVm()).hasAvailableCard()) {
                PaySelRouter.INSTANCE.jumpTo99TopupAmountPage(this);
            } else {
                PaySelRouter.INSTANCE.jumpToTopupChanelPage(this);
            }
            PaySelUT paySelUT = PaySelUT.INSTANCE;
            String str = paySelItemData.logData;
            List<String> list = paySelItemData.cardDiscountTags;
            Intrinsics.checkNotNullExpressionValue(list, "info.cardDiscountTags");
            paySelUT.trackClkWithPromotionInfo("recharge", str, list);
            return;
        }
        PaySelRouter.INSTANCE.jumpToWalletHomePage(this);
    }

    /* renamed from: g */
    private final void m25623g(PaySelItemData paySelItemData) {
        String d = m25616d(paySelItemData);
        WalletTopUpOmegaUtil.Companion.trackEvent("fin_payment_topup_ck", new HashMap());
        String str = "GuaranaOneTravel://one/ddw_top_up?pub_source=rider_payment_topup";
        if (!TextUtils.isEmpty(d)) {
            str = str + "&ext=" + d;
        }
        ((Request) DRouter.build(str).putExtra(Extend.START_ACTIVITY_REQUEST_CODE, 10)).start(this, new RouterCallback() {
            public final void onResult(Result result) {
                PayMethodSelActivity.m25609a(PayMethodSelActivity.this, result);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25609a(PayMethodSelActivity payMethodSelActivity, Result result) {
        Intrinsics.checkNotNullParameter(payMethodSelActivity, "this$0");
        Intrinsics.checkNotNullParameter(result, "it");
        payMethodSelActivity.f36224j = true;
    }

    /* renamed from: h */
    private final void m25624h(PaySelItemData paySelItemData) {
        if (paySelItemData.status == 1) {
            if (WalletApolloUtil.getTopUpIsNew()) {
                m25623g(paySelItemData);
            } else {
                WalletRouter.gotoTopUpChannelActivity(this, 10, 1);
            }
            PaySelUT paySelUT = PaySelUT.INSTANCE;
            String str = paySelItemData.logData;
            List<String> list = paySelItemData.cardDiscountTags;
            Intrinsics.checkNotNullExpressionValue(list, "info.cardDiscountTags");
            paySelUT.trackClkWithPromotionInfo("recharge", str, list);
            return;
        }
        PaySelRouter.INSTANCE.jumpToWalletHomePage(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onReceiveEvent(PayMethodConfirmEvent payMethodConfirmEvent) {
        Intrinsics.checkNotNullParameter(payMethodConfirmEvent, "event");
        PaySelItemData paySelItemData = this.f36222h;
        if (paySelItemData != null) {
            this.f36221g.performClick(paySelItemData);
            this.f36222h = null;
        }
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        ViewGroup viewGroup = this.f36216b;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
            viewGroup = null;
        }
        return viewGroup;
    }
}
