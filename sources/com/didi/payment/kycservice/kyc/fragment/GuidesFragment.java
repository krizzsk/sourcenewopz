package com.didi.payment.kycservice.kyc.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.commonsdk.p129ui.WBaseFragment;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.commonsdk.utils.NViewUtils;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.kycservice.guide.rule.GuidsRuleManager;
import com.didi.payment.kycservice.guide.rule.IKycGuidesRule;
import com.didi.payment.kycservice.kyc.SignUpPageScene;
import com.didi.payment.kycservice.kyc.SignUpVM;
import com.didi.payment.kycservice.kyc.p133vm.SignUpGuideVM;
import com.didi.payment.kycservice.kyc.response.GuidesInfoResp;
import com.didiglobal.font.DIDIFontUtils;
import com.didiglobal.font.DiDiTypeface;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0015H\u0002J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\u001a\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0016\u0010%\u001a\u00020\u00172\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0002J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000¨\u0006-"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/GuidesFragment;", "Lcom/didi/payment/commonsdk/ui/WBaseFragment;", "Lcom/didi/payment/kycservice/kyc/vm/SignUpGuideVM;", "()V", "bizData", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$Data;", "mBtnSignUp", "Landroid/widget/TextView;", "mContainerLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mLlContainer", "Landroid/widget/LinearLayout;", "mTopImage", "Landroid/widget/ImageView;", "mTvMainTitle", "mTvSubTitle", "pageSource", "", "pixSignUpVM", "Lcom/didi/payment/kycservice/kyc/SignUpVM;", "getTitleBarView", "Landroid/view/View;", "initListener", "", "initView", "rootView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onViewCreated", "view", "updateSignUpStepAreaUI", "items", "Ljava/util/ArrayList;", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$TipsInfo;", "updateTitleAreaUI", "guideData", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$GuideData;", "Companion", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GuidesFragment.kt */
public final class GuidesFragment extends WBaseFragment<SignUpGuideVM> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private ImageView f30792a;

    /* renamed from: b */
    private TextView f30793b;

    /* renamed from: c */
    private TextView f30794c;

    /* renamed from: d */
    private TextView f30795d;

    /* renamed from: e */
    private LinearLayout f30796e;

    /* renamed from: f */
    private ConstraintLayout f30797f;

    /* renamed from: g */
    private GuidesInfoResp.Data f30798g;

    /* renamed from: h */
    private String f30799h = "";

    /* renamed from: i */
    private SignUpVM f30800i;

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return null;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/GuidesFragment$Companion;", "", "()V", "newInstance", "Lcom/didi/payment/kycservice/kyc/fragment/GuidesFragment;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GuidesFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GuidesFragment newInstance() {
            Bundle bundle = new Bundle();
            GuidesFragment guidesFragment = new GuidesFragment();
            guidesFragment.setArguments(bundle);
            return guidesFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragement_guides_layout, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(SignUpVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir…get(SignUpVM::class.java)");
        SignUpVM signUpVM = (SignUpVM) viewModel;
        this.f30800i = signUpVM;
        SignUpVM signUpVM2 = null;
        if (signUpVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM = null;
        }
        this.f30798g = signUpVM.getPixSignUpInfoData();
        SignUpVM signUpVM3 = this.f30800i;
        if (signUpVM3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
        } else {
            signUpVM2 = signUpVM3;
        }
        this.f30799h = signUpVM2.getPageSource();
        OmegaComParams.Companion.setPubPage(OmegaComParams.KYC_GUIDE);
        m21669a(view);
        m21668a();
    }

    public void onDestroyView() {
        super.onDestroyView();
        OmegaComParams.Companion.setPUB_FROM_PAGE(OmegaComParams.KYC_GUIDE);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* renamed from: a */
    private final void m21669a(View view) {
        GuidesInfoResp.GuideData guideData;
        KycOmega.Companion.trackEvent("fin_kycguide_sw");
        View findViewById = view.findViewById(R.id.pix_sign_up_guide_intro_bg_iv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.…ign_up_guide_intro_bg_iv)");
        this.f30792a = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.pix_sign_up_guide_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.….pix_sign_up_guide_title)");
        this.f30793b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.pix_sign_up_guide_sub_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.…_sign_up_guide_sub_title)");
        this.f30794c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.pix_sign_up_guide_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.pix_sign_up_guide_btn)");
        this.f30795d = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.pix_sign_up_guide_ll_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.…gn_up_guide_ll_container)");
        this.f30796e = (LinearLayout) findViewById5;
        View findViewById6 = view.findViewById(R.id.container_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.container_layout)");
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById6;
        this.f30797f = constraintLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainerLayout");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(0);
        GuidesInfoResp.Data data = this.f30798g;
        if (data != null && (guideData = data.getGuideData()) != null) {
            m21671a(guideData);
        }
    }

    /* renamed from: a */
    private final void m21668a() {
        TextView textView = this.f30795d;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnSignUp");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                GuidesFragment.m21670a(GuidesFragment.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21670a(GuidesFragment guidesFragment, View view) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(guidesFragment, "this$0");
        Map linkedHashMap = new LinkedHashMap();
        TextView textView = guidesFragment.f30795d;
        SignUpVM signUpVM = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnSignUp");
            textView = null;
        }
        linkedHashMap.put("button_name", StringsKt.replace$default(textView.getText().toString(), " ", "_", false, 4, (Object) null));
        KycOmega.Companion.trackEvent("fin_kycguide_button_ck", linkedHashMap);
        SparseArray<IKycGuidesRule> guidesRules = GuidsRuleManager.Companion.getGuidesRules();
        if (guidesRules != null) {
            SignUpVM signUpVM2 = guidesFragment.f30800i;
            if (signUpVM2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                signUpVM2 = null;
            }
            IKycGuidesRule iKycGuidesRule = guidesRules.get(Integer.parseInt(signUpVM2.getPageSource()));
            if (iKycGuidesRule != null) {
                iKycGuidesRule.displayedGuideRule();
            }
        }
        ConstraintLayout constraintLayout = guidesFragment.f30797f;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainerLayout");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(8);
        SignUpVM signUpVM3 = guidesFragment.f30800i;
        if (signUpVM3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM3 = null;
        }
        if (signUpVM3.getResultPageData() != null) {
            SignUpVM signUpVM4 = guidesFragment.f30800i;
            if (signUpVM4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                signUpVM4 = null;
            }
            if (!signUpVM4.getSrcFromResultPage()) {
                SignUpVM signUpVM5 = guidesFragment.f30800i;
                if (signUpVM5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                } else {
                    signUpVM = signUpVM5;
                }
                signUpVM.getPageSceneLD().setValue(SignUpPageScene.RESULT);
                return;
            }
        }
        SignUpVM signUpVM6 = guidesFragment.f30800i;
        if (signUpVM6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
        } else {
            signUpVM = signUpVM6;
        }
        if (signUpVM.updatePageSceneByStepList() && (activity = guidesFragment.getActivity()) != null) {
            activity.finish();
        }
    }

    /* renamed from: a */
    private final void m21671a(GuidesInfoResp.GuideData guideData) {
        TextView textView = this.f30794c;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvSubTitle");
            textView = null;
        }
        CharSequence desc = guideData.getDesc();
        textView.setVisibility(desc == null || desc.length() == 0 ? 8 : 0);
        NViewUtils nViewUtils = NViewUtils.INSTANCE;
        TextView textView3 = this.f30793b;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvMainTitle");
            textView3 = null;
        }
        nViewUtils.setText2HighLight(textView3, guideData.getNoviceTitle());
        NViewUtils nViewUtils2 = NViewUtils.INSTANCE;
        TextView textView4 = this.f30794c;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvSubTitle");
            textView4 = null;
        }
        nViewUtils2.setText2HighLight(textView4, guideData.getDesc());
        String iconUrl = guideData.getIconUrl();
        if (iconUrl != null) {
            ImageView imageView = this.f30792a;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopImage");
                imageView = null;
            }
            imageView.setVisibility(0);
            Context context = getContext();
            ImageView imageView2 = this.f30792a;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopImage");
                imageView2 = null;
            }
            GlideUtils.with2load2into(context, iconUrl, imageView2);
        }
        ArrayList<GuidesInfoResp.TipsInfo> tipsList = guideData.getTipsList();
        if (tipsList != null) {
            m21672a(tipsList);
        }
        TextView textView5 = this.f30795d;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnSignUp");
            textView5 = null;
        }
        textView5.setText(guideData.getRegisterBtn());
        TextView textView6 = this.f30795d;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnSignUp");
        } else {
            textView2 = textView6;
        }
        textView2.setVisibility(0);
    }

    /* renamed from: a */
    private final void m21672a(ArrayList<GuidesInfoResp.TipsInfo> arrayList) {
        int size = arrayList.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                LayoutInflater from = LayoutInflater.from(getContext());
                LinearLayout linearLayout = this.f30796e;
                LinearLayout linearLayout2 = null;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLlContainer");
                    linearLayout = null;
                }
                View inflate = from.inflate(R.layout.kyc_guide_item, linearLayout, false);
                TextView textView = (TextView) inflate.findViewById(R.id.pix_sign_up_guide_item_txt);
                DIDIFontUtils.Companion companion = DIDIFontUtils.Companion;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(textView, "tvItemTitle");
                companion.setTypeface(context, (Object) textView, DiDiTypeface.FONT_MEDIUM);
                GlideUtils.with2load2into(inflate.getContext(), arrayList.get(i).getTipIconUrl(), (ImageView) inflate.findViewById(R.id.pix_sign_up_guide_item_iv));
                NViewUtils.INSTANCE.setText(textView, arrayList.get(i).getContent());
                LinearLayout linearLayout3 = this.f30796e;
                if (linearLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLlContainer");
                } else {
                    linearLayout2 = linearLayout3;
                }
                linearLayout2.addView(inflate);
                if (i2 <= size) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }
}
