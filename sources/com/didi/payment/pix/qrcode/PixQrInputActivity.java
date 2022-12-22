package com.didi.payment.pix.qrcode;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.commonsdk.activity.AutoDetectQRCodeActivity;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.pix.qrcode.p138vm.PixQueryQrCodeVM;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0012\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u001eH\u0014J\b\u0010#\u001a\u00020\u001eH\u0014J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020%H\u0016J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u0002H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006)"}, mo175978d2 = {"Lcom/didi/payment/pix/qrcode/PixQrInputActivity;", "Lcom/didi/payment/commonsdk/activity/AutoDetectQRCodeActivity;", "Lcom/didi/payment/pix/qrcode/vm/PixQueryQrCodeVM;", "()V", "mClearView", "Landroid/view/View;", "getMClearView", "()Landroid/view/View;", "setMClearView", "(Landroid/view/View;)V", "mEtView", "Landroid/widget/EditText;", "getMEtView", "()Landroid/widget/EditText;", "setMEtView", "(Landroid/widget/EditText;)V", "mSubmitBtn", "getMSubmitBtn", "setMSubmitBtn", "mSwitchView", "getMSwitchView", "setMSwitchView", "mTitleBar", "Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "getMTitleBar", "()Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "setMTitleBar", "(Lcom/didi/sdk/view/titlebar/CommonTitleBar;)V", "getTitleBarView", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onReceivePopbackEvent", "onResume", "registeBackstackEvent", "", "showError", "subscribeUi", "vm", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixQrInputActivity.kt */
public final class PixQrInputActivity extends AutoDetectQRCodeActivity<PixQueryQrCodeVM> {
    public View mClearView;
    public EditText mEtView;
    public View mSubmitBtn;
    public View mSwitchView;
    public CommonTitleBar mTitleBar;

    public boolean registeBackstackEvent() {
        return true;
    }

    public boolean showError() {
        return true;
    }

    public final CommonTitleBar getMTitleBar() {
        CommonTitleBar commonTitleBar = this.mTitleBar;
        if (commonTitleBar != null) {
            return commonTitleBar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
        return null;
    }

    public final void setMTitleBar(CommonTitleBar commonTitleBar) {
        Intrinsics.checkNotNullParameter(commonTitleBar, "<set-?>");
        this.mTitleBar = commonTitleBar;
    }

    public final EditText getMEtView() {
        EditText editText = this.mEtView;
        if (editText != null) {
            return editText;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mEtView");
        return null;
    }

    public final void setMEtView(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<set-?>");
        this.mEtView = editText;
    }

    public final View getMSwitchView() {
        View view = this.mSwitchView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSwitchView");
        return null;
    }

    public final void setMSwitchView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mSwitchView = view;
    }

    public final View getMClearView() {
        View view = this.mClearView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mClearView");
        return null;
    }

    public final void setMClearView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mClearView = view;
    }

    public final View getMSubmitBtn() {
        View view = this.mSubmitBtn;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSubmitBtn");
        return null;
    }

    public final void setMSubmitBtn(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mSubmitBtn = view;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_pix_qrcode_input);
        m21902a();
        ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) this, (ViewModelProvider.Factory) new PixQueryQrCodeVM.Factory(getApplication())).get(PixQueryQrCodeVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ueryQrCodeVM::class.java)");
        setVm((WBaseViewModel) viewModel);
        subscribeUi((PixQueryQrCodeVM) getVm());
        initQRDetectVm();
        FinOmegaSDK.trackEvent("ibt_didipay_pix_manual_input_sw");
    }

    /* access modifiers changed from: protected */
    public void onReceivePopbackEvent() {
        finish();
    }

    /* renamed from: a */
    private final void m21902a() {
        View findViewById = findViewById(R.id.layout_title_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.layout_title_bar)");
        setMTitleBar((CommonTitleBar) findViewById);
        View findViewById2 = findViewById(R.id.pix_qrcode_input_et);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.pix_qrcode_input_et)");
        setMEtView((EditText) findViewById2);
        View findViewById3 = findViewById(R.id.pix_qrcode_input_switch_scan);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.pix_qrcode_input_switch_scan)");
        setMSwitchView(findViewById3);
        View findViewById4 = findViewById(R.id.pix_qrcode_input_clear);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.pix_qrcode_input_clear)");
        setMClearView(findViewById4);
        View findViewById5 = findViewById(R.id.pix_qrcode_input_submit);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.pix_qrcode_input_submit)");
        setMSubmitBtn(findViewById5);
        getMTitleBar().setRightVisible(4);
        getMTitleBar().setTitleBarLineVisible(8);
        getMTitleBar().setVisibility(0);
        getMTitleBar().setLeftImage((int) R.drawable.common_title_back_arrow, (View.OnClickListener) new View.OnClickListener() {
            public final void onClick(View view) {
                PixQrInputActivity.m21903a(PixQrInputActivity.this, view);
            }
        });
        getMClearView().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixQrInputActivity.m21906b(PixQrInputActivity.this, view);
            }
        });
        getMSwitchView().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixQrInputActivity.m21907c(PixQrInputActivity.this, view);
            }
        });
        getMSubmitBtn().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixQrInputActivity.m21908d(PixQrInputActivity.this, view);
            }
        });
        getMEtView().addTextChangedListener(new C10838x15e2f6fd(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21903a(PixQrInputActivity pixQrInputActivity, View view) {
        Intrinsics.checkNotNullParameter(pixQrInputActivity, "this$0");
        pixQrInputActivity.onBackPressed();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m21906b(PixQrInputActivity pixQrInputActivity, View view) {
        Intrinsics.checkNotNullParameter(pixQrInputActivity, "this$0");
        pixQrInputActivity.getMEtView().setText("");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m21907c(PixQrInputActivity pixQrInputActivity, View view) {
        Intrinsics.checkNotNullParameter(pixQrInputActivity, "this$0");
        FinOmegaSDK.trackEvent("ibt_didipay_pix_manual_input_scan_ck");
        DRouter.build("99pay://one/pix_scan_auto").start(pixQrInputActivity);
        pixQrInputActivity.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static final void m21908d(PixQrInputActivity pixQrInputActivity, View view) {
        Intrinsics.checkNotNullParameter(pixQrInputActivity, "this$0");
        FinOmegaSDK.trackEvent("ibt_didipay_pix_manual_input_ck");
        ((PixQueryQrCodeVM) pixQrInputActivity.getVm()).queryQrCodeWithType(pixQrInputActivity.getMEtView().getText().toString(), true);
    }

    public void subscribeUi(PixQueryQrCodeVM pixQueryQrCodeVM) {
        Intrinsics.checkNotNullParameter(pixQueryQrCodeVM, "vm");
        super.subscribeUi(pixQueryQrCodeVM);
        LifecycleOwner lifecycleOwner = this;
        pixQueryQrCodeVM.mErrorMessage.observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PixQrInputActivity.m21905a(PixQrInputActivity.this, (String) obj);
            }
        });
        pixQueryQrCodeVM.mQuerySuccess.observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PixQrInputActivity.m21904a(PixQrInputActivity.this, (Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21905a(PixQrInputActivity pixQrInputActivity, String str) {
        Intrinsics.checkNotNullParameter(pixQrInputActivity, "this$0");
        WalletToastNew.showFailedMsg(pixQrInputActivity, str);
        FinOmegaSDK.trackEvent("ibt_didipay_pix_manual_input_error_sw");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21904a(PixQrInputActivity pixQrInputActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(pixQrInputActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        if (bool.booleanValue()) {
            pixQrInputActivity.finish();
        }
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return getMTitleBar();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }
}
