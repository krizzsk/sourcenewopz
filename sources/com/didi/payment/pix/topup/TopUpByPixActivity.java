package com.didi.payment.pix.topup;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.facade.CashierLaunchListener;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.payment.base.dialog.BackInfoHintDialogFragment;
import com.didi.payment.base.proxy.CommonProxyHolder;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.NewCashierApolloUtils;
import com.didi.payment.base.utils.ServiceLoaderUtil;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.p129ui.WBaseActivity;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.commonsdk.widget.WalletAmountEditText;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.pix.net.response.PixOrderCreateResp;
import com.didi.payment.pix.net.response.PixTopUpOption;
import com.didi.payment.pix.utils.ViewExtsKt;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpPayResultActivity;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpUniPayActivity;
import com.didi.payment.wallet.password.PasswordDataVo;
import com.didi.payment.wallet.password.PasswordScene;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.didi.unifiedPay.component.model.PayParam;
import com.didiglobal.pay.paysecure.OpenCertificationListener;
import com.didiglobal.pay.paysecure.PaySecure;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\"\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/payment/pix/topup/TopUpByPixActivity;", "Lcom/didi/payment/commonsdk/ui/WBaseActivity;", "Lcom/didi/payment/pix/topup/TopUpByPixViewModel;", "()V", "btnTopUp", "Landroid/view/View;", "etAmount", "Lcom/didi/payment/commonsdk/widget/WalletAmountEditText;", "llContent", "llEmpty", "titleBar", "Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "getTitleBarView", "initContentView", "", "launchCashier", "outOrderId", "", "launchOldCashier", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onInflateContentLayout", "showContent", "showRetryView", "Companion", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopUpByPixActivity.kt */
public final class TopUpByPixActivity extends WBaseActivity<TopUpByPixViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int REQUEST_CODE_CASHIER = 100;
    public static final int REQUEST_CODE_NEW_CASHIER = 200;
    public static final int REQUEST_CODE_PAY_RESULT = 101;

    /* renamed from: a */
    private CommonTitleBar f31210a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WalletAmountEditText f31211b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f31212c;

    /* renamed from: d */
    private View f31213d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f31214e;

    public int onInflateContentLayout() {
        return R.layout.activity_top_up_by_pix;
    }

    public static final /* synthetic */ TopUpByPixViewModel access$getVm(TopUpByPixActivity topUpByPixActivity) {
        return (TopUpByPixViewModel) topUpByPixActivity.getVm();
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/payment/pix/topup/TopUpByPixActivity$Companion;", "", "()V", "REQUEST_CODE_CASHIER", "", "REQUEST_CODE_NEW_CASHIER", "REQUEST_CODE_PAY_RESULT", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TopUpByPixActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void initContentView() {
        super.initContentView();
        ComponentActivity componentActivity = this;
        View view = null;
        Function0 function0 = null;
        setVm((WBaseViewModel) new ViewModelLazy(C21490Reflection.getOrCreateKotlinClass(TopUpByPixViewModel.class), new TopUpByPixActivity$initContentView$$inlined$viewModels$default$2(componentActivity), new TopUpByPixActivity$initContentView$$inlined$viewModels$default$1(componentActivity)).getValue());
        View findViewById = findViewById(R.id.common_title_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.common_title_bar)");
        this.f31210a = (CommonTitleBar) findViewById;
        View findViewById2 = findViewById(R.id.aet_amount);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.aet_amount)");
        this.f31211b = (WalletAmountEditText) findViewById2;
        View findViewById3 = findViewById(R.id.btn_topup);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.btn_topup)");
        this.f31212c = findViewById3;
        View findViewById4 = findViewById(R.id.ll_content);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.ll_content)");
        this.f31213d = findViewById4;
        View findViewById5 = findViewById(R.id.ll_empty);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.ll_empty)");
        this.f31214e = findViewById5;
        CommonTitleBar commonTitleBar = this.f31210a;
        if (commonTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            commonTitleBar = null;
        }
        decoretaTitlebar(commonTitleBar);
        CommonTitleBar commonTitleBar2 = this.f31210a;
        if (commonTitleBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            commonTitleBar2 = null;
        }
        ImageView leftImgView = commonTitleBar2.getLeftImgView();
        Intrinsics.checkNotNullExpressionValue(leftImgView, "leftImgView");
        ViewExtsKt.click(leftImgView, new TopUpByPixActivity$initContentView$1$1(this));
        View findViewById6 = commonTitleBar2.findViewById(R.id.title_bar_layout_above);
        if (findViewById6 != null) {
            findViewById6.setBackground((Drawable) null);
        }
        WalletAmountEditText walletAmountEditText = this.f31211b;
        if (walletAmountEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etAmount");
            walletAmountEditText = null;
        }
        walletAmountEditText.setOnExceedListener(new TopUpByPixActivity$initContentView$2(this));
        WalletAmountEditText walletAmountEditText2 = this.f31211b;
        if (walletAmountEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etAmount");
            walletAmountEditText2 = null;
        }
        walletAmountEditText2.setOnAmountValidListener(new TopUpByPixActivity$initContentView$3(this));
        View view2 = this.f31212c;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnTopUp");
            view2 = null;
        }
        view2.setOnClickListener(new TopUpByPixActivity$initContentView$4(this));
        View view3 = this.f31214e;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llEmpty");
        } else {
            view = view3;
        }
        ViewExtsKt.click(view, new TopUpByPixActivity$initContentView$5(this));
        LifecycleOwner lifecycleOwner = this;
        ((TopUpByPixViewModel) getVm()).getPixTopUpOption().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                TopUpByPixActivity.m21962a(TopUpByPixActivity.this, (PixTopUpOption) obj);
            }
        });
        ((TopUpByPixViewModel) getVm()).isLoading().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                TopUpByPixActivity.m21964a(TopUpByPixActivity.this, (Boolean) obj);
            }
        });
        ((TopUpByPixViewModel) getVm()).getSuccessOrder().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                TopUpByPixActivity.m21961a(TopUpByPixActivity.this, (PixOrderCreateResp.OrderMetaData) obj);
            }
        });
        ((TopUpByPixViewModel) getVm()).getFailedToast().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                TopUpByPixActivity.m21965a(TopUpByPixActivity.this, (String) obj);
            }
        });
        ((TopUpByPixViewModel) getVm()).getPwdData().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                TopUpByPixActivity.m21963a(TopUpByPixActivity.this, (PasswordDataVo) obj);
            }
        });
        ((TopUpByPixViewModel) getVm()).getErrObj().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                TopUpByPixActivity.m21960a(TopUpByPixActivity.this, (WBaseResp) obj);
            }
        });
        ((TopUpByPixViewModel) getVm()).loadData();
        FinOmegaSDK.trackEvent("ibt_pixtopup_sw");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21962a(TopUpByPixActivity topUpByPixActivity, PixTopUpOption pixTopUpOption) {
        Intrinsics.checkNotNullParameter(topUpByPixActivity, "this$0");
        Integer maxValue = pixTopUpOption.getMaxValue();
        if (maxValue != null) {
            WalletAmountEditText walletAmountEditText = topUpByPixActivity.f31211b;
            WalletAmountEditText walletAmountEditText2 = null;
            if (walletAmountEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etAmount");
                walletAmountEditText = null;
            }
            walletAmountEditText.setMaxValue(maxValue.intValue());
            WalletAmountEditText walletAmountEditText3 = topUpByPixActivity.f31211b;
            if (walletAmountEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etAmount");
            } else {
                walletAmountEditText2 = walletAmountEditText3;
            }
            walletAmountEditText2.setExtraText(topUpByPixActivity.getString(R.string.GDriver_2_Maximum_amount_HDCC, new Object[]{Intrinsics.stringPlus(topUpByPixActivity.getString(R.string.BRL_Symbol), Integer.valueOf(maxValue.intValue() / 100))}));
            topUpByPixActivity.m21958a();
            return;
        }
        topUpByPixActivity.m21967b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21964a(TopUpByPixActivity topUpByPixActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(topUpByPixActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        if (bool.booleanValue()) {
            topUpByPixActivity.showLoading();
        } else {
            topUpByPixActivity.hideLoading();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21961a(TopUpByPixActivity topUpByPixActivity, PixOrderCreateResp.OrderMetaData orderMetaData) {
        Intrinsics.checkNotNullParameter(topUpByPixActivity, "this$0");
        String outTradeId = orderMetaData == null ? null : orderMetaData.getOutTradeId();
        CharSequence charSequence = outTradeId;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            topUpByPixActivity.m21966a(outTradeId);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21965a(TopUpByPixActivity topUpByPixActivity, String str) {
        Intrinsics.checkNotNullParameter(topUpByPixActivity, "this$0");
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            WalletToastNew.showFailedMsg(topUpByPixActivity, str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21963a(TopUpByPixActivity topUpByPixActivity, PasswordDataVo passwordDataVo) {
        Intrinsics.checkNotNullParameter(topUpByPixActivity, "this$0");
        if (passwordDataVo.getType() == 0) {
            if (passwordDataVo.getTitle() != null && passwordDataVo.getContent() != null && passwordDataVo.getConfirmButton() != null && passwordDataVo.getCancelButton() != null) {
                FinOmegaSDK.trackEvent("ibt_password_paying_bottom_popoup_sw");
                BackInfoHintDialogFragment.show(topUpByPixActivity, passwordDataVo.getTitle(), passwordDataVo.getContent(), passwordDataVo.getCancelButton(), passwordDataVo.getConfirmButton(), (View.OnClickListener) null, new View.OnClickListener() {
                    public final void onClick(View view) {
                        TopUpByPixActivity.m21959a(TopUpByPixActivity.this, view);
                    }
                });
            }
        } else if (passwordDataVo.getType() == 1) {
            OpenCertificationListener openCertificationListener = (OpenCertificationListener) ServiceLoaderUtil.getInstance().load(OpenCertificationListener.class);
            String paySessionId = passwordDataVo.getPaySessionId();
            if (openCertificationListener != null && paySessionId != null) {
                PaySecure paySecure = PaySecure.INSTANCE;
                String name = PasswordScene.CHECK_OUT_WALLET.name();
                StringBuilder sb = new StringBuilder();
                WalletAmountEditText walletAmountEditText = topUpByPixActivity.f31211b;
                WalletAmountEditText walletAmountEditText2 = null;
                if (walletAmountEditText == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("etAmount");
                    walletAmountEditText = null;
                }
                sb.append(walletAmountEditText.getCurrency());
                WalletAmountEditText walletAmountEditText3 = topUpByPixActivity.f31211b;
                if (walletAmountEditText3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("etAmount");
                } else {
                    walletAmountEditText2 = walletAmountEditText3;
                }
                sb.append(walletAmountEditText2.getAmountValue());
                paySecure.verifyPayPassword(name, paySessionId, sb.toString(), new TopUpByPixActivity$initContentView$10$2(topUpByPixActivity), openCertificationListener);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21959a(TopUpByPixActivity topUpByPixActivity, View view) {
        Intrinsics.checkNotNullParameter(topUpByPixActivity, "this$0");
        FinOmegaSDK.trackEvent("ibt_password_paying_bottom_popoup_yes_ck");
        OpenCertificationListener openCertificationListener = (OpenCertificationListener) ServiceLoaderUtil.getInstance().load(OpenCertificationListener.class);
        if (openCertificationListener != null) {
            PaySecure.INSTANCE.createPayPassword(PasswordScene.MONEY_IN.name(), openCertificationListener, new TopUpByPixActivity$initContentView$10$1$1(topUpByPixActivity));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21960a(TopUpByPixActivity topUpByPixActivity, WBaseResp wBaseResp) {
        Intrinsics.checkNotNullParameter(topUpByPixActivity, "this$0");
        topUpByPixActivity.m21967b();
    }

    /* renamed from: a */
    private final void m21958a() {
        View view = this.f31213d;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llContent");
            view = null;
        }
        view.setVisibility(0);
        View view3 = this.f31214e;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llEmpty");
        } else {
            view2 = view3;
        }
        view2.setVisibility(8);
    }

    /* renamed from: b */
    private final void m21967b() {
        View view = this.f31213d;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llContent");
            view = null;
        }
        view.setVisibility(8);
        View view3 = this.f31214e;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llEmpty");
        } else {
            view2 = view3;
        }
        view2.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public CommonTitleBar getTitleBarView() {
        CommonTitleBar commonTitleBar = this.f31210a;
        if (commonTitleBar != null) {
            return commonTitleBar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        return null;
    }

    /* renamed from: a */
    private final void m21966a(String str) {
        if (NewCashierApolloUtils.useNewCashier()) {
            CashierParam cashierParam = new CashierParam((String) null, (String) null, (String) null, (String) null, (Map) null, (Map) null, (String) null, 127, (DefaultConstructorMarker) null);
            cashierParam.setOutTradeId(str);
            CashierFacade.Companion.getInstance().launchForResult((Activity) this, 200, cashierParam, (CashierLaunchListener) new TopUpByPixActivity$launchCashier$1(this, str));
            return;
        }
        m21968b(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m21968b(String str) {
        CommonProxyHolder.ICommonProxy proxy = CommonProxyHolder.getProxy();
        Object terminalId = proxy == null ? null : proxy.getTerminalId(this);
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("product_line", 650);
        if (terminalId != null) {
            hashMap.put("wallet_terminal_id", terminalId);
        }
        PayParam payParam = new PayParam();
        payParam.outTradeId = str;
        payParam.omegaAttrs = hashMap;
        Unit unit = Unit.INSTANCE;
        WalletTopUpUniPayActivity.launch(this, payParam, 100);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            Integer num = null;
            if (i == 100) {
                if (intent != null) {
                    num = Integer.valueOf(intent.getIntExtra("code", 3));
                }
                if (CollectionsKt.contains(CollectionsKt.listOf(1, 3), num)) {
                    WalletTopUpPayResultActivity.launch(this, 101, 650, ((TopUpByPixViewModel) getVm()).getOrderId(), 0);
                    finish();
                }
            } else if (i == 200) {
                if (intent != null) {
                    num = Integer.valueOf(intent.getIntExtra("code", 3));
                }
                if (CollectionsKt.contains(CollectionsKt.listOf(1, 3), num)) {
                    WalletTopUpPayResultActivity.launch(this, 101, 650, ((TopUpByPixViewModel) getVm()).getOrderId(), 0);
                    finish();
                }
            }
        }
    }
}
