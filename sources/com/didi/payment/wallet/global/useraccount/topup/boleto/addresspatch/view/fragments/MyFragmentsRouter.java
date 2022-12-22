package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.view.fragments;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.didi.payment.wallet.global.useraccount.constant.WalletConstants;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.adapter.ListItem;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.AddressFromZipCodeResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.ListFragmentExtraCity;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.ListFragmentExtraState;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.view.activities.WalletBoletoPatchAddressActivity;

public class MyFragmentsRouter implements FragmentManager.OnBackStackChangedListener {
    public static final String FRAGMENT_BACKSTACK_ADD_MANUALLY_ENTER_ADDRESS = "backstackAddManuallyEnterAddressPage";
    public static final String FRAGMENT_BACKSTACK_ADD_POST_CODE = "backstackAddCodeViewPage";
    public static final String FRAGMENT_BACKSTACK_BOLETO_ADDR_LIST = "backstackBoletoAddressList";
    public static final String FRAGMENT_TAG_BOLETO_ADDR_LIST = "boletoAddressList";
    public static final String FRAGMENT_TAG_MANUALLY_ENTER_ADDRESS = "manuallyEnterAddressView";
    public static final String FRAGMENT_TAG_ZIP_CODE = "postCodeView";
    public static final int REQUEST_CODE_CITY = 104;
    public static final int REQUEST_CODE_STATE = 103;

    /* renamed from: c */
    private static final int f31879c = 2131432213;

    /* renamed from: a */
    private Context f31880a;

    /* renamed from: b */
    private FragmentManager f31881b;

    public void onBackStackChanged() {
    }

    public MyFragmentsRouter(Context context) {
        this.f31880a = context;
        m22585a();
    }

    /* renamed from: a */
    private void m22585a() {
        FragmentManager supportFragmentManager = ((WalletBoletoPatchAddressActivity) this.f31880a).getSupportFragmentManager();
        this.f31881b = supportFragmentManager;
        supportFragmentManager.addOnBackStackChangedListener(this);
    }

    public void addZipCodeView() {
        WalletBoletoZipCodeFragment newInstance = WalletBoletoZipCodeFragment.newInstance();
        FragmentTransaction beginTransaction = this.f31881b.beginTransaction();
        beginTransaction.add(f31879c, newInstance, FRAGMENT_TAG_ZIP_CODE);
        beginTransaction.commit();
    }

    public void addAddressManuallyView(AddressFromZipCodeResp.DataBean dataBean) {
        WalletBoletoAddressFragment newInstance = WalletBoletoAddressFragment.newInstance(dataBean);
        FragmentTransaction beginTransaction = this.f31881b.beginTransaction();
        beginTransaction.replace(f31879c, newInstance, FRAGMENT_TAG_MANUALLY_ENTER_ADDRESS);
        beginTransaction.addToBackStack(FRAGMENT_BACKSTACK_ADD_MANUALLY_ENTER_ADDRESS);
        beginTransaction.commit();
    }

    public void showListFragmentForState(ListFragmentExtraState listFragmentExtraState, WalletBoletoAddressFragment walletBoletoAddressFragment) {
        WalletBoletoAddressListFragment newInstance = WalletBoletoAddressListFragment.newInstance(listFragmentExtraState);
        newInstance.setTargetFragment(walletBoletoAddressFragment, 103);
        FragmentTransaction beginTransaction = this.f31881b.beginTransaction();
        beginTransaction.replace(f31879c, newInstance, FRAGMENT_TAG_BOLETO_ADDR_LIST);
        beginTransaction.addToBackStack(FRAGMENT_BACKSTACK_BOLETO_ADDR_LIST);
        beginTransaction.commit();
    }

    public void showListFragmentForCity(ListFragmentExtraCity listFragmentExtraCity, WalletBoletoAddressFragment walletBoletoAddressFragment) {
        WalletBoletoAddressListFragment newInstance = WalletBoletoAddressListFragment.newInstance(listFragmentExtraCity);
        newInstance.setTargetFragment(walletBoletoAddressFragment, 104);
        FragmentTransaction beginTransaction = this.f31881b.beginTransaction();
        beginTransaction.replace(f31879c, newInstance, FRAGMENT_TAG_BOLETO_ADDR_LIST);
        beginTransaction.addToBackStack(FRAGMENT_BACKSTACK_BOLETO_ADDR_LIST);
        beginTransaction.commit();
    }

    public void popBackStackFromManager() {
        this.f31881b.popBackStackImmediate();
    }

    public void backtoAddressPatchFromStatePage(FragmentActivity fragmentActivity, ListItem listItem, WalletBoletoAddressListFragment walletBoletoAddressListFragment) {
        Intent intent = new Intent(fragmentActivity, WalletBoletoAddressListFragment.class);
        intent.putExtra(WalletConstants.KEY_INTENT_LIST_CALLBACK_KEY, listItem.getStateCode());
        walletBoletoAddressListFragment.getTargetFragment().onActivityResult(walletBoletoAddressListFragment.getTargetRequestCode(), -1, intent);
        fragmentActivity.onBackPressed();
    }

    public void backtoAddressPatchFromCityPage(FragmentActivity fragmentActivity, ListItem listItem, WalletBoletoAddressListFragment walletBoletoAddressListFragment) {
        Intent intent = new Intent(fragmentActivity, WalletBoletoAddressListFragment.class);
        intent.putExtra(WalletConstants.KEY_INTENT_LIST_CALLBACK_KEY, listItem.getDisplayContent());
        walletBoletoAddressListFragment.getTargetFragment().onActivityResult(walletBoletoAddressListFragment.getTargetRequestCode(), -1, intent);
        fragmentActivity.onBackPressed();
    }
}
