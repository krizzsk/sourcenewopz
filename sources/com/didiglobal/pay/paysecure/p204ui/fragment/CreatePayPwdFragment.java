package com.didiglobal.pay.paysecure.p204ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.util.UiThreadHandler;
import com.didiglobal.pay.paysecure.PayPwdResultListener;
import com.didiglobal.pay.paysecure.PaySecure;
import com.didiglobal.pay.paysecure.SetPwdResultListener;
import com.didiglobal.pay.paysecure.base.PaySecureBaseFragment;
import com.didiglobal.pay.paysecure.base.PaySecureState;
import com.didiglobal.pay.paysecure.net.PaySecureRequest;
import com.didiglobal.pay.paysecure.net.pojo.response.PasswordSettings;
import com.didiglobal.pay.paysecure.net.pojo.response.SetPwdResponse;
import com.didiglobal.pay.paysecure.omega.OmegaUtil;
import com.didiglobal.pay.paysecure.omega.OmegaUtilKt;
import com.didiglobal.pay.paysecure.p204ui.view.CommonBottomDialog;
import com.didiglobal.pay.paysecure.p204ui.view.ErrorDialogCallback;
import com.didiglobal.pay.paysecure.p204ui.view.InputPwdView;
import com.didiglobal.pay.paysecure.util.PaySecurePref;
import com.didiglobal.pay.paysecure.util.ToastUtil;
import com.didiglobal.pay.paysecure.util.UiUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.taxis99.R;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0002\u0011\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001cH\u0016J$\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u0017H\u0016J\b\u0010.\u001a\u00020\u0017H\u0016J\b\u0010/\u001a\u00020\u0017H\u0016J\u0010\u00100\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\u0010\u00101\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u00102\u001a\u00020\u0017H\u0002J\b\u00103\u001a\u00020\u0017H\u0002J\b\u00104\u001a\u00020\u0017H\u0002J\b\u00105\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u00066"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/ui/fragment/CreatePayPwdFragment;", "Lcom/didiglobal/pay/paysecure/base/PaySecureBaseFragment;", "()V", "mChange", "Landroid/widget/TextView;", "mConfirm", "mFirstPwd", "", "mHintView", "mInputPwdView", "Lcom/didiglobal/pay/paysecure/ui/view/InputPwdView;", "mOldPwd", "mRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mSubTitleView", "mTitleView", "setPwdCallback", "com/didiglobal/pay/paysecure/ui/fragment/CreatePayPwdFragment$setPwdCallback$1", "Lcom/didiglobal/pay/paysecure/ui/fragment/CreatePayPwdFragment$setPwdCallback$1;", "verifyPwdCallback", "com/didiglobal/pay/paysecure/ui/fragment/CreatePayPwdFragment$verifyPwdCallback$1", "Lcom/didiglobal/pay/paysecure/ui/fragment/CreatePayPwdFragment$verifyPwdCallback$1;", "backToFirst", "", "callbackSuccess", "data", "Lcom/didiglobal/pay/paysecure/net/pojo/response/SetPwdResponse;", "checkForbidden", "", "pwd", "checkRepeat", "result", "getErrorDialogCallback", "Lcom/didiglobal/pay/paysecure/ui/view/ErrorDialogCallback;", "getNowState", "Lcom/didiglobal/pay/paysecure/base/PaySecureState;", "onBackPressed", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onStart", "onStop", "sendRequest", "sendVerifyRequest", "showConfirmDialog", "transformToFirst", "transformToModify", "transformToRepeat", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.fragment.CreatePayPwdFragment */
/* compiled from: CreatePayPwdFragment.kt */
public final class CreatePayPwdFragment extends PaySecureBaseFragment {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ConstraintLayout f50415a;

    /* renamed from: b */
    private TextView f50416b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TextView f50417c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f50418d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public InputPwdView f50419e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f50420f;

    /* renamed from: g */
    private TextView f50421g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f50422h;

    /* renamed from: i */
    private String f50423i;

    /* renamed from: j */
    private final CreatePayPwdFragment$setPwdCallback$1 f50424j = new CreatePayPwdFragment$setPwdCallback$1(this);

    /* renamed from: k */
    private final CreatePayPwdFragment$verifyPwdCallback$1 f50425k = new CreatePayPwdFragment$verifyPwdCallback$1(this);

    @Metadata(mo175976bv = {1, 0, 3}, mo175979k = 3, mo175980mv = {1, 1, 16})
    /* renamed from: com.didiglobal.pay.paysecure.ui.fragment.CreatePayPwdFragment$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PaySecureState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PaySecureState.STATE_VERIFY_OLD_PWD.ordinal()] = 1;
            $EnumSwitchMapping$0[PaySecureState.STATE_SET_NEW_PWD.ordinal()] = 2;
            int[] iArr2 = new int[PaySecureState.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[PaySecureState.STATE_VERIFY_OLD_PWD.ordinal()] = 1;
            $EnumSwitchMapping$1[PaySecureState.STATE_SET_NEW_PWD.ordinal()] = 2;
            $EnumSwitchMapping$1[PaySecureState.STATE_SET_PWD.ordinal()] = 3;
            $EnumSwitchMapping$1[PaySecureState.STATE_REPEAT_PWD.ordinal()] = 4;
        }
    }

    public static final /* synthetic */ TextView access$getMConfirm$p(CreatePayPwdFragment createPayPwdFragment) {
        TextView textView = createPayPwdFragment.f50420f;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConfirm");
        }
        return textView;
    }

    public static final /* synthetic */ String access$getMFirstPwd$p(CreatePayPwdFragment createPayPwdFragment) {
        String str = createPayPwdFragment.f50422h;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFirstPwd");
        }
        return str;
    }

    public static final /* synthetic */ TextView access$getMHintView$p(CreatePayPwdFragment createPayPwdFragment) {
        TextView textView = createPayPwdFragment.f50418d;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHintView");
        }
        return textView;
    }

    public static final /* synthetic */ InputPwdView access$getMInputPwdView$p(CreatePayPwdFragment createPayPwdFragment) {
        InputPwdView inputPwdView = createPayPwdFragment.f50419e;
        if (inputPwdView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputPwdView");
        }
        return inputPwdView;
    }

    public static final /* synthetic */ ConstraintLayout access$getMRootView$p(CreatePayPwdFragment createPayPwdFragment) {
        ConstraintLayout constraintLayout = createPayPwdFragment.f50415a;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        }
        return constraintLayout;
    }

    public static final /* synthetic */ TextView access$getMSubTitleView$p(CreatePayPwdFragment createPayPwdFragment) {
        TextView textView = createPayPwdFragment.f50417c;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSubTitleView");
        }
        return textView;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        FragmentActivity activity = getActivity();
        if (!(activity == null || (window = activity.getWindow()) == null)) {
            window.setSoftInputMode(16);
        }
        View inflate = layoutInflater.inflate(R.layout.fragment_create_pay_pwd, viewGroup, false);
        if (inflate != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
            this.f50415a = constraintLayout;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            View findViewById = constraintLayout.findViewById(R.id.tv_create_pwd_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "mRootView.findViewById(R.id.tv_create_pwd_title)");
            this.f50416b = (TextView) findViewById;
            ConstraintLayout constraintLayout2 = this.f50415a;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            View findViewById2 = constraintLayout2.findViewById(R.id.tv_create_pwd_sub_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "mRootView.findViewById(R….tv_create_pwd_sub_title)");
            this.f50417c = (TextView) findViewById2;
            ConstraintLayout constraintLayout3 = this.f50415a;
            if (constraintLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            View findViewById3 = constraintLayout3.findViewById(R.id.tv_create_pwd_hint);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "mRootView.findViewById(R.id.tv_create_pwd_hint)");
            this.f50418d = (TextView) findViewById3;
            ConstraintLayout constraintLayout4 = this.f50415a;
            if (constraintLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            View findViewById4 = constraintLayout4.findViewById(R.id.view_input_pwd);
            Intrinsics.checkExpressionValueIsNotNull(findViewById4, "mRootView.findViewById(R.id.view_input_pwd)");
            this.f50419e = (InputPwdView) findViewById4;
            ConstraintLayout constraintLayout5 = this.f50415a;
            if (constraintLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            View findViewById5 = constraintLayout5.findViewById(R.id.btn_create_pwd_confirm);
            if (findViewById5 != null) {
                this.f50420f = (TextView) findViewById5;
                ConstraintLayout constraintLayout6 = this.f50415a;
                if (constraintLayout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                }
                View findViewById6 = constraintLayout6.findViewById(R.id.btn_create_pwd_change);
                Intrinsics.checkExpressionValueIsNotNull(findViewById6, "mRootView.findViewById(R.id.btn_create_pwd_change)");
                this.f50421g = (TextView) findViewById6;
                ConstraintLayout constraintLayout7 = this.f50415a;
                if (constraintLayout7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                }
                constraintLayout7.findViewById(R.id.fl_pay_secure_back).setOnClickListener(new CreatePayPwdFragment$onCreateView$1(this));
                int i = WhenMappings.$EnumSwitchMapping$0[getMState().ordinal()];
                if (i == 1) {
                    OmegaUtil.Companion.trackEvent("ibt_password_original_password_verify_sw");
                    TextView textView = this.f50416b;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
                    }
                    textView.setText(R.string.Finance_latour_Enter_payment_GXiX);
                    TextView textView2 = this.f50417c;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSubTitleView");
                    }
                    textView2.setText(R.string.Finance_latour_4_digits_EdET);
                    TextView textView3 = this.f50421g;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mChange");
                    }
                    textView3.setVisibility(0);
                } else if (i != 2) {
                    OmegaUtil.Companion.trackEvent("ibt_password_setting_password_sw");
                } else {
                    TextView textView4 = this.f50416b;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
                    }
                    textView4.setText(R.string.Finance_latour_Change_the_IwHy);
                    TextView textView5 = this.f50417c;
                    if (textView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSubTitleView");
                    }
                    textView5.setText(R.string.Finance_latour_4_digits_hPZO);
                    new OmegaUtil("ibt_password_change_password_sw").add(OmegaUtilKt.ENTRANCE_PAGE_ID, Integer.valueOf(getSourcePageId())).send();
                }
                Context context = getContext();
                if (context != null) {
                    TextView textView6 = this.f50420f;
                    if (textView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mConfirm");
                    }
                    textView6.setBackground(ContextCompat.getDrawable(context, PaySecure.INSTANCE.getConfig().getTheme().getPositiveBtnBg()));
                    TextView textView7 = this.f50420f;
                    if (textView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mConfirm");
                    }
                    textView7.setTextColor(ContextCompat.getColorStateList(context, PaySecure.INSTANCE.getConfig().getTheme().getPositiveBtnTextColor()));
                    TextView textView8 = this.f50421g;
                    if (textView8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mChange");
                    }
                    textView8.setTextColor(ContextCompat.getColor(context, PaySecure.INSTANCE.getConfig().getTheme().getThemeColor()));
                }
                InputPwdView inputPwdView = this.f50419e;
                if (inputPwdView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInputPwdView");
                }
                inputPwdView.setPwdCount(PaySecurePref.INSTANCE.getPwdCount());
                InputPwdView inputPwdView2 = this.f50419e;
                if (inputPwdView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInputPwdView");
                }
                inputPwdView2.setMResultListener(new CreatePayPwdFragment$onCreateView$3(this));
                TextView textView9 = this.f50420f;
                if (textView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mConfirm");
                }
                textView9.setOnClickListener(new CreatePayPwdFragment$onCreateView$4(this));
                TextView textView10 = this.f50421g;
                if (textView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mChange");
                }
                textView10.setOnClickListener(new CreatePayPwdFragment$onCreateView$5(this));
                InputPwdView inputPwdView3 = this.f50419e;
                if (inputPwdView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInputPwdView");
                }
                inputPwdView3.requestFocus();
                ConstraintLayout constraintLayout8 = this.f50415a;
                if (constraintLayout8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                }
                constraintLayout8.setOnClickListener(new CreatePayPwdFragment$onCreateView$6(this));
                ConstraintLayout constraintLayout9 = this.f50415a;
                if (constraintLayout9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                }
                return constraintLayout9;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m36261a(String str) {
        PasswordSettings passwordSettings = getMessenger().getPasswordSettings();
        String[] strArr = null;
        if ((passwordSettings != null ? passwordSettings.getForbiddenRegular() : null) != null) {
            PasswordSettings passwordSettings2 = getMessenger().getPasswordSettings();
            if (passwordSettings2 != null) {
                strArr = passwordSettings2.getForbiddenRegular();
            }
            if (strArr == null) {
                Intrinsics.throwNpe();
            }
            for (String compile : strArr) {
                if (Pattern.compile(compile).matcher(str).find()) {
                    if (getMessenger().getSceneType() == 1 || getMessenger().getSceneType() == 3) {
                        new OmegaUtil("ibt_password_change_password_easy_sw").add(OmegaUtilKt.ENTRANCE_PAGE_ID, Integer.valueOf(getSourcePageId())).send();
                    } else if (getMessenger().getSceneType() == 0) {
                        new OmegaUtil("ibt_password_setting_password_easy_sw").add(OmegaUtilKt.ENTRANCE_PAGE_ID, Integer.valueOf(getSourcePageId())).send();
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void onStart() {
        super.onStart();
        UiThreadHandler.post(new CreatePayPwdFragment$onStart$1(this));
    }

    public void onStop() {
        UiUtils uiUtils = UiUtils.INSTANCE;
        Context context = getContext();
        ConstraintLayout constraintLayout = this.f50415a;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        }
        uiUtils.hideKeyboard(context, constraintLayout);
        super.onStop();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m36263b(String str) {
        String str2 = this.f50422h;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFirstPwd");
        }
        if (Intrinsics.areEqual((Object) str, (Object) str2)) {
            TextView textView = this.f50420f;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mConfirm");
            }
            textView.setEnabled(true);
            return;
        }
        if (getMessenger().getSceneType() == 1 || getMessenger().getSceneType() == 3) {
            new OmegaUtil("ibt_password_change_password_second_failed_sw").add(OmegaUtilKt.ENTRANCE_PAGE_ID, Integer.valueOf(getSourcePageId())).send();
        } else if (getMessenger().getSceneType() == 0) {
            OmegaUtil.Companion.trackEvent("ibt_password_twice_comfire_failure_sw");
        }
        ToastUtil.INSTANCE.showError(getContext(), (int) R.string.Finance_latour_Password_error_LqWA);
        InputPwdView inputPwdView = this.f50419e;
        if (inputPwdView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputPwdView");
        }
        inputPwdView.showErr();
        UiThreadHandler.postDelayed(new CreatePayPwdFragment$checkRepeat$1(this), 500);
    }

    /* renamed from: a */
    private final void m36259a() {
        this.f50422h = "";
        TextView textView = this.f50416b;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
        }
        textView.setText(R.string.Finance_latour_New_Payment_OfUd);
        InputPwdView inputPwdView = this.f50419e;
        if (inputPwdView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputPwdView");
        }
        inputPwdView.reset();
        setMState(PaySecureState.STATE_SET_PWD);
        TextView textView2 = this.f50420f;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConfirm");
        }
        textView2.setVisibility(4);
        TextView textView3 = this.f50420f;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConfirm");
        }
        textView3.setEnabled(false);
        TextView textView4 = this.f50421g;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChange");
        }
        textView4.setVisibility(8);
        TextView textView5 = this.f50417c;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSubTitleView");
        }
        textView5.setVisibility(0);
        TextView textView6 = this.f50417c;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSubTitleView");
        }
        textView6.setText(R.string.Finance_latour_4_pure_EKki);
        TextView textView7 = this.f50418d;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHintView");
        }
        textView7.setVisibility(4);
        UiThreadHandler.post(new CreatePayPwdFragment$transformToFirst$1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m36262b() {
        this.f50422h = "";
        TextView textView = this.f50416b;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
        }
        textView.setText(R.string.Finance_latour_Change_the_IwHy);
        InputPwdView inputPwdView = this.f50419e;
        if (inputPwdView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputPwdView");
        }
        inputPwdView.reset();
        setMState(PaySecureState.STATE_SET_NEW_PWD);
        TextView textView2 = this.f50420f;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConfirm");
        }
        textView2.setVisibility(4);
        TextView textView3 = this.f50420f;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConfirm");
        }
        textView3.setEnabled(false);
        TextView textView4 = this.f50421g;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChange");
        }
        textView4.setVisibility(8);
        TextView textView5 = this.f50417c;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSubTitleView");
        }
        textView5.setVisibility(0);
        TextView textView6 = this.f50417c;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSubTitleView");
        }
        textView6.setText(R.string.Finance_latour_4_digits_EdET);
        TextView textView7 = this.f50418d;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHintView");
        }
        textView7.setVisibility(4);
        UiThreadHandler.post(new CreatePayPwdFragment$transformToModify$1(this));
        new OmegaUtil("ibt_password_change_password_sw").add(OmegaUtilKt.ENTRANCE_PAGE_ID, Integer.valueOf(getSourcePageId())).send();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m36264c() {
        TextView textView = this.f50416b;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
        }
        textView.setText(R.string.Finance_latour_Enter_the_tlwv);
        InputPwdView inputPwdView = this.f50419e;
        if (inputPwdView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputPwdView");
        }
        inputPwdView.reset();
        setMState(PaySecureState.STATE_REPEAT_PWD);
        TextView textView2 = this.f50420f;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConfirm");
        }
        textView2.setVisibility(0);
        TextView textView3 = this.f50420f;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConfirm");
        }
        textView3.setEnabled(false);
        TextView textView4 = this.f50418d;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHintView");
        }
        textView4.setVisibility(4);
        TextView textView5 = this.f50417c;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSubTitleView");
        }
        textView5.setVisibility(0);
        if (getMessenger().getSceneType() == 1) {
            TextView textView6 = this.f50417c;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSubTitleView");
            }
            textView6.setText(R.string.Finance_latour_4_digits_Jrkg);
            return;
        }
        TextView textView7 = this.f50417c;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSubTitleView");
        }
        textView7.setText(R.string.Finance_latour_4_pure_FEXQ);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m36265c(String str) {
        prepareEncrypt(str, this.f50423i);
        JsonElement parse = new JsonParser().parse(getMessenger().getUserVerificationParamsRaw());
        Intrinsics.checkExpressionValueIsNotNull(parse, "jsonParser.parse(getMess…serVerificationParamsRaw)");
        JsonObject asJsonObject = parse.getAsJsonObject();
        asJsonObject.remove("check_type");
        asJsonObject.addProperty("check_type", getMessenger().getSelectedCheckType());
        UiUtils uiUtils = UiUtils.INSTANCE;
        Context context = getContext();
        InputPwdView inputPwdView = this.f50419e;
        if (inputPwdView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputPwdView");
        }
        uiUtils.hideKeyboard(context, inputPwdView);
        String str2 = null;
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
        Intrinsics.checkExpressionValueIsNotNull(asJsonObject, "userVerificationParams");
        String iv = getIv();
        if (iv == null) {
            Intrinsics.throwNpe();
        }
        paySecureRequest.setPwd(scene, encryptKey, str3, encryptedPwdString, asJsonObject, iv, this.f50424j);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m36260a(SetPwdResponse setPwdResponse) {
        PayPwdResultListener pwdResultListener;
        if (PaySecure.INSTANCE.getSetPwdResultListener() != null && getMessenger().getSceneType() != 3) {
            SetPwdResultListener setPwdResultListener = PaySecure.INSTANCE.getSetPwdResultListener();
            if (setPwdResultListener != null) {
                String token = setPwdResponse.getToken();
                if (token == null) {
                    Intrinsics.throwNpe();
                }
                setPwdResultListener.onSuccess(token);
            }
        } else if (PaySecure.INSTANCE.getPwdResultListener() != null && (pwdResultListener = PaySecure.INSTANCE.getPwdResultListener()) != null) {
            String token2 = setPwdResponse.getToken();
            if (token2 == null) {
                Intrinsics.throwNpe();
            }
            pwdResultListener.onSuccess(token2);
        }
    }

    public PaySecureState getNowState() {
        return getMState();
    }

    public boolean onBackPressed() {
        if (getMState() == PaySecureState.STATE_REPEAT_PWD) {
            m36266d();
            return true;
        }
        m36268e();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final void m36266d() {
        if (getMessenger().getSceneType() == 0) {
            m36259a();
        } else if (getMessenger().getSceneType() == 1 || getMessenger().getSceneType() == 3) {
            m36262b();
        }
    }

    public final ErrorDialogCallback getErrorDialogCallback() {
        return new CreatePayPwdFragment$getErrorDialogCallback$1(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final void m36267d(String str) {
        this.f50423i = str;
        String str2 = null;
        prepareEncrypt(str, (String) null);
        UiUtils uiUtils = UiUtils.INSTANCE;
        Context context = getContext();
        ConstraintLayout constraintLayout = this.f50415a;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        }
        uiUtils.hideKeyboard(context, constraintLayout);
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
        String iv = getIv();
        if (iv == null) {
            Intrinsics.throwNpe();
        }
        paySecureRequest.verifyPwd(scene, encryptKey, str3, encryptedPwdString, paySessionId, iv, this.f50425k);
    }

    /* renamed from: e */
    private final void m36268e() {
        new CommonBottomDialog(getBaseActivity(), (String) null, (String) null, 6, (DefaultConstructorMarker) null).show(new CreatePayPwdFragment$showConfirmDialog$1(this));
        new OmegaUtil("ibt_password_give_up_sw").add(OmegaUtilKt.ENTRANCE_PAGE_ID, Integer.valueOf(getSourcePageId())).send();
    }

    public void onPause() {
        UiUtils uiUtils = UiUtils.INSTANCE;
        Context context = getContext();
        ConstraintLayout constraintLayout = this.f50415a;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        }
        uiUtils.hideKeyboard(context, constraintLayout);
        super.onPause();
    }
}
