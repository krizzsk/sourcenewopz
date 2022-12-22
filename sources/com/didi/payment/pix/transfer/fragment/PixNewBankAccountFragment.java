package com.didi.payment.pix.transfer.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.MD5Util;
import com.didi.payment.base.widget.CommonEditText;
import com.didi.payment.commonsdk.fragment.WCommonAllBankListFragment;
import com.didi.payment.commonsdk.p129ui.AbsWBaseFragment;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.commonsdk.widget.WCommonAccountFieldView;
import com.didi.payment.commonsdk.widget.WCommonDataPicker;
import com.didi.payment.commonsdk.widget.WCommonOptionView;
import com.didi.payment.pix.net.response.PixBankOptionResp;
import com.didi.payment.pix.transfer.p141vm.model.BankAccountMetaData;
import com.didi.payment.pix.transfer.p141vm.model.PixBankOptionsVM;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.taxis99.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u00108\u001a\u0002092\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u0002092\u0006\u0010>\u001a\u00020\u0016H\u0016J\b\u0010?\u001a\u000209H\u0016J\b\u0010@\u001a\u000209H\u0016J\b\u0010A\u001a\u000203H\u0016J\u001a\u0010B\u001a\u0002092\u0006\u0010>\u001a\u00020\u00162\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\b\u0010E\u001a\u000209H\u0002J\b\u0010F\u001a\u000209H\u0002J\u0010\u0010G\u001a\u0002092\u0006\u0010H\u001a\u00020IH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u000bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\t\"\u0004\b+\u0010\u000bR\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u000203X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006J"}, mo175978d2 = {"Lcom/didi/payment/pix/transfer/fragment/PixNewBankAccountFragment;", "Lcom/didi/payment/commonsdk/ui/AbsWBaseFragment;", "Lcom/didi/payment/pix/transfer/vm/model/PixBankOptionsVM;", "()V", "accountTypeContainer", "Landroid/widget/LinearLayout;", "agencyField", "Lcom/didi/payment/commonsdk/widget/WCommonAccountFieldView;", "getAgencyField", "()Lcom/didi/payment/commonsdk/widget/WCommonAccountFieldView;", "setAgencyField", "(Lcom/didi/payment/commonsdk/widget/WCommonAccountFieldView;)V", "bankAccountField", "getBankAccountField", "setBankAccountField", "bankAccountMeta", "Lcom/didi/payment/pix/transfer/vm/model/BankAccountMetaData;", "getBankAccountMeta", "()Lcom/didi/payment/pix/transfer/vm/model/BankAccountMetaData;", "setBankAccountMeta", "(Lcom/didi/payment/pix/transfer/vm/model/BankAccountMetaData;)V", "bottomBtnLay", "Landroid/view/View;", "bottomBtnTv", "Landroid/widget/TextView;", "cfpField", "getCfpField", "setCfpField", "checkedAccountType", "Lcom/didi/payment/pix/net/response/PixBankOptionResp$AccountTypeEntry;", "dataPicker", "Lcom/didi/payment/commonsdk/widget/WCommonDataPicker;", "getDataPicker", "()Lcom/didi/payment/commonsdk/widget/WCommonDataPicker;", "setDataPicker", "(Lcom/didi/payment/commonsdk/widget/WCommonDataPicker;)V", "institutionField", "getInstitutionField", "setInstitutionField", "lastCheckOption", "Lcom/didi/payment/commonsdk/widget/WCommonOptionView;", "nameField", "getNameField", "setNameField", "pspList", "", "Lcom/didi/payment/pix/net/response/PixBankOptionResp$PspEntry;", "selectPspEntry", "selectedBank", "", "sourcePage", "", "getSourcePage", "()I", "setSourcePage", "(I)V", "fillBankInfo", "", "initCommonTitlebar", "commonTitleBar", "Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "initContentView", "view", "initViewModels", "onBackToFront", "onInflateLayout", "onViewCreated", "savedInstanceState", "Landroid/os/Bundle;", "parseArguments", "refreshConfirmBtn", "updateConfirmBtn", "enable", "", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixNewBankAccountFragment.kt */
public final class PixNewBankAccountFragment extends AbsWBaseFragment<PixBankOptionsVM> {

    /* renamed from: a */
    private PixBankOptionResp.AccountTypeEntry f31220a;
    public WCommonAccountFieldView agencyField;

    /* renamed from: b */
    private String f31221b;
    public WCommonAccountFieldView bankAccountField;

    /* renamed from: c */
    private PixBankOptionResp.PspEntry f31222c;
    public WCommonAccountFieldView cfpField;

    /* renamed from: d */
    private TextView f31223d;

    /* renamed from: e */
    private View f31224e;

    /* renamed from: f */
    private LinearLayout f31225f;

    /* renamed from: g */
    private WCommonOptionView f31226g;

    /* renamed from: h */
    private WCommonDataPicker f31227h = new WCommonDataPicker();

    /* renamed from: i */
    private int f31228i;
    public WCommonAccountFieldView institutionField;

    /* renamed from: j */
    private BankAccountMetaData f31229j;

    /* renamed from: k */
    private List<PixBankOptionResp.PspEntry> f31230k;
    public WCommonAccountFieldView nameField;

    public int onInflateLayout() {
        return R.layout.pix_new_bank_account_fragment;
    }

    public final WCommonAccountFieldView getNameField() {
        WCommonAccountFieldView wCommonAccountFieldView = this.nameField;
        if (wCommonAccountFieldView != null) {
            return wCommonAccountFieldView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nameField");
        return null;
    }

    public final void setNameField(WCommonAccountFieldView wCommonAccountFieldView) {
        Intrinsics.checkNotNullParameter(wCommonAccountFieldView, "<set-?>");
        this.nameField = wCommonAccountFieldView;
    }

    public final WCommonAccountFieldView getCfpField() {
        WCommonAccountFieldView wCommonAccountFieldView = this.cfpField;
        if (wCommonAccountFieldView != null) {
            return wCommonAccountFieldView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cfpField");
        return null;
    }

    public final void setCfpField(WCommonAccountFieldView wCommonAccountFieldView) {
        Intrinsics.checkNotNullParameter(wCommonAccountFieldView, "<set-?>");
        this.cfpField = wCommonAccountFieldView;
    }

    public final WCommonAccountFieldView getBankAccountField() {
        WCommonAccountFieldView wCommonAccountFieldView = this.bankAccountField;
        if (wCommonAccountFieldView != null) {
            return wCommonAccountFieldView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bankAccountField");
        return null;
    }

    public final void setBankAccountField(WCommonAccountFieldView wCommonAccountFieldView) {
        Intrinsics.checkNotNullParameter(wCommonAccountFieldView, "<set-?>");
        this.bankAccountField = wCommonAccountFieldView;
    }

    public final WCommonAccountFieldView getAgencyField() {
        WCommonAccountFieldView wCommonAccountFieldView = this.agencyField;
        if (wCommonAccountFieldView != null) {
            return wCommonAccountFieldView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("agencyField");
        return null;
    }

    public final void setAgencyField(WCommonAccountFieldView wCommonAccountFieldView) {
        Intrinsics.checkNotNullParameter(wCommonAccountFieldView, "<set-?>");
        this.agencyField = wCommonAccountFieldView;
    }

    public final WCommonAccountFieldView getInstitutionField() {
        WCommonAccountFieldView wCommonAccountFieldView = this.institutionField;
        if (wCommonAccountFieldView != null) {
            return wCommonAccountFieldView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("institutionField");
        return null;
    }

    public final void setInstitutionField(WCommonAccountFieldView wCommonAccountFieldView) {
        Intrinsics.checkNotNullParameter(wCommonAccountFieldView, "<set-?>");
        this.institutionField = wCommonAccountFieldView;
    }

    public final WCommonDataPicker getDataPicker() {
        return this.f31227h;
    }

    public final void setDataPicker(WCommonDataPicker wCommonDataPicker) {
        Intrinsics.checkNotNullParameter(wCommonDataPicker, "<set-?>");
        this.f31227h = wCommonDataPicker;
    }

    public final int getSourcePage() {
        return this.f31228i;
    }

    public final void setSourcePage(int i) {
        this.f31228i = i;
    }

    public final BankAccountMetaData getBankAccountMeta() {
        return this.f31229j;
    }

    public final void setBankAccountMeta(BankAccountMetaData bankAccountMetaData) {
        this.f31229j = bankAccountMetaData;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_search_bank_account_sw");
        FinOmegaSDK.trackEvent("ibt_drv_transfer_ted_detail_sw", ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        m21969a();
        ((PixBankOptionsVM) getVm()).loadData(this.f31228i);
    }

    /* renamed from: a */
    private final void m21974a(BankAccountMetaData bankAccountMetaData) {
        getNameField().setText(bankAccountMetaData.getPayeeName());
        getCfpField().setText(bankAccountMetaData.getCpf());
        getBankAccountField().setText(bankAccountMetaData.getCardNo());
        getAgencyField().setText(bankAccountMetaData.getAgency());
        PixBankOptionResp.PspEntry pspEntry = new PixBankOptionResp.PspEntry();
        this.f31222c = pspEntry;
        if (pspEntry != null) {
            pspEntry.setPspId(bankAccountMetaData.getPspId());
        }
        PixBankOptionResp.PspEntry pspEntry2 = this.f31222c;
        if (pspEntry2 != null) {
            pspEntry2.setName("");
        }
        List<PixBankOptionResp.PspEntry> list = this.f31230k;
        String str = null;
        if (list != null) {
            Iterator<PixBankOptionResp.PspEntry> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PixBankOptionResp.PspEntry next = it.next();
                PixBankOptionResp.PspEntry pspEntry3 = this.f31222c;
                if (Intrinsics.areEqual((Object) pspEntry3 == null ? null : pspEntry3.getPspId(), (Object) next.getPspId())) {
                    PixBankOptionResp.PspEntry pspEntry4 = this.f31222c;
                    if (pspEntry4 != null) {
                        pspEntry4.setName(next.getName());
                    }
                }
            }
        }
        WCommonAccountFieldView institutionField2 = getInstitutionField();
        PixBankOptionResp.PspEntry pspEntry5 = this.f31222c;
        if (pspEntry5 != null) {
            str = pspEntry5.getName();
        }
        institutionField2.setText(str);
        m21976b();
    }

    /* renamed from: a */
    private final void m21969a() {
        Serializable serializable;
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey("source")) {
                String string = arguments.getString("source");
                CharSequence charSequence = string;
                if (!(charSequence == null || charSequence.length() == 0) && TextUtils.isDigitsOnly(charSequence)) {
                    setSourcePage(Integer.parseInt(string));
                }
            }
            if (arguments.containsKey("bank_metadata") && (serializable = arguments.getSerializable("bank_metadata")) != null) {
                setBankAccountMeta((BankAccountMetaData) serializable);
            }
        }
    }

    public void initViewModels() {
        super.initViewModels();
        ViewModel viewModel = new ViewModelProvider(this).get(PixBankOptionsVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…ankOptionsVM::class.java)");
        setVm((WBaseViewModel) viewModel);
        subscribeUi(getVm());
        ((PixBankOptionsVM) getVm()).getBankOptionsLiveData().observe(this, new Observer() {
            public final void onChanged(Object obj) {
                PixNewBankAccountFragment.m21972a(PixNewBankAccountFragment.this, (PixBankOptionResp.DataEntry) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21972a(PixNewBankAccountFragment pixNewBankAccountFragment, PixBankOptionResp.DataEntry dataEntry) {
        Intrinsics.checkNotNullParameter(pixNewBankAccountFragment, "this$0");
        pixNewBankAccountFragment.f31230k = dataEntry.getPspList();
        PixBankOptionResp.LastHistory lastHistory = dataEntry.getLastHistory();
        int i = 0;
        LinearLayout linearLayout = null;
        if (lastHistory != null && lastHistory.valid()) {
            pixNewBankAccountFragment.getNameField().setText(lastHistory.getName());
            pixNewBankAccountFragment.getCfpField().setText(lastHistory.getCpf());
            pixNewBankAccountFragment.getBankAccountField().setText(lastHistory.getAccountId());
            pixNewBankAccountFragment.getAgencyField().setText(lastHistory.getAgency());
            PixBankOptionResp.PspEntry pspEntry = new PixBankOptionResp.PspEntry();
            pixNewBankAccountFragment.f31222c = pspEntry;
            if (pspEntry != null) {
                pspEntry.setPspId(lastHistory.getPspId());
            }
            PixBankOptionResp.PspEntry pspEntry2 = pixNewBankAccountFragment.f31222c;
            if (pspEntry2 != null) {
                pspEntry2.setName("");
            }
            List<PixBankOptionResp.PspEntry> list = pixNewBankAccountFragment.f31230k;
            if (list != null) {
                Iterator<PixBankOptionResp.PspEntry> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PixBankOptionResp.PspEntry next = it.next();
                    String pspId = next.getPspId();
                    PixBankOptionResp.PspEntry pspEntry3 = pixNewBankAccountFragment.f31222c;
                    if (Intrinsics.areEqual((Object) pspId, (Object) pspEntry3 == null ? null : pspEntry3.getPspId())) {
                        PixBankOptionResp.PspEntry pspEntry4 = pixNewBankAccountFragment.f31222c;
                        if (pspEntry4 != null) {
                            pspEntry4.setName(next.getName());
                        }
                    }
                }
            }
            WCommonAccountFieldView institutionField2 = pixNewBankAccountFragment.getInstitutionField();
            PixBankOptionResp.PspEntry pspEntry5 = pixNewBankAccountFragment.f31222c;
            institutionField2.setText(pspEntry5 == null ? null : pspEntry5.getName());
            if ((lastHistory.getAccountType().length() > 0) && TextUtils.isDigitsOnly(lastHistory.getAccountType())) {
                PixBankOptionResp.AccountTypeEntry accountTypeEntry = new PixBankOptionResp.AccountTypeEntry();
                pixNewBankAccountFragment.f31220a = accountTypeEntry;
                if (accountTypeEntry != null) {
                    accountTypeEntry.setTypeId(Integer.parseInt(lastHistory.getAccountType()));
                }
            }
            pixNewBankAccountFragment.m21976b();
        }
        LinearLayout linearLayout2 = pixNewBankAccountFragment.f31225f;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountTypeContainer");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.removeAllViews();
        int size = dataEntry.getAccountTypes().size() - 1;
        if (size >= 0) {
            while (true) {
                int i2 = i + 1;
                PixBankOptionResp.AccountTypeEntry accountTypeEntry2 = dataEntry.getAccountTypes().get(i);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                WCommonOptionView wCommonOptionView = new WCommonOptionView(pixNewBankAccountFragment.getContext());
                wCommonOptionView.setOptionName(accountTypeEntry2.getName());
                wCommonOptionView.setOnClickListener(new View.OnClickListener(accountTypeEntry2) {
                    public final /* synthetic */ PixBankOptionResp.AccountTypeEntry f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        PixNewBankAccountFragment.m21971a(PixNewBankAccountFragment.this, this.f$1, view);
                    }
                });
                PixBankOptionResp.AccountTypeEntry accountTypeEntry3 = pixNewBankAccountFragment.f31220a;
                if (accountTypeEntry3 != null) {
                    if (accountTypeEntry2.getTypeId() == accountTypeEntry3.getTypeId()) {
                        PixBankOptionResp.AccountTypeEntry accountTypeEntry4 = pixNewBankAccountFragment.f31220a;
                        if (accountTypeEntry4 != null) {
                            accountTypeEntry4.setName(accountTypeEntry2.getName());
                        }
                        wCommonOptionView.setChecked(true);
                        pixNewBankAccountFragment.f31226g = wCommonOptionView;
                        wCommonOptionView.setSelected(true);
                    }
                    pixNewBankAccountFragment.m21976b();
                }
                linearLayout.addView(wCommonOptionView, layoutParams);
                if (i2 > size) {
                    break;
                }
                i = i2;
            }
        }
        BankAccountMetaData bankAccountMeta = pixNewBankAccountFragment.getBankAccountMeta();
        if (bankAccountMeta != null) {
            pixNewBankAccountFragment.m21974a(bankAccountMeta);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21971a(PixNewBankAccountFragment pixNewBankAccountFragment, PixBankOptionResp.AccountTypeEntry accountTypeEntry, View view) {
        Intrinsics.checkNotNullParameter(pixNewBankAccountFragment, "this$0");
        Intrinsics.checkNotNullParameter(accountTypeEntry, "$typeItem");
        if (!view.isSelected()) {
            if (view != null) {
                WCommonOptionView wCommonOptionView = (WCommonOptionView) view;
                wCommonOptionView.setChecked(true);
                wCommonOptionView.setSelected(true);
                pixNewBankAccountFragment.f31220a = accountTypeEntry;
                WCommonOptionView wCommonOptionView2 = pixNewBankAccountFragment.f31226g;
                if (wCommonOptionView2 != null) {
                    wCommonOptionView2.setChecked(false);
                }
                WCommonOptionView wCommonOptionView3 = pixNewBankAccountFragment.f31226g;
                if (wCommonOptionView3 != null) {
                    wCommonOptionView3.setSelected(false);
                }
                pixNewBankAccountFragment.f31226g = wCommonOptionView;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.didi.payment.commonsdk.widget.WCommonOptionView");
            }
        } else if (view != null) {
            WCommonOptionView wCommonOptionView4 = (WCommonOptionView) view;
            wCommonOptionView4.setChecked(false);
            wCommonOptionView4.setSelected(false);
            pixNewBankAccountFragment.f31220a = null;
            pixNewBankAccountFragment.f31226g = null;
        } else {
            throw new NullPointerException("null cannot be cast to non-null type com.didi.payment.commonsdk.widget.WCommonOptionView");
        }
        pixNewBankAccountFragment.m21976b();
    }

    public void initContentView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.initContentView(view);
        $$Lambda$PixNewBankAccountFragment$9QBx4IFcDozhhyqLgIDvLgK59o4 r0 = new CommonEditText.OnTextChangeListener() {
            public final void onTextChanged(String str) {
                PixNewBankAccountFragment.m21973a(PixNewBankAccountFragment.this, str);
            }
        };
        View findViewById = view.findViewById(R.id.pix_account_name);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.pix_account_name)");
        setNameField((WCommonAccountFieldView) findViewById);
        getNameField().setOnTextChangeListener(r0);
        getNameField().setLabel(getString(R.string.GRider_payment_Name_EUpZ));
        View findViewById2 = view.findViewById(R.id.pix_account_cpf);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.pix_account_cpf)");
        setCfpField((WCommonAccountFieldView) findViewById2);
        getCfpField().setLabel(getString(R.string.GRider_payment_CPF_gyTA));
        getCfpField().setMaxLength(11);
        getCfpField().setEditType(CommonEditText.TYPE.CARD_NUMBER);
        getCfpField().setOnTextChangeListener(r0);
        View findViewById3 = view.findViewById(R.id.pix_field_bankaccount);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.pix_field_bankaccount)");
        setBankAccountField((WCommonAccountFieldView) findViewById3);
        getBankAccountField().setLabel(getString(R.string.GRider_payment_Bank_accounts_AZvO));
        getBankAccountField().setEditType(CommonEditText.TYPE.CARD_NUMBER);
        getBankAccountField().setMaxLength(14);
        getBankAccountField().setOnTextChangeListener(r0);
        View findViewById4 = view.findViewById(R.id.pix_account_agencycode);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.pix_account_agencycode)");
        setAgencyField((WCommonAccountFieldView) findViewById4);
        getAgencyField().setLabel(getString(R.string.GRider_payment_Acting_YIYJ));
        getAgencyField().setMaxLength(4);
        getAgencyField().setEditType(CommonEditText.TYPE.CARD_NUMBER);
        getAgencyField().setOnTextChangeListener(r0);
        View findViewById5 = view.findViewById(R.id.pix_institution);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.pix_institution)");
        setInstitutionField((WCommonAccountFieldView) findViewById5);
        getInstitutionField().setLabel(getString(R.string.GRider_payment_Banking_institutions_UIbF));
        getInstitutionField().setExpandImg(R.drawable.pix_key_list_arrow_right_icon);
        getInstitutionField().switchType(false);
        getInstitutionField().enableExpandFunc();
        getInstitutionField().setOnTextChangeListener(r0);
        getInstitutionField().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixNewBankAccountFragment.m21970a(PixNewBankAccountFragment.this, view);
            }
        });
        View findViewById6 = view.findViewById(R.id.pix_account_type_container);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.pix_account_type_container)");
        this.f31225f = (LinearLayout) findViewById6;
        View findViewById7 = view.findViewById(R.id.page_bottom_floating_btn_lay);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.p…_bottom_floating_btn_lay)");
        this.f31224e = findViewById7;
        View findViewById8 = view.findViewById(R.id.retry_btn_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.retry_btn_tv)");
        TextView textView = (TextView) findViewById8;
        this.f31223d = textView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBtnTv");
            textView = null;
        }
        textView.setText(getString(R.string.GRider_payment_Continue_TUku));
        TextView textView3 = this.f31223d;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBtnTv");
        } else {
            textView2 = textView3;
        }
        textView2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixNewBankAccountFragment.m21977b(PixNewBankAccountFragment.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21973a(PixNewBankAccountFragment pixNewBankAccountFragment, String str) {
        Intrinsics.checkNotNullParameter(pixNewBankAccountFragment, "this$0");
        pixNewBankAccountFragment.m21976b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21970a(PixNewBankAccountFragment pixNewBankAccountFragment, View view) {
        Intrinsics.checkNotNullParameter(pixNewBankAccountFragment, "this$0");
        List<PixBankOptionResp.PspEntry> list = pixNewBankAccountFragment.f31230k;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            int size = list.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i2 = i + 1;
                    arrayList.add(list.get(i).getName());
                    if (i2 > size) {
                        break;
                    }
                    i = i2;
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString("source_page", pixNewBankAccountFragment.getTag());
            bundle.putStringArrayList("bank_list", arrayList);
            pixNewBankAccountFragment.forwardNextPage(WCommonAllBankListFragment.class, bundle);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m21977b(PixNewBankAccountFragment pixNewBankAccountFragment, View view) {
        boolean z;
        Intrinsics.checkNotNullParameter(pixNewBankAccountFragment, "this$0");
        Bundle bundle = new Bundle();
        BankAccountMetaData bankAccountMetaData = new BankAccountMetaData();
        String inputValue = pixNewBankAccountFragment.getNameField().getInputValue();
        Intrinsics.checkNotNullExpressionValue(inputValue, "nameField.inputValue");
        bankAccountMetaData.setPayeeName(inputValue);
        String inputValue2 = pixNewBankAccountFragment.getCfpField().getInputValue();
        Intrinsics.checkNotNullExpressionValue(inputValue2, "cfpField.inputValue");
        bankAccountMetaData.setCpf(inputValue2);
        String inputValue3 = pixNewBankAccountFragment.getBankAccountField().getInputValue();
        Intrinsics.checkNotNullExpressionValue(inputValue3, "bankAccountField.inputValue");
        bankAccountMetaData.setCardNo(inputValue3);
        String inputValue4 = pixNewBankAccountFragment.getAgencyField().getInputValue();
        Intrinsics.checkNotNullExpressionValue(inputValue4, "agencyField.inputValue");
        bankAccountMetaData.setAgency(inputValue4);
        PixBankOptionResp.AccountTypeEntry accountTypeEntry = pixNewBankAccountFragment.f31220a;
        String str = null;
        Integer valueOf = accountTypeEntry == null ? null : Integer.valueOf(accountTypeEntry.getTypeId());
        Intrinsics.checkNotNull(valueOf);
        bankAccountMetaData.setAccountType(valueOf.intValue());
        String md5 = MD5Util.md5(bankAccountMetaData.getCpf());
        if (md5 == null) {
            z = false;
        } else {
            PixBankOptionResp.DataEntry value = ((PixBankOptionsVM) pixNewBankAccountFragment.getVm()).getBankOptionsLiveData().getValue();
            if (value != null) {
                str = value.getSecretText();
            }
            z = StringsKt.equals(md5, str, true);
        }
        bankAccountMetaData.setSameCpf(z);
        String inputValue5 = pixNewBankAccountFragment.getCfpField().getInputValue();
        Intrinsics.checkNotNullExpressionValue(inputValue5, "cfpField.inputValue");
        bankAccountMetaData.setCpf4Display(inputValue5);
        PixBankOptionResp.PspEntry pspEntry = pixNewBankAccountFragment.f31222c;
        if (pspEntry != null) {
            bankAccountMetaData.setPspId(pspEntry.getPspId());
            bankAccountMetaData.setPspName(pspEntry.getName());
        }
        FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_search_bank_account_confirm_ck", "cpf_number", bankAccountMetaData.getCpf());
        FinOmegaSDK.trackEvent("ibt_drv_transfer_ted_detail_ck", ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        bundle.putSerializable("bank_metadata", bankAccountMetaData);
        bundle.putString("source_page", "new_bank_info");
        pixNewBankAccountFragment.forwardNextPage(PixTransferAmountEditFragment.class, bundle);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0090, code lost:
        if ((r0 != null && r0.getTypeId() == 0) == false) goto L_0x0094;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m21976b() {
        /*
            r4 = this;
            com.didi.payment.commonsdk.widget.WCommonAccountFieldView r0 = r4.getNameField()
            java.lang.String r0 = r0.getInputValue()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0093
            com.didi.payment.commonsdk.widget.WCommonAccountFieldView r0 = r4.getCfpField()
            java.lang.String r0 = r0.getInputValue()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0093
            com.didi.payment.commonsdk.widget.WCommonAccountFieldView r0 = r4.getCfpField()
            java.lang.String r0 = r0.getInputValue()
            int r0 = r0.length()
            r3 = 11
            if (r0 < r3) goto L_0x0093
            com.didi.payment.commonsdk.widget.WCommonAccountFieldView r0 = r4.getBankAccountField()
            java.lang.String r0 = r0.getInputValue()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0093
            com.didi.payment.commonsdk.widget.WCommonAccountFieldView r0 = r4.getBankAccountField()
            java.lang.String r0 = r0.getInputValue()
            int r0 = r0.length()
            r3 = 14
            if (r0 > r3) goto L_0x0093
            com.didi.payment.commonsdk.widget.WCommonAccountFieldView r0 = r4.getAgencyField()
            java.lang.String r0 = r0.getInputValue()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0093
            com.didi.payment.commonsdk.widget.WCommonAccountFieldView r0 = r4.getAgencyField()
            java.lang.String r0 = r0.getInputValue()
            int r0 = r0.length()
            r3 = 4
            if (r0 < r3) goto L_0x0093
            com.didi.payment.commonsdk.widget.WCommonAccountFieldView r0 = r4.getInstitutionField()
            java.lang.String r0 = r0.getInputValue()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0093
            com.didi.payment.pix.net.response.PixBankOptionResp$AccountTypeEntry r0 = r4.f31220a
            if (r0 == 0) goto L_0x0093
            if (r0 != 0) goto L_0x0089
        L_0x0087:
            r0 = 0
            goto L_0x0090
        L_0x0089:
            int r0 = r0.getTypeId()
            if (r0 != 0) goto L_0x0087
            r0 = 1
        L_0x0090:
            if (r0 != 0) goto L_0x0093
            goto L_0x0094
        L_0x0093:
            r1 = 0
        L_0x0094:
            r4.m21975a((boolean) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.pix.transfer.fragment.PixNewBankAccountFragment.m21976b():void");
    }

    /* renamed from: a */
    private final void m21975a(boolean z) {
        TextView textView = this.f31223d;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBtnTv");
            textView = null;
        }
        textView.setEnabled(z);
    }

    public void initCommonTitlebar(CommonTitleBar commonTitleBar) {
        Intrinsics.checkNotNullParameter(commonTitleBar, "commonTitleBar");
        super.initCommonTitlebar(commonTitleBar);
        commonTitleBar.setTitle((int) R.string.CS_payment_PIX_Transfer_Onrd);
        View findViewById = commonTitleBar.findViewById(R.id.title_bar_layout_above);
        if (findViewById != null) {
            findViewById.setBackgroundColor(0);
        }
        ImageView leftImgView = commonTitleBar.getLeftImgView();
        if (leftImgView != null) {
            leftImgView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    PixNewBankAccountFragment.m21978c(PixNewBankAccountFragment.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m21978c(PixNewBankAccountFragment pixNewBankAccountFragment, View view) {
        Intrinsics.checkNotNullParameter(pixNewBankAccountFragment, "this$0");
        pixNewBankAccountFragment.backToPrePage((Bundle) null);
    }

    public void onBackToFront() {
        List<PixBankOptionResp.PspEntry> list;
        super.onBackToFront();
        Bundle arguments = getArguments();
        String string = arguments == null ? null : arguments.getString("selected_bank", "");
        if (string != null && (list = this.f31230k) != null) {
            Iterator<PixBankOptionResp.PspEntry> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PixBankOptionResp.PspEntry next = it.next();
                if (Intrinsics.areEqual((Object) next.getName(), (Object) string)) {
                    this.f31222c = next;
                    break;
                }
            }
        }
        PixBankOptionResp.PspEntry pspEntry = this.f31222c;
        if (pspEntry != null) {
            getInstitutionField().setText(pspEntry.getName());
            m21976b();
        }
    }
}
