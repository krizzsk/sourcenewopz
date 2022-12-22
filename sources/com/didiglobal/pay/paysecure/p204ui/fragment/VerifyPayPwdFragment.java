package com.didiglobal.pay.paysecure.p204ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.util.UiThreadHandler;
import com.didiglobal.pay.paysecure.PaySecure;
import com.didiglobal.pay.paysecure.base.CheckoutScene;
import com.didiglobal.pay.paysecure.base.PaySecureBaseFragment;
import com.didiglobal.pay.paysecure.base.PaySecureState;
import com.didiglobal.pay.paysecure.net.PaySecureRequest;
import com.didiglobal.pay.paysecure.net.pojo.response.PasswordSettings;
import com.didiglobal.pay.paysecure.omega.OmegaUtil;
import com.didiglobal.pay.paysecure.omega.OmegaUtilKt;
import com.didiglobal.pay.paysecure.p204ui.view.CommonBottomDialog;
import com.didiglobal.pay.paysecure.p204ui.view.ErrorDialogCallback;
import com.didiglobal.pay.paysecure.p204ui.view.InputPwdView;
import com.didiglobal.pay.paysecure.util.PaySecurePref;
import com.didiglobal.pay.paysecure.util.UiUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0016J\u0010\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020 H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006&"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/ui/fragment/VerifyPayPwdFragment;", "Lcom/didiglobal/pay/paysecure/base/PaySecureBaseFragment;", "()V", "mAmountLabelTV", "Landroid/widget/TextView;", "mAmountView", "mClose", "Landroid/widget/ImageView;", "mForgotView", "mHintView", "mInputPwdView", "Lcom/didiglobal/pay/paysecure/ui/view/InputPwdView;", "mRootView", "Landroid/view/ViewGroup;", "mSubTitleTV", "verifyPwdCallback", "com/didiglobal/pay/paysecure/ui/fragment/VerifyPayPwdFragment$verifyPwdCallback$1", "Lcom/didiglobal/pay/paysecure/ui/fragment/VerifyPayPwdFragment$verifyPwdCallback$1;", "getErrorDialogCallback", "Lcom/didiglobal/pay/paysecure/ui/view/ErrorDialogCallback;", "getNowState", "Lcom/didiglobal/pay/paysecure/base/PaySecureState;", "onBackPressed", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "", "onStart", "sendRequest", "pwd", "", "showConfirmDialog", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.fragment.VerifyPayPwdFragment */
/* compiled from: VerifyPayPwdFragment.kt */
public final class VerifyPayPwdFragment extends PaySecureBaseFragment {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ViewGroup f50428a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public InputPwdView f50429b;

    /* renamed from: c */
    private TextView f50430c;

    /* renamed from: d */
    private TextView f50431d;

    /* renamed from: e */
    private TextView f50432e;

    /* renamed from: f */
    private TextView f50433f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f50434g;

    /* renamed from: h */
    private ImageView f50435h;

    /* renamed from: i */
    private final VerifyPayPwdFragment$verifyPwdCallback$1 f50436i = new VerifyPayPwdFragment$verifyPwdCallback$1(this);

    public static final /* synthetic */ TextView access$getMHintView$p(VerifyPayPwdFragment verifyPayPwdFragment) {
        TextView textView = verifyPayPwdFragment.f50434g;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHintView");
        }
        return textView;
    }

    public static final /* synthetic */ InputPwdView access$getMInputPwdView$p(VerifyPayPwdFragment verifyPayPwdFragment) {
        InputPwdView inputPwdView = verifyPayPwdFragment.f50429b;
        if (inputPwdView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputPwdView");
        }
        return inputPwdView;
    }

    public static final /* synthetic */ ViewGroup access$getMRootView$p(VerifyPayPwdFragment verifyPayPwdFragment) {
        ViewGroup viewGroup = verifyPayPwdFragment.f50428a;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        }
        return viewGroup;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        CharSequence charSequence;
        Window window;
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        OmegaUtil.Companion.trackEvent("ibt_password_enter_payment_password_sw");
        FragmentActivity activity = getActivity();
        if (!(activity == null || (window = activity.getWindow()) == null)) {
            window.setSoftInputMode(16);
        }
        View inflate = layoutInflater.inflate(R.layout.fragment_verify_pay_pwd, viewGroup, false);
        if (inflate != null) {
            ViewGroup viewGroup2 = (ViewGroup) inflate;
            this.f50428a = viewGroup2;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            View findViewById = viewGroup2.findViewById(R.id.view_input_pwd);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "mRootView.findViewById(R.id.view_input_pwd)");
            this.f50429b = (InputPwdView) findViewById;
            ViewGroup viewGroup3 = this.f50428a;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            View findViewById2 = viewGroup3.findViewById(R.id.view_forgot_pwd);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "mRootView.findViewById(R.id.view_forgot_pwd)");
            this.f50430c = (TextView) findViewById2;
            ViewGroup viewGroup4 = this.f50428a;
            if (viewGroup4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            View findViewById3 = viewGroup4.findViewById(R.id.tv_amount_label);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "mRootView.findViewById(R.id.tv_amount_label)");
            this.f50431d = (TextView) findViewById3;
            ViewGroup viewGroup5 = this.f50428a;
            if (viewGroup5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            View findViewById4 = viewGroup5.findViewById(R.id.tv_sub_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById4, "mRootView.findViewById(R.id.tv_sub_title)");
            this.f50432e = (TextView) findViewById4;
            ViewGroup viewGroup6 = this.f50428a;
            if (viewGroup6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            View findViewById5 = viewGroup6.findViewById(R.id.tv_amount);
            Intrinsics.checkExpressionValueIsNotNull(findViewById5, "mRootView.findViewById(R.id.tv_amount)");
            this.f50433f = (TextView) findViewById5;
            Context context = getContext();
            if (context != null) {
                TextView textView = this.f50430c;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mForgotView");
                }
                textView.setTextColor(ContextCompat.getColor(context, PaySecure.INSTANCE.getConfig().getTheme().getForgetTextColor()));
                TextView textView2 = this.f50433f;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAmountView");
                }
                textView2.setTextColor(ContextCompat.getColor(context, PaySecure.INSTANCE.getConfig().getTheme().getThemeColor()));
            }
            TextView textView3 = this.f50430c;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mForgotView");
            }
            textView3.setOnClickListener(new VerifyPayPwdFragment$onCreateView$2(this));
            if (Intrinsics.areEqual((Object) getMessenger().getScene(), (Object) CheckoutScene.FASTPAY_VERIFY_PASSWD.name())) {
                TextView textView4 = this.f50431d;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAmountLabelTV");
                }
                textView4.setVisibility(8);
                TextView textView5 = this.f50433f;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAmountView");
                }
                textView5.setVisibility(8);
                TextView textView6 = this.f50432e;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSubTitleTV");
                }
                textView6.setVisibility(0);
                TextView textView7 = this.f50432e;
                if (textView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSubTitleTV");
                }
                if (!TextUtils.isEmpty(getMessenger().getAmount())) {
                    charSequence = getString(R.string.Fintech_Payment_FastPay__SaIb, getMessenger().getAmount());
                }
                textView7.setText(charSequence);
            } else {
                TextView textView8 = this.f50431d;
                if (textView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAmountLabelTV");
                }
                textView8.setVisibility(0);
                TextView textView9 = this.f50433f;
                if (textView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAmountView");
                }
                textView9.setVisibility(0);
                TextView textView10 = this.f50432e;
                if (textView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSubTitleTV");
                }
                textView10.setVisibility(8);
                TextView textView11 = this.f50433f;
                if (textView11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAmountView");
                }
                textView11.setText(getMessenger().getAmount());
            }
            ViewGroup viewGroup7 = this.f50428a;
            if (viewGroup7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            View findViewById6 = viewGroup7.findViewById(R.id.tv_verify_pwd_hint);
            Intrinsics.checkExpressionValueIsNotNull(findViewById6, "mRootView.findViewById(R.id.tv_verify_pwd_hint)");
            this.f50434g = (TextView) findViewById6;
            ViewGroup viewGroup8 = this.f50428a;
            if (viewGroup8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            View findViewById7 = viewGroup8.findViewById(R.id.iv_verify_pwd_close);
            Intrinsics.checkExpressionValueIsNotNull(findViewById7, "mRootView.findViewById(R.id.iv_verify_pwd_close)");
            ImageView imageView = (ImageView) findViewById7;
            this.f50435h = imageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mClose");
            }
            imageView.setOnClickListener(new VerifyPayPwdFragment$onCreateView$3(this));
            InputPwdView inputPwdView = this.f50429b;
            if (inputPwdView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputPwdView");
            }
            inputPwdView.setPwdCount(PaySecurePref.INSTANCE.getPwdCount());
            InputPwdView inputPwdView2 = this.f50429b;
            if (inputPwdView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputPwdView");
            }
            inputPwdView2.setMResultListener(new VerifyPayPwdFragment$onCreateView$4(this));
            InputPwdView inputPwdView3 = this.f50429b;
            if (inputPwdView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputPwdView");
            }
            inputPwdView3.requestFocus();
            ViewGroup viewGroup9 = this.f50428a;
            if (viewGroup9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            viewGroup9.setOnClickListener(new VerifyPayPwdFragment$onCreateView$5(this));
            ViewGroup viewGroup10 = this.f50428a;
            if (viewGroup10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            return viewGroup10;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public void onStart() {
        super.onStart();
        UiThreadHandler.post(new VerifyPayPwdFragment$onStart$1(this));
    }

    public void onPause() {
        UiUtils uiUtils = UiUtils.INSTANCE;
        Context context = getContext();
        ViewGroup viewGroup = this.f50428a;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        }
        uiUtils.hideKeyboard(context, viewGroup);
        super.onPause();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m36274a(String str) {
        String str2 = null;
        prepareEncrypt(str, (String) null);
        UiUtils uiUtils = UiUtils.INSTANCE;
        Context context = getContext();
        ViewGroup viewGroup = this.f50428a;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        }
        uiUtils.hideKeyboard(context, viewGroup);
        showLoading((String) null);
        PaySecureRequest paySecureRequest = PaySecureRequest.INSTANCE;
        String scene = getMessenger().getScene();
        String encryptKey = getEncryptKey();
        if (encryptKey == null) {
            Intrinsics.throwNpe();
        }
        PasswordSettings passwordSettings = getMessenger().getPasswordSettings();
        if (passwordSettings != null) {
            str2 = passwordSettings.getKeyId();
        }
        String str3 = str2;
        if (str3 == null) {
            Intrinsics.throwNpe();
        }
        String encryptedPwdString = getEncryptedPwdString();
        if (encryptedPwdString == null) {
            Intrinsics.throwNpe();
        }
        String paySessionId = getMessenger().getPaySessionId();
        if (paySessionId == null) {
            Intrinsics.throwNpe();
        }
        String iv = getIv();
        if (iv == null) {
            Intrinsics.throwNpe();
        }
        paySecureRequest.verifyPwd(scene, encryptKey, str3, encryptedPwdString, paySessionId, iv, this.f50436i);
    }

    public PaySecureState getNowState() {
        return PaySecureState.STATE_VERIFY_PWD;
    }

    public final ErrorDialogCallback getErrorDialogCallback() {
        return new VerifyPayPwdFragment$getErrorDialogCallback$1(this);
    }

    public boolean onBackPressed() {
        UiUtils uiUtils = UiUtils.INSTANCE;
        Context context = getContext();
        ViewGroup viewGroup = this.f50428a;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        }
        uiUtils.hideKeyboard(context, viewGroup);
        m36273a();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m36273a() {
        new CommonBottomDialog(getBaseActivity(), (String) null, (String) null, 6, (DefaultConstructorMarker) null).show(new VerifyPayPwdFragment$showConfirmDialog$1(this));
        new OmegaUtil("ibt_password_give_up_sw").add(OmegaUtilKt.ENTRANCE_PAGE_ID, Integer.valueOf(getSourcePageId())).send();
    }
}
