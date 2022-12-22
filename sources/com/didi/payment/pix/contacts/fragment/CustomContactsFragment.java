package com.didi.payment.pix.contacts.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.commonsdk.p129ui.AbsWBaseFragment;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.commonsdk.p129ui.helper.NLEGODialogBuilder;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.pix.contacts.fragment.adapter.PhoneContactsAdapter;
import com.didi.payment.pix.contacts.p134vm.CustomContactsVM;
import com.didi.payment.pix.contacts.p134vm.model.PhoneContacts;
import com.didi.payment.pix.net.response.PixKeyVerifyResp;
import com.didi.payment.pix.transfer.fragment.PixTransferAmountEditFragment;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\bH\u0016J\b\u0010&\u001a\u00020!H\u0016J\b\u0010'\u001a\u00020\u001fH\u0016J\u0010\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020*H\u0016J&\u0010+\u001a\u0004\u0018\u00010\b2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020!H\u0016J\u001a\u00103\u001a\u00020!2\u0006\u0010%\u001a\u00020\b2\b\u00100\u001a\u0004\u0018\u000101H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00064"}, mo175978d2 = {"Lcom/didi/payment/pix/contacts/fragment/CustomContactsFragment;", "Lcom/didi/payment/commonsdk/ui/AbsWBaseFragment;", "Lcom/didi/payment/pix/contacts/vm/CustomContactsVM;", "Lcom/didi/payment/pix/contacts/fragment/adapter/PhoneContactsAdapter$OnItemClickListener;", "()V", "adapter", "Lcom/didi/payment/pix/contacts/fragment/adapter/PhoneContactsAdapter;", "clearImg", "Landroid/view/View;", "contactLV", "Landroidx/recyclerview/widget/RecyclerView;", "getContactLV", "()Landroidx/recyclerview/widget/RecyclerView;", "setContactLV", "(Landroidx/recyclerview/widget/RecyclerView;)V", "drawer", "Lcom/didi/global/globaluikit/drawer/LEGODrawer;", "logger", "Lcom/didi/sdk/logging/Logger;", "getLogger", "()Lcom/didi/sdk/logging/Logger;", "setLogger", "(Lcom/didi/sdk/logging/Logger;)V", "mTitleBar", "nameInputEt", "Landroid/widget/EditText;", "getNameInputEt", "()Landroid/widget/EditText;", "setNameInputEt", "(Landroid/widget/EditText;)V", "customErrorUI", "", "initCommonTitlebar", "", "commonTitleBar", "Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "initContentView", "view", "initViewModels", "onBackKeyPressed", "onContactClicked", "contacts", "Lcom/didi/payment/pix/contacts/vm/model/PhoneContacts;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomContactsFragment.kt */
public final class CustomContactsFragment extends AbsWBaseFragment<CustomContactsVM> implements PhoneContactsAdapter.OnItemClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public LEGODrawer f31027a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f31028b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public PhoneContactsAdapter f31029c;
    public RecyclerView contactLV;

    /* renamed from: d */
    private View f31030d;

    /* renamed from: e */
    private Logger f31031e;
    public EditText nameInputEt;

    public CustomContactsFragment() {
        Logger logger = LoggerFactory.getLogger("CustomContactsFgm");
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(\"CustomContactsFgm\")");
        this.f31031e = logger;
    }

    public final EditText getNameInputEt() {
        EditText editText = this.nameInputEt;
        if (editText != null) {
            return editText;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nameInputEt");
        return null;
    }

    public final void setNameInputEt(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<set-?>");
        this.nameInputEt = editText;
    }

    public final RecyclerView getContactLV() {
        RecyclerView recyclerView = this.contactLV;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("contactLV");
        return null;
    }

    public final void setContactLV(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.contactLV = recyclerView;
    }

    public final Logger getLogger() {
        return this.f31031e;
    }

    public final void setLogger(Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "<set-?>");
        this.f31031e = logger;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_custom_contacts, viewGroup, false);
    }

    public void initCommonTitlebar(CommonTitleBar commonTitleBar) {
        Intrinsics.checkNotNullParameter(commonTitleBar, "commonTitleBar");
        commonTitleBar.setTitle(getString(R.string.CS_payment_Choose_friends_KwfK));
        commonTitleBar.setLeftBackListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CustomContactsFragment.m21814a(CustomContactsFragment.this, view);
            }
        });
        super.initCommonTitlebar(commonTitleBar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21814a(CustomContactsFragment customContactsFragment, View view) {
        Intrinsics.checkNotNullParameter(customContactsFragment, "this$0");
        customContactsFragment.backToPrePage();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_contact_sw");
    }

    public void initViewModels() {
        ViewModel viewModel = new ViewModelProvider(this).get(CustomContactsVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…omContactsVM::class.java)");
        setVm((WBaseViewModel) viewModel);
        subscribeUi(getVm());
        ((CustomContactsVM) getVm()).getContactsLD().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                CustomContactsFragment.m21816a(CustomContactsFragment.this, (List) obj);
            }
        });
        ((CustomContactsVM) getVm()).getPhoneNumPixLD().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                CustomContactsFragment.m21815a(CustomContactsFragment.this, (PixKeyVerifyResp.PixKeyList) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21816a(CustomContactsFragment customContactsFragment, List list) {
        Intrinsics.checkNotNullParameter(customContactsFragment, "this$0");
        if (list != null) {
            Collections.sort(list);
            List arrayList = new ArrayList();
            Iterator it = list.iterator();
            String str = "";
            while (it.hasNext()) {
                PhoneContacts phoneContacts = (PhoneContacts) it.next();
                if (phoneContacts.isValid()) {
                    String name = phoneContacts.getName();
                    if (name != null) {
                        String substring = name.substring(0, 1);
                        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        if (!Intrinsics.areEqual((Object) str, (Object) substring)) {
                            arrayList.add(new PhoneContacts(substring, ""));
                            phoneContacts.setFirstInGroup(true);
                            str = substring;
                        }
                        arrayList.add(phoneContacts);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                }
            }
            PhoneContactsAdapter phoneContactsAdapter = customContactsFragment.f31029c;
            PhoneContactsAdapter phoneContactsAdapter2 = null;
            if (phoneContactsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                phoneContactsAdapter = null;
            }
            phoneContactsAdapter.setContactList(arrayList);
            PhoneContactsAdapter phoneContactsAdapter3 = customContactsFragment.f31029c;
            if (phoneContactsAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                phoneContactsAdapter2 = phoneContactsAdapter3;
            }
            phoneContactsAdapter2.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21815a(CustomContactsFragment customContactsFragment, PixKeyVerifyResp.PixKeyList pixKeyList) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(customContactsFragment, "this$0");
        if (pixKeyList != null && (activity = customContactsFragment.getActivity()) != null) {
            String str = null;
            if (!TextUtils.isEmpty(pixKeyList.getNotExistLabel())) {
                FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_contact_choose_payee_fail_sw");
                NLEGODialogBuilder nLEGODialogBuilder = new NLEGODialogBuilder(activity);
                String string = customContactsFragment.getString(R.string.GRider_payment_The_friend_HuMJ);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.GRider_payment_The_friend_HuMJ)");
                NLEGODialogBuilder title = nLEGODialogBuilder.title(string);
                String string2 = customContactsFragment.getString(R.string.GRider_payment_I_see_YaKc);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.GRider_payment_I_see_YaKc)");
                NLEGODialogBuilder confirmAction = title.confirmAction(string2, new CustomContactsFragment$initViewModels$2$1$1$1(customContactsFragment));
                String string3 = customContactsFragment.getString(R.string.GRider_payment_You_can_cGUL);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.GRider_payment_You_can_cGUL)");
                customContactsFragment.f31027a = NLEGODialogBuilder.build$default(confirmAction.subTitle(string3), 0, 1, (Object) null).show();
            } else if (!CollectionUtil.isEmpty((Collection<?>) pixKeyList.getKeyList())) {
                List<PixKeyVerifyResp.PixAccount> keyList = pixKeyList.getKeyList();
                PixKeyVerifyResp.PixAccount pixAccount = keyList == null ? null : keyList.get(0);
                if (pixAccount != null) {
                    str = pixAccount.getKey();
                }
                FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_contact_choose_payee_api_success_bt", "pix_payee_key", str);
                Bundle bundle = new Bundle();
                bundle.putSerializable("pix_account", pixAccount);
                bundle.putString("source_page", "contact_search");
                customContactsFragment.forwardNextPage(PixTransferAmountEditFragment.class, bundle);
            }
        }
    }

    public boolean customErrorUI() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            WalletToastNew.showFailedMsg(activity, "retry again");
        }
        return super.customErrorUI();
    }

    public void initContentView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.user_input_keyword_et);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.user_input_keyword_et)");
        setNameInputEt((EditText) findViewById);
        View findViewById2 = view.findViewById(R.id.clear_input);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.clear_input)");
        this.f31028b = findViewById2;
        getNameInputEt().addTextChangedListener(new CustomContactsFragment$initContentView$1(this));
        View view2 = this.f31028b;
        PhoneContactsAdapter phoneContactsAdapter = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearImg");
            view2 = null;
        }
        view2.setOnClickListener(new CustomContactsFragment$initContentView$2(this));
        View findViewById3 = view.findViewById(R.id.custom_contacts_recyclerview);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.c…om_contacts_recyclerview)");
        setContactLV((RecyclerView) findViewById3);
        getContactLV().setLayoutManager(new LinearLayoutManager(getActivity()));
        PhoneContactsAdapter phoneContactsAdapter2 = new PhoneContactsAdapter();
        this.f31029c = phoneContactsAdapter2;
        if (phoneContactsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            phoneContactsAdapter2 = null;
        }
        phoneContactsAdapter2.setOnItemClickListener(this);
        RecyclerView contactLV2 = getContactLV();
        PhoneContactsAdapter phoneContactsAdapter3 = this.f31029c;
        if (phoneContactsAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            phoneContactsAdapter = phoneContactsAdapter3;
        }
        contactLV2.setAdapter(phoneContactsAdapter);
        View findViewById4 = view.findViewById(R.id.custom_contacts_titlebar);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.custom_contacts_titlebar)");
        this.f31030d = findViewById4;
    }

    public void onContactClicked(PhoneContacts phoneContacts) {
        Intrinsics.checkNotNullParameter(phoneContacts, InvitationPageActivity.CONTACTS);
        FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_contact_choose_payee_ck");
        String replace$default = StringsKt.replace$default(StringsKt.replace$default(phoneContacts.getPhoneNum(), " ", "", false, 4, (Object) null), "-", "", false, 4, (Object) null);
        if (StringsKt.indexOf$default((CharSequence) replace$default, "+55", 0, false, 6, (Object) null) < 0) {
            replace$default = Intrinsics.stringPlus("+55", replace$default);
        }
        ((CustomContactsVM) getVm()).checkPhoneNum(replace$default);
    }

    public void onResume() {
        super.onResume();
        Context context = getContext();
        if (context != null) {
            ((CustomContactsVM) getVm()).loadContacts(context);
        }
    }

    public boolean onBackKeyPressed() {
        return super.onBackKeyPressed();
    }
}
