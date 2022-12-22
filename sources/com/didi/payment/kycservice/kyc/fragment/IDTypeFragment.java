package com.didi.payment.kycservice.kyc.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.commonsdk.p129ui.WBaseFragment;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.commonsdk.spi.JumioService;
import com.didi.payment.commonsdk.utils.JumioFaceFinishEvent;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.commonsdk.utils.NViewUtils;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.kycservice.kyc.SignUpVM;
import com.didi.payment.kycservice.kyc.p133vm.IDTypeVM;
import com.didi.payment.kycservice.net.response.JumioGuideResp;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Metadata(mo175977d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ;2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001;B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001bH\u0002J&\u0010!\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u001dH\u0016J\u0012\u0010)\u001a\u00020\u001d2\b\u0010*\u001a\u0004\u0018\u00010+H\u0007J\u001a\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J+\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u0002002\u000e\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u0017022\u0006\u00103\u001a\u000204¢\u0006\u0002\u00105J\u0010\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\u0002H\u0016J\u0010\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020:H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000¨\u0006<"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/IDTypeFragment;", "Lcom/didi/payment/commonsdk/ui/WBaseFragment;", "Lcom/didi/payment/kycservice/kyc/vm/IDTypeVM;", "()V", "mConfirmBtn", "Landroid/widget/TextView;", "getMConfirmBtn", "()Landroid/widget/TextView;", "setMConfirmBtn", "(Landroid/widget/TextView;)V", "mIdGuideSubTitle", "getMIdGuideSubTitle", "setMIdGuideSubTitle", "mIdGuideTitle", "getMIdGuideTitle", "setMIdGuideTitle", "mIdImage", "Landroid/widget/ImageView;", "getMIdImage", "()Landroid/widget/ImageView;", "setMIdImage", "(Landroid/widget/ImageView;)V", "pageSource", "", "pixSignUpVM", "Lcom/didi/payment/kycservice/kyc/SignUpVM;", "getTitleBarView", "Landroid/view/View;", "goIntentSetting", "", "initListener", "initView", "rootView", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onEvent", "event", "Lcom/didi/payment/commonsdk/utils/JumioFaceFinishEvent;", "onViewCreated", "view", "showPerDialog", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "subscribeUi", "vm", "updateView", "guideData", "Lcom/didi/payment/kycservice/net/response/JumioGuideResp$Data;", "Companion", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IDTypeFragment.kt */
public final class IDTypeFragment extends WBaseFragment<IDTypeVM> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private TextView f30801a;

    /* renamed from: b */
    private TextView f30802b;

    /* renamed from: c */
    private TextView f30803c;

    /* renamed from: d */
    private ImageView f30804d;

    /* renamed from: e */
    private String f30805e = "";
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SignUpVM f30806f;

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return null;
    }

    public final TextView getMConfirmBtn() {
        return this.f30801a;
    }

    public final void setMConfirmBtn(TextView textView) {
        this.f30801a = textView;
    }

    public final TextView getMIdGuideTitle() {
        return this.f30802b;
    }

    public final void setMIdGuideTitle(TextView textView) {
        this.f30802b = textView;
    }

    public final TextView getMIdGuideSubTitle() {
        return this.f30803c;
    }

    public final void setMIdGuideSubTitle(TextView textView) {
        this.f30803c = textView;
    }

    public final ImageView getMIdImage() {
        return this.f30804d;
    }

    public final void setMIdImage(ImageView imageView) {
        this.f30804d = imageView;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/IDTypeFragment$Companion;", "", "()V", "newInstance", "Lcom/didi/payment/kycservice/kyc/fragment/IDTypeFragment;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IDTypeFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IDTypeFragment newInstance() {
            Bundle bundle = new Bundle();
            IDTypeFragment iDTypeFragment = new IDTypeFragment();
            iDTypeFragment.setArguments(bundle);
            return iDTypeFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragement_id_type_layout, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        OmegaComParams.Companion.setPubPage(OmegaComParams.FULL_KYC_VER);
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(SignUpVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir…get(SignUpVM::class.java)");
        SignUpVM signUpVM = (SignUpVM) viewModel;
        this.f30806f = signUpVM;
        if (signUpVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM = null;
        }
        this.f30805e = signUpVM.getPageSource();
        ViewModel viewModel2 = new ViewModelProvider(this).get(IDTypeVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(this).get(IDTypeVM::class.java)");
        setVm((WBaseViewModel) viewModel2);
        ((IDTypeVM) getVm()).loadData();
        subscribeUi((IDTypeVM) getVm());
        m21674a(view);
        m21673a();
        EventBus.getDefault().register(this);
        KycOmega.Companion.trackEvent("fin_fullkycverification_sw");
    }

    public void subscribeUi(IDTypeVM iDTypeVM) {
        Intrinsics.checkNotNullParameter(iDTypeVM, "vm");
        super.subscribeUi(iDTypeVM);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        iDTypeVM.getJumioGuideData().observe(viewLifecycleOwner, new IDTypeFragment$subscribeUi$$inlined$observe$1(this));
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        iDTypeVM.getJumioCreateData().observe(viewLifecycleOwner2, new IDTypeFragment$subscribeUi$$inlined$observe$2(this));
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        iDTypeVM.isLoading().observe(viewLifecycleOwner3, new IDTypeFragment$subscribeUi$$inlined$observe$3(this));
    }

    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    /* renamed from: a */
    private final void m21674a(View view) {
        this.f30801a = (TextView) view.findViewById(R.id.confirm_btn);
        this.f30802b = (TextView) view.findViewById(R.id.id_guide_title);
        this.f30803c = (TextView) view.findViewById(R.id.id_guide_sub_title);
        this.f30804d = (ImageView) view.findViewById(R.id.id_guide_image);
    }

    /* renamed from: a */
    private final void m21673a() {
        TextView textView = this.f30801a;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    IDTypeFragment.m21675a(IDTypeFragment.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21675a(IDTypeFragment iDTypeFragment, View view) {
        Intrinsics.checkNotNullParameter(iDTypeFragment, "this$0");
        try {
            KycOmega.Companion.trackButtonEvent("fin_fullkycverification_button_ck", 1);
            FragmentActivity activity = iDTypeFragment.getActivity();
            if (activity != null) {
                if (!JumioService.Companion.checkPermissions(activity)) {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        IDTypeVM iDTypeVM = (IDTypeVM) iDTypeFragment.getVm();
        SignUpVM signUpVM = iDTypeFragment.f30806f;
        SignUpVM signUpVM2 = null;
        if (signUpVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM = null;
        }
        String pageSource = signUpVM.getPageSource();
        SignUpVM signUpVM3 = iDTypeFragment.f30806f;
        if (signUpVM3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
        } else {
            signUpVM2 = signUpVM3;
        }
        iDTypeVM.createToken(pageSource, signUpVM2.getFromPrimary());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m21677a(JumioGuideResp.Data data) {
        String imageLink;
        TextView textView = this.f30802b;
        if (textView != null) {
            textView.setText(data.getTitle());
        }
        TextView textView2 = this.f30803c;
        if (textView2 != null) {
            NViewUtils.INSTANCE.setText2HighLight(textView2, data.getSubTitle(), Color.parseColor("#666666"));
        }
        ImageView imageView = this.f30804d;
        if (imageView != null && (imageLink = data.getImageLink()) != null) {
            GlideUtils.with2load2into(getContext(), imageLink, imageView);
        }
    }

    @Subscribe
    public final void onEvent(JumioFaceFinishEvent jumioFaceFinishEvent) {
        boolean z = false;
        if (jumioFaceFinishEvent != null && jumioFaceFinishEvent.finish) {
            z = true;
        }
        if (z) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        ((IDTypeVM) getVm()).checkJumio(new IDTypeFragment$onEvent$1(this));
    }

    public final void showPerDialog(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        if (i == 303) {
            StringBuilder sb = new StringBuilder();
            int length = iArr.length - 1;
            if (length >= 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    if (iArr[i2] != 0) {
                        sb.append(strArr[i2]);
                        sb.append(" not granted,");
                    }
                    if (i3 > length) {
                        break;
                    }
                    i2 = i3;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
            SignUpVM signUpVM = null;
            if (!StringsKt.isBlank(sb2)) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_kyc_title_custome, (ViewGroup) null, false);
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    new AlertDialogFragment.Builder(activity).setContentView(inflate).setPositiveButton((CharSequence) getResources().getString(R.string.FoodC_homepage_To_authorize_CEZR), (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
                        public final void onClick(AlertDialogFragment alertDialogFragment, View view) {
                            IDTypeFragment.m21676a(IDTypeFragment.this, alertDialogFragment, view);
                        }
                    }).setPositiveButtonDefault().setCancelable(false).setNegativeButton((CharSequence) getResources().getString(R.string.GRider_Registration_Cancel_kckP), (AlertDialogFragment.OnClickListener) $$Lambda$IDTypeFragment$amQwWFwbPGmkDw2Wcizdd_88H8o.INSTANCE).create().show(activity.getSupportFragmentManager(), "");
                    return;
                }
                return;
            }
            IDTypeVM iDTypeVM = (IDTypeVM) getVm();
            SignUpVM signUpVM2 = this.f30806f;
            if (signUpVM2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                signUpVM2 = null;
            }
            String pageSource = signUpVM2.getPageSource();
            SignUpVM signUpVM3 = this.f30806f;
            if (signUpVM3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            } else {
                signUpVM = signUpVM3;
            }
            iDTypeVM.createToken(pageSource, signUpVM.getFromPrimary());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21676a(IDTypeFragment iDTypeFragment, AlertDialogFragment alertDialogFragment, View view) {
        Intrinsics.checkNotNullParameter(iDTypeFragment, "this$0");
        alertDialogFragment.dismiss();
        iDTypeFragment.m21679b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21678a(AlertDialogFragment alertDialogFragment, View view) {
        alertDialogFragment.dismiss();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f A[Catch:{ Exception -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m21679b() {
        /*
            r6 = this;
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            r1 = 0
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x0043 }
            java.lang.String r3 = "android.settings.APPLICATION_DETAILS_SETTINGS"
            r2.<init>(r3)     // Catch:{ Exception -> 0x0043 }
            r2.setFlags(r0)     // Catch:{ Exception -> 0x0043 }
            java.lang.String r3 = "package"
            androidx.fragment.app.FragmentActivity r4 = r6.getActivity()     // Catch:{ Exception -> 0x0043 }
            if (r4 != 0) goto L_0x0017
            r4 = r1
            goto L_0x001b
        L_0x0017:
            java.lang.String r4 = r4.getPackageName()     // Catch:{ Exception -> 0x0043 }
        L_0x001b:
            r5 = r1
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0043 }
            android.net.Uri r3 = android.net.Uri.fromParts(r3, r4, r5)     // Catch:{ Exception -> 0x0043 }
            java.lang.String r4 = "fromParts(\"package\", act…ageName, null as String?)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ Exception -> 0x0043 }
            r2.setData(r3)     // Catch:{ Exception -> 0x0043 }
            androidx.fragment.app.FragmentActivity r3 = r6.getActivity()     // Catch:{ Exception -> 0x0043 }
            if (r3 != 0) goto L_0x0032
        L_0x0030:
            r3 = r1
            goto L_0x003d
        L_0x0032:
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch:{ Exception -> 0x0043 }
            if (r3 != 0) goto L_0x0039
            goto L_0x0030
        L_0x0039:
            android.content.ComponentName r3 = r2.resolveActivity(r3)     // Catch:{ Exception -> 0x0043 }
        L_0x003d:
            if (r3 == 0) goto L_0x006d
            r6.startActivity(r2)     // Catch:{ Exception -> 0x0043 }
            goto L_0x006d
        L_0x0043:
            r2 = move-exception
            r2.printStackTrace()
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x0069 }
            java.lang.String r3 = "android.settings.SETTINGS"
            r2.<init>(r3)     // Catch:{ Exception -> 0x0069 }
            r2.setFlags(r0)     // Catch:{ Exception -> 0x0069 }
            androidx.fragment.app.FragmentActivity r0 = r6.getActivity()     // Catch:{ Exception -> 0x0069 }
            if (r0 != 0) goto L_0x0058
            goto L_0x0063
        L_0x0058:
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ Exception -> 0x0069 }
            if (r0 != 0) goto L_0x005f
            goto L_0x0063
        L_0x005f:
            android.content.ComponentName r1 = r2.resolveActivity(r0)     // Catch:{ Exception -> 0x0069 }
        L_0x0063:
            if (r1 == 0) goto L_0x006d
            r6.startActivity(r2)     // Catch:{ Exception -> 0x0069 }
            goto L_0x006d
        L_0x0069:
            r0 = move-exception
            r0.printStackTrace()
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.kycservice.kyc.fragment.IDTypeFragment.m21679b():void");
    }
}
