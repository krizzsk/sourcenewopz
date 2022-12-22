package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.view.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.adapter.ListItem;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.ListFragmentExtraCity;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.ListFragmentExtraState;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.view.fragments.WalletBoletoAddressListFragment;
import com.didi.payment.wallet.global.wallet.view.activity.WalletBaseActivity;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\r\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/useraccount/topup/boleto/addresspatch/view/activities/WalletAddressListActivity;", "Lcom/didi/payment/wallet/global/wallet/view/activity/WalletBaseActivity;", "Lcom/didi/payment/wallet/global/useraccount/topup/boleto/addresspatch/view/fragments/WalletBoletoAddressListFragment$OnListFragmentInteractionListener;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onListFragmentCityInteraction", "item", "Lcom/didi/payment/wallet/global/useraccount/topup/boleto/addresspatch/adapter/ListItem;", "listItemFragment", "Lcom/didi/payment/wallet/global/useraccount/topup/boleto/addresspatch/view/fragments/WalletBoletoAddressListFragment;", "onListFragmentStateInteraction", "Companion", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletAddressListActivity.kt */
public final class WalletAddressListActivity extends WalletBaseActivity implements WalletBoletoAddressListFragment.OnListFragmentInteractionListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FRAGMENT_TAG_ADDRESS_LIST = "address_list";
    public static final String RESULT = "result";

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/useraccount/topup/boleto/addresspatch/view/activities/WalletAddressListActivity$Companion;", "", "()V", "FRAGMENT_TAG_ADDRESS_LIST", "", "RESULT", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: WalletAddressListActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String stringExtra;
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_global_activity_boleto_cashin_patch_address);
        Intent intent = getIntent();
        String str = "";
        if (!(intent == null || (stringExtra = intent.getStringExtra("type")) == null)) {
            str = stringExtra;
        }
        int hashCode = str.hashCode();
        if (hashCode != 3053931) {
            if (hashCode == 109757585 && str.equals("state")) {
                getSupportFragmentManager().beginTransaction().add(R.id.ll_boleto_addr_patch_fragment_contrainer, WalletBoletoAddressListFragment.newInstance(new ListFragmentExtraState("BR")), FRAGMENT_TAG_ADDRESS_LIST).commitAllowingStateLoss();
                return;
            }
        } else if (str.equals("city")) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Intent intent2 = getIntent();
            beginTransaction.add(R.id.ll_boleto_addr_patch_fragment_contrainer, WalletBoletoAddressListFragment.newInstance(new ListFragmentExtraCity("BR", intent2 == null ? null : intent2.getStringExtra("state"))), FRAGMENT_TAG_ADDRESS_LIST).commitAllowingStateLoss();
            return;
        }
        finish();
    }

    public void onListFragmentStateInteraction(ListItem listItem, WalletBoletoAddressListFragment walletBoletoAddressListFragment) {
        setResult(-1, new Intent().putExtra("result", listItem == null ? null : listItem.getStateCode()));
        finish();
    }

    public void onListFragmentCityInteraction(ListItem listItem, WalletBoletoAddressListFragment walletBoletoAddressListFragment) {
        setResult(-1, new Intent().putExtra("result", listItem == null ? null : listItem.getDisplayContent()));
        finish();
    }
}
