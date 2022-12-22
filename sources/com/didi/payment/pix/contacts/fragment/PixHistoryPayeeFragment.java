package com.didi.payment.pix.contacts.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.permission.PermissionCallback;
import com.didi.commoninterfacelib.permission.PermissionContext;
import com.didi.commoninterfacelib.permission.PermissionUtil;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.fragment.ContactPermissionFragment;
import com.didi.payment.commonsdk.p129ui.AbsWBaseFragment;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.commonsdk.p129ui.helper.NLEGODialogBuilder;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.pix.contacts.HistoryPayeeAdapter;
import com.didi.payment.pix.contacts.p134vm.HistoryContacksVM;
import com.didi.payment.pix.contacts.p134vm.model.PayeeItem;
import com.didi.payment.pix.net.response.HistoryPixPayeeResp;
import com.didi.payment.pix.net.response.PixKeyVerifyResp;
import com.didi.payment.pix.transfer.fragment.PixNewBankAccountFragment;
import com.didi.payment.pix.transfer.fragment.PixTransferAmountEditFragment;
import com.didi.payment.pix.transfer.p141vm.model.BankAccountMetaData;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.lang.invoke.SerializedLambda;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class PixHistoryPayeeFragment extends AbsWBaseFragment<HistoryContacksVM> {

    /* renamed from: a */
    private RecyclerView f31032a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public HistoryPayeeAdapter f31033b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TextView f31034c;

    /* renamed from: d */
    private TextView f31035d;

    /* renamed from: e */
    private View f31036e;

    /* renamed from: f */
    private View f31037f;

    /* renamed from: g */
    private View f31038g;

    /* renamed from: h */
    private List<HistoryPixPayeeResp.Payee> f31039h = null;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public LEGODrawer f31040i = null;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public PixKeyVerifyResp.PixAccount f31041j;
    protected AppCompatEditText mPixInputEt;

    /* renamed from: a */
    private static /* synthetic */ Object m21823a(SerializedLambda serializedLambda) {
        String implMethodName = serializedLambda.getImplMethodName();
        if (((implMethodName.hashCode() == -2060371867 && implMethodName.equals("lambda$pickUpContacts$3061c16$1")) ? (char) 0 : 65535) == 0 && serializedLambda.getImplMethodKind() == 7 && serializedLambda.getFunctionalInterfaceClass().equals("com/didi/commoninterfacelib/permission/PermissionCallback") && serializedLambda.getFunctionalInterfaceMethodName().equals("isAllGranted") && serializedLambda.getFunctionalInterfaceMethodSignature().equals("(Z[Ljava/lang/String;)V") && serializedLambda.getImplClass().equals("com/didi/payment/pix/contacts/fragment/PixHistoryPayeeFragment") && serializedLambda.getImplMethodSignature().equals("(Lcom/didi/payment/commonsdk/fragment/ContactPermissionFragment;Z[Ljava/lang/String;)V")) {
            return new Object((ContactPermissionFragment) serializedLambda.getCapturedArg(1)) {
                public final /* synthetic */ ContactPermissionFragment f$1;

                {
                    this.f$1 = r2;
                }

                public final void isAllGranted(boolean z, String[] strArr) {
                    PixHistoryPayeeFragment.this.m21826a(this.f$1, z, strArr);
                }
            };
        }
        throw new IllegalArgumentException("Invalid lambda deserialization");
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return super.getTitleBarView();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_pix_history_trans_contacts, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_sw");
        ((HistoryContacksVM) this.f30179vm).loadData();
    }

    public void onResume() {
        super.onResume();
    }

    public void initCommonTitlebar(CommonTitleBar commonTitleBar) {
        commonTitleBar.setTitle(getString(R.string.CS_payment_PIX_Transfer_Onrd));
        commonTitleBar.setLeftBackListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                PixHistoryPayeeFragment.this.backToPrePage();
            }
        });
        super.initCommonTitlebar(commonTitleBar);
    }

    public void initContentView(View view) {
        AppCompatEditText appCompatEditText = (AppCompatEditText) view.findViewById(R.id.pix_key_input_et);
        this.mPixInputEt = appCompatEditText;
        appCompatEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 3) {
                    return false;
                }
                InputMethodManager inputMethodManager = (InputMethodManager) PixHistoryPayeeFragment.this.getContext().getSystemService("input_method");
                if (inputMethodManager.isActive()) {
                    inputMethodManager.hideSoftInputFromWindow(textView.getWindowToken(), 0);
                }
                PixHistoryPayeeFragment.this.m21829a(String.valueOf(PixHistoryPayeeFragment.this.mPixInputEt.getText()));
                return true;
            }
        });
        this.mPixInputEt.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    PixHistoryPayeeFragment.this.f31034c.setEnabled(true);
                    PixHistoryPayeeFragment.this.f31034c.setTextColor(-16777216);
                    return;
                }
                PixHistoryPayeeFragment.this.f31034c.setEnabled(false);
                PixHistoryPayeeFragment.this.f31034c.setTextColor(-7829368);
            }
        });
        View findViewById = view.findViewById(R.id.pix_pickup_from_contact_img);
        this.f31037f = findViewById;
        findViewById.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_contact_ck");
                PixHistoryPayeeFragment.this.m21824a();
            }
        });
        TextView textView = (TextView) view.findViewById(R.id.pix_new_bank_account_tv);
        this.f31035d = textView;
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.wallet_title_text_color));
        String string = getString(R.string.CS_payment_Don_t_ZkYu);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.orange_didi)), string.indexOf("?") + 1, spannableStringBuilder.length(), 34);
        this.f31035d.setText(spannableStringBuilder);
        this.f31035d.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_search_bank_account_ck");
                PixHistoryPayeeFragment.this.forwardNextPage(PixNewBankAccountFragment.class);
            }
        });
        this.f31038g = view.findViewById(R.id.payee_list_container);
        View findViewById2 = view.findViewById(R.id.viewmore_tv);
        this.f31036e = findViewById2;
        findViewById2.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                PixHistoryPayeeFragment.this.m21824a();
            }
        });
        TextView textView2 = (TextView) view.findViewById(R.id.pix_confirm_transfer_btn_tv);
        this.f31034c = textView2;
        textView2.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                String valueOf = String.valueOf(PixHistoryPayeeFragment.this.mPixInputEt.getText());
                PixHistoryPayeeFragment.this.m21829a(valueOf);
                FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_confirm_key_ck", "pix_payee_key", valueOf);
            }
        });
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.pix_history_contacts_rcview);
        this.f31032a = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), 1);
        dividerItemDecoration.setDrawable(new ColorDrawable(Color.parseColor("#1f000000")));
        this.f31032a.addItemDecoration(dividerItemDecoration);
        HistoryPayeeAdapter historyPayeeAdapter = new HistoryPayeeAdapter(getContext(), new HistoryPayeeAdapter.ContactItemListener() {
            public void onContactItemClick(PayeeItem payeeItem) {
                if (!payeeItem.isCanExpand()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("source_page", "existing_payee");
                    PixKeyVerifyResp.PixAccount a = PixHistoryPayeeFragment.this.m21820a(payeeItem);
                    if (payeeItem.type == 5) {
                        bundle.putSerializable("bank_metadata", PixHistoryPayeeFragment.this.m21822a(payeeItem, true));
                        PixHistoryPayeeFragment.this.forwardNextPage(PixNewBankAccountFragment.class, bundle);
                        return;
                    } else if (!TextUtil.isEmpty(a.getKey())) {
                        FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_confirm_payee_ck", "pix_payee_key", a.getKey());
                        ((HistoryContacksVM) PixHistoryPayeeFragment.this.f30179vm).doublecheckPixKey(a.getKey());
                        return;
                    } else {
                        BankAccountMetaData a2 = PixHistoryPayeeFragment.this.m21822a(payeeItem, false);
                        if (a2.valid()) {
                            FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_confirm_payee_ck", "pix_payee_key", a2.cpf);
                            bundle.putSerializable("bank_metadata", a2);
                            PixHistoryPayeeFragment.this.forwardNextPage(PixTransferAmountEditFragment.class, bundle);
                            return;
                        }
                    }
                }
                if (payeeItem.displayStyle == 1) {
                    PixHistoryPayeeFragment.this.f31033b.foldGroupItem(payeeItem);
                } else {
                    PixHistoryPayeeFragment.this.f31033b.expandChildItems(payeeItem);
                }
            }

            public void onLastItemVisible() {
                ((HistoryContacksVM) PixHistoryPayeeFragment.this.f30179vm).loadTransContacts();
            }
        });
        this.f31033b = historyPayeeAdapter;
        this.f31032a.setAdapter(historyPayeeAdapter);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21829a(String str) {
        if (!TextUtil.isEmpty(str)) {
            ((HistoryContacksVM) this.f30179vm).checkPixKey(str.replace(" ", ""), false, false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21824a() {
        new ContactPermissionFragment.Builder().setClickListener("", new ContactPermissionFragment.OnClickListener() {
            public final void onClick(ContactPermissionFragment contactPermissionFragment) {
                PixHistoryPayeeFragment.this.m21825a(contactPermissionFragment);
            }
        }).create().show(requireActivity().getSupportFragmentManager(), "");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21825a(ContactPermissionFragment contactPermissionFragment) {
        FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_contact_access_allow_ck");
        PermissionUtil.checkAndRequestPermissions((PermissionContext) requireContext(), (PermissionCallback) new Object(contactPermissionFragment) {
            public final /* synthetic */ ContactPermissionFragment f$1;

            {
                this.f$1 = r2;
            }

            public final void isAllGranted(boolean z, String[] strArr) {
                PixHistoryPayeeFragment.this.m21826a(this.f$1, z, strArr);
            }
        }, new String[]{Permission.READ_CONTACTS}, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21826a(ContactPermissionFragment contactPermissionFragment, boolean z, String[] strArr) {
        contactPermissionFragment.dismiss();
        if (z) {
            forwardNextPage(CustomContactsFragment.class);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public PixKeyVerifyResp.PixAccount m21820a(PayeeItem payeeItem) {
        if (this.f31039h == null || payeeItem == null || TextUtil.isEmpty(payeeItem.key)) {
            return new PixKeyVerifyResp.PixAccount();
        }
        for (HistoryPixPayeeResp.Payee next : this.f31039h) {
            if (next.getKeyList() != null && next.getKeyList().size() > 0) {
                for (HistoryPixPayeeResp.KeyInfo key : next.getKeyList()) {
                    if (payeeItem.key.equals(key.getKey())) {
                        PixKeyVerifyResp.PixAccount pixAccount = new PixKeyVerifyResp.PixAccount();
                        pixAccount.setCpf(next.getCpf());
                        pixAccount.setName(next.getName());
                        pixAccount.icon = next.getIcon();
                        pixAccount.setKey(payeeItem.key);
                        PixKeyVerifyResp.PspInfo pspInfo = new PixKeyVerifyResp.PspInfo();
                        pspInfo.setId(payeeItem.pspId);
                        pspInfo.setName(payeeItem.pspName);
                        pixAccount.psp = pspInfo;
                        return pixAccount;
                    }
                }
                continue;
            }
        }
        return new PixKeyVerifyResp.PixAccount();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public BankAccountMetaData m21822a(PayeeItem payeeItem, boolean z) {
        List<HistoryPixPayeeResp.Payee> list = this.f31039h;
        if (list == null || payeeItem == null) {
            return new BankAccountMetaData();
        }
        for (HistoryPixPayeeResp.Payee next : list) {
            if (next.getKeyList() != null && next.getKeyList().size() > 0) {
                for (HistoryPixPayeeResp.KeyInfo next2 : next.getKeyList()) {
                    if (payeeItem.cardId.equals(next2.getCardId())) {
                        BankAccountMetaData bankAccountMetaData = new BankAccountMetaData();
                        if (!z || next2.getType().intValue() == 5) {
                            if (next2.getType().intValue() == 5) {
                                bankAccountMetaData.cpf = next.getCpf();
                                bankAccountMetaData.cpf4Display = "";
                            } else if (next2.getType().intValue() == 2) {
                                bankAccountMetaData.cpf4Display = next.getShowCpf();
                                bankAccountMetaData.cpf = next.getCpf();
                            }
                            bankAccountMetaData.payeeName = next.getName();
                            bankAccountMetaData.cardNo = next2.getCardId();
                            bankAccountMetaData.setShowCardId(next2.getShowCardId());
                            bankAccountMetaData.pspId = next2.getPspId();
                            bankAccountMetaData.pspName = next2.getPspName();
                            bankAccountMetaData.agency = next2.getOrgCode();
                            bankAccountMetaData.setAccountType(next2.getAccountType());
                            return bankAccountMetaData;
                        }
                    }
                }
                continue;
            }
        }
        return new BankAccountMetaData();
    }

    /* renamed from: b */
    private boolean m21833b() {
        return PermissionUtil.checkPermissionAllGranted((Context) getActivity(), Permission.READ_CONTACTS);
    }

    public void initViewModels() {
        this.f30179vm = (WBaseViewModel) new ViewModelProvider(this).get(HistoryContacksVM.class);
        subscribeUi((HistoryContacksVM) this.f30179vm);
        ((HistoryContacksVM) this.f30179vm).payeeListLD.observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                PixHistoryPayeeFragment.this.m21830a((List) obj);
            }
        });
        ((HistoryContacksVM) this.f30179vm).verifyPixAccount.observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                PixHistoryPayeeFragment.this.m21832b((PixKeyVerifyResp.PixKeyList) obj);
            }
        });
        ((HistoryContacksVM) this.f30179vm).doubleCheckPixAccount.observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                PixHistoryPayeeFragment.this.m21828a((PixKeyVerifyResp.PixKeyList) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21830a(List list) {
        boolean z = !CollectionUtil.isEmpty((Collection<?>) list);
        FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_bt", "pix_transfer_potential_transfer", String.valueOf(z ? 1 : 0));
        if (z) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                if (CollectionUtil.isEmpty((Collection<?>) this.f31039h)) {
                    this.f31039h = list;
                } else {
                    this.f31039h.addAll(list);
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.addAll(Arrays.asList(PayeeItem.convert((HistoryPixPayeeResp.Payee) it.next())));
                }
            }
            this.f31038g.setVisibility(0);
            this.f31033b.appendData(arrayList);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m21832b(PixKeyVerifyResp.PixKeyList pixKeyList) {
        if (pixKeyList != null) {
            if (!CollectionUtil.isEmpty((Collection<?>) pixKeyList.getKeyList()) || TextUtil.isEmpty(pixKeyList.getNotExistLabel())) {
                final List<PixKeyVerifyResp.PixAccount> keyList = pixKeyList.getKeyList();
                if (keyList.size() >= 2) {
                    this.f31040i = new NLEGODialogBuilder(getActivity()).title(getString(R.string.GRider_payment_The_friend_HuMJ)).confirmAction(keyList.get(0).dialogBtn, new DoubleCheckOnClickListener() {
                        public void doClick(View view) {
                            PixHistoryPayeeFragment.this.f31040i.dismiss();
                            PixKeyVerifyResp.PixAccount unused = PixHistoryPayeeFragment.this.f31041j = (PixKeyVerifyResp.PixAccount) keyList.get(0);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("pix_account", PixHistoryPayeeFragment.this.f31041j);
                            PixHistoryPayeeFragment.this.forwardNextPage(PixTransferAmountEditFragment.class, bundle);
                        }
                    }).negativeAction(keyList.get(1).dialogBtn, new DoubleCheckOnClickListener() {
                        public void doClick(View view) {
                            PixHistoryPayeeFragment.this.f31040i.dismiss();
                            PixKeyVerifyResp.PixAccount unused = PixHistoryPayeeFragment.this.f31041j = (PixKeyVerifyResp.PixAccount) keyList.get(1);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("pix_account", PixHistoryPayeeFragment.this.f31041j);
                            PixHistoryPayeeFragment.this.forwardNextPage(PixTransferAmountEditFragment.class, bundle);
                        }
                    }).subTitle(getString(R.string.GRider_payment_You_can_cGUL)).build(1).show();
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putSerializable("pix_account", pixKeyList.getKeyList().get(0));
                bundle.putString("source_page", "manual_input_key");
                forwardNextPage(PixTransferAmountEditFragment.class, bundle);
                return;
            }
            WalletToastNew.showFailedMsg(getContext(), !TextUtil.isEmpty(pixKeyList.getNotExistLabel()) ? pixKeyList.getNotExistLabel().replace("\n", " ") : "error");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21828a(PixKeyVerifyResp.PixKeyList pixKeyList) {
        if (pixKeyList != null) {
            if (!CollectionUtil.isEmpty((Collection<?>) pixKeyList.getKeyList()) || TextUtil.isEmpty(pixKeyList.getNotExistLabel())) {
                Bundle bundle = new Bundle();
                bundle.putString("source_page", "existing_payee");
                bundle.putSerializable("pix_account", pixKeyList.getKeyList().get(0));
                forwardNextPage(PixTransferAmountEditFragment.class, bundle);
                return;
            }
            WalletToastNew.showFailedMsg(getContext(), !TextUtil.isEmpty(pixKeyList.getNotExistLabel()) ? pixKeyList.getNotExistLabel().replace("\n", " ") : "error");
        }
    }
}
