package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.view.fragments.WalletBoletoAddressListFragment;
import com.taxis99.R;
import java.util.List;

public class MyBoletoAddressListItemAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a */
    private final List<ListItem> f31857a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final WalletBoletoAddressListFragment.OnListFragmentInteractionListener f31858b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletBoletoAddressListFragment f31859c;

    public MyBoletoAddressListItemAdapter(List<ListItem> list, WalletBoletoAddressListFragment.OnListFragmentInteractionListener onListFragmentInteractionListener, WalletBoletoAddressListFragment walletBoletoAddressListFragment) {
        this.f31857a = list;
        this.f31858b = onListFragmentInteractionListener;
        this.f31859c = walletBoletoAddressListFragment;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_statecityitem, viewGroup, false));
    }

    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        viewHolder.mItem = this.f31857a.get(i);
        viewHolder.mContentView.setText(this.f31857a.get(i).getDisplayContent());
        viewHolder.mView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (MyBoletoAddressListItemAdapter.this.f31858b == null) {
                    return;
                }
                if (viewHolder.mItem.getStateOrCity().equals("state")) {
                    MyBoletoAddressListItemAdapter.this.f31858b.onListFragmentStateInteraction(viewHolder.mItem, MyBoletoAddressListItemAdapter.this.f31859c);
                } else if (viewHolder.mItem.getStateOrCity().equals("city")) {
                    MyBoletoAddressListItemAdapter.this.f31858b.onListFragmentCityInteraction(viewHolder.mItem, MyBoletoAddressListItemAdapter.this.f31859c);
                }
            }
        });
    }

    public void refresh(List<ListItem> list) {
        if (list != null) {
            this.f31857a.clear();
            this.f31857a.addAll(list);
            notifyDataSetChanged();
        }
    }

    public int getItemCount() {
        return this.f31857a.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mContentView;
        public ListItem mItem;
        public final View mView;

        public ViewHolder(View view) {
            super(view);
            this.mView = view;
            this.mContentView = (TextView) view.findViewById(R.id.content);
        }

        public String toString() {
            return super.toString() + " '" + this.mContentView.getText() + "'";
        }
    }
}
