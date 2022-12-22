package com.didi.payment.transfer.newaccount;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.event.PayEventPublisher;
import com.didi.payment.base.widget.CommonEditText;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.transfer.common.PayEventKeys;
import com.didi.payment.transfer.common.TransBaseFragment;
import com.didi.payment.transfer.common.model.TransBankInfo;
import com.didi.payment.transfer.constants.TransferContants;
import com.didi.payment.transfer.newaccount.TransBankAccountTypeResp;
import com.didi.payment.transfer.newaccount.presenter.ITransNewAccountPresenter;
import com.didi.payment.transfer.newaccount.presenter.TransNewAccountPresenter;
import com.didi.payment.transfer.newaccount.task.LoadJsonDataTask;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.transfer.utils.TransOmegaUtil;
import com.didi.payment.transfer.widget.TransAccountFieldView;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.sdk.view.SimpleWheelPopup;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TransNewAccountFragment extends TransBaseFragment<ITransNewAccountPresenter> implements INewAccountPageView, LoadJsonDataTask.IViewCallback {

    /* renamed from: a */
    private final int f31410a = 1;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TransAccountFieldView f31411b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TransAccountFieldView f31412c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TransAccountFieldView f31413d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TransAccountFieldView f31414e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TransAccountFieldView f31415f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TransAccountFieldView f31416g;

    /* renamed from: h */
    private ConstraintLayout f31417h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public TextView f31418i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public LoadJsonDataTask f31419j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Trans2BankModel f31420k = new Trans2BankModel();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public BankDataModel f31421l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f31422m = false;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public ArrayList<TransBankAccountTypeResp.AccountType> f31423n;

    /* renamed from: o */
    private CommonEditText.OnTextChangeListener f31424o = new CommonEditText.OnTextChangeListener() {
        public void onTextChanged(String str) {
            if (TransNewAccountFragment.this.f31422m) {
                if (TransNewAccountFragment.this.f31412c.unMaskInput().length() == 11) {
                    if (TransNewAccountFragment.this.f31412c.isCPFValidInput()) {
                        TransNewAccountFragment.this.f31412c.hideErrorInfo();
                    } else {
                        TransNewAccountFragment.this.f31412c.showErrorInfo(TransNewAccountFragment.this.getString(R.string.Fintech_Payment_verification_CPF_is_gzeF));
                    }
                }
                if (TransNewAccountFragment.this.f31413d.unMaskInput().length() == 4) {
                    TransNewAccountFragment.this.f31413d.hideErrorInfo();
                }
            }
            TransNewAccountFragment.this.f31418i.setEnabled(TransNewAccountFragment.this.m22182b());
        }
    };

    /* renamed from: p */
    private TransAccountFieldView.onLoseFocusListener f31425p = new TransAccountFieldView.onLoseFocusListener() {
        public void onLoseFocus(TransAccountFieldView transAccountFieldView) {
            if (transAccountFieldView.getId() == R.id.trans_account_cpf) {
                if (TransNewAccountFragment.this.f31412c.unMaskInput().length() < 11) {
                    TransNewAccountFragment.this.f31412c.showErrorInfo(TransNewAccountFragment.this.getString(R.string.GRider_PAX_Enter_11_wxDm));
                } else if (!TransNewAccountFragment.this.f31412c.isCPFValidInput()) {
                    TransNewAccountFragment.this.f31412c.showErrorInfo(TransNewAccountFragment.this.getString(R.string.Fintech_Payment_verification_CPF_is_gzeF));
                } else if (TransNewAccountFragment.this.f31412c.isCPFValidInput()) {
                    TransNewAccountFragment.this.f31412c.hideErrorInfo();
                }
            } else if (transAccountFieldView.getId() != R.id.trans_account_agentcode) {
            } else {
                if (TransNewAccountFragment.this.f31413d.isAgencyCodeValidInput()) {
                    TransNewAccountFragment.this.f31413d.hideErrorInfo();
                } else {
                    TransNewAccountFragment.this.f31413d.showErrorInfo(TransNewAccountFragment.this.getString(R.string.GRider_PAX_Enter_4_kgPI));
                }
            }
        }
    };

    /* renamed from: q */
    private PayEventPublisher.OnEventListener<String> f31426q = new PayEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            if (TransNewAccountFragment.this.f31421l != null && !CollectionUtil.isEmpty((Map<?, ?>) TransNewAccountFragment.this.f31421l.fullValues) && TransNewAccountFragment.this.f31421l.fullValues.containsKey(str2)) {
                TransBankInfo transBankInfo = TransNewAccountFragment.this.f31421l.fullValues.get(str2);
                TransNewAccountFragment.this.f31415f.setText(transBankInfo.name);
                TransNewAccountFragment.this.f31420k.toBankCode = (String) transBankInfo.value;
            }
        }
    };

    /* renamed from: r */
    private Trans2BankModel f31427r = null;

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.trans_addnew_account_lay;
    }

    public void showSuggestBankDialog() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m22178a();
    }

    /* renamed from: a */
    private void m22178a() {
        if (getArguments() != null) {
            this.f31422m = getArguments().containsKey(TransferContants.IntentKey.INTENT_PARAMS_KEY_2BANK_NEW_VERSION) && getArguments().getBoolean(TransferContants.IntentKey.INTENT_PARAMS_KEY_2BANK_NEW_VERSION);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m22182b() {
        if (this.f31422m) {
            if (!this.f31411b.isValidInput() || !this.f31412c.isCPFValidInput() || !this.f31414e.isValidInput() || !this.f31415f.isValidInput() || !this.f31413d.isAgencyCodeValidInput() || !this.f31416g.isValidInput()) {
                return false;
            }
            return true;
        } else if (!this.f31411b.isValidInput() || !this.f31412c.isValidInput() || !this.f31414e.isValidInput() || !this.f31415f.isValidInput() || !this.f31413d.isValidInput() || !this.f31416g.isValidInput()) {
            return false;
        } else {
            return true;
        }
    }

    public void registeEventListeners() {
        PayEventPublisher.getPublisher().subscribe("selected_bank_data", this.f31426q);
    }

    public void unregisteEventListeners() {
        PayEventPublisher.getPublisher().unsubscribe("selected_bank_data", this.f31426q);
    }

    /* access modifiers changed from: protected */
    public ITransNewAccountPresenter onCreatePresenter() {
        return new TransNewAccountPresenter(getActivity(), this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        m22184c();
        return onCreateView;
    }

    /* renamed from: c */
    private void m22184c() {
        if (getArguments() != null && getArguments().containsKey("pix_transfer")) {
            Bundle arguments = getArguments();
            Trans2BankModel trans2BankModel = new Trans2BankModel();
            this.f31427r = trans2BankModel;
            trans2BankModel.toName = arguments.getString("name", "");
            this.f31427r.toCPF = arguments.getString("cpf", "");
            this.f31427r.toBankName = arguments.getString("bank_name", "");
            this.f31427r.toBankCode = arguments.getString("bank_code", "");
            this.f31427r.toBankCard = arguments.getString("bank_card", "");
            this.f31427r.toAgentCode = arguments.getString("agent_code", "");
            m22179a(this.f31427r);
        }
    }

    /* renamed from: a */
    private void m22179a(Trans2BankModel trans2BankModel) {
        this.f31411b.setText(trans2BankModel.toName);
        this.f31412c.setText(trans2BankModel.toCPF);
        this.f31415f.setText(trans2BankModel.toBankName);
        this.f31414e.setText(trans2BankModel.toBankCard);
        this.f31413d.setText(trans2BankModel.toAgentCode);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TransOmegaUtil.trackEventWithGlobal("ibt_didipay_p2p_bank_account_new_account_sw", TransGlobalOmegaKey.KEY_WALLET_PAGEID, TransGlobalOmegaKey.KEY_ACCOUNT_STATUS);
    }

    /* access modifiers changed from: protected */
    public void initViews(View view) {
        super.initViews(view);
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.f31417h = (ConstraintLayout) view.findViewById(R.id.containerView);
        TransAccountFieldView transAccountFieldView = (TransAccountFieldView) view.findViewById(R.id.trans_account_name);
        this.f31411b = transAccountFieldView;
        transAccountFieldView.setMaxLength(150);
        TransAccountFieldView transAccountFieldView2 = (TransAccountFieldView) view.findViewById(R.id.trans_account_cpf);
        this.f31412c = transAccountFieldView2;
        transAccountFieldView2.setType(CommonEditText.TYPE.CARD_NUMBER);
        TransAccountFieldView transAccountFieldView3 = (TransAccountFieldView) view.findViewById(R.id.trans_field_bankname);
        this.f31415f = transAccountFieldView3;
        transAccountFieldView3.getInputET().setSingleLine();
        this.f31415f.setEnableExpand(true);
        TransAccountFieldView transAccountFieldView4 = (TransAccountFieldView) view.findViewById(R.id.trans_field_banktype);
        this.f31416g = transAccountFieldView4;
        transAccountFieldView4.getInputET().setSingleLine();
        this.f31416g.setEnableExpand(true);
        TransAccountFieldView transAccountFieldView5 = (TransAccountFieldView) view.findViewById(R.id.trans_field_bankaccount);
        this.f31414e = transAccountFieldView5;
        transAccountFieldView5.setType(CommonEditText.TYPE.CARD_NUMBER);
        TransAccountFieldView transAccountFieldView6 = (TransAccountFieldView) view.findViewById(R.id.trans_account_agentcode);
        this.f31413d = transAccountFieldView6;
        transAccountFieldView6.setType(CommonEditText.TYPE.CARD_NUMBER);
        this.f31413d.setMaxLength(4);
        this.f31413d.getInputET().setFocusable(true);
        this.f31413d.getInputET().setFocusableInTouchMode(true);
        this.f31411b.setLabel(getString(R.string.GRider_PAX_Name_NVSg), "");
        this.f31414e.getInputET().setFocusable(true);
        this.f31414e.getInputET().setFocusableInTouchMode(true);
        this.f31411b.setOnTextChangeListener(this.f31424o);
        this.f31412c.setOnTextChangeListener(this.f31424o);
        this.f31413d.setOnTextChangeListener(this.f31424o);
        this.f31414e.setOnTextChangeListener(this.f31424o);
        this.f31415f.getInputET().setFocusableInTouchMode(false);
        this.f31415f.setOnTextChangeListener(this.f31424o);
        this.f31416g.getInputET().setFocusableInTouchMode(false);
        this.f31416g.setOnTextChangeListener(this.f31424o);
        this.f31416g.setLabel(getString(R.string.Fintech_Payment_type_Account_Type_yTPI), getString(R.string.Fintech_Payment_type_Select_Account_lwkQ));
        if (this.f31422m) {
            this.f31412c.setMaxLength(14);
            this.f31414e.setMaxLength(17);
            this.f31412c.setLabel(getString(R.string.GRider_PAX_CPF_fMMn), "000.000.000-00");
            this.f31413d.setLabel(getString(R.string.GRider_PAX_Agency_code_IfjA), "0000");
            this.f31414e.setLabel(getString(R.string.GRider_PAX_Bank_accounts_JfbH), getString(R.string.Fintech_Payment_verification2_Fill_in_FYtt));
            this.f31415f.setLabel(getString(R.string.GRider_PAX_Name_of_mjpR), getString(R.string.Fintech_Payment_verification2_Select_Bank_jTYP));
            this.f31414e.addBankCardInputListener();
            this.f31412c.addCPFCardInputListener();
            this.f31412c.setLoseFocusListener(this.f31425p);
            this.f31413d.setLoseFocusListener(this.f31425p);
            this.f31414e.setLoseFocusListener(this.f31425p);
        } else {
            this.f31412c.setMaxLength(11);
            this.f31414e.setMaxLength(14);
            this.f31412c.setLabel(getString(R.string.GRider_PAX_CPF_fMMn), getString(R.string.GRider_PAX_Enter_11_wxDm));
            this.f31413d.setLabel(getString(R.string.GRider_PAX_Agency_code_IfjA), getString(R.string.GRider_PAX_Enter_4_kgPI));
            this.f31415f.setLabel(getString(R.string.GRider_PAX_Name_of_mjpR), getString(R.string.GRider_PAX_Enter_the_xPSI));
            this.f31414e.setLabel(getString(R.string.GRider_PAX_Bank_accounts_JfbH), "");
        }
        this.f31415f.setOnExpandListener(new TransAccountFieldView.OnExpandListener() {
            public void onExpandIconClick() {
                Bundle bundle = new Bundle();
                bundle.putString("last_option", TransNewAccountFragment.this.getContext().getString(R.string.GRider_PAX_Choosing_Other_uGBd));
                LoadJsonDataTask unused = TransNewAccountFragment.this.f31419j = new LoadJsonDataTask(TransNewAccountFragment.this.getActivity(), TransNewAccountFragment.this, bundle);
                TransNewAccountFragment.this.f31419j.execute(new String[]{TransferContants.BankData.STATIC_BANK_JSON_FILE});
                TransNewAccountFragment.this.m22185d();
            }
        });
        this.f31415f.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("last_option", TransNewAccountFragment.this.getContext().getString(R.string.GRider_PAX_Choosing_Other_uGBd));
                LoadJsonDataTask unused = TransNewAccountFragment.this.f31419j = new LoadJsonDataTask(TransNewAccountFragment.this.getActivity(), TransNewAccountFragment.this, bundle);
                TransNewAccountFragment.this.f31419j.execute(new String[]{TransferContants.BankData.STATIC_BANK_JSON_FILE});
                TransNewAccountFragment.this.m22185d();
            }
        });
        this.f31416g.setOnExpandListener(new TransAccountFieldView.OnExpandListener() {
            public void onExpandIconClick() {
                TransNewAccountFragment.this.showAccountTypeDialog();
                TransNewAccountFragment.this.m22185d();
            }
        });
        this.f31416g.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                TransNewAccountFragment.this.showAccountTypeDialog();
                TransNewAccountFragment.this.m22185d();
            }
        });
        TextView textView = (TextView) view.findViewById(R.id.trans_newaccount_confirm_btn);
        this.f31418i = textView;
        textView.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                TransOmegaUtil.trackEvent("ibt_didipay_p2p_bank_account_new_account_confirm_ck", TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, TransGlobalOmegaKey.KEY_WALLET_PAGEID);
                TransNewAccountFragment.this.f31420k.toName = TransNewAccountFragment.this.f31411b.getInputValue();
                TransNewAccountFragment.this.f31420k.toCPF = TransNewAccountFragment.this.f31412c.unMaskInput();
                TransNewAccountFragment.this.f31420k.toBankName = TransNewAccountFragment.this.f31415f.getInputValue();
                TransNewAccountFragment.this.f31420k.toBankCard = TransNewAccountFragment.this.f31414e.unMaskInput();
                try {
                    TransNewAccountFragment.this.f31420k.toAgentCode = TransNewAccountFragment.this.f31413d.getInputValue();
                } catch (Exception unused) {
                    ToastHelper.showShortInfo(TransNewAccountFragment.this.getContext(), "Invalid input agency code");
                }
                PayEventPublisher.getPublisher().publish(PayEventKeys.FragmentForward.EVENT_FORWARD_TO_CONFIRM_TRANAMOUNT, TransNewAccountFragment.this.f31420k);
            }
        });
    }

    public void showAccountTypeDialog() {
        if (this.f31423n != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<TransBankAccountTypeResp.AccountType> it = this.f31423n.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().key);
            }
            final SimpleWheelPopup simpleWheelPopup = new SimpleWheelPopup();
            simpleWheelPopup.setTitle(getString(R.string.Fintech_Payment_type_Select_Account_lwkQ));
            simpleWheelPopup.setRightText(getString(R.string.GRider_PAX_Confirmation_YVVM));
            simpleWheelPopup.setWheelData((List<String>) arrayList);
            simpleWheelPopup.setOnSelectListener(new SimpleWheelPopup.OnSelectListener() {
                public void onSelect(int i, Object obj) {
                    int selectedIndex = simpleWheelPopup.getSelectedIndex();
                    TransNewAccountFragment.this.f31416g.setText(((TransBankAccountTypeResp.AccountType) TransNewAccountFragment.this.f31423n.get(selectedIndex)).key);
                    TransNewAccountFragment.this.f31420k.toAccountType = ((TransBankAccountTypeResp.AccountType) TransNewAccountFragment.this.f31423n.get(selectedIndex)).key;
                    TransNewAccountFragment.this.f31420k.toAccountTypeValue = String.valueOf(((TransBankAccountTypeResp.AccountType) TransNewAccountFragment.this.f31423n.get(selectedIndex)).value);
                }
            });
            simpleWheelPopup.show(getFragmentManager(), "account_type_fragment");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m22185d() {
        this.f31411b.getInputET().clearFocus();
        this.f31412c.getInputET().clearFocus();
        this.f31413d.getInputET().clearFocus();
        this.f31414e.getInputET().clearFocus();
    }

    public void onBankDataLoaded(final BankDataModel bankDataModel) {
        if (getContext() != null && isVisible()) {
            this.f31421l = bankDataModel;
            final SimpleWheelPopup simpleWheelPopup = new SimpleWheelPopup();
            simpleWheelPopup.setTitle(getString(R.string.GRider_PAX_Select_the_LXxn));
            simpleWheelPopup.setRightText(getString(R.string.GRider_PAX_Confirmation_YVVM));
            simpleWheelPopup.setWheelData(bankDataModel.getTopFiveInStringList(1));
            simpleWheelPopup.setOnSelectListener(new SimpleWheelPopup.OnSelectListener() {
                public void onSelect(int i, Object obj) {
                    if (i == bankDataModel.topFive.size() - 1) {
                        PayEventPublisher.getPublisher().publish(PayEventKeys.FragmentForward.EVENT_FORWARD_TO_BANKLIST_TRANAMOUNT, bankDataModel);
                        return;
                    }
                    TransBankInfo transBankInfo = bankDataModel.topFive.get(simpleWheelPopup.getSelectedValue());
                    TransNewAccountFragment.this.f31415f.setText(String.valueOf(transBankInfo.name));
                    TransNewAccountFragment.this.f31420k.toBankCode = (String) transBankInfo.value;
                }
            });
            simpleWheelPopup.show(getFragmentManager(), "country_list_fragment");
        }
    }

    public void gotoFullBankList() {
        startActivityForResult(new Intent(), 1);
    }

    public void onGetAccountTypeList(TransBankAccountTypeResp.DataBean dataBean) {
        this.f31423n = dataBean.accountTypeList;
        if (dataBean.hitBankImprove) {
            this.f31412c.setMaxLength(14);
            this.f31414e.setMaxLength(17);
            this.f31412c.setLabel(getString(R.string.GRider_PAX_CPF_fMMn), "000.000.000-00");
            this.f31413d.setLabel(getString(R.string.GRider_PAX_Agency_code_IfjA), "0000");
            this.f31414e.setLabel(getString(R.string.GRider_PAX_Bank_accounts_JfbH), getString(R.string.Fintech_Payment_verification2_Fill_in_FYtt));
            this.f31415f.setLabel(getString(R.string.GRider_PAX_Name_of_mjpR), getString(R.string.Fintech_Payment_verification2_Select_Bank_jTYP));
            this.f31414e.addBankCardInputListener();
            this.f31412c.addCPFCardInputListener();
            this.f31412c.setLoseFocusListener(this.f31425p);
            this.f31413d.setLoseFocusListener(this.f31425p);
            this.f31414e.setLoseFocusListener(this.f31425p);
        }
        this.f31417h.setVisibility(0);
    }

    public void onShowPageLoadding() {
        notifyParentPageLoading(true);
    }

    public void onDismissPageLoadding() {
        notifyParentPageLoading(false);
    }
}
