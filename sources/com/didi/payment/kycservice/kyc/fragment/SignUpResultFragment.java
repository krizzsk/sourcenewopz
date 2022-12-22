package com.didi.payment.kycservice.kyc.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.commoninterfacelib.permission.PermissionUtil;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.commonsdk.p129ui.WBaseFragment;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.commonsdk.utils.NViewUtils;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.kycservice.kyc.ContactPermissionActivity;
import com.didi.payment.kycservice.kyc.SignUpActivity;
import com.didi.payment.kycservice.kyc.SignUpVM;
import com.didi.payment.kycservice.kyc.p133vm.SignUpResultVM;
import com.didi.payment.kycservice.kyc.response.ResultPageData;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u0012\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u0010H\u0016J\u001a\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006'"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/SignUpResultFragment;", "Lcom/didi/payment/commonsdk/ui/WBaseFragment;", "Lcom/didi/payment/kycservice/kyc/vm/SignUpResultVM;", "()V", "btnConfirm", "Landroid/widget/TextView;", "btnContinue", "ivTopArea", "Landroid/widget/ImageView;", "llContentContainer", "Landroid/widget/LinearLayout;", "pixSignUpVM", "Lcom/didi/payment/kycservice/kyc/SignUpVM;", "tvCenterSubTitle", "tvCenterTitle", "addItemView", "", "itemInfo", "Lcom/didi/payment/kycservice/kyc/response/ResultPageData$ItemInfo;", "getTitleBarView", "Landroid/view/View;", "initView", "rootView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onViewCreated", "view", "updateToolbarAndBottomBtn", "resultData", "Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "updateView", "Companion", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SignUpResultFragment.kt */
public final class SignUpResultFragment extends WBaseFragment<SignUpResultVM> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private ImageView f30834a;

    /* renamed from: b */
    private TextView f30835b;

    /* renamed from: c */
    private TextView f30836c;

    /* renamed from: d */
    private LinearLayout f30837d;

    /* renamed from: e */
    private TextView f30838e;

    /* renamed from: f */
    private TextView f30839f;

    /* renamed from: g */
    private SignUpVM f30840g;

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return null;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/SignUpResultFragment$Companion;", "", "()V", "newInstance", "Lcom/didi/payment/kycservice/kyc/fragment/SignUpResultFragment;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SignUpResultFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SignUpResultFragment newInstance() {
            return new SignUpResultFragment();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(SignUpVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir…get(SignUpVM::class.java)");
        this.f30840g = (SignUpVM) viewModel;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_common_sign_up_result, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        m21722a(view);
        if (Intrinsics.areEqual((Object) OmegaComParams.Companion.getPUB_FROM_PAGE(), (Object) OmegaComParams.PIX_KEY_REG)) {
            OmegaComParams.Companion.setPubPage(OmegaComParams.PRE_PIX_KEY);
            KycOmega.Companion.trackEvent("ibt_didipay_registration_result_kyc_pending_cpf_available_sw");
            return;
        }
        OmegaComParams.Companion.setPubPage(OmegaComParams.KYC_RESULET_PEG);
        KycOmega.Companion.trackEvent("fin_kyc_regist_result_sw");
    }

    /* renamed from: a */
    private final void m21722a(View view) {
        View findViewById = view.findViewById(R.id.pix_sign_up_result_iv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.pix_sign_up_result_iv)");
        this.f30834a = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.pix_sign_up_result_center_main_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.…result_center_main_title)");
        this.f30835b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.pix_sign_up_result_center_sub_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.…_result_center_sub_title)");
        this.f30836c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.pix_sign_up_result_content_container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.…result_content_container)");
        this.f30837d = (LinearLayout) findViewById4;
        View findViewById5 = view.findViewById(R.id.pix_sign_up_result_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.pix_sign_up_result_btn)");
        this.f30838e = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.continue_register_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.continue_register_btn)");
        this.f30839f = (TextView) findViewById6;
        SignUpVM signUpVM = this.f30840g;
        if (signUpVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM = null;
        }
        ResultPageData resultPageData = signUpVM.getResultPageData();
        if (resultPageData != null) {
            m21725a(resultPageData);
        }
    }

    /* renamed from: a */
    private final void m21725a(ResultPageData resultPageData) {
        String centerSubTitle;
        ResultPageData.IconInfo richIcon = resultPageData.getRichIcon();
        TextView textView = null;
        if (richIcon != null) {
            ImageView imageView = this.f30834a;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivTopArea");
                imageView = null;
            }
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (richIcon.getSize() == 0 && Intrinsics.areEqual((Object) resultPageData.isPix(), (Object) true)) {
                layoutParams.width = UIUtil.dip2px(getContext(), 120.0f);
                layoutParams.height = UIUtil.dip2px(getContext(), 120.0f);
            } else if (richIcon.getSize() == 0) {
                layoutParams.width = UIUtil.dip2px(getContext(), 180.0f);
                layoutParams.height = UIUtil.dip2px(getContext(), 120.0f);
            } else {
                layoutParams.width = UIUtil.dip2px(getContext(), 375.0f);
                layoutParams.height = UIUtil.dip2px(getContext(), 220.0f);
            }
            ImageView imageView2 = this.f30834a;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivTopArea");
                imageView2 = null;
            }
            imageView2.setLayoutParams(layoutParams);
            Context activity = getActivity();
            String iconUrl = richIcon.getIconUrl();
            ImageView imageView3 = this.f30834a;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivTopArea");
                imageView3 = null;
            }
            GlideUtils.with2load2into(activity, iconUrl, imageView3);
            TextView textView2 = this.f30839f;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnContinue");
                textView2 = null;
            }
            textView2.setVisibility(resultPageData.getExtraButton() == null ? 8 : 0);
            TextView textView3 = this.f30839f;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnContinue");
                textView3 = null;
            }
            ResultPageData.ExtraButton extraButton = resultPageData.getExtraButton();
            textView3.setText(extraButton == null ? null : extraButton.getExtraBtnText());
        }
        NViewUtils nViewUtils = NViewUtils.INSTANCE;
        TextView textView4 = this.f30835b;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvCenterTitle");
            textView4 = null;
        }
        nViewUtils.setText(textView4, resultPageData.getCenterTitle());
        if (!(resultPageData == null || (centerSubTitle = resultPageData.getCenterSubTitle()) == null)) {
            NViewUtils nViewUtils2 = NViewUtils.INSTANCE;
            TextView textView5 = this.f30836c;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvCenterSubTitle");
            } else {
                textView = textView5;
            }
            nViewUtils2.setText2HighLight(textView, centerSubTitle);
        }
        ArrayList<ResultPageData.ItemInfo> entryList = resultPageData.getEntryList();
        if (entryList != null) {
            Iterator<ResultPageData.ItemInfo> it = entryList.iterator();
            while (it.hasNext()) {
                m21724a(it.next());
            }
        }
        m21728b(resultPageData);
    }

    /* renamed from: b */
    private final void m21728b(ResultPageData resultPageData) {
        NViewUtils nViewUtils = NViewUtils.INSTANCE;
        TextView textView = this.f30838e;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
            textView = null;
        }
        nViewUtils.setText(textView, resultPageData.getBtnText());
        int clickAction = resultPageData.getClickAction();
        if (clickAction == EResultPageBtnAction.ACTION_OK.getValue()) {
            TextView textView3 = this.f30838e;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
                textView3 = null;
            }
            textView3.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    SignUpResultFragment.m21723a(SignUpResultFragment.this, view);
                }
            });
        } else if (clickAction == EResultPageBtnAction.ACTION_OK_REQ_CONTACT.getValue()) {
            TextView textView4 = this.f30838e;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
                textView4 = null;
            }
            textView4.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    SignUpResultFragment.m21727b(SignUpResultFragment.this, view);
                }
            });
        } else {
            boolean z = true;
            if (!(clickAction == EResultPageBtnAction.ACTION_TRY_AGAIN.getValue() || clickAction == EResultPageBtnAction.ACTION_CONTINUE.getValue())) {
                z = false;
            }
            if (z) {
                TextView textView5 = this.f30838e;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
                    textView5 = null;
                }
                textView5.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        SignUpResultFragment.m21729c(SignUpResultFragment.this, view);
                    }
                });
            } else {
                TextView textView6 = this.f30838e;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
                    textView6 = null;
                }
                textView6.setVisibility(8);
            }
        }
        TextView textView7 = this.f30839f;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnContinue");
        } else {
            textView2 = textView7;
        }
        textView2.setOnClickListener(new View.OnClickListener(this) {
            public final /* synthetic */ SignUpResultFragment f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                SignUpResultFragment.m21726a(ResultPageData.this, this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21723a(SignUpResultFragment signUpResultFragment, View view) {
        Intrinsics.checkNotNullParameter(signUpResultFragment, "this$0");
        FragmentActivity activity = signUpResultFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
        if (Intrinsics.areEqual((Object) OmegaComParams.Companion.getPUB_PAGE(), (Object) OmegaComParams.PRE_PIX_KEY)) {
            KycOmega.Companion.trackEvent("fin_prepixkeyregistration_ok_ck");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m21727b(SignUpResultFragment signUpResultFragment, View view) {
        Intrinsics.checkNotNullParameter(signUpResultFragment, "this$0");
        if (!PermissionUtil.checkPermissionAllGranted((Context) signUpResultFragment.getActivity(), Permission.READ_CONTACTS)) {
            signUpResultFragment.startActivity(new Intent(signUpResultFragment.getActivity(), ContactPermissionActivity.class));
        }
        FragmentActivity activity = signUpResultFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m21729c(SignUpResultFragment signUpResultFragment, View view) {
        Intrinsics.checkNotNullParameter(signUpResultFragment, "this$0");
        Context context = signUpResultFragment.getContext();
        if (context != null) {
            Intent intent = new Intent(context, SignUpActivity.class);
            SignUpVM signUpVM = signUpResultFragment.f30840g;
            if (signUpVM == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                signUpVM = null;
            }
            intent.putExtra("source", signUpVM.getPageSource()).putExtra(SignUpActivity.PARAM_FROM_RESULT_PAGE, true);
            context.startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21726a(ResultPageData resultPageData, SignUpResultFragment signUpResultFragment, View view) {
        Intrinsics.checkNotNullParameter(resultPageData, "$resultData");
        Intrinsics.checkNotNullParameter(signUpResultFragment, "this$0");
        ResultPageData.ExtraButton extraButton = resultPageData.getExtraButton();
        DRouter.build(extraButton == null ? null : extraButton.getLink()).start(signUpResultFragment.getActivity());
    }

    /* renamed from: a */
    private final void m21724a(ResultPageData.ItemInfo itemInfo) {
        View view;
        LinearLayout linearLayout = null;
        if (itemInfo.getType() == 0) {
            LayoutInflater from = LayoutInflater.from(getActivity());
            LinearLayout linearLayout2 = this.f30837d;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llContentContainer");
                linearLayout2 = null;
            }
            view = from.inflate(R.layout.pix_sign_up_result_item_new, linearLayout2, false);
            TextView textView = (TextView) view.findViewById(R.id.pix_sign_up_result_main_title);
            TextView textView2 = (TextView) view.findViewById(R.id.pix_sign_up_result_sub_title);
            NViewUtils nViewUtils = NViewUtils.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(textView, "tvTitle");
            nViewUtils.setText2HighLight(textView, itemInfo.getTitle());
            NViewUtils nViewUtils2 = NViewUtils.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(textView2, "tvSubTitle");
            nViewUtils2.setText2HighLight(textView2, itemInfo.getDesc());
            NViewUtils.INSTANCE.setText((TextView) view.findViewById(R.id.pix_sign_up_result_ref_title), itemInfo.getReference());
        } else {
            LayoutInflater from2 = LayoutInflater.from(getActivity());
            LinearLayout linearLayout3 = this.f30837d;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llContentContainer");
                linearLayout3 = null;
            }
            view = from2.inflate(R.layout.pix_sign_up_result_item_with_dot_new, linearLayout3, false);
            TextView textView3 = (TextView) view.findViewById(R.id.pix_sign_up_result_title);
            NViewUtils nViewUtils3 = NViewUtils.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(textView3, "tvTitle");
            nViewUtils3.setText2HighLight(textView3, itemInfo.getTitle());
        }
        LinearLayout linearLayout4 = this.f30837d;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llContentContainer");
        } else {
            linearLayout = linearLayout4;
        }
        linearLayout.addView(view);
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (Intrinsics.areEqual((Object) OmegaComParams.Companion.getPUB_PAGE(), (Object) OmegaComParams.PRE_PIX_KEY)) {
            OmegaComParams.Companion.setPUB_FROM_PAGE(OmegaComParams.PRE_PIX_KEY);
        }
    }
}
