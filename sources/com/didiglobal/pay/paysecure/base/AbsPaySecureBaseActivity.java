package com.didiglobal.pay.paysecure.base;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.didi.travel.psnger.model.response.ScarShareChannel;
import com.didiglobal.pay.paysecure.p204ui.view.PaySecureProgressDialog;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\"\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/base/AbsPaySecureBaseActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "currentMessenger", "Lcom/didiglobal/pay/paysecure/base/FragmentMessenger;", "getCurrentMessenger", "()Lcom/didiglobal/pay/paysecure/base/FragmentMessenger;", "setCurrentMessenger", "(Lcom/didiglobal/pay/paysecure/base/FragmentMessenger;)V", "forbidBack", "", "isPopBack", "loadingView", "Landroid/widget/LinearLayout;", "hideLoading", "", "isViewAlive", "onBackPressed", "onCancel", "showLoading", "msg", "", "transform", "fromState", "Lcom/didiglobal/pay/paysecure/base/PaySecureState;", "toState", "messenger", "Companion", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: AbsPaySecureBaseActivity.kt */
public abstract class AbsPaySecureBaseActivity extends FragmentActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_FRAGMENT_MESSENGER = "key_fragment_messenger";

    /* renamed from: a */
    private final boolean f50312a;

    /* renamed from: b */
    private final boolean f50313b;

    /* renamed from: c */
    private final LinearLayout f50314c;
    public FragmentMessenger currentMessenger;

    public void onCancel() {
    }

    public final FragmentMessenger getCurrentMessenger() {
        FragmentMessenger fragmentMessenger = this.currentMessenger;
        if (fragmentMessenger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMessenger");
        }
        return fragmentMessenger;
    }

    public final void setCurrentMessenger(FragmentMessenger fragmentMessenger) {
        Intrinsics.checkParameterIsNotNull(fragmentMessenger, "<set-?>");
        this.currentMessenger = fragmentMessenger;
    }

    public final void transform(PaySecureState paySecureState, PaySecureState paySecureState2, FragmentMessenger fragmentMessenger) {
        Intrinsics.checkParameterIsNotNull(fragmentMessenger, ScarShareChannel.MESSENGER);
        try {
            this.currentMessenger = fragmentMessenger;
            Fragment fragment = PaySecureFragmentManager.INSTANCE.getFragment(paySecureState2);
            if (fragment != null) {
                FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
                Intrinsics.checkExpressionValueIsNotNull(beginTransaction, "supportFragmentManager.beginTransaction()");
                Bundle bundle = new Bundle();
                bundle.putSerializable("key_fragment_messenger", fragmentMessenger);
                bundle.putSerializable("initState", paySecureState2);
                fragment.setArguments(bundle);
                beginTransaction.replace(R.id.fl_pay_secure_root, fragment, fragment.getClass().getName());
                if (paySecureState != null) {
                    Intrinsics.checkExpressionValueIsNotNull(beginTransaction.addToBackStack((String) null), "transaction.addToBackStack(null)");
                } else {
                    getSupportFragmentManager().popBackStackImmediate((String) null, 1);
                }
                beginTransaction.commitAllowingStateLoss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onBackPressed() {
        if (!isFinishing()) {
            Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fl_pay_secure_root);
            if ((!(findFragmentById instanceof PaySecureBaseFragment) || !((PaySecureBaseFragment) findFragmentById).onBackPressed()) && !getSupportFragmentManager().popBackStackImmediate()) {
                onCancel();
                supportFinishAfterTransition();
            }
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/base/AbsPaySecureBaseActivity$Companion;", "", "()V", "KEY_FRAGMENT_MESSENGER", "", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: AbsPaySecureBaseActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void showLoading(String str) {
        if (isViewAlive()) {
            PaySecureProgressDialog paySecureProgressDialog = PaySecureProgressDialog.INSTANCE;
            FragmentActivity fragmentActivity = this;
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.pay_secure_loading_msg);
            }
            paySecureProgressDialog.showDialog(fragmentActivity, str, false);
        }
    }

    public void hideLoading() {
        PaySecureProgressDialog.INSTANCE.dismissProgressDialogFragmentSafely();
    }

    public boolean isViewAlive() {
        return !isFinishing() && !isDestroyed();
    }
}
