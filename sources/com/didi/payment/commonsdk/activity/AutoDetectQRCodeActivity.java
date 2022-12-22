package com.didi.payment.commonsdk.activity;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.commonsdk.fragment.QRDetectedDialog;
import com.didi.payment.commonsdk.net.PixQrCodeQueryResp;
import com.didi.payment.commonsdk.p129ui.WBaseActivity;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.commonsdk.utils.NClipBoardUtil;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.pix.common.PixQRCodeVerifyVM;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u00020\fH\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/activity/AutoDetectQRCodeActivity;", "T", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "Lcom/didi/payment/commonsdk/ui/WBaseActivity;", "()V", "qrcodeVerifyVm", "Lcom/didi/payment/pix/common/PixQRCodeVerifyVM;", "getQrcodeVerifyVm", "()Lcom/didi/payment/pix/common/PixQRCodeVerifyVM;", "setQrcodeVerifyVm", "(Lcom/didi/payment/pix/common/PixQRCodeVerifyVM;)V", "autoDetectQrCode", "", "initQRDetectVm", "onStart", "showError", "", "showQRDetectDialog", "context", "Landroid/content/Context;", "qrCode", "Lcom/didi/payment/commonsdk/net/PixQrCodeQueryResp$QRCodeData;", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AutoDetectQRCodeActivity.kt */
public class AutoDetectQRCodeActivity<T extends WBaseViewModel> extends WBaseActivity<T> {
    public PixQRCodeVerifyVM qrcodeVerifyVm;

    public boolean showError() {
        return false;
    }

    public final PixQRCodeVerifyVM getQrcodeVerifyVm() {
        PixQRCodeVerifyVM pixQRCodeVerifyVM = this.qrcodeVerifyVm;
        if (pixQRCodeVerifyVM != null) {
            return pixQRCodeVerifyVM;
        }
        Intrinsics.throwUninitializedPropertyAccessException("qrcodeVerifyVm");
        return null;
    }

    public final void setQrcodeVerifyVm(PixQRCodeVerifyVM pixQRCodeVerifyVM) {
        Intrinsics.checkNotNullParameter(pixQRCodeVerifyVM, "<set-?>");
        this.qrcodeVerifyVm = pixQRCodeVerifyVM;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public final void run() {
                AutoDetectQRCodeActivity.m21114a(AutoDetectQRCodeActivity.this);
            }
        }, 1000);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21114a(AutoDetectQRCodeActivity autoDetectQRCodeActivity) {
        Intrinsics.checkNotNullParameter(autoDetectQRCodeActivity, "this$0");
        autoDetectQRCodeActivity.m21112a();
    }

    public final void initQRDetectVm() {
        ViewModel viewModel = new ViewModelProvider(this).get(PixQRCodeVerifyVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…CodeVerifyVM::class.java)");
        setQrcodeVerifyVm((PixQRCodeVerifyVM) viewModel);
        LifecycleOwner lifecycleOwner = this;
        getQrcodeVerifyVm().qrcodeData.observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                AutoDetectQRCodeActivity.m21115a(AutoDetectQRCodeActivity.this, (PixQrCodeQueryResp.QRCodeData) obj);
            }
        });
        getQrcodeVerifyVm().errMsg.observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                AutoDetectQRCodeActivity.m21116a(AutoDetectQRCodeActivity.this, (String) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21115a(AutoDetectQRCodeActivity autoDetectQRCodeActivity, PixQrCodeQueryResp.QRCodeData qRCodeData) {
        Intrinsics.checkNotNullParameter(autoDetectQRCodeActivity, "this$0");
        if (autoDetectQRCodeActivity.isVisibleToUser()) {
            Intrinsics.checkNotNullExpressionValue(qRCodeData, "qrCode");
            autoDetectQRCodeActivity.m21113a((Context) autoDetectQRCodeActivity, qRCodeData);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21116a(AutoDetectQRCodeActivity autoDetectQRCodeActivity, String str) {
        Intrinsics.checkNotNullParameter(autoDetectQRCodeActivity, "this$0");
        if (autoDetectQRCodeActivity.showError()) {
            WalletToastNew.showFailedMsg(autoDetectQRCodeActivity, str);
        }
    }

    /* renamed from: a */
    private final void m21112a() {
        String clipboardText = NClipBoardUtil.Companion.getClipboardText(this);
        CharSequence charSequence = clipboardText;
        if (!StringsKt.contains$default(charSequence, (CharSequence) "BR.GOV.BCB.PIX", false, 2, (Object) null)) {
            String lowerCase = "BR.GOV.BCB.PIX".toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
            if (!StringsKt.contains$default(charSequence, (CharSequence) lowerCase, false, 2, (Object) null)) {
                return;
            }
        }
        getQrcodeVerifyVm().autoVerifyQRCode(clipboardText);
    }

    /* renamed from: a */
    private final void m21113a(Context context, PixQrCodeQueryResp.QRCodeData qRCodeData) {
        QRDetectedDialog qRDetectedDialog = new QRDetectedDialog(new AutoDetectQRCodeActivity$showQRDetectDialog$qrDetectedDialog$1(qRCodeData, context), qRCodeData);
        qRDetectedDialog.setCancelable(false);
        qRDetectedDialog.show(getSupportFragmentManager(), "qr_detected_fragment_tag");
        FinOmegaSDK.trackEvent("ibt_didipay_pix_clipboard_sw", "pix_payee_key", qRCodeData.getKey());
    }
}
