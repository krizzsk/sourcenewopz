package com.didi.payment.kycservice.kyc.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.utils.TextHighlightUtil;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.kycservice.key.create.PixKeyCreateActivity;
import com.didi.payment.kycservice.kyc.SignUpVM;
import com.didi.payment.kycservice.kyc.p133vm.ChooseKeyTypeVM;
import com.didi.payment.kycservice.kyc.response.CPFCheckResp;
import com.didi.payment.kycservice.kyc.response.MigrateTipData;
import com.didi.payment.kycservice.kyc.response.PixChooseTypeListResp;
import com.didi.payment.kycservice.utils.KycRegisterUtils;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\rH\u0016J\u001a\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J \u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0002H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/ChooseKeyTypeFragment;", "Lcom/didi/payment/kycservice/kyc/fragment/ChooseTypeBaseFragment;", "Lcom/didi/payment/kycservice/kyc/vm/ChooseKeyTypeVM;", "()V", "dlgMigrate", "Lcom/didi/global/globaluikit/drawer/LEGODrawer;", "pixSignUpVM", "Lcom/didi/payment/kycservice/kyc/SignUpVM;", "tvShowOtherType", "Landroid/widget/TextView;", "uid", "", "go2PixKeyCreateActivity", "", "item", "Lcom/didi/payment/kycservice/kyc/response/PixChooseTypeListResp$Item;", "initListener", "initView", "rootView", "Landroid/view/View;", "onDestroyView", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "showMigrateDlg", "dlgInfo", "Lcom/didi/payment/kycservice/kyc/response/MigrateTipData;", "keyType", "", "keyVal", "subscribeUi", "vm", "Companion", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ChooseKeyTypeFragment.kt */
public final class ChooseKeyTypeFragment extends ChooseTypeBaseFragment<ChooseKeyTypeVM> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private TextView f30756a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LEGODrawer f30757b;

    /* renamed from: c */
    private String f30758c = "";

    /* renamed from: d */
    private SignUpVM f30759d;

    public static final /* synthetic */ ChooseKeyTypeVM access$getVm(ChooseKeyTypeFragment chooseKeyTypeFragment) {
        return (ChooseKeyTypeVM) chooseKeyTypeFragment.getVm();
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/ChooseKeyTypeFragment$Companion;", "", "()V", "newInstance", "Lcom/didi/payment/kycservice/kyc/fragment/ChooseKeyTypeFragment;", "titlePrefix", "", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ChooseKeyTypeFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ChooseKeyTypeFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "titlePrefix");
            ChooseKeyTypeFragment chooseKeyTypeFragment = new ChooseKeyTypeFragment();
            Bundle bundle = new Bundle();
            bundle.putString(ChooseTypeBaseFragmentKt.PARAM_TITLE_PREFIX, str);
            chooseKeyTypeFragment.setArguments(bundle);
            return chooseKeyTypeFragment;
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        OmegaComParams.Companion.setPubPage(OmegaComParams.PIX_KEY_REG);
        m21634a(view);
        m21633a();
        ViewModel viewModel = new ViewModelProvider(this).get(ChooseKeyTypeVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…oseKeyTypeVM::class.java)");
        setVm((WBaseViewModel) viewModel);
        ViewModel viewModel2 = new ViewModelProvider(requireActivity()).get(SignUpVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(requir…get(SignUpVM::class.java)");
        this.f30759d = (SignUpVM) viewModel2;
        subscribeUi((ChooseKeyTypeVM) getVm());
        String stringParam = PayBaseParamUtil.getStringParam(getContext(), "phone");
        Intrinsics.checkNotNullExpressionValue(stringParam, "getStringParam(context, PayParam.PHONE)");
        this.f30758c = stringParam;
        KycOmega.Companion.trackEvent("ibt_didipay_registration_sw");
    }

    public void onDestroyView() {
        super.onDestroyView();
        OmegaComParams.Companion.setPUB_FROM_PAGE(OmegaComParams.PIX_KEY_REG);
    }

    public void subscribeUi(ChooseKeyTypeVM chooseKeyTypeVM) {
        Intrinsics.checkNotNullParameter(chooseKeyTypeVM, "vm");
        super.subscribeUi(chooseKeyTypeVM);
        chooseKeyTypeVM.isLoading().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                ChooseKeyTypeFragment.m21640a(ChooseKeyTypeFragment.this, (Boolean) obj);
            }
        });
        chooseKeyTypeVM.getBizLD().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                ChooseKeyTypeFragment.m21637a(ChooseKeyTypeFragment.this, (PixChooseTypeListResp.Data) obj);
            }
        });
        chooseKeyTypeVM.getCpfCheckData().observe(getViewLifecycleOwner(), new Observer(chooseKeyTypeVM) {
            public final /* synthetic */ ChooseKeyTypeVM f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                ChooseKeyTypeFragment.m21639a(ChooseKeyTypeFragment.this, this.f$1, (CPFCheckResp) obj);
            }
        });
        chooseKeyTypeVM.getBizMigrateInApiData().observe(getViewLifecycleOwner(), new Observer(chooseKeyTypeVM) {
            public final /* synthetic */ ChooseKeyTypeVM f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                ChooseKeyTypeFragment.m21638a(ChooseKeyTypeFragment.this, this.f$1, (WBaseResp) obj);
            }
        });
        chooseKeyTypeVM.getErrObj().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                ChooseKeyTypeFragment.m21636a(ChooseKeyTypeFragment.this, (WBaseResp) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21640a(ChooseKeyTypeFragment chooseKeyTypeFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(chooseKeyTypeFragment, "this$0");
        SignUpVM signUpVM = chooseKeyTypeFragment.f30759d;
        if (signUpVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            signUpVM = null;
        }
        signUpVM.isLoading().setValue(bool);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21637a(ChooseKeyTypeFragment chooseKeyTypeFragment, PixChooseTypeListResp.Data data) {
        Intrinsics.checkNotNullParameter(chooseKeyTypeFragment, "this$0");
        chooseKeyTypeFragment.getTvMainTitle().setText(TextHighlightUtil.highlight(Intrinsics.stringPlus(chooseKeyTypeFragment.getTitlePrefix(), data.getTitle()), Color.parseColor("#000000"), Color.parseColor("#FF8040")));
        CharSequence subTitle = data.getSubTitle();
        int i = 8;
        if (subTitle == null || subTitle.length() == 0) {
            chooseKeyTypeFragment.getTvSubTitle().setVisibility(8);
        } else {
            chooseKeyTypeFragment.getTvSubTitle().setVisibility(0);
            chooseKeyTypeFragment.getTvSubTitle().setText(TextHighlightUtil.highlight(data.getSubTitle(), Color.parseColor("#666666"), Color.parseColor("#FF8040")));
        }
        TextView textView = chooseKeyTypeFragment.f30756a;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvShowOtherType");
            textView = null;
        }
        if (data.isHide()) {
            i = 0;
        }
        textView.setVisibility(i);
        if (data.isHide()) {
            Collection keyList = data.getKeyList();
            if (!(keyList == null || keyList.isEmpty())) {
                SignUpRvAdapter rvAdapter = chooseKeyTypeFragment.getRvAdapter();
                ArrayList<PixChooseTypeListResp.Item> keyList2 = data.getKeyList();
                Intrinsics.checkNotNull(keyList2);
                PixChooseTypeListResp.Item item = keyList2.get(0);
                Intrinsics.checkNotNullExpressionValue(item, "it.keyList!![0]");
                rvAdapter.setData(CollectionsKt.arrayListOf(item));
                return;
            }
        }
        chooseKeyTypeFragment.getRvAdapter().setData(data.getKeyList());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21639a(ChooseKeyTypeFragment chooseKeyTypeFragment, ChooseKeyTypeVM chooseKeyTypeVM, CPFCheckResp cPFCheckResp) {
        PixChooseTypeListResp.Item.Detail defaultDetail;
        String defaultValue;
        Intrinsics.checkNotNullParameter(chooseKeyTypeFragment, "this$0");
        Intrinsics.checkNotNullParameter(chooseKeyTypeVM, "$vm");
        if (cPFCheckResp.errno == 0) {
            chooseKeyTypeFragment.m21642a(chooseKeyTypeVM.getCpfItemData());
        } else if (cPFCheckResp.errno == 60200) {
            CPFCheckResp.Data data = cPFCheckResp.getData();
            if ((data == null ? null : data.getMigrateTipData()) != null) {
                PixChooseTypeListResp.Item cpfItemData = chooseKeyTypeVM.getCpfItemData();
                String str = "";
                if (!(cpfItemData == null || (defaultDetail = cpfItemData.getDefaultDetail()) == null || (defaultValue = defaultDetail.getDefaultValue()) == null)) {
                    str = defaultValue;
                }
                CPFCheckResp.Data data2 = cPFCheckResp.getData();
                Intrinsics.checkNotNull(data2);
                MigrateTipData migrateTipData = data2.getMigrateTipData();
                Intrinsics.checkNotNull(migrateTipData);
                chooseKeyTypeFragment.m21641a(migrateTipData, 1, str);
            }
            KycOmega.Companion.trackEvent("ibt_didipay_registration_cpf_taken_others_sw");
        } else {
            Context context = chooseKeyTypeFragment.getContext();
            if (context != null) {
                ToastHelper.showLongInfo(context, cPFCheckResp.errmsg);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21638a(ChooseKeyTypeFragment chooseKeyTypeFragment, ChooseKeyTypeVM chooseKeyTypeVM, WBaseResp wBaseResp) {
        Intrinsics.checkNotNullParameter(chooseKeyTypeFragment, "this$0");
        Intrinsics.checkNotNullParameter(chooseKeyTypeVM, "$vm");
        if (wBaseResp.errno == 0) {
            KycRegisterUtils.INSTANCE.go2PixSignUpResultPage(chooseKeyTypeFragment.getActivity(), chooseKeyTypeVM.getResultPageData());
            return;
        }
        Context context = chooseKeyTypeFragment.getContext();
        if (context != null) {
            ToastHelper.showLongInfo(context, wBaseResp.errmsg);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21636a(ChooseKeyTypeFragment chooseKeyTypeFragment, WBaseResp wBaseResp) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(chooseKeyTypeFragment, "this$0");
        if (wBaseResp.errno == 60222 && (activity = chooseKeyTypeFragment.getActivity()) != null) {
            activity.finish();
        }
    }

    /* renamed from: a */
    private final void m21634a(View view) {
        View findViewById = view.findViewById(R.id.pix_sign_up_view_other_key_type);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.…n_up_view_other_key_type)");
        this.f30756a = (TextView) findViewById;
    }

    /* renamed from: a */
    private final void m21633a() {
        TextView textView = this.f30756a;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvShowOtherType");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ChooseKeyTypeFragment.m21635a(ChooseKeyTypeFragment.this, view);
            }
        });
        getRvAdapter().setOnItemClickListener(new ChooseKeyTypeFragment$initListener$2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21635a(ChooseKeyTypeFragment chooseKeyTypeFragment, View view) {
        Intrinsics.checkNotNullParameter(chooseKeyTypeFragment, "this$0");
        TextView textView = chooseKeyTypeFragment.f30756a;
        ArrayList<PixChooseTypeListResp.Item> arrayList = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvShowOtherType");
            textView = null;
        }
        textView.setVisibility(8);
        SignUpRvAdapter rvAdapter = chooseKeyTypeFragment.getRvAdapter();
        PixChooseTypeListResp.Data value = ((ChooseKeyTypeVM) chooseKeyTypeFragment.getVm()).getBizLD().getValue();
        if (value != null) {
            arrayList = value.getKeyList();
        }
        rvAdapter.setData(arrayList);
    }

    /* renamed from: a */
    private final void m21641a(MigrateTipData migrateTipData, int i, String str) {
        this.f30757b = LEGOUICreator.showDrawerTemplate(getContext(), new LEGODrawerModel1(migrateTipData.getMigrateTitle(), new LEGOBtnTextAndCallback(migrateTipData.getMigrateButton(), new ChooseKeyTypeFragment$showMigrateDlg$model$1(this, i, str, migrateTipData))).addMinorBtn(new LEGOBtnTextAndCallback(migrateTipData.getCancelButton(), new ChooseKeyTypeFragment$showMigrateDlg$model$2(this, migrateTipData))).setClickOutsideCanCancel(true).setSubTitle(migrateTipData.getMigrateSubTitle()));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m21642a(PixChooseTypeListResp.Item item) {
        String str;
        String str2;
        String subTitle;
        if (item != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("param_key_type", item.getType());
            PixChooseTypeListResp.Item.Detail defaultDetail = item.getDefaultDetail();
            String str3 = "";
            if (defaultDetail == null || (str = defaultDetail.getDefaultValue()) == null) {
                str = str3;
            }
            bundle.putString("param_key_val", str);
            PixChooseTypeListResp.Item.Detail defaultDetail2 = item.getDefaultDetail();
            if (defaultDetail2 == null || (str2 = defaultDetail2.getTitle()) == null) {
                str2 = str3;
            }
            bundle.putString(PixKeyCreateActivity.PARAM_KEY_TITLE, str2);
            PixChooseTypeListResp.Item.Detail defaultDetail3 = item.getDefaultDetail();
            if (!(defaultDetail3 == null || (subTitle = defaultDetail3.getSubTitle()) == null)) {
                str3 = subTitle;
            }
            bundle.putString(PixKeyCreateActivity.PARAM_KEY_SUBTITLE, str3);
            Intent intent = new Intent(getActivity(), PixKeyCreateActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
