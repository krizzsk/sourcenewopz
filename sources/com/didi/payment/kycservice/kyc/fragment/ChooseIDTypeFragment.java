package com.didi.payment.kycservice.kyc.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.payment.base.anti.AccessBlockManager;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.utils.TextHighlightUtil;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.kycservice.kyc.SignUpVM;
import com.didi.payment.kycservice.kyc.p133vm.ChooseIDTypeVM;
import com.didi.payment.kycservice.kyc.response.DoorGodResp;
import com.didi.payment.kycservice.kyc.response.FaceInitInfoResp;
import com.didi.payment.kycservice.kyc.response.FaceResultResp;
import com.didi.payment.kycservice.kyc.response.GuidesInfoResp;
import com.didi.payment.kycservice.kyc.response.PixChooseTypeListResp;
import com.didi.payment.kycservice.utils.KycRegisterUtils;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import com.didi.payment.wallet_ui.dialog.WalletDrawerContent;
import com.didi.safety.god.manager.SafetyGod;
import com.didi.safety.god.manager.SafetyGodConfig;
import com.didi.safety.god.manager.SafetyGodResult;
import com.didi.safety.god.manager.callback.SafetyGodCallBack;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.diface.DiFace;
import com.didichuxing.diface.DiFaceParam;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.omega.sdk.common.utils.JsonUtil;
import com.taxis99.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0002J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\u001a\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J \u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u0002H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006'"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/ChooseIDTypeFragment;", "Lcom/didi/payment/kycservice/kyc/fragment/ChooseTypeBaseFragment;", "Lcom/didi/payment/kycservice/kyc/vm/ChooseIDTypeVM;", "()V", "dlgFailure", "Lcom/didi/payment/wallet_ui/dialog/WalletDialog;", "itemType", "", "pixSignUpVM", "Lcom/didi/payment/kycservice/kyc/SignUpVM;", "decorateData", "", "faceResultResp", "Lcom/didi/payment/kycservice/kyc/response/FaceResultResp;", "doFaceRecognition", "", "data", "Lcom/didi/payment/kycservice/kyc/response/FaceInitInfoResp$Data;", "type", "", "initData", "initDoorGodSdk", "initListener", "isAccessBlockFaceCheck", "onClickFirstBtn", "onClickSecondBtn", "onDestroyView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "openDoorGod", "Lcom/didi/payment/kycservice/kyc/response/DoorGodResp$Data;", "cardArray", "showFailDlg", "subscribeUi", "vm", "Companion", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ChooseIDTypeFragment.kt */
public final class ChooseIDTypeFragment extends ChooseTypeBaseFragment<ChooseIDTypeVM> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: d */
    private static boolean f30752d;

    /* renamed from: a */
    private WalletDialog f30753a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public SignUpVM f30754b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f30755c;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final Context m21613a(Context context) {
        return null;
    }

    public static final /* synthetic */ ChooseIDTypeVM access$getVm(ChooseIDTypeFragment chooseIDTypeFragment) {
        return (ChooseIDTypeVM) chooseIDTypeFragment.getVm();
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/ChooseIDTypeFragment$Companion;", "", "()V", "initSafetyGod", "", "newInstance", "Lcom/didi/payment/kycservice/kyc/fragment/ChooseIDTypeFragment;", "titlePrefix", "", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ChooseIDTypeFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ChooseIDTypeFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "titlePrefix");
            ChooseIDTypeFragment chooseIDTypeFragment = new ChooseIDTypeFragment();
            Bundle bundle = new Bundle();
            bundle.putString(ChooseTypeBaseFragmentKt.PARAM_TITLE_PREFIX, str);
            chooseIDTypeFragment.setArguments(bundle);
            return chooseIDTypeFragment;
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        OmegaComParams.Companion.setPubPage(OmegaComParams.FULL_KYC_VER);
        m21614a();
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(SignUpVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir…get(SignUpVM::class.java)");
        this.f30754b = (SignUpVM) viewModel;
        ViewModel viewModel2 = new ViewModelProvider(this).get(ChooseIDTypeVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(this).…ooseIDTypeVM::class.java)");
        setVm((WBaseViewModel) viewModel2);
        subscribeUi((ChooseIDTypeVM) getVm());
        KycOmega.Companion.ibt_didipay_verification_sw(Boolean.valueOf(m21631d()));
        m21626b();
    }

    public void onDestroyView() {
        super.onDestroyView();
        OmegaComParams.Companion.setPUB_FROM_PAGE(OmegaComParams.FULL_KYC_VER);
    }

    public void subscribeUi(ChooseIDTypeVM chooseIDTypeVM) {
        Intrinsics.checkNotNullParameter(chooseIDTypeVM, "vm");
        chooseIDTypeVM.isLoading().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                ChooseIDTypeFragment.m21620a(ChooseIDTypeFragment.this, (Boolean) obj);
            }
        });
        chooseIDTypeVM.isNetError().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                ChooseIDTypeFragment.m21627b(ChooseIDTypeFragment.this, (Boolean) obj);
            }
        });
        if (!m21631d()) {
            chooseIDTypeVM.getBizLD().observe(getViewLifecycleOwner(), new Observer() {
                public final void onChanged(Object obj) {
                    ChooseIDTypeFragment.m21616a(ChooseIDTypeFragment.this, (PixChooseTypeListResp.Data) obj);
                }
            });
        }
        chooseIDTypeVM.getDoorGodInitLD().observe(getViewLifecycleOwner(), new Observer(chooseIDTypeVM) {
            public final /* synthetic */ ChooseIDTypeVM f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                ChooseIDTypeFragment.m21617a(ChooseIDTypeFragment.this, this.f$1, (DoorGodResp.Data) obj);
            }
        });
        chooseIDTypeVM.getFaceInitLD().observe(getViewLifecycleOwner(), new Observer(chooseIDTypeVM) {
            public final /* synthetic */ ChooseIDTypeVM f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                ChooseIDTypeFragment.m21618a(ChooseIDTypeFragment.this, this.f$1, (FaceInitInfoResp.Data) obj);
            }
        });
        chooseIDTypeVM.getFaceResultLD().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                ChooseIDTypeFragment.m21615a(ChooseIDTypeFragment.this, (FaceResultResp) obj);
            }
        });
        chooseIDTypeVM.getShowResultPageLD().observe(getViewLifecycleOwner(), new Observer(chooseIDTypeVM) {
            public final /* synthetic */ ChooseIDTypeVM f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                ChooseIDTypeFragment.m21619a(ChooseIDTypeFragment.this, this.f$1, (Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21620a(ChooseIDTypeFragment chooseIDTypeFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(chooseIDTypeFragment, "this$0");
        SignUpVM signUpVM = chooseIDTypeFragment.f30754b;
        if (signUpVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM = null;
        }
        signUpVM.isLoading().setValue(bool);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m21627b(ChooseIDTypeFragment chooseIDTypeFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(chooseIDTypeFragment, "this$0");
        ViewGroup errViewContainer = chooseIDTypeFragment.getErrViewContainer();
        if (errViewContainer != null) {
            Intrinsics.checkNotNullExpressionValue(bool, "isNetError");
            errViewContainer.setVisibility((!bool.booleanValue() || chooseIDTypeFragment.customErrorUI()) ? 8 : 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21616a(ChooseIDTypeFragment chooseIDTypeFragment, PixChooseTypeListResp.Data data) {
        Intrinsics.checkNotNullParameter(chooseIDTypeFragment, "this$0");
        chooseIDTypeFragment.getTvMainTitle().setText(TextHighlightUtil.highlight(Intrinsics.stringPlus(chooseIDTypeFragment.getTitlePrefix(), data.getTitle()), Color.parseColor("#000000"), Color.parseColor("#FF8040")));
        CharSequence subTitle = data.getSubTitle();
        if (subTitle == null || subTitle.length() == 0) {
            chooseIDTypeFragment.getTvSubTitle().setVisibility(8);
        } else {
            chooseIDTypeFragment.getTvSubTitle().setVisibility(0);
            chooseIDTypeFragment.getTvSubTitle().setText(TextHighlightUtil.highlight(data.getSubTitle(), Color.parseColor("#666666"), Color.parseColor("#FF8040")));
        }
        chooseIDTypeFragment.getRvAdapter().setData(data.getKeyList());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21617a(ChooseIDTypeFragment chooseIDTypeFragment, ChooseIDTypeVM chooseIDTypeVM, DoorGodResp.Data data) {
        Intrinsics.checkNotNullParameter(chooseIDTypeFragment, "this$0");
        Intrinsics.checkNotNullParameter(chooseIDTypeVM, "$vm");
        if (!f30752d) {
            chooseIDTypeFragment.m21629c();
            f30752d = true;
        }
        int verifyFaceType = chooseIDTypeVM.getVerifyFaceType();
        String str = ChooseIDTypeVM.TYPE_RG;
        String str2 = ChooseIDTypeVM.CARD_ARRAY_RG;
        if (verifyFaceType == 2001) {
            str2 = ChooseIDTypeVM.CARD_ARRAY_CNH;
            str = ChooseIDTypeVM.TYPE_CNH;
        }
        Intrinsics.checkNotNullExpressionValue(data, "data");
        chooseIDTypeFragment.m21623a(data, str2, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21618a(ChooseIDTypeFragment chooseIDTypeFragment, ChooseIDTypeVM chooseIDTypeVM, FaceInitInfoResp.Data data) {
        Intrinsics.checkNotNullParameter(chooseIDTypeFragment, "this$0");
        Intrinsics.checkNotNullParameter(chooseIDTypeVM, "$vm");
        Intrinsics.checkNotNullExpressionValue(data, "it");
        int verifyFaceType = chooseIDTypeVM.getVerifyFaceType();
        chooseIDTypeFragment.m21624a(data, verifyFaceType != 2001 ? verifyFaceType != 2002 ? "" : ChooseIDTypeVM.TYPE_RG : ChooseIDTypeVM.TYPE_CNH);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21615a(ChooseIDTypeFragment chooseIDTypeFragment, FaceResultResp faceResultResp) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(chooseIDTypeFragment, "this$0");
        if (faceResultResp.errno == 0) {
            if (chooseIDTypeFragment.m21631d()) {
                FragmentActivity activity2 = chooseIDTypeFragment.getActivity();
                if (activity2 != null) {
                    activity2.finish();
                    return;
                }
                return;
            }
            SignUpVM signUpVM = chooseIDTypeFragment.f30754b;
            if (signUpVM == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                signUpVM = null;
            }
            if (signUpVM.updatePageSceneByStepList() && (activity = chooseIDTypeFragment.getActivity()) != null) {
                activity.finish();
            }
        } else if (chooseIDTypeFragment.m21631d()) {
            Context context = chooseIDTypeFragment.getContext();
            if (context != null) {
                WalletToastNew.showFailedMsg(context, faceResultResp.errmsg);
            }
            FragmentActivity activity3 = chooseIDTypeFragment.getActivity();
            if (activity3 != null) {
                activity3.finish();
            }
        } else {
            Intrinsics.checkNotNullExpressionValue(faceResultResp, "it");
            chooseIDTypeFragment.m21625a(faceResultResp);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21619a(ChooseIDTypeFragment chooseIDTypeFragment, ChooseIDTypeVM chooseIDTypeVM, Boolean bool) {
        Intrinsics.checkNotNullParameter(chooseIDTypeFragment, "this$0");
        Intrinsics.checkNotNullParameter(chooseIDTypeVM, "$vm");
        KycRegisterUtils.INSTANCE.go2PixSignUpResultPage(chooseIDTypeFragment.getActivity(), chooseIDTypeVM.getResultPageData());
    }

    /* renamed from: a */
    private final void m21614a() {
        getRvAdapter().setOnItemClickListener(new ChooseIDTypeFragment$initListener$1(this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001d, code lost:
        r0 = r0.getIntent();
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m21626b() {
        /*
            r8 = this;
            com.didi.payment.kycservice.kyc.SignUpVM r0 = r8.f30754b
            java.lang.String r1 = "pixSignUpVM"
            r2 = 0
            if (r0 != 0) goto L_0x000b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x000b:
            java.lang.String r0 = r0.getPageSource()
            java.lang.String r3 = "4"
            kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            androidx.fragment.app.FragmentActivity r0 = r8.getActivity()
            r3 = 0
            if (r0 != 0) goto L_0x001d
        L_0x001b:
            r0 = r2
            goto L_0x002e
        L_0x001d:
            android.content.Intent r0 = r0.getIntent()
            if (r0 != 0) goto L_0x0024
            goto L_0x001b
        L_0x0024:
            java.lang.String r4 = "param_access_block"
            boolean r0 = r0.getBooleanExtra(r4, r3)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
        L_0x002e:
            r4 = 2001(0x7d1, float:2.804E-42)
            if (r0 != 0) goto L_0x0034
            goto L_0x00c4
        L_0x0034:
            boolean r5 = r0.booleanValue()
            com.didi.payment.commonsdk.ui.WBaseViewModel r6 = r8.getVm()
            com.didi.payment.kycservice.kyc.vm.ChooseIDTypeVM r6 = (com.didi.payment.kycservice.kyc.p133vm.ChooseIDTypeVM) r6
            r6.setFaceScene(r5)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00c4
            androidx.fragment.app.FragmentActivity r0 = r8.getActivity()
            if (r0 != 0) goto L_0x004f
        L_0x004d:
            r0 = r2
            goto L_0x0060
        L_0x004f:
            android.content.Intent r0 = r0.getIntent()
            if (r0 != 0) goto L_0x0056
            goto L_0x004d
        L_0x0056:
            java.lang.String r5 = "param_access_block_code"
            int r0 = r0.getIntExtra(r5, r3)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L_0x0060:
            r5 = 10010(0x271a, float:1.4027E-41)
            java.lang.String r6 = "param_source"
            if (r0 != 0) goto L_0x0067
            goto L_0x0092
        L_0x0067:
            int r7 = r0.intValue()
            if (r7 != r5) goto L_0x0092
            com.didi.payment.commonsdk.ui.WBaseViewModel r0 = r8.getVm()
            com.didi.payment.kycservice.kyc.vm.ChooseIDTypeVM r0 = (com.didi.payment.kycservice.kyc.p133vm.ChooseIDTypeVM) r0
            androidx.fragment.app.FragmentActivity r1 = r8.getActivity()
            if (r1 != 0) goto L_0x007a
            goto L_0x0085
        L_0x007a:
            android.content.Intent r1 = r1.getIntent()
            if (r1 != 0) goto L_0x0081
            goto L_0x0085
        L_0x0081:
            int r3 = r1.getIntExtra(r6, r3)
        L_0x0085:
            r0.setSource(r3)
            com.didi.payment.commonsdk.ui.WBaseViewModel r0 = r8.getVm()
            com.didi.payment.kycservice.kyc.vm.ChooseIDTypeVM r0 = (com.didi.payment.kycservice.kyc.p133vm.ChooseIDTypeVM) r0
            r0.reqFaceInitInfo(r4)
            return
        L_0x0092:
            r5 = 10011(0x271b, float:1.4028E-41)
            if (r0 != 0) goto L_0x0097
            goto L_0x00c4
        L_0x0097:
            int r0 = r0.intValue()
            if (r0 != r5) goto L_0x00c4
            com.didi.payment.commonsdk.ui.WBaseViewModel r0 = r8.getVm()
            com.didi.payment.kycservice.kyc.vm.ChooseIDTypeVM r0 = (com.didi.payment.kycservice.kyc.p133vm.ChooseIDTypeVM) r0
            androidx.fragment.app.FragmentActivity r1 = r8.getActivity()
            if (r1 != 0) goto L_0x00aa
            goto L_0x00b5
        L_0x00aa:
            android.content.Intent r1 = r1.getIntent()
            if (r1 != 0) goto L_0x00b1
            goto L_0x00b5
        L_0x00b1:
            int r3 = r1.getIntExtra(r6, r3)
        L_0x00b5:
            r0.setSource(r3)
            com.didi.payment.commonsdk.ui.WBaseViewModel r0 = r8.getVm()
            com.didi.payment.kycservice.kyc.vm.ChooseIDTypeVM r0 = (com.didi.payment.kycservice.kyc.p133vm.ChooseIDTypeVM) r0
            r1 = 2002(0x7d2, float:2.805E-42)
            r0.reqFaceInitInfo(r1)
            return
        L_0x00c4:
            com.didi.payment.kycservice.kyc.SignUpVM r0 = r8.f30754b
            if (r0 != 0) goto L_0x00cc
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x00cc:
            com.didi.payment.kycservice.kyc.response.GuidesInfoResp$Data r0 = r0.getPixSignUpInfoData()
            r5 = 1
            if (r0 != 0) goto L_0x00d5
        L_0x00d3:
            r0 = 0
            goto L_0x00dc
        L_0x00d5:
            boolean r0 = r0.getNeedDoorGod()
            if (r0 != 0) goto L_0x00d3
            r0 = 1
        L_0x00dc:
            r6 = 101(0x65, float:1.42E-43)
            if (r0 == 0) goto L_0x00fb
            com.didi.payment.commonsdk.ui.WBaseViewModel r0 = r8.getVm()
            com.didi.payment.kycservice.kyc.vm.ChooseIDTypeVM r0 = (com.didi.payment.kycservice.kyc.p133vm.ChooseIDTypeVM) r0
            r0.setFaceScene(r3)
            com.didi.payment.commonsdk.ui.WBaseViewModel r0 = r8.getVm()
            com.didi.payment.kycservice.kyc.vm.ChooseIDTypeVM r0 = (com.didi.payment.kycservice.kyc.p133vm.ChooseIDTypeVM) r0
            r0.setSource(r6)
            com.didi.payment.commonsdk.ui.WBaseViewModel r0 = r8.getVm()
            com.didi.payment.kycservice.kyc.vm.ChooseIDTypeVM r0 = (com.didi.payment.kycservice.kyc.p133vm.ChooseIDTypeVM) r0
            r0.reqFaceInitInfo(r4)
        L_0x00fb:
            com.didi.payment.kycservice.kyc.SignUpVM r0 = r8.f30754b
            if (r0 != 0) goto L_0x0103
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0103:
            com.didi.payment.kycservice.kyc.response.GuidesInfoResp$Data r0 = r0.getPixSignUpInfoData()
            if (r0 != 0) goto L_0x010a
            goto L_0x0111
        L_0x010a:
            boolean r0 = r0.getNeedSkipPage()
            if (r0 != r5) goto L_0x0111
            r3 = 1
        L_0x0111:
            if (r3 == 0) goto L_0x0147
            com.didi.payment.commonsdk.ui.WBaseViewModel r0 = r8.getVm()
            com.didi.payment.kycservice.kyc.vm.ChooseIDTypeVM r0 = (com.didi.payment.kycservice.kyc.p133vm.ChooseIDTypeVM) r0
            r0.setSource(r6)
            com.didi.payment.commonsdk.ui.WBaseViewModel r0 = r8.getVm()
            com.didi.payment.kycservice.kyc.vm.ChooseIDTypeVM r0 = (com.didi.payment.kycservice.kyc.p133vm.ChooseIDTypeVM) r0
            r0.setVerifyFaceType(r4)
            com.didi.payment.commonsdk.ui.WBaseViewModel r0 = r8.getVm()
            com.didi.payment.kycservice.kyc.vm.ChooseIDTypeVM r0 = (com.didi.payment.kycservice.kyc.p133vm.ChooseIDTypeVM) r0
            com.didi.payment.kycservice.kyc.SignUpVM r3 = r8.f30754b
            if (r3 != 0) goto L_0x0133
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r3 = r2
        L_0x0133:
            java.lang.String r3 = r3.getPageSource()
            com.didi.payment.kycservice.kyc.SignUpVM r5 = r8.f30754b
            if (r5 != 0) goto L_0x013f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x0140
        L_0x013f:
            r2 = r5
        L_0x0140:
            int r1 = r2.getFromPrimary()
            r0.reqDoorGodInitInfo(r4, r3, r1)
        L_0x0147:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.kycservice.kyc.fragment.ChooseIDTypeFragment.m21626b():void");
    }

    /* renamed from: a */
    private final void m21624a(FaceInitInfoResp.Data data, String str) {
        DiFaceParam diFaceParam = new DiFaceParam();
        String bizCode = data.getBizCode();
        Intrinsics.checkNotNull(bizCode);
        diFaceParam.setBizCode(Integer.parseInt(bizCode));
        diFaceParam.setToken(PayBaseParamUtil.getStringParam(getActivity(), "token"));
        diFaceParam.setSessionId(data.getSessionId());
        DiFace.startFaceRecognition(diFaceParam, new DiFace.IDiFaceCallback(str) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onResult(DiFaceResult diFaceResult) {
                ChooseIDTypeFragment.m21622a(ChooseIDTypeFragment.this, this.f$1, diFaceResult);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21622a(ChooseIDTypeFragment chooseIDTypeFragment, String str, DiFaceResult diFaceResult) {
        FragmentActivity activity;
        Intent intent;
        Intrinsics.checkNotNullParameter(chooseIDTypeFragment, "this$0");
        Intrinsics.checkNotNullParameter(str, "$type");
        int i = 1;
        if (diFaceResult.getCode() != 102) {
            FragmentActivity activity2 = chooseIDTypeFragment.getActivity();
            if (activity2 == null || (intent = activity2.getIntent()) == null || !intent.getBooleanExtra(AccessBlockManager.PARAM_ACCESS_BLOCK, false)) {
                i = 0;
            }
            ((ChooseIDTypeVM) chooseIDTypeFragment.getVm()).reqFaceResult(i);
        } else if (chooseIDTypeFragment.m21631d()) {
            FragmentActivity activity3 = chooseIDTypeFragment.getActivity();
            if (activity3 != null) {
                activity3.finish();
            }
        } else if (diFaceResult.getCode() == 102) {
            SignUpVM signUpVM = chooseIDTypeFragment.f30754b;
            if (signUpVM == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                signUpVM = null;
            }
            GuidesInfoResp.Data pixSignUpInfoData = signUpVM.getPixSignUpInfoData();
            if (pixSignUpInfoData == null || pixSignUpInfoData.getNeedDoorGod()) {
                i = 0;
            }
            if (!(i == 0 || (activity = chooseIDTypeFragment.getActivity()) == null)) {
                activity.finish();
            }
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("verify_type", str);
            String map2Json = JsonUtil.map2Json(diFaceResult.data);
            Intrinsics.checkNotNullExpressionValue(map2Json, "map2Json(result.data as Map<String, Any>?)");
            hashMap.put("callback", map2Json);
            FinOmegaSDK.trackEvent("ibt_wallet_verification_face_sdk_ex", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private final void m21623a(DoorGodResp.Data data, String str, String str2) {
        SafetyGodConfig.Builder builder = new SafetyGodConfig.Builder();
        String bizCode = data.getBizCode();
        Intrinsics.checkNotNull(bizCode);
        SafetyGodConfig builder2 = builder.setBizCode(Integer.parseInt(bizCode)).setToken(PayBaseParamUtil.getStringParam(getActivity(), "token")).setKeeperId(data.getKeeperId()).setCardArray(str).setNation("BR").setLanguage((String) WalletCommonParamsUtil.getCommonParam(getContext(), "lang")).setActivityDelegate($$Lambda$ChooseIDTypeFragment$QO69PhWZShlL9hjF7iDCjiJHTeY.INSTANCE).builder();
        Intrinsics.checkNotNullExpressionValue(builder2, "Builder()\n            .s… }\n            .builder()");
        Context context = getContext();
        if (context != null) {
            SafetyGod.launch(context, builder2, new SafetyGodCallBack(str2) {
                public final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void onCallBack(SafetyGodResult safetyGodResult) {
                    ChooseIDTypeFragment.m21621a(ChooseIDTypeFragment.this, this.f$1, safetyGodResult);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21621a(ChooseIDTypeFragment chooseIDTypeFragment, String str, SafetyGodResult safetyGodResult) {
        Intrinsics.checkNotNullParameter(chooseIDTypeFragment, "this$0");
        Intrinsics.checkNotNullParameter(str, "$type");
        if (safetyGodResult.getCode() == 100000) {
            ((ChooseIDTypeVM) chooseIDTypeFragment.getVm()).reqDoorGodResult();
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("verify_type", str);
            String map2Json = JsonUtil.map2Json(safetyGodResult.getLastConfig());
            Intrinsics.checkNotNullExpressionValue(map2Json, "map2Json(it.lastConfig as Map<String, Any>?)");
            hashMap.put("callback", map2Json);
            FinOmegaSDK.trackEvent("ibt_wallet_verification_orc_sdk_ex", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private final void m21629c() {
        SafetyGod.init(getActivity(), new ChooseIDTypeFragment$initDoorGodSdk$1(this));
        SafetyGod.setClientAppFunction(new ChooseIDTypeFragment$initDoorGodSdk$2(this));
    }

    /* renamed from: a */
    private final void m21625a(FaceResultResp faceResultResp) {
        if (faceResultResp.getData() != null) {
            m21632d(faceResultResp);
            FaceResultResp.Data data = faceResultResp.getData();
            Intrinsics.checkNotNull(data);
            int i = this.f30755c;
            if (i == 2002) {
                KycOmega.Companion.trackEvent("fin_fullkycverification_rgpopup_sw");
            } else if (i == 2001) {
                KycOmega.Companion.trackEvent("fin_fullkycverification_cnhpopup_sw");
            }
            Context context = getContext();
            if (context != null) {
                WalletDialog.Companion companion = WalletDialog.Companion;
                WalletDrawerContent.Builder builder = new WalletDrawerContent.Builder();
                String title = data.getTitle();
                Intrinsics.checkNotNull(title);
                builder.setTitle(title);
                builder.setContent(data.getSubTitle());
                builder.setFirstBtnText(data.getFirstButtonText());
                builder.setFirstClickListener(new ChooseIDTypeFragment$showFailDlg$1$1$1(this, faceResultResp, data));
                builder.setSecondBtnText(data.getSecondButtonText());
                builder.setSecondClickListener(new ChooseIDTypeFragment$showFailDlg$1$1$2(this, faceResultResp, data));
                Unit unit = Unit.INSTANCE;
                this.f30753a = WalletDialog.Companion.configDrawer$default(companion, context, builder, false, false, 12, (Object) null);
            }
            WalletDialog walletDialog = this.f30753a;
            if (walletDialog != null) {
                SystemUtils.showDialog(walletDialog);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m21628b(FaceResultResp faceResultResp) {
        WalletDialog walletDialog = this.f30753a;
        if (walletDialog != null) {
            Intrinsics.checkNotNull(walletDialog);
            if (walletDialog.isShowing()) {
                WalletDialog walletDialog2 = this.f30753a;
                Intrinsics.checkNotNull(walletDialog2);
                walletDialog2.dismiss();
            }
        }
        int i = faceResultResp.errno;
        if (i != 60234) {
            switch (i) {
                case FaceResultResp.CODE_VERIFY_RG_FAILED /*60218*/:
                    ((ChooseIDTypeVM) getVm()).submitHumanCheck();
                    return;
                case FaceResultResp.C0DE_VERIFY_CHN_FAILED /*60219*/:
                    ((ChooseIDTypeVM) getVm()).setVerifyFaceType(2002);
                    ChooseIDTypeVM chooseIDTypeVM = (ChooseIDTypeVM) getVm();
                    SignUpVM signUpVM = this.f30754b;
                    SignUpVM signUpVM2 = null;
                    if (signUpVM == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                        signUpVM = null;
                    }
                    String pageSource = signUpVM.getPageSource();
                    SignUpVM signUpVM3 = this.f30754b;
                    if (signUpVM3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                    } else {
                        signUpVM2 = signUpVM3;
                    }
                    chooseIDTypeVM.reqDoorGodInitInfo(2002, pageSource, signUpVM2.getFromPrimary());
                    return;
                case FaceResultResp.CODE_BACKGROUND_CHECK_FAILED /*60220*/:
                    FragmentActivity activity = getActivity();
                    if (activity != null) {
                        activity.finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m21630c(FaceResultResp faceResultResp) {
        FragmentActivity activity;
        Intent intent;
        WalletDialog walletDialog = this.f30753a;
        if (walletDialog != null) {
            Intrinsics.checkNotNull(walletDialog);
            if (walletDialog.isShowing()) {
                WalletDialog walletDialog2 = this.f30753a;
                Intrinsics.checkNotNull(walletDialog2);
                walletDialog2.dismiss();
            }
        }
        int i = faceResultResp.errno;
        boolean z = true;
        SignUpVM signUpVM = null;
        if (i != 60234) {
            switch (i) {
                case FaceResultResp.CODE_VERIFY_RG_FAILED /*60218*/:
                    ((ChooseIDTypeVM) getVm()).setVerifyFaceType(2002);
                    ChooseIDTypeVM chooseIDTypeVM = (ChooseIDTypeVM) getVm();
                    SignUpVM signUpVM2 = this.f30754b;
                    if (signUpVM2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                        signUpVM2 = null;
                    }
                    String pageSource = signUpVM2.getPageSource();
                    SignUpVM signUpVM3 = this.f30754b;
                    if (signUpVM3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                    } else {
                        signUpVM = signUpVM3;
                    }
                    chooseIDTypeVM.reqDoorGodInitInfo(2002, pageSource, signUpVM.getFromPrimary());
                    return;
                case FaceResultResp.C0DE_VERIFY_CHN_FAILED /*60219*/:
                    ((ChooseIDTypeVM) getVm()).setVerifyFaceType(2001);
                    ChooseIDTypeVM chooseIDTypeVM2 = (ChooseIDTypeVM) getVm();
                    SignUpVM signUpVM4 = this.f30754b;
                    if (signUpVM4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                        signUpVM4 = null;
                    }
                    String pageSource2 = signUpVM4.getPageSource();
                    SignUpVM signUpVM5 = this.f30754b;
                    if (signUpVM5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                    } else {
                        signUpVM = signUpVM5;
                    }
                    chooseIDTypeVM2.reqDoorGodInitInfo(2001, pageSource2, signUpVM.getFromPrimary());
                    return;
                case FaceResultResp.CODE_BACKGROUND_CHECK_FAILED /*60220*/:
                    WebBrowserUtil.startInternalWebActivity(getActivity(), "https://help.didiglobal.com/passenger-index-new.html?source=99pay&kfPageSource=99pay", "");
                    FragmentActivity activity2 = getActivity();
                    if (activity2 == null || (intent = activity2.getIntent()) == null || !intent.getBooleanExtra(AccessBlockManager.PARAM_ACCESS_BLOCK, false)) {
                        z = false;
                    }
                    if (z && (activity = getActivity()) != null) {
                        activity.finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            SignUpVM signUpVM6 = this.f30754b;
            if (signUpVM6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                signUpVM6 = null;
            }
            GuidesInfoResp.Data pixSignUpInfoData = signUpVM6.getPixSignUpInfoData();
            if (pixSignUpInfoData == null || pixSignUpInfoData.getNeedDoorGod()) {
                z = false;
            }
            if (z) {
                ((ChooseIDTypeVM) getVm()).reqFaceInitInfo(2001);
                return;
            }
            ((ChooseIDTypeVM) getVm()).setVerifyFaceType(2001);
            ChooseIDTypeVM chooseIDTypeVM3 = (ChooseIDTypeVM) getVm();
            SignUpVM signUpVM7 = this.f30754b;
            if (signUpVM7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                signUpVM7 = null;
            }
            String pageSource3 = signUpVM7.getPageSource();
            SignUpVM signUpVM8 = this.f30754b;
            if (signUpVM8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            } else {
                signUpVM = signUpVM8;
            }
            chooseIDTypeVM3.reqDoorGodInitInfo(2001, pageSource3, signUpVM.getFromPrimary());
        }
    }

    /* renamed from: d */
    private final boolean m21632d(FaceResultResp faceResultResp) {
        int i = faceResultResp.errno;
        if (i != 60234) {
            switch (i) {
                case FaceResultResp.CODE_VERIFY_RG_FAILED /*60218*/:
                    FaceResultResp.Data data = faceResultResp.getData();
                    if (data != null) {
                        data.setFirstButtonText(getString(R.string.GRider_Registration_Try_again_wVgL));
                    }
                    FaceResultResp.Data data2 = faceResultResp.getData();
                    if (data2 != null) {
                        data2.setSecondButtonText(getString(R.string.GRider_Registration_Manual_Verification_tWgA));
                    }
                    return true;
                case FaceResultResp.C0DE_VERIFY_CHN_FAILED /*60219*/:
                    FaceResultResp.Data data3 = faceResultResp.getData();
                    if (data3 != null) {
                        data3.setFirstButtonText(getString(R.string.GRider_Registration_Try_again_wVgL));
                    }
                    FaceResultResp.Data data4 = faceResultResp.getData();
                    if (data4 != null) {
                        data4.setSecondButtonText(getString(R.string.GRider_Registration_RG_Verification_kjyt));
                    }
                    return true;
                case FaceResultResp.CODE_BACKGROUND_CHECK_FAILED /*60220*/:
                    FaceResultResp.Data data5 = faceResultResp.getData();
                    if (data5 != null) {
                        data5.setFirstButtonText(getString(R.string.GRider_Registration_Customer_Service_ECyt));
                    }
                    FaceResultResp.Data data6 = faceResultResp.getData();
                    if (data6 != null) {
                        data6.setSecondButtonText(getString(R.string.GRider_Registration_Cancel_kckP));
                    }
                    return true;
                default:
                    Context context = getContext();
                    if (context == null) {
                        return false;
                    }
                    WalletToastNew.showFailedMsg(context, faceResultResp.errmsg);
                    return false;
            }
        } else {
            FaceResultResp.Data data7 = faceResultResp.getData();
            if (data7 != null) {
                data7.setFirstButtonText(getString(R.string.GRider_Registration_Try_again_wVgL));
            }
            FaceResultResp.Data data8 = faceResultResp.getData();
            if (data8 != null) {
                data8.setSecondButtonText(getString(R.string.GRider_Registration_Cancel_kckP));
            }
            return true;
        }
    }

    /* renamed from: d */
    private final boolean m21631d() {
        Intent intent;
        FragmentActivity activity = getActivity();
        Integer num = null;
        if (!(activity == null || (intent = activity.getIntent()) == null)) {
            num = Integer.valueOf(intent.getIntExtra(AccessBlockManager.PARAM_ACCESS_BLOCK_CODE, 0));
        }
        if ((num != null && num.intValue() == 10010) || (num != null && num.intValue() == 10011)) {
            return true;
        }
        return false;
    }
}
