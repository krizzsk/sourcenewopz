package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.adapter.ListItem;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.adapter.MyBoletoAddressListItemAdapter;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.contract.WalletBoletoAddressListContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.AddressListStateResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.ListFragmentExtraCity;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.ListFragmentExtraState;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.presenter.WalletBoletoAddressListPresenter;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.widget.sidebar.OnSideBarTouchListener;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.widget.sidebar.SideBar;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.widget.sidebar.SortUtil;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class WalletBoletoAddressListFragment extends Fragment implements WalletBoletoAddressListContract.View {

    /* renamed from: b */
    private static final String f31897b = "state-or-city";

    /* renamed from: c */
    private static final String f31898c = "state";

    /* renamed from: d */
    private static final String f31899d = "city";

    /* renamed from: a */
    SideBar f31900a;

    /* renamed from: e */
    private String f31901e;

    /* renamed from: f */
    private ListFragmentExtraState f31902f;

    /* renamed from: g */
    private ListFragmentExtraCity f31903g;

    /* renamed from: h */
    private LinearLayout f31904h;

    /* renamed from: i */
    private RecyclerView f31905i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public LinearLayoutManager f31906j;

    /* renamed from: k */
    private MyBoletoAddressListItemAdapter f31907k;

    /* renamed from: l */
    private OnListFragmentInteractionListener f31908l;

    /* renamed from: m */
    private WalletLoadingContract f31909m;

    /* renamed from: n */
    private WalletBoletoAddressListContract.Presenter f31910n;

    public interface OnListFragmentInteractionListener {
        void onListFragmentCityInteraction(ListItem listItem, WalletBoletoAddressListFragment walletBoletoAddressListFragment);

        void onListFragmentStateInteraction(ListItem listItem, WalletBoletoAddressListFragment walletBoletoAddressListFragment);
    }

    public static WalletBoletoAddressListFragment newInstance(ListFragmentExtraState listFragmentExtraState) {
        WalletBoletoAddressListFragment walletBoletoAddressListFragment = new WalletBoletoAddressListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(f31897b, "state");
        bundle.putSerializable("state", listFragmentExtraState);
        walletBoletoAddressListFragment.setArguments(bundle);
        return walletBoletoAddressListFragment;
    }

    public static WalletBoletoAddressListFragment newInstance(ListFragmentExtraCity listFragmentExtraCity) {
        WalletBoletoAddressListFragment walletBoletoAddressListFragment = new WalletBoletoAddressListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(f31897b, "city");
        bundle.putSerializable("city", listFragmentExtraCity);
        walletBoletoAddressListFragment.setArguments(bundle);
        return walletBoletoAddressListFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            String string = getArguments().getString(f31897b);
            this.f31901e = string;
            if ("city".equals(string)) {
                this.f31903g = (ListFragmentExtraCity) getArguments().getSerializable("city");
            } else if ("state".equals(this.f31901e)) {
                this.f31902f = (ListFragmentExtraState) getArguments().getSerializable("state");
            }
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m22595a();
    }

    /* renamed from: a */
    private void m22595a() {
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_statecityitem_list, viewGroup, false);
        m22596a(inflate);
        m22598c();
        this.f31910n = new WalletBoletoAddressListPresenter(getActivity(), this, this.f31909m);
        m22597b();
        return inflate;
    }

    /* renamed from: b */
    private void m22597b() {
        if (this.f31901e.equals("state")) {
            this.f31910n.requestStates(this.f31902f);
        } else if (this.f31901e.equals("city")) {
            this.f31910n.requestCities(this.f31903g);
        }
    }

    /* renamed from: a */
    private void m22596a(View view) {
        this.f31905i = (RecyclerView) view.findViewById(R.id.rv_address_list);
        this.f31904h = (LinearLayout) view.findViewById(R.id.ll_addr_list_empty);
        this.f31900a = (SideBar) view.findViewById(R.id.side_bar_state_city);
    }

    /* renamed from: c */
    private void m22598c() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        this.f31906j = linearLayoutManager;
        this.f31905i.setLayoutManager(linearLayoutManager);
        this.f31905i.setLayoutManager(this.f31906j);
        ArrayList arrayList = new ArrayList();
        this.f31900a.setOnSideBarTouchListener(SortUtil.getGroups(arrayList), new OnSideBarTouchListener() {
            public void onTouchEnd() {
            }

            public void onTouch(String str, int i) {
                if (i != -1) {
                    WalletBoletoAddressListFragment.this.f31906j.scrollToPositionWithOffset(i, 0);
                }
            }
        });
        MyBoletoAddressListItemAdapter myBoletoAddressListItemAdapter = new MyBoletoAddressListItemAdapter(arrayList, this.f31908l, this);
        this.f31907k = myBoletoAddressListItemAdapter;
        this.f31905i.setAdapter(myBoletoAddressListItemAdapter);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            this.f31908l = (OnListFragmentInteractionListener) context;
            if (context instanceof WalletLoadingContract) {
                this.f31909m = (WalletLoadingContract) context;
                return;
            }
            throw new RuntimeException(context.toString() + " must implement WalletLoadingContract");
        }
        throw new RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener");
    }

    public void onDetach() {
        super.onDetach();
        this.f31908l = null;
        this.f31909m = null;
    }

    public void onStatesSuccessful(List<AddressListStateResp.StateBean> list) {
        ArrayList arrayList = new ArrayList();
        for (AddressListStateResp.StateBean next : list) {
            arrayList.add(new ListItem("state", next.stateName, next.stateCode));
        }
        SortUtil.sort(arrayList);
        this.f31900a.setOnSideBarTouchListener(SortUtil.getGroups(arrayList), new OnSideBarTouchListener() {
            public void onTouchEnd() {
            }

            public void onTouch(String str, int i) {
                if (i != -1) {
                    WalletBoletoAddressListFragment.this.f31906j.scrollToPositionWithOffset(i, 0);
                }
            }
        });
        this.f31907k.refresh(arrayList);
    }

    public void onCitiesSuccessful(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String listItem : list) {
            arrayList.add(new ListItem("city", listItem, (String) null));
        }
        SortUtil.sort(arrayList);
        this.f31900a.setOnSideBarTouchListener(SortUtil.getGroups(arrayList), new OnSideBarTouchListener() {
            public void onTouchEnd() {
            }

            public void onTouch(String str, int i) {
                if (i != -1) {
                    WalletBoletoAddressListFragment.this.f31906j.scrollToPositionWithOffset(i, 0);
                }
            }
        });
        this.f31907k.refresh(arrayList);
    }

    public void onNetworkError() {
        this.f31905i.setVisibility(8);
        this.f31900a.setVisibility(8);
        this.f31904h.setVisibility(0);
    }
}
