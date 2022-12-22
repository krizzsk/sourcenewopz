package com.didi.payment.kycservice.key.create.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.payment.commonsdk.p129ui.WBaseFragment;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.kycservice.key.create.PixKeyCreateActivity;
import com.didi.payment.kycservice.key.create.PixKeyCreateVM;
import com.didi.payment.kycservice.kyc.response.MigrateTipData;
import com.didi.payment.kycservice.module.PixTitleBarModule;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001e\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010\f\u001a\u00020\rR\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006+"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/create/fragment/CreateKeyBaseFragment;", "Lcom/didi/payment/commonsdk/ui/WBaseFragment;", "Lcom/didi/payment/kycservice/key/create/PixKeyCreateVM;", "()V", "btnContinue", "Landroid/widget/TextView;", "getBtnContinue", "()Landroid/widget/TextView;", "setBtnContinue", "(Landroid/widget/TextView;)V", "dlgMigrate", "Lcom/didi/global/globaluikit/drawer/LEGODrawer;", "keyVal", "", "getKeyVal", "()Ljava/lang/String;", "setKeyVal", "(Ljava/lang/String;)V", "subTitle", "getSubTitle", "setSubTitle", "title", "getTitle", "setTitle", "titleBarModule", "Lcom/didi/payment/kycservice/module/PixTitleBarModule;", "getTitleBarModule", "()Lcom/didi/payment/kycservice/module/PixTitleBarModule;", "setTitleBarModule", "(Lcom/didi/payment/kycservice/module/PixTitleBarModule;)V", "getTitleBarView", "Landroid/view/View;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "showMigrateDlg", "dlgInfo", "Lcom/didi/payment/kycservice/kyc/response/MigrateTipData;", "keyType", "", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreateKeyBaseFragment.kt */
public abstract class CreateKeyBaseFragment extends WBaseFragment<PixKeyCreateVM> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public LEGODrawer f30645a;

    /* renamed from: b */
    private String f30646b = "";
    protected TextView btnContinue;

    /* renamed from: c */
    private String f30647c = "";

    /* renamed from: d */
    private String f30648d = "";
    protected PixTitleBarModule titleBarModule;

    public static final /* synthetic */ PixKeyCreateVM access$getVm(CreateKeyBaseFragment createKeyBaseFragment) {
        return (PixKeyCreateVM) createKeyBaseFragment.getVm();
    }

    /* access modifiers changed from: protected */
    public final TextView getBtnContinue() {
        TextView textView = this.btnContinue;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("btnContinue");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setBtnContinue(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.btnContinue = textView;
    }

    /* access modifiers changed from: protected */
    public final PixTitleBarModule getTitleBarModule() {
        PixTitleBarModule pixTitleBarModule = this.titleBarModule;
        if (pixTitleBarModule != null) {
            return pixTitleBarModule;
        }
        Intrinsics.throwUninitializedPropertyAccessException("titleBarModule");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setTitleBarModule(PixTitleBarModule pixTitleBarModule) {
        Intrinsics.checkNotNullParameter(pixTitleBarModule, "<set-?>");
        this.titleBarModule = pixTitleBarModule;
    }

    /* access modifiers changed from: protected */
    public final String getTitle() {
        return this.f30646b;
    }

    /* access modifiers changed from: protected */
    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f30646b = str;
    }

    /* access modifiers changed from: protected */
    public final String getSubTitle() {
        return this.f30647c;
    }

    /* access modifiers changed from: protected */
    public final void setSubTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f30647c = str;
    }

    /* access modifiers changed from: protected */
    public final String getKeyVal() {
        return this.f30648d;
    }

    /* access modifiers changed from: protected */
    public final void setKeyVal(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f30648d = str;
    }

    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        String string;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String str3 = "";
        if (arguments == null || (str = arguments.getString(PixKeyCreateActivity.PARAM_KEY_TITLE)) == null) {
            str = str3;
        }
        this.f30646b = str;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str2 = arguments2.getString(PixKeyCreateActivity.PARAM_KEY_SUBTITLE)) == null) {
            str2 = str3;
        }
        this.f30647c = str2;
        Bundle arguments3 = getArguments();
        if (!(arguments3 == null || (string = arguments3.getString("param_key_val")) == null)) {
            str3 = string;
        }
        this.f30648d = str3;
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(PixKeyCreateVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir…xKeyCreateVM::class.java)");
        setVm((WBaseViewModel) viewModel);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.create_key_continue_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.create_key_continue_btn)");
        setBtnContinue((TextView) findViewById);
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.create_key_title_bar);
        PixTitleBarModule.Companion companion = PixTitleBarModule.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Intrinsics.checkNotNullExpressionValue(viewStub, "titleBarStub");
        setTitleBarModule(companion.create(requireContext, viewStub));
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return getTitleBarModule().getToolBar();
    }

    public final void showMigrateDlg(MigrateTipData migrateTipData, int i, String str) {
        Intrinsics.checkNotNullParameter(migrateTipData, "dlgInfo");
        Intrinsics.checkNotNullParameter(str, "keyVal");
        this.f30645a = LEGOUICreator.showDrawerTemplate(getContext(), new LEGODrawerModel1(migrateTipData.getMigrateTitle(), new LEGOBtnTextAndCallback(migrateTipData.getMigrateButton(), new CreateKeyBaseFragment$showMigrateDlg$model$1(this, i, str))).addMinorBtn(new LEGOBtnTextAndCallback(migrateTipData.getCancelButton(), new CreateKeyBaseFragment$showMigrateDlg$model$2(this))).setClickOutsideCanCancel(true).setSubTitle(migrateTipData.getMigrateSubTitle()));
    }
}
