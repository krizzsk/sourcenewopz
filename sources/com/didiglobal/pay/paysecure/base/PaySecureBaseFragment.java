package com.didiglobal.pay.paysecure.base;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didiglobal.pay.paysecure.net.pojo.response.ErrorData;
import com.didiglobal.pay.paysecure.net.pojo.response.PasswordSettings;
import com.didiglobal.pay.paysecure.p204ui.view.ErrorDialog;
import com.didiglobal.pay.paysecure.p204ui.view.ErrorDialogCallback;
import com.didiglobal.pay.paysecure.util.CipherUtil;
import com.didiglobal.pay.paysecure.util.ToastUtil;
import com.didiglobal.pay.paysecure.util.UiUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u0019H&J\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020&H\u0016J\u0012\u0010'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001a\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\u0004H\u0004J$\u0010-\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u000203H\u0004J\u0012\u00104\u001a\u00020$2\b\u00105\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u00106\u001a\u00020$2\u0006\u00107\u001a\u00020\u0019H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00068"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/base/PaySecureBaseFragment;", "Landroidx/fragment/app/Fragment;", "()V", "aesKey", "", "getAesKey", "()Ljava/lang/String;", "setAesKey", "(Ljava/lang/String;)V", "baseActivity", "Lcom/didiglobal/pay/paysecure/base/AbsPaySecureBaseActivity;", "getBaseActivity", "()Lcom/didiglobal/pay/paysecure/base/AbsPaySecureBaseActivity;", "setBaseActivity", "(Lcom/didiglobal/pay/paysecure/base/AbsPaySecureBaseActivity;)V", "encryptKey", "getEncryptKey", "setEncryptKey", "encryptedPwdString", "getEncryptedPwdString", "setEncryptedPwdString", "iv", "getIv", "setIv", "mState", "Lcom/didiglobal/pay/paysecure/base/PaySecureState;", "getMState", "()Lcom/didiglobal/pay/paysecure/base/PaySecureState;", "setMState", "(Lcom/didiglobal/pay/paysecure/base/PaySecureState;)V", "getMessenger", "Lcom/didiglobal/pay/paysecure/base/FragmentMessenger;", "getNowState", "getSourcePageId", "", "hideLoading", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "prepareEncrypt", "pwd", "oldPwd", "showErrorData", "errorData", "Lcom/didiglobal/pay/paysecure/net/pojo/response/ErrorData;", "hintView", "Landroid/widget/TextView;", "callback", "Lcom/didiglobal/pay/paysecure/ui/view/ErrorDialogCallback;", "showLoading", "msg", "transform", "state", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: PaySecureBaseFragment.kt */
public abstract class PaySecureBaseFragment extends Fragment {

    /* renamed from: a */
    private AbsPaySecureBaseActivity f50315a;

    /* renamed from: b */
    private String f50316b;

    /* renamed from: c */
    private String f50317c;

    /* renamed from: d */
    private String f50318d;

    /* renamed from: e */
    private String f50319e;
    protected PaySecureState mState;

    public abstract PaySecureState getNowState();

    public boolean onBackPressed() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final PaySecureState getMState() {
        PaySecureState paySecureState = this.mState;
        if (paySecureState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mState");
        }
        return paySecureState;
    }

    /* access modifiers changed from: protected */
    public final void setMState(PaySecureState paySecureState) {
        Intrinsics.checkParameterIsNotNull(paySecureState, "<set-?>");
        this.mState = paySecureState;
    }

    public final AbsPaySecureBaseActivity getBaseActivity() {
        return this.f50315a;
    }

    public final void setBaseActivity(AbsPaySecureBaseActivity absPaySecureBaseActivity) {
        this.f50315a = absPaySecureBaseActivity;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("initState") : null;
        if (serializable != null) {
            this.mState = (PaySecureState) serializable;
            if (getActivity() instanceof AbsPaySecureBaseActivity) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    this.f50315a = (AbsPaySecureBaseActivity) activity;
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.didiglobal.pay.paysecure.base.AbsPaySecureBaseActivity");
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.didiglobal.pay.paysecure.base.PaySecureState");
    }

    public FragmentMessenger getMessenger() {
        AbsPaySecureBaseActivity absPaySecureBaseActivity = this.f50315a;
        FragmentMessenger currentMessenger = absPaySecureBaseActivity != null ? absPaySecureBaseActivity.getCurrentMessenger() : null;
        if (currentMessenger == null) {
            Intrinsics.throwNpe();
        }
        return currentMessenger;
    }

    public void transform(PaySecureState paySecureState) {
        Intrinsics.checkParameterIsNotNull(paySecureState, "state");
        AbsPaySecureBaseActivity absPaySecureBaseActivity = this.f50315a;
        if (absPaySecureBaseActivity != null) {
            absPaySecureBaseActivity.transform(getNowState(), paySecureState, getMessenger());
        }
    }

    /* access modifiers changed from: protected */
    public final void showErrorData(ErrorData errorData, TextView textView, ErrorDialogCallback errorDialogCallback) {
        String style;
        Intrinsics.checkParameterIsNotNull(errorDialogCallback, "callback");
        if (errorData != null && (style = errorData.getStyle()) != null) {
            int hashCode = style.hashCode();
            if (hashCode != -1332085432) {
                if (hashCode != 3202695) {
                    if (hashCode == 110532135 && style.equals(BlocksConst.ACTION_TYPE_TOAST)) {
                        ToastUtil.INSTANCE.showError(getContext(), errorData.getBody());
                    }
                } else if (style.equals(ViewHierarchyConstants.HINT_KEY) && textView != null) {
                    textView.setText(errorData.getBody());
                }
            } else if (style.equals("dialog")) {
                if (textView != null) {
                    UiUtils uiUtils = UiUtils.INSTANCE;
                    Context context = getContext();
                    if (context == null) {
                        Intrinsics.throwNpe();
                    }
                    uiUtils.hideKeyboard(context, textView);
                }
                AbsPaySecureBaseActivity absPaySecureBaseActivity = this.f50315a;
                if (absPaySecureBaseActivity == null) {
                    Intrinsics.throwNpe();
                }
                new ErrorDialog(absPaySecureBaseActivity, errorData, getSourcePageId()).show(errorDialogCallback);
            }
        }
    }

    public final String getAesKey() {
        return this.f50316b;
    }

    public final void setAesKey(String str) {
        this.f50316b = str;
    }

    public final String getIv() {
        return this.f50317c;
    }

    public final void setIv(String str) {
        this.f50317c = str;
    }

    public final String getEncryptedPwdString() {
        return this.f50318d;
    }

    public final void setEncryptedPwdString(String str) {
        this.f50318d = str;
    }

    public final String getEncryptKey() {
        return this.f50319e;
    }

    public final void setEncryptKey(String str) {
        this.f50319e = str;
    }

    /* access modifiers changed from: protected */
    public final void prepareEncrypt(String str, String str2) {
        String str3;
        byte[] bArr;
        Intrinsics.checkParameterIsNotNull(str, "pwd");
        this.f50316b = CipherUtil.INSTANCE.getAESKey();
        this.f50317c = CipherUtil.INSTANCE.getAESIv();
        SecureRandom secureRandom = new SecureRandom();
        if (TextUtils.isEmpty(str2)) {
            str3 = "{\"password\":\"" + str + "\", \"random\":\"" + secureRandom.nextInt() + "\"}";
        } else {
            str3 = "{\"password\":\"" + str + "\", \"random\":\"" + secureRandom.nextInt() + "\", \"old_password\":\"" + str2 + "\"}";
        }
        CipherUtil cipherUtil = CipherUtil.INSTANCE;
        String str4 = this.f50316b;
        if (str4 == null) {
            Intrinsics.throwNpe();
        }
        String str5 = this.f50317c;
        String str6 = null;
        if (str5 != null) {
            Charset charset = Charsets.UTF_8;
            if (str5 != null) {
                bArr = str5.getBytes(charset);
                Intrinsics.checkExpressionValueIsNotNull(bArr, "(this as java.lang.String).getBytes(charset)");
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
        } else {
            bArr = null;
        }
        if (bArr == null) {
            Intrinsics.throwNpe();
        }
        this.f50318d = cipherUtil.aesEncrypt(str3, str4, bArr);
        CipherUtil cipherUtil2 = CipherUtil.INSTANCE;
        String str7 = this.f50316b;
        if (str7 == null) {
            Intrinsics.throwNpe();
        }
        PasswordSettings passwordSettings = getMessenger().getPasswordSettings();
        if (passwordSettings != null) {
            str6 = passwordSettings.getPublicKey();
        }
        if (str6 == null) {
            Intrinsics.throwNpe();
        }
        this.f50319e = cipherUtil2.encryptRSAToString(str7, str6);
    }

    public void showLoading(String str) {
        AbsPaySecureBaseActivity absPaySecureBaseActivity = this.f50315a;
        if (absPaySecureBaseActivity != null) {
            absPaySecureBaseActivity.showLoading(str);
        }
    }

    public void hideLoading() {
        AbsPaySecureBaseActivity absPaySecureBaseActivity = this.f50315a;
        if (absPaySecureBaseActivity != null) {
            absPaySecureBaseActivity.hideLoading();
        }
    }

    public final int getSourcePageId() {
        int sceneType = getMessenger().getSceneType();
        if (sceneType == 0) {
            return 1;
        }
        if (sceneType == 1) {
            return 3;
        }
        if (sceneType != 2) {
            return sceneType != 3 ? 0 : 2;
        }
        return 4;
    }
}
